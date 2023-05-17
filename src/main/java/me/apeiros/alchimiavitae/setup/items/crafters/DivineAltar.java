package me.apeiros.alchimiavitae.setup.items.crafters;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

import me.apeiros.alchimiavitae.AlchimiaUtils;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.setup.AlchimiaItems;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

/**
 * Divine Altar
 */
public class DivineAltar extends AbstractCrafter<SlimefunItemStack> {

    public DivineAltar(ItemGroup ig) {
        super(ig, AlchimiaItems.DIVINE_ALTAR, RecipeType.ANCIENT_ALTAR, new ItemStack[] {
                AlchimiaItems.EXP_CRYSTAL, SlimefunItems.ELECTRO_MAGNET, AlchimiaItems.EXP_CRYSTAL,
                SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.ANCIENT_ALTAR, SlimefunItems.BLISTERING_INGOT_3,
                SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.HEATED_PRESSURE_CHAMBER, SlimefunItems.ANCIENT_PEDESTAL
        });
    }

    // {{{ Set up effects
    @Override
    protected void newInstanceEffects(World w, Location l) {
        // Play effects
        w.spawnParticle(Particle.REVERSE_PORTAL, l, 100, 0.5, 0.5, 0.5);
        w.playSound(l, Sound.BLOCK_BEACON_ACTIVATE, 1F, 1F);
    }
    // }}}

    // {{{ Default recipes
    @Override
    protected void addDefaultRecipes() {
        // {{{ Prepare
        // Get plugin instance and config
        AlchimiaVitae instance = AlchimiaVitae.i();
        Configuration cfg = instance.getConfig();

        // Get config values
        boolean reinforcedTransmutation       = cfg.getBoolean("options.transmutations.reinforced-transmutation");
        boolean hardenedTransmutation         = cfg.getBoolean("options.transmutations.hardened-transmutation");
        boolean steelTransmutation            = cfg.getBoolean("options.transmutations.steel-transmutation");
        boolean damascusTransmutation         = cfg.getBoolean("options.transmutations.damascus-transmutation");
        boolean compressedCarbonTransmutation = cfg.getBoolean("options.transmutations.compressed-carbon-transmutation");

        // Get ItemGroup and RecipeType
        ItemGroup ig = AlchimiaUtils.ItemGroups.ALTAR_RECIPES;
        RecipeType rt = AlchimiaUtils.RecipeTypes.DIVINE_ALTAR;
        // }}}

        // {{{ Reinforced Alloy Ingot
        if (reinforcedTransmutation) {
            this.newRecipe(ig, rt,
                // Out
                new SlimefunItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 2),

            item = new SlimefunItemStack("AV_REINFORCED_ALLOY_INGOT", Material.IRON_INGOT, "&b&l强化合金锭");

            if (useSlimefunItemCustomModelData) {
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(cts.getModelData("REINFORCED_ALLOY_INGOT"));
                item.setItemMeta(meta);
                cts.setTexture(item, "AV_REINFORCED_ALLOY_INGOT");
            }

            new SlimefunItem(Utils.ItemGroups.ALTAR_RECIPES, item, Utils.RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, SlimefunItems.DAMASCUS_STEEL_INGOT, null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.DAMASCUS_STEEL_INGOT, null
            }, new SlimefunItemStack(item, 2)).register(av);
        }
        // }}}

        // {{{ Hardened Metal
        if (hardenedTransmutation) {
            this.newRecipe(ig, rt,
                new SlimefunItemStack(SlimefunItems.HARDENED_METAL_INGOT, 2),

            item = new SlimefunItemStack("AV_HARDENED_METAL_INGOT", Material.IRON_INGOT, "&b&l硬化金属");

            if (useSlimefunItemCustomModelData) {
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(cts.getModelData("HARDENED_METAL_INGOT"));
                item.setItemMeta(meta);
                cts.setTexture(item, "AV_HARDENED_METAL_INGOT");
            }

            new SlimefunItem(Utils.ItemGroups.ALTAR_RECIPES, item, Utils.RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, SlimefunItems.STEEL_INGOT, null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.STEEL_INGOT, null
            }, new SlimefunItemStack(item, 2)).register(av);
        }
        // }}}

