package me.apeiros.alchimiavitae.setup.items.potions;

import java.util.Collection;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;

import me.apeiros.alchimiavitae.AlchimiaUtils;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.setup.AlchimiaItems;
import me.apeiros.alchimiavitae.setup.items.crafters.CosmicCauldron;

public class PotionOfOsmosis extends AbstractListenerPotion {

    public PotionOfOsmosis(ItemGroup ig, CosmicCauldron cauldron) {
        super(ig, AlchimiaItems.POTION_OF_OSMOSIS, AlchimiaUtils.RecipeTypes.COSMIC_CAULDRON, new ItemStack[] {
                AlchimiaItems.EXP_CRYSTAL, new ItemStack(Material.NETHERITE_SCRAP), AlchimiaItems.EXP_CRYSTAL,
                AlchimiaItems.DARK_ESSENCE, new ItemStack(Material.HONEY_BOTTLE), AlchimiaItems.LIGHT_ESSENCE,
                AlchimiaItems.DARKSTEEL, new ItemStack(Material.DRAGON_BREATH), AlchimiaItems.ILLUMIUM
        }, cauldron);
    }

    // {{{ Handle potion drink
    @EventHandler(ignoreCancelled = true)
    public void onDrink(PlayerItemConsumeEvent e) {
        ItemStack potion = e.getItem();

            // If player has no effects
            if (p.getActivePotionEffects().isEmpty()) {
                p.sendMessage(Utils.legacySerialize("<red>你身上没有任何药水效果!"));
                return;
            }

            // Collection of player's effects
            Collection<PotionEffect> playerEffectsList = p.getActivePotionEffects();

            // Remove the player's current potion effects
            for (PotionEffect eff : playerEffectsList) {
                p.removePotionEffect(eff.getType());
            }

            // Make a new potion
            ItemStack newPotion = Utils.makePotion(
                "AV_CORUSCATING_POTION_POTION",
                Utils.legacySerialize("<gradient:#6fe3e1:#53e6a6>闪烁的药水</gradient>"),
                Color.FUCHSIA,
                playerEffectsList
            );
            PotionMeta meta = (PotionMeta) newPotion.getItemMeta();

            // Make a lore
            List<String> lore = new ArrayList<>();
            lore.add(Utils.legacySerialize("<green>由<gradient:#6274e7:#8752a3>渗透药水</gradient><green>制成"));

            // Set the lore
            meta.setLore(lore);

            // Set item meta
            newPotion.setItemMeta(meta);

            // Remove potion of osmosis
            p.getInventory().removeItem(potion);
            
            // Effects
            // Layer 0
            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_BREWING_STAND_BREW, 1, 1);

            // Layer 1
            Bukkit.getScheduler().runTaskLater(AlchimiaVitae.i(), () -> {
                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1, 1);

                // Layer 2
                Bukkit.getScheduler().runTaskLater(AlchimiaVitae.i(), () -> {
                    p.getWorld().playSound(p.getLocation(), Sound.ITEM_BOTTLE_FILL_DRAGONBREATH, 1, 1);
                    p.getWorld().playSound(p.getLocation(), Sound.ITEM_BOTTLE_FILL, 1, 1);
                    p.getWorld().playSound(p.getLocation(), Sound.ITEM_TOTEM_USE, 0.6F, 1);
                    p.getWorld().spawnParticle(Particle.END_ROD, p.getLocation(), 60, 1, 1, 1);

                    // Message
                    p.sendMessage(Utils.legacySerialize("<green>已将你身上的药水效果制作成药水瓶!"));

                    // Add new potion
                    p.getInventory().addItem(newPotion);
                }, 30);
            }, 30);
        };
    }
    // }}}

}
