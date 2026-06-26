package net.ixogqng.simpleprogression.block.entity;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.block.ModBlocks;
import net.ixogqng.simpleprogression.block.custom.AdvancedForgeBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, SimpleProgression.MODID);

    public static final Supplier<BlockEntityType<BasicForgeBlockEntity>> BASIC_FORGE_BE =
            BLOCK_ENTITIES.register("basic_forge_be", () -> BlockEntityType.Builder.of(
                    BasicForgeBlockEntity::new, ModBlocks.BASIC_FORGE.get()
            ).build(null));

    public static final Supplier<BlockEntityType<AdvancedForgeBlockEntity>> ADVANCED_FORGE_BE =
            BLOCK_ENTITIES.register("advanced_forge_be", () -> BlockEntityType.Builder.of(
                    AdvancedForgeBlockEntity::new, ModBlocks.ADVANCED_FORGE.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
