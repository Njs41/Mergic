package no.runsafe.mergic.magic.spells;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.WorldEffect;
import no.runsafe.mergic.magic.MagicSchool;
import no.runsafe.mergic.magic.Spell;
import no.runsafe.mergic.magic.SpellHandler;
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
	public void onCast(IPlayer player)
	{
		ILocation playerLocation = player.getLocation();
		if (playerLocation == null)
			return; // Drop here if we have a problem with the players location;

		for (IPlayer victim : playerLocation.getPlayersInRange(15))
		{
			// This is a test, it will act in opposite to what we want, but testing!
			if (!victim.getName().equals(player.getName()))
			{
				SpellHandler.killManager.registerAttack(victim, player); // Register a hit.
				victim.throwFromPoint(playerLocation); // Throw the player.

				ILocation victimLocation = victim.getLocation();

				if (victimLocation != null)
				{
//					victimLocation.playEffect(WorldEffect.ENCHANTMENT_TABLE, 1, 10, 50); // Shiny effect!
//					victimLocation.playSound(Sound.Player.Breath, 2, -1);
				}
			}
		}
	}
}
