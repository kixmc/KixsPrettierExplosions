package com.kixmc.PE.core;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

import java.util.List;

public class Visuals {

    // the core visual
    public static void createRealisticExplosion(List<Block> list) {

        for (Block b : list) {
            if (PrettierExplosions.get().activeBlocksCount >= PrettierExplosions.get().visualCap) break;

            FallingBlock fb;

            // don't include these blocks in the visual (more importantly the active blocks count)
            if (b.getType() == Material.AIR) continue;
            if (b.getType() == Material.CAVE_AIR) continue; // not sure if this is necessary
            if (b.getType() == Material.TNT) continue;

            // create the entity
            fb = b.getWorld().spawnFallingBlock(b.getLocation().add(0, 1, 0), b.getBlockData());
            fb.setDropItem(false);

            // give it random velocity within limit
            fb.setVelocity(new Vector((float) -1 + (float) (Math.random() * ((1 - -1) + 1)), (float) 0.5, (float) -0.3 + (float) (Math.random() * ((0.3 - -0.3) + 1))));

            // save it to flying blocks list so we can delete it when it lands instead of it placing as an actual block
            PrettierExplosions.get().flyingBlocks.add(fb);

            PrettierExplosions.get().activeBlocksCount++;
        }

    }

}