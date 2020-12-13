package Radiator;

public class Radiator
{
  private RadiatorState rs;

  public Radiator()
  {
    rs = new OffState();
  }

  public void turnUp()
  {
    rs.turnUp(this);
  }

  public void turnDown()
  {
    rs.turnDown(this);
  }

  public int getPower()
  {
    return rs.getPower();
  }

  public void setPowerState(RadiatorState state)
  {
    rs = state;
  }

  public String toString()
  {
    return " " + getPower();
  }
}
