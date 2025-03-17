package com.CodeMaster013.vaultmod.registry;

import com.yourname.vaultmod.VaultMod;
import com.yourname.vaultmod.entity.GuardianStatueEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static EntityType<GuardianStatueEntity> GUARDIAN_STATUE_ENTITY_TYPE;

    public static void registerEntities() {
        GUARDIAN_STATUE_ENTITY_TYPE = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(VaultMod.MOD_ID, "guardian_statue"),
                FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, GuardianStatueEntity::new)
                        .dimensions(EntityDimensions.fixed(0.75F, 2.0F))
                        .build()
        );
    }
}
