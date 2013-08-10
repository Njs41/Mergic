package no.runsafe.mergic.magic.spells;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.mergic.magic.MagicSchool;
import no.runsafe.mergic.magic.Spell;
import no.runsafe.mergic.magic.SpellType;

public class RepulsiveGale implements Spell
{
	@Override
	public int getCooldown()
	{
		return 7;
	}

	@Override
	public String getName()
	{
		return "Repulsive Gale";
	}

	@Override
	public MagicSchool getSchool()
	{
		return MagicSchool.WIND;
	}

	@Override
	public SpellType getType()
	{
		return SpellType.GENERIC;
	}

	@Override
	public String getDescription()
	{
		return "Pushes players away from you with gale force.";
	}

	@Override
	public void onCast(RunsafePlayer player)
	{
		RunsafeLocation playerLocation = player.getLocation();
		if (playerLocation == null)
			return; // Drop here if we have a problem with the players location;

		for (RunsafePlayer victim : playerLocation.getPlayersInRange(20))
		{
			// This is a test, it will act in opposite to what we want, but testing!
			victim.knockbackToPoint(playerLocation);
		}
	}
}