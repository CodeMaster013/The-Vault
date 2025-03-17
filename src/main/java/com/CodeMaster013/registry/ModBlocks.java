package com.CodeMaster013.vaultmod.registry;

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
    public static final Block VAULT_MULTIBLOCK_PORTAL = new VaultMultiBlockPortal(
            FabricBlockSettings
                    .of(/* Material.METAL or similar */)
                    .strength(-1.0F, 3600000.0F)
                    .requiresTool()
    );
    public static final Block VAULT_WALL = new VaultWall(
            FabricBlockSettings
                    .of(/* Material.METAL or similar */)
                    .strength(-1.0F, 3600000.0F)
                    .requiresTool()
    );

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("vaultmod", "vault_block"), VAULT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("vaultmod", "vault_block"), new BlockItem(VAULT_BLOCK, new Item.Settings()));
        Registry.register(Registry.BLOCK, new Identifier("vaultmod", "vault_multiblock_portal"), VAULT_MULTIBLOCK_PORTAL);
        Registry.register(Registry.ITEM, new Identifier("vaultmod", "vault_multiblock_portal"), new BlockItem(VAULT_MULTIBLOCK_PORTAL, new Item.Settings()));
        Registry.register(Registry.BLOCK, new Identifier("vaultmod", "vault_wall"), VAULT_WALL;
        Registry.register(Registry.ITEM, new Identifier("vaultmod", "vault_wall"), new BlockItem(VAULT_WALL, new Item.Settings()));
}