        // {{{ Steel Ingot
        if (steelTransmutation) {
            this.newRecipe(ig, rt,
                new SlimefunItemStack(SlimefunItems.STEEL_INGOT, 8),

            item = new SlimefunItemStack("AV_STEEL_INGOT", Material.IRON_INGOT, "&b钢锭");

            if (useSlimefunItemCustomModelData) {
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(cts.getModelData("STEEL_INGOT"));
                item.setItemMeta(meta);
                cts.setTexture(item, "AV_STEEL_INGOT");
            }

            new SlimefunItem(Utils.ItemGroups.ALTAR_RECIPES, item, Utils.RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, new ItemStack(Material.IRON_BLOCK), null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.CARBON, null
            }, new SlimefunItemStack(item, 8)).register(av);
        }
        // }}}

        // {{{ Damascus Steel Ingot
        if (damascusTransmutation) {
            this.newRecipe(ig, rt,
                new SlimefunItemStack(SlimefunItems.DAMASCUS_STEEL_INGOT, 8),

            item = new SlimefunItemStack("AV_DAMASCUS_STEEL_INGOT", Material.IRON_INGOT, "&b大马士革钢锭");

            if (useSlimefunItemCustomModelData) {
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(cts.getModelData("DAMASCUS_STEEL_INGOT"));
                item.setItemMeta(meta);
                cts.setTexture(item, "AV_DAMASCUS_STEEL_INGOT");
            }

            new SlimefunItem(Utils.ItemGroups.ALTAR_RECIPES, item, Utils.RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, new ItemStack(Material.IRON_BLOCK), null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.COMPRESSED_CARBON, null
            }, new SlimefunItemStack(item, 8)).register(av);
        }
        // }}}

