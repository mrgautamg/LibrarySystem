package application.library.member;

import application.library.member.controller.AddNewMemberController;
import application.librarysample.business.LibraryMember;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AddNewMember extends Application{
//	public static void main(String[] args) {
//        Application.launch(AddNewMember.class, args);
//    }
	private Parent root;
	
    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("newMember.fxml"));
        
       stage.setScene(new Scene(root, 400, 450));
        //stage.showAndWait();
    }
    
    public void AddMemberView(Stage stage) throws Exception{
    	start(stage);
    	stage.setTitle("Add New Member");
        //stage.setFullScreen(true);
        stage.showAndWait();
    }
    
    public boolean EditMemberView(LibraryMember libMember) throws Exception{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("newMember.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Edit Person");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(new Stage());
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
         
    	AddNewMemberController newMemberController = loader.getController();
		newMemberController.setMember(libMember);
        //stage.setFullScreen(true);
		dialogStage.showAndWait();
		
		return newMemberController.isSaveClick();
    }
}
