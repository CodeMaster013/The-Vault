package com.yourname.vaultmod.registry;

import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.yourname.vaultmod.VaultMod;
import com.yourname.vaultmod.item.StatueSummonerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ModItems {
    public static final Item VAULT_BLOCK_ITEM = new BlockItem(
            ModBlocks.VAULT_BLOCK, new FabricItemSettings()
    );
    public static final Item STATUE_SUMMONER_ITEM = new StatueSummonerItem(
            new FabricItemSettings().maxCount(1)
    );

    public static void registerItems() {
        Registry.register(Registries.ITEM,
                new Identifier(VaultMod.MOD_ID, "vault_block"),
                VAULT_BLOCK_ITEM
        );
        Registry.register(Registries.ITEM,
                new Identifier(VaultMod.MOD_ID, "statue_summoner"),
                STATUE_SUMMONER_ITEM
        );
    }
}
