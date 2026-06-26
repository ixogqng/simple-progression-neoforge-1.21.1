package net.ixogqng.simpleprogression.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.block.ModBlocks;
import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.DataMapHooks;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;

import java.util.Map;
import java.util.Optional;

public class PaxelItem extends DiggerItem {
    public PaxelItem(Tier tier, Properties properties) {
        super(tier, ModTags.Blocks.MINEABLE_WITH_PAXEL, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // First attempt shovel logic
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Player player = context.getPlayer();
        if (context.getClickedFace() != Direction.DOWN) {
            SimpleProgression.LOGGER.info("blockstate is " + blockstate);
            SimpleProgression.LOGGER.info("Is block above air? " + level.getBlockState(blockpos.above()).isAir());
            SimpleProgression.LOGGER.info("Is block capable of pathing? " + blockstate.is(ModTags.Blocks.CAN_HAVE_PATH));
            if (level.getBlockState(blockpos.above()).isAir() && blockstate.is(ModTags.Blocks.CAN_HAVE_PATH)) {
                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    level.setBlock(blockpos, Blocks.DIRT_PATH.defaultBlockState(), 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, Blocks.DIRT_PATH.defaultBlockState()));
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if ((blockstate.is(Blocks.CAMPFIRE) || blockstate.is(Blocks.SOUL_CAMPFIRE)) && blockstate.getValue(BlockStateProperties.LIT)) {
                if (!level.isClientSide()) {
                    level.levelEvent(null, 1009, blockpos, 0);
                    level.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, false), 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, Blocks.CAMPFIRE.defaultBlockState()));
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        // Then implement axe logic
        if (!playerHasShieldUseIntent(context)) {
            Holder<Block> blockHolder = BuiltInRegistries.BLOCK.wrapAsHolder(blockstate.getBlock());
            Strippable strippable = blockHolder.getData(NeoForgeDataMaps.STRIPPABLES);
            Block oxidizable = DataMapHooks.getPreviousOxidizedStage(blockstate.getBlock());
            Block waxable = DataMapHooks.getBlockUnwaxed(blockstate.getBlock());
            if (strippable != null) {
                Block strippedBlock = strippable.strippedBlock();
                BlockState strippedState = strippedBlock.defaultBlockState();
                strippedState = strippedState.setValue(BlockStateProperties.AXIS, blockstate.getValue(BlockStateProperties.AXIS));
                level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide()) {
                    level.setBlock(blockpos, strippedState, 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, strippedState));
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            else if (oxidizable != null) {
                SimpleProgression.LOGGER.info("previous oxidized stage of " + blockstate.getBlock() + " is " + DataMapHooks.getPreviousOxidizedStage(blockstate.getBlock()));
                BlockState scrapedState = oxidizable.defaultBlockState();
                for (Property<?> property : blockstate.getProperties()) {
                    if (scrapedState.hasProperty(property)) {
                        scrapedState = copyPropertyHelper(blockstate, scrapedState, property);
                    }
                }
                level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, blockpos, 0);
                if (!level.isClientSide()) {
                    if (blockstate.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
                        DoubleBlockHalf half = blockstate.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
                        BlockPos otherHalfPos = (half == DoubleBlockHalf.LOWER) ? blockpos.above() : blockpos.below();
                        BlockState otherHalfState = level.getBlockState(otherHalfPos);

                        if (otherHalfState.is(blockstate.getBlock())) {
                            BlockState updatedOtherHalf = scrapedState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, half == DoubleBlockHalf.LOWER ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
                            level.setBlock(otherHalfPos, updatedOtherHalf, 3);
                        }
                    }
                    level.setBlock(blockpos, scrapedState, 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, scrapedState));
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            else if (waxable != null) {
                SimpleProgression.LOGGER.info("previous oxidized stage of " + blockstate.getBlock() + " is " + DataMapHooks.getPreviousOxidizedStage(blockstate.getBlock()));
                BlockState unwaxedState = waxable.defaultBlockState();
                for (Property<?> property : blockstate.getProperties()) {
                    if (unwaxedState.hasProperty(property)) {
                        unwaxedState = copyPropertyHelper(blockstate, unwaxedState, property);
                    }
                }
                level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3004, blockpos, 0);
                if (!level.isClientSide()) {
                    if (blockstate.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
                        DoubleBlockHalf half = blockstate.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
                        BlockPos otherHalfPos = (half == DoubleBlockHalf.LOWER) ? blockpos.above() : blockpos.below();
                        BlockState otherHalfState = level.getBlockState(otherHalfPos);

                        if (otherHalfState.is(blockstate.getBlock())) {
                            BlockState updatedOtherHalf = unwaxedState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, half == DoubleBlockHalf.LOWER ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
                            level.setBlock(otherHalfPos, updatedOtherHalf, 3);
                        }
                    }
                    level.setBlock(blockpos, unwaxedState, 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, unwaxedState));
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }

    private static <T extends Comparable<T>> BlockState copyPropertyHelper(BlockState state, BlockState state2, Property<T> property) {
        return state2.setValue(property, state.getValue(property));
    }

    private static boolean playerHasShieldUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }
}