        // {{{ Compressed Carbon
        if (compressedCarbonTransmutation) {
            this.newRecipe(ig, rt,
                SlimefunItems.COMPRESSED_CARBON,

            item = new SlimefunItemStack("AV_COMPRESSED_CARBON", HeadTexture.COMPRESSED_CARBON, "&c压缩碳");

            if (useSlimefunItemCustomModelData) {
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(cts.getModelData("COMPRESSED_CARBON"));
                item.setItemMeta(meta);
                cts.setTexture(item, "AV_COMPRESSED_CARBON");
            }

            new SlimefunItem(Utils.ItemGroups.ALTAR_RECIPES, item, Utils.RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.COAL),
                    new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.KELP),
                    new ItemStack(Material.COAL), new ItemStack(Material.ROTTEN_FLESH), new ItemStack(Material.COAL)
            }, item).register(av);
        }
        // }}}
    }
    // }}}

    // {{{ Finish crafting
    @Override
    protected void finish(World w, Location l, BlockMenu menu, SlimefunItemStack item) {
        // Schedule task
        new BukkitRunnable() {
            private int layer = 4;

            @Override
            public void run() {
                if (layer == 4) {
                    // Pre-craft
                    w.playSound(l, Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 1, 1);
                    w.playSound(l, Sound.ITEM_LODESTONE_COMPASS_LOCK, 1.5F, 1);

                    // Decrease layer
                    layer--;
                } else if (layer > 0) {
                    // Pre-craft
                    w.playSound(l, Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
                    w.playSound(l, Sound.ITEM_LODESTONE_COMPASS_LOCK, 1.5F, 1);
                    w.spawnParticle(Particle.FLASH, l, 2, 0.1, 0.1, 0.1);

                    // Decrease layer
                    layer--;
                } else {
                    // Output the item
                    ItemStack newItem = item.clone();

                    if (menu.fits(newItem, OUT_SLOTS)) {
                        menu.pushItem(newItem, OUT_SLOTS);
                    } else {
                        // Drop if it doesn't fit
                        w.dropItemNaturally(l.add(0, 0.5, 0), newItem);
                    }

                    // Post-craft
                    w.strikeLightningEffect(l.add(0, 0.5, 0));
                    w.playSound(l, Sound.ITEM_TRIDENT_THUNDER, 1, 1);
                    w.playSound(l, Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
                    w.spawnParticle(Particle.FLASH, l, 5, 0.1, 0.1, 0.1);
                    w.spawnParticle(Particle.REVERSE_PORTAL, l, 300, 2, 2, 2);

        // Sound effect
        b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.BLOCK_BEACON_ACTIVATE, 1F, 1F);

        // Craft button click handler
        for (int slot : CRAFT_BUTTON) {
            menu.addMenuClickHandler(slot, (player, i, itemStack, clickAction) -> {
                // Craft item
                craft(b, menu, player);
                return false;
            });
        }
    }

    @Override
    protected void onBreak(BlockBreakEvent e, BlockMenu menu) {
        Location l = menu.getLocation();
        menu.dropItems(l, IN_SLOTS);
        e.getBlock().getWorld().playSound(e.getBlock().getLocation().add(0.5, 0.5, 0.5), Sound.BLOCK_BEACON_DEACTIVATE, 1F, 1F);
    }

    @Override
    protected void craft(@NotNull Block b, @NotNull BlockMenu inv, @NotNull Player p) {
        // Get expected output
        ItemStack[] input = new ItemStack[9];

        int index = 0;
        for (int i : IN_SLOTS) {
            input[index] = inv.getItemInSlot(i);
            index++;
        }

        CraftingBlockRecipe output = this.getOutput(input);
        ItemStack item = null;

        if (output != null) {
            item = output.output();
        }

        // Invalid recipe
        if (item == null) {
            p.sendMessage(Utils.legacySerialize("<red>无效的配方!"));
            p.sendMessage(Utils.legacySerialize("<red>请重试."));
            return;
        }

        // Check for space
        if (!inv.fits(item, OUT_SLOTS)) {
            p.sendMessage(Utils.legacySerialize("<red>输出空间不足!"));
            return;
        }

        // Consume items
        for (int slot : IN_SLOTS) {
            if (inv.getItemInSlot(slot) != null) {
                inv.consumeItem(slot, 1);
            }
        }

        // Pre-craft effects
        ItemStack finalItem = item;
        Bukkit.getScheduler().runTaskLater(AlchimiaVitae.i(), () -> {
            b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
            b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ITEM_LODESTONE_COMPASS_LOCK, 1.5F, 1);
            b.getWorld().spawnParticle(Particle.FLASH, b.getLocation().add(0.5, 0.5, 0.5), 2, 0.1, 0.1, 0.1);

            Bukkit.getScheduler().runTaskLater(AlchimiaVitae.i(), () -> {
                b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
                b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ITEM_LODESTONE_COMPASS_LOCK, 1.5F, 1);
                b.getWorld().spawnParticle(Particle.FLASH, b.getLocation().add(0.5, 0.5, 0.5), 2, 0.1, 0.1, 0.1);

                Bukkit.getScheduler().runTaskLater(AlchimiaVitae.i(), () -> {
                    b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
                    b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ITEM_LODESTONE_COMPASS_LOCK, 1.5F, 1);
                    b.getWorld().spawnParticle(Particle.FLASH, b.getLocation().add(0.5, 0.5, 0.5), 2, 0.1, 0.1, 0.1);

                    Bukkit.getScheduler().runTaskLater(AlchimiaVitae.i(), () -> {
                        // Post-craft effects
                        b.getWorld().strikeLightningEffect(b.getLocation().add(0.5, 1, 0.5));
                        b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ITEM_TRIDENT_THUNDER, 1, 1);
                        b.getWorld().playSound(b.getLocation().add(0.5, 0.5, 0.5), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
                        b.getWorld().spawnParticle(Particle.FLASH, b.getLocation().add(0.5, 0.5, 0.5), 5, 0.1, 0.1, 0.1);
                        b.getWorld().spawnParticle(Particle.REVERSE_PORTAL, b.getLocation().add(0.5, 0.5, 0.5), 300, 2, 2, 2);

                        // Send message
                        p.sendMessage(Utils.legacySerialize("<gradient:#50fa75:#3dd2ff>成功合成!</gradient>"));

                        // Output the item(s)
                        inv.pushItem(finalItem.clone(), OUT_SLOTS);
                    }, 30);
                }, 30);
            }, 30);
        }, 30);
    }
    // }}}

}
