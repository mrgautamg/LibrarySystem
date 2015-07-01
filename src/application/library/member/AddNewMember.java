package application.library.member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddNewMember extends Application{
	public static void main(String[] args) {
        Application.launch(AddNewMember.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("newMember.fxml"));
        
        stage.setTitle("Add New Member");
        //stage.setFullScreen(true);
        stage.setScene(new Scene(root, 400, 450));
        stage.show();
    }
}
