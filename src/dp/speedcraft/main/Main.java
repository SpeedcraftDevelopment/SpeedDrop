package dp.speedcraft.main;

import dp.speedcraft.cmds.DropCMD;
import dp.speedcraft.events.onBreak;
import dp.speedcraft.events.onInventoryClick;
import dp.speedcraft.events.onJoin;
import dp.speedcraft.gui.Coal;
import dp.speedcraft.gui.Gold;
import dp.speedcraft.gui.Iron;
import dp.speedcraft.gui.Redstone;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main main;

    public void onEnable() {
        getLogger().info("Enabling Speedcraft Drop plugin...");

        getConfig().options().copyDefaults(true);
        saveConfig();

        main = this;

        new onBreak(this);
        new onJoin(this);
        new onInventoryClick(this);

        new Coal(this);
        new Iron(this);
        new Gold(this);
        new Redstone(this);
        new DropCMD(this);

        getServer().getPluginManager().registerEvents(new onBreak(this), this);
        getServer().getPluginManager().registerEvents(new onJoin(this), this);
        getServer().getPluginManager().registerEvents(new onInventoryClick(this), this);
    }

    public static Main getMain() {
        return main;
    }
}
