package com.r9000.charcoalmagitech;

import com.r9000.charcoalmagitech.init.CMBlocks;
import com.r9000.charcoalmagitech.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CharcoalMagitech.MODID, version = CharcoalMagitech.VERSION)
public class CharcoalMagitech
{
    public static final String MODID = "charcoalmagitech";
    public static final String VERSION = "0.7.2-1.7.10";
    public static final String MODNAME = "The Charcoal Mod";
    
    @Instance(MODID)
	public static CharcoalMagitech instance;

	@SidedProxy(clientSide = "uk.co.lastresorts.charcoalmod.proxies.ClientProxy", serverSide = "uk.co.lastresorts.charcoalmod.proxies.CommonProxy")
	public static CommonProxy proxy;
	public static SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("charChannel");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		CMItems.init();
		CMItems.registerItems();
		CMBlocks.init();
		CMItems.registerRecipes();
		CMBlocks.registerTileEntities();
		CMBlocks.registerRecipes();
		
		CMEntities.init();
		
		GameRegistry.registerWorldGenerator(new CharcoalWorldGen(), 0);
		GameRegistry.registerFuelHandler(new CMFuelHandler());
		BiomeRegistry.initializeBiomes();
		BiomeRegistry.registerBiomes();
		new GuiHandler();
		wrapper.registerMessage(ButtonPacketHandlerC2S.class, ButtonPacketC2S.class, 0, Side.SERVER);
		wrapper.registerMessage(TextPacketHandlerC2S.class, TextPacketC2S.class, 1, Side.SERVER);
		
		proxy.initRenderers();
		proxy.initSounds();
		System.out.println("Charcoal Mod successfully initialized.");
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new CharcoalEventHandler());
	}
	
	public static final CreativeTabs tabCharcoalMagitech = (new CreativeTabs("tabCharcoalMagitech") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(CMBlocks.charcoalBlock);
		}
		
	});
}
