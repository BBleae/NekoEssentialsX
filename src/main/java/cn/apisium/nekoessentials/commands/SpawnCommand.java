package cn.apisium.nekoessentials.commands;

import cn.apisium.nekoessentials.Main;
import cn.apisium.nekoessentials.utils.DatabaseSingleton;
import cn.apisium.nekoessentials.utils.Serializer;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandName("spawn")
public final class SpawnCommand extends TeleportCommand {
    @SuppressWarnings("ConstantConditions")
    private final Location spawn = instance.getServer().getWorld("world").getSpawnLocation();

    public SpawnCommand(Main main) {
        super(main);
    }

    @Override
    public void doTeleport(CommandSender sender, Player p, boolean now) {
        byte[] bytes = DatabaseSingleton.INSTANCE.get("spawn");
        if (bytes != null) {
            instance.delayTeleport(p, Serializer.deserializeLocation(bytes), now);
        } else {
            instance.delayTeleport(p, spawn, now);
        }
    }
}
