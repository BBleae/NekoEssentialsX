package cn.apisium.nekoessentials.commands;

import cn.apisium.nekoessentials.*;
import cn.apisium.nekoessentials.utils.DatabaseSingleton;
import cn.apisium.nekoessentials.utils.Serializer;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandName("top")
public final class TopCommand extends TeleportCommand {
    public TopCommand(Main main) {
        super(main);
    }

    @Override
    public void doTeleport(CommandSender sender, Player p, boolean now) {
        final Location loc = p.getLocation();
        loc.setY(loc.getWorld().getHighestBlockYAt(loc));
        instance.delayTeleport(p, loc, now);
    }
}
