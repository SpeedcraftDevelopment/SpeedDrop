package dp.speedcraft.cmds;

import dp.speedcraft.gui.OpenGUI;
import dp.speedcraft.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DropCMD implements CommandExecutor {

    Main plugin;

    public DropCMD(Main m) {
        plugin = m;
        m.getCommand("drop").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        Player p = (Player) sender;

        OpenGUI.OpenGUI(p);
        return false;
    }
}
