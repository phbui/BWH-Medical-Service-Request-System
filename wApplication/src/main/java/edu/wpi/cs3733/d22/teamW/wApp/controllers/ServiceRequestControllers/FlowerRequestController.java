package edu.wpi.cs3733.d22.teamW.wApp.controllers.ServiceRequestControllers;

import edu.wpi.cs3733.d22.teamW.Managers.PageManager;
import edu.wpi.cs3733.d22.teamW.wApp.controllers.ConfirmAlert;
import edu.wpi.cs3733.d22.teamW.wApp.controllers.EmptyAlert;
import edu.wpi.cs3733.d22.teamW.wApp.controllers.customControls.AutoCompleteInput;
import edu.wpi.cs3733.d22.teamW.wApp.controllers.customControls.EmergencyButton;
import edu.wpi.cs3733.d22.teamW.wApp.controllers.customControls.HospitalMap;
import edu.wpi.cs3733.d22.teamW.wDB.Managers.EmployeeManager;
import edu.wpi.cs3733.d22.teamW.wDB.Managers.LocationManager;
import edu.wpi.cs3733.d22.teamW.wDB.RequestFactory;
import edu.wpi.cs3733.d22.teamW.wDB.entity.Employee;
import edu.wpi.cs3733.d22.teamW.wDB.entity.Location;
import edu.wpi.cs3733.d22.teamW.wDB.enums.EmployeeType;
import edu.wpi.cs3733.d22.teamW.wDB.enums.Flower;
import edu.wpi.cs3733.d22.teamW.wDB.enums.RequestType;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FlowerRequestController implements Initializable {
    @FXML
    TextField recipientLastName;
    @FXML
    TextField recipientFirstName;
    @FXML
    AutoCompleteInput locationComboBox;
    @FXML
    //Pane map;
    HospitalMap map;
    @FXML
    AutoCompleteInput employeeIDComboBox;
    @FXML
    AutoCompleteInput flowerTypeBox;
    @FXML
    EmergencyButton emergencyButton;
    @FXML
    Label successLabel;
    Alert confirm = new ConfirmAlert();
    Alert emptyFields = new EmptyAlert();
    private FadeTransition fadeOut = new FadeTransition(Duration.millis(5000));

    public void submitButton(ActionEvent actionEvent) throws SQLException {
        if (!emptyFields()) {
            confirm.showAndWait();
            if (confirm.getResult() == ButtonType.OK) {
                pushFlowerRequestToDB();
                clearFields();
                successLabel.setVisible(true);
                fadeOut.playFromStart();
            }
        } else {
            emptyFields.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            onLoad();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        map.attachOnSelectionMade(l -> locationComboBox.getSelectionModel().select(l.getLongName()));
    }

    public void onLoad() throws SQLException {
        fadeOut.setNode(successLabel);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(false);
        locationComboBox.loadValues(getLocations());
        employeeIDComboBox.loadValues(getEmployeeNames());
        flowerTypeBox.loadValues(getFlowerTypeList());
    }

    private boolean emptyFields() {
        return employeeIDComboBox.getSelectionModel().isEmpty()
                || locationComboBox.getSelectionModel().isEmpty()
                || flowerTypeBox.getSelectionModel().isEmpty()
                || recipientFirstName.getText().isEmpty()
                || recipientLastName.getText().isEmpty();
    }

    private void pushFlowerRequestToDB() throws SQLException {
        ArrayList<String> srFields = new ArrayList<String>();
        srFields.add(flowerTypeBox.getSelectionModel().getSelectedItem().toString());
        srFields.add(recipientLastName.getText());
        srFields.add(recipientFirstName.getText());
        srFields.add(
                locationToNodeID(locationComboBox.getSelectionModel().getSelectedItem().toString()));
        srFields.add(
                getEmployeeID(employeeIDComboBox.getSelectionModel().getSelectedItem().toString()));
        if (emergencyButton.getValue()) {
            srFields.add("1");
        } else {
            srFields.add("0");
        }
        try {
            RequestFactory.getRequestFactory().getRequest(RequestType.FlowerRequest, srFields, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        locationComboBox.getSelectionModel().clearSelection();
        employeeIDComboBox.getSelectionModel().clearSelection();
        flowerTypeBox.getSelectionModel().clearSelection();
        recipientFirstName.clear();
        recipientLastName.clear();
        emergencyButton.setValue(false);
    }

    private String getEmployeeID(String name) throws SQLException {
        name = name.trim();
        Integer employeeID = null;
        String employeeLastName;
        String employeeFirstName;
        Integer commaIndex = name.indexOf(',');
        employeeLastName = name.substring(0, commaIndex);
        employeeFirstName = name.substring(commaIndex + 2);
        employeeID = EmployeeManager.getEmployeeManager().getEmployeeFromName(employeeLastName, employeeFirstName).getEmployeeID();

        return String.format("%d", employeeID);
    }

    private String locationToNodeID(String target) {
        String nodeID = "FAIL";

        ArrayList<Location> locationsRaw = null;
        try {
            locationsRaw = LocationManager.getLocationManager().getAllLocations();
        } catch (SQLException e) {
            System.out.println("Failed to unearth locations from database");
            e.printStackTrace();
        }
        for (Location l : locationsRaw) {
            if (l.getLongName().equals(target)) {
                nodeID = l.getNodeID();
            }
        }
        return nodeID;
    }

    private ArrayList<String> getEmployeeNames() {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Employee> employees = null;
        ArrayList<EmployeeType> types = new ArrayList<>();
        types.add(EmployeeType.Nurse);
        types.add(EmployeeType.Staff);
        try {
            employees = EmployeeManager.getEmployeeManager().getEmployeeListByType(types);
        } catch (SQLException e) {
            System.out.println("Failed to unearth employees from database");
            e.printStackTrace();
        }
        for (Employee e : employees) {
            String empName = String.format("%s, %s", e.getLastName(), e.getFirstName());
            name.add(empName);
        }
        return name;
    }

    private ArrayList<String> getLocations() {
        ArrayList<String> locations = new ArrayList<>();
        ArrayList<Location> locationsRaw = null;
        ArrayList<Integer> removeIndexes = new ArrayList<>();
        try {
            locationsRaw = LocationManager.getLocationManager().getAllLocations();
        } catch (SQLException e) {
            System.out.println("Failed to unearth locations from database");
            e.printStackTrace();
        }

        for (Location l : locationsRaw) {
            if (!l.getNodeType().equals("NONE")) {
                locations.add(l.getLongName());
            }
        }
        return locations;
    }

    private ArrayList<String> getFlowerTypeList() {
        ArrayList<String> flowers = new ArrayList<>();
        for (Flower f : Flower.values()) {
            flowers.add(f.getString());
        }
        return flowers;
    }

    public void switchToRequestList() throws IOException {
        PageManager.getInstance().loadPage(PageManager.Pages.RequestList);
    }
}
