package View.Show;

import Core.ViewHandler;
import Model.Temperature;
import View.Control.ControlViewModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.beans.PropertyChangeEvent;

public class ShowViewController
{
  @FXML private Label powerPositionLabel;
  @FXML private Label indoor1Label;
  @FXML private Label indoor2Label;
  @FXML private Label outdoorLabel;
  @FXML private Label warningLabel;

  private final double minTemp = 10;
  private final double maxTemp = 40;

  private ViewHandler vh;
  private ShowViewModel showVM;
  private ControlViewModel controlVM;

  public void init(ViewHandler vh, ShowViewModel showVM, ControlViewModel controlVM)
  {
    this.vh = vh;
    this.showVM = showVM;
    this.controlVM = controlVM;
    powerPositionLabel.textProperty().bind(showVM.getPowerPosition());
    indoor1Label.textProperty().bind(showVM.getTemperatureT1());
    indoor2Label.textProperty().bind(showVM.getTemperatureT2());
    outdoorLabel.setText(String.valueOf(2));
    showVM.getTm().addPropertyChangeListener("Temperature", this::tempWarning);
  }

  private void tempWarning(PropertyChangeEvent evt)
  {
    Temperature t = (Temperature) evt.getNewValue();

    double currentTemp = t.getValue();
    if (currentTemp <= minTemp)
    {
      Platform.runLater(() -> {
        warningLabel.setText("Temperature is running low.");
      });
    }
    else if (currentTemp > maxTemp)
    {
      Platform.runLater(() -> {
        warningLabel.setText("Temperature is running high.");
      });
    }
  }

  public void controlButton(ActionEvent actionEvent)
  {
    showVM.clear();
    vh.openControlView();
  }
}
