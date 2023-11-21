package io.github.elihuso.chatcolor.listener;

import io.github.elihuso.chatcolor.utils.ColorHandleUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class PlayerChatListener implements Listener {

    private final Plugin plugin;

    public PlayerChatListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(ColorHandleUtils.HandleFormat(event.getMessage()));
    }
}
