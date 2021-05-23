package com.kixmc.PE.listeners;

import com.kixmc.PE.core.PrettierExplosions;
import org.bukkit.Effect;
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
        if (!PrettierExplosions.get().flyingBlocks.contains((FallingBlock) e.getEntity())) return;

        e.setCancelled(true);

        PrettierExplosions.get().activeBlocksCount--;

        if (PrettierExplosions.get().extraVisuals) {
            // give the block landing particles so it doesn't just vanish into thin air
            e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND,
                    e.getBlock().getLocation().subtract(0, 1, 0).getBlock().getType());
        }

    }

}