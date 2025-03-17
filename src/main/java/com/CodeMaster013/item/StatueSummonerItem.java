package com.CodeMaster013.vaultmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import com.yourname.vaultmod.registry.ModEntities;
import com.yourname.vaultmod.entity.GuardianStatueEntity;

public class StatueSummonerItem extends Item {
    public StatueSummonerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            GuardianStatueEntity statue = ModEntities.GUARDIAN_STATUE_ENTITY_TYPE.create(world);
            if (statue != null) {
                statue.setOwner(user.getUuid());
                statue.refreshPositionAndAngles(user.getBlockPos().up(), 0.0F, 0.0F);
                world.spawnEntity(statue);
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
