package org.discordpvp;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

public class KitchenSink extends JavaPlugin implements Listener{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("removePotion")) {
	        if (!(sender instanceof Player)) {
	            sender.sendMessage("Only players can use this command!");
	            return true;
	        }
	        // After checking to make sure that the sender is a Player, we can safely case it to one.
	        Player s = (Player) sender;

	        System.out.println("POTION EFFECTS Before" + s.getActivePotionEffects());
	        for (PotionEffect effect : s.getActivePotionEffects())
	            s.removePotionEffect(effect.getType());
	        System.out.println("POTION EFFECTS AFTER" + s.getActivePotionEffects());

//	        for (EntityDamageEvent.DamageCause c : EntityDamageEvent.DamageCause.values())
//	        	 s.remove
//	         s.getInventory().addItem(new ItemStack(Material.MILK_BUCKET, 1));

	        return true;
	    }
	    return false;
	}
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome, " + event.getPlayer().getDisplayName() + "!");
    }

}
