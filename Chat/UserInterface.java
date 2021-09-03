package Pack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class UserInterface extends Application{
	@Override
	public void start(Stage arg0) throws Exception {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text sceneTitle = new Text("Server");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 2, 1);
		
		Text ipText = new Text("ip:127.0.0.0");
		grid.add(ipText, 1, 1);
		
		Text ipAddress = new Text("");
		grid.add(ipAddress, 2, 1);
		
		Text userName = new Text("Name:");
		grid.add(userName, 0, 2);
				
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 2);
		
		Button connectBtn = new Button("Connect");
		VBox vBtn1 = new VBox(10);
		vBtn1.setAlignment(Pos.TOP_RIGHT);
		vBtn1.getChildren().add(connectBtn);
		grid.add(vBtn1, 2, 2);
		
		TextArea chatBoxArea = new TextArea();
		grid.add(chatBoxArea, 0, 3);
		
		TextArea currentMemberArea = new TextArea();
		grid.add(currentMemberArea, 1, 3);
		
		Text chatBoxText = new Text("Chat Box");
		grid.add(chatBoxText, 0, 4);
		
		Text memberText = new Text("Current Member");
		grid.add(memberText, 1, 4);
		
		Button sendBtn = new Button("Send");
		VBox vBtn2 = new VBox(10);
		vBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		vBtn2.getChildren().add(sendBtn);
		grid.add(vBtn2, 1, 5);
		
		Button exitBtn = new Button("Exit");
		VBox vBtn3 = new VBox(10);
		vBtn3.setAlignment(Pos.BOTTOM_RIGHT);
		vBtn3.getChildren().add(exitBtn);
		grid.add(vBtn3, 2, 5);
		
		Scene scene = new Scene(grid, 800, 700);
		arg0.setScene(scene);
		arg0.setTitle("Chat");
		arg0.show();
	}
	public static void main(String[] args) {
		launch();
		System.out.println("Exit");
	}
}
