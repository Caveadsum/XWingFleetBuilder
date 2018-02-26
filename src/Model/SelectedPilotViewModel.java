package Model;

import java.util.Observable;

public class SelectedPilotViewModel extends Observable{
	
	private Pilot SelectedPilot;
	
	public SelectedPilotViewModel()
	{
		SelectedPilot = new Pilot();
	}
	
	public SelectedPilotViewModel(Pilot pilot)
	{
		SelectedPilot = pilot;
	}
	
	//sets the selected Upgrade
	public void SelectPilot(Pilot pilot)
	{
		SelectedPilot = pilot;
		Notify();
	}
	
	//returns the selected Upgrade
	public Pilot GetSelectedPilot()
	{
		return SelectedPilot;
	}
	
	//clears the selected Upgrade
	public void ClearPilot()
	{
		SelectedPilot = new Pilot();
		Notify();
	}
	
	//Applies an Upgrade
	public UpgradeCount ApplyUpgrade(UpgradeCount upgrade, int index) throws Exception
	{
		UpgradeCount removed = SelectedPilot.ApplyUpgrade(upgrade, index);  //SHOULD BE HITTING HERE
		Notify();
		return removed;
	}
	
	//Default RemoveUpgrade - removes an indexed Upgrade from the selected pilot
	public UpgradeCount RemoveUpgrade(int index) throws Exception
	{
		UpgradeCount removed = SelectedPilot.RemoveUpgrade(index);
		Notify();
		return removed;
	}
	
	private void Notify()
	{
		setChanged();
		notifyObservers();
	}

}
