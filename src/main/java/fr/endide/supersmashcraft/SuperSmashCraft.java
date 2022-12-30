package fr.endide.supersmashcraft;

import fr.endide.supersmashcraft.commands.ssc;
import fr.endide.supersmashcraft.entity.Arena;
import fr.endide.supersmashcraft.entity.ArenaManager;
import fr.endide.supersmashcraft.entity.FighterManager;
import fr.endide.supersmashcraft.entity.Fighters;
import fr.endide.supersmashcraft.listeners.basicSystem;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class SuperSmashCraft extends JavaPlugin {
    private Location spawn;
    private ArenaManager arenaManager = new ArenaManager();
    private FighterManager fighterManager = new FighterManager();
    private File arenaConfigFile;
    private YamlConfiguration arenaConfig;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        createArenaConfig();
        getCommand("scc").setExecutor(new ssc(this));
        getServer().getPluginManager().registerEvents(new basicSystem(this), this);

    }

    @Override
    public void onDisable() {
        saveArenasInConfig();

    }
    public void getArenasList(){
        arenaManager.deleteAllArenas();
        ConfigurationSection arenaSection = arenaConfig.getConfigurationSection("arenas");
        for(String string : arenaSection.getKeys(false)) {
            String name = arenaConfig.getString(string + ".name");
            Double loc1X = arenaConfig.getDouble(string + ".loc1.x");
            Double loc1Y = arenaConfig.getDouble(string + ".loc1.y");
            Double loc1Z = arenaConfig.getDouble(string + ".loc1.z");
            Double loc2X = arenaConfig.getDouble(string + ".loc2.x");
            Double loc2Y = arenaConfig.getDouble(string + ".loc2.y");
            Double loc2Z = arenaConfig.getDouble(string + ".loc2.z");
            String worldName = arenaConfig.getString(string + ".worldName");
            int maxPlayers = arenaConfig.getInt(string + ".maxPlayers");
            Location loc1 = new Location(getServer().getWorld(worldName), loc1X, loc1Y, loc1Z);
            Location loc2 = new Location(getServer().getWorld(worldName), loc2X, loc2Y, loc2Z);
            Arena arena = new Arena(name, loc1, loc2, getServer().getWorld(worldName), new ArrayList<>(), false, maxPlayers);
            arenaManager.addArena(arena);
        }
    }

    public void saveArenasInConfig(){
        arenaConfig.set("arenas", null);
        for (Arena arena : arenaManager.arenas) {
            String name = arena.getName();
            Double loc1X = arena.getLoc1().getX();
            Double loc1Y = arena.getLoc1().getY();
            Double loc1Z = arena.getLoc1().getZ();
            Double loc2X = arena.getLoc2().getX();
            Double loc2Y = arena.getLoc2().getY();
            Double loc2Z = arena.getLoc2().getZ();
            String worldName = arena.getWorldName().getName();
            int maxPlayers = arena.getMaxPlayers();
            arenaConfig.set("arenas." + name + ".name", name);
            arenaConfig.set("arenas." + name + ".loc1.x", loc1X);
            arenaConfig.set("arenas." + name + ".loc1.y", loc1Y);
            arenaConfig.set("arenas." + name + ".loc1.z", loc1Z);
            arenaConfig.set("arenas." + name + ".loc2.x", loc2X);
            arenaConfig.set("arenas." + name + ".loc2.y", loc2Y);
            arenaConfig.set("arenas." + name + ".loc2.z", loc2Z);
            arenaConfig.set("arenas." + name + ".worldName", worldName);
            arenaConfig.set("arenas." + name + ".maxPlayers", maxPlayers);
        }
        try {
            arenaConfig.save(arenaConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createArenaConfig() {
        arenaConfigFile = new File(getDataFolder(), "arenas.yml");
        if (!arenaConfigFile.exists()) {
            arenaConfigFile.getParentFile().mkdirs();
            saveResource("arenas.yml", false);
         }

        arenaConfig = new YamlConfiguration();
        try {
            arenaConfig.load(arenaConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public ArenaManager getArenaManager() {
        return arenaManager;
    }
    public FileConfiguration getArenaConfig() {
        return this.arenaConfig;
    }
    public Location getSpawn() {
        return spawn;
    }
    public void addDefaultFighters(){
        Fighters mario = new Fighters("mario", 1, 2, 1, 2, new ArrayList<>());
        Fighters luigi = new Fighters("luigi", 1, 2, 1, 2, new ArrayList<>());



    }
}
