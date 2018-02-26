package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;
import Model.SelectedUpgradeViewModel;
import Model.UpgradeSlot;

public class SelectedUpgradeViewer extends JPanel implements Observer{
	
	FleetStorage Model;
	FleetManager Manager;
	Control Controller;
	JPanel UpgradeCost;
	JLabel UpgradeCostLabel;
	JPanel UpgradeName;
	JLabel UpgradeNameLabel;
	JPanel UpgradeEffect;
	JLabel UpgradeEffectLabel;
	JLabel UpgradeCard;
	
	public SelectedUpgradeViewer(FleetManager manager, Control control)
	{
		//Model = model;
		Manager = manager;
		Controller = control;
		//Manager.addObserver(this);
		//Manager.FleetStorage().addObserver(this);
		Manager.SelectedUpgrade().addObserver(this);
		Controller.addObserver(this);
		
		
		
		//The buttons should be disabled for slots that don't match the selected upgrade type
		
		
		//move logic to create this to Controller?
		TitledBorder border = BorderFactory.createTitledBorder("Selected Upgrade");
		border.setTitleJustification(TitledBorder.RIGHT);
		setBorder(border);
		setPreferredSize(new Dimension(80, 275));
		setLayout(new BorderLayout());
		
		//JPanel with Pilot cost, name, and Effect
		UpgradeCost = new JPanel();
		UpgradeCostLabel = new JLabel(String.valueOf(Manager.SelectedUpgrade().GetSelectedUpgrade().Upgrade().Cost()));
		UpgradeCost.add(UpgradeCostLabel);
		UpgradeName = new JPanel();
		UpgradeNameLabel = new JLabel(Manager.SelectedUpgrade().GetSelectedUpgrade().Upgrade().Name());
		UpgradeName.add(UpgradeNameLabel);
		
		UpgradeEffect = new JPanel();
		UpgradeEffectLabel = new JLabel(Manager.SelectedUpgrade().GetSelectedUpgrade().Upgrade().Effect());
		UpgradeEffectLabel.setMaximumSize(new Dimension(80, 50));
		UpgradeEffect.add(UpgradeEffectLabel);
		
		UpgradeCard = new JLabel();
		
		/*
		JLabel upgradeCard = new JLabel();
		ImageIcon image = new ImageIcon (getClass().getResource("/View/Images/180px-Marksmanship.png"));
		upgradeCard.setIcon(image);
		upgrade.add(upgradeCard);
		*/
		
		add(UpgradeName, BorderLayout.WEST);
		add(UpgradeEffect, BorderLayout.CENTER);
		add(UpgradeCost, BorderLayout.EAST);
		add(UpgradeCard, BorderLayout.SOUTH);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		//UpgradeCostLabel.setText(String.valueOf(Manager.SelectedUpgrade().GetSelectedUpgrade().Upgrade().Cost()));
		//UpgradeNameLabel.setText(Manager.SelectedUpgrade().GetSelectedUpgrade().Upgrade().Name());
		//UpgradeEffectLabel.setText(Manager.SelectedUpgrade().GetSelectedUpgrade().Upgrade().Effect());
		
		
		//Don't really know if, in the future, Observable is in fact the SelectedUpgradeViewModel, might should keep above code
		UpgradeCostLabel.setText(String.valueOf(((SelectedUpgradeViewModel)arg0).GetSelectedUpgrade().Upgrade().Cost()));
		UpgradeNameLabel.setText(((SelectedUpgradeViewModel)arg0).GetSelectedUpgrade().Upgrade().Name());
		UpgradeEffectLabel.setText(((SelectedUpgradeViewModel)arg0).GetSelectedUpgrade().Upgrade().Effect());
		ImageIcon image = new ImageIcon (getClass().getResource("/View/Images/180px-Marksmanship.png"));
		UpgradeCard.setIcon(image);
		
	}
}
