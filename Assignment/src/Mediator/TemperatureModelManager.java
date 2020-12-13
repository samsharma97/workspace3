package Mediator;

import Model.Temperature;
import Model.TemperatureList;
import Radiator.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList tempList;
  private Radiator radiator;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public TemperatureModelManager()
  {
    tempList = new TemperatureList();
    radiator = new Radiator();
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temp = new Temperature(id, value);
    support.firePropertyChange("Temperature", null, temp);
  }

  @Override public void turnUp()
  {
    radiator.turnUp();
  }

  @Override public void turnDown()
  {
    radiator.turnDown();
  }

  @Override public int getPowerPosition()
  {
    return radiator.getPower();
  }
}

