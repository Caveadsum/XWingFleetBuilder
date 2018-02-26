package View;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Model.UpgradeCount;
import View.Buttons.ToggleButton;

public class UpgradeTypeViewer extends JPanel{
	
	private ToggleButton ToggleButton;
	private String UpdateType;
	private JPanel UpdateListPanel;
	
	public UpgradeTypeViewer()
	{
		//pass in observables
		UpdateListPanel = new JPanel();
		UpdateListPanel.setLayout(new BoxLayout (typePanel, BoxLayout.Y_AXIS));
		String toggleButtonText = upgrades.get(typeIndex).Type().toString() + "("+upgrades.get(typeIndex).Upgrades().size()+")";
		ToggleButton = new ToggleButton(toggleButtonText, typePanel);

		for (int upgradeIndex = 0; upgradeIndex< upgrades.get(typeIndex).Upgrades().size(); upgradeIndex++)
		{
			JPanel upgrade = new JPanel();
			UpgradeCount upgradeCount = upgrades.get(typeIndex).Upgrades().get(upgradeIndex);
			SelectUpgradeButton button = new SelectUpgradeButton(typeIndex, upgradeIndex, Controller, upgradeCount);
			String buttonText = upgradeCount.Upgrade().Name();
			buttonText += " : " + upgradeCount.Count();
			button.setText(buttonText);
			upgrade.add(button);
			UpdateListPanel.add(upgrade);
		}
		add(toggleList);
		add(typePanel);
	}
	
	
	/*
	 * JPanel typePanel = new JPanel();
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
	 */
	
	public JPanel GetUpdateListPanel()
	{
		return UpdateListPanel;
	}

}
