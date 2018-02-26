package Controller;

public class FleetCommander {
	
	private Model.Enums.Faction Faction;
	
	public FleetCommander(Model.Enums.Faction faction)
	{
		Faction = faction;
	}
	
	//returns the Commander's faction
	public Model.Enums.Faction Faction()
	{
		return Faction;
	}

}
