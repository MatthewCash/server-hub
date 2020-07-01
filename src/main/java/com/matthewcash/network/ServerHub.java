package com.matthewcash.network;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class ServerHub extends JavaPlugin implements PluginMessageListener {
    private static ServerHub plugin;

    public static ServerHub getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemInteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ServerMenu(), this);
        Bukkit.getPluginManager().registerEvents(new CancelEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JoinLeaveEvents(), this);
        Bukkit.getPluginManager().registerEvents(new NPCInteract(), this);

        Bukkit.getPluginCommand("website").setExecutor(new HubCommands());
        Bukkit.getPluginCommand("menu").setExecutor(new HubCommands());
        Bukkit.getPluginCommand("leave").setExecutor(new HubCommands());

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getLogger().info("Enabled ServerHub!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled ServerHub!");
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        // No messages are expected to be received
    }
}