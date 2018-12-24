package com.r9000.charcoalmagitech.blocks;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockStratosphericAir extends BlockBase {
	public BlockStratosphericAir(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setHardness(2.0F);
		this.setCreativeTab(CharcoalMagitech.tabCharcoalMagitech);
		this.setSoundType(SoundType.SNOW);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}
