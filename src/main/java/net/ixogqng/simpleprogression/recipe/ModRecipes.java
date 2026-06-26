package net.ixogqng.simpleprogression.recipe;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, SimpleProgression.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, SimpleProgression.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BasicForgeRecipe>> BASIC_FORGE_SERIALIZER =
            SERIALIZERS.register("basic_forge", () -> new SimpleCookingSerializer<>(
                    BasicForgeRecipe::new, 200
            ));

    public static final DeferredHolder<RecipeType<?>, RecipeType<BasicForgeRecipe>> BASIC_FORGE_TYPE =
            TYPES.register("basic_forge", () -> new RecipeType<BasicForgeRecipe>() {
                @Override
                public String toString() {
                    return "simpleprogression:basic_forge";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<AdvancedForgeRecipe>> ADVANCED_FORGE_SERIALIZER =
            SERIALIZERS.register("advanced_forge", () -> new SimpleCookingSerializer<>(
                    AdvancedForgeRecipe::new, 200
            ));

    public static final DeferredHolder<RecipeType<?>, RecipeType<AdvancedForgeRecipe>> ADVANCED_FORGE_TYPE =
            TYPES.register("advanced_forge", () -> new RecipeType<AdvancedForgeRecipe>() {
                @Override
                public String toString() {
                    return "simpleprogression:advanced_forge";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
