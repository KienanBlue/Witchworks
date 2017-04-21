package com.wiccanarts.api.sound;

import com.wiccanarts.api.WiccanArtsAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class WiccaSoundEvents {

	public static final SoundEvent BOIL = getRegisteredSound(WiccanArtsAPI.BOIL);
	public static final SoundEvent BUZZ = getRegisteredSound(WiccanArtsAPI.BUZZ);

	private WiccaSoundEvents() {
	}

	private static SoundEvent getRegisteredSound(ResourceLocation name) {
		return SoundEvent.REGISTRY.getObject(name);
	}
}
