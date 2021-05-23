package com.kixmc.PE.commands;

import com.kixmc.PE.config.ConfigVarLoader;
import com.kixmc.PE.core.PrettierExplosions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PrettierExplosionsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getLabel().equalsIgnoreCase("prettierexplosions")) {

            if (args.length != 1) {

                sender.sendMessage(ChatColor.AQUA + "Prettier Explosions by kixmc: v" + PrettierExplosions.get().getDescription().getVersion());

                if (sender.hasPermission("prettierexplosions.reload")) {
                    sender.sendMessage(ChatColor.GRAY + "Reload config with /" + label + " reload");
                }

            } else if (args[0].equalsIgnoreCase("reload")) {

                if (!sender.hasPermission("prettierexplosions.reload")) {
                    sender.sendMessage(ChatColor.RED + "No permission.");
                    return true;
                }

                PrettierExplosions.get().reloadConfig();
                ConfigVarLoader.update();

                sender.sendMessage(ChatColor.GREEN + "Reloaded config!");

                return true;

            } else {
                sender.sendMessage(ChatColor.RED + "/" + label + " reload");
                return true;
            }

        }

        return true;
    }

}
