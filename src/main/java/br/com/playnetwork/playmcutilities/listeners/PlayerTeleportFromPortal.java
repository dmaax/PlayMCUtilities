package br.com.playnetwork.playmcutilities.listeners;

import br.com.playnetwork.playmcutilities.PlayMCUtilities;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleportFromPortal implements Listener {

    private final PlayMCUtilities playmcutilities;

    public PlayerTeleportFromPortal(PlayMCUtilities playmcutilities) {
        this.playmcutilities = playmcutilities;
    }


    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
            TextComponent component = Component.text("Você teleportou através de um portal.\nSeu mundo: " + player.getWorld().getName(), TextColor.color(90, 23, 120));
            playmcutilities.adventure().player(player).sendMessage(component);

        }

    }

}
