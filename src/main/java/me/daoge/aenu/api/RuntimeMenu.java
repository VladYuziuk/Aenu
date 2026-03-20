package me.daoge.aenu.api;

import lombok.Getter;
import me.daoge.aenu.model.MenuUiType;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime Java menu definition.
 */
@Getter
public class RuntimeMenu {

    private final String id;
    private final MenuUiType uiType;
    private String title = "";
    private String content = "";
    private String permission;
    private final List<RuntimeMenuButton> buttons = new ArrayList<>();

    private RuntimeMenu(String id, MenuUiType uiType) {
        this.id = id;
        this.uiType = uiType;
    }

    public static RuntimeMenu form(String id) {
        return new RuntimeMenu(id, MenuUiType.FORM);
    }

    public static RuntimeMenu chest(String id) {
        return new RuntimeMenu(id, MenuUiType.CHEST);
    }

    public static RuntimeMenu doubleChest(String id) {
        return new RuntimeMenu(id, MenuUiType.DOUBLE_CHEST);
    }

    public RuntimeMenu title(String title) {
        this.title = title == null ? "" : title;
        return this;
    }

    public RuntimeMenu content(String content) {
        this.content = content == null ? "" : content;
        return this;
    }

    public RuntimeMenu permission(String permission) {
        this.permission = permission;
        return this;
    }

    public RuntimeMenu button(RuntimeMenuButton button) {
        this.buttons.add(button);
        return this;
    }
}
