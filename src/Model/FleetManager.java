package Model;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.sql.*;

import Model.UpgradeCount;
import Model.AvailablePilots.PilotsByShip;
import Model.Enums.Faction;
import Model.Enums.ShipType;
import Model.Enums.UpgradeType;
import View.Viewer;

public class FleetManager extends Observable {
	/************************************************************
	 * Handles the logic of adding Enhancements to ships
	 * Handles loading and saving of game data
	 ************************************************************/
	/*
	 * To load data
	 * have first xml tag be expansion
	 * from start up screen, get how many of each expansion is owned
	 * Load that tag that many times before going on to next expansion tag
	 * 
	 */
	
	private SelectedPilotViewModel SelectedPilot;
	private SelectedUpgradeViewModel SelectedUpgrade;
	private FleetStorage FleetStorage;
	private Model.Enums.Faction CurrentFaction;
	private String DisplayMessage;
	final private int MAXPOINTS;
	
	public FleetManager()
	{
		CurrentFaction = Model.Enums.Faction.REBELLION;
		FleetStorage = new FleetStorage();
		SelectedPilot = new SelectedPilotViewModel();
		SelectedUpgrade = new SelectedUpgradeViewModel();
		MAXPOINTS = 100;
	}
	
	public FleetManager(FleetStorage fleetStorage)
	{
		CurrentFaction = Model.Enums.Faction.REBELLION;
		FleetStorage = fleetStorage;
		SelectedPilot = new SelectedPilotViewModel();
		SelectedUpgrade = new SelectedUpgradeViewModel();
		MAXPOINTS = 100;
	}
	
	public FleetManager(int maxpoints)
	{
		CurrentFaction = Model.Enums.Faction.REBELLION;
		FleetStorage = new FleetStorage();
		SelectedPilot = new SelectedPilotViewModel();
		SelectedUpgrade = new SelectedUpgradeViewModel();
		MAXPOINTS = maxpoints;
	}
	
	public FleetManager(FleetStorage fleetStorage, int maxpoints)
	{
		CurrentFaction = Model.Enums.Faction.REBELLION;
		FleetStorage = fleetStorage;
		MAXPOINTS = maxpoints;
	}
	
	//gets the fleet storage
	public FleetStorage FleetStorage()
	{
		return FleetStorage;
	}
	
	//-------------------------------------------------------------------
	//	MANAGE FACTION
	//-------------------------------------------------------------------
	public Model.Enums.Faction GetCurrentFaction()
	{
		return CurrentFaction;
	}
	
	//Sets current faction to Rebellion
	public void SetFactionRebellion()
	{
		SetFaction(Model.Enums.Faction.REBELLION);
	}
	
	//Sets current faction to Empire
	public void SetFactionEmpire()
	{
		SetFaction(Model.Enums.Faction.EMPIRE);
	}
	
	//Sets current faction to given Faction
	private void SetFaction(Model.Enums.Faction faction)
	{
		CurrentFaction = faction;
		UnselectPilot();
		Notify();
	}
	
	//----------------------------------------------------------------
	// UpgradeSlot Validation
	//----------------------------------------------------------------

	//Checks if a given upgrade is available to a pilot
	public boolean IsPilotUpgradeValid(Pilot pilot, Upgrade toCheck)
	{
		return pilot.IsUpgradeValid(toCheck.Type());
	}
	
	//returns ValidUpgradeSlots for the SelectedPilot
	public List<Integer> GetValidUpgradeSlots()
	{
		return GetValidUpgradeSlots(SelectedUpgrade.GetSelectedUpgrade());
	}
	
	//returns ValidUpgradeSlots for the SelectedPilot
	public List<Integer> GetValidUpgradeSlots(UpgradeCount upgrade)
	{
		return SelectedPilot.GetSelectedPilot().GetValidUpgradeSlots(upgrade);
	}
	
	//returns ValidUpgradeSlots for a specified Pilot
	public List<Integer> GetValidUpgradeSlots(Pilot pilot, UpgradeCount upgrade)
	{
		return pilot.GetValidUpgradeSlots(upgrade);
	}
	
	//----------------------------------------------------------------
	// UpgradeSlot Management
	//----------------------------------------------------------------
	
	//gets the selected Upgrade
	public SelectedUpgradeViewModel SelectedUpgrade()
	{
		return SelectedUpgrade;
	}
	
	
	//Handles the selection of an Upgrade
	public void SelectUpgrade(int typeIndex, int upgradeIndex)
	{		
		/*
		UpgradeCount previouslySelected = SelectedUpgrade.GetSelectedUpgrade();
		UpgradeCount newlySelected = FleetStorage.AvailableUpgrades().get(typeIndex).Upgrades().get(upgradeIndex);
		if (previouslySelected == newlySelected)
		{
			return;
		}*/
		SelectedUpgrade.SelectUpgrade(FleetStorage.AvailableUpgrades().get(typeIndex).Upgrades().get(upgradeIndex));

		//Notify();
	}
	
	//Returns the cost difference between the selected upgrade and the current upgrade
	public int SwapUpgradeDifference (int index)
	{
		int newCost = SelectedUpgrade.GetSelectedUpgrade().Upgrade().Cost();
		int oldCost = SelectedPilot.GetSelectedPilot().Upgrades[index].Upgrade.Upgrade().Cost();
		return newCost - oldCost;
	}
	
	//Returns the string for ApplyUpgradeButton
	public String GetApplyUpgradeButtonText(int index)
	{
		String text = "Apply";
		
		if (ShouldEnableApplyUpgradeButton(index))
		{
			text += " : ";
			int diff = SwapUpgradeDifference(index);
			if (diff > 0)
			{
				text += "+";
			}
			text +=  diff + "pts";
		}
		
		return text;
	}
	
	//returns if the ApplyUpgradeButton should be enabled
	public boolean ShouldEnableApplyUpgradeButton(int index)
	{
		//Check Title for specific ship type

		boolean show;
		UpgradeCount upgradeSelected = SelectedUpgrade.GetSelectedUpgrade();
		UpgradeCount upgradeSlot = SelectedPilot.GetSelectedPilot().Upgrades[index].Upgrade;
		
		//Don't allow adding Upgrades unless the pilot is in the roster
		show = GetRoster().Roster().contains(SelectedPilot.GetSelectedPilot());
		if (!show)
		{
			return show;
		}
		
		//There must be enough of the selected Upgrade unused
		show = upgradeSelected.Count() > 0;
		if (!show)
		{
			return show;
		}
		
		//Check if adding Upgrade would exceed points
		show = show && (MAXPOINTS - (GetFleetCost() + upgradeSelected.Upgrade().Cost) >= 0);
		if (!show)
		{
			DisplayMessage = "Adding will exceed point allowance.";
			return show;
		}

		//Match Upgrade types
		show = show && upgradeSelected.Upgrade().Type() == upgradeSlot.Upgrade().Type();
		if (!show)
		{
			return show;
		}
		
		//Disable if same Upgrade as slot holds
		show = show && !(upgradeSelected.Upgrade() == upgradeSlot.Upgrade());
		if (!show)
		{
			return show;
		}
		
		//Match Faction
		Model.Enums.Faction upgradeFaction = upgradeSelected.Upgrade().Faction();
		show = show && (upgradeFaction == Model.Enums.Faction.NONE || upgradeFaction == CurrentFaction);
		
		if (!show)
		{	
			DisplayMessage = "Upgrade Faction mismatch.";
			//Notify();
			return show;
		}
		
		//Check if Unique already in use
		show = show && !IsUniqueUpgradeUsed();
		
		return show;
	}
	
