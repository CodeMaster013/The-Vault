package com.CodeMaster013.vaultmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VaultBlock extends Block {
    public VaultBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, net.minecraft.entity.LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            if (world.getBlockEntity(pos) instanceof VaultBlockEntity vaultBE
                    && placer instanceof PlayerEntity player) {
                vaultBE.setOwner(player.getUuid());
            }
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof VaultBlockEntity vaultBE) {
            if (!vaultBE.isOwner(player)) {
                // Cancel break if not owner.  One approach:
                return;
            }
        }
        super.onBreak(world, pos, state, player);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new VaultBlockEntity(pos, state);
    }

    @Override
    public boolean hasBlockEntity() {
        return true;
    }
}
