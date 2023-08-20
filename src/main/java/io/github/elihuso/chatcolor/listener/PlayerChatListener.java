package io.github.elihuso.chatcolor.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class PlayerChatListener implements Listener {

    private final Plugin plugin;

    public PlayerChatListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerChat(AsyncPlayerChatEvent event) {
        char[] charmap = event.getMessage().toCharArray();
        int length = charmap.length;
        for (int i = 0; i < charmap.length; ++i) {
            if (charmap[i] == '&') {
                if (charmap[i + 1] != '&') {
                    charmap[i] = '§';
                }
                else {
                    for (int j = i; j < charmap.length - 1; ++j) {
                        charmap[j] = charmap[j + 1];
                    }
                    i += 1;
                    length -= 1;
                }
            }
        }
        char[] out = new char[length];
        System.arraycopy(charmap, 0, out, 0, length);
        event.setMessage(new String(out));
    }
}
