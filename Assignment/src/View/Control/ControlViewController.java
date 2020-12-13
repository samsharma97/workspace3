package View.Control;

import Core.ViewHandler;
import View.Show.ShowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControlViewController
{
  @FXML private Label currentStateLabel;

  private ViewHandler vh;
  private ControlViewModel controlVM;
  private ShowViewModel showViewModel;

  @FXML private void showButton(ActionEvent actionEvent)
  {
    controlVM.clear();
    vh.openShowView();
  }

  @FXML private void turnUpButton(ActionEvent actionEvent)
  {
    controlVM.turnUp();
    //currentStateLabel.setText(controlVM.getPowerPosition().toString());
    showViewModel.getPowerPosition().setValue(controlVM.getPowerPosition().toString());
  }

  @FXML private void turnDownButton(ActionEvent actionEvent)
  {
    controlVM.turnDown();
       //currentStateLabel.setText(controlVM.getPowerPosition().toString());
    //    showViewModel.getPowerPosition().setValue(controlVM.getPowerPosition().toString());
  }

  public void init(ViewHandler vh, ControlViewModel controlVM, ShowViewModel showVM)
  {
    this.vh = vh;
    this.controlVM = controlVM;
    showViewModel = showVM;
    currentStateLabel.textProperty().bind(controlVM.getPowerPosition());
  }
}
