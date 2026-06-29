package net.ixogqng.simpleprogression.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.DataMapHooks;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;

import java.util.ArrayList;
import java.util.List;

public class BronzeAxeItem extends AxeItem {
    public BronzeAxeItem(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        if(traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                }
            }
        }

        if(traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                }
            }
        }

        if(traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                }
            }
        }

        return positions;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Player player = context.getPlayer();
        if (!playerHasShieldUseIntent(context)) {
            Holder<Block> blockHolder = BuiltInRegistries.BLOCK.wrapAsHolder(blockstate.getBlock());
            Strippable strippable = blockHolder.getData(NeoForgeDataMaps.STRIPPABLES);
            Block oxidizable = DataMapHooks.getPreviousOxidizedStage(blockstate.getBlock());
            Block waxable = DataMapHooks.getBlockUnwaxed(blockstate.getBlock());


            if (strippable != null) {
                level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                    for(BlockPos pos : getBlocksToBeDestroyed(1, blockpos, serverPlayer)) {
                        BlockState posState = level.getBlockState(pos);
                        blockHolder = BuiltInRegistries.BLOCK.wrapAsHolder(posState.getBlock());
                        strippable = blockHolder.getData(NeoForgeDataMaps.STRIPPABLES);


                        if(strippable != null) {
                            Block strippedBlock = strippable.strippedBlock();
                            BlockState strippedState = strippedBlock.defaultBlockState();
                            strippedState = strippedState.setValue(BlockStateProperties.AXIS, posState.getValue(BlockStateProperties.AXIS));
                            level.setBlock(pos, strippedState, 3);
                            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, strippedState));
                            if (player != null) {
                                context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                            }
                        }
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            else if (oxidizable != null) {
                level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                    for(BlockPos pos : getBlocksToBeDestroyed(1, blockpos, serverPlayer)) {
                        BlockState posState = level.getBlockState(pos);
                        oxidizable = DataMapHooks.getPreviousOxidizedStage(posState.getBlock());

                        if(oxidizable != null) {
                            BlockState scrapedState = oxidizable.defaultBlockState();
                            for (Property<?> property : posState.getProperties()) {
                                if (scrapedState.hasProperty(property)) {
                                    scrapedState = copyPropertyHelper(posState, scrapedState, property);
                                }
                            }
                            level.levelEvent(player, 3005, pos, 0);

                            if (!level.isClientSide()) {
                                if (posState.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
                                    DoubleBlockHalf half = posState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
                                    BlockPos otherHalfPos = (half == DoubleBlockHalf.LOWER) ? pos.above() : pos.below();
                                    BlockState otherHalfState = level.getBlockState(otherHalfPos);

                                    if (otherHalfState.is(posState.getBlock())) {
                                        BlockState updatedOtherHalf = scrapedState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, half == DoubleBlockHalf.LOWER ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
                                        level.setBlock(otherHalfPos, updatedOtherHalf, 3);
                                    }
                                }
                                level.setBlock(pos, scrapedState, 3);
                                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, scrapedState));
                                if (player != null) {
                                    context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                                }
                            }
                        }
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            else if (waxable != null) {
                level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                    for(BlockPos pos : getBlocksToBeDestroyed(1, blockpos, serverPlayer)) {
                        BlockState posState = level.getBlockState(pos);
                        waxable = DataMapHooks.getBlockUnwaxed(posState.getBlock());

                        if(waxable != null) {
                            BlockState scrapedState = waxable.defaultBlockState();
                            for (Property<?> property : posState.getProperties()) {
                                if (scrapedState.hasProperty(property)) {
                                    scrapedState = copyPropertyHelper(posState, scrapedState, property);
                                }
                            }
                            level.levelEvent(player, 3004, pos, 0);

                            if (!level.isClientSide()) {
                                if (posState.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
                                    DoubleBlockHalf half = posState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
                                    BlockPos otherHalfPos = (half == DoubleBlockHalf.LOWER) ? pos.above() : pos.below();
                                    BlockState otherHalfState = level.getBlockState(otherHalfPos);

                                    if (otherHalfState.is(posState.getBlock())) {
                                        BlockState updatedOtherHalf = scrapedState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, half == DoubleBlockHalf.LOWER ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
                                        level.setBlock(otherHalfPos, updatedOtherHalf, 3);
                                    }
                                }
                                level.setBlock(pos, scrapedState, 3);
                                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, scrapedState));
                                if (player != null) {
                                    context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                                }
                            }
                        }
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
