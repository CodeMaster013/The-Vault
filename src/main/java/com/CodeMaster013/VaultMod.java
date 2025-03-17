package com.yourname.vaultmod;

import net.fabricmc.api.ModInitializer;
// Quilt: import org.quiltmc.loader.api.ModContainer;
// import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.yourname.vaultmod.registry.ModBlocks;
import com.yourname.vaultmod.registry.ModBlockEntities;
import com.yourname.vaultmod.registry.ModEntities;
import com.yourname.vaultmod.registry.ModItems;

public class VaultMod implements ModInitializer {
    public static final String MOD_ID = "vaultmod";

    @Override
    public void onInitialize() {
        // Register everything
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
        ModItems.registerItems();
        ModEntities.registerEntities();

        // Possibly log something
        System.out.println("VaultMod initialized!");
    }
}
