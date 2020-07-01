package com.matthewcash.network;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WebsiteMessage {
    private static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void showMessage(Player player) {
        player.sendMessage(color(""));
        player.sendMessage(color("&e&lVisit my Website"));
        player.sendMessage(color("&7> &fmatthew-cash.com"));
        player.sendMessage(color(""));
    }
}