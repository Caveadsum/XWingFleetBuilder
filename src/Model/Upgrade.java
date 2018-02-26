package Model;
import Model.Enums.*;


public class Upgrade {


		/*
		 * Build an Xwing miniature fleet builder app/program.

	Double check decorator pattern.  Might could decorate ships with Enhancement, Action, Move, etc.

	Store expansions separately, so you can check which expansions you have and it'll automatically provide only those items available.

	Automatically tally Pilot and Enhancement costs.  Make suggestions based on how many points are left and what Enhancements have yet to be used.  Track and show total damage output per turn?

	Have Enhancement manager that tracks what is available: Ensures can not apply more than the total count as provided by applied expansions.  Ensures only one Unique (Luke Skywalker) can be applied.

	Can list by ship or by pilot.

	Be sure to have a Unique class member boolean, so you can't have Luke Skywalker pilot and gunner.

	Perhaps long term, also make a game for it so you can practice maneuvers against computer or other player (though there will undoubtedly be some legal issues to deal with)...unless you make your own game.

	Possible architecture:

	Highest class is Ship.
	A Ship has one each of Pilot, Title, and Modification.  The Pilot has a container of Enhancement and container of possible Enhancement.

	The Pilot has a total point cost that includes its own cost, plus the costs of any enhancements.

	Enhancement parent class - has Cost (int), Effect (text), Name (String), Unique (boolean)
	    Pilot - required Enhancement
	    Title - Unique, AllowedShip type
	    Modification
	    Weapon - Effective range(tuple of ints?), Damage(int)
	        Torpedo
	        Missile
	        Turret
	    Crew - Unique bool
	    Ability (or is this just Effect)
	    Allow/Disallow based on Republic or Empire.
		 */
		
		/******************************************************
		 * Enhancement parent class
		 ******************************************************/
		protected int Cost;
		protected String Effect;
		protected String Name;
		protected boolean Unique;
		protected UpgradeType Type;
		protected Faction Faction;

		public Upgrade()
		{
			
		}
		
		public Upgrade (UpgradeType t)
		{
			Cost = 0;
			Effect = "";
			Name = "NONE";
			Unique = false;
			Type = t;
			Faction = Faction.NONE;
		}
		
		public Upgrade (int c, String e, String n, boolean u, UpgradeType t, Faction fs)
		{
			/*
			SetCost(c);
			SetEffect(e);
			SetName(n);
			SetUnique(u);		
			SetType(t);
			*/
			
			Cost = c;
			Effect = e;
			Name = n;
			Unique = u;
			Type = t;
			Faction = fs;
		}
		
		private void SetCost(int cost)
		{
			Cost = cost;
		}
		
		public int Cost()
		{
			return Cost;
		}
		
		private void SetEffect(String effect)
		{
			Effect = effect;
		}
		
		public String Effect()
		{
			return Effect;
		}
		
		private void SetName(String name)
		{
			Name = name;
		}
		
		public String Name()
		{
			return Name;
		}
		
		private void SetUnique(boolean unique)
		{
			Unique = unique;
		}
		
		public boolean IsUnique()
		{
			return Unique;
		}
		
		private void SetType(UpgradeType t)
		{
			Type = t;
		}
		
		public UpgradeType Type()
		{
			return Type;
		}
		
		private void SetFaction(Faction faction)
		{
			Faction = faction;
		}
		
		public Faction Faction()
		{
			return Faction;
		}
}
