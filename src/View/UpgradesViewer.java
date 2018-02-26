package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;
import Model.UpgradeCount;
import Model.AvailablePilots.PilotsByShip;
import Model.AvailableUpgrades.UpgradesByType;
import View.Buttons.ToggleButton;

public class UpgradesViewer extends JPanel implements Observer{
	
	private FleetManager Manager;
	private Control Controller;
	
	public UpgradesViewer(FleetManager manager, Control control)
	{
		Manager = manager;
		Controller = control;
		
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		//setPreferredSize(new Dimension(250, 3650));
		setBackground (Color.green);
		this.add(new JLabel("Available Upgrades"));
			
		int typeIndex = 0;
		List<UpgradesByType> upgrades = Manager.FleetStorage().AvailableUpgrades();
		for (; typeIndex < upgrades.size(); typeIndex++)
		{
			JPanel typePanel = new JPanel();
			typePanel.setLayout(new BoxLayout (typePanel, BoxLayout.Y_AXIS));
			String toggleButtonText = upgrades.get(typeIndex).Type().toString() + "("+upgrades.get(typeIndex).Upgrades().size()+")";
			ToggleButton toggleList = new ToggleButton(toggleButtonText, typePanel);

			for (int upgradeIndex = 0; upgradeIndex< upgrades.get(typeIndex).Upgrades().size(); upgradeIndex++)
			{
				JPanel upgrade = new JPanel();
				UpgradeCount upgradeCount = upgrades.get(typeIndex).Upgrades().get(upgradeIndex);
				SelectUpgradeButton button = new SelectUpgradeButton(typeIndex, upgradeIndex, Controller, upgradeCount);
				String buttonText = upgradeCount.Upgrade().Name();
				buttonText += " : " + upgradeCount.Count();
				button.setText(buttonText);
				upgrade.add(button);
				typePanel.add(upgrade);
			}
			add(toggleList);
			add(typePanel);
		}	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
