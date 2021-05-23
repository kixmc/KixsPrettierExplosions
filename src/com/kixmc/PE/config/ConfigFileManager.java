package com.kixmc.PE.config;

import com.kixmc.PE.core.PrettierExplosions;

import java.io.File;

public class ConfigFileManager {

    public static void setup() {

        try {

            if (!PrettierExplosions.get().getDataFolder().exists()) {
                PrettierExplosions.get().getDataFolder().mkdirs();
            }

            File config = new File(PrettierExplosions.get().getDataFolder(), "config.yml");

            if (!config.exists()) {
                PrettierExplosions.get().saveDefaultConfig();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}