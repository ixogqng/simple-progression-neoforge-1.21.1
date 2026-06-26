package net.ixogqng.simpleprogression.screen.custom;

import net.ixogqng.simpleprogression.recipe.ModRecipes;
import net.ixogqng.simpleprogression.screen.ModMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;

public class AdvancedForgeMenu extends AbstractFurnaceMenu {
    public AdvancedForgeMenu(int containerId, Inventory playerInventory) {
        super(ModMenuTypes.ADVANCED_FORGE_MENU.get(), ModRecipes.ADVANCED_FORGE_TYPE.get(), RecipeBookType.FURNACE /* change this to custom type */, containerId, playerInventory);
    }

    public AdvancedForgeMenu(int containerId, Inventory playerInventory, Container advancedForgeContainer, ContainerData advancedForgeData) {
        super(ModMenuTypes.ADVANCED_FORGE_MENU.get(), ModRecipes.ADVANCED_FORGE_TYPE.get(), RecipeBookType.FURNACE, containerId, playerInventory, advancedForgeContainer, advancedForgeData);
    }

    @Override
    protected boolean canSmelt(ItemStack stack) {
        return this.level.getRecipeManager().getRecipeFor(ModRecipes.ADVANCED_FORGE_TYPE.get(), new SingleRecipeInput(stack), this.level).isPresent();
    }
}
