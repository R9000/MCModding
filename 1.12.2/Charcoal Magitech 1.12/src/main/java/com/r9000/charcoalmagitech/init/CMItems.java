package com.r9000.charcoalmagitech.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.r9000.charcoalmagitech.info.ItemInfo;
import com.r9000.charcoalmagitech.items.CMItemArmor;
import com.r9000.charcoalmagitech.items.ItemBoundCharcoal;
import com.r9000.charcoalmagitech.items.ItemCharcoalAirWand;
import com.r9000.charcoalmagitech.items.ItemCharcoalFireWand;
import com.r9000.charcoalmagitech.items.ItemCharcoalPlantWand;
import com.r9000.charcoalmagitech.items.ItemCharcoalTeleportWand;
import com.r9000.charcoalmagitech.items.ItemCharcoalWand;
import com.r9000.charcoalmagitech.items.ItemCharcoalWaterWand;
import com.r9000.charcoalmagitech.items.ItemEnergizedCharcoal;
import com.r9000.charcoalmagitech.items.ItemHiEnergyCharcoal;
import com.r9000.charcoalmagitech.items.ItemOsmelloscope;
import com.r9000.charcoalmagitech.items.ItemPlasticSheet;
import com.r9000.charcoalmagitech.items.ItemPliableCharcoal;
import com.r9000.charcoalmagitech.items.ItemSmore;
import com.r9000.charcoalmagitech.items.ItemVoltageRegulatorCircuit;
import com.r9000.charcoalmagitech.items.ItemWandCrystal;
import com.r9000.charcoalmagitech.items.ItemWandHandle;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CMItems {
	public static ArmorMaterial CHARCOAL_ARMOR = EnumHelper.addArmorMaterial("CHARCOAL_ARMOR", 12, new int[] {2, 5, 4, 1}, 12);
	public static ArmorMaterial BOUND_CHARCOAL_ARMOR = EnumHelper.addArmorMaterial("BOUND_CHARCOAL_ARMOR", 20, new int[] {2, 5, 5, 2}, 13);
	public static ArmorMaterial REINFORCED_CHARCOAL_ARMOR = EnumHelper.addArmorMaterial("REINFORCED_CHARCOAL_ARMOR", 30, new int[] {3, 7, 6, 3}, 15);
	public static Item charcoalHelmet;
	public static Item charcoalChestplate;
	public static Item charcoalLeggings;
	public static Item charcoalBoots;
	public static Item boundCharcoalHelmet;
	public static Item boundCharcoalChestplate;
	public static Item boundCharcoalLeggings;
	public static Item boundCharcoalBoots;
	public static Item reinforcedCharcoalHelmet;
	public static Item reinforcedCharcoalChestplate;
	public static Item reinforcedCharcoalLeggings;
	public static Item reinforcedCharcoalBoots;
	
	public static Item boundCharcoal;
	public static Item hiEnergyCharcoal;
	public static Item wandHandle;
	public static Item wandCrystal;
	public static Item smore;
	public static Item deliciousHotSmore;
	public static Item pliableCharcoal;
	public static Item plasticSheet;
	public static Item voltageRegCircuit;
	
	public static Item energizedCharcoal;
	public static Item charcoalWand;
	public static Item charcoalWaterWand;
	public static Item charcoalFireWand;
	public static Item charcoalTeleportWand;
	public static Item charcoalPlantWand;
	public static Item charcoalAirWand;
	
	public static Item osmelloscope;
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static void init() {
		boundCharcoal = new ItemBoundCharcoal().setUnlocalizedName(ItemInfo.BOUNDCHARCOAL_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMaterials);
		hiEnergyCharcoal = new ItemHiEnergyCharcoal().setUnlocalizedName(ItemInfo.HIENERGYCHARCOAL_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMaterials);
		energizedCharcoal = new ItemEnergizedCharcoal().setUnlocalizedName(ItemInfo.ENERGIZEDCHARCOAL_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(1).setMaxDamage(200);
		wandHandle = new ItemWandHandle().setUnlocalizedName(ItemInfo.WANDHANDLE_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMisc);
		wandCrystal = new ItemWandCrystal(ItemInfo.WANDCRYSTAL_UNLOCALIZED_NAME).setUnlocalizedName(ItemInfo.WANDCRYSTAL_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMisc);
		smore = new ItemSmore(4, false).setUnlocalizedName(ItemInfo.SMORE_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabFood);
		deliciousHotSmore = new ItemSmore(8, false).setUnlocalizedName(ItemInfo.DELICIOUS_HOT_SMORE_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabFood);
		pliableCharcoal = new ItemPliableCharcoal().setUnlocalizedName(ItemInfo.PLIABLECHARCOAL_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMaterials);
		plasticSheet = new ItemPlasticSheet().setUnlocalizedName(ItemInfo.PLASTICSHEET_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMaterials);
		voltageRegCircuit = new ItemVoltageRegulatorCircuit().setUnlocalizedName(ItemInfo.VOLTAGEREGULATORCIRCUIT_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabMisc);
		
		charcoalWand = new ItemCharcoalWand().setUnlocalizedName(ItemInfo.CHARCOALWAND_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(200);
		charcoalWaterWand = new ItemCharcoalWaterWand().setUnlocalizedName(ItemInfo.CHARCOALWATERWAND_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(200);
		charcoalFireWand = new ItemCharcoalFireWand().setUnlocalizedName(ItemInfo.CHARCOALFIREWAND_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(200);
		charcoalTeleportWand = new ItemCharcoalTeleportWand().setUnlocalizedName(ItemInfo.CHARCOALTELEPORTWAND_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(200);
		charcoalPlantWand = new ItemCharcoalPlantWand().setUnlocalizedName(ItemInfo.CHARCOALPLANTWAND_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(200);
		charcoalAirWand = new ItemCharcoalAirWand().setUnlocalizedName(ItemInfo.CHARCOALAIRWAND_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(200);
		osmelloscope = new ItemOsmelloscope().setUnlocalizedName(ItemInfo.OSMELLOSCOPE_UNLOCALIZED_NAME).setCreativeTab(CreativeTabs.tabTools);
	}
	
	public static void registerItems() {
		//Armor Registry:
		GameRegistry.registerItem(charcoalHelmet = new CMItemArmor(ItemInfo.CHARCOALHELMET_UNLOCALIZED_NAME, CHARCOAL_ARMOR, "charcoal", 0), ItemInfo.CHARCOALHELMET_UNLOCALIZED_NAME);
		GameRegistry.registerItem(charcoalChestplate = new CMItemArmor(ItemInfo.CHARCOALCHEST_UNLOCALIZED_NAME, CHARCOAL_ARMOR, "charcoal", 1), ItemInfo.CHARCOALCHEST_UNLOCALIZED_NAME);
		GameRegistry.registerItem(charcoalLeggings = new CMItemArmor(ItemInfo.CHARCOALLEGS_UNLOCALIZED_NAME, CHARCOAL_ARMOR, "charcoal", 2), ItemInfo.CHARCOALLEGS_UNLOCALIZED_NAME);
		GameRegistry.registerItem(charcoalBoots = new CMItemArmor(ItemInfo.CHARCOALBOOTS_UNLOCALIZED_NAME, CHARCOAL_ARMOR, "charcoal", 3), ItemInfo.CHARCOALBOOTS_UNLOCALIZED_NAME);
		charcoalHelmet.setTextureName(CharcoalMod.MODID + ":charcoalHelmet");
		charcoalChestplate.setTextureName(CharcoalMod.MODID + ":charcoalChestplate");
		charcoalLeggings.setTextureName(CharcoalMod.MODID + ":charcoalLeggings");
		charcoalBoots.setTextureName(CharcoalMod.MODID + ":charcoalBoots");
		
		GameRegistry.registerItem(boundCharcoalHelmet = new CMItemArmor(ItemInfo.BOUNDCHARCOALHELMET_UNLOCALIZED_NAME, BOUND_CHARCOAL_ARMOR, "boundCharcoal", 0), ItemInfo.BOUNDCHARCOALHELMET_UNLOCALIZED_NAME);
		GameRegistry.registerItem(boundCharcoalChestplate = new CMItemArmor(ItemInfo.BOUNDCHARCOALCHEST_UNLOCALIZED_NAME, BOUND_CHARCOAL_ARMOR, "boundCharcoal", 1), ItemInfo.BOUNDCHARCOALCHEST_UNLOCALIZED_NAME);
		GameRegistry.registerItem(boundCharcoalLeggings = new CMItemArmor(ItemInfo.BOUNDCHARCOALLEGS_UNLOCALIZED_NAME, BOUND_CHARCOAL_ARMOR, "boundCharcoal", 2), ItemInfo.BOUNDCHARCOALLEGS_UNLOCALIZED_NAME);
		GameRegistry.registerItem(boundCharcoalBoots = new CMItemArmor(ItemInfo.BOUNDCHARCOALBOOTS_UNLOCALIZED_NAME, BOUND_CHARCOAL_ARMOR, "boundCharcoal", 3), ItemInfo.BOUNDCHARCOALBOOTS_UNLOCALIZED_NAME);
		boundCharcoalHelmet.setTextureName(CharcoalMod.MODID + ":boundCharcoalHelmet");
		boundCharcoalChestplate.setTextureName(CharcoalMod.MODID + ":boundCharcoalChestplate");
		boundCharcoalLeggings.setTextureName(CharcoalMod.MODID + ":boundCharcoalLeggings");
		boundCharcoalBoots.setTextureName(CharcoalMod.MODID + ":boundCharcoalBoots");
		
		GameRegistry.registerItem(reinforcedCharcoalHelmet = new CMItemArmor(ItemInfo.REINFORCEDCHARCOALHELMET_UNLOCALIZED_NAME, REINFORCED_CHARCOAL_ARMOR, "reinforcedCharcoal", 0), ItemInfo.REINFORCEDCHARCOALHELMET_UNLOCALIZED_NAME);
		GameRegistry.registerItem(reinforcedCharcoalChestplate = new CMItemArmor(ItemInfo.REINFORCEDCHARCOALCHEST_UNLOCALIZED_NAME, REINFORCED_CHARCOAL_ARMOR, "reinforcedCharcoal", 1), ItemInfo.REINFORCEDCHARCOALCHEST_UNLOCALIZED_NAME);
		GameRegistry.registerItem(reinforcedCharcoalLeggings = new CMItemArmor(ItemInfo.REINFORCEDCHARCOALLEGS_UNLOCALIZED_NAME, REINFORCED_CHARCOAL_ARMOR, "reinforcedCharcoal", 2), ItemInfo.REINFORCEDCHARCOALLEGS_UNLOCALIZED_NAME);
		GameRegistry.registerItem(reinforcedCharcoalBoots = new CMItemArmor(ItemInfo.REINFORCEDCHARCOALBOOTS_UNLOCALIZED_NAME, REINFORCED_CHARCOAL_ARMOR, "reinforcedCharcoal", 3), ItemInfo.REINFORCEDCHARCOALBOOTS_UNLOCALIZED_NAME);
		reinforcedCharcoalHelmet.setTextureName(CharcoalMod.MODID + ":reinforcedCharcoalHelmet");
		reinforcedCharcoalChestplate.setTextureName(CharcoalMod.MODID + ":reinforcedCharcoalChestplate");
		reinforcedCharcoalLeggings.setTextureName(CharcoalMod.MODID + ":reinforcedCharcoalLeggings");
		reinforcedCharcoalBoots.setTextureName(CharcoalMod.MODID + ":reinforcedCharcoalBoots");
		//End of Armor Registry.
		
		//Regular Item Registry:
		GameRegistry.registerItem(boundCharcoal, ItemInfo.BOUNDCHARCOAL_UNLOCALIZED_NAME);
		boundCharcoal.setTextureName(CharcoalMod.MODID + ":boundCharcoal");
		GameRegistry.registerItem(hiEnergyCharcoal, ItemInfo.HIENERGYCHARCOAL_UNLOCALIZED_NAME);
		hiEnergyCharcoal.setTextureName(CharcoalMod.MODID + ":hiEnergyCharcoal");
		GameRegistry.registerItem(energizedCharcoal, ItemInfo.ENERGIZEDCHARCOAL_UNLOCALIZED_NAME);
		GameRegistry.registerItem(wandHandle, ItemInfo.WANDHANDLE_UNLOCALIZED_NAME);
		wandHandle.setTextureName(CharcoalMod.MODID + ":wandHandle");
		GameRegistry.registerItem(wandCrystal, ItemInfo.WANDCRYSTAL_UNLOCALIZED_NAME);
		GameRegistry.registerItem(smore, ItemInfo.SMORE_UNLOCALIZED_NAME);
		smore.setTextureName(CharcoalMod.MODID + ":smore");
		GameRegistry.registerItem(deliciousHotSmore, ItemInfo.DELICIOUS_HOT_SMORE_UNLOCALIZED_NAME);
		deliciousHotSmore.setTextureName(CharcoalMod.MODID + ":delicious_hot_smore");
		GameRegistry.registerItem(pliableCharcoal, ItemInfo.PLIABLECHARCOAL_UNLOCALIZED_NAME);
		pliableCharcoal.setTextureName(CharcoalMod.MODID + ":pliable_charcoal");
		GameRegistry.registerItem(plasticSheet, ItemInfo.PLASTICSHEET_UNLOCALIZED_NAME);
		plasticSheet.setTextureName(CharcoalMod.MODID + ":plastic_sheet");
		GameRegistry.registerItem(voltageRegCircuit, ItemInfo.VOLTAGEREGULATORCIRCUIT_UNLOCALIZED_NAME);
		voltageRegCircuit.setTextureName(CharcoalMod.MODID + ":voltage_regulator_circuit");
		
		//Tool/Weapon Registry:
		GameRegistry.registerItem(charcoalWand, ItemInfo.CHARCOALWAND_UNLOCALIZED_NAME);
		charcoalWand.setTextureName(CharcoalMod.MODID + ":charcoalWand");
		GameRegistry.registerItem(charcoalWaterWand, ItemInfo.CHARCOALWATERWAND_UNLOCALIZED_NAME);
		charcoalWaterWand.setTextureName(CharcoalMod.MODID + ":charcoalWaterWand");
		GameRegistry.registerItem(charcoalFireWand, ItemInfo.CHARCOALFIREWAND_UNLOCALIZED_NAME);
		//charcoalFireWand.setTextureName(CharcoalMod.MODID + ":charcoalFireWand");
		GameRegistry.registerItem(charcoalTeleportWand, ItemInfo.CHARCOALTELEPORTWAND_UNLOCALIZED_NAME);
		charcoalTeleportWand.setTextureName(CharcoalMod.MODID + ":charcoalTeleportWand");
		GameRegistry.registerItem(charcoalPlantWand, ItemInfo.CHARCOALPLANTWAND_UNLOCALIZED_NAME);
		charcoalPlantWand.setTextureName(CharcoalMod.MODID + ":charcoalPlantWand");
		GameRegistry.registerItem(charcoalAirWand, ItemInfo.CHARCOALAIRWAND_UNLOCALIZED_NAME);
		charcoalAirWand.setTextureName(CharcoalMod.MODID + ":charcoalAirWand");
		
		GameRegistry.registerItem(osmelloscope, ItemInfo.OSMELLOSCOPE_UNLOCALIZED_NAME);
		osmelloscope.setTextureName(CharcoalMod.MODID + ":osmelloscope");
	}
	
	public static void registerRenders() {
		//registerRender(bot, 0);
	}
	
	public static void registerRender(Item item, int meta) {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(ModInformation.ID + ":" + item.getUnlocalizedName().substring(5) + meta, "Inventory"));
	}
	
	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.charcoalHelmet), new Object[] {"###", "# #", '#', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.charcoalChestplate), new Object[] {"# #", "###", "###", '#', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.charcoalLeggings), new Object[] {"###", "# #", "# #", '#', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.charcoalBoots), new Object[] {"# #", "# #", '#', new ItemStack(Items.coal, 1, 1)});
		
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.boundCharcoalHelmet), new Object[] {"###", "# #", '#', CMItems.boundCharcoal});
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.boundCharcoalChestplate), new Object[] {"# #", "###", "###", '#', CMItems.boundCharcoal});
		GameRegistry.addShapedRecipe(new ItemStack(CMItems.boundCharcoalLeggings), new Object[] {"###", "# #", "# #", '#', CMItems.boundCharcoal});
		ItemStack springyBoots = new ItemStack(CMItems.boundCharcoalBoots);
		springyBoots.addEnchantment(Enchantment.featherFalling, 4);	//Add feather falling to the boots.
		GameRegistry.addShapedRecipe(springyBoots, new Object[] {"# #", "# #", '#', CMItems.boundCharcoal});
		
		ItemStack heatHelmet = new ItemStack(CMItems.reinforcedCharcoalHelmet);
		heatHelmet.addEnchantment(Enchantment.fireProtection, 4);
		ItemStack heatShirt = new ItemStack(CMItems.reinforcedCharcoalChestplate);
		heatShirt.addEnchantment(Enchantment.fireProtection, 4);
		ItemStack heatTrousers = new ItemStack(CMItems.reinforcedCharcoalLeggings);
		heatTrousers.addEnchantment(Enchantment.fireProtection, 4);
		ItemStack heatFeet = new ItemStack(CMItems.reinforcedCharcoalBoots);
		heatFeet.addEnchantment(Enchantment.fireProtection, 4);
		
		GameRegistry.addShapedRecipe(heatHelmet, new Object[] {"###", "# #", '#', new ItemStack(CMBlocks.reinforcedCharcoalBlock)});
		GameRegistry.addShapedRecipe(heatShirt, new Object[] {"# #", "###", "###", '#', new ItemStack(CMBlocks.reinforcedCharcoalBlock)});
		GameRegistry.addShapedRecipe(heatTrousers, new Object[] {"###", "# #", "# #", '#', new ItemStack(CMBlocks.reinforcedCharcoalBlock)});
		GameRegistry.addShapedRecipe(heatFeet, new Object[] {"# #", "# #", '#', new ItemStack(CMBlocks.reinforcedCharcoalBlock)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(boundCharcoal), new Object[] {new ItemStack(Items.coal, 1, 1), Items.slime_ball});
		GameRegistry.addShapedRecipe(new ItemStack(hiEnergyCharcoal), new Object[] {"SSS", "SBS", "SSS", 'S', Items.sugar, 'B', new ItemStack(CMBlocks.charcoalBlock)});
		GameRegistry.addSmelting(smore, new ItemStack(deliciousHotSmore), 1.0F);
		GameRegistry.addSmelting(boundCharcoal, new ItemStack(pliableCharcoal), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(plasticSheet, 2), new Object[] {pliableCharcoal, pliableCharcoal, pliableCharcoal, pliableCharcoal, new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(voltageRegCircuit), new Object[] {"wRw", "gcg", "qqq", 'R', Items.repeater, 'w', new ItemStack(CMBlocks.basicWire2), 'c', Items.comparator, 'g', Items.gold_ingot, 'q', Items.quartz});
		
		ItemStack emptyCrystal = new ItemStack(energizedCharcoal);
		emptyCrystal.attemptDamageItem(200, new Random());
		GameRegistry.addShapedRecipe(emptyCrystal, new Object[] {"RBR", "CDC", "RBR", 'R', Items.redstone, 'B', Items.blaze_powder, 'D', Items.diamond, 'C', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(wandHandle), new Object[] {" cB", "cBc", "Bc ", 'c', new ItemStack(Items.coal, 1, 1), 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(wandHandle), new Object[] {" bC", "bCb", "Cb ", 'C', new ItemStack(CMBlocks.charredLog), 'b', Items.blaze_powder});
		GameRegistry.addShapedRecipe(new ItemStack(wandCrystal, 1, 0), new Object[] {" h ", "hCh", " h ", 'C', energizedCharcoal, 'h', hiEnergyCharcoal});
		
		GameRegistry.addShapedRecipe(new ItemStack(charcoalWand), new Object[] {" C", "h ", 'C', new ItemStack(wandCrystal, 1, 0), 'h', wandHandle});
		GameRegistry.addShapedRecipe(new ItemStack(charcoalWaterWand), new Object[] {" C", "h ", 'C', new ItemStack(wandCrystal, 1, 1), 'h', wandHandle});
		GameRegistry.addShapedRecipe(new ItemStack(charcoalFireWand), new Object[] {" C", "h ", 'C', new ItemStack(wandCrystal, 1, 2), 'h', wandHandle});
		GameRegistry.addShapedRecipe(new ItemStack(charcoalTeleportWand), new Object[] {" C", "h ", 'C', new ItemStack(wandCrystal, 1, 3), 'h', wandHandle});
		GameRegistry.addShapedRecipe(new ItemStack(charcoalPlantWand), new Object[] {" C", "h ", 'C', new ItemStack(wandCrystal, 1, 4), 'h', wandHandle});
		GameRegistry.addShapedRecipe(new ItemStack(charcoalAirWand), new Object[] {" C", "h ", 'C', new ItemStack(wandCrystal, 1, 5), 'h', wandHandle});
	}
}
