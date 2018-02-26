package Model.AvailablePilots;

import java.util.ArrayList;
import java.util.List;

import Model.UpgradeCount;
import Model.Enums.ShipType;

public class PilotsByShip {

	private ShipType Ship;
	private String Name;
	private List<UpgradeCount> Pilots;
	
	public PilotsByShip(Model.Enums.ShipType ship)
	{
		Ship = ship;			
		Pilots = new ArrayList<UpgradeCount>();
	}
	
	public PilotsByShip(Model.Enums.ShipType ship, String name)
	{
		Ship = ship;			
		Name = name;
		Pilots = new ArrayList<UpgradeCount>();
	}
	
	//Returns the pilot List
	public List<UpgradeCount> Pilots()
	{
		return Pilots;
	}
	
	//Returns the ship type
	public Model.Enums.ShipType Ship()
	{
		return Ship;
	}
	
	//Returns the ship type as a string
	public String ShipName()
	{
		if (Name != null && !Name.isEmpty())
		{
			return Name;
		}
		return Ship.toString();
	}
	
	public void AddPilot(UpgradeCount pilot)
	{
		Pilots.add(pilot);
	}

}
