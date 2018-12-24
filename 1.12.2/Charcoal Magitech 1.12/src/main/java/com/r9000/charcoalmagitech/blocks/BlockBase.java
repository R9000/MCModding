package com.r9000.charcoalmagitech.blocks;

import com.r9000.charcoalmagitech.CharcoalMagitech;
import com.r9000.charcoalmagitech.init.CMBlocks;
import com.r9000.charcoalmagitech.init.CMItems;
import com.r9000.charcoalmagitech.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CharcoalMagitech.tabCharcoalMagitech);
		
		CMBlocks.BLOCKS.add(this);
		CMItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		CharcoalMagitech.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
