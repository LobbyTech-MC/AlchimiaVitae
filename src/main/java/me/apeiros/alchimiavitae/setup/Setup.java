package me.apeiros.alchimiavitae.setup;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import me.apeiros.alchimiavitae.AlchimiaUtils;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.listeners.DyeListener;
import me.apeiros.alchimiavitae.listeners.infusion.FishingRodListener;
import me.apeiros.alchimiavitae.listeners.infusion.HoeListener;
import me.apeiros.alchimiavitae.listeners.infusion.MeleeWeaponListener;
import me.apeiros.alchimiavitae.listeners.infusion.RangedWeaponListener;
import me.apeiros.alchimiavitae.listeners.infusion.TotemListener;
import me.apeiros.alchimiavitae.setup.items.crafters.AltarOfInfusion;
import me.apeiros.alchimiavitae.setup.items.crafters.CosmicCauldron;
import me.apeiros.alchimiavitae.setup.items.crafters.DivineAltar;
import me.apeiros.alchimiavitae.setup.items.electric.EXPCrystallizer;
import me.apeiros.alchimiavitae.setup.items.electric.PlantInfusionChamber;
import me.apeiros.alchimiavitae.setup.items.general.MoltenMysteryMetal;
import me.apeiros.alchimiavitae.setup.items.general.SoulCollector;
import me.apeiros.alchimiavitae.setup.items.potions.BenevolentBrew;
import me.apeiros.alchimiavitae.setup.items.potions.MalevolentConcoction;
import me.apeiros.alchimiavitae.setup.items.potions.PotionOfOsmosis;

/**
 * Sets up items, {@link Listener}s, and {@link Research}es
 */
public class Setup {

    // {{{ Main
    public static void setup(AlchimiaVitae instance) {
        // Register main item group
        AlchimiaUtils.ItemGroups.MAIN.register(instance);

        // Items
        setupItems(instance);

        // Listeners
        setupListeners(instance);

        // Researches
        setupResearches(instance);
    }
    // }}}
    public static void setupResearches(AlchimiaVitae p) {
        new Research(new NamespacedKey(p, "soul"), 131072,
                "破坏轮回", 25)
                .addItems(Items.CONDENSED_SOUL, Items.SOUL_COLLECTOR)
                .register();

        new Research(new NamespacedKey(p, "magic_plants"), 131073,
                "两极对立", 30)
                .addItems(Items.PLANT_INFUSION_CHAMBER, Items.GOOD_MAGIC_PLANT, Items.EVIL_MAGIC_PLANT)
                .register();

        new Research(new NamespacedKey(p, "magic_essence"), 131074,
                "需要打磨", 10)
                .addItems(Items.GOOD_ESSENCE, Items.EVIL_ESSENCE)
                .register();

        new Research(new NamespacedKey(p, "exp_crystals"), 131075,
                "晶化经验", 21)
                .addItems(Items.EXP_CRYSTALLIZER, Items.EXP_CRYSTAL)
                .register();

        new Research(new NamespacedKey(p, "magic_steel"), 131076,
                "神秘金属", 16)
                .addItems(Items.DARKSTEEL, Items.ILLUMIUM)
                .register();

        new Research(new NamespacedKey(p, "divine_altar"), 131077,
                "古代祭坛的远房亲戚", 45)
                .addItems(Items.DIVINE_ALTAR)
                .register();

        new Research(new NamespacedKey(p, "metal_amalgamation"), 131078,
                "金属物质的混合", 19)
                .addItems(Items.MOLTEN_MYSTERY_METAL, Items.MYSTERY_METAL)
                .register();

        new Research(new NamespacedKey(p, "ornate_cauldron"), 131079,
                "酿造高级药水的装置", 35)
                .addItems(Items.ORNATE_CAULDRON)
                .register();

        new Research(new NamespacedKey(p, "potion_of_osmosis"), 131080,
                "吸收与反射", 30)
                .addItems(Items.POTION_OF_OSMOSIS)
                .register();

        new Research(new NamespacedKey(p, "benevolent_brew"), 131081,
                "来自盖亚的祝福", 35)
                .addItems(Items.BENEVOLENT_BREW)
                .register();

        new Research(new NamespacedKey(p, "malevolent_concoction"), 131082,
                "带有轻微腐蚀的物质", 35)
                .addItems(Items.MALEVOLENT_CONCOCTION)
                .register();

        new Research(new NamespacedKey(p, "altar_of_infusion"), 131083,
                "终极祭坛", 30)
                .addItems(Items.ALTAR_OF_INFUSION)
                .register();
    }
    // }}}

}
