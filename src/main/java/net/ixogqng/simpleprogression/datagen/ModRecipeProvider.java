package net.ixogqng.simpleprogression.datagen;

import net.ixogqng.simpleprogression.block.ModBlocks;
import net.ixogqng.simpleprogression.item.ModItems;
import net.ixogqng.simpleprogression.recipe.BasicForgeRecipeBuilder;
import net.ixogqng.simpleprogression.recipe.ModRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_PICKAXE.get())
                .pattern("FFF")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_AXE.get())
                .pattern("FF")
                .pattern("FS")
                .pattern(" S")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_HOE.get())
                .pattern("FF")
                .pattern(" S")
                .pattern(" S")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_SHOVEL.get())
                .pattern(" F ")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FLINT_SWORD.get())
                .pattern(" F ")
                .pattern(" F ")
                .pattern(" S ")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIN_PICKAXE.get())
                .pattern("FFF")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', ModItems.TIN_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIN_AXE.get())
                .pattern("FF")
                .pattern("FS")
                .pattern(" S")
                .define('F', ModItems.TIN_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIN_HOE.get())
                .pattern("FF")
                .pattern(" S")
                .pattern(" S")
                .define('F', ModItems.TIN_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIN_SHOVEL.get())
                .pattern(" F ")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', ModItems.TIN_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIN_SWORD.get())
                .pattern(" F ")
                .pattern(" F ")
                .pattern(" S ")
                .define('F', ModItems.TIN_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIN_BOOTS.get())
                .pattern("F F")
                .pattern("F F")
                .define('F', ModItems.TIN_INGOT)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIN_LEGGINGS.get())
                .pattern("FFF")
                .pattern("F F")
                .pattern("F F")
                .define('F', ModItems.TIN_INGOT)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIN_CHESTPLATE.get())
                .pattern("F F")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModItems.TIN_INGOT)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIN_HELMET.get())
                .pattern("FFF")
                .pattern("F F")
                .define('F', ModItems.TIN_INGOT)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_BLOCK.get())
                .pattern("FFF")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModItems.TIN_INGOT)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get())
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block", has(ModBlocks.TIN_BLOCK))
                .save(recipeOutput, "tin_ingot_from_tin_block");
        BasicForgeRecipeBuilder.create(
                Ingredient.of(ModItems.RAW_TIN),
                CookingBookCategory.MISC,
                ModItems.TIN_INGOT.get(),
                0.7f,
                200
        )
                .unlockedBy("has_raw_tin", has(ModItems.RAW_TIN))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get())
                .pattern("FFF")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get())
                .pattern("FF")
                .pattern("FS")
                .pattern(" S")
                .define('F', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get())
                .pattern("FF")
                .pattern(" S")
                .pattern(" S")
                .define('F', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL.get())
                .pattern(" F ")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD.get())
                .pattern(" F ")
                .pattern(" F ")
                .pattern(" S ")
                .define('F', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS.get())
                .pattern("F F")
                .pattern("F F")
                .define('F', Items.COPPER_INGOT)
                .unlockedBy("has_tin_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS.get())
                .pattern("FFF")
                .pattern("F F")
                .pattern("F F")
                .define('F', Items.COPPER_INGOT)
                .unlockedBy("has_tin_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE.get())
                .pattern("F F")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', Items.COPPER_INGOT)
                .unlockedBy("has_tin_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_HELMET.get())
                .pattern("FFF")
                .pattern("F F")
                .define('F', Items.COPPER_INGOT)
                .unlockedBy("has_tin_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);
    }
}
