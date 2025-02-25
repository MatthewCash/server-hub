package com.matthewcash.network;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.bukkit.plugin.Plugin;

public class RealDayTime {
    public static double latitudeDeg;
    public static double longitudeDeg;

    public static double sunriseHour;
    public static double sunsetHour;

    public static void startTimer() {
        final Plugin plugin = ServerHub.getPlugin();

        latitudeDeg = plugin.getConfig().getDouble("latitude");
        longitudeDeg = plugin.getConfig().getDouble("longitude");

        plugin.getServer().getScheduler()
            .scheduleSyncRepeatingTask(
                plugin, () -> updateSunTimes(), 0, 3600 * 20
            );

        plugin.getServer().getScheduler()
            .scheduleSyncRepeatingTask(
                plugin, () -> updateTime(), 1, 1
            );
    }

    private static void updateSunTimes() {
        // Approximate solar declination in degrees
        final double declRad = Math.toRadians(
            23.44 * Math.sin(
                (2 * Math.PI
                    * (284 + LocalDate.now()
                        .getDayOfYear()))
                    / 365
            )
        );

        final double latRad = Math
            .toRadians(latitudeDeg);

        // Calculate the hour angle H at sunrise/sunset
        final double cosH = Math
            .clamp(-Math.tan(latRad) * Math.tan(declRad), -1, 1);

        // Convert the hour angle to hours (15° = 1 hour)
        final double Hdeg = Math.toDegrees(Math.acos(cosH));
        final double deltaHours = Hdeg / 15.0;

        sunriseHour = 12 - deltaHours;
        sunsetHour = 12 + deltaHours;
    }

    private static void updateTime() {

        final double solarHour = getSolarHour(
            ServerHub.getPlugin().getConfig().getDouble("longitude")
        );

        final double dayPercent = (solarHour - sunriseHour)
            / (sunsetHour - sunriseHour);

        final long ticks = (long) (dayPercent * 12000);

        ServerHub.getPlugin().getServer().getWorlds().getFirst()
            .setTime(ticks);
    }

    public static double getSolarHour(double longitudeDeg) {
        ZonedDateTime nowUTC = ZonedDateTime.now(ZoneOffset.UTC);

        double utcHour = nowUTC.getHour() + nowUTC.getMinute() / 60.0
            + nowUTC.getSecond() / 3600.0;

        double solarHour = utcHour + longitudeDeg / 15.0;

        return (solarHour % 24 + 24) % 24;
    }
}
