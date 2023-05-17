package me.apeiros.alchimiavitae.setup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.utils.Utils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class Items {

    // GUI items (for custom crafters)

    public static final ItemStack IN_BG = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,
        Utils.legacySerialize("<gradient:#ff68fc:#ff9a5c>输入</gradient>"));

    public static final ItemStack CRAFT_BTN = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
        Utils.legacySerialize("<gradient:#39f792:#5c95ff>合成</gradient>"), "&a点击合成");

    public static final ItemStack CRAFT_BG = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
        Utils.legacySerialize("<gradient:#39f792:#5c95ff>合成</gradient>"));

    public static final ItemStack OUT_BG = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
        Utils.legacySerialize("<gradient:#5cb8ff:#39f7e1>输出</gradient>"));

    // AlchimiaVitae items

    public static final SlimefunItemStack SOUL_COLLECTOR = new SlimefunItemStack(
        "AV_SOUL_COLLECTOR",
        Material.DIAMOND_SWORD,
        Utils.legacySerialize("<gradient:#6baefa:#7145b0>灵魂收割者</gradient>"),
        "&b收集灵魂",
        "&b使用这把剑击杀任何生物",
        "&b将收集该生物的灵魂",
        "&a可获得3倍经验掉落",
        "&9凋灵类生物将掉落",
        "&9更多灵魂",
        "&c无法对玩家造成伤害"
    );

    private static final Configuration cfg = AlchimiaVitae.i().getConfig();

    static {
        ItemMeta meta = SOUL_COLLECTOR.getItemMeta();
        meta.setUnbreakable(true);

        SOUL_COLLECTOR.setItemMeta(meta);
        SOUL_COLLECTOR.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
    }

    public static final SlimefunItemStack CONDENSED_SOUL = new SlimefunItemStack(
        "AV_CONDENSED_SOUL",
        Material.LIGHT_BLUE_DYE,
        Utils.legacySerialize("<gradient:#6baefa:#7145b0>凝魂</gradient>"),
        "&b凝聚成球的灵魂",
        "&9&o也许有方法可以",
        "&9&o操控它的力量..."
    );

    static {
        ItemMeta meta = CONDENSED_SOUL.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        CONDENSED_SOUL.setItemMeta(meta);
        CONDENSED_SOUL.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack PLANT_INFUSION_CHAMBER = new SlimefunItemStack(
        "AV_PLANT_INFUSION_CHAMBER",
        Material.LIME_STAINED_GLASS,
        Utils.legacySerialize("<gradient:#549c64:#1de078>植物注入仓</gradient>"),
        "&b可使用灵魂向植物注入暗能量",
        "&b或使用魔法结晶向植物注入光能量",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerPerSecond(64)
    );

    public static final SlimefunItemStack GOOD_MAGIC_PLANT = new SlimefunItemStack(
        "AV_GOOD_MAGIC_PLANT",
        Material.OAK_SAPLING,
        Utils.legacySerialize("<gradient:#2ddae0:#31f876>光魔法植物</gradient>"),
        "&7光魔法 I",
        "&a发散着至高无上,",
        "&a与众不同的光芒..."
    );

    static {
        ItemMeta meta = GOOD_MAGIC_PLANT.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        GOOD_MAGIC_PLANT.setItemMeta(meta);
        GOOD_MAGIC_PLANT.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack EVIL_MAGIC_PLANT = new SlimefunItemStack(
        "AV_EVIL_MAGIC_PLANT",
        Material.OAK_SAPLING,
        Utils.legacySerialize("<gradient:#ff5555:#ffa012>暗魔法植物</gradient>"),
        "&7暗魔法 I",
        "&c在它的木质中封印了",
        "&c无数的暗魔法..."
    );

    static {
        ItemMeta meta = EVIL_MAGIC_PLANT.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        EVIL_MAGIC_PLANT.setItemMeta(meta);
        EVIL_MAGIC_PLANT.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack GOOD_ESSENCE = new SlimefunItemStack(
        "AV_GOOD_ESSENCE",
        Material.SUGAR,
        Utils.legacySerialize("<gradient:#2ddae0:#31f876>光之精华</gradient>"),
        "&7光魔法 II",
        "&a生命与光明"
    );

    public static final SlimefunItemStack EVIL_ESSENCE = new SlimefunItemStack(
        "AV_EVIL_ESSENCE",
        Material.GUNPOWDER,
        Utils.legacySerialize("<gradient:#ff5555:#ffa012>暗之精华</gradient>"),
        "&7暗魔法 II",
        "&c死亡与黑暗"
    );

    public static final SlimefunItemStack EXP_CRYSTALLIZER = new SlimefunItemStack(
        "AV_EXP_CRYSTALLIZER",
        Material.LIME_STAINED_GLASS,
        Utils.legacySerialize("<gradient:#50fa75:#3dd2ff>经验结晶器</gradient>"),
        "&a将经验球转化为晶体形态",
        "&a耐用且充满活力",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerPerSecond(32)
    );

    public static final SlimefunItemStack EXP_CRYSTAL = new SlimefunItemStack(
        "AV_EXP_CRYSTAL",
        Material.EMERALD,
        Utils.legacySerialize("<gradient:#50fa75:#3dd2ff>经验晶体</gradient>"),
        "&a一块结晶的经验"
    );

    static {
        ItemMeta meta = EXP_CRYSTAL.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        EXP_CRYSTAL.setItemMeta(meta);
        EXP_CRYSTAL.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack ILLUMIUM = new SlimefunItemStack(
        "AV_ILLUMIUM",
        Material.IRON_INGOT,
        Utils.legacySerialize("<gradient:#2ddae0:#31f876>光明锭</gradient>"),
        "&a它在你手中散发着强力的光芒"
    );

    static {
        ItemMeta meta = ILLUMIUM.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ILLUMIUM.setItemMeta(meta);
        ILLUMIUM.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack DARKSTEEL = new SlimefunItemStack(
        "AV_DARKSTEEL",
        Material.NETHERITE_INGOT,
        Utils.legacySerialize("<gradient:#ff5555:#ffa012>暗钢锭</gradient>"),
        "&c它在散发着...无尽的黑暗?"
    );

    static {
        ItemMeta meta = DARKSTEEL.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        DARKSTEEL.setItemMeta(meta);
        DARKSTEEL.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack DIVINE_ALTAR = new SlimefunItemStack(
        "AV_DIVINE_ALTAR",
        Material.ENCHANTING_TABLE,
        Utils.legacySerialize("<gradient:#ff5555:#ff6cfd>神圣祭坛</gradient>"),
        "&5用于进行古代仪式的",
        "&5神圣装置"
    );

    public static final SlimefunItemStack MOLTEN_MYSTERY_METAL = new SlimefunItemStack(
        "AV_MOLTEN_MYSTERY_METAL",
        Material.LAVA_BUCKET,
        Utils.legacySerialize("<gradient:#ff6745:#ff5555>熔融神秘金属</gradient>"),
        "&6不同金属的聚合体"
    );

    public static final SlimefunItemStack MYSTERY_METAL = new SlimefunItemStack(
        "AV_MYSTERY_METAL",
        Material.IRON_INGOT,
        Utils.legacySerialize("<gradient:#ff6745:#ff5555>神秘金属锭</gradient>"),
        "&6包含了许多的金属"
    );

    public static final SlimefunItemStack ORNATE_CAULDRON = new SlimefunItemStack(
        "AV_ORNATE_CAULDRON",
        Material.CAULDRON,
        Utils.legacySerialize("<gradient:#57ebbe:#f6fa2a>华丽炼药锅</gradient>"),
        "&2用于酿造药水的高级炼药锅"
    );

    public static final SlimefunItemStack POTION_OF_OSMOSIS = new SlimefunItemStack(
        "AV_POTION_OF_OSMOSIS",
        Material.DRAGON_BREATH,
        Utils.legacySerialize("<gradient:#6274e7:#8752a3>渗透药水</gradient>"),
        "&e右键点击&6吸收你身上的所有药水效果",
        "&6并将它们储存在药水瓶中"
    );

    private static final Map<PotionEffectType, int[]> potEffectsMap = new HashMap<>();

    static {
        // Add effects
        potEffectsMap.put(PotionEffectType.DAMAGE_RESISTANCE, new int[] {
            cfg.getInt("options.potions.benevolent-brew.resistance.ticks"),
            cfg.getInt("options.potions.benevolent-brew.resistance.level") - 1
        });
        potEffectsMap.put(PotionEffectType.FAST_DIGGING, new int[] {
            cfg.getInt("options.potions.benevolent-brew.haste.ticks"),
            cfg.getInt("options.potions.benevolent-brew.haste.level") - 1
        });
        potEffectsMap.put(PotionEffectType.REGENERATION, new int[] {
            cfg.getInt("options.potions.benevolent-brew.regen.ticks"),
            cfg.getInt("options.potions.benevolent-brew.regen.level") - 1
        });
        potEffectsMap.put(PotionEffectType.SPEED, new int[] {
            cfg.getInt("options.potions.benevolent-brew.speed.ticks"),
            cfg.getInt("options.potions.benevolent-brew.speed.level") - 1
        });
        potEffectsMap.put(PotionEffectType.JUMP, new int[] {
            cfg.getInt("options.potions.benevolent-brew.jump.ticks"),
            cfg.getInt("options.potions.benevolent-brew.jump.level") - 1
        });
    }

    public static final SlimefunItemStack BENEVOLENT_BREW = Utils.makePotion(
        "AV_BENEVOLENT_BREW_POTION",
        Utils.legacySerialize("<gradient:#2ddae0:#31f876>仁慈酿造</gradient>"),
        Color.LIME,
        potEffectsMap
    );

    static {
        // Clear the map from the previous usage
        potEffectsMap.clear();

        // Add effects
        potEffectsMap.put(PotionEffectType.WEAKNESS, new int[] {
            cfg.getInt("options.potions.malevolent-concoction.weakness.ticks"),
            cfg.getInt("options.potions.malevolent-concoction.weakness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.SLOW, new int[] {
            cfg.getInt("options.potions.malevolent-concoction.slowness.ticks"),
            cfg.getInt("options.potions.malevolent-concoction.slowness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.POISON, new int[] {
            cfg.getInt("options.potions.malevolent-concoction.poison.ticks"),
            cfg.getInt("options.potions.malevolent-concoction.poison.level") - 1
        });
        potEffectsMap.put(PotionEffectType.BLINDNESS, new int[] {
            cfg.getInt("options.potions.malevolent-concoction.blindness.ticks"),
            cfg.getInt("options.potions.malevolent-concoction.blindness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.HUNGER, new int[] {
            cfg.getInt("options.potions.malevolent-concoction.hunger.ticks"),
            cfg.getInt("options.potions.malevolent-concoction.hunger.level") - 1
        });
    }

    public static final SlimefunItemStack MALEVOLENT_CONCOCTION = Utils.makeSplashPotion(
        "AV_MALEVOLENT_CONCOCTION_SPLASH_POTION",
        Utils.legacySerialize("<gradient:#ff5555:#ffa012>恶毒混合物</gradient>"),
        Color.MAROON,
        potEffectsMap
    );

    public static final SlimefunItemStack ALTAR_OF_INFUSION = new SlimefunItemStack(
        "AV_ALTAR_OF_INFUSION",
        Material.LODESTONE,
        Utils.legacySerialize("<gradient:#f78770:#ff607b>注入祭坛</gradient>"),
        "&5结合了科技与巫术的祭坛",
        "&5可以向物品注入强大的属性",
        "&d仅能注入金、铁、钻石、下界合金装备",
        "&d以及钓竿、弓、弩"
    );

}
