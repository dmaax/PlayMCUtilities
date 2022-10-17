package br.com.playnetwork.playmcutilities;

import br.com.playnetwork.playmcutilities.commands.Teste;
import br.com.playnetwork.playmcutilities.listeners.PlayerTeleportFromPortal;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class PlayMCUtilities extends JavaPlugin {

    private BukkitAudiences adventure;

    public @NonNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        //Startup login
        this.adventure = BukkitAudiences.create(this);
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        //Shutdown login
        if(this.adventure != null) {
            this.adventure.close();
            this.adventure = null;
        }
        unregisterAll();
    }

    private void registerCommands() {
        getCommand("teste").setExecutor(new Teste(this));
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerTeleportFromPortal(this), this);
    }

    private void unregisterAll() {
        HandlerList.unregisterAll();
    }

}
