package com.matthewcash.network;

import java.time.LocalDate;
import java.time.LocalTime;

import org.bukkit.plugin.Plugin;

public class RealDayTime {
    public static void startTimer() {
        final Plugin plugin = ServerHub.getPlugin();
        plugin.getServer().getScheduler()
            .scheduleSyncRepeatingTask(
                plugin, () -> updateTime(), 0, 1
            );
    }

    private static void updateTime() {
        // Approximate solar declination in degrees
        final double declRad = Math.toRadians(
            23.44 * Math.sin(
                (2 * Math.PI
                    * (284 + LocalDate.now()
                        .getDayOfYear()))
                    / 365
            )
        );

        final double latRad = Math.toRadians(46.5);

        // Calculate the hour angle H at sunrise/sunset
        final double cosH = Math
            .clamp(-Math.tan(latRad) * Math.tan(declRad), -1, 1);

        // Convert the hour angle to hours (15° = 1 hour)
        final double Hdeg = Math.toDegrees(Math.acos(cosH));
        final double deltaHours = Hdeg / 15.0;

        final double sunriseTime = 12 - deltaHours;
        final double sunsetTime = 12 + deltaHours;

        final LocalTime now = LocalTime.now();
        final double hourFraction = now.getHour()
            + now.getMinute() / 60.0
            + now.getSecond() / 3600.0;

        final double dayPercent = (hourFraction - sunriseTime)
            / (sunsetTime - sunriseTime);

        final long ticks = (long) (dayPercent * 12000);

        ServerHub.getPlugin().getServer().getWorlds().getFirst()
            .setTime(ticks);
    }
}
