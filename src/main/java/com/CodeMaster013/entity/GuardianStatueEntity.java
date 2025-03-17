package com.yourname.vaultmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import java.util.UUID;

public class GuardianStatueEntity extends PathAwareEntity {
    private UUID ownerUuid;

    public GuardianStatueEntity(EntityType<? extends GuardianStatueEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setOwner(UUID owner) {
        this.ownerUuid = owner;
    }

    public boolean isOwner(PlayerEntity player) {
        return player != null && player.getUuid().equals(ownerUuid);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        // Add custom goals
        this.targetSelector.add(1, new AttackIntrudersGoal(this));
    }

    // NBT
    @Override
    public void writeCustomDataToNbt(net.minecraft.nbt.NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (ownerUuid != null) {
            nbt.putUuid("OwnerUUID", ownerUuid);
        }
    }

    @Override
    public void readCustomDataFromNbt(net.minecraft.nbt.NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("OwnerUUID")) {
            ownerUuid = nbt.getUuid("OwnerUUID");
        }
    }
}
