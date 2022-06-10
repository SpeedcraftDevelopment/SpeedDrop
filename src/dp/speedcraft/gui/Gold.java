package dp.speedcraft.gui;

import dp.speedcraft.main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.UUID;

public class Gold {

    static Main plugin;

    public Gold(Main m) {
        plugin = m;
    }

    public static ItemStack gold(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldM = gold.getItemMeta();

        goldM.setDisplayName(ChatColor.GOLD + "Gold Ingot");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().get(uuid + ".gold") == "true"){
            lore.add(ChatColor.WHITE + "Active " + ChatColor.GREEN + "Yes");
        } else {
            lore.add(ChatColor.WHITE + "Active " + ChatColor.RED + "No");
        }

        lore.add(" ");

        goldM.setLore(lore);
        gold.setItemMeta(goldM);

        return gold;
    }
}