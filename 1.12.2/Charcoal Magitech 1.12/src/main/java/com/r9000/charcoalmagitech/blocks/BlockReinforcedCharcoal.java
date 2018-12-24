package com.r9000.charcoalmagitech.blocks;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockReinforcedCharcoal extends Block {

	protected BlockReinforcedCharcoal(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(CharcoalMagitech.MODID + ":" + unlocalizedName);
		this.setHardness(15.0F);
		this.setResistance(1800.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeStone);
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}
}
