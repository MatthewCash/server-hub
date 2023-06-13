package com.matthewcash.network.Events;

import com.matthewcash.network.ServerMenu;
import com.matthewcash.network.WebsiteMessage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemInteractEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemClick(PlayerInteractEvent event) {
        // Cancel if event is not a click
        if (event.getAction() == Action.PHYSICAL) {
            return;
        }

        Player player = event.getPlayer();
        Integer currentSlot = player.getInventory().getHeldItemSlot();

        switch (currentSlot) {
            // Website Item
            case 0: {
                WebsiteMessage.showMessage(player);
                break;
            }
            // Server Menu Item
            case 4: {
                ServerMenu.showMenu(player);
                break;
            }
            // Leave Item
            case 8: {
                player.kickPlayer("Disconnected");
                break;
            }
        }
    }
}
