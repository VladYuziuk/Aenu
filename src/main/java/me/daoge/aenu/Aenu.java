package me.daoge.aenu;

import lombok.Getter;
import me.daoge.aenu.api.RuntimeMenu;
import me.daoge.aenu.api.RuntimeMenuButton;
import me.daoge.aenu.command.MenuCommand;
import me.daoge.aenu.manager.MenuManager;
import org.allaymc.api.entity.interfaces.EntityPlayer;
import org.allaymc.api.item.type.ItemTypes;
import org.allaymc.api.plugin.Plugin;
import org.allaymc.api.registry.Registries;
import org.allaymc.api.server.Server;

/**
 * Main plugin class for Aenu - A configurable menu plugin for AllayMC
 * Supports SimpleForm menus with PlaceholderAPI integration
 */
public class Aenu extends Plugin {

    @Getter
    private static Aenu instance;

    @Getter
    private MenuManager menuManager;

    @Override
    public void onLoad() {
        instance = this;
        this.pluginLogger.info("Aenu is loading...");
    }

    @Override
    public void onEnable() {
        // Initialize menu manager
        this.menuManager = new MenuManager(this);

        // Load all menu configurations from data folder
        this.menuManager.loadMenus();

        // Register the /menu command
        Registries.COMMANDS.register(new MenuCommand());

        RuntimeMenu menu = RuntimeMenu.form("mines")
                .title("Mines")
                .content("Choose a mine")
                .button(RuntimeMenuButton.of("Mine A")
                        .message("§aOpening Mine A...")
                        .onClick(ctx -> {
                            // your Java logic here
                            // mineService.teleport(ctx.getPlayer(), mineA);
                        }))
                .button(RuntimeMenuButton.of("Back")
                        .jump("example"));

        registerRuntimeMenu(menu);

        RuntimeMenu c_menu = RuntimeMenu.chest("mines_chest")
                .title("Mines")
                .button(RuntimeMenuButton.of("Mine A")
                        .item("minecraft:diamond_pickaxe")
                        .slot(10)
                        .lore("§7Unlocked", "§eClick to enter")
                        .message("Testtttt")
                        .onClick(ctx -> {
                            // your Java logic here
                        }))
                .button(RuntimeMenuButton.of("Locked Mine")
                        .item("minecraft:barrier")
                        .slot(13)
                        .lore("§cLocked"));

        registerRuntimeMenu(c_menu);

        RuntimeMenu d_c_menu = RuntimeMenu.doubleChest("mines_double_chest")
                .title("Mines")
                .button(RuntimeMenuButton.of("Mine A")
                        .item("minecraft:diamond_pickaxe")
                        .slot(10)
                        .lore("§7Unlocked", "§eClick to enter")
                        .message("Testtttt2")
                        .onClick(ctx -> {
                            // your Java logic here
                        }))
                .button(RuntimeMenuButton.of("Locked Mine")
                        .item("minecraft:barrier")
                        .slot(13)
                        .lore("§cLocked"));

        registerRuntimeMenu(d_c_menu);

        this.pluginLogger.info("Aenu has been enabled! Loaded {} menus.", menuManager.getMenuCount());
    }

    @Override
    public void onDisable() {
        this.pluginLogger.info("Aenu has been disabled!");
    }

    @Override
    public boolean isReloadable() {
        return true;
    }

    @Override
    public void reload() {
        this.pluginLogger.info("Reloading Aenu...");

        // Clear existing menus and reload all configurations
        this.menuManager.clearMenus();
        this.menuManager.loadMenus();

        this.pluginLogger.info("Aenu has been reloaded! Loaded {} menus.", menuManager.getMenuCount());
    }

    public boolean openMenu(EntityPlayer player, String menuName) {
        return menuManager.showMenu(player, menuName);
    }

    public boolean openMenu(EntityPlayer player, RuntimeMenu runtimeMenu) {
        return menuManager.showMenu(player, runtimeMenu);
    }

    public RuntimeMenu registerRuntimeMenu(RuntimeMenu runtimeMenu) {
        menuManager.registerRuntimeMenu(runtimeMenu);
        return runtimeMenu;
    }

    public RuntimeMenu unregisterRuntimeMenu(String menuId) {
        return menuManager.unregisterRuntimeMenu(menuId);
    }
}
