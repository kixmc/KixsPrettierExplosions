package com.kixmc.PE.commands.registry;

import com.kixmc.PE.core.PrettierExplosions;
import com.kixmc.PE.commands.PrettierExplosionsCommand;

public class CommandRegistry {

    public static void register() {

        PrettierExplosions.get().getCommand("prettierexplosions").setExecutor(new PrettierExplosionsCommand());

    }

}