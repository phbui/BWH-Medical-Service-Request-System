package edu.wpi.cs3733.d22.teamW.wApp.controllers.ServiceRequestControllers;

import edu.wpi.cs3733.d22.teamW.wDB.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MedicalEquipmentServiceRequestController {
  Alert confirm =
      new Alert(
          Alert.AlertType.CONFIRMATION,
          "Would you like to confirm this request " + " ?",
          ButtonType.OK,
          ButtonType.CANCEL);

  Alert emptyFields =
      new Alert(
          Alert.AlertType.ERROR,
          "There are required fields empty " + " !",
          ButtonType.OK,
          ButtonType.CANCEL);
  @FXML ComboBox<String> equipmentSelection;
  // location here
  @FXML TextField employeeName;
  @FXML CheckBox emergencyLevel;
  int emergency;

  RequestFactory requestFactory = RequestFactory.getRequestFactory();
  ArrayList<String> lastRequest;

  public void submitButton(ActionEvent actionEvent) throws SQLException {
    System.out.println("Button Clicked");
    if ((equipmentSelection.getValue() != null) && !employeeName.getText().isEmpty()) {
      confirm.showAndWait();
      if (confirm.getResult() == ButtonType.OK) {
        ArrayList<String> fields = new ArrayList<String>();
        fields.add(equipmentSelection.getValue());
        System.out.println(equipmentSelection.getValue());
        fields.add("wSTOR001L1"); // location
        fields.add(employeeName.getText());
        if (emergencyLevel.isSelected()) {
          emergency = 1;
        } else {
          emergency = 0;
        }
        fields.add("" + emergency);
        requestFactory.getRequest("MEDEQUIPREQUEST", fields);
        lastRequest = fields;
      }
    } else {
      emptyFields.show();
    }
  }

  public void cancelButton(ActionEvent actionEvent) {
    // MedicalEquipmentController.cancel(requestFactory.getRequest("MEDEQUIPREQUEST", fields));
  }
}
