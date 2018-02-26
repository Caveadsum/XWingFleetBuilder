package Model;

import java.util.Observable;

public class SelectedUpgradeViewModel extends Observable{
	
	private UpgradeCount SelectedUpgrade;
	
	public SelectedUpgradeViewModel()
	{
		SelectedUpgrade = new UpgradeCount(new Upgrade(), 0);
	}
	
	public SelectedUpgradeViewModel(UpgradeCount upgrade)
	{
		SelectedUpgrade = upgrade;
	}
	
	//sets the selected Upgrade
	public void SelectUpgrade(UpgradeCount upgrade)
	{
		SelectedUpgrade = upgrade;
		Notify();
	}
	
	//returns the selected Upgrade
	public UpgradeCount GetSelectedUpgrade()
	{
		return SelectedUpgrade;
	}
	
	//clears the selected Upgrade
	public void ClearUpgrade()
	{
		SelectedUpgrade = new UpgradeCount(new Upgrade(), 0);
		Notify();
	}
	
	//Notifies Observers of changes
	private void Notify()
	{
		setChanged();
		notifyObservers();
	}

}
