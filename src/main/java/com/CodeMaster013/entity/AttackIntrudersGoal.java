package com.yourname.vaultmod.entity;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import java.util.List;

public class AttackIntrudersGoal extends Goal {
    private final GuardianStatueEntity statue;
    private PlayerEntity target;

    public AttackIntrudersGoal(GuardianStatueEntity statue) {
        this.statue = statue;
    }

    @Override
    public boolean canStart() {
        // Find a nearby player who is not the owner
        List<PlayerEntity> players = statue.world.getEntitiesByClass(
                PlayerEntity.class,
                statue.getBoundingBox().expand(16.0D),
                p -> !statue.isOwner(p)
        );
        if (!players.isEmpty()) {
            target = players.get(0);
            return true;
        }
        return false;
    }

    @Override
    public void start() {
        if (target != null) {
            statue.setTarget(target);
        }
    }

    @Override
    public boolean shouldContinue() {
        return target != null && target.isAlive() && !statue.isOwner(target);
    }

    @Override
    public void stop() {
        statue.setTarget(null);
        target = null;
    }
}
