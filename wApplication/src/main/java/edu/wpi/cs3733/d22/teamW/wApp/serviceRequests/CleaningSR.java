package edu.wpi.cs3733.d22.teamW.wApp.serviceRequests;

import edu.wpi.cs3733.d22.teamW.wDB.Managers.CleaningRequestManager;
import edu.wpi.cs3733.d22.teamW.wDB.Managers.MedEquipManager;
import edu.wpi.cs3733.d22.teamW.wDB.entity.Request;
import java.sql.SQLException;

public class CleaningSR extends SR {

  public CleaningSR(Request r) {
    super(r);
  }

  public String getRequestType() {
    return "Cleaning";
  }

  @Override
  public String getFormattedInfo() throws SQLException {
    String itemID =
        CleaningRequestManager.getCleaningRequestManager()
            .getRequest(this.getRequestID())
            .getItemID();
    String info = "Automated cleaning request for equipment.\n";
    info +=
        "Equipment type: "
            + MedEquipManager.getMedEquipManager().getMedEquip(itemID).getType()
            + "\n";
    info += "Equipment ID: " + itemID + "\n";
    // info += "Location: " + MedEquipManager.getMedEquipManager().getMedEquip(itemID).getNodeID().
    return info;
  }
}
