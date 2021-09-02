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
				System.out.println(s+" �����͸� �޾ҽ��ϴ�");
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
			System.out.println("���� ���� ���� ����");
			
			mss.bind(new InetSocketAddress(InetAddress.getLocalHost(), 5001));
			System.out.println("���ε� �Ϸ�");
			
			// ���ŷ �Լ� 
			while(true) {
				Socket ss = mss.accept();
				System.out.println("������ �����Ͽ����ϴ�.");
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
		root.setSpacing(10); // ����
		//-------------------------------------------
		Button btn1 = new Button("��������");
		Button btn2 = new Button("�׽�Ʈ2");
		
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

// ���� ctrl + F11
// Ŭ���̾�Ʈ ctrl + F11
// �ܼ�â���� ���� �� �ϰ� 
// �ι�° �ֿܼ��� ���÷��� select �ϰ� �� 

//public class Server {
//
//	public static void main(String[] args) {
//		System.out.println("Server Start");
//		
//		try {
//			// ������ ���� ����
//			ServerSocket mss = new ServerSocket();
//			System.out.println("���� ���� ���� ����");
//			
//			// cmd - ipconfig - IPv4�ּ�...: ip �ּ�
//			// ������ ���� ������ ���� �ʰ� ���� ȣ��Ʈ ã�Ƽ� ���� 
//			mss.bind(new InetSocketAddress(InetAddress.getLocalHost(), 5001));
//			System.out.println("���ε� �Ϸ�");
//			
//			// ���ŷ �Լ� 
//			Socket ss = mss.accept();
//			System.out.println("������ �����Ͽ����ϴ�.");
//			InputStream inputstream = ss.getInputStream();
//			
//			// ���ŷ �Լ�
//			byte[] data = new byte[512]; 
//			// ������ ����Ʈ �迭�� �޾ƾ��ϰ� ũ��� 2�� ��������Ѵ�.
// 			int size = inputstream.read(data);
// 			
// 			String s = new String(data, 0, size);
// 			// ����Ʈ Ÿ������ �޾Ƽ� ���ڿ��� s �� �־���
// 			System.out.println(s+" �����͸� �޾ҽ��ϴ�");
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
