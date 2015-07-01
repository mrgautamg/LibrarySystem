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

public class LibraryMemberOverview extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource(
				"libraryMemberOverview.fxml"));

		primaryStage.setTitle("Library Member");
		// stage.setFullScreen(true);
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
	}

//	public static boolean  editMember(LibraryMember libMember) {
//		try {
//			
//			AddNewMemberController newMemberController = loader.getController();
//			newMemberController.setMember(libMember);
//
//			AnchorPane page = (AnchorPane) loader.load();
//
//			// Create the dialog Stage.
//			Stage editMemberStage = new Stage();
//			editMemberStage.setTitle("Edit Member");
//			editMemberStage.initModality(Modality.WINDOW_MODAL);
//			editMemberStage.initOwner(new Stage());
//			Scene scene = new Scene(page);
//			editMemberStage.setScene(scene);
//			editMemberStage.showAndWait();
//
//	        return newMemberController.isSaveClick();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

	// public static void main(String[] args) {
	// Application.launch(LibraryMemberOverview.class, args);
	// }

}
