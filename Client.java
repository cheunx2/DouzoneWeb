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
		root.setSpacing(10); // ����
		//-------------------------------------------
		Button btn1 = new Button("Ŭ���̾�Ʈ");
		Button btn2 = new Button("�׽�Ʈ2");
		
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
					System.out.println("�����Ͱ� ���۵Ǿ����ϴ�.");
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
//			System.out.println("���ڸ� �Է��ϸ� ������ �õ��մϴ�.");
//			new Scanner( System.in ).nextInt();
//			// "115.22.10.55"
//			cs.connect(new InetSocketAddress("115.22.10.55", 5001));
//			// ���� �Ǿ��� �ƴ϶�� IP �ּҰ� ����
//			System.out.println("���ڸ� �Է��ϸ� ������ �����͸� �����մϴ�.");
//			new Scanner( System.in ).nextInt();
//			OutputStream outputStream = cs.getOutputStream();
//			String s = "apfel";
//			byte[] data = s.getBytes();
//			outputStream.write(data);
//			System.out.println("�����Ͱ� ���۵Ǿ����ϴ�.");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		new Scanner( System.in ).nextInt();
//		System.out.println("Client End");
//	}
//}
