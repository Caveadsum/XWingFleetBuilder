package Model.AvailableUpgrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Upgrade;
import Model.UpgradeCount;
import Model.AvailablePilots.PilotsByShip;
import Model.Enums.Faction;
import Model.Enums.UpgradeType;

public class AvailableUpgradesViewModel extends Observable{

	private List<UpgradesByType> AvailableUpgrades;
	
	
	private UpgradesByType Astromechs;
	private UpgradesByType Bombs;
	private UpgradesByType Cannons;
	private UpgradesByType Crew;
	private UpgradesByType EliteTalents;
	private UpgradesByType Missiles;
	private UpgradesByType Modifications;
	private UpgradesByType Systems;
	private UpgradesByType Titles;
	private UpgradesByType Torpedoes;
	private UpgradesByType Turrets;

	private Model.Enums.Faction Faction;
	
	public AvailableUpgradesViewModel()
	{
		Initialize();
	}
	
	//Initializes the pilot lists
	private void Initialize()
	{
		LoadUpgrades();
	}
	
	private void LoadUpgrades()
	{
		InitializeHardCoded();
	}
	
	//Returns the available pilots depending on faction
	public List<UpgradesByType> AvailableUpgrades()
	{
		return AvailableUpgrades;
	}
	
	private void InitializeHardCoded()
	{
		AvailableUpgrades = new ArrayList<UpgradesByType>();
		InitializeAstromechs();
		InitializeBombs();
		InitializeCannons();
		InitializeCrew();
		InitializeTalents();
		InitializeMissiles();
		InitializeModifications();
		InitializeSystems();
		InitializeTitles();
		InitializeTorpedoes();
		InitializeTurrets();
		
		AvailableUpgrades.add(Astromechs);
		AvailableUpgrades.add(Bombs);
		AvailableUpgrades.add(Cannons);
		AvailableUpgrades.add(Crew);
		AvailableUpgrades.add(EliteTalents);
		AvailableUpgrades.add(Missiles);
		AvailableUpgrades.add(Modifications);
		AvailableUpgrades.add(Systems);
		AvailableUpgrades.add(Titles);
		AvailableUpgrades.add(Torpedoes);
		AvailableUpgrades.add(Turrets);
	}
	
