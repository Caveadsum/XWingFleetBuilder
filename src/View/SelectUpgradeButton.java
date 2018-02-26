package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import Controller.Control;
import Model.Upgrade;
import Model.UpgradeCount;

public class SelectUpgradeButton extends IndexedButton{
	
	//private Upgrade ViewUpgrade;
	private Control Controller;
	private int TypeIndex;
	private int UpgradeIndex;
	
	public SelectUpgradeButton(int typeIndex, int upgradeIndex, Control controller, UpgradeCount upgradeCount)
	{
		super (upgradeIndex, controller, upgradeCount);
		TypeIndex = typeIndex;
		UpgradeIndex = upgradeIndex;
		Controller = controller;
		upgradeCount.addObserver(this);
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_SelectUpgrade(TypeIndex, UpgradeIndex);
			}
		});
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpgradeCount upgrade = (UpgradeCount)o;
		setText(upgrade.Upgrade().Name() + " : " + upgrade.Count());
		//super.repaint();
	}
}
