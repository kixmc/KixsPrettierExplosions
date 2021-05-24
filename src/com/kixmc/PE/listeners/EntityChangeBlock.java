package com.kixmc.PE.listeners;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.core.Visuals;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class EntityChangeBlock implements Listener {

    // delete flying blocks when they land instead of it placing as an actual block
    // LOWEST priority to ensure it's called as soon as possible - don't want rogue entities

    @EventHandler(priority = EventPriority.LOWEST)
    public void deleteFlyingBlocksOnLand(EntityChangeBlockEvent e) {

        if (!(e.getEntity() instanceof FallingBlock)) return;
        FallingBlock fb = (FallingBlock) e.getEntity();
        if (!PrettierExplosions.get().flyingBlocks.contains(fb)) return;

        e.setCancelled(true);

        PrettierExplosions.get().activeBlocksCount--;

        if (PrettierExplosions.get().extraVisuals) {
            // give the block landing particles so it doesn't just vanish into thin air
            Visuals.createBlockLandEffect(fb);
        }

    }

}
