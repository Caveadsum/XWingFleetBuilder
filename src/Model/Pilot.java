package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Model.Enums.*;

public class Pilot extends Upgrade implements Observer {
	
	UpgradeSlot[] Upgrades;
	private final int NONPILOTUPGRADESLOTS = 2;
	private final ShipType Ship;
	
	//have collections of authorized and loaded Enhancements
	public Pilot()
	{
		super(UpgradeType.Pilot);
		Upgrades = new UpgradeSlot[1];
		Upgrades[0] = new UpgradeSlot(new UpgradeCount(new Upgrade(UpgradeType.NONE), 0));
		Ship = ShipType.NONE;
	}

	public Pilot(int c, String e, String n, boolean u, UpgradeCount[] a, ShipType s, Faction f)
	{
		super(c, e, n, u, UpgradeType.Pilot, f);
		Ship = s;
		InitializeUpgrades(a);
	}
	
	public Pilot(Pilot pilot)
	{
		Cost = pilot.Cost;
		Effect = pilot.Effect;
		Name = pilot.Name;
		Unique = pilot.Unique;
		Upgrades = new UpgradeSlot[pilot.Upgrades.length];
		System.arraycopy(pilot.Upgrades, 0, Upgrades, 0, pilot.Upgrades.length);
		Ship = pilot.Ship;
		Type = pilot.Type;
		Faction = pilot.Faction;
	}
	
	private UpgradeSlot[] CopySlots(UpgradeSlot[] original)
	{
		UpgradeSlot[] copy = new UpgradeSlot[original.length];
		
		
		return copy;
	}
	
	//Initializes an empty enhancement loadout
	private void InitializeUpgrades(UpgradeCount[] a)
	{
		int length = a.length;
		Upgrades = new UpgradeSlot[length];
		for (int i = 0; i < length; i ++)
		{
			Upgrades[i] = new UpgradeSlot(a[i]);
		}		 
	}
	
	//Returns the pilot's ship type
	public ShipType Ship()
	{
		return Ship;
	}
	
	//Returns the pilot's upgrades
	public UpgradeSlot[] Upgrades()
	{
		return Upgrades;
	}
	
	//Sets an upgrade in a specified index
	public UpgradeCount ApplyUpgrade(UpgradeCount upgrade, int index) throws Exception
	{
		if (index > Upgrades.length || index < 0)
		{
			throw new Exception("Index not available");
		}
		
		if (Upgrades[index].Upgrade.Upgrade().Type() != upgrade.Upgrade().Type())
		{
			throw new Exception ("Mismatched Upgrade");
		}
		
		return Upgrades[index].ApplyUpgrade(upgrade);
	}
	
	//Gets the valid slots for an upgrade type
	public ArrayList<Integer> GetValidUpgradeSlots(UpgradeCount upgrade)
	{
		ArrayList<Integer> validSlots = new ArrayList<Integer>();
		for (int i = 0; i<Upgrades.length-1; i++)
		{
			if (Upgrades[i].Upgrade.Upgrade().Type() == upgrade.Upgrade().Type())
			{
				validSlots.add(i);
			}
		}
		
		return validSlots;
	}
	
	//Determines if a given upgrade is valid for the pilot
	public boolean IsUpgradeValid(UpgradeType type)
	{
		for (int i = 0; i<Upgrades.length - 1; i++)
		{
			if (type == Upgrades[i].Upgrade.Upgrade().Type())
			{
				return true;
			}
		}
		return false;
	}
	
	//Gets an upgrade at a specified index
	public UpgradeSlot GetUpgradeSlot(int index) throws Exception
	{
		if (index > Upgrades.length || index < 0)
		{
			throw new Exception("Index not available");
		}
		
		return Upgrades[index];
	}
		
	//Removes an upgrade
	public UpgradeCount RemoveUpgrade(int index) throws Exception
	{
		if (index > Upgrades.length -1)
		{
			throw new Exception("Index not available");
		}
		return Upgrades[index].RemoveUpgrade(index);		
	}
	
	//Adds a new UpgradeSlot
	public void AddUpgradeSlot(UpgradeCount upgrade)
	{
		//this is for the rare card that allows a pilot an additional upgrade card
		//i.e. Slave I adds Photon Torpedo
		UpgradeSlot[] temp = new UpgradeSlot[Upgrades.length+1];
		int i = 0;
		for(; i < Upgrades.length; i ++)
		{
			temp[i] = Upgrades[i];
		}
		
		temp[i] = new UpgradeSlot(upgrade);
		Upgrades = temp;
	}
	
	//Remove an UpgradeSlot
	public void RemoveUpgradeSlot()
	{
		//this is to undo AddUpgradeSlot
		UpgradeSlot[] temp = new UpgradeSlot[Upgrades.length-1];
		
		for (int i = 0; i < Upgrades.length-2; i ++)
		{
			temp[i] = Upgrades[i];
		}
		
		Upgrades = temp;
	}
	
	//Returns the Cost of the pilot and its Upgrades
	public int Cost()
	{
		int cost = Cost;
		for (int index = 0; index < Upgrades.length; index ++)
		{
			if (Upgrades[index].Applied)
			{
				cost += Upgrades[index].Upgrade.Upgrade().Cost;
			}
		}
		
		return cost;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


}
