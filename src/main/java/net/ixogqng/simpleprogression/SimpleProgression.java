package net.ixogqng.simpleprogression;

import net.ixogqng.simpleprogression.block.ModBlocks;
import net.ixogqng.simpleprogression.block.entity.ModBlockEntities;
import net.ixogqng.simpleprogression.item.ModItems;
import net.ixogqng.simpleprogression.recipe.ModRecipes;
import net.ixogqng.simpleprogression.screen.ModMenuTypes;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(SimpleProgression.MODID)
public class SimpleProgression {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "simpleprogression";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public SimpleProgression(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModRecipes.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.KINDLING);
            event.accept(ModItems.FLINT_PICKAXE);
            event.accept(ModItems.FLINT_SWORD);
            event.accept(ModItems.FLINT_HOE);
            event.accept(ModItems.FLINT_AXE);
            event.accept(ModItems.FLINT_SHOVEL);
            event.accept(ModItems.TIN_INGOT);
            event.accept(ModItems.TIN_HELMET);
            event.accept(ModItems.TIN_CHESTPLATE);
            event.accept(ModItems.TIN_LEGGINGS);
            event.accept(ModItems.TIN_BOOTS);
            event.accept(ModItems.TIN_PICKAXE);
            event.accept(ModItems.TIN_SWORD);
            event.accept(ModItems.TIN_AXE);
            event.accept(ModItems.TIN_HOE);
            event.accept(ModItems.TIN_SHOVEL);
            event.accept(ModBlocks.TIN_BLOCK);
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.BASIC_FORGE);
            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.COPPER_PICKAXE);
            event.accept(ModItems.COPPER_SWORD);
            event.accept(ModItems.COPPER_AXE);
            event.accept(ModItems.COPPER_HOE);
            event.accept(ModItems.COPPER_SHOVEL);
            event.accept(ModItems.COPPER_HELMET);
            event.accept(ModItems.COPPER_CHESTPLATE);
            event.accept(ModItems.COPPER_LEGGINGS);
            event.accept(ModItems.COPPER_BOOTS);
            event.accept(ModItems.BAG_OF_WIND);
            event.accept(ModItems.DIAMOND_PAXEL);
            event.accept(ModItems.BRONZE_PICKAXE);
            event.accept(ModItems.BRONZE_SWORD);
            event.accept(ModItems.BRONZE_AXE);
            event.accept(ModItems.BRONZE_HOE);
            event.accept(ModItems.BRONZE_SHOVEL);
            event.accept(ModItems.BRONZE_INGOT);
            event.accept(ModItems.BRONZE_HELMET);
            event.accept(ModItems.BRONZE_CHESTPLATE);
            event.accept(ModItems.BRONZE_LEGGINGS);
            event.accept(ModItems.BRONZE_BOOTS);
            event.accept(ModBlocks.ADVANCED_FORGE);
            event.accept(ModBlocks.BRONZE_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
