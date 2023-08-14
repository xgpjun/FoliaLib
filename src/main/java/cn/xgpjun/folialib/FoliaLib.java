package cn.xgpjun.folialib;

import cn.xgpjun.folialib.Enum.ServerType;
import org.bukkit.plugin.java.JavaPlugin;

public final class FoliaLib extends JavaPlugin {

    public static ServerType serverType;

    @Override
    public void onEnable() {
        // Plugin startup logic
        serverType = ServerType.getServerType();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
