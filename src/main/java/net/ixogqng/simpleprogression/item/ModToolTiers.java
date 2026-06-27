package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier FLINT = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
            32, 3.0f, 0.5f, 15, () -> Ingredient.of(Items.FLINT));
    public static final Tier TIN = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_TIN_TOOL,
            175, 5.5f, 1.5f, 13, () -> Ingredient.of(ModItems.TIN_INGOT.get()));
    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            190, 5.0f, 1.0f, 13, () -> Ingredient.of(Items.COPPER_INGOT));
    public static final Tier BRONZE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL,
            750, 6.0f, 2.0f, 5, () -> Ingredient.of(ModItems.BRONZE_INGOT.get()));
    public static final Tier ECLIPSITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ECLIPSITE_TOOL,
            2031, 9.0f, 4.0f, 15, () -> Ingredient.of(ModItems.ECLIPSITE_INGOT.get()));
}
