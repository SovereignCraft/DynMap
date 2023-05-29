package com.sovereigncraft.playerqrmap.event;

import com.sovereigncraft.playerqrmap.Main;
import com.sovereigncraft.playerqrmap.util.ImageCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ItemHeld implements Listener {

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getItemInHand();
        if (item.getItemMeta().hasLore()) {
            if (Material.MAP.equals(item.getType()) & item.getItemMeta().getLore().toString() == "SC Interface") {
                MapView map = Bukkit.getMap(item.getDurability());
                MapRenderer SCMapRenderer = new MapRenderer(true) {
                    @Override
                    public void render(MapView map, MapCanvas canvas, Player player) {

                    }
                };

            }
        }
    }

}
