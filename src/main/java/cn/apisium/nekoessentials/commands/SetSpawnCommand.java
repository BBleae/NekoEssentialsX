package cn.apisium.nekoessentials.commands;

import cn.apisium.nekoessentials.Main;
import cn.apisium.nekoessentials.utils.DatabaseSingleton;
import cn.apisium.nekoessentials.utils.Serializer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandName("setspawn")
public final class SetSpawnCommand extends BasicCommand {
    public SetSpawnCommand(Main main) {
        super(main);
    }

    @Override
    public boolean callback(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return false;
        final Player p = (Player) sender;
        DatabaseSingleton.INSTANCE.set("spawn", Serializer.serializeLocation(p.getLocation()));
        p.sendMessage("§a成功设置出生点!");
        return true;
    }
}
