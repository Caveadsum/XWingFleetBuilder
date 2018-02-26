package Model.AvailablePilots;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Model.Pilot;
import Model.Upgrade;
import Model.UpgradeCount;
import Model.Enums.Faction;
import Model.Enums.ShipType;
import Model.Enums.UpgradeType;

public class AvailablePilotsViewModel extends Observable{
	
	private List<PilotsByShip> PilotsRebellion;
	private PilotsByShip PilotsBwing;
	private PilotsByShip PilotsXwing;
	private PilotsByShip PilotsYT1300;
	private PilotsByShip PilotsHWK290;
	
	private List<PilotsByShip> PilotsEmpire;
	private PilotsByShip PilotsTieFighter;
	private PilotsByShip PilotsTieAdvanced;
	private PilotsByShip PilotsFirespray;
	private PilotsByShip PilotsLambda;
	
	private Model.Enums.Faction Faction;
	
	public AvailablePilotsViewModel()
	{
		//Faction = Model.Enums.Faction.REBELLION;
		//Faction = Model.Enums.Faction.EMPIRE;
		Initialize();
	}
	
	//Initializes the pilot lists
	private void Initialize()
	{
		LoadPilots();
	}
	
	private void LoadPilots()
	{
		InitializeHardCoded();
	}
	
	//Returns the available pilots depending on faction
	public List<PilotsByShip> AvailableRebelPilots()
	{
		return PilotsRebellion;
	}
	
	//Returns the available Empirial pilots
	public List<PilotsByShip> AvailableEmpirePilots()
	{
		return PilotsEmpire;
	}
	
	private void InitializeHardCoded()
	{
		PilotsRebellion = new ArrayList<PilotsByShip>();
		InitializeRebellionPilots();
		PilotsEmpire = new ArrayList<PilotsByShip>();
		InitializeEmpirePilots();
	}
	
	//Populates the Republic pilot data
	private void InitializeRebellionPilots()
	{
		InitializeBwingPilots();
		PilotsRebellion.add(PilotsBwing);
		InitializeXwingPilots();
		PilotsRebellion.add(PilotsXwing);
		InitializeYTPilots();
		PilotsRebellion.add(PilotsYT1300);
		InitializeHwkPilots();
		PilotsRebellion.add(PilotsHWK290);
	}
	
	//Populates the Republic pilot data
	private void InitializeEmpirePilots()
	{
		InitializeFiresprayPilots();
		PilotsEmpire.add(PilotsFirespray);
		InitializeLambdaPilots();
		PilotsEmpire.add(PilotsLambda);
		InitializeTieAdvancedPilots();
		PilotsEmpire.add(PilotsTieAdvanced);
		InitializeTieFighterPilots();
		PilotsEmpire.add(PilotsTieFighter);
	}
	
