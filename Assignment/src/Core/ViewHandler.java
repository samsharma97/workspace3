package Core;
import View.Control.ControlViewController;
import View.Show.ShowViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class ViewHandler
{
  private Stage currentStage;
  private Scene showScene;
  private Scene controlScene;

  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start( Stage primaryStage)
  {
    currentStage = primaryStage;
    openShowView();
  }

  public void openShowView()
  {
    if(showScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/Show/ShowView.fxml"));
        Parent root = loader.load();

        ShowViewController ctrl = loader.getController();
        ctrl.init(this,vmf.getShowVM(), vmf.getControlVM());
        currentStage.setTitle("Temperature");
        showScene = new Scene(root);
      }
      catch(IOException e){
        e.printStackTrace();
      }
    }
    currentStage.setScene(showScene);
    currentStage.show();
  }

  public void openControlView()
  {
    if(controlScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/Control/ControlView.fxml"));
        Parent root = loader.load();

        ControlViewController ctrl = loader.getController();
        ctrl.init(this,vmf.getControlVM(), vmf.getShowVM());
        currentStage.setTitle("Radiator Control");
        controlScene = new Scene(root);
      }
      catch(IOException e){
        e.printStackTrace();
      }
    }
    currentStage.setScene(controlScene);
    currentStage.show();
  }
}
