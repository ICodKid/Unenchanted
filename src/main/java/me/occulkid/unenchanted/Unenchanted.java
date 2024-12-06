package me.occulkid.unenchanted;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;

public final class Unenchanted extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register the event listener
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Unenchanted plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Unenchanted plugin has been disabled!");
    }

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        // Get the items in the anvil slots
        ItemStack firstItem = event.getInventory().getItem(0);
        ItemStack secondItem = event.getInventory().getItem(1);

        // Check if the first item is an Elytra
        if (firstItem != null && firstItem.getType() == Material.ELYTRA) {
            // Prevent any combination involving the Elytra
            if (secondItem != null) {
                event.setResult(null); // Block the combination
                event.getView().getPlayer().sendMessage("Enchanting Elytra is completely disabled on this server.");
            }
        }
    }
}
