package com.r9000.charcoalmagitech.blocks;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEntityDetector extends Block implements ITileEntityProvider {

	public IIcon[] icons = new IIcon[6];
	
	public BlockEntityDetector(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(CharcoalMagitech.MODID + ":" + unlocalizedName);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundTypeStone);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg) {
			this.icons[0] = reg.registerIcon(this.textureName + "_top");
			this.icons[1] = reg.registerIcon(this.textureName + "_bottom");
	    for (int i = 2; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName);
	    }
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        int k = getOrientation(meta);
        return k > 5 ? this.icons[0] : (side == k ? this.icons[0] : (side == Facing.oppositeSide[k] ? this.icons[1] : this.icons[2]));
    }
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}
	
	@Override
	public int damageDropped(int par1) {
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_)
    {
        return this.icons[2];
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.icons[0];
    }

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityEntityDetector();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ)
    {
		if (!world.isRemote) {
			ItemStack heldItem = player.getHeldItem();
			if(heldItem != null && heldItem.getItem() == CMItems.osmelloscope && heldItem.hasTagCompound()) {
				NBTTagCompound nbt = heldItem.getTagCompound();
				if(nbt.hasKey("savedEntityName")) {
					String nameToSave = nbt.getString("savedEntityName");
					if(nameToSave != null && nameToSave != "") {
						TileEntity te = world.getTileEntity(x, y, z);
						if(te != null && te instanceof TileEntityEntityDetector) {
							TileEntityEntityDetector ed = (TileEntityEntityDetector)te;
							ed.setText(nameToSave);
							player.addChatMessage(new ChatComponentText("Entity name successfully transferred!"));
						}
					}else{
						player.addChatMessage(new ChatComponentText("No entity saved in osmelloscope."));
					}
				}else{
					player.addChatMessage(new ChatComponentText("No entity saved in osmelloscope."));
				}
			}else{
			FMLNetworkHandler.openGui(player, CharcoalMagitech.instance, 3, world, x, y, z);
			}
		}
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
    {
        int l = determineOrientation(world, x, y, z, player);
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
        TileEntity te = world.getTileEntity(x, y, z);
        if(te != null && te instanceof TileEntityEntityDetector)
        {
        	TileEntityEntityDetector detector = (TileEntityEntityDetector)te;
        	detector.setOrientation(l);
        }
    }
	
	//Orientation methods taken from vanilla code.
	public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player)
    {
        if (MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F)
        {
            double d0 = player.posY + 1.82D - (double)player.yOffset;

            if (d0 - (double)y > 2.0D)
            {
                return 1;
            }

            if ((double)y - d0 > 0.0D)
            {
                return 0;
            }
        }

        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }	//0 = down, 1 = up, 2 = north, 3 = south, 4 = west, 5 = east.
	
	public static int getOrientation(int meta)
    {
        return meta & 7;
    }
	
	@Override
	public boolean canProvidePower()
    {
        return true;
    }
	
	@Override
	public int isProvidingWeakPower(IBlockAccess access, int x, int y, int z, int meta)	//Gets updated when TileEntity changes.
    {
		TileEntityEntityDetector te = (TileEntityEntityDetector)access.getTileEntity(x, y, z);
		boolean out = te.isActivated();
		if(out) {return 15;} else {return 0;}
    }
}
