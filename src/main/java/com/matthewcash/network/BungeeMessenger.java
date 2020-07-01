package com.matthewcash.network;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import org.bukkit.entity.Player;

public class BungeeMessenger {
    public static void sendPlayer(Player player, String server) {
        ByteArrayDataOutput data = ByteStreams.newDataOutput();
        data.writeUTF("Connect");
        data.writeUTF(server);
        player.sendPluginMessage(ServerHub.getPlugin(), "BungeeCord", data.toByteArray());
    }
}