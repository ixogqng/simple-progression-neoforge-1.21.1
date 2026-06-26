package net.ixogqng.simpleprogression.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class AdvancedForgeRecipe extends AbstractCookingRecipe {
    public AdvancedForgeRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(ModRecipes.ADVANCED_FORGE_TYPE.get(), group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ADVANCED_FORGE_SERIALIZER.get();
    }
}
