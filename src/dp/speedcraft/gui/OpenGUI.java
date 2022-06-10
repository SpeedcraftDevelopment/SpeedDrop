package dp.speedcraft.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenGUI {

    public static void OpenGUI(Player p) {
        Inventory i = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Drop");

        ItemStack iron = Iron.iron(p);
        ItemStack gold = Gold.gold(p);
        ItemStack coal = Coal.coal(p);
        ItemStack redstone = Redstone.redstone(p);

        i.setItem(10, iron);
        i.setItem(11, gold);
        i.setItem(12, coal);
        i.setItem(13, redstone);

        p.openInventory(i);
    }
}
