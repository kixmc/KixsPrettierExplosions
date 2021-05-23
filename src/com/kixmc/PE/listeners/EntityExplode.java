package com.kixmc.PE.listeners;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.core.Visuals;
import com.kixmc.PE.util.LogicUtil;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplode implements Listener {

    // fires for tnt and other entities
    // HIGHEST priority to ensure it's called as late as possible to hand over priority to protection & claiming plugins if they cancel the event

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onExplosion(EntityExplodeEvent e) {

        if (!LogicUtil.shouldExecuteInWorld(e.getLocation().getWorld().getName())) return;

        boolean shouldFly = false;

        if (PrettierExplosions.get().executeOnTnt && e.getEntityType() == EntityType.PRIMED_TNT) shouldFly = true;
        if (PrettierExplosions.get().executeOnCreepers && e.getEntityType() == EntityType.CREEPER) shouldFly = true;
        if (PrettierExplosions.get().executeOnOther && e.getEntityType() != EntityType.PRIMED_TNT) shouldFly = true;

        if (shouldFly) Visuals.createRealisticExplosion(e.blockList());

    }

}