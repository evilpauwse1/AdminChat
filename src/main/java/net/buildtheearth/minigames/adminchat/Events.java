package net.buildtheearth.minigames.adminchat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.protocol.packet.Chat;

import java.util.UUID;

public class Events implements Listener {
    @EventHandler
    public void onPostLogin(PostLoginEvent e) {
        ProxiedPlayer player = e.getPlayer();
        if(AdminChat.adminChatViewers.contains(player.getUniqueId())) {

            player.sendMessage(new TextComponent(ChatColor.RED + "[AC] " + ChatColor.BLUE + "Admin Chat feed is currently " + ChatColor.BOLD + "enabled."));
        }
        if(AdminChat.adminChatChatters.contains(player.getUniqueId())) {

            player.sendMessage(new TextComponent(ChatColor.RED + "[AC] " + ChatColor.BLUE + "Sending messages to Admin Chat is currently " + ChatColor.BOLD + "enabled."));
        }
    }
    @EventHandler
    public void onChat(ChatEvent e) {
        ProxiedPlayer player = (ProxiedPlayer) e.getSender();
        if(e.isCommand() == true) {
            return;
        }
        if(AdminChat.adminChatChatters.contains(player.getUniqueId())) {
            TextComponent theText = new TextComponent(ChatColor.RED + "[AC] " + ChatColor.BLUE + "[" + ((ProxiedPlayer) e.getSender()).getServer().getInfo().getName()  + "] " + e.getSender() + ": ");
            theText.setColor(ChatColor.DARK_PURPLE);
            theText.addExtra(e.getMessage());
            for (UUID p : AdminChat.adminChatViewers) {
                ProxyServer.getInstance().getPlayer(p).sendMessage(theText);
            }
            e.setCancelled(true);
        }


    }

}