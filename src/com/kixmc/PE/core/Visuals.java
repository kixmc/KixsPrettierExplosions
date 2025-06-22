package com.kixmc.PE.core;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

import java.util.List;

public class Visuals {

    // the core visual
    public static void createRealisticExplosion(Location sourcePoint, List<Block> list) {

        for (Block b : list) {
            if (PrettierExplosions.get().activeBlocksCount >= PrettierExplosions.get().visualCap) break;

            // don't include these blocks in the visual (more importantly the active blocks count)
            if (b.getType() == Material.AIR) continue;
            if (b.getType() == Material.CAVE_AIR) continue; // not sure if this is necessary
            if (b.getType() == Material.TNT) continue;
            if (!b.getType().isSolid()) continue; // only launch solid blocks

            // create the entity
            FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation().add(0.5, 0.5, 0.5), b.getBlockData());
            fb.setDropItem(false);

            if(PrettierExplosions.get().realisticTrajectories) {

                // fling the blocks away from the explosion source point
                double distance = fb.getLocation().distance(sourcePoint);
                Vector velocity = fb.getLocation().clone().subtract(sourcePoint).toVector().normalize().divide(new Vector(distance, distance, distance)).multiply(1.5);

                // always make sure the blocks get thrown into the air
                if (velocity.getY() < 0) {
                    velocity.multiply(new Vector(1, -1.5, 1));
                } else {
                    velocity.multiply(new Vector(1, 1.5, 1));
                }

                // don't let the blocks fly *too* high
                if (velocity.getY() > 2) velocity.setY(2);

                // add a little bit of randomness
                velocity.add(Vector.getRandom().multiply(0.05));
                fb.setVelocity(velocity);

            } else { fb.setVelocity(new Vector((float) -1 + (float) (Math.random() * ((1 - -1) + 1)), (float) 0.5, (float) -0.3 + (float) (Math.random() * ((0.3 - -0.3) + 1)))); }

            // save it to flying blocks list so we can delete it when it lands instead of it placing as an actual block
            PrettierExplosions.get().flyingBlocks.add(fb);
            // we'll remove the entity regardless after 30 seconds, as it should always have landed by this point
            // if it hasn't, it's probably frozen out of tick distance and would otherwise become untracked and land normally if not loaded before the server restarts
            Bukkit.getScheduler().runTaskLater(PrettierExplosions.get(), () -> {
                PrettierExplosions.get().flyingBlocks.remove(fb);
                if(fb.isValid()) fb.remove();
            }, 600L); // 30 sec

            PrettierExplosions.get().activeBlocksCount++;
        }

    }

    // currently the only extra visual
    public static void createBlockLandEffect(FallingBlock fb) {
        // makes block break looking particles of the inputted blocks material
        fb.getWorld().playEffect(fb.getLocation(), Effect.STEP_SOUND, fb.getBlockData().getMaterial());
    }

}
