package net.ixogqng.simpleprogression.block.entity;

import net.ixogqng.simpleprogression.recipe.ModRecipes;
import net.ixogqng.simpleprogression.screen.custom.AdvancedForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AdvancedForgeBlockEntity extends AbstractFurnaceBlockEntity {
    public AdvancedForgeBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ADVANCED_FORGE_BE.get(), pos, blockState, ModRecipes.ADVANCED_FORGE_TYPE.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.simpleprogression.advanced_forge");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new AdvancedForgeMenu(containerId, inventory, this, this.dataAccess);
    }
}
