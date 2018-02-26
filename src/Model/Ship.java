package Model;

import java.util.ArrayList;
import java.util.List;

import Model.Enums.ShipType;

public class Ship {
	//no need, manager will just have list of pilots arranged by ship type
	Pilot ThePilot;
	List<Pilot> AllowedPilots;
	ShipType ShipType;
	String Name;
	//icon
	
	public Ship()
	{
	}
	
	public Ship(ShipType type, List<Pilot> pilots)
	{
		ShipType = type;
		AllowedPilots = new ArrayList<Pilot>(pilots);
		BuildName();
	}
	
	//Assigns a ship name based on Type
	private void BuildName()
	{
		switch(ShipType)
		{
		//TieFighter, TieAdvanced, YT1300, Firespray1, Hwk290, Lambda
			case XWing:
			{
				Name = "X-Wing";
				break;
			}
			case TieFighter:
			{
				Name = "TIE Fighter";
				break;
			}
			case TieAdvanced:
			{
				Name = "TIE Advanced";
				break;
			}
			case YT1300:
			{
				Name = "YT-1300";
				break;
			}
			case Firespray31:
			{
				Name = "Firespray-31";
				break;
			}
			case Hwk290:
			{
				Name = "HWK-290";
				break;
			}
			case Lambda:
			{
				Name = "Lamda Class Shuttle";
				break;
			}		
			default:
			{
				Name = "No Ship selected.";
				break;
			}
		}
	}
	
	//Assigns a pilot to the ship
	public void AssignPilot(Pilot p)
	{
		ThePilot = p;
	}
	
	//Gets the assigned pilot
	public Pilot Pilot()
	{
		return ThePilot;
	}
	/*
	//Gets the ship upgrades
	public UpgradeSlot[] Upgrades()
	{
		return Upgrades;
	}
	*/
	//Gets the pilot's upgrades
	public UpgradeSlot[] PilotUpgrades()
	{
		return ThePilot.Upgrades;
	}
	/*
	//Adds an Enhancement to the Ship
	public void ApplyShipUpgrade(Upgrade toAdd, int index) throws Exception
	{
		
		//check if pilot has been added.
		//if there is a pilot, add enhancement to the pilot, unless Modification or Title
		Upgrades[index].Upgrade = toAdd;
		Upgrades[index].Applied = true;
	}
	
	//Removes a ship upgrade
	public Upgrade RemoveShipUpgrade(int index) throws Exception
	{
		if (index >= Upgrades.length)
		{
			throw new Exception ("Index unavailable");
		}
		
		Upgrade removed = Upgrades[index].Upgrade;
		Upgrades[index].Reset();
		return removed;
	}
	*/
	//Adds an Upgrade to the pilot
	/*
	public void ApplyPilotUpgrade(Upgrade toAdd, int index) throws Exception
	{
		ThePilot.ApplyUpgrade(toAdd, index);
	}
	
	//Removes an upgrade from the pilot
	public Upgrade RemovePilotUpgrade(int index) throws Exception
	{
		return ThePilot.RemoveUpgrade(index);
	}
	*/
	//returns the total assigned enhancement points
	public int GetAssignedPoints()
	{
		/*
		int tally = 0;
		for (int i = 0; i < Upgrades.length-1; i++)
		{
			tally += Upgrades[i].Upgrade.Cost();
		}
		
		tally += ThePilot.Cost();
		
		return tally;
		*/
		return ThePilot.Cost();
	}
	

}
