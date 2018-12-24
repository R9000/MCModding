package com.R9000.testmod.init;

import java.util.ArrayList;
import java.util.List;

import com.R9000.testmod.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block CAGE_BLOCK = new BlockBase("cage_block", Material.IRON);
	
}
