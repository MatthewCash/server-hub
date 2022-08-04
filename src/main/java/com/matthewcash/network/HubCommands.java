package com.matthewcash.network;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        switch (command.getName().toLowerCase()) {
            case "website": {
                WebsiteMessage.showMessage(player);
                break;
            }
            case "menu": {
                ServerMenu.showMenu(player);
                break;
            }
            case "leave": {
                player.kickPlayer("Disconnected");
                break;
            }
        }

        return true;
    }
}