package Model;

import java.util.Observable;

public class UpgradeCount extends Observable{
	private Upgrade Upgrade;
	private int Count;
	private final int MAXCOUNT;
	
	public UpgradeCount(Upgrade upgrade, int count)
	{
		Upgrade = upgrade;
		MAXCOUNT = count;
		Count = MAXCOUNT;
	}
	
	public Upgrade Upgrade()
	{
		return Upgrade;
	}
	
	//Sets the number of Upgrades
	public void SetCount(int count) throws Exception
	{
		if (count < 0 || count > MAXCOUNT)
		{
			throw new Exception ("Invalid Upgrade count");
		}
		Count = count;
		Notify();
	}
	
	//Gets the number of Upgrades
	public int Count()
	{
		return Count;
	}
	
	//Increases the number of Upgrades by 1
	public void Increase() throws Exception
	{
		if (Upgrade.Name().equals("NONE"))
		{
			return;
		}
		if (Count >= MAXCOUNT)
		{
			throw new Exception ("Increasing will exceed max Upgrade count");
		}
		Count ++;
		Notify();
	}
	
	//Decreases the number of Upgrades by 1
	public void Decrease() throws Exception
	{
		if (Upgrade.Name().equals("NONE"))
		{
			return;
		}
		if (Count <= 0)
		{
			throw new Exception ("No upgrades available to decrement");
		}
		Count --;
		Notify();
	}
	
	public void Notify()
	{
		setChanged();
		notifyObservers();
	}
}
