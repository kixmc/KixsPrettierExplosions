package com.kixmc.PE.listeners.registry;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.listeners.BlockExplode;
import com.kixmc.PE.listeners.EntityChangeBlock;
import com.kixmc.PE.listeners.EntityExplode;
import org.bukkit.Bukkit;

public class ListenerRegistry {

    public static void register() {

        Bukkit.getPluginManager().registerEvents(new BlockExplode(), PrettierExplosions.get());
        Bukkit.getPluginManager().registerEvents(new EntityExplode(), PrettierExplosions.get());
        Bukkit.getPluginManager().registerEvents(new EntityChangeBlock(), PrettierExplosions.get());

    }

}