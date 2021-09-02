package Pack;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ClientThread extends Thread {
	Socket socket;
	public ClientThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		InputStream inputstream;
		try {
			inputstream = socket.getInputStream();
			
			while(true) {
				byte[] data = new byte[512]; 
				int size = inputstream.read(data);
				String s = new String(data, 0, size);
				System.out.println(s+" 데이터를 받았습니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ConnectThread extends Thread {
	public void run() {
		try {
			ServerSocket mss = new ServerSocket();
			System.out.println("메인 서버 소켓 생성");
			
			mss.bind(new InetSocketAddress(InetAddress.getLocalHost(), 5001));
			System.out.println("바인딩 완료");
			
			// 블로킹 함수 
			while(true) {
				Socket ss = mss.accept();
				System.out.println("누군가 접속하였습니다.");
				new ClientThread(ss).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Server extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400,300); 
		root.setSpacing(10); // 간격
		//-------------------------------------------
		Button btn1 = new Button("서버오픈");
		Button btn2 = new Button("테스트2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new ConnectThread().start();
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		//--------------------------------------------
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Server");
		primaryStage.show();
	}

	public static void main(String[] args) 
	{
		launch();
		System.out.println("Exit");
	}
}

// 서버 ctrl + F11
// 클라이언트 ctrl + F11
// 콘솔창에서 서버 핀 하고 
// 두번째 콘솔에서 디스플레이 select 하고 핀 

//public class Server {
//
//	public static void main(String[] args) {
//		System.out.println("Server Start");
//		
//		try {
//			// 서버의 메인 소켓
//			ServerSocket mss = new ServerSocket();
//			System.out.println("메인 서버 소켓 생성");
//			
//			// cmd - ipconfig - IPv4주소...: ip 주소
//			// 서버는 직접 아이피 넣지 않고 로컬 호스트 찾아서 넣음 
//			mss.bind(new InetSocketAddress(InetAddress.getLocalHost(), 5001));
//			System.out.println("바인딩 완료");
//			
//			// 블로킹 함수 
//			Socket ss = mss.accept();
//			System.out.println("누군가 접속하였습니다.");
//			InputStream inputstream = ss.getInputStream();
//			
//			// 블로킹 함수
//			byte[] data = new byte[512]; 
//			// 무조건 바이트 배열로 받아야하고 크기는 2의 배수여야한다.
// 			int size = inputstream.read(data);
// 			
// 			String s = new String(data, 0, size);
// 			// 바이트 타입으로 받아서 문자열로 s 에 넣어줌
// 			System.out.println(s+" 데이터를 받았습니다");
// 			
// 			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		new Scanner( System.in ).nextInt();
//		System.out.println("Server End");
//	}
//
//}
