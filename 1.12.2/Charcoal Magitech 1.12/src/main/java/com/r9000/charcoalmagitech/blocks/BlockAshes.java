package com.r9000.charcoalmagitech.blocks;

import java.util.Random;

import com.r9000.charcoalmagitech.CharcoalMagitech;
import com.r9000.charcoalmagitech.init.CMBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAshes extends BlockBase {
	
	private Random rand = new Random();
	
	//Added BlockSnow methods from vanilla.
	public BlockAshes(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setCreativeTab(CharcoalMagitech.tabCharcoalMagitech);
		this.setSoundType(SoundType.SAND);
		float f = 0.5F;
        float f1 = 0.015625F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int par3) {
        return CMBlocks.charredSapling.getItemDropped(state, rand, par3);
    }
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
		if(!world.isRemote)
		{
			if(world.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.AIR || world.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == CMBlocks.ashPile)
			{
					EntityAshes ashes = new EntityAshes(world);
					ashes.setPosition((double)pos.getX()+0.5F, (double)pos.getY()+0.5F, (double)pos.getZ()+0.5F);
					world.setBlockToAir(pos);
					world.spawnEntityInWorld(ashes);
			}
		}
    }
	
	@Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
		//Base chance of 1/16 to drop a sapling, increases in 16ths until it's 50% at full meta.
        return (rand.nextFloat()*(float)(state.getBlock().getMetaFromState(state)+1) >= 1.75F) ? 1 : 0;
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(facing == EnumFacing.UP){
			if(!world.isRemote)
			{
				int meta = state.getBlock().getMetaFromState(state);
					if(player.getHeldItem(hand) != null && player.getHeldItem(hand).getItem() == Item.getItemFromBlock(this) && meta < 7)
						{
							world.setBlockState(pos, state., flags).setBlockMetadataWithNotify(pos, meta+1, 2);
						}
			}
		return true;
		}else{
			return false;
		}
    }
	
	//

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.calculateBounds(0);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z)
    {
    	BlockPos pos = new BlockPos(x, y, z);
        this.calculateBounds(access.getBlockState(pos).getBlockMetadata(x, y, z));
    }

    protected void calculateBounds(int meta)
    {
        int j = meta & 7;
        float f = ((float)meta+1)*0.03125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        IBlockState state = world.getBlockState(new BlockPos(x, y-1, z));
        return state.isOpaqueCube();
    }

    /**
     * Determines if a new block can be replace the space occupied by this one,
     * Used in the player's placement code to make the block act like water, and lava.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block is replaceable by another block
     */
    public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }
    
    //
}
