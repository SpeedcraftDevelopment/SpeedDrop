package dp.speedcraft.gui;

import dp.speedcraft.main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.UUID;

public class Iron {

    static Main plugin;

    public Iron(Main m) {
        plugin = m;
    }

    public static ItemStack iron(Player p) {
        UUID uuid = p.getUniqueId();

        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta ironM = iron.getItemMeta();

        ironM.setDisplayName(ChatColor.DARK_GRAY + "Iron Ingot");
        ArrayList<String> lore = new ArrayList<String>();

        lore.add(" ");
        if(plugin.getConfig().get(uuid + ".iron") == "true"){
            lore.add(ChatColor.WHITE + "Active " + ChatColor.GREEN + "Yes");
        } else {
            lore.add(ChatColor.WHITE + "Active " + ChatColor.RED + "No");
        }

        lore.add(" ");

        ironM.setLore(lore);
        iron.setItemMeta(ironM);

        return iron;
    }
}
