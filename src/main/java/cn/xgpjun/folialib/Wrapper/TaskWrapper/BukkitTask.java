package cn.xgpjun.folialib.Wrapper.TaskWrapper;

import cn.xgpjun.folialib.Wrapper.Task;
import org.bukkit.plugin.Plugin;

public class BukkitTask implements Task {
    private final org.bukkit.scheduler.BukkitTask task;
    private final boolean isTimer;
    public BukkitTask(org.bukkit.scheduler.BukkitTask task,boolean isTimer){
        this.task = task;
        this.isTimer = isTimer;
    }

    @Override
    public Plugin getOwningPlugin() {
        return task.getOwner();
    }

    @Override
    public void cancel() {
        task.cancel();
    }

    @Override
    public boolean isCancelled() {
        return task.isCancelled();
    }


    @Override
    public boolean isTimerTask() {
        return isTimer;
    }

    @Override
    public boolean isAsyncTask() {
        return task.isSync();
    }
}
