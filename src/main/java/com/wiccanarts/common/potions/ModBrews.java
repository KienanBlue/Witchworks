package com.wiccanarts.common.potions;

import com.wiccanarts.api.BrewRegistry;
import com.wiccanarts.api.item.BrewEffect;
import com.wiccanarts.api.item.IBrew;
import com.wiccanarts.common.lib.LibMod;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder (LibMod.MOD_ID)
public final class ModBrews {

	public static IBrew SHELL_ARMOR;

	private ModBrews() {
	}

	public static void init() {
		SHELL_ARMOR = BrewRegistry.registerBrew(new ShellArmorBrew());
		BrewRegistry.addDefault(new BrewEffect(SHELL_ARMOR, 2500, false));
	}
}