	//Checks if a unique Upgrade has already been assigned
	private boolean IsUniqueUpgradeUsed()
	{
		UpgradeCount selected= SelectedUpgrade.GetSelectedUpgrade();
		if (!selected.Upgrade().IsUnique())
		{
			return false;
		}
		ArrayList<Pilot> roster = FleetStorage.GetRoster(CurrentFaction).Roster();
		for (int i = 0; i < roster.size(); i ++)
		{
			Pilot pilot = roster.get(i);
			if (selected.Upgrade().Name().equals(pilot.Name))
			{
				return true;
			}
			
			for (int j = 0; j < pilot.Upgrades.length; j ++)
			{
				if (selected.Upgrade().Name.equals(pilot.Upgrades[j].Upgrade.Upgrade().Name))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	//Returns the string for ApplyUpgradeButton
	public String GetRemoveUpgradeButtonText(int index)
	{
		String text = "Remove";
		if (ShouldEnableRemoveUpgradeButton(index))
		{
			text += " : -" + SelectedPilot.GetSelectedPilot().Upgrades[index].Upgrade.Upgrade().Cost() + "pts";
		}
		
		return text;
	}
	
	//returns if the RemoveUpgradeButton should be enabled
	public boolean ShouldEnableRemoveUpgradeButton(int index)
	{
		return !(SelectedPilot.GetSelectedPilot().Upgrades[index].Upgrade.Upgrade().Name().equals("NONE"));
	}
	
	//Default ApplyUpgrade - Applies the Selected 
	public void ApplyUpgrade(int index)
	{
		try
		{
			//index is index of Pilot's UpgradeSlot the 
			UpgradeCount removed = SelectedPilot.ApplyUpgrade(SelectedUpgrade.GetSelectedUpgrade(), index);
			SelectedUpgrade.GetSelectedUpgrade().Decrease();
			removed.Increase();
			Notify();
		}
		catch(Exception e)
		{
			//Notify();
		}
	}
	
	//Default RemoveUpgrade - removes an indexed Upgrade from the selected pilot
	public void RemoveUpgrade(int index)
	{
		try
		{
			SelectedPilot.RemoveUpgrade(index).Increase();
			Notify();
		}
		catch(Exception e)
		{
			Exception test = e;
		}
	}
	
	//----------------------------------------------------------------
	// Pilot Management
	//----------------------------------------------------------------
	
	//gets the selected Pilot
	public SelectedPilotViewModel SelectedPilot()
	{
		return SelectedPilot;
	}
	
	//Gets the available pilots based on faction
	public List<PilotsByShip> AvailablePilots()
	{
		if (CurrentFaction == Model.Enums.Faction.REBELLION)
		{
			return FleetStorage.AvailableRebelPilots();
		}
		else
		{
			return FleetStorage.AvailableEmpirePilots();
		}
	}
	
	//Returns the text for adding a Pilot to the roster
	public String GetAddPilotButtonText()
	{
		Pilot pilot = SelectedPilot.GetSelectedPilot();
		return "ADD: " + pilot.Name + " : +" + pilot.Cost + "pts";
	}
	
	//Determines if the Pilot is available for add
	public boolean CanPilotBeAdded()
	{
		boolean show = true;
		
		Pilot pilotSelected = SelectedPilot.GetSelectedPilot();
		//UpgradeCount upgradeSlot = SelectedPilot.GetSelectedPilot().Upgrades[index].Upgrade;
		
		//There must be enough of the selected Upgrade unused
		/*
		show = upgradeSelected.Count() > 0;
		if (!show)
		{
			return show;
		}
		*/
		//Check if adding Upgrade would exceed points
		show = show && (MAXPOINTS - (GetFleetCost() + pilotSelected.Cost) >= 0);
		if (!show)
		{
			DisplayMessage = "Adding will exceed point allowance.";
			return show;
		}

		/*
		//Is there enough of ship type available
		show = show && pilotSelected.Ship(). == upgradeSlot.Upgrade().Type();
		if (!show)
		{
			return show;
		}
		*/
		
		//Match Faction
		show = show && (pilotSelected.Faction() == CurrentFaction);
		
		if (!show)
		{	
			DisplayMessage = "Upgrade Faction mismatch.";
			return show;
		}
		
		show = show && !IsUniquePilotUsed();
		
		return show;
	}
	
	//Checks if a unique Upgrade has already been assigned
		private boolean IsUniquePilotUsed()
		{
			Pilot selected= SelectedPilot.GetSelectedPilot();
			if (!selected.IsUnique())
			{
				return false;
			}
			ArrayList<Pilot> roster = FleetStorage.GetRoster(CurrentFaction).Roster();
			for (int i = 0; i < roster.size(); i ++)
			{
				Pilot pilot = roster.get(i);
				if (selected.Name().equals(pilot.Name))
				{
					DisplayMessage = "Pilot already is use.";
					return true;
				}
				
				for (int j = 0; j < pilot.Upgrades.length; j ++)
				{
					if (selected.Name.equals(pilot.Upgrades[j].Upgrade.Upgrade().Name))
					{
						DisplayMessage = "Pilot already is use.";
						return true;
					}
				}
			}
			
			return false;
		}
	
	//Adds the selected pilot to the roster
	public void AddPilotToRoster()
	{
		Pilot toAdd = new Pilot(SelectedPilot.GetSelectedPilot());
		int pilotIndex = FleetStorage.GetRoster(CurrentFaction).AddPilot(toAdd);
		SelectRosterPilot(pilotIndex);
		Notify();
	}
	
	//Gets the current faction's roster
	public PilotRosterModel GetRoster()
	{
		return FleetStorage.GetRoster(CurrentFaction);
	}
	
	//Adds the selected pilot to the roster
	public void RemovePilotFromRoster()
	{
		ClearPilotUpgrades();
		//Pilot removed = SelectedPilot.GetSelectedPilot();
		FleetStorage.GetRoster(CurrentFaction).Roster().remove(SelectedPilot.GetSelectedPilot());
		Notify();
	}
	
	//Clears the selected Pilot's upgrades
	public void ClearPilotUpgrades()
	{
		Pilot pilot = SelectedPilot.GetSelectedPilot();
		//UpgradeSlot[] upgrades = SelectedPilot.GetSelectedPilot().Upgrades();
		try
		{
			for (int i = 0; i < SelectedPilot.GetSelectedPilot().Upgrades().length; i ++)
			{
				pilot.RemoveUpgrade(i).Increase();
			}
		}
		catch(Exception e)
		{
			
		}
		Notify();
	}
	
	//select a pilot from the available pilots list
	public void SelectAvailablePilot(int shipIndex, int pilotIndex)
	{
		/*
		Pilot previouslySelected = SelectedPilot.GetSelectedPilot();
		Pilot newlySelected = (Pilot)AvailablePilots().get(shipIndex).Pilots().get(pilotIndex).Upgrade();
		if (previouslySelected == newlySelected)
		{
			return;
		}
		*/
		//SelectedPilot.SelectPilot(newlySelected);
		SelectedPilot.SelectPilot((Pilot)AvailablePilots().get(shipIndex).Pilots().get(pilotIndex).Upgrade());
		Notify();
	}
	
	public void SelectRosterPilot(int index)
	{
		SelectedPilot.SelectPilot(FleetStorage.GetRoster(CurrentFaction).Roster().get(index));
		Notify();
	}
	
	public void UnselectPilot()
	{
		SelectedPilot = new SelectedPilotViewModel();
		Notify();
	}

	

	
	//----------------------------------------------------------------
	// Fleet Cost Management
	//----------------------------------------------------------------
	//Returns the current faction's fleet cost
	public int GetFleetCost()
	{
		return FleetStorage.GetFleetCost(CurrentFaction);
	}
	
	
	//Determines if the current fleet cost exceed the maximum allowance
	public boolean ExceedsMaxCost()
	{
		return FleetStorage.GetFleetCost(CurrentFaction) > MAXPOINTS;
	}	
	
	//Handle Observable functions
	private void Notify()
	{
		setChanged();
		notifyObservers();
	}
}
