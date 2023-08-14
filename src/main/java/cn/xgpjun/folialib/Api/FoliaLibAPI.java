package cn.xgpjun.folialib.Api;

import cn.xgpjun.folialib.Enum.ServerType;
import cn.xgpjun.folialib.Wrapper.Scheduler;
import cn.xgpjun.folialib.Wrapper.SchedulerWrapper.BukkitScheduler;
import cn.xgpjun.folialib.Wrapper.SchedulerWrapper.FoliaScheduler;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;


public class FoliaLibAPI {
    private final Plugin plugin;
    private final ServerType serverType;
    public FoliaLibAPI(Plugin plugin){
        serverType = ServerType.getServerType();
        this.plugin = plugin;
    }
    public boolean teleport(Entity entity, Location target){
        return teleport(entity,target, PlayerTeleportEvent.TeleportCause.PLUGIN);
    }
    public boolean teleport(Entity entity, Location target, PlayerTeleportEvent.TeleportCause cause){
        if (Objects.requireNonNull(serverType) == ServerType.FOLIA) {
            return entity.teleportAsync(target,cause).isDone();
        }
        return entity.teleport(target,cause);
    }

    public Scheduler getScheduler(){
        if (Objects.requireNonNull(serverType) == ServerType.FOLIA) {
            return new FoliaScheduler(plugin,false);
        }
        return new BukkitScheduler(plugin);
    }
    public Scheduler getScheduler(Entity entity,Runnable retired){
        if (Objects.requireNonNull(serverType) == ServerType.FOLIA) {
            return new FoliaScheduler(plugin,entity,retired);
        }
        return new BukkitScheduler(plugin);
    }
    public Scheduler getScheduler(Location location){
        if (Objects.requireNonNull(serverType) == ServerType.FOLIA) {
            return new FoliaScheduler(plugin,location);
        }
        return new BukkitScheduler(plugin);
    }

    public Scheduler getScheduler(boolean isGlobal){
        if (Objects.requireNonNull(serverType) == ServerType.FOLIA) {
            return new FoliaScheduler(plugin,isGlobal);
        }
        return new BukkitScheduler(plugin);
    }
}
