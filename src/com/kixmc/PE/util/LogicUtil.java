package com.kixmc.PE.util;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.core.ListType;

public class LogicUtil {

    // determines whether an explosion should be prettified based on the world whitelist/blacklist
    public static boolean shouldExecuteInWorld(String worldName) {

        if (PrettierExplosions.get().listType == ListType.NONE) return true;
        if (PrettierExplosions.get().listType == ListType.WHITELIST) return PrettierExplosions.get().worldList.contains(worldName);
        if (PrettierExplosions.get().listType == ListType.BLACKLIST) return !PrettierExplosions.get().worldList.contains(worldName);

        return false;

    }

}
