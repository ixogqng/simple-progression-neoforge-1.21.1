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
            175, 5.2f, 1.7f, 18, () -> Ingredient.of(ModItems.TIN_INGOT.get()));
}
