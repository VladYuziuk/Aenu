package me.daoge.aenu.api;

import lombok.Getter;
import org.allaymc.api.form.element.ImageData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Runtime Java button definition.
 */
@Getter
public class RuntimeMenuButton {

    private final String text;
    private String id;
    private String item = "minecraft:paper";
    private int count = 1;
    private int meta = 0;
    private final List<String> lore = new ArrayList<>();
    private Integer slot;
    private boolean close;
    private String permission;
    private final List<String> messages = new ArrayList<>();
    private String jump;
    private final List<String> commands = new ArrayList<>();
    private ImageData.ImageType imageType;
    private String imageData;
    private Consumer<MenuClickContext> onClick;

    private RuntimeMenuButton(String text) {
        this.text = text;
    }

    public static RuntimeMenuButton of(String text) {
        return new RuntimeMenuButton(text);
    }

    public RuntimeMenuButton id(String id) {
        this.id = id;
        return this;
    }

    public RuntimeMenuButton item(String item) {
        this.item = item;
        return this;
    }

    public RuntimeMenuButton count(int count) {
        this.count = count;
        return this;
    }

    public RuntimeMenuButton meta(int meta) {
        this.meta = meta;
        return this;
    }

    public RuntimeMenuButton lore(String... lines) {
        this.lore.addAll(List.of(lines));
        return this;
    }

    public RuntimeMenuButton lore(List<String> lines) {
        this.lore.addAll(lines);
        return this;
    }

    public RuntimeMenuButton slot(int slot) {
        this.slot = slot;
        return this;
    }

    public RuntimeMenuButton close(boolean close) {
        this.close = close;
        return this;
    }

    public RuntimeMenuButton permission(String permission) {
        this.permission = permission;
        return this;
    }

    public RuntimeMenuButton message(String message) {
        this.messages.add(message);
        return this;
    }

    public RuntimeMenuButton messages(List<String> messages) {
        this.messages.addAll(messages);
        return this;
    }

    public RuntimeMenuButton jump(String jump) {
        this.jump = jump;
        return this;
    }

    public RuntimeMenuButton command(String command) {
        this.commands.add(command);
        return this;
    }

    public RuntimeMenuButton commands(List<String> commands) {
        this.commands.addAll(commands);
        return this;
    }

    public RuntimeMenuButton image(ImageData.ImageType imageType, String imageData) {
        this.imageType = imageType;
        this.imageData = imageData;
        return this;
    }

    public RuntimeMenuButton onClick(Consumer<MenuClickContext> onClick) {
        this.onClick = onClick;
        return this;
    }
}