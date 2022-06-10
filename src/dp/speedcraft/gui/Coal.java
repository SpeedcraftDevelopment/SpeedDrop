package dp.speedcraft.gui;

import dp.speedcraft.main.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class Coal {

    static Main plugin;

    public Coal(Main m) {
        plugin = m;
    }

    public static ItemStack coal(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack coal = new ItemStack(Material.COAL);
        ItemMeta coalM = coal.getItemMeta();

        coalM.setDisplayName(ChatColor.DARK_GRAY + "Coal");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().get(uuid + ".coal") == "true"){
            lore.add(ChatColor.WHITE + "Active " + ChatColor.GREEN + "Yes");
        } else {
            lore.add(ChatColor.WHITE + "Active " + ChatColor.RED + "No");
        }

        lore.add(" ");

        coalM.setLore(lore);
        coal.setItemMeta(coalM);

        return coal;
    }
}
