package net.ixogqng.simpleprogression.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdvancedForgeRecipeBuilder implements RecipeBuilder {
    private final Ingredient ingredient;
    private final CookingBookCategory category;
    private final ItemStack result;
    private final float experience;
    private final int cookingTime;
    private final Map<String, Criterion<?>> critera = new LinkedHashMap<>();

    public AdvancedForgeRecipeBuilder(Ingredient ingredient, CookingBookCategory category, ItemStack result, float experience, int cookingTime) {
        this.ingredient = ingredient;
        this.category = category;
        this.result = result;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static AdvancedForgeRecipeBuilder create(Ingredient ingredient, CookingBookCategory category, Item result, float experience, int cookingTime) {
        return new AdvancedForgeRecipeBuilder(ingredient, category, new ItemStack(result), experience, cookingTime);
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.critera.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        Advancement.Builder advancementBuilder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.critera.forEach(advancementBuilder::addCriterion);

        AdvancedForgeRecipe recipe = new AdvancedForgeRecipe("", this.category, this.ingredient, this.result, this.experience, this.cookingTime);
        recipeOutput.accept(id, recipe, advancementBuilder.build(id.withPrefix("recipes/")));
    }
}
