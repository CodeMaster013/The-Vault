package com.yourname.vaultmod.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

import com.yourname.vaultmod.registry.ModBlockEntities;

public class VaultBlockEntity extends BlockEntity {
    private UUID ownerUuid;

    public VaultBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VAULT_BLOCK_ENTITY_TYPE, pos, state);
    }

    public void setOwner(UUID uuid) {
        this.ownerUuid = uuid;
    }

    public boolean isOwner(net.minecraft.entity.player.PlayerEntity player) {
        return player.getUuid().equals(ownerUuid);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (ownerUuid != null) {
            nbt.putUuid("OwnerUUID", ownerUuid);
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("OwnerUUID")) {
            ownerUuid = nbt.getUuid("OwnerUUID");
        }
    }
}
