package com.r9000.charcoalmagitech.blocks;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCharredLog extends BlockLog {

	public IIcon[] icons = new IIcon[6];
	
	public BlockCharredLog(String unlocalizedName, Material material) {
		super();
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(CharcoalMagitech.MODID + ":" + unlocalizedName);
		this.setHardness(2.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeWood);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for(int i = 0; i < 2; i++) {
			this.icons[i] = reg.registerIcon(this.textureName + "_top");
		}
	    for (int i = 2; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName);
	    }
	}
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}
	
	//@Override
	//public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        //return Item.getItemFromBlock(CMBlocks.charredLog);
    //}
	
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
}
