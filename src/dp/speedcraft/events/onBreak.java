package dp.speedcraft.events;

import dp.speedcraft.main.Main;

import dp.speedcraft.system.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class onBreak implements Listener {

    Main plugin;

    public onBreak(Main m) {
        plugin = m;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        Block b = e.getBlock();

        ItemStack coal = new ItemStack(Material.COAL);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemStack redstone = new ItemStack(Material.REDSTONE);

        if (b.getType() == Material.STONE) {
            int rand = Random.getRandom();

            if (rand <= 4) { //40%
                if (plugin.getConfig().getString(uuid + ".coal") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), coal);
                }
            } else if (rand > 4 && rand <= 7) { //30%
                if (plugin.getConfig().getString(uuid + ".iron") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), iron);
                }
            } else if (rand > 7 && rand <= 9) { //20%
                if (plugin.getConfig().getString(uuid + ".gold") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), gold);
                }
            } else if (rand == 10) { //10%
                if (plugin.getConfig().getString(uuid + ".redstone") == "true") {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), redstone);
                }
            }
        }
    }
}
