package edu.wpi.cs3733.d22.teamW.wDB.Managers;

import edu.wpi.cs3733.d22.teamW.wDB.DAO.LabServiceRequestDao;
import edu.wpi.cs3733.d22.teamW.wDB.RequestFactory;
import edu.wpi.cs3733.d22.teamW.wDB.entity.LabServiceRequest;
import edu.wpi.cs3733.d22.teamW.wDB.entity.Request;
import edu.wpi.cs3733.d22.teamW.wDB.enums.RequestStatus;
import edu.wpi.cs3733.d22.teamW.wDB.enums.RequestType;

import java.sql.SQLException;
import java.util.ArrayList;

public class LabServiceRequestManager implements RequestManager {

  private LabServiceRequestDao lsrdi;

  private static LabServiceRequestManager labServiceRequestManager = new LabServiceRequestManager();

  private LabServiceRequestManager() {}

  public static LabServiceRequestManager getLabServiceRequestManager() {
    return labServiceRequestManager;
  }

  public void setLabServiceRequestDao(LabServiceRequestDao labServiceRequestDao) {
    this.lsrdi = labServiceRequestDao;
  }

  // TODO make this use just SQL
  @Override
  public Request getRequest(Integer reqID) {
    ArrayList<Request> list = lsrdi.getAllLabServiceRequests();

    for (Request l : list) {
      if (l.getRequestID().equals(reqID)) {
        return l;
      }
    }
    return null;
  }

  @Override
  public Request addRequest(Integer num, ArrayList<String> fields) throws SQLException {
    LabServiceRequest lSR;
    // Set status to in queue if it is not already included (from CSVs)
    if (fields.size() == 4) {
      fields.add(String.format("%d", RequestStatus.InQueue.getValue()));
      lSR = new LabServiceRequest(num, fields);
    } else {
      System.out.println("Right before making lSR");
      lSR = new LabServiceRequest(fields);
    }
    lsrdi.addLabServiceRequest(lSR);
    return lSR;
  }

  public void start(Integer requestID) throws SQLException {
    LabServiceRequest request = (LabServiceRequest) RequestFactory.getRequestFactory().findRequest(requestID);
    request.setStatus(RequestStatus.InProgress);
    lsrdi.changeLabServiceRequest(
        request.getRequestID(),
        request.getLabType(),
        request.getNodeID(),
        request.getEmployeeID(),
        request.getEmergency(),
            RequestStatus.InProgress);
  }

  public void complete(Integer requestID) throws SQLException {
    LabServiceRequest request = (LabServiceRequest) RequestFactory.getRequestFactory().findRequest(requestID);
    request.setStatus(RequestStatus.Completed);
    lsrdi.changeLabServiceRequest(
        request.getRequestID(),
        request.getLabType(),
        request.getNodeID(),
        request.getEmployeeID(),
        request.getEmergency(),
            RequestStatus.Completed);
  }


  public void cancel(Integer requestID) throws SQLException {
    LabServiceRequest request = (LabServiceRequest) RequestFactory.getRequestFactory().findRequest(requestID);
    request.setStatus(RequestStatus.Cancelled);
    lsrdi.changeLabServiceRequest(
        request.getRequestID(),
        request.getLabType(),
        request.getNodeID(),
        request.getEmployeeID(),
        request.getEmergency(),
            RequestStatus.Cancelled);
  }

  public void reQueue(Integer requestID) throws SQLException {
    LabServiceRequest request = (LabServiceRequest) RequestFactory.getRequestFactory().findRequest(requestID);
    request.setStatus(RequestStatus.Cancelled);
    lsrdi.changeLabServiceRequest(
            request.getRequestID(),
            request.getLabType(),
            request.getNodeID(),
            request.getEmployeeName(),
            request.getEmergency(),
            RequestStatus.InQueue);
  }

  @Override
  public ArrayList<Request> getAllRequests() {
    return this.lsrdi.getAllLabServiceRequests();
  }

  public void exportLabServiceRequestCSV(String filename) {
    lsrdi.exportLabServiceReqCSV(filename);
  }
}
