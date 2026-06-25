package net.ixogqng.simpleprogression.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class BasicForgeRecipe extends AbstractCookingRecipe {
    public BasicForgeRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(ModRecipes.BASIC_FORGE_TYPE.get(), group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.BASIC_FORGE_SERIALIZER.get();
    }
}
