package net.ixogqng.simpleprogression.item.custom;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class BronzeHoeItem extends HoeItem {
    public BronzeHoeItem(Tier p_42961_, Properties p_42964_) {
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
        if (context.getClickedFace() != Direction.DOWN) {
            if (level.getBlockState(blockpos.above()).isAir() && blockstate.is(ModTags.Blocks.CAN_BE_TILLED)) {
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                    for(BlockPos pos : getBlocksToBeDestroyed(1, blockpos, serverPlayer)) {
                        if(level.getBlockState(pos.above()).isAir() && level.getBlockState(pos).is(ModTags.Blocks.CAN_BE_TILLED)) {
                            level.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), 3);
                            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(serverPlayer, Blocks.FARMLAND.defaultBlockState()));
                            if (player != null) {
                                context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                            }
                        }
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (turnIntoDirt(blockstate)) {
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                    for(BlockPos pos : getBlocksToBeDestroyed(1, blockpos, serverPlayer)) {
                        BlockState posState = level.getBlockState(pos);
                        if(turnIntoDirt(posState)) {
                            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
                            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(serverPlayer, Blocks.DIRT.defaultBlockState()));
                            if (posState.is(Blocks.ROOTED_DIRT)) {
                                SimpleProgression.LOGGER.info("It's rooted");
                                Block.popResourceFromFace(level, pos, Direction.UP, new ItemStack(Items.HANGING_ROOTS));
                            }
                            if (player != null) {
                                context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                            }
                        }
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }

    private static boolean turnIntoDirt(BlockState blockState) {
        return blockState.is(Blocks.COARSE_DIRT) || blockState.is(Blocks.ROOTED_DIRT);
    }
}
