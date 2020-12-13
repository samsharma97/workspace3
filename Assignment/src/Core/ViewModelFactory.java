package Core;
import View.Control.ControlViewModel;
import View.Show.ShowViewModel;
public class ViewModelFactory
{
  private ModelFactory mf;
  private ShowViewModel showVM;
  private ControlViewModel controlVM;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public ShowViewModel getShowVM()
  {
    if(showVM == null)
    {
      showVM = new ShowViewModel(mf.getTemperatureModel());
    }
    return showVM;
  }

  public ControlViewModel getControlVM()
  {
    if(controlVM == null)
    {
      controlVM = new ControlViewModel(mf.getTemperatureModel());
    }
    return controlVM;
  }
}
