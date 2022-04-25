package edu.wpi.cs3733.d22.teamW.wApp.controllers;

import edu.wpi.cs3733.d22.teamW.Managers.WindowManager;
import edu.wpi.cs3733.d22.teamW.wApp.controllers.PacMan.Game;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class GamingController {
  public void playPacMan(ActionEvent actionEvent) {
    new Game(new Stage());
  }

  public void playSnake(ActionEvent actionEvent) throws IOException {
    WindowManager.getInstance()
        .openWindow(
            "Snake.fxml", "Wiggling Wong", "/edu/wpi/cs3733/d22/teamW/wApp/assets/Icons/wong.png");
  }
}
