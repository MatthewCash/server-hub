package com.matthewcash.network;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerMenu implements Listener {
    private static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void showMenu(Player player) {
        Inventory inventory = Bukkit
            .createInventory(null, 27, color("&c&lServer Menu"));

        inventory.setItem(
            11,
            createInventoryItem(
                Material.SAPLING, "&c&lSkyFactory", "&eClick to Join!", true
            )
        );
        inventory.setItem(
            13,
            createInventoryItem(
                Material.IRON_SWORD, "&a&lSurvival", "&eClick to Join!", true
            )
        );
        inventory.setItem(
            15,
            createInventoryItem(
                Material.DIAMOND_PICKAXE, "&b&lCreative", "&eClick to Join!",
                true
            )
        );

        player.openInventory(inventory);
    }

    private static ItemStack createInventoryItem(
        Material itemType, String name, String lore, Boolean glowing
    ) {
        ItemStack itemStack = new ItemStack(itemType);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));

        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(color(lore));

        itemMeta.setLore(itemLore);

        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        if (glowing) {
            itemStack.addUnsafeEnchantment(Enchantment.LURE, 1);
        }

        return itemStack;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onInventoryClick(InventoryClickEvent event) {
        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null)
            return;
        if (event.getCurrentItem().getType() == Material.AIR)
            return;

        switch (event.getRawSlot()) {
            case 11: {
                BungeeMessenger.sendPlayer(player, "skyfactory");
                break;
            }
            case 13: {
                BungeeMessenger.sendPlayer(player, "survival");
                break;
            }
            case 15: {
                BungeeMessenger.sendPlayer(player, "creative");
                break;
            }
        }
    }
}
