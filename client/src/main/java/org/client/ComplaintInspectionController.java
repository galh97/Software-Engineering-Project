/**
 * Sample Skeleton for 'ComplaintInspection.fxml' Controller Class
 */

package org.client;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.entities.Complaint;

public class ComplaintInspectionController extends Controller{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="compensationCheckbox"
    private CheckBox compensationCheckbox; // Value injected by FXMLLoader

    @FXML // fx:id="compensationField"
    private TextField compensationField; // Value injected by FXMLLoader

    @FXML // fx:id="complainerName"
    private TextArea complainerName; // Value injected by FXMLLoader

    @FXML // fx:id="complaintText"
    private TextArea complaintText; // Value injected by FXMLLoader

    @FXML // fx:id="complaintType"
    private TextField complaintType; // Value injected by FXMLLoader

    @FXML // fx:id="submitBtn"
    private Button submitBtn; // Value injected by FXMLLoader

    private Complaint complaint;

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    @FXML
    void compensationMode(ActionEvent event) {
        compensationField.setEditable(compensationCheckbox.isSelected());
        if(compensationCheckbox.isSelected())
            compensationField.setDisable(false);
        else{
            compensationField.setDisable(true);
            compensationField.setText("");
        }
    }


    Pattern pattern1 = Pattern.compile(".{0,5}");
    TextFormatter<String> formatter1 = new TextFormatter<String>(change -> {
        change.setText(change.getText().replaceAll("[^0-9.,]", ""));
        return pattern1.matcher(change.getControlNewText()).matches() ? change : null;
    });

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert compensationCheckbox != null : "fx:id=\"compensationCheckbox\" was not injected: check your FXML file 'ComplaintInspection.fxml'.";
        assert compensationField != null : "fx:id=\"compensationField\" was not injected: check your FXML file 'ComplaintInspection.fxml'.";
        assert complainerName != null : "fx:id=\"complainerName\" was not injected: check your FXML file 'ComplaintInspection.fxml'.";
        assert complaintText != null : "fx:id=\"complaintText\" was not injected: check your FXML file 'ComplaintInspection.fxml'.";
        assert complaintType != null : "fx:id=\"complaintType\" was not injected: check your FXML file 'ComplaintInspection.fxml'.";
        assert submitBtn != null : "fx:id=\"submitBtn\" was not injected: check your FXML file 'ComplaintInspection.fxml'.";
        Platform.runLater(() -> {
            complaintText.setText(complaint.getCompText());
            complainerName.setText(complaint.getCustomer().getName());
            complaintType.setText(complaint.getTopic().toString());
            complaintText.setDisable(true);
            complainerName.setDisable(true);
            complaintType.setDisable(true);
            compensationField.setDisable(true);
            compensationField.setTextFormatter(formatter1);
        });
    }

}
