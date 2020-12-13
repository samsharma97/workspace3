import Mediator.TemperatureModel;
import Radiator.Radiator;

public class Thermometer implements Runnable
{
  private String id;
  private double t;
  private int d;
  private TemperatureModel tm;
  private double min;
  private double max;
  private int p;

  public Thermometer(String id, double t, int d, int p, TemperatureModel tm)
  {
    this.id = id;
    this.t = t;
    this.d = d;
    this.tm = tm;
    this.p = p;
  }

  public Thermometer(double min, double max)
  {
    this.min = min;
    this.max = max;
  }

  private int getP()
  {
    Radiator r = new Radiator();
    p = r.getPower();
    return p;
  }

  private double internalTemperature(double t, int p, int d, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;

    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }

    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);

    return t;
  }

  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  public void run()
  {
    while(true)
    {
      double t1 = internalTemperature(t, getP(), 1,0, 6);
      double t2 = internalTemperature(t, getP(), 7, 0, 6);
      double t3 = externalTemperature(0, 0, 20);

      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
      }
      tm.addTemperature(id, t1);
      tm.addTemperature(id,t2);
      tm.addTemperature(id, t3);
    }
  }
}