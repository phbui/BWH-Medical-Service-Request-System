package edu.wpi.cs3733.d22.teamW.wApp.serviceRequests;

import edu.wpi.cs3733.d22.teamW.wDB.entity.Request;
import edu.wpi.cs3733.d22.teamW.wDB.enums.RequestType;
import java.sql.SQLException;

public class GiftSR extends SR {

  public GiftSR(Request r) {
    super(r);
  }

  @Override
  public RequestType getRequestType() {
    return RequestType.GiftDelivery;
  }

  @Override
  public String getRequestTypeS() {
    return "Gift Service";
  }

  @Override
  public String getFormattedInfo() throws SQLException {
    String info = "";
    if (this.getEmergency() == 1) {
      info += "Request marked as an EMERGENCY\n";
    }
    info += "Assigned Employee: " + this.getEmployeeName() + "\n";
    info += "Employee ID: " + this.getEmployeeID() + "\n";
    info += "";
    return info;
  }
}