	private void InitializeAstromechs()
	{
		Astromechs = new UpgradesByType(UpgradeType.Astromech);
		Astromechs.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"After executing a green maneuver, you may recover 1 shield (up to your shield value).",
				"R2-D2",
				true,
				UpgradeType.Astromech,
				Faction.REBELLION), 1));
		Astromechs.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"ACTION: Increase your agility value by 1 until the end of this game round.",
				"R2-F2",
				true,
				UpgradeType.Astromech,
				Faction.REBELLION), 1)); 
	}
	
	private void InitializeBombs()
	{
		Bombs = new UpgradesByType(UpgradeType.Bomb);
		Bombs.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"ACTION: Discard this card to drop 1 proximity mine token. \n When a ship executes a maneuver, if its base or maneuver template overlaps this token, this token detonates.",
				"Proximity Mines",
				false,
				UpgradeType.Bomb,
				Faction.NONE), 1));
		Bombs.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"When you reveal your maneuver dial, you may discard this card to drop 1 seismic charge token. \n This token detonates at the end of the Activation phase.",
				"Seismic Charges",
				false,
				UpgradeType.Bomb,
				Faction.NONE), 1));
	}
	
	private void InitializeCannons()
	{
		Cannons = new UpgradesByType(UpgradeType.Cannon);
		Cannons.AddUpgrade(new UpgradeCount(new Upgrade(
				5,
				"ATTACK: Attack 1 ship. \n Your HIT results cannot be canceled by defense dice. The defender may cancel CRIT results before HIT results.",
				"Autoblaster",
				false,
				UpgradeType.Cannon,
				Faction.NONE), 1));
		Cannons.AddUpgrade(new UpgradeCount(new Upgrade(
				7,
				"ATTACK: Attack 1 ship. \n Immediately after rolling your attack dice, you must change all of your CRIT results to HIT results.",
				"Heavy Laser Cannon",
				false,
				UpgradeType.Cannon,
				Faction.NONE), 2));
		Cannons.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"ATTACK: Attack 1 ship. \n If this attack hits, the defender suffers 1 damage and receives 1 ion token. Then cancel all dice results.",
				"Ion Cannon",
				false,
				UpgradeType.Cannon,
				Faction.NONE), 2));
	}
	
	private void InitializeCrew()
	{
		Crew = new UpgradesByType(UpgradeType.Crew);
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"After you perform an attack against an enemy ship, you may suffer 2 damage to cause that ship to suffer 1 critical damage.",
				"Darth Vader",
				true,
				UpgradeType.Crew,
				Faction.EMPIRE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"When you are deatl a Damage card, you may immediately discard that card and recover 1 shield. Then, discard this Upgrade card.",
				"Chewbacca",
				true,
				UpgradeType.Crew,
				Faction.REBELLION), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"When defending, you may reroll 1 of your FOCUS results. \n If the attacker's pilot skill value is \"2\" or lower, you may reroll 1 of your blank results instead.",
				"Flight Instructor",
				false,
				UpgradeType.Crew,
				Faction.NONE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				5,
				"After you perform an attack that does not hit, immediately perform a primary weapon attack. You cannot perform another attack this round.",
				"Gunner",
				false,
				UpgradeType.Crew,
				Faction.NONE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				1,
				"At the start of the Activation phase, choose 1 enemy ship at Range 1-2. You may look at that ship's chosen maneuver.",
				"Intelligence Agent",
				false,
				UpgradeType.Crew,
				Faction.NONE), 2));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				7,
				"After you perform an attack that does not hit, immediately perform a primary weapon attack. You may change 1 focus result to a HIT result. You cannot perform another attack this round.",
				"Luke Skywalker",
				true,
				UpgradeType.Crew,
				Faction.REBELLION), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"When attacking at Range 3, you may change 1 of your HIT results to a CRIT result.",
				"Mercenary Copilot",
				false,
				UpgradeType.Crew,
				Faction.NONE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"When you reveal a maneuver, you may rotate your dial to another maneuver with the same bearing. \n You cannot rotate to a red maneuver if you have stress tokens.",
				"Navigator",
				false,
				UpgradeType.Crew,
				Faction.NONE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				1,
				"You may treat all Straight maneuvers as green maneuvers.",
				"Nien Nunb",
				true,
				UpgradeType.Crew,
				Faction.REBELLION), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"Once per round, the first ship that declares you as the target of an attack immediately recieves 1 stress token.",
				"Rebel Captive",
				true,
				UpgradeType.Crew,
				Faction.EMPIRE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"When you perform a focus action, assign 1 additional focus token to your ship.",
				"Recon Specialist",
				false,
				UpgradeType.Crew,
				Faction.NONE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"ACTION: Choose 1 enemy ship at Range 1 and roll 1 attack die.  On a HIT or a CRIT result, choose 1 random facedown Damage card assigned to that ship, flip it faceup, and resolve it.",
				"Saboteur",
				false,
				UpgradeType.Crew,
				Faction.NONE), 1));
		Crew.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"You may maintain 2 target locks (only 1 per enemy ship). \n When you acquire a target lock, you may lock onto 2 different ships.",
				"Weapons Engineer",
				false,
				UpgradeType.Crew,
				Faction.NONE), 2));		
	}
	
	private void InitializeTalents()
	{
		EliteTalents = new UpgradesByType(UpgradeType.EliteTalent);
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				1,
				"When you are dealt a faceup Damage card with the Pilot trait, discard it immediately without resolving its effect.",
				"Determination",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				1,
				"When a friendly ship at Range 1 is hit by an attack, you may suffer 1 of the uncanceled CRIT results instead of the target ship.",
				"Draw Their Fire",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"When defending, you may receive 1 stress token to choose 1 attack die. The attacker must reroll that die. \n If you have at least 1 stress token, you cannot use this ability.",
				"Elusiveness",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"ACTION: Performa a free barrel roll action. If you do not have hte Barrel Roll action icon, receive one stress token. \n You may then remove 1 enemy target lock from your ship.",
				"Expert Handling",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"ACTION: Until the end of the round, increase your primary weapon value by 1 and decrease your agility value by 1.",
				"Expose",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"ACTION: When attacking this round, you may change 1 of your FOCUS results to a CRIT result and all of your other FOCUS results to HIT results.",
				"Marksmanship",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"ACTION: Choose 1 ship at Range 1-2 that has a lower pilot skill than you. \n The chosen ship may immediately perform 1 free action",
				"Squad Leader",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"At the start of the Combat phase, choose 1 friendly ship at Range 1. \n Until the end of this phase, treat the chosen ship as if its pilot skill were equal to your pilot skill.",
				"Swarm Tactics",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 1));
		EliteTalents.AddUpgrade(new UpgradeCount(new Upgrade(
				1,
				"Increase your pilot skill value by 2.",
				"Veteran Instincts",
				false,
				UpgradeType.EliteTalent,
				Faction.NONE), 2));
	}
	
	private void InitializeMissiles()
	{
		Missiles = new UpgradesByType(UpgradeType.Missile);
		Missiles.AddUpgrade(new UpgradeCount(new Upgrade(
				5,
				"ATTACK[TARGET LOCK]: Spend your target lock and discard this card to perform this attack. \n If this attack hits, each other ship at Range 1 of the defender suffers 1 damage.",
				"Assault Missiles",
				false,
				UpgradeType.Missile,
				Faction.NONE), 2));
		Missiles.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"ATTACK[TARGET LOCK]: Spend your target lock and discard this card to perfrom this attack TWICE.",
				"Cluster Missiles",
				false,
				UpgradeType.Missile,
				Faction.NONE), 1));
		Missiles.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"ATTACK[TARGET LOCK]: Spend your target lock and discard this card to perform this attack. \n You may change 1 of your blank results to a HIT result.",
				"Concussion Missiles",
				false,
				UpgradeType.Missile,
				Faction.NONE), 2));
		Missiles.AddUpgrade(new UpgradeCount(new Upgrade(
				5,
				"ATTACK[TARGET LOCK]: Discard this card to perform this attack. \n The defender cannot spend evade tokens during this attack.",
				"Homing Missiles",
				false,
				UpgradeType.Missile,
				Faction.NONE), 1));
	}
	
	private void InitializeModifications()
	{
		Modifications = new UpgradesByType(UpgradeType.Modification);
		Modifications.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"Your action bar gains the BOOST action icon.",
				"Engine Upgrade",
				false,
				UpgradeType.Modification,
				Faction.NONE), 2));
		Modifications.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"Increase your shield value by 1.",
				"Shield Upgrade",
				false,
				UpgradeType.Modification,
				Faction.NONE), 2));
		Modifications.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"Increase your agility value by 1. If you are hit by an attack, discard this card.",
				"Stealth Device",
				false,
				UpgradeType.Modification,
				Faction.NONE), 2));
		Modifications.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"LARGE SHIP ONLY: After an enemy ship executes a maneuver that causes it to overlap your ship, roll 1 attack die. On a HIT or CRIT result, the enemy ship suffers 1 damage.",
				"Anti-Pursuit Lasers",
				false,
				UpgradeType.Modification,
				Faction.NONE), 2));
	}
	
	private void InitializeSystems()
	{
		Systems = new UpgradesByType(UpgradeType.Systems);
		Systems.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"Immediately before you reveal your maneuver, you may perform 1 free action. \n If you use this ability, you must skip your \"Perform Action\" step during this round.",
				"Advanced Sensors",
				false,
				UpgradeType.Systems,
				Faction.NONE), 1));
		Systems.AddUpgrade(new UpgradeCount(new Upgrade(
				2,
				"After you perform an attack, you may acquire a target lock on the defender.",
				"Fire-Control System",
				false,
				UpgradeType.Systems,
				Faction.NONE), 1));
		Systems.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"When defending, you may change 1 of the attacker's HIT results to a FOCUS result. \n The attacker cannot reroll the die with the changed result.",
				"Sensor Jammer",
				false,
				UpgradeType.Systems,
				Faction.NONE), 1));
	}
	
	private void InitializeTitles()
	{
		Titles = new UpgradesByType(UpgradeType.Title);
		Titles.AddUpgrade(new UpgradeCount(new Upgrade(
				1,
				"Your action bar gains the EVADE action icon.",
				"Millennium Falcon",
				true,
				UpgradeType.Title,
				Faction.REBELLION), 1));
		Titles.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"During the End phase, do not remove unused focus tokens from your ship.",
				"Moldy Crow",
				true,
				UpgradeType.Title,
				Faction.REBELLION), 1));
		Titles.AddUpgrade(new UpgradeCount(new Upgrade(
				0,
				"Your upgrade bar gainse the TORPEDO upgrade icon.",
				"Slave I",
				true,
				UpgradeType.Title,
				Faction.EMPIRE), 1));
		Titles.AddUpgrade(new UpgradeCount(new Upgrade(
				3,
				"When acquiring a target lock, you may lock onto any enemy ship in the play area.",
				"ST-321",
				true,
				UpgradeType.Title,
				Faction.EMPIRE), 1));
	}
	
	private void InitializeTorpedoes()
	{
		Torpedoes = new UpgradesByType(UpgradeType.Torpedo);
		Torpedoes.AddUpgrade(new UpgradeCount(new Upgrade(
				6,
				"ATTACK [TARGET LOCK]: Spend your target lock and discard this card to perform this attack. \n You may change up to 3 of your blank results to FOCUS results.",
				"Adv. Proton Torpedoes",
				false,
				UpgradeType.Torpedo,
				Faction.NONE), 1));	
		Torpedoes.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"ATTACK [TARGET LOCK]: Spend your target lock and discard this card to perform this attack. \n You may change 1 of your FOCUS results to a CRIT result.",
				"Proton Torpedoes",
				false,
				UpgradeType.Torpedo,
				Faction.NONE), 2));	
	}
	
	private void InitializeTurrets()
	{
		Turrets = new UpgradesByType(UpgradeType.Turret);
		Turrets.AddUpgrade(new UpgradeCount(new Upgrade(
				4,
				"ATTACK [FOCUS]: Spend 1 focus token to perform this attack against 1 ship (even a ship outside your firing arc).",
				"Blaster Turret",
				false,
				UpgradeType.Turret,
				Faction.NONE), 1));	
		Turrets.AddUpgrade(new UpgradeCount(new Upgrade(
				5,
				"ATTACK Attack a ship (even a ship outside your firing arc. \n If this attack hits the target ship, the ship suffers 1 damage and receives 1 ion token. Then cancel ALL dice results.",
				"Ion Cannon Turret",
				false,
				UpgradeType.Turret,
				Faction.NONE), 1));	
	}
}
