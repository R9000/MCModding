package com.r9000.charcoalmagitech.blocks;

import java.util.List;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockCharcoalWire2 extends Block implements ITileEntityProvider {

	protected BlockCharcoalWire2(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(CharcoalMagitech.MODID + ":" + unlocalizedName);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundTypePiston);
	}
	
	@Override
    public int getRenderType() {
        return -1;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int x, int y, int z) {
    	float x1, y1, z1, x2, y2, z2;
    	x1=y1=z1=0.3125F;
    	x2=y2=z2=0.6875F;
    	
    	
		TileEntity te = iBlockAccess.getTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityBasicCharcoalWire2) {
			TileEntityBasicCharcoalWire2 wire = (TileEntityBasicCharcoalWire2)te;
			boolean connectedSides[] = wire.connectedSides;
			if(connectedSides != null) {
				if(connectedSides[0]) y1 = 0;
				if(connectedSides[1]) y2 = 1;
				if(connectedSides[2]) z1 = 0;
				if(connectedSides[3]) z2 = 1;
				if(connectedSides[4]) x1 = 0;
				if(connectedSides[5]) x2 = 1;
				}
		}
		this.setBlockBounds(x1, y1, z1, x2, y2, z2);
    }
    
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
    	float x1, y1, z1, x2, y2, z2;
    	x1=y1=z1=0.3125F;
    	x2=y2=z2=0.6875F;
    	
    	
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityBasicCharcoalWire2) {
			TileEntityBasicCharcoalWire2 wire = (TileEntityBasicCharcoalWire2)te;
			boolean connectedSides[] = wire.connectedSides;
			if(connectedSides != null) {
				if(connectedSides[0]) y1 = 0;
				if(connectedSides[1]) y2 = 1;
				if(connectedSides[2]) z1 = 0;
				if(connectedSides[3]) z2 = 1;
				if(connectedSides[4]) x1 = 0;
				if(connectedSides[5]) x2 = 1;
				}
		}
		this.setBlockBounds(x1, y1, z1, x2, y2, z2);
		super.addCollisionBoxesToList(world, x, y, z, box, list, entity);
    }
    
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		////////////Prints out connected network stuff for assistance with debugging.
		if(!world.isRemote && player.getHeldItem() != null && player.getHeldItem().getItem() == CMItems.osmelloscope) {
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof ICharcoalEnergyCarrier) {
				ICharcoalEnergyCarrier wire = (ICharcoalEnergyCarrier)te;
				PowerNetwork powerNetwork = wire.getNetwork();
				
				if(powerNetwork != null) {
					System.out.println("Connected wire positions:");
					for(int i = 0; i < powerNetwork.wires.size(); i++) {
						System.out.println(powerNetwork.wires.get(i).x + " " + powerNetwork.wires.get(i).y + " " + powerNetwork.wires.get(i).z);
					}
					System.out.println("Connected receiver positions:");
					for(int i = 0; i < powerNetwork.receivers.size(); i++) {
						System.out.println(powerNetwork.receivers.get(i).x + " " + powerNetwork.receivers.get(i).y + " " + powerNetwork.receivers.get(i).z);
					}
					System.out.println("Connected transmitter positions:");
					for(int i = 0; i < powerNetwork.transmitters.size(); i++) {
						System.out.println(powerNetwork.transmitters.get(i).x + " " + powerNetwork.transmitters.get(i).y + " " + powerNetwork.transmitters.get(i).z);
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		return meta;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if(!world.isRemote) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof ICharcoalEnergyCarrier) {
			ICharcoalEnergyCarrier carrier = (ICharcoalEnergyCarrier)te;
			if(carrier.getNetwork() != null){
				PowerNetwork wireNet = carrier.getNetwork();
				wireNet.refreshNetwork();
			}
			carrier.updateConnectedSides();
			}
		}
	}
	
	@Override
	 public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
		//Reforms the network to check if it is still connected.
		if(!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof ICharcoalEnergyCarrier) {
				ICharcoalEnergyCarrier wire = (ICharcoalEnergyCarrier)te;
				wire.setCanBeConnected(false);
				//System.out.println("Disconnecting adjacents");
				wire.disconnectAdjacentWires();
			}
		}
	}
}
