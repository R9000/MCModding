package com.r9000.charcoalmagitech.blocks;

import java.util.Random;

import com.r9000.charcoalmagitech.CharcoalMagitech;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCharcoal extends BlockBase {
	Random rand = new Random();

	protected BlockCharcoal(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CharcoalMagitech.tabCharcoalMagitech);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		//Spawn smoke client-side if entity is walking on top of charcoal block. 2x the amount if entity is a sprinting player.
		if(world.isRemote && (Math.abs(entity.motionX) + Math.abs(entity.motionZ))>0) {
			for(int i = 0; i<4; i++){
				world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, entity.posX-0.5+rand.nextFloat(), entity.posY-1.5, entity.posZ-0.5+rand.nextFloat(), 0.0D, 0.0D, 0.0D);
			}
			if(entity instanceof EntityPlayer && entity.isSprinting()) {
				for(int i = 0; i<4; i++){		//SPAWN MOAR SMOKE!!!
					world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, entity.posX-0.5+rand.nextFloat(), entity.posY-1.5, entity.posZ-0.5+rand.nextFloat(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}
