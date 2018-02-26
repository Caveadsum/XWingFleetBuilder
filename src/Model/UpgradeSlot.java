package Model;

import java.util.Observable;

public class UpgradeSlot extends Observable {
	
		public UpgradeCount Upgrade;
		public boolean Applied;
		
		public UpgradeSlot(UpgradeCount u)
		{
			Upgrade = u;
			Applied = false;
		}
		
		public UpgradeSlot(UpgradeCount u, boolean a)
		{
			Upgrade = u;
			Applied = a;
		}
		
		//resets an upgrade slots values
		public void Reset()
		{
			Upgrade = new UpgradeCount(new Upgrade(Upgrade.Upgrade().Type()), 0);
			Applied = false;	
			Notify();
		}
		
		//Swaps the UpgradeSlot's Upgrade value with a new value
		public UpgradeCount ApplyUpgrade(UpgradeCount upgrade) throws Exception
		{
			UpgradeCount previousUpgrade = Upgrade;
			Upgrade = upgrade;
			Applied = true;
			//Upgrade.Decrease();
			//previousUpgrade.Increase();
			return previousUpgrade;
			//Notify();
		}
		
		//Removes an Upgrade
		public UpgradeCount RemoveUpgrade(int index) throws Exception
		{
			//Upgrade.Increase();
			UpgradeCount removed = Upgrade;
			Reset();
			return removed;
		}
		
		public void Notify()
		{
			setChanged();
			notifyObservers();
		}
	}
