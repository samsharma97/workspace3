package Radiator;

public class Power3State implements RadiatorState, Runnable
{
  private static int POWER = 3;
  private Thread t;
  private Radiator radiator;

  public Power3State(Radiator radiator)
  {
    this.radiator=radiator;
    t= new Thread(this);
    t.setDaemon(true);
    t.start();
  }

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {
    t.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return 3;
  }

  @Override public void run()
  {
    try
    {
      Thread.sleep(10000);
      radiator.setPowerState(new Power2State());
    }
    catch (InterruptedException e)
    {
    }
  }
}

