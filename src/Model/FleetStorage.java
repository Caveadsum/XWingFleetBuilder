	package Model;

	import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import Model.AvailablePilots.AvailablePilotsViewModel;
import Model.AvailablePilots.PilotsByShip;
import Model.AvailableUpgrades.AvailableUpgradesViewModel;
import Model.AvailableUpgrades.UpgradesByType;
import Model.Enums.Faction;
import Model.Enums.ShipType;
import Model.Enums.UpgradeType;
	//import Model.FleetManager.UpgradeCount;
import View.Viewer;
	
	
public class FleetStorage extends Observable{


		/* Go back to basics.  What does the user want to accomplish?

	As a fleet builder, I want a tool that can help me manage the cost of my fleet and what upgrades are available.

	Requirements:
	-Keep track of and display current build cost : Track done
	-Keep track of and display current upgrades applied : Track done
	-Keep track of and display available upgrades not applied

	Optional:
	-Allow user to input a maximum cost allowance
	-Make recommendations based on left over cost and perceived power and synergy with already applied upgrades

	Design Considerations:
	-Observer pattern
		 */

		

			//private ArrayList<Pilot> AddedPilots;//have dictionary key is shiptype, value is list of pilots? so pilots can choose a ship, then see that ships options
			private PilotRosterModel RebelRoster;
			private PilotRosterModel EmpireRoster;
	
			//private List<Upgrade> AvailableUpgrades;  //perhaps an arraylist of delineated Upgrades...Titles are indeces 0-4, Modifications 5-10, etc.
			//or dictionary of Upgrade keys and int values

			
			private AvailablePilotsViewModel AvailablePilots;
			private AvailableUpgradesViewModel AvailableUpgrades;
			
			//private Faction PlayerFaction;
			//private List<Expansion>
			
			private Viewer View;
			
			public FleetStorage()
			{
				//AddedPilots = new ArrayList<Pilot>();
				RebelRoster = new PilotRosterModel();
				EmpireRoster = new PilotRosterModel();
				AvailablePilots = new AvailablePilotsViewModel();
				LoadUpgrades();
			}
			
			public void SetView (Viewer viewer)
			{
				View = viewer;
			}

			//------------------------------------------------------------------------
			//  UpgradeCount Lists
			//------------------------------------------------------------------------
			//Loads the Upgrades
			private void LoadUpgrades()
			{
				AvailableUpgrades = new AvailableUpgradesViewModel();
							
				//Load Enhancement List
				//Save Enhancement List?
				//load upgrades based on selected faction and expansions
				InitializeHardCodedUpgrade();
			}
					
			//Retrieves the Available Upgrades
			public List<UpgradesByType> AvailableUpgrades()
			{
				return AvailableUpgrades.AvailableUpgrades();
			}
									
			//----------------------------------------------------------------------------
			//	Pilot Roster Management
			//----------------------------------------------------------------------------
			
			//Gets the available pilots
			public List<PilotsByShip> AvailableRebelPilots()
			{
				return AvailablePilots.AvailableRebelPilots();
			}
			
			//Gets the available pilots
			public List<PilotsByShip> AvailableEmpirePilots()
			{
				return AvailablePilots.AvailableEmpirePilots();
			}
			
			//Adds a pilot to the roster
			public int AddPilot(Model.Enums.Faction faction, Pilot p)
			{
				Pilot toAdd = new Pilot(p);
				//AddedPilots.add(toAdd);
				return GetRoster(faction).AddPilot(toAdd);
				
			}
			
			//Adds a pilot to the roster
			public void RemovePilot(Model.Enums.Faction faction, Pilot p)
			{
				GetRoster(faction).RemovePilot(p);
				//AddedPilots.remove(p);
				try
				{
					//IncrementUpgradeCount(AvailablePilots.AvailablePilots(), p);	
				}
				catch (Exception e)
				{
					//set warning
				}
			}

			//Gets the pilot roster
			//public ArrayList<Pilot> AddedPilots()
			public PilotRosterModel GetRoster(Model.Enums.Faction faction)
			{
				if (faction == Model.Enums.Faction.REBELLION)
				{
					return RebelRoster;
				}
				return EmpireRoster;
			}

			//--------------------------------------------------------------
			//	Costs
			//--------------------------------------------------------------
			
			//Gets the current fleet cost total
			public int GetFleetCost(Model.Enums.Faction faction)
			{
				return GetRoster(faction).FleetCost();
			}
			

			
			//initial hard coded Upgrade list - replace with file loader
			private void InitializeHardCodedUpgrade()
			{
			}
}
