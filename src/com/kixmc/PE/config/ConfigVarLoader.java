package com.kixmc.PE.config;

import com.kixmc.PE.core.ListType;
import com.kixmc.PE.core.PrettierExplosions;

public class ConfigVarLoader {

    public static void update() {

        PrettierExplosions.get().executeOnTnt = PrettierExplosions.get().getConfig().getBoolean("prettify.tnt-explosions");
        PrettierExplosions.get().executeOnBeds = PrettierExplosions.get().getConfig().getBoolean("prettify.bed-explosions");
        PrettierExplosions.get().executeOnCreepers = PrettierExplosions.get().getConfig().getBoolean("prettify.creeper-explosions");
        PrettierExplosions.get().executeOnOther = PrettierExplosions.get().getConfig().getBoolean("prettify.other-explosions");

        PrettierExplosions.get().visualCap = PrettierExplosions.get().getConfig().getInt("visual-cap-in-blocks");

        PrettierExplosions.get().extraVisuals = PrettierExplosions.get().getConfig().getBoolean("extra-visuals");

        PrettierExplosions.get().listType = ListType.valueOf(PrettierExplosions.get().getConfig().getString("list-type").toUpperCase());

        PrettierExplosions.get().worldList.clear();
        PrettierExplosions.get().worldList.addAll(PrettierExplosions.get().getConfig().getStringList("world-list"));

        if (PrettierExplosions.get().worldList.isEmpty()) PrettierExplosions.get().listType = ListType.NONE;

    }

}