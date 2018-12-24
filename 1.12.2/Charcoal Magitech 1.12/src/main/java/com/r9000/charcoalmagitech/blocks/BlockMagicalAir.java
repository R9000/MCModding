package com.r9000.charcoalmagitech.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMagicalAir extends BlockBase {
	
	public BlockMagicalAir(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setBlockUnbreakable();
		this.setLightLevel(14.0F);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	public int getRenderType()
    {
        return -1;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, BlockPos pos, IBlockState state)
    {
        return null;
    }
	
	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {
        return false;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int par2)
    {
		return null;
    }
	
	//How many world ticks before ticking:
	@Override
	public int tickRate(World world)
    {
		//10 Seconds
        return 200;
    }
	
	//Remove the block on update tick.
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote) {
        	world.setBlockToAir(pos);
        }
    }
	
	//Schedule removal on addition to world.
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        world.scheduleBlockUpdate(pos, this, this.tickRate(world), 1);
    }
}
