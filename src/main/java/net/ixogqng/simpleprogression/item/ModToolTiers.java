package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier FLINT = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
            32, 3.0f, 0.0f, 15, () -> Ingredient.of(Items.FLINT));
}
