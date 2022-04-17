package edu.wpi.cs3733.d22.teamW.wDB.Managers;

import edu.wpi.cs3733.d22.teamW.wDB.DAO.EmployeeMessageDao;
import edu.wpi.cs3733.d22.teamW.wDB.entity.EmployeeMessage;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeMessageManager {
  private EmployeeMessageDao emd;

  private static Integer count = 1;

  private static EmployeeMessageManager employeeMessageManager = new EmployeeMessageManager();

  public static EmployeeMessageManager getEmployeeMessageManager() {
    return employeeMessageManager;
  }

  private EmployeeMessageManager() {}

  public void setEmployeeMessageDao(EmployeeMessageDao emd) {
    this.emd = emd;
  }

  public ArrayList<EmployeeMessage> getAllMessages() throws SQLException {
    return this.emd.getAllMessages();
  }

  public ArrayList<EmployeeMessage> getAllUnreadMessages(Integer empIDto) throws SQLException {
    return this.emd.getAllUnreadMessages(empIDto);
  }

  public ArrayList<EmployeeMessage> getMessagesFromTo(Integer empIDfrom, Integer empIDto)
      throws SQLException {
    return this.emd.getMessagesFromTo(empIDfrom, empIDto);
  }

  public EmployeeMessage getEmployeeMessage(Integer messageID) throws SQLException {
    return this.emd.getEmployeeMessage(messageID);
  }

  public void addEmployeeMessage(EmployeeMessage em) throws SQLException {
    this.emd.addEmployeeMessage(em);
    count++;
  }

  public void changeEmployeeMessage(EmployeeMessage em) throws SQLException {
    this.emd.changeEmployeeMessage(em);
  }

  public void deleteEmployeeMessage(Integer messageID) throws SQLException {
    this.emd.deleteEmployeeMessage(messageID);
  }

  public Integer getNextMsgID() {
    return count;
  }
}
