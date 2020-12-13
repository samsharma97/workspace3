package View.Control;

import Mediator.TemperatureModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ControlViewModel
{
  private StringProperty powerPosition;
  private TemperatureModel tm;

  public ControlViewModel(TemperatureModel model)
  {
    tm = model;
    powerPosition = new SimpleStringProperty();
  }

  public void clear()
  {
    powerPosition.setValue("");
  }

  public StringProperty getPowerPosition()
  {
    return powerPosition;
  }

  public void turnUp()
  {
    tm.turnUp();
    powerPosition.setValue(String.valueOf(tm.getPowerPosition()));
  }

  public void turnDown()
  {
    tm.turnDown();
    powerPosition.setValue(String.valueOf(tm.getPowerPosition()));
  }
}

