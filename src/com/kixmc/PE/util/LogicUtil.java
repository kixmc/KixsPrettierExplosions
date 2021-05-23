package com.kixmc.PE.util;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.config.ConfigListType;

public class LogicUtil {

    // determines whether an explosion should be prettified based on the world whitelist/blacklist
    public static boolean shouldExecuteInWorld(String worldName) {

        if (PrettierExplosions.get().listType == ConfigListType.NONE) return true;
        if (PrettierExplosions.get().listType == ConfigListType.WHITELIST) return PrettierExplosions.get().worldList.contains(worldName);
        if (PrettierExplosions.get().listType == ConfigListType.BLACKLIST) return !PrettierExplosions.get().worldList.contains(worldName);

        return false;

    }

}
