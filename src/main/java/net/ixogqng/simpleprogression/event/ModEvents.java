package net.ixogqng.simpleprogression.event;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

@EventBusSubscriber(modid = SimpleProgression.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void blockDropsEvent(BlockDropsEvent event) {
        if (event.getBreaker() instanceof Player) {
            if (event.getTool().is(ModTags.Items.GOLD_TOOLS)) {
                List<ItemEntity> drops = event.getDrops();
                ServerLevel level = event.getLevel();
                Block block = event.getState().getBlock();
                if (block != Blocks.BUDDING_AMETHYST
                        && block != Blocks.CAKE
                        && block != Blocks.FARMLAND
                        && block != Blocks.FIRE
                        && block != Blocks.FROSTED_ICE
                        && block != Blocks.DIRT_PATH
                        && block != Blocks.INFESTED_COBBLESTONE
                        && block != Blocks.INFESTED_CHISELED_STONE_BRICKS
                        && block != Blocks.INFESTED_DEEPSLATE
                        && block != Blocks.INFESTED_STONE
                        && block != Blocks.INFESTED_CRACKED_STONE_BRICKS
                        && block != Blocks.INFESTED_MOSSY_STONE_BRICKS
                        && block != Blocks.INFESTED_STONE_BRICKS) {
                    drops.clear();
                    drops.add(new ItemEntity(
                            level,
                            event.getPos().getX() + 0.5, event.getPos().getY() + 0.5, event.getPos().getZ() + 0.5,
                            new ItemStack(block, 1)
                    ));
                    event.setDroppedExperience(0);
                }
            }
        }
    }
}
