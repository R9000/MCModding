package com.r9000.charcoalmagitech.init;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import com.r9000.charcoalmagitech.blocks.BlockAshes;
import com.r9000.charcoalmagitech.blocks.BlockBasicCharcoalWire2;
import com.r9000.charcoalmagitech.blocks.BlockBoundCharcoal;
import com.r9000.charcoalmagitech.blocks.BlockCharcoal;
import com.r9000.charcoalmagitech.blocks.BlockChargeRelay;
import com.r9000.charcoalmagitech.blocks.BlockChargeStorageBattery;
import com.r9000.charcoalmagitech.blocks.BlockCharger;
import com.r9000.charcoalmagitech.blocks.BlockCharredLeaves;
import com.r9000.charcoalmagitech.blocks.BlockCharredLog;
import com.r9000.charcoalmagitech.blocks.BlockCharredSapling;
import com.r9000.charcoalmagitech.blocks.BlockEnderChunk;
import com.r9000.charcoalmagitech.blocks.BlockEntityDetector;
import com.r9000.charcoalmagitech.blocks.BlockFlare;
import com.r9000.charcoalmagitech.blocks.BlockItemDetector;
import com.r9000.charcoalmagitech.blocks.BlockMagicalAir;
import com.r9000.charcoalmagitech.blocks.BlockReinforcedCharcoal;
import com.r9000.charcoalmagitech.blocks.BlockShieldLeaves;
import com.r9000.charcoalmagitech.blocks.BlockSmoreOre;
import com.r9000.charcoalmagitech.blocks.BlockStratosphericAir;
import com.r9000.charcoalmagitech.blocks.BlockValidCharger;
import com.r9000.charcoalmagitech.info.BlockInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CMBlocks {
	public static Block charcoalBlock;
	public static Block boundCharcoalBlock;
	public static Block reinforcedCharcoalBlock;
	public static Block charredLog;
	public static Block charredLeaves;
	public static Block charredSapling;
	public static Block leafShield;
	public static Block enderChunk;
	public static Block chargerFrame;
	public static Block validChargerFrame;
	public static Block chargeRelay;
	public static Block stratosphericAir;
	public static Block magicalAir;
	public static Block basicWire2;
	public static Block smoreOre;
	public static Block storageBattery;
	public static Block ashPile;
	public static Block itemDetector;
	public static Block entityDetector;
	public static Block flare;
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static void init() {
		GameRegistry.registerBlock(charcoalBlock = new BlockCharcoal(BlockInfo.CHARCOALBLOCK_UNLOCALIZED_NAME, Material.rock), BlockInfo.CHARCOALBLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(boundCharcoalBlock = new BlockBoundCharcoal(BlockInfo.BOUNDCHARCOALBLOCK_UNLOCALIZED_NAME, Material.rock), BlockInfo.BOUNDCHARCOALBLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(reinforcedCharcoalBlock = new BlockReinforcedCharcoal(BlockInfo.REINFORCEDCHARCOALBLOCK_UNLOCALIZED_NAME, Material.rock), BlockInfo.REINFORCEDCHARCOALBLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(charredLog = new BlockCharredLog(BlockInfo.CHARREDLOG_UNLOCALIZED_NAME, Material.wood), BlockInfo.CHARREDLOG_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(charredLeaves = new BlockCharredLeaves(BlockInfo.CHARREDLEAVES_UNLOCALIZED_NAME, Material.leaves), BlockInfo.CHARREDLEAVES_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(charredSapling = new BlockCharredSapling(), BlockInfo.CHARREDSAPLING_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(leafShield = new BlockShieldLeaves(BlockInfo.LEAFSHIELD_UNLOCALIZED_NAME, Material.leaves), BlockInfo.LEAFSHIELD_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(enderChunk = new BlockEnderChunk(BlockInfo.ENDERCHUNK_UNLOCALIZED_NAME, Material.rock), BlockInfo.ENDERCHUNK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(chargerFrame = new BlockCharger(BlockInfo.CHARGER_UNLOCALIZED_NAME, Material.iron), BlockInfo.CHARGER_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(validChargerFrame = new BlockValidCharger(BlockInfo.VALIDCHARGER_UNLOCALIZED_NAME, Material.iron), BlockInfo.VALIDCHARGER_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(chargeRelay = new BlockChargeRelay(BlockInfo.RELAY_UNLOCALIZED_NAME, Material.iron), BlockInfo.RELAY_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(stratosphericAir = new BlockStratosphericAir(BlockInfo.S_AIR_UNLOCALIZED_NAME, Material.sponge), BlockInfo.S_AIR_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(magicalAir = new BlockMagicalAir(BlockInfo.MAGICALAIR_UNLOCALIZED_NAME, (Material.glass)), BlockInfo.MAGICALAIR_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(basicWire2 = new BlockBasicCharcoalWire2(BlockInfo.BASICWIRE2_UNLOCALIZED_NAME, Material.iron), BlockInfo.BASICWIRE2_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(smoreOre = new BlockSmoreOre(BlockInfo.SMOREORE_UNLOCALIZED_NAME, Material.rock), BlockInfo.SMOREORE_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(ashPile = new BlockAshes(BlockInfo.ASHPILE_UNLOCALIZED_NAME, Material.sand), BlockInfo.ASHPILE_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(itemDetector = new BlockItemDetector(BlockInfo.ITEMDETECTOR_UNLOCALIZED_NAME, Material.piston), BlockInfo.ITEMDETECTOR_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(entityDetector = new BlockEntityDetector(BlockInfo.ENTITYDETECTOR_UNLOCALIZED_NAME, Material.piston), BlockInfo.ENTITYDETECTOR_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(flare = new BlockFlare(BlockInfo.FLARE_UNLOCALIZED_NAME, Material.circuits), BlockInfo.FLARE_UNLOCALIZED_NAME);
		
		GameRegistry.registerBlock(storageBattery = new BlockChargeStorageBattery(BlockInfo.BATTERY_UNLOCALIZED_NAME, Material.iron), ItemBlockBatteryBlock.class, BlockInfo.BATTERY_UNLOCALIZED_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityCharger.class, BlockInfo.CHARGER_KEY);
		GameRegistry.registerTileEntity(TileEntityChargeRelay.class, BlockInfo.RELAY_KEY);
		GameRegistry.registerTileEntity(TileEntityBasicCharcoalWire2.class, BlockInfo.BASICWIRE2_KEY);
		GameRegistry.registerTileEntity(TileEntityItemDetector.class, BlockInfo.DETECTOR_KEY);
		GameRegistry.registerTileEntity(TileEntityEntityDetector.class, BlockInfo.ENTITY_DETECTOR_KEY);
		GameRegistry.registerTileEntity(TileEntityFlare.class, BlockInfo.FLARE_KEY);
		//Battery tiers:
		GameRegistry.registerTileEntity(TileEntityT1Battery.class, BlockInfo.BATTERY_KEY[0]);
		GameRegistry.registerTileEntity(TileEntityT2Battery.class, BlockInfo.BATTERY_KEY[1]);
		GameRegistry.registerTileEntity(TileEntityT3Battery.class, BlockInfo.BATTERY_KEY[2]);
	}
	
	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.charcoalBlock), new Object[] {"###", "###", "###", '#', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.boundCharcoalBlock), new Object[] {"###", "###", "###", '#', CMItems.boundCharcoal});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.enderChunk), new Object[] {"#o#", "oBo", "#o#", '#', Blocks.end_stone, 'o', Items.ender_pearl, 'B', CMItems.hiEnergyCharcoal});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, 9, 1), new ItemStack(CMBlocks.charcoalBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(CMItems.boundCharcoal, 9), new ItemStack(CMBlocks.boundCharcoalBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, 2, 1), new ItemStack(CMBlocks.charredLog));
		GameRegistry.addSmelting(CMBlocks.boundCharcoalBlock, new ItemStack(CMBlocks.reinforcedCharcoalBlock), 1.0F);
		GameRegistry.addSmelting(CMBlocks.smoreOre, new ItemStack(CMItems.deliciousHotSmore, 3), 1.0F);
		
		ItemStack emptyCrystal = new ItemStack(CMItems.energizedCharcoal);
		emptyCrystal.attemptDamageItem(200, new Random());
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.chargerFrame), new Object[] {"BRB", "GCG", "BRB", 'R', new ItemStack(Blocks.redstone_block), 'C', emptyCrystal, 'G', Items.gold_ingot, 'B', Items.brick});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.chargeRelay), new Object[] {"ICI", "GFG", "ICI", 'I', Items.iron_ingot, 'C', emptyCrystal, 'G', Items.gold_ingot, 'F', new ItemStack(Blocks.furnace)});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.storageBattery, 1, 0), new Object[] {"WCW", "CLC", "PCP", 'P', CMItems.plasticSheet, 'C', emptyCrystal, 'W', CMItems.wandHandle, 'L', Items.lava_bucket});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.storageBattery, 1, 1), new Object[] {" V ", "BbB", " W ", 'V', CMItems.voltageRegCircuit, 'B', new ItemStack(CMBlocks.storageBattery, 1, 0), 'W', basicWire2, 'b', new ItemStack(boundCharcoalBlock)});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.storageBattery, 1, 2), new Object[] {"BWB", "VRV", "BWB", 'V', CMItems.voltageRegCircuit, 'B', new ItemStack(CMBlocks.storageBattery, 1, 1), 'W', basicWire2, 'R', new ItemStack(reinforcedCharcoalBlock)});
		GameRegistry.addShapedRecipe(new ItemStack(basicWire2, 3), new Object[] {" p ", "GEG", " p ", 'p', CMItems.pliableCharcoal, 'E', CMItems.hiEnergyCharcoal, 'G', Items.gold_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.itemDetector), new Object[] {"IGI", "RCR", "IXI", 'C', Items.comparator, 'I', Items.iron_ingot, 'G', new ItemStack(Blocks.glass_pane), 'X', new ItemStack(Blocks.chest), 'R', Items.redstone});
		GameRegistry.addShapedRecipe(new ItemStack(CMBlocks.entityDetector), new Object[] {"IGI", "RCR", "IXI", 'C', Items.comparator, 'I', Items.iron_ingot, 'G', new ItemStack(Blocks.glass_pane), 'X', Items.writable_book, 'R', Items.redstone});
	}
	
	public static void registerRender(Block block, int meta) {
		Item item = Item.getItemFromBlock(block);
	}
}
