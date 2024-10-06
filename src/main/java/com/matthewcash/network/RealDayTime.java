package com.matthewcash.network;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class RealDayTime {
    static final double TIME_RATIO = 86400.0 / 24000;

    public static void startTimer() {
        final Plugin plugin = ServerHub.getPlugin();
        final BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler
            .scheduleSyncRepeatingTask(
                plugin, () -> updateTime(), 0, (long) TIME_RATIO * 20
            );
    }

    private static void updateTime() {
        final int seconds = LocalTime.now().toSecondOfDay();
        final long ticks = (long) ((seconds / TIME_RATIO + 18000) % 24000);

        ServerHub.getPlugin().getServer().getWorlds().getFirst().setTime(ticks);
    }
}
