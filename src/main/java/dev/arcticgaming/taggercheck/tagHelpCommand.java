package dev.arcticgaming.taggercheck;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tagHelpCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Component helpMessage = Component.text().content("-----------------------------------------------\n" +
                            "Use /tagrename <name> to rename tags\n" +
                            "\n" +
                            "(Java Only)\n" +
                            "RGB and Gradients can be formatted correctly at\n" +
                            "this site: ").color(TextColor.color(0x0bfc03))
                    .append(Component.text("[Click Here]").clickEvent(ClickEvent.openUrl("https://webui.adventure.kyori.net/"))
                            .color(TextColor.color(0xf8fc03))).build()
                    .append(Component.text("\n-----------------------------------------------").color(TextColor.color(0x0bfc03)))
                    .toBuilder().build();

            player.sendMessage(helpMessage);


        }
        return false;
    }
}
