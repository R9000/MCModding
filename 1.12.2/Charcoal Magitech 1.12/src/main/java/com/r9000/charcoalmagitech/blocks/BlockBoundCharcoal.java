package com.r9000.charcoalmagitech.blocks;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBoundCharcoal extends BlockBase {

	protected BlockBoundCharcoal(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setHardness(6.0F);
		this.setResistance(11.0F);
		this.setCreativeTab(CharcoalMagitech.tabCharcoalMagitech);
		this.setSoundType(SoundType.STONE);
	}
}
