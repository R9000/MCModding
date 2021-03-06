package com.r9000.charcoalmagitech.blocks;

import java.util.ArrayList;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockChargeRelay extends Block implements ITileEntityProvider {

	public IIcon[] icons = new IIcon[2];
	
	public BlockChargeRelay(String unlocalizedName, Material material) {
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
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityChargeRelay();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		//NOT in a loop so I can see which icons are which in the icons array.
        this.icons[0] = reg.registerIcon(this.textureName + "_top");
        this.icons[1] = reg.registerIcon(this.textureName + "_side");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side > 1) return this.icons[1];
		else return this.icons[0];
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ)
    {
		if (!world.isRemote) {
			//Displays debug info about connected receivers:
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == CMItems.osmelloscope) {
				System.out.println("Current receivers at:");
				TileEntity te = world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityChargeRelay) {
					TileEntityChargeRelay ter = (TileEntityChargeRelay)te;
					
					for(int i = 0; i < ter.linkedReceivers.size(); i++) {
						BlockPos recPos = ter.linkedReceivers.get(i);
						System.out.println("x:" + recPos.x + " y:" + recPos.y + " z:" + recPos.z);
					}
				}
			}else{	//Opens GUI:
			FMLNetworkHandler.openGui(player, CharcoalMagitech.instance, 0, world, x, y, z);
			}
		}
		return true;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if(!world.isRemote && world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityChargeRelay) {
			TileEntityChargeRelay te = (TileEntityChargeRelay)world.getTileEntity(x, y, z);
			ArrayList<TileEntity> receivers = new ArrayList();
			if(world.getTileEntity(x-1, y, z) != null) receivers.add(world.getTileEntity(x-1, y, z));
			if(world.getTileEntity(x+1, y, z) != null) receivers.add(world.getTileEntity(x+1, y, z));
			if(world.getTileEntity(x, y, z-1) != null) receivers.add(world.getTileEntity(x, y, z-1));
			if(world.getTileEntity(x, y, z+1) != null) receivers.add(world.getTileEntity(x, y, z+1));
			for(int i = 0; i < receivers.size(); i++) {
				if(receivers.get(i) != null && receivers.get(i) instanceof TileEntityCharger) {
					
					TileEntityCharger charger = (TileEntityCharger) receivers.get(i);
					BlockPos coords = charger.centreCoords;
					if(charger.hasCompleteStructure) {
						if(charger.xCoord == coords.x && charger.yCoord == coords.y && charger.zCoord == coords.z) {
							te.addReceiverToList(new BlockPos(charger.xCoord, charger.yCoord, charger.zCoord));
						}else if(world.getTileEntity(coords.x, coords.y, coords.z) != null && world.getTileEntity(coords.x, coords.y, coords.z) instanceof TileEntityCharger) {
							te.addReceiverToList(new BlockPos(coords.x, coords.y, coords.z));
						}
					}
				}
			}
		}
	}
	
	@Override
	public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if(tileEntity != null && tileEntity instanceof TileEntityChargeRelay) {
			TileEntityChargeRelay tileEntityRelay = (TileEntityChargeRelay)tileEntity;
				if(tileEntityRelay.item != null) {
					world.spawnEntityInWorld(new EntityItem(world, x+0.5, y+0.5, z+0.5, tileEntityRelay.item));
					tileEntityRelay.removeItem();
				}
		}
	}
}
