package com.kixmc.PE.core;

import com.kixmc.PE.commands.registry.CommandRegistry;
import com.kixmc.PE.config.ConfigFileManager;
import com.kixmc.PE.config.ConfigVarLoader;
import com.kixmc.PE.listeners.registry.ListenerRegistry;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class PrettierExplosions extends JavaPlugin implements Listener, CommandExecutor {

    // class getter

    private static PrettierExplosions main;

    public static PrettierExplosions get() {
        return main;
    }

    // main vars

    public ArrayList<FallingBlock> flyingBlocks = new ArrayList<>();

    public int activeBlocksCount = 0;

    // config vars

    public boolean executeOnTnt = false;
    public boolean executeOnBeds = false;
    public boolean executeOnCreepers = false;
    public boolean executeOnOther = false;

    public int visualCap = 150;

    public boolean extraVisuals = true;

    public ListType listType = ListType.WHITELIST;

    public ArrayList<String> worldList = new ArrayList<>();

    public void onEnable() {

        main = this;

        // listeners
        ListenerRegistry.register();

        // commands
        CommandRegistry.register();

        // config and vars
        ConfigFileManager.setup();
        ConfigVarLoader.update();

        beginContinuity();

    }

    public void onDisable() {

        // get rid of spawned entities on shut down, if any
        for (FallingBlock fb : flyingBlocks) { fb.remove(); }

    }

    // sometimes the flying block counter gets inaccurate because the servers processing so many flying block entities at once. this resets the counter back to 0 every 30 seconds to prevent buildup
    public void beginContinuity() { Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> activeBlocksCount = 0, 0L, 600L); }

}