package Pack;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/*
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println("check");
	}
}
*/

/*
//ex75) Thread �ȿ��� ��Ʈ�� �ϰ� ���� �� 
class ConnectThread extends Thread{
	Hello hello;

	ConnectThread(Hello hello){
		this.hello = hello;
	};

	public void run() {
		System.out.println(2);
		Platform.runLater(
				()->{
					hello.btn1.setText("Tiger");
				});
	}
}

public class Hello extends Application
{
	Button btn1 = new Button("�׽�Ʈ1");
	Button btn2 = new Button("�׽�Ʈ2");

	
		@Override
		public void start(Stage arg0) throws Exception {
			VBox root = new VBox();
			root.setPrefSize(400,300); 
			root.setSpacing(10); // ����
			//-------------------------------------------
			btn1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					new Thread() {
						@Override
						public void run() {
							System.out.println(1);
							Platform.runLater(
									()->{
										btn2.setText("Tiger");
									});
					}
				}.start(); // Thread �ȿ��� ���۽� �׻� ������ �� 
			}
		});

			btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					new ConnectThread(Hello.this).start();
				}
			});

			root.getChildren().addAll(btn1, btn2);
			//--------------------------------------------
			Scene scene = new Scene(root);
			arg0.setTitle("ȣ����");
			arg0.setScene(scene);
			arg0.show();
	}

	public static void main(String[] args) 
	{
		launch();
		System.out.println("Exit");
	}
}
*/

/*
// ex74)
public class Hello extends Application
{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400,300); 
		root.setSpacing(10); // ����
		//-------------------------------------------
		Button btn1 = new Button("�׽�Ʈ1");
		Button btn2 = new Button("�׽�Ʈ2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("ȣ����");
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// btn1.setVisible(false);
				btn1.setDisable(true);
			}
		});
		
		root.getChildren().addAll(btn1, btn2);
		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) 
	{
		launch();
		System.out.println("Exit");
	}
}
*/

/*
// ex73)
public class Hello extends Application
{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400,300); 
		root.setSpacing(10); // ����
		//-------------------------------------------
		Button btn1 = new Button("�׽�Ʈ1");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("ȣ����");
			}
		});
		
		TextArea textarea = new TextArea(); // ���� ġ�� �����ٷ� �Ѿ� �� 

		
		TextField textfield = new TextField(); // �� ��, ����ġ�� �̺�Ʈ �߻�
		
		textfield.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("�ڳ���");
				String s = textfield.getText();
				textarea.appendText(s+"\n"); 
				// run later ���, *** ������ �ȿ��� ��Ʈ�� ���� XXX ***
				textfield.setText("");
			}
		}); // ���� �� �� �ڳ��� ���(== �̺�Ʈ �߻�)
		
		
		root.getChildren().addAll(btn1, textarea, textfield);
		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) 
	{
		launch();
		System.out.println("Exit");
	}
}
*/

/*
// ex72)
public class Hello extends Application
{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400,300); 
		root.setSpacing(10); // ����
		//-------------------------------------------
		// ��� (1)
//		Button btn1 = new Button("�׽�Ʈ1");
//		root.getChildren().add(btn1);
//		
//		Button btn2 = new Button("�׽�Ʈ2");
//		root.getChildren().add(btn2);
		
		// ��� (2)
		Button btn1 = new Button("�׽�Ʈ1");
		Button btn2 = new Button("�׽�Ʈ2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("ȣ����");
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("����");
			}
		});
		
		root.getChildren().addAll(btn1, btn2);
		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("ȣ����");
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) 
	{
		launch();
		System.out.println("Exit");
	}
}
*/

/*
// ex71)
// jfx �ٿ�ε� program files > java �� ���� Ǯ��
// ������Ʈ ��Ŭ�� > Properties > Jave Build Path > Libraries > Modulepath Ŭ�� > Add External JARs... > �ٿ� ���� ���Ϸ� ���� >
// lib > ctrl + a���� ctrl ������ src ���� �ϰ� ���� > open > apply

// --module-path "C:\Program Files\Java\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib"
// --add-modules javafx.controls,javafx.fxml

// ������Ʈ ��Ŭ�� - Run as - run configurations - Arguments - VM arguments�� ���� �� �� ���� -apply -run
// class�� extends Application ctrl + space �ڹ� ��¼�� Ŭ�� �ϰ� 
// ������ �ȿ� ���� ctrl + space �ؼ� ���� => start �Լ� ����
public class Hello extends Application
{
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(2);
		arg0.show();
		System.out.println(3);
		
	}
	
	public static void main(String[] args) 
	{
		System.out.println(1);
		Launch();
		System.out.println(4);
	}
}
*/