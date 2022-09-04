package com.matthewcash.network;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WebsiteMessage {
    private static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void showMessage(Player player) {
        player.sendMessage(color("\n&e&lVisit my Website\n &7> &fmatthew-cash.com\n"));
    }
}