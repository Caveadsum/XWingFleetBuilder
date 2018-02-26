package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;
import Model.UpgradeCount;
import Model.AvailablePilots.AvailablePilotsViewModel;
import Model.AvailablePilots.PilotsByShip;
import View.Buttons.ToggleButton;

public class PilotsViewer extends JPanel implements Observer{
	
	FleetStorage FleetStorage;
	FleetManager Manager;
	Control Controller;
	
	public PilotsViewer(FleetManager manager, Control control)
	{
		Manager = manager;
		Manager.addObserver(this);
		FleetStorage = Manager.FleetStorage();
		Controller = control;
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		//setPreferredSize(new Dimension(250, 150));
		setBackground (Color.blue);
		add(new JLabel("Available Pilots"));
		UpdatePilotsList();
	}
	
	//Populates the Pilots List
	private void UpdatePilotsList()
	{
		removeAll();
		int typeIndex = 0;
		List<PilotsByShip> faction = Manager.AvailablePilots();
		for (; typeIndex < faction.size(); typeIndex++)
		{
			JPanel shipPanel = new JPanel();
			shipPanel.setLayout(new BoxLayout (shipPanel, BoxLayout.Y_AXIS));
			String toggleButtonText = faction.get(typeIndex).Ship().toString() + "("+faction.get(typeIndex).Pilots().size()+")";
			ToggleButton toggleList = new ToggleButton(toggleButtonText, shipPanel);

			for (int pilotIndex = 0; pilotIndex< faction.get(typeIndex).Pilots().size(); pilotIndex++)
			{
				JPanel pilot = new JPanel();
				UpgradeCount upgradeCount = faction.get(typeIndex).Pilots().get(pilotIndex);
				SelectPilotButton button = new SelectPilotButton(typeIndex, pilotIndex, Controller, upgradeCount);
				String buttonText = upgradeCount.Upgrade().Name();
				buttonText += " : " + upgradeCount.Count();
				button.setText(buttonText);
				pilot.add(button);
				shipPanel.add(pilot);
			}
			add(toggleList);
			add(shipPanel);
		}	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdatePilotsList();
	}

}
