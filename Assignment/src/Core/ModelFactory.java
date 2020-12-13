package Core;
import Mediator.TemperatureModel;
import Mediator.TemperatureModelManager;
public class ModelFactory
{
  private TemperatureModel tm;

  public TemperatureModel getTemperatureModel()
  {
    if(tm == null)
    {
      tm = new TemperatureModelManager();
    }
    return tm;
  }
}
