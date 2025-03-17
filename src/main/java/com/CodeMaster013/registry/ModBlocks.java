package com.yourname.vaultmod.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import com.yourname.vaultmod.block.VaultBlock;
import com.yourname.vaultmod.VaultMod;

public class ModBlocks {
    public static final Block VAULT_BLOCK = new VaultBlock(
            FabricBlockSettings
                    .of(/* Material.METAL or similar */)
                    .strength(-1.0F, 3600000.0F)
                    .requiresTool()
    );

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("your_mod_id", "vault_block"), VAULT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("your_mod_id", "vault_block"), new BlockItem(VAULT_BLOCK, new Item.Settings()));
}
