package com.matthewcash.network.Events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvent implements Listener {
    public final static Location spawn = new Location(
        Bukkit.getWorld("hub"), -1618.5, 51, 1215.5, 180, 0
    );

    private static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.teleport(spawn);

        player.setGameMode(GameMode.ADVENTURE);

        player.getInventory().clear();

        player.setSaturation(20);
        player.setFoodLevel(20);

        player.getInventory().setHeldItemSlot(4);

        // Set Website Item (Slot 0)
        ItemStack websiteItem = createInventoryItem(
            Material.PAPER, "&a&lWebsite", "&eClick to open Website"
        );
        player.getInventory().setItem(0, websiteItem);

        // Set Server Menu Item (Slot 4)
        ItemStack menuItem = createInventoryItem(
            Material.NETHER_STAR, "&b&lServer Menu",
            "&eClick to open Server Menu"
        );
        player.getInventory().setItem(4, menuItem);

        // Set Leave Item (Slot 8)
        ItemStack leaveItem = createInventoryItem(
            Material.BED, "&c&lLeave", "&eClick to Leave"
        );
        player.getInventory().setItem(8, leaveItem);

    }

    private static ItemStack createInventoryItem(
        Material itemType, String name, String lore
    ) {
        ItemStack itemStack = new ItemStack(itemType);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));

        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(color(lore));

        itemMeta.setLore(itemLore);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
