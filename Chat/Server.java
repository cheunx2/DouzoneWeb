package Pack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Broadcast{
	HashMap<Socket, String> hashmap=null;
	Iterator<Socket> itkey=null;
	Iterator<String> itvalue=null;
	Socket key=null;
	String value=null;
	String FLAG="a";
	
	public Broadcast(HashMap<Socket, String> hashmap) {
		this.hashmap=hashmap;
		this.itkey = hashmap.keySet().iterator();
		this.itvalue = hashmap.values().iterator();
	}
	
	void loginCehckSend(TextArea currentMem) {
		String text=currentMem.getText();
		while(itkey.hasNext()) {
			key=itkey.next();
			value=itvalue.next();
			try {
				OutputStream outputstream = key.getOutputStream();
				byte[] data = (FLAG+text).getBytes(); // String을 byte로 바꿈
				outputstream.write(data);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	void send(String s) {
		Socket key=null;
		while(itkey.hasNext()) {
			key=itkey.next();
			try {
				OutputStream outputstream = key.getOutputStream();
				byte[] data1 = s.getBytes(); // String을 byte로 바꿈
				outputstream.write(data1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class IOThread extends Thread{ // 읽는 처리를 하는 스레드
//	Socket socket=new Socket();
	HashMap<Socket, String> hashmap;
	Socket socket;
	TextArea teatarea1;
	TextArea currentMem;
	
	public IOThread(HashMap<Socket, String> hashmap, Socket socket,TextArea teatarea1, TextArea currentMem) {
		this.hashmap=hashmap;
		this.socket=socket;
		this.teatarea1=teatarea1;
		this.currentMem=currentMem;
	}
	
	public void run() { // 데이터를 읽는 작업
		try {
			InputStream inputstream = socket.getInputStream(); // 통신 소켓 ss가 우리한테 없다.
			
			while(true) {
				byte[] data = new byte[512]; // 512byte로
				System.out.println("지금 작동 중임");
				int size = inputstream.read(data);// ---> blocking 된다.----------------------------
				
				
				
				String s = new String(data, 0, size);
				char check = s.charAt(0);
				String value = null;
				String temp = s.substring(1);
				System.out.println(temp);
				Socket key=null;
				if (check == 'b') {
					Iterator<String> itvalue = hashmap.values().iterator();
					Iterator<Socket> itkey = hashmap.keySet().iterator();
					while(itvalue.hasNext()) {
						value = itvalue.next();
						key = itkey.next();
						if (value == temp) {
							hashmap.remove(key);
							try {
								byte[] data1 = (s+"님이 나갔습니다.").getBytes(); // String을 byte로 바꿈
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;
						}
					}
					
					Iterator<String> itvalue1 = hashmap.values().iterator();
					value = null;
					while(itvalue1.hasNext()) {
						value = itvalue1.next();
						try {
							currentMem.setText(value+"님이 접속중\n");
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					new Broadcast(hashmap).loginCehckSend(currentMem);
				}else {
					teatarea1.appendText(s + "\n");
					new Broadcast(hashmap).send(s);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class ConnectThread extends Thread{ // 접속만 하는 스레드
	Server server; // hash 사용하기 위해서
	HashMap<Socket, String> hashmap;
	TextArea teatarea1;
	TextArea currentMem;
	public ConnectThread(HashMap<Socket, String> hashmap, TextArea teatarea1, TextArea currentMem) {
		this.hashmap=hashmap;
		this.teatarea1=teatarea1;
		this.currentMem=currentMem;
	}
	public void run(){
		try {
			//서버 메인 소켓
			ServerSocket mss = new ServerSocket();		
			System.out.println("메인 서버 소켓 생성");
			
//			mss.bind(new InetSocketAddress("localhost", 5001));  //바인딩
			mss.bind(new InetSocketAddress(InetAddress.getLocalHost(), 5001));  //바인딩
			System.out.println("바인딩 완료\n");
			
			while(true) {
				Socket ss = mss.accept();
				InputStream inputstream = ss.getInputStream();
				byte[] data = new byte[512];
				int size = inputstream.read(data); // 이름 받음
				String name = new String(data, 0, size);

				synchronized(hashmap) {
					hashmap.put(ss, name);
					System.out.println("현재 "+hashmap.size()+"명 접속하였습니다.");
					new IOThread(hashmap, ss, teatarea1, currentMem).start();
				}
				
				// 들어온거 브로드캐스팅 및 출력
				System.out.println(name+"님 들어오셨습니다");
				currentMem.appendText(name+"님 접속 중\n");
				new Broadcast(hashmap).loginCehckSend(currentMem);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Server extends Application  {
    Stage window;
    Scene scene;
    Button button;
    String Sname;
    
    static HashMap<Socket, String> hashmap;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Server");
        //------------------------------------------------------------------------------------
        HBox topMenu = new HBox();
        Label labelName = new Label("이름 : ");
		TextField name = new TextField();
		Button connectBnt = new Button("접속");
		topMenu.setSpacing(15);
		Label labelIP = new Label("IP"+InetAddress.getLocalHost());
		topMenu.getChildren().addAll(labelName, name, connectBnt, labelIP);
        
        HBox centerMenu = new HBox();
		TextArea textarea1 = new TextArea();
		textarea1.setMaxSize(600, 500);
		centerMenu.setSpacing(10);
		TextArea currentMem = new TextArea();
		currentMem.setMaxSize(210, 500);
		centerMenu.getChildren().addAll(textarea1, currentMem);
		
		HBox bottomMenu = new HBox();
		TextField talkBox = new TextField();
		talkBox.setPrefSize(535, 100);
		bottomMenu.setSpacing(100);
		Button sendBnt = new Button("보내기");
		sendBnt.setPrefSize(100, 100);
		bottomMenu.setSpacing(10);
		Button exitBnt = new Button("나가기");
		exitBnt.setPrefSize(100, 100);
		bottomMenu.getChildren().addAll(talkBox, sendBnt, exitBnt);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerMenu);
        borderPane.setBottom(bottomMenu);
        
        //-----------------------------------------------------------------------------------
        connectBnt.setOnAction(new EventHandler<ActionEvent>() { //버튼 클릭 했을때의 이벤트
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("서버 오픈");
				Sname = name.getText(); // 작성한 텍스트를 가져올 수 있는 함수
				currentMem.appendText(Sname+"님 접속 중\n"); // 기존 데이터 + 새로운 데이터를 추가하는 개념의 함수
				hashmap=new HashMap<Socket, String>();
				new ConnectThread(hashmap, textarea1, currentMem).start();
			}
		});
        
        sendBnt.setOnAction(new EventHandler<ActionEvent>() { //버튼 클릭 했을때의 이벤트
			@Override
			public void handle(ActionEvent arg0) {
				String s = talkBox.getText(); // 작성한 텍스트를 가져올 수 있는 함수
				textarea1.appendText("["+Sname+"] : "+s+"\n"); // 기존 데이터 + 새로운 데이터를 추가하는 개념의 함수
				talkBox.setText(" ");
				Iterator<Socket> it = hashmap.keySet().iterator();
				Socket key=null;
				while(it.hasNext()) {
					key=it.next();
					try {
						OutputStream outputstream = key.getOutputStream();
						byte[] data1 = ("["+Sname+"] : "+s).getBytes(); // String을 byte로 바꿈
						outputstream.write(data1);
						System.out.println("데이터 보냄");
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});
        
        //---------------------------------------------------------------------------------
        scene = new Scene(borderPane, 770, 650);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}