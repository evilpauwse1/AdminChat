package net.buildtheearth.minigames.adminchat;
import net.md_5.bungee.api.plugin.Plugin;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class AdminChat extends Plugin {
    @Override
    public void onEnable() {
        getLogger().info("Admin Chat Loaded Successfully!");
        getProxy().getPluginManager().registerCommand(this, new acView());
        getProxy().getPluginManager().registerCommand(this, new acToggle());
        getProxy().getPluginManager().registerCommand(this, new acChat());
        getProxy().getPluginManager().registerListener(this, new Events());
    }
    public static List<UUID> adminChatViewers = new ArrayList<>();
    public static List<UUID> adminChatChatters = new ArrayList<>();
}
