package dp.speedcraft.events;

import dp.speedcraft.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class onJoin implements Listener {

    Main plugin;

    public onJoin(Main m) {
        plugin = m;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(p.hasPlayedBefore()) {
            UUID uuid = p.getUniqueId();


            plugin.getConfig().set(uuid + ".coal", "true");
            plugin.getConfig().set(uuid + ".iron", "true");
            plugin.getConfig().set(uuid + ".gold", "true");
            plugin.getConfig().set(uuid + ".redstone", "true");
            plugin.saveConfig();
        }
    }
}
