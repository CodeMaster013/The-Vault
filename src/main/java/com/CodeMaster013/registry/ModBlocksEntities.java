package com.CodeMaster013.vaultmod.registry;

import com.yourname.vaultmod.VaultMod;
import com.yourname.vaultmod.block.VaultBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<VaultBlockEntity> VAULT_BLOCK_ENTITY_TYPE;

    public static void registerBlockEntities() {
        VAULT_BLOCK_ENTITY_TYPE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier(VaultMod.MOD_ID, "vault_block_entity"),
                FabricBlockEntityTypeBuilder.create(
                        VaultBlockEntity::new,
                        ModBlocks.VAULT_BLOCK
                ).build()
        );
    }
}
