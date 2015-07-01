package application.library.member.controller;

import application.librarysample.business.Address;
import application.librarysample.business.LibraryMember;
import application.librarysample.business.Person;
import application.librarysample.dataaccess.DataAccess;
import application.librarysample.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewMemberController {
	@FXML
	private TextField memberId;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField street;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField zip;
	@FXML
	private TextField phoneNo;
	@FXML
	private Label output;
	@FXML
	private Button save;
	@FXML
	private Button cancel;

	private boolean SaveClicked = false;
	
	@FXML
	protected void handleSaveButtonAction(ActionEvent event) {
		try {

			Address addr = new Address(street.getText(), city.getText(),
					state.getText(), zip.getText());
			LibraryMember member = new LibraryMember(memberId.getText(),
					firstName.getText(), lastName.getText(),
					phoneNo.getText(), addr);
			DataAccess da = new DataAccessFacade();
			da.saveLibraryMember(memberId.getText(), member);
			clearMemberData();
			output.setText("Successfully added member");
			SaveClicked=true;
		} catch (Exception e) {
			output.setText("Error: " + e.getMessage());
		}
	}

	@FXML
	protected void handleCancleButtonAction(ActionEvent event) {
		try {
			Stage stage = (Stage) cancel.getScene().getWindow();
			stage.close();
			
		} catch (Exception e) {
			output.setText("Error: " + e.getMessage());
		}
	}

	
	public void clearMemberData() {
		memberId.setDisable(true);
		firstName.setDisable(true);
		lastName.setDisable(true);
		street.setDisable(true);
		city.setDisable(true);
		state.setDisable(true);
		zip.setDisable(true);
		phoneNo.setDisable(true);
		save.setDisable(true);
	}
	
	public void setMember(LibraryMember libMember){
		memberId.setText(libMember.getMemberId());
		firstName.setText(libMember.getFirstName());
		lastName.setText(libMember.getLastName());
		street.setText(libMember.getAddress().getStreet());
		city.setText(libMember.getAddress().getCity());
		state.setText(libMember.getAddress().getState());
		zip.setText(libMember.getAddress().getZip());
		phoneNo.setText(libMember.getPhoneNo());
		memberId.setDisable(true);
		save.setText("Update");
	}
	
	public boolean isSaveClick(){
		return SaveClicked;
	}
}
