package net.ixogqng.simpleprogression.datagen;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.item.ModItems;
import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, SimpleProgression.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.STICK_ITEMS)
                .add(Items.BAMBOO)
                .add(Items.STICK);

        tag(ModTags.Items.PAXELS)
                .add(ModItems.DIAMOND_PAXEL.get())
                .add(ModItems.WOODEN_PAXEL.get())
                .add(ModItems.FLINT_PAXEL.get())
                .add(ModItems.IRON_PAXEL.get())
                .add(ModItems.TIN_PAXEL.get())
                .add(ModItems.BRONZE_PAXEL.get())
                .add(ModItems.GOLD_PAXEL.get())
                .add(ModItems.COPPER_PAXEL.get())
                .add(ModItems.SILVER_PAXEL.get())
                .add(ModItems.ECLIPSITE_PAXEL.get())
                .add(ModItems.NETHERITE_PAXEL.get())
                .add(ModItems.STONE_PAXEL.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.FLINT_PICKAXE.get())
                .add(ModItems.TIN_PICKAXE.get())
                .add(ModItems.COPPER_PICKAXE.get())
                .add(ModItems.BRONZE_PICKAXE.get())
                .add(ModItems.ECLIPSITE_PICKAXE.get())
                .add(ModItems.SILVER_PICKAXE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.FLINT_SWORD.get())
                .add(ModItems.TIN_SWORD.get())
                .add(ModItems.COPPER_SWORD.get())
                .add(ModItems.BRONZE_SWORD.get())
                .add(ModItems.ECLIPSITE_SWORD.get())
                .add(ModItems.SILVER_SWORD.get());

        tag(ItemTags.HOES)
                .add(ModItems.FLINT_HOE.get())
                .add(ModItems.TIN_HOE.get())
                .add(ModItems.COPPER_HOE.get())
                .add(ModItems.BRONZE_HOE.get())
                .add(ModItems.ECLIPSITE_HOE.get())
                .add(ModItems.SILVER_HOE.get());

        tag(ItemTags.AXES)
                .add(ModItems.FLINT_AXE.get())
                .add(ModItems.TIN_AXE.get())
                .add(ModItems.COPPER_AXE.get())
                .add(ModItems.BRONZE_AXE.get())
                .add(ModItems.ECLIPSITE_AXE.get())
                .add(ModItems.SILVER_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.FLINT_SHOVEL.get())
                .add(ModItems.TIN_SHOVEL.get())
                .add(ModItems.COPPER_SHOVEL.get())
                .add(ModItems.BRONZE_SHOVEL.get())
                .add(ModItems.ECLIPSITE_SHOVEL.get())
                .add(ModItems.SILVER_SHOVEL.get());

        tag(ModTags.Items.GOLD_TOOLS)
                .add(Items.GOLDEN_PICKAXE)
                .add(Items.GOLDEN_AXE)
                .add(Items.GOLDEN_HOE)
                .add(Items.GOLDEN_SHOVEL)
                .add(ModItems.GOLD_PAXEL.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TIN_BOOTS.get())
                .add(ModItems.TIN_HELMET.get())
                .add(ModItems.TIN_LEGGINGS.get())
                .add(ModItems.TIN_CHESTPLATE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.TIN_HELMET.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.TIN_BOOTS.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.TIN_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.TIN_LEGGINGS.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_BOOTS.get())
                .add(ModItems.COPPER_HELMET.get())
                .add(ModItems.COPPER_LEGGINGS.get())
                .add(ModItems.COPPER_CHESTPLATE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.COPPER_HELMET.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.COPPER_BOOTS.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.COPPER_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.COPPER_LEGGINGS.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_BOOTS.get())
                .add(ModItems.BRONZE_HELMET.get())
                .add(ModItems.BRONZE_LEGGINGS.get())
                .add(ModItems.BRONZE_CHESTPLATE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.BRONZE_HELMET.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.BRONZE_BOOTS.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.BRONZE_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.BRONZE_LEGGINGS.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ECLIPSITE_BOOTS.get())
                .add(ModItems.ECLIPSITE_HELMET.get())
                .add(ModItems.ECLIPSITE_LEGGINGS.get())
                .add(ModItems.ECLIPSITE_CHESTPLATE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.ECLIPSITE_HELMET.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.ECLIPSITE_BOOTS.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.ECLIPSITE_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.ECLIPSITE_LEGGINGS.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SILVER_BOOTS.get())
                .add(ModItems.SILVER_HELMET.get())
                .add(ModItems.SILVER_LEGGINGS.get())
                .add(ModItems.SILVER_CHESTPLATE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.SILVER_HELMET.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.SILVER_BOOTS.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.SILVER_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.SILVER_LEGGINGS.get());
    }
}
