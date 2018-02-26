package Controller;

import java.awt.event.ActionEvent;
import java.util.Observable;

import Model.FleetManager;
import Model.FleetStorage;
import Model.Pilot;
import Model.Upgrade;
import View.Viewer;

public class Control extends Observable{
	
	private FleetManager FleetManager;
	private FleetStorage FleetStorage;
	private Viewer Viewport;
	private FleetCommander RebelCommander;
	private FleetCommander ImperialCommander;
	private Upgrade SelectedUpgrade;
	private Pilot SelectedPilot;
	
	/*
	 * -Only display legal upgrades
  -Depends on Expansions included
  -Depends on Faction
  -Depends on currently selected ship/pilot?
-Display cost of an upgrade
	 */
	
	public Control()
	{
		SetCommanders();
		
	}
	
	public Control(FleetStorage model, Viewer viewer)
	{
		FleetStorage = model;
		Viewport = viewer;
		SetCommanders();
	}
	
	public FleetManager GetFleetManager()
	{
		return FleetManager;
	}
	
	public void SetFleetManager(FleetManager manager)
	{
		FleetManager = manager;
	}
	
	public Viewer GetViewer()
	{
		return Viewport;
	}
	
	public void SetViewer(Viewer viewer)
	{
		Viewport = viewer;
	}
	private void SetCommanders()
	{
		RebelCommander = new FleetCommander(Model.Enums.Faction.REBELLION);
		ImperialCommander = new FleetCommander(Model.Enums.Faction.EMPIRE);
	}
	
	public void on_EmpireSelected()
	{
		FleetManager.SetFactionEmpire();
	}
	
	public void on_RebellionSelected()
	{
		FleetManager.SetFactionRebellion();
	}
	
	/**
	 * Indicate to the player that the user clicked on the given
	 * row and column with the mouse.
	 * */
	public void on_UpgradeSelected(int row, int col, int button)
	{
		Upgrade marker = new Upgrade();
		SelectedUpgrade = marker;
	}


	public void on_RemoveUpgrade(int index)
	{
		FleetManager.RemoveUpgrade(index);
	}
	
	public void on_ApplyUpgrade(int index)
	{
		FleetManager.ApplyUpgrade(index);
	}

	public void updateDisplay()
	{
		
	}

	/**
	 * clears valid move highlights
	*/
	public void ClearSelected()
	{
	}

	/**
	 * Handle when the user selected the new Fleet or ClearFleet button.
	*/
	void on_NewFleet()
	{
	
	}


	/**
	 * Handle when the user selects to quit the game, either through the
	 * quit button, the close X button, or the file menu.
	*/
	public void on_QuitGame()
	{
	
	}

	/**
	 * Set the Viewer that this Controller will handle inputs for.
		 */
	void SetView(Viewer view)
	{
		Viewport = view;
	}
	
	/**
	 * Handles the selection of an Upgrade
	 */
	public void on_SelectUpgrade(int typeIndex, int upgradeIndex)
	{
		//index is index of Upgrade button pressed
		FleetManager.SelectUpgrade(typeIndex, upgradeIndex);
	}
	
	public void on_SelectPilot(int shipIndex, int pilotIndex)
	{
		FleetManager.SelectAvailablePilot(shipIndex, pilotIndex);
	}
	
	public void on_SelectRosterPilot(int index)
	{
		FleetManager.SelectRosterPilot(index);
	}
	
	public void on_AddPilotToRoster()
	{
		FleetManager.AddPilotToRoster();
	}
	
	public void on_RemovePilotFromRoster()
	{
		FleetManager.RemovePilotFromRoster();
	}
}