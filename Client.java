package Pack;

import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application{
	Socket cs = new Socket();

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400,300); 
		root.setSpacing(10); // 간격
		//-------------------------------------------
		Button btn1 = new Button("클라이언트");
		Button btn2 = new Button("테스트2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent arg0) {
				try {
					cs = new Socket();
					cs.connect(new InetSocketAddress("118.38.27.198", 5001));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream outputStream = cs.getOutputStream();
					String s = "apfel"+ count++;
					byte[] data = s.getBytes();
					outputStream.write(data);
					System.out.println("데이터가 전송되었습니다.");
				} catch (Exception e) {
					
				}
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		//--------------------------------------------
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Client");
		primaryStage.show();
	}
	public static void main(String[] args) 
	{
		launch();
		System.out.println("Exit");
	}
}

//public class Client {
//
//	public static void main(String[] args) {
//		System.out.println("Client Start");
//		
//		try {
//			Socket cs = new Socket();
//			
//			System.out.println("숫자를 입력하면 접속을 시도합니다.");
//			new Scanner( System.in ).nextInt();
//			// "115.22.10.55"
//			cs.connect(new InetSocketAddress("115.22.10.55", 5001));
//			// 동일 피씨가 아니라면 IP 주소가 들어간다
//			System.out.println("숫자를 입력하면 서버에 데이터를 전송합니다.");
//			new Scanner( System.in ).nextInt();
//			OutputStream outputStream = cs.getOutputStream();
//			String s = "apfel";
//			byte[] data = s.getBytes();
//			outputStream.write(data);
//			System.out.println("데이터가 전송되었습니다.");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		new Scanner( System.in ).nextInt();
//		System.out.println("Client End");
//	}
//}
