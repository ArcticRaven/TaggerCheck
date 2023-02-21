package dev.arcticgaming.taggercheck;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.minimessage.tag.standard.StandardTags;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class tagRenameCommand implements CommandExecutor {
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

            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.NAME_TAG) {

                ItemMeta NameTagMeta = item.getItemMeta();
                Component displayName = formatResolve(args[0]);
                NameTagMeta.displayName(displayName);
                item.setItemMeta(NameTagMeta);
            }
        }
        return false;
    }

    public static Component formatResolve(String string){

        MiniMessage serializer = MiniMessage.builder()
                .tags(TagResolver.builder()
                        .resolver(StandardTags.defaults()).build())
                .build();

        return serializer.deserialize(string);
    }
}
