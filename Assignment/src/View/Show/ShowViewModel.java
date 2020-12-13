package View.Show;

import Mediator.TemperatureModel;
import Model.Temperature;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class ShowViewModel
{
  private StringProperty powerPosition;
  private StringProperty temperatureT1;
  private StringProperty temperatureT2;
  //private StringProperty temperatureT3;
  private TemperatureModel tm;

  public ShowViewModel(TemperatureModel model)
  {
    tm = model;
    powerPosition = new SimpleStringProperty();
    temperatureT1 = new SimpleStringProperty();
    temperatureT2 = new SimpleStringProperty();
   // temperatureT3 = new SimpleStringProperty();

    tm.addPropertyChangeListener("Temperature", this::updateTemp);
  }

  public StringProperty getPowerPosition()
  {
    return powerPosition;
  }

  private void updateTemp(PropertyChangeEvent propertyChangeEvent)
  {
    Temperature t = (Temperature) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> {
      if(t.getId().equalsIgnoreCase("t1"))
      {
        temperatureT1.setValue(t.toString());
      }
      else if(t.getId().equalsIgnoreCase("t2"))
      {
        temperatureT2.setValue(t.toString());
      }
      //else if(t.getId().equalsIgnoreCase("t3"))
      {
       // temperatureT3.setValue(t.toString());
      }
    });
  }

  public StringProperty getTemperatureT1()
  {
    return temperatureT1;
  }
  public StringProperty getTemperatureT2()
  {
    return temperatureT2;
  }
  //public StringProperty getTemperatureT3()
  {
   // return temperatureT3;
  }

  public TemperatureModel getTm()
  {
    return tm;
  }

  public void clear()
  {
    powerPosition.setValue("");
    temperatureT1.setValue("");
    temperatureT2.setValue("");
  }

  public void setPower(String power)
  {
    powerPosition.setValue(power);
  }
}
