package com.matthewcash.network;

import com.matthewcash.network.Events.JoinEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WorldBorder implements Listener {
    private static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPlayerMove(PlayerMoveEvent event) {
        if (event.getTo().getY() < 36)
            resetPlayerPosition(event.getPlayer());
    }

    static void resetPlayerPosition(Player player) {
        player.teleport(JoinEvent.spawn);
        player.sendMessage(color("&4&lERROR &cYou may not leave spawn!"));
    }
}
