package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;
import Model.Pilot;
import Model.Upgrade;
import Model.UpgradeCount;
import Model.Enums.*;

public class FleetViewer extends JPanel implements Observer{

	private FleetStorage Model;
	private FleetManager Manager;
	private Control Controller;
	private JPanel AssignedPilots;
	private JPanel SelectedPilot;
	private JPanel SelectedUpgrade;
	private JLabel FleetLabel;
	
	public FleetViewer(FleetManager manager, Control control)
	{
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		//setPreferredSize(new Dimension(250, 600));
		setBackground (Color.red);
		Manager = manager;
		Manager.addObserver(this);
		Manager.FleetStorage().GetRoster(Faction.REBELLION).addObserver(this);
		Manager.FleetStorage().GetRoster(Faction.EMPIRE).addObserver(this);
		Model = manager.FleetStorage();
		Controller = control;
		//add(new JLabel("Ships in " + Manager.GetCurrentFaction().toString() + " fleet"));
		JPanel header = new JPanel();
		FleetLabel = new JLabel("Ships in " + Manager.GetCurrentFaction().toString() + " fleet");
		header.add(FleetLabel);
		
		JButton switchEmpire = new JButton("EMPIRE");
		switchEmpire.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_EmpireSelected();
			}
		});
		//add(new JButton("Empire"));
		
		JButton switchRebel = new JButton("REBELLION");
		switchRebel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_RebellionSelected();
			}
		});
		header.add(switchEmpire);
		header.add(switchRebel);
		add(header);

		
		//Set up the individual panels
		SetUpPilotsPanel();
		SetUpPilotPanel();
		SetUpUpgradePanel();
		
		add(AssignedPilots);
		add(SelectedPilot);
		add(SelectedUpgrade);
	}
	
	public FleetViewer(FleetStorage model, Control control)
	{
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		//setPreferredSize(new Dimension(250, 600));
		setBackground (Color.red);
		Model = model;
		Controller = control;
		JPanel header = new JPanel();
		header.add(new JLabel("BLAH!Ships in " + Manager.GetCurrentFaction().toString() + " fleet"));
		
		JButton switchEmpire = new JButton("EMPIRE");
		switchEmpire.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_EmpireSelected();
			}
		});
		add(new JButton("Empire"));
		
		JButton switchRebel = new JButton("REBELLION");
		switchEmpire.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_RebellionSelected();
			}
		});
		header.add(switchEmpire);
		header.add(switchRebel);
		add(header);
		//Set up the individual panels
		SetUpPilotsPanel();
		SetUpPilotPanel();
		SetUpUpgradePanel();
		
		add(AssignedPilots);
		add(SelectedPilot);
		add(SelectedUpgrade);
	}
	
	//Sets up the Assigned Pilots panel
	private void SetUpPilotsPanel()
	{
		AssignedPilots = new JPanel();
		TitledBorder border = BorderFactory.createTitledBorder("Assigned Pilots");
		border.setTitleJustification(TitledBorder.RIGHT);
		AssignedPilots.setBorder(border);
		UpdateRoster();
	}
	
	private void UpdateRoster()
	{
		AssignedPilots.removeAll();
		ArrayList<Pilot> roster = Manager.GetRoster().Roster();
		for (int i = 0; i < roster.size(); i++)
		{
			Pilot pilot = roster.get(i);
			String buttonText = pilot.Name() + " (" + pilot.Ship() + ")";
			SelectRosterPilotButton addedPilot = new SelectRosterPilotButton(i, Controller);
			addedPilot.setText(pilot.Name() + " : " + pilot.Ship().toString());

			
			/*
			 * ToggleList.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Modifications.setVisible(!Modifications.isVisible());
			}
		});
			 */
			AssignedPilots.add(addedPilot);
		}
	}
	
	//Sets up the SelectedPilot view panel
	private void SetUpPilotPanel()
	{
		SelectedPilot = new SelectedPilotViewer(Manager, Controller);		
	}
	
	//Sets up the SelectedUpgrade view panel
	private void SetUpUpgradePanel()
	{
		SelectedUpgrade = new SelectedUpgradeViewer(Manager, Controller);
	}
	
	//Updates the SelectedPilot Panel
	public void UpdateSelectedUpgradePanel()
	{
		JPanel upgradeInfo = new JPanel();
		JPanel upgradeName = new JPanel();
		UpgradeCount upgrade = Manager.SelectedUpgrade().GetSelectedUpgrade();
		upgradeName.add(new JLabel(upgrade.Upgrade().Name()));
		
		JPanel upgradeText = new JPanel();
		upgradeText.add(new JLabel(upgrade.Upgrade().Effect()));
		
		upgradeInfo.add(upgradeName);
		upgradeInfo.add(upgradeText);
		SelectedPilot.add(upgradeInfo);
	}

	@Override
	public void update(Observable o, Object arg) {
		UpdateRoster();
		FleetLabel.setText("Ships in " + Manager.GetCurrentFaction().toString() + " fleet");
		repaint();
		validate();
	}
}
