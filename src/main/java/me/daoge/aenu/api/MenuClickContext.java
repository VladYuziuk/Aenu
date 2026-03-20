package me.daoge.aenu.api;

import lombok.Getter;
import me.daoge.aenu.manager.MenuManager;
import org.allaymc.api.entity.interfaces.EntityPlayer;

/**
 * Runtime context for Java-built menu button clicks.
 */
@Getter
public class MenuClickContext {

    private final EntityPlayer player;
    private final MenuManager menuManager;
    private final RuntimeMenu menu;
    private final RuntimeMenuButton button;

    public MenuClickContext(EntityPlayer player, MenuManager menuManager, RuntimeMenu menu, RuntimeMenuButton button) {
        this.player = player;
        this.menuManager = menuManager;
        this.menu = menu;
        this.button = button;
    }

    public boolean openMenu(String menuName) {
        return menuManager.showMenu(player, menuName);
    }

    public boolean openMenu(RuntimeMenu runtimeMenu) {
        return menuManager.showMenu(player, runtimeMenu);
    }

    public void sendMessage(String message) {
        menuManager.sendRuntimeMessage(player, message);
    }

    public void executeCommand(String command) {
        menuManager.executeRuntimeCommand(player, command);
    }

    public String getButtonId() {
        return button.getId();
    }
}
