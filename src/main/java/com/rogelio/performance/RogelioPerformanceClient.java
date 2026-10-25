package com.rogelio.performance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Initial diagnostic foundation. This version intentionally does not change
 * rendering, world data, Voxy, Iris, Sodium, or gameplay settings.
 */
public final class RogelioPerformanceClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("Rogelio Performance");
    private static final int SAMPLE_INTERVAL_TICKS = 100; // approximately 5 seconds
    private int ticks;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Rogelio Performance 0.1.0 iniciado. Modo diagnóstico seguro; no modifica el renderizado.");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client == null || client.player == null || client.world == null) {
                ticks = 0;
                return;
            }
            ticks++;
            if (ticks >= SAMPLE_INTERVAL_TICKS) {
                ticks = 0;
                Runtime runtime = Runtime.getRuntime();
                long usedMiB = (runtime.totalMemory() - runtime.freeMemory()) / (1024L * 1024L);
                long maxMiB = runtime.maxMemory() / (1024L * 1024L);
                LOGGER.info("[RP-METRICS] fps={} heap_used_mib={} heap_max_mib={} dimension={}",
                        client.getCurrentFps(), usedMiB, maxMiB, client.world.getRegistryKey().getValue());
            }
        });
    }
}
