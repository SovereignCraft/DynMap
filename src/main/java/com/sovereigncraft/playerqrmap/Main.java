package com.sovereigncraft.playerqrmap;


import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import com.sovereigncraft.playerqrmap.command.QRCode;
import com.sovereigncraft.playerqrmap.command.MapInterface;
import com.sovereigncraft.playerqrmap.event.MapInitialize;
import com.sovereigncraft.playerqrmap.event.ItemHeld;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin {

    @Getter @Setter
    private static Main instance;

    @SneakyThrows
    @Override
    public void onEnable() {
        setInstance(this);
        getCommand("qrcode").setExecutor(new QRCode());
        getCommand("mapinterface").setExecutor(new MapInterface());
        Bukkit.getPluginManager().registerEvents(new MapInitialize(), this);
        Bukkit.getPluginManager().registerEvents(new ItemHeld(), this);


        File configFile = new File(getDataFolder()+File.separator+"config.yml");
        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        File mapsData = new File(getDataFolder()+File.separator+"data.yml");
        if (!mapsData.exists()) {
            mapsData.createNewFile();
        }

        getLogger().info("PlayerQRMap is enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlayerQRMap is disabled!");
    }

    public static String getMessage(String messageCode) {
        return getInstance().getConfig().getString(messageCode).replace("&", "§");
    }

}