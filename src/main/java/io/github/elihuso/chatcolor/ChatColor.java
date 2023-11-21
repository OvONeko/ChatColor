package io.github.elihuso.chatcolor;

import io.github.elihuso.chatcolor.config.ConfigManager;
import io.github.elihuso.chatcolor.listener.PlayerChatListener;
import io.github.elihuso.chatcolor.utils.ColorHandleUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.*;

import java.util.ArrayList;

public final class ChatColor extends JavaPlugin {
    private final ConfigManager configManager = new ConfigManager(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (configManager.Enabled()) Bukkit.getPluginManager().registerEvents(new PlayerChatListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String commandLabel, @Nullable String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command could only run by a player");
            return false;
        }
        Player player = (Player) sender;
        if (!configManager.AllowCommandRename()) {
            player.sendMessage(org.bukkit.ChatColor.GREEN + "this command was disabled globally");
            return false;
        }
        if (command.getLabel().equalsIgnoreCase("rename")) {
            if (args.length == 0) {
                player.sendMessage(org.bukkit.ChatColor.RED + "Please input new name!");
                return false;
            }
            String s = "";
            for (var v : args) {
                if (s.length() != 0)
                    s += " ";
                s += v;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null) {
                player.sendMessage(org.bukkit.ChatColor.RED + "No item in your hand!");
                return false;
            }
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ColorHandleUtils.HandleFormat(s));
            item.setItemMeta(meta);
            player.getInventory().setItemInMainHand(item);
        }
        if (command.getLabel().equalsIgnoreCase("description")) {
            if (args.length == 0) {
                player.sendMessage(org.bukkit.ChatColor.RED + "Please input new name!");
                return false;
            }
            String s = "";
            for (var v : args) {
                if (s.length() != 0)
                    s += " ";
                s += v;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null) {
                player.sendMessage(org.bukkit.ChatColor.RED + "No item in your hand!");
                return false;
            }
            ItemMeta meta = item.getItemMeta();
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ColorHandleUtils.HandleFormat(s));
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().setItemInMainHand(item);
        }
        if (command.getLabel().equalsIgnoreCase("addlore")) {
            if (args.length == 0) {
                player.sendMessage(org.bukkit.ChatColor.RED + "Please input new name!");
                return false;
            }
            String s = "";
            for (var v : args) {
                if (s.length() != 0)
                    s += " ";
                s += v;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null) {
                player.sendMessage(org.bukkit.ChatColor.RED + "No item in your hand!");
                return false;
            }
            ItemMeta meta = item.getItemMeta();
            ArrayList<String> lore = new ArrayList<>();
            lore.addAll(meta.getLore());
            lore.add(ColorHandleUtils.HandleFormat(s));
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().setItemInMainHand(item);
        }
        return false;
    }
}
