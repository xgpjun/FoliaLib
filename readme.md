# FoliaLib

简单统一bukkit与folia中调度程序写法。

**仅供参考**

使用下方示例来获得API实例，需传入你的插件实例。

```java
FoliaLibAPI api = new FoliaLibAPI(plugin);
```



获得调度管理器

```
 /**
     * 传送实体
     * @param entity 需要传送的实体
     * @param target 目的地
     * @return 传送结果
     */
    public boolean teleport(Entity entity, Location target)
    
 

    /**
     * 传送实体
     * @param entity 需要传送的实体
     * @param target 传送目的地
     * @param cause 传送原因
     * @return 传送结果
     */
    public boolean teleport(Entity entity, Location target, PlayerTeleportEvent.TeleportCause cause)
 

    /**
     * 获得调度程序管理器, 参数仅影在Folia中的实现, 无参代表getAsyncScheduler()。
     * @return 调度管理器
     */
    public Scheduler getScheduler()

    /**
     * 获得调度程序管理器, 参数仅影在Folia中的实现, 此处获得实体调度器.
     * @param entity 操作的实体
     * @param retired 回调函数. 当执行时实体变为null时执行的方法。
     * @return 调度管理器
     */
    public Scheduler getScheduler(Entity entity,Runnable retired)

    /**
     *获得调度程序管理器, 参数仅影在Folia中的实现, 此处获得区块调度器.
     * @param location 区域的位置
     * @return 调度管理器
     */
    public Scheduler getScheduler(Location location)

    /**
     * 获得调度程序管理器, 参数仅影在Folia中的实现, 此处获得全局调度器.
     * @param isGlobal 是否为全局， 如为false则等同无参。
     * @return 调度管理器
     */
    public Scheduler getScheduler(boolean isGlobal)
```



调度写法与Bukkit类似

```
		Task runTask(@NotNull Runnable runnable);

    Task runTaskLater(@NotNull Runnable runnable, long delay);

    Task runTaskTimer(@NotNull Runnable runnable, long delay, long period);

    Task runTaskAsynchronously(@NotNull Runnable runnable);

    Task runTaskLaterAsynchronously(@NotNull Runnable runnable, long delay);

    Task runTaskTimerAsynchronously(@NotNull Runnable runnable, long delay, long period);
```



返回Task为调度程序实例

```
		Plugin getOwningPlugin();
    void cancel();
    boolean isCancelled();
    boolean isTimerTask();
    boolean isAsyncTask();
```

