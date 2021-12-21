package com.matthewcash.network.Events;

import com.matthewcash.network.BungeeMessenger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;

public class NPCInteractEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onNPCLeftClick(NPCLeftClickEvent event) {
        Player player = event.getClicker();
        NPC npc = event.getNPC();

        NPCClick(player, npc.getId());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onNPCRightClick(NPCRightClickEvent event) {
        Player player = event.getClicker();
        NPC npc = event.getNPC();

        NPCClick(player, npc.getId());
    }

    private static void NPCClick(Player player, Integer id) {
        switch (id) {
            case 0: {
                BungeeMessenger.sendPlayer(player, "survival");
                break;
            }
            case 1: {
                BungeeMessenger.sendPlayer(player, "creative");
                break;
            }
            case 2: {
                BungeeMessenger.sendPlayer(player, "skyfactory");
                break;
            }
        }
    }
}