package Model.AvailableUpgrades;

import java.util.ArrayList;
import java.util.List;

import Model.UpgradeCount;
import Model.Enums.ShipType;
import Model.Enums.UpgradeType;

public class UpgradesByType {
	private UpgradeType Type;
	private String Name;
	private List<UpgradeCount> Upgrades;
	
	public UpgradesByType(Model.Enums.UpgradeType type)
	{
		Type = type;			
		Upgrades = new ArrayList<UpgradeCount>();
	}
	
	public UpgradesByType(Model.Enums.UpgradeType type, String name)
	{
		Type = type;			
		Name = name;
		Upgrades = new ArrayList<UpgradeCount>();
	}
	
	//Returns the pilot List
	public List<UpgradeCount> Upgrades()
	{
		return Upgrades;
	}
	
	//Returns the ship type
	public Model.Enums.UpgradeType Type()
	{
		return Type;
	}
	
	//Returns the ship type as a string
	public String TypeName()
	{
		if (Name != null && !Name.isEmpty())
		{
			return Name;
		}
		return Type.toString();
	}
	
	public void AddUpgrade(UpgradeCount upgrade)
	{
		Upgrades.add(upgrade);
	}
}
