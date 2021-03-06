package com.r9000.charcoalmagitech.blocks;

import java.util.List;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockChargeStorageBattery extends BlockConfigurableSides implements ITileEntityProvider {

	protected BlockChargeStorageBattery(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(CharcoalMagitech.MODID + ":" + unlocalizedName);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundTypeMetal);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public int getRenderType() {
        return -1;
    }
	
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < 3; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public int damageDropped(int metadata) {
	    return metadata;
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int x, int y, int z) {
    	float lowerCorner=0.25F, upperCorner=0.75F, y1=0.25F, y2=0.75F;
    	
		TileEntityBatteryBase te = (TileEntityBatteryBase)iBlockAccess.getTileEntity(x, y, z);
		switch(te.powerBufferSize) {
		case 1600:
			lowerCorner=0.125F;
			upperCorner=0.875F;
			y1=0.1875F;
			y2 = 0.8125F;
			break;
		case 6400:
			lowerCorner=0.0625F;
			upperCorner=0.9375F;
			y1=0.125F;
			y2=0.875F;
			break;
		default:
		}
		
		this.setBlockBounds(lowerCorner, y1, lowerCorner, upperCorner, y2, upperCorner);
    }
	
	@Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
		float lowerCorner=0.25F, upperCorner=0.75F, y1=0.25F, y2=0.75F;
	    	
		TileEntityBatteryBase te = (TileEntityBatteryBase)world.getTileEntity(x, y, z);
		switch(te.powerBufferSize) {
		case 1600:
			lowerCorner=0.125F;
			upperCorner=0.875F;
			y1=0.1875F;
			y2 = 0.8125F;
			break;
		case 6400:
			lowerCorner=0.0625F;
			upperCorner=0.9375F;
			y1=0.125F;
			y2=0.875F;
			break;
		default:
		}
		
		this.setBlockBounds(lowerCorner, y1, lowerCorner, upperCorner, y2, upperCorner);
		super.addCollisionBoxesToList(world, x, y, z, box, list, entity);
    }
	
	/*
	@SideOnly(Side.CLIENT)
	@Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }
	
	*/
	
	/*
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return AxisAlignedBB.getBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }
	*/

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		switch(meta) {
		case 0:
			return new TileEntityT1Battery();
		case 1:
			return new TileEntityT2Battery();
		case 2:
			return new TileEntityT3Battery();
		default:
			return null;
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
		super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
		if (!world.isRemote && (player.getHeldItem() == null || player.getHeldItem().getItem() != Items.stick)) {
			FMLNetworkHandler.openGui(player, CharcoalMagitech.instance, 1, world, x, y, z);
		}
		return true;
	}
	
}
