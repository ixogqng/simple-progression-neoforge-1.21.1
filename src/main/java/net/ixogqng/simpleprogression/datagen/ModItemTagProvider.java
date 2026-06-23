package net.ixogqng.simpleprogression.datagen;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.item.ModItems;
import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
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

        tag(ItemTags.PICKAXES)
                .add(ModItems.FLINT_PICKAXE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.FLINT_SWORD.get());

        tag(ItemTags.HOES)
                .add(ModItems.FLINT_HOE.get());

        tag(ItemTags.AXES)
                .add(ModItems.FLINT_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.FLINT_SHOVEL.get());
    }
}
