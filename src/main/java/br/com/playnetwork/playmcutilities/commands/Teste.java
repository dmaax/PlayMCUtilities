package br.com.playnetwork.playmcutilities.commands;

import br.com.playnetwork.playmcutilities.PlayMCUtilities;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Teste implements CommandExecutor {

    private final PlayMCUtilities playmcutilities;

    public Teste(PlayMCUtilities playmcutilities) {
        this.playmcutilities = playmcutilities;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        //Audience
        //Content
        if(label.equalsIgnoreCase("teste")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("Comando in-game apenas.");
                return true;
            }
            TextComponent component = Component.text("Teste", TextColor.color(6, 57, 112));
            playmcutilities.adventure().sender((Player) sender).sendMessage(component);
        }


        return false;
    }
}
