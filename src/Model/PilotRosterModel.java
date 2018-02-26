package Model;

import java.util.ArrayList;
import java.util.Observable;

public class PilotRosterModel extends Observable{

	private ArrayList<Pilot> Roster;
	private int FleetCost;
	
	public PilotRosterModel()
	{
		Roster = new ArrayList<Pilot>();
	}
	
	//Returns the Roster
	public ArrayList<Pilot> Roster()
	{
		return Roster;
	}
	
	//Adds a pilot to the roster
	public int AddPilot(Pilot pilot)
	{
		Roster.add(pilot);
		FleetCost += pilot.Cost;
		Notify();
		return Roster.indexOf(pilot);
	}
	
	//Removes a pilot from the roster
	public void RemovePilot(Pilot pilot)
	{
		Roster.remove(pilot);
		FleetCost -= pilot.Cost;
		Notify();
	}
	
	//Returns the FleetCost
	public int FleetCost()
	{
		int cost = 0;
		for (int i = 0; i < Roster.size(); i ++)
		{
			cost += Roster.get(i).Cost();
		}
		
		return cost;
		//return FleetCost;
	}
	
	//Notify Observers
	private void Notify()
	{
		setChanged();
		notifyObservers();
	}
}
