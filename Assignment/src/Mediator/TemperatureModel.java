package Mediator;
import chatSystem.Util.PropertyChangeSubject;

public interface TemperatureModel extends PropertyChangeSubject
{
  public void addTemperature(String id, double temperature);
  public void turnUp();
  public void turnDown();
  public int getPowerPosition();
}
