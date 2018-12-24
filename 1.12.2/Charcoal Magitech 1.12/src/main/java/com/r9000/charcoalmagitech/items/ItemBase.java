package com.r9000.charcoalmagitech.items;

import com.r9000.charcoalmagitech.CharcoalMagitech;
import com.r9000.charcoalmagitech.init.CMItems;
import com.r9000.charcoalmagitech.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		CMItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
	
		CharcoalMagitech.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
