package com.kixmc.PE.listeners;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.core.Visuals;
import com.kixmc.PE.util.LogicUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class BlockExplode implements Listener {

    // fires for beds and other block explosions
    // HIGHEST priority to ensure it's called as late as possible to hand over priority to protection & claiming plugins if they cancel the event

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockExplode(BlockExplodeEvent e) {

        if (!LogicUtil.shouldExecuteInWorld(e.getBlock().getLocation().getWorld().getName())) return;

        boolean shouldFly = false;

        boolean isBed = e.getBlock().getType().toString().contains("BED");

        if (PrettierExplosions.get().executeOnBeds && isBed) shouldFly = true;
        if (PrettierExplosions.get().executeOnOther && !isBed) shouldFly = true;

        if (shouldFly) Visuals.createRealisticExplosion(e.getBlock().getLocation(), e.blockList());

    }

}
