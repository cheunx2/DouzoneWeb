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
//ex75) Thread 안에서 컨트롤 하고 싶을 때 
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
	Button btn1 = new Button("테스트1");
	Button btn2 = new Button("테스트2");

	
		@Override
		public void start(Stage arg0) throws Exception {
			VBox root = new VBox();
			root.setPrefSize(400,300); 
			root.setSpacing(10); // 간격
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
				}.start(); // Thread 안에서 조작시 항상 주의할 것 
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
			arg0.setTitle("호랑이");
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
		root.setSpacing(10); // 간격
		//-------------------------------------------
		Button btn1 = new Button("테스트1");
		Button btn2 = new Button("테스트2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("호랑이");
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
		arg0.setTitle("호랑이");
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
		root.setSpacing(10); // 간격
		//-------------------------------------------
		Button btn1 = new Button("테스트1");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("호랑이");
			}
		});
		
		TextArea textarea = new TextArea(); // 엔터 치면 다음줄로 넘어 감 

		
		TextField textfield = new TextField(); // 한 줄, 엔터치면 이벤트 발생
		
		textfield.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("코끼리");
				String s = textfield.getText();
				textarea.appendText(s+"\n"); 
				// run later 사용, *** 스레드 안에서 컨트롤 변경 XXX ***
				textfield.setText("");
			}
		}); // 엔터 할 때 코끼리 출력(== 이벤트 발생)
		
		
		root.getChildren().addAll(btn1, textarea, textfield);
		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
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
		root.setSpacing(10); // 간격
		//-------------------------------------------
		// 방법 (1)
//		Button btn1 = new Button("테스트1");
//		root.getChildren().add(btn1);
//		
//		Button btn2 = new Button("테스트2");
//		root.getChildren().add(btn2);
		
		// 방법 (2)
		Button btn1 = new Button("테스트1");
		Button btn2 = new Button("테스트2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("호랑이");
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("사자");
			}
		});
		
		root.getChildren().addAll(btn1, btn2);
		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("호랑이");
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
// jfx 다운로드 program files > java 에 압축 풀기
// 프로젝트 우클릭 > Properties > Jave Build Path > Libraries > Modulepath 클릭 > Add External JARs... > 다운 받은 파일로 들어가서 >
// lib > ctrl + a에서 ctrl 눌러서 src 제외 하고 열기 > open > apply

// --module-path "C:\Program Files\Java\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib"
// --add-modules javafx.controls,javafx.fxml

// 프로젝트 우클릭 - Run as - run configurations - Arguments - VM arguments에 위에 두 줄 복붙 -apply -run
// class에 extends Application ctrl + space 자바 어쩌구 클릭 하고 
// 스코프 안에 들어가서 ctrl + space 해서 엔터 => start 함수 생김
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