package net.ixogqng.simpleprogression.datagen;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SimpleProgression.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.KINDLING.get());

        handheldItem(ModItems.FLINT_PICKAXE.get());
        handheldItem(ModItems.FLINT_SWORD.get());
        handheldItem(ModItems.FLINT_HOE.get());
        handheldItem(ModItems.FLINT_AXE.get());
        handheldItem(ModItems.FLINT_SHOVEL.get());
        handheldItem(ModItems.TIN_INGOT.get());
    }
}
