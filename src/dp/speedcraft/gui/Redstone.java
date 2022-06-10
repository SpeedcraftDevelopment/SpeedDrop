package dp.speedcraft.gui;

import dp.speedcraft.main.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class Redstone {

    static Main plugin;

    public Redstone(Main m) {
        plugin = m;
    }

    public static ItemStack redstone(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack redstone = new ItemStack(Material.COAL);
        ItemMeta redstoneM = redstone.getItemMeta();

        redstoneM.setDisplayName(ChatColor.LIGHT_PURPLE + "Coal");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().get(uuid + ".redstone") == "true"){
            lore.add(ChatColor.WHITE + "Active " + ChatColor.GREEN + "Yes");
        } else {
            lore.add(ChatColor.WHITE + "Active " + ChatColor.RED + "No");
        }

        lore.add(" ");

        redstoneM.setLore(lore);
        redstone.setItemMeta(redstoneM);

        return redstone;
    }
}
}
