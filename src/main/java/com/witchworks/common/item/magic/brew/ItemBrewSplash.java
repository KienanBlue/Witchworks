package com.witchworks.common.item.magic.brew;

import com.witchworks.api.BrewRegistry;
import com.witchworks.common.entity.EntityBrew;
import com.witchworks.common.lib.LibItemName;
import com.witchworks.common.potions.BrewUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemBrewSplash extends ItemBrew {

	public ItemBrewSplash() {
		super(LibItemName.BREW_PHIAL_SPLASH);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		ItemStack copy = playerIn.capabilities.isCreativeMode ? itemstack.copy() : itemstack.splitStack(1);
		playerIn.playSound(SoundEvents.ENTITY_SPLASH_POTION_THROW, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			EntityBrew brew = new EntityBrew(worldIn, copy, EntityBrew.BrewDispersion.SPLASH);

			brew.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.5F, 1.0F);
			worldIn.spawnEntity(brew);
		}

		return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		BrewRegistry.getBrews().stream().filter(brew -> BrewRegistry.hasDefault(brew) && brew.getType() == BrewRegistry.Brew.SPLASH).forEach(
				brew -> subItems.add(BrewUtils.createBrew(itemIn, brew))
		);
	}
}
