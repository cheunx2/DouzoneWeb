package Pack;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
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
import javafx.stage.Stage;

class ListeningThread extends Thread { // 서버에서 보낸 메세지 읽는 Thread
	Socket cs;
	TextArea textarea1;
	TextArea textarea2;

	public ListeningThread(Socket cs,TextArea textarea1,TextArea textarea2) { // 생성자
		this.cs = cs; // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
		this.textarea1 = textarea1;
		this.textarea2 = textarea2;
	}
	
	public void run() {
		try {
			InputStream inputstream = cs.getInputStream(); // 통신 소켓 ss가 우리한테 없다.
			while(true) {
				byte[] data = new byte[512]; // 512byte로
				System.out.println("지금 작동 중임");
				int size = inputstream.read(data);// ---> blocking 된다.----------------------------
				String s = new String(data, 0, size);
				System.out.println(s+"데이터 받음"); // 종료하지 않고 계속 받곘다.
				char check = s.charAt(0);
				if(check == 'a') {
					textarea2.clear();
					textarea2.appendText(s.substring(1) + "\n");
				} else {
					textarea1.appendText(s + "\n");
				}
			}
		} catch (Exception e) {
			System.out.println("종료");
			e.printStackTrace();
		} 
	}
}

public class Client extends Application  {
	 
    Stage window;
    Scene scene;
    Button button;
    Socket cs = new Socket();
    String name;
 
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Client");
 
        HBox leftMenu = new HBox();
        Label label2 = new Label("이름 : "); // 라벨을 만들기 위해
		TextField textfield = new TextField();
		Button connectBnt = new Button("접속");
        leftMenu.getChildren().addAll(label2, textfield, connectBnt);
        
        HBox centerMenu = new HBox();
		TextArea textarea1 = new TextArea();
		textarea1.setMaxSize(600, 500);
		TextArea textarea2 = new TextArea();
		textarea2.setMaxSize(300, 500);
		centerMenu.getChildren().addAll(textarea1, textarea2);
		
		HBox leftMenu3 = new HBox();
		TextField textfield1 = new TextField();
		textfield1.setPrefSize(600, 100);
		Button sendBnt = new Button("보내기");
		sendBnt.setPrefSize(100, 100);
		Button exitBnt = new Button("나가기");
		exitBnt.setPrefSize(100, 100);
		leftMenu3.getChildren().addAll(textfield1, sendBnt, exitBnt);
		
		connectBnt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					cs.connect(new InetSocketAddress("115.22.11.76",5001));
					OutputStream outputStream = cs.getOutputStream();
					String s = textfield.getText();
					name = textfield.getText();
					byte[] data = s.getBytes();
					outputStream.write(data);
					System.out.println(textfield.getText() + "접속완료");
					new ListeningThread(cs,textarea1,textarea2).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		sendBnt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream outputStream = cs.getOutputStream();
					String s = "["+name + "] : " + textfield1.getText();
					byte[] data = s.getBytes();
					outputStream.write(data);
					System.out.println(textfield1.getText() + "전송완료");
					textfield1.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		exitBnt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream outputStream = cs.getOutputStream();
					String s = "b"+name;
					byte[] data = s.getBytes();
					outputStream.write(data);
//					new ListeningThread(cs, textarea2, textarea2).interrupt();
					outputStream.close();
					cs.close();
					window.close();
//					launch(arg0).close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(leftMenu);
        borderPane.setCenter(centerMenu);
        borderPane.setBottom(leftMenu3);
 
        scene = new Scene(borderPane, 850, 650);
        window.setScene(scene);
        window.show();
    }
    
    protected BufferedReader launch(ActionEvent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
        launch(args);
    }
}