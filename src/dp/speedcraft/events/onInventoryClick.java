package dp.speedcraft.events;

import dp.speedcraft.gui.OpenGUI;
import dp.speedcraft.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class onInventoryClick {

    public class onInventoryClick implements Listener {

        Main plugin;

        public onInventoryClick(Main m) {
            plugin = m;
        }

        @EventHandler
        public void onInventoryClick(InventoryClickEvent e) {
            if(!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Drop"))
                return;
            Player p = (Player) e.getWhoClicked();
            UUID uuid = p.getUniqueId();

            e.setCancelled(true);

            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;
            }
            switch(e.getCurrentItem().getType()) {
            case COAL:
                if(plugin.getConfig().getString(uuid + ".coal") == "true") {
                    plugin.getConfig().set(uuid + ".coal", "false");
                    plugin.saveConfig();
                } else {
                    plugin.getConfig().set(uuid + ".coal", "true");
                }
                p.closeInventory();
                OpenGUI.OpenGUI(p);
                break;
            case IRON_INGOT:
                if(plugin.getConfig().getString(uuid + ".iron") == "true") {
                    plugin.getConfig().set(uuid + ".iron", "false");
                    plugin.saveConfig();
                } else {
                    plugin.getConfig().set(uuid + ".iron", "true");
                }
                p.closeInventory();
                OpenGUI.OpenGUI(p);
                break;
            case GOLD_INGOT:
                if(plugin.getConfig().getString(uuid + ".gold") == "true") {
                    plugin.getConfig().set(uuid + ".gold", "false");
                    plugin.saveConfig();
                } else {
                    plugin.getConfig().set(uuid + ".gold", "true");
                }
                p.closeInventory();
                OpenGUI.OpenGUI(p);
                break;
            case REDSTONE:
                if(plugin.getConfig().getString(uuid + ".redstone") == "true") {
                    plugin.getConfig().set(uuid + ".redstone", "false");
                    plugin.saveConfig();
                } else {
                    plugin.getConfig().set(uuid + ".redstone", "true");
                }
                p.closeInventory();
                OpenGUI.OpenGUI(p);
                break;
            default:
                p.closeInventory();
                break;
            }
        }

    }
}
