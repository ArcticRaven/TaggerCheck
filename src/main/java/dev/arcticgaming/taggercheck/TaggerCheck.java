package dev.arcticgaming.taggercheck;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TaggerCheck extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Objects.requireNonNull(getCommand("tagRename")).setExecutor(new tagRenameCommand());
        Objects.requireNonNull(getCommand("tagsHelp")).setExecutor(new tagHelpCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
