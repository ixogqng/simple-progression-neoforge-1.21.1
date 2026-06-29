package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleProgression.MODID);

    public static final Supplier<CreativeModeTab> SIMPLE_PROGRESSIONS_TAB = CREATIVE_MODE_TAB.register("simpleprogression_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .title(Component.translatable("creativetab.simpleprogression.simpleprogressions_items"))
                    .displayItems((itemDisplayParamenters, event) -> {
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
                        event.accept(ModItems.WOODEN_PAXEL);
                        event.accept(ModItems.FLINT_PAXEL);
                        event.accept(ModItems.STONE_PAXEL);
                        event.accept(ModItems.IRON_PAXEL);
                        event.accept(ModItems.BRONZE_PAXEL);
                        event.accept(ModItems.TIN_PAXEL);
                        event.accept(ModItems.GOLD_PAXEL);
                        event.accept(ModItems.SILVER_PAXEL);
                        event.accept(ModItems.COPPER_PAXEL);
                        event.accept(ModItems.ECLIPSITE_PAXEL);
                        event.accept(ModItems.DIAMOND_PAXEL);
                        event.accept(ModItems.NETHERITE_PAXEL);
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
                        event.accept(ModBlocks.BRONZE_BLOCK);
                        event.accept(ModItems.ECLIPSITE_PICKAXE);
                        event.accept(ModItems.ECLIPSITE_SWORD);
                        event.accept(ModItems.ECLIPSITE_AXE);
                        event.accept(ModItems.ECLIPSITE_HOE);
                        event.accept(ModItems.ECLIPSITE_SHOVEL);
                        event.accept(ModItems.RAW_ECLIPSITE);
                        event.accept(ModItems.ECLIPSITE_INGOT);
                        event.accept(ModItems.ECLIPSITE_HELMET);
                        event.accept(ModItems.ECLIPSITE_CHESTPLATE);
                        event.accept(ModItems.ECLIPSITE_LEGGINGS);
                        event.accept(ModItems.ECLIPSITE_BOOTS);
                        event.accept(ModBlocks.RAW_TIN_BLOCK);
                        event.accept(ModBlocks.ECLIPSITE_ORE);
                        event.accept(ModBlocks.ECLIPSITE_BLOCK);
                        event.accept(ModBlocks.RAW_ECLIPSITE_BLOCK);
                        event.accept(ModItems.SILVER_PICKAXE);
                        event.accept(ModItems.SILVER_SWORD);
                        event.accept(ModItems.SILVER_AXE);
                        event.accept(ModItems.SILVER_HOE);
                        event.accept(ModItems.SILVER_SHOVEL);
                        event.accept(ModItems.RAW_SILVER);
                        event.accept(ModItems.SILVER_INGOT);
                        event.accept(ModItems.SILVER_HELMET);
                        event.accept(ModItems.SILVER_CHESTPLATE);
                        event.accept(ModItems.SILVER_LEGGINGS);
                        event.accept(ModItems.SILVER_BOOTS);
                        event.accept(ModBlocks.SILVER_ORE);
                        event.accept(ModBlocks.SILVER_BLOCK);
                        event.accept(ModBlocks.RAW_SILVER_BLOCK);
                        event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
                        event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
