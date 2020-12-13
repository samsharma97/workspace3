import Core.ModelFactory;
import Core.ViewHandler;
import Core.ViewModelFactory;
import Mediator.TemperatureModel;
import Radiator.Radiator;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);

    vh.start(primaryStage);
    updateAll(mf.getTemperatureModel());
  }

  private void updateAll(TemperatureModel tm)
  {
    Radiator radiator = new Radiator();
    int p = radiator.getPower();
    Thread t1 = new Thread(new Thermometer("t1", 15, 1,p, tm));
    Thread t2 = new Thread(new Thermometer("t2", 15, 7,p, tm));
    t1.setDaemon(true);
    t2.setDaemon(true);
    t1.start();
    t2.start();
  }
}