	private void InitializeBwingPilots()
	{
		UpgradeCount[] BlueUpgrades = new UpgradeCount[5];
		BlueUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		BlueUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		BlueUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		BlueUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		BlueUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] DaggerUpgrades = new UpgradeCount[5];
		DaggerUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		DaggerUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		DaggerUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		DaggerUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		DaggerUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] IbtisamUpgrades = new UpgradeCount[6];
		IbtisamUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		IbtisamUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		IbtisamUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		IbtisamUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		IbtisamUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		IbtisamUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] TenNumbUpgrades = new UpgradeCount[6];
		TenNumbUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		TenNumbUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		TenNumbUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		TenNumbUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		TenNumbUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		TenNumbUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		
		
		PilotsBwing = new PilotsByShip(ShipType.BWing);
		PilotsBwing.AddPilot(new UpgradeCount(new Pilot(
				22,
				"",
				"Blue Squadron Pilot",
				false,
				BlueUpgrades,
				ShipType.BWing,
				Faction.REBELLION
				), 1));
		
		PilotsBwing.AddPilot(new UpgradeCount(new Pilot(
				24,
				"",
				"Dagger Squadron Pilot",
				false,
				DaggerUpgrades,
				ShipType.BWing,
				Faction.REBELLION
				), 1));
		
		PilotsBwing.AddPilot(new UpgradeCount(new Pilot(
				28,
				"When attacking or defending, if you have at least 1 stress token, you may reroll 1 of your dice",
				"Ibtisam",
				true,
				IbtisamUpgrades,
				ShipType.BWing,
				Faction.REBELLION
				), 1));
		
		PilotsBwing.AddPilot(new UpgradeCount(new Pilot(
				31,
				"When attacking, 1 of your CRIT results cannot be canceled by defense dice.",
				"Ten Numb",
				true,
				IbtisamUpgrades,
				ShipType.BWing,
				Faction.REBELLION
				), 1));
	}

	private void InitializeXwingPilots()
	{
		UpgradeCount[] LukeUpgrades = new UpgradeCount[4];
		LukeUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Astromech), 0);
		LukeUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		LukeUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		LukeUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] BiggsUpgrades = new UpgradeCount[3];
		BiggsUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Astromech), 0);
		BiggsUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		BiggsUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] RedSquadronUpgrades = new UpgradeCount[3];
		RedSquadronUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Astromech), 0);
		RedSquadronUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		RedSquadronUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] RookiePilotUpgrades = new UpgradeCount[3];
		RookiePilotUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Astromech), 0);
		RookiePilotUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Torpedo), 0);
		RookiePilotUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		PilotsXwing = new PilotsByShip(ShipType.XWing);
		PilotsXwing.AddPilot(new UpgradeCount(new Pilot(
				28,
				"When defending, you may change 1 of your focus results to an evade result.",
				"Luke Skywalker",
				true,
				LukeUpgrades,
				ShipType.XWing,
				Faction.REBELLION
				), 1));
		PilotsXwing.AddPilot(new UpgradeCount(new Pilot(
				25,
				"Other friendly ships at Range 1 cannot be targeted by attacks if the attacker could target you instead.",
				"Biggs Darklighter",
				true,
				BiggsUpgrades,
				ShipType.XWing,
				Faction.REBELLION
				), 1));
		PilotsXwing.AddPilot(new UpgradeCount(new Pilot(
				23,
				"",
				"Red Squadron Pilot",
				false,
				RedSquadronUpgrades,
				ShipType.XWing,
				Faction.REBELLION
				), 1));
		PilotsXwing.AddPilot(new UpgradeCount(new Pilot(
				21,
				"",
				"Rookie Pilot",
				false,
				RookiePilotUpgrades,
				ShipType.XWing,
				Faction.REBELLION
				), 1));
	}
	
	private void InitializeYTPilots()
	{
		UpgradeCount[] HanUpgrades = new UpgradeCount[6];
		HanUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		HanUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		HanUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		HanUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		HanUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		HanUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] LandoUpgrades = new UpgradeCount[6];
		LandoUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		LandoUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		LandoUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		LandoUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		LandoUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		LandoUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] ChewieUpgrades = new UpgradeCount[6];
		ChewieUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		ChewieUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		ChewieUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		ChewieUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		ChewieUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		ChewieUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] SmugglerUpgrades = new UpgradeCount[4];
		SmugglerUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		SmugglerUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		SmugglerUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		SmugglerUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		PilotsYT1300 = new PilotsByShip(ShipType.YT1300);
		PilotsYT1300.AddPilot(new UpgradeCount(new Pilot(
				46,
				"When attacking, you may reroll all of your dice. If you choose to do so, you must reroll as many of your dice as possible",
				"Han Solo",
				true,
				HanUpgrades,
				ShipType.YT1300,
				Faction.REBELLION
				), 1));
		PilotsYT1300.AddPilot(new UpgradeCount(new Pilot(
				44,
				"After you execute a green manuever, choose 1 other friendly ship at Range 1. That ship may perform 1 free action shown in its action bar.",
				"Lando Calrissian",
				true,
				LandoUpgrades,
				ShipType.YT1300,
				Faction.REBELLION
				), 1));
		PilotsYT1300.AddPilot(new UpgradeCount(new Pilot(
				42,
				"When you are dealt a faceup Damage card, immediately flip it facedown (without resolving its ability).",
				"Chewbacca",
				true,
				ChewieUpgrades,
				ShipType.YT1300,
				Faction.REBELLION
				), 1));
		PilotsYT1300.AddPilot(new UpgradeCount(new Pilot(
				27,
				"",
				"Outer Rim Smuggler",
				false,
				SmugglerUpgrades,
				ShipType.YT1300,
				Faction.REBELLION
				), 1));
	}
	
	private void InitializeHwkPilots()
	{
		UpgradeCount[] JanUpgrades = new UpgradeCount[5];
		JanUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		JanUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Turret), 0);
		JanUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		JanUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		JanUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] KyleUpgrades = new UpgradeCount[5];
		KyleUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		KyleUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Turret), 0);
		KyleUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		KyleUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		KyleUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] RoarkUpgrades = new UpgradeCount[4];
		RoarkUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		RoarkUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Turret), 0);
		RoarkUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		RoarkUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] OperativeUpgrades = new UpgradeCount[4];
		OperativeUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		OperativeUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Turret), 0);
		OperativeUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		OperativeUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		PilotsHWK290 = new PilotsByShip(ShipType.Hwk290);
		PilotsHWK290.AddPilot(new UpgradeCount(new Pilot(
				25,
				"When another friendly ship at Range 1-3 is attacking, if you have no stress tokens, you may receive 1 stress token to allow that ship to roll 1 additional attack die.",
				"Jan Ors",
				true,
				JanUpgrades,
				ShipType.Hwk290,
				Faction.REBELLION
				), 1));
		PilotsHWK290.AddPilot(new UpgradeCount(new Pilot(
				21,
				"At the start of the Combat phase, you may assign 1 of your focus tokens to another friendly ship at Range 1-3.",
				"Kyle Katarn",
				true,
				KyleUpgrades,
				ShipType.Hwk290,
				Faction.REBELLION
				), 1));
		PilotsHWK290.AddPilot(new UpgradeCount(new Pilot(
				19,
				"At the start of the Combat phast, choose 1 other friendly ship at Range 1-3. Until the end of the phase, treat that ship's pilot skill value as \"12\".",
				"Roark Garnet",
				true,
				RoarkUpgrades,
				ShipType.Hwk290,
				Faction.REBELLION
				), 1));
		PilotsHWK290.AddPilot(new UpgradeCount(new Pilot(
				16,
				"",
				"Rebel Operative",
				false,
				OperativeUpgrades,
				ShipType.Hwk290,
				Faction.REBELLION
				), 1));
	}
	
	private void InitializeLambdaPilots()
	{
		UpgradeCount[] KagiUpgrades = new UpgradeCount[6];
		KagiUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		KagiUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		KagiUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		KagiUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		KagiUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		KagiUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] JendonUpgrades = new UpgradeCount[6];
		JendonUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		JendonUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		JendonUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		JendonUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		JendonUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		JendonUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] YorrUpgrades = new UpgradeCount[6];
		YorrUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		YorrUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		YorrUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		YorrUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		YorrUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		YorrUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] OmicronUpgrades = new UpgradeCount[6];
		OmicronUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		OmicronUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		OmicronUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		OmicronUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Systems), 0);
		OmicronUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		OmicronUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		PilotsLambda = new PilotsByShip(ShipType.Lambda);
		PilotsLambda.AddPilot(new UpgradeCount(new Pilot(
				27,
				"When an enemy ship acquires a target lock, it must lock onto your ship if able.",
				"Captain Kagi",
				true,
				KagiUpgrades,
				ShipType.Lambda,
				Faction.EMPIRE
				), 1));
		PilotsLambda.AddPilot(new UpgradeCount(new Pilot(
				24,
				"When another friendly ship at Range 1-2 would receive a stress token, if you have 2 or fewer stress tokens, you may recieve that token instead.",
				"Captain Yorr",
				true,
				YorrUpgrades,
				ShipType.Lambda,
				Faction.EMPIRE
				), 1));
		PilotsLambda.AddPilot(new UpgradeCount(new Pilot(
				26,
				"At the start of the Combat phase, you may assign 1 of your blue target lock tokens to a friendly ship at Range 1 if it does not have a blue target lock token.",
				"Colonel Jendon",
				true,
				JendonUpgrades,
				ShipType.Lambda,
				Faction.EMPIRE
				), 1));
		PilotsLambda.AddPilot(new UpgradeCount(new Pilot(
				21,
				"",
				"Omicron Group Pilot",
				false,
				OmicronUpgrades,
				ShipType.Lambda,
				Faction.EMPIRE
				), 1));
	}

	private void InitializeTieFighterPilots()
	{
		UpgradeCount[] BaseUpgrades = new UpgradeCount[1];
		BaseUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] EliteUpgrades = new UpgradeCount[2];
		EliteUpgrades [0] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		EliteUpgrades [1] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		
		PilotsTieFighter = new PilotsByShip(ShipType.TieFighter);
		PilotsTieFighter.AddPilot(new UpgradeCount(new Pilot(
				12,
				"",
				"Academy Pilot",
				false,
				BaseUpgrades,
				ShipType.TieFighter,
				Faction.EMPIRE
				), 2));
		PilotsTieFighter.AddPilot(new UpgradeCount(new Pilot(
				13,
				"",
				"Obsidian Squadron Pilot",
				false,
				BaseUpgrades,
				ShipType.TieFighter,
				Faction.EMPIRE
				), 2));
		PilotsTieFighter.AddPilot(new UpgradeCount(new Pilot(
				14,
				"",
				"Black Squadron Pilot",
				false,
				BaseUpgrades,
				ShipType.TieFighter,
				Faction.EMPIRE
				), 2));
		PilotsTieFighter.AddPilot(new UpgradeCount(new Pilot(
				15,
				"After executing a green maneuver, you may perform a free focus action.",
				"Night Beast",
				true,
				BaseUpgrades,
				ShipType.TieFighter,
				Faction.EMPIRE
				), 1));
		PilotsTieFighter.AddPilot(new UpgradeCount(new Pilot(
				16,
				"When defending, ships attacking you cannont spend focus tokens or reroll attack dice.",
				"Dark Curse",
				true,
				BaseUpgrades,
				ShipType.TieFighter,
				Faction.EMPIRE
				), 1));
		PilotsTieFighter.AddPilot(new UpgradeCount(new Pilot(
				17,
				"When attacking at Range 1, roll 1 additional attck die.",
				"Mauler Mithel",
				true,
				EliteUpgrades,
				ShipType.TieFighter,
				Faction.EMPIRE
				), 1));
	
	}
	
	private void InitializeTieAdvancedPilots()
	{
		UpgradeCount[] BaseUpgrades = new UpgradeCount[2];
		BaseUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		BaseUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		UpgradeCount[] EliteUpgrades = new UpgradeCount[3];
		EliteUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		EliteUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		EliteUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		
		PilotsTieAdvanced = new PilotsByShip(ShipType.TieAdvanced);
		PilotsTieAdvanced.AddPilot(new UpgradeCount(new Pilot(
				21,
				"",
				"Tempest Squadron Pilot",
				false,
				BaseUpgrades,
				ShipType.TieAdvanced,
				Faction.EMPIRE
				), 1));
		PilotsTieAdvanced.AddPilot(new UpgradeCount(new Pilot(
				23,
				"",
				"Storm Squadron Pilot",
				false,
				BaseUpgrades,
				ShipType.TieAdvanced,
				Faction.EMPIRE
				), 1));
		PilotsTieAdvanced.AddPilot(new UpgradeCount(new Pilot(
				27,
				"When your attack deals a faceup Damage card to the defender, instead draw 3 Damage cards, choose 1 to deal, and discard the others.",
				"Maarek Stele",
				true,
				EliteUpgrades,
				ShipType.TieAdvanced,
				Faction.EMPIRE
				), 1));
		PilotsTieAdvanced.AddPilot(new UpgradeCount(new Pilot(
				29,
				"During your \"Perform Action\" step, you may perform 2 actions.",
				"Darth Vader",
				true,
				EliteUpgrades,
				ShipType.TieAdvanced,
				Faction.EMPIRE
				), 1));	
	}
	
	private void InitializeFiresprayPilots()
	{
		UpgradeCount[] BaseUpgrades = new UpgradeCount[6];
		BaseUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		BaseUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		BaseUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Bomb), 0);
		BaseUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		BaseUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		BaseUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		UpgradeCount[] EliteUpgrades = new UpgradeCount[7];
		EliteUpgrades[0] = new UpgradeCount(new Upgrade(UpgradeType.Missile), 0);
		EliteUpgrades[1] = new UpgradeCount(new Upgrade(UpgradeType.Crew), 0);
		EliteUpgrades[2] = new UpgradeCount(new Upgrade(UpgradeType.Bomb), 0);
		EliteUpgrades[3] = new UpgradeCount(new Upgrade(UpgradeType.Cannon), 0);
		EliteUpgrades[4] = new UpgradeCount(new Upgrade(UpgradeType.EliteTalent), 0);
		EliteUpgrades[5] = new UpgradeCount(new Upgrade(UpgradeType.Modification), 0);
		EliteUpgrades[6] = new UpgradeCount(new Upgrade(UpgradeType.Title), 0);
		
		PilotsFirespray = new PilotsByShip(ShipType.Firespray31);
		PilotsFirespray.AddPilot(new UpgradeCount(new Pilot(
				33,
				"",
				"Bounty Hunter",
				false,
				BaseUpgrades,
				ShipType.Firespray31,
				Faction.EMPIRE
				), 1));
		PilotsFirespray.AddPilot(new UpgradeCount(new Pilot(
				36,
				"When attacking with a secondary weapon, you may reroll 1 attack die.",
				"Krassis Trelix",
				true,
				BaseUpgrades,
				ShipType.Firespray31,
				Faction.EMPIRE
				), 1));
		PilotsFirespray.AddPilot(new UpgradeCount(new Pilot(
				38,
				"When attacking, the defender receives 1 stress token if he cancels at least 1 CRIT result.",
				"Kath Scarlet",
				true,
				EliteUpgrades,
				ShipType.Firespray31,
				Faction.EMPIRE
				), 1));
		PilotsFirespray.AddPilot(new UpgradeCount(new Pilot(
				39,
				"When you reveal a bank maneuver, you may rotate your dial to the other bank maneuver of the same speed.",
				"Boba Fett",
				true,
				EliteUpgrades,
				ShipType.Firespray31,
				Faction.EMPIRE
				), 1));
	}
}
