package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;

public class Viewer extends JFrame implements Observer{
	
	//private FleetStorage FleetStorage;
	private FleetManager Manager;
	private Control Controller;
	JFrame Frame;
	JPanel MainPanel;
	JPanel FleetCost;
	JLabel CostLabel;
		
	public Viewer(FleetManager manager)
	{
		/*
		 * In center, show info on selected Pilot under Pilot List and over selected Upgrade info.

In Selected Pilot panel, have buttons for each Upgrade slot.  Left click, assign Upgrade.  Right click, remove.  Slot Buttons will be inactive for invalid upgrades.

Upgrade buttons on left will be hidden for invalid upgrade options for pilot.

perhaps for now, fail fast and all, have an "Assign" button and a "Remove" button.
		 */
		Frame = new JFrame("Fleet Builder");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel = new JPanel();
		MainPanel.setBackground(Color.cyan);//setBackground (icon of starfield?);
		//MainPanel.setPreferredSize(new Dimension(1800, 1000));
		MainPanel.setLayout (new BorderLayout());
		Manager = manager;
		Manager.addObserver(this);
		Controller = new Control(Manager.FleetStorage(), this);
		Controller.SetFleetManager(Manager);
		
		JPanel Upgrades = new UpgradesViewer(Manager, Controller);
		JScrollPane UpgradeScrollPane = new JScrollPane(Upgrades);
		//UpgradeScrollPane.setPreferredSize(new Dimension(200, 300));
		JPanel Fleet = new FleetViewer(Manager, Controller);
		JPanel Pilots = new PilotsViewer(Manager, Controller);
		JScrollPane PilotScrollPane = new JScrollPane(Pilots);
		
		FleetCost = new JPanel();
		CostLabel = new JLabel("Main Panel Test");
		FleetCost.add(CostLabel);
		MainPanel.add(FleetCost, BorderLayout.NORTH);
		//MainPanel.add (Upgrades, BorderLayout.WEST);
		MainPanel.add(UpgradeScrollPane, BorderLayout.WEST);
		MainPanel.add (Fleet, BorderLayout.CENTER);
		//MainPanel.add (Pilots, BorderLayout.EAST);
		MainPanel.add(PilotScrollPane, BorderLayout.EAST);
		
		Frame.getContentPane().add(MainPanel);
		Frame.pack();
		Frame.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		CostLabel.setText(Integer.toString(Manager.GetFleetCost()));
	}
}
