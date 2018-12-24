package com.r9000.charcoalmagitech.blocks;

import java.util.Random;

import com.r9000.charcoalmagitech.CharcoalMagitech;
import com.r9000.charcoalmagitech.init.CMItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockSmoreOre extends BlockBase {

	protected BlockSmoreOre(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CharcoalMagitech.tabCharcoalMagitech);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return CMItems.smore;
	}

	@Override
	public int damageDropped(IBlockState state) {
	    return 0;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
	    return 1 + random.nextInt(3 + fortune);
	}
}