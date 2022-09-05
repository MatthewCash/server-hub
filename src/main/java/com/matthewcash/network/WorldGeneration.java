package com.matthewcash.network;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class WorldGeneration implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onChunkLoad(ChunkLoadEvent event) {
        if (event.isNewChunk())
            event.getChunk().unload(false, false);
    }
}
