package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.item.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleProgression.MODID);

    // Items

    public static final DeferredItem<PickaxeItem> FLINT_PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FLINT,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.FLINT, 1, -2.8f))));
    public static final DeferredItem<SwordItem> FLINT_SWORD = ITEMS.register("flint_sword",
            () -> new SwordItem(ModToolTiers.FLINT,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.FLINT, 3.0f, -2.4f))));
    public static final DeferredItem<HoeItem> FLINT_HOE = ITEMS.register("flint_hoe",
            () -> new HoeItem(ModToolTiers.FLINT,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.FLINT, 0.0f, -3.0f))));
    public static final DeferredItem<AxeItem> FLINT_AXE = ITEMS.register("flint_axe",
            () -> new AxeItem(ModToolTiers.FLINT,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.FLINT, 6.0f, -3.2f))));
    public static final DeferredItem<ShovelItem> FLINT_SHOVEL = ITEMS.register("flint_shovel",
            () -> new ShovelItem(ModToolTiers.FLINT,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.FLINT, 1.5f, -3.0f))));

    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<ArmorItem> TIN_HELMET = ITEMS.register("tin_helmet",
            () -> new ArmorItem(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(9))
                    .attributes(ItemAttributeModifiers.builder()
                            .add(Attributes.MOVEMENT_SPEED,
                                new AttributeModifier(
                                        ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_helmet_speed"),
                                        0.005f,
                                        AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.HEAD)
                            .add(Attributes.ARMOR,
                                    new AttributeModifier(
                                            ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_helmet_armor"),
                                            3,
                                            AttributeModifier.Operation.ADD_VALUE
                                    ),
                            EquipmentSlotGroup.HEAD)
                            .build())));
    public static final DeferredItem<ArmorItem> TIN_BOOTS = ITEMS.register("tin_boots",
            () -> new ArmorItem(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(9)).attributes(ItemAttributeModifiers.builder().add(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(
                                    ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_boots_speed"),
                                    0.005f,
                                    AttributeModifier.Operation.ADD_VALUE
                            ),
                            EquipmentSlotGroup.FEET)
                            .add(Attributes.ARMOR,
                                    new AttributeModifier(
                                            ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_boots_armor"),
                                            3,
                                            AttributeModifier.Operation.ADD_VALUE
                                    ),
                                    EquipmentSlotGroup.FEET)
                            .build())));
    public static final DeferredItem<ArmorItem> TIN_CHESTPLATE = ITEMS.register("tin_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(9)).attributes(ItemAttributeModifiers.builder().add(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(
                                    ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_chestplate_speed"),
                                    0.005f,
                                    AttributeModifier.Operation.ADD_VALUE
                            ),
                            EquipmentSlotGroup.CHEST).add(Attributes.ARMOR,
                            new AttributeModifier(
                                    ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_chestplate_armor"),
                                    3,
                                    AttributeModifier.Operation.ADD_VALUE
                            ),
                            EquipmentSlotGroup.CHEST)
                            .build())));
    public static final DeferredItem<ArmorItem> TIN_LEGGINGS = ITEMS.register("tin_leggings",
            () -> new ArmorItem(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(9)).attributes(ItemAttributeModifiers.builder().add(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(
                                    ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_leggings_speed"),
                                    0.005f,
                                    AttributeModifier.Operation.ADD_VALUE
                            ),
                            EquipmentSlotGroup.LEGS).add(Attributes.ARMOR,
                            new AttributeModifier(
                                    ResourceLocation.fromNamespaceAndPath("simpleprogression", "tin_leggings_armor"),
                                    3,
                                    AttributeModifier.Operation.ADD_VALUE
                            ),
                            EquipmentSlotGroup.LEGS)
                            .build())));
    public static final DeferredItem<PickaxeItem> TIN_PICKAXE = ITEMS.register("tin_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TIN,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.TIN, 1, -2.8f))));
    public static final DeferredItem<SwordItem> TIN_SWORD = ITEMS.register("tin_sword",
            () -> new SwordItem(ModToolTiers.TIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TIN, 3.0f, -2.4f))));
    public static final DeferredItem<HoeItem> TIN_HOE = ITEMS.register("tin_hoe",
            () -> new HoeItem(ModToolTiers.TIN,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.TIN, -1.0f, -2.0f))));
    public static final DeferredItem<AxeItem> TIN_AXE = ITEMS.register("tin_axe",
            () -> new AxeItem(ModToolTiers.TIN,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.TIN, 6.0f, -3.2f))));
    public static final DeferredItem<ShovelItem> TIN_SHOVEL = ITEMS.register("tin_shovel",
            () -> new ShovelItem(ModToolTiers.TIN,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.TIN, 1.5f, -3.0f))));
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1, -2.8f))));
    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3.0f, -2.4f))));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -1.0f, -2.0f))));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 7.0f, -3.2f))));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.5f, -3.0f))));
    public static final DeferredItem<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(11))));
    public static final DeferredItem<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(11))));
    public static final DeferredItem<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(11))));
    public static final DeferredItem<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(11))));

    public static final DeferredItem<WindChargeItem> BAG_OF_WIND = ITEMS.register("bag_of_wind",
            () -> new WindChargeItem(new Item.Properties()));

    public static final DeferredItem<PaxelItem> DIAMOND_PAXEL = ITEMS.register("diamond_paxel",
            () -> new PaxelItem(Tiers.DIAMOND,
                    new Item.Properties().attributes(PaxelItem.createAttributes(Tiers.DIAMOND, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> WOODEN_PAXEL = ITEMS.register("wooden_paxel",
            () -> new PaxelItem(Tiers.WOOD,
                    new Item.Properties().attributes(PaxelItem.createAttributes(Tiers.WOOD, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> FLINT_PAXEL = ITEMS.register("flint_paxel",
            () -> new PaxelItem(ModToolTiers.FLINT,
                    new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.FLINT, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> IRON_PAXEL = ITEMS.register("iron_paxel",
            () -> new PaxelItem(Tiers.IRON,
                    new Item.Properties().attributes(PaxelItem.createAttributes(Tiers.IRON, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> TIN_PAXEL = ITEMS.register("tin_paxel",
            () -> new PaxelItem(ModToolTiers.TIN,
                    new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.TIN, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> GOLD_PAXEL = ITEMS.register("gold_paxel",
            () -> new PaxelItem(Tiers.GOLD,
                    new Item.Properties().attributes(PaxelItem.createAttributes(Tiers.GOLD, 1, -2.8f))));
    public static final DeferredItem<BronzePaxelItem> BRONZE_PAXEL = ITEMS.register("bronze_paxel",
            () -> new BronzePaxelItem(ModToolTiers.BRONZE,
                    new Item.Properties().attributes(BronzePaxelItem.createAttributes(ModToolTiers.BRONZE, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> COPPER_PAXEL = ITEMS.register("copper_paxel",
            () -> new PaxelItem(ModToolTiers.COPPER,
                    new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.COPPER, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> SILVER_PAXEL = ITEMS.register("silver_paxel",
            () -> new PaxelItem(ModToolTiers.SILVER,
                    new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.SILVER, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> ECLIPSITE_PAXEL = ITEMS.register("eclipsite_paxel",
            () -> new PaxelItem(ModToolTiers.ECLIPSITE,
                    new Item.Properties().attributes(PaxelItem.createAttributes(ModToolTiers.ECLIPSITE, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> NETHERITE_PAXEL = ITEMS.register("netherite_paxel",
            () -> new PaxelItem(Tiers.NETHERITE,
                    new Item.Properties().attributes(PaxelItem.createAttributes(Tiers.NETHERITE, 1, -2.8f))));
    public static final DeferredItem<PaxelItem> STONE_PAXEL = ITEMS.register("stone_paxel",
            () -> new PaxelItem(Tiers.STONE,
                    new Item.Properties().attributes(PaxelItem.createAttributes(Tiers.STONE, 1, -2.8f))));

    public static final DeferredItem<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(ModToolTiers.BRONZE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.BRONZE, 3.0f, -2.4f))));

    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet",
            () -> new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(25))));
    public static final DeferredItem<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots",
            () -> new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(25))));
    public static final DeferredItem<ArmorItem> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(25))));
    public static final DeferredItem<ArmorItem> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings",
            () -> new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(25))));

    public static final DeferredItem<PickaxeItem> ECLIPSITE_PICKAXE = ITEMS.register("eclipsite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ECLIPSITE,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ECLIPSITE, 1, -2.8f))));
    public static final DeferredItem<SwordItem> ECLIPSITE_SWORD = ITEMS.register("eclipsite_sword",
            () -> new SwordItem(ModToolTiers.ECLIPSITE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ECLIPSITE, 3.0f, -2.4f))));
    public static final DeferredItem<HoeItem> ECLIPSITE_HOE = ITEMS.register("eclipsite_hoe",
            () -> new HoeItem(ModToolTiers.ECLIPSITE,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.ECLIPSITE, -4.0f, 0.0f))));
    public static final DeferredItem<AxeItem> ECLIPSITE_AXE = ITEMS.register("eclipsite_axe",
            () -> new AxeItem(ModToolTiers.ECLIPSITE,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ECLIPSITE, 5.0f, -3.0f))));
    public static final DeferredItem<ShovelItem> ECLIPSITE_SHOVEL = ITEMS.register("eclipsite_shovel",
            () -> new ShovelItem(ModToolTiers.ECLIPSITE,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ECLIPSITE, 1.5f, -3.0f))));
    public static final DeferredItem<Item> RAW_ECLIPSITE = ITEMS.register("raw_eclipsite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ECLIPSITE_INGOT = ITEMS.register("eclipsite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<ArmorItem> ECLIPSITE_HELMET = ITEMS.register("eclipsite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ECLIPSITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<ArmorItem> ECLIPSITE_BOOTS = ITEMS.register("eclipsite_boots",
            () -> new ArmorItem(ModArmorMaterials.ECLIPSITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(37))));
    public static final DeferredItem<ArmorItem> ECLIPSITE_CHESTPLATE = ITEMS.register("eclipsite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ECLIPSITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<ArmorItem> ECLIPSITE_LEGGINGS = ITEMS.register("eclipsite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ECLIPSITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));

    public static final DeferredItem<BronzePickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new BronzePickaxeItem(ModToolTiers.BRONZE,
                    new Item.Properties().attributes(BronzePickaxeItem.createAttributes(ModToolTiers.BRONZE, 1, -2.8f))));
    public static final DeferredItem<BronzeShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new BronzeShovelItem(ModToolTiers.BRONZE,
                    new Item.Properties().attributes(BronzeShovelItem.createAttributes(ModToolTiers.BRONZE, 1.5f, -3.0f))));
    public static final DeferredItem<BronzeHoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new BronzeHoeItem(ModToolTiers.BRONZE,
                    new Item.Properties().attributes(BronzeHoeItem.createAttributes(ModToolTiers.BRONZE, -1.0f, -2.0f))));
    public static final DeferredItem<BronzeAxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new BronzeAxeItem(ModToolTiers.BRONZE,
                    new Item.Properties().attributes(BronzeAxeItem.createAttributes(ModToolTiers.BRONZE, 7.0f, -3.2f))));

    public static final DeferredItem<SilverPickaxeItem> SILVER_PICKAXE = ITEMS.register("silver_pickaxe",
            () -> new SilverPickaxeItem(ModToolTiers.SILVER,
                    new Item.Properties().attributes(SilverPickaxeItem.createAttributes(ModToolTiers.SILVER, 1, -2.8f))));
    public static final DeferredItem<SwordItem> SILVER_SWORD = ITEMS.register("silver_sword",
            () -> new SwordItem(ModToolTiers.SILVER,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.SILVER, 3.0f, -2.4f))));
    public static final DeferredItem<SilverShovelItem> SILVER_SHOVEL = ITEMS.register("silver_shovel",
            () -> new SilverShovelItem(ModToolTiers.SILVER,
                    new Item.Properties().attributes(SilverShovelItem.createAttributes(ModToolTiers.SILVER, 1.5f, -3.0f))));
    public static final DeferredItem<HoeItem> SILVER_HOE = ITEMS.register("silver_hoe",
            () -> new HoeItem(ModToolTiers.SILVER,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.SILVER, -1.0f, -2.0f))));
    public static final DeferredItem<SilverAxeItem> SILVER_AXE = ITEMS.register("silver_axe",
            () -> new SilverAxeItem(ModToolTiers.SILVER,
                    new Item.Properties().attributes(SilverAxeItem.createAttributes(ModToolTiers.SILVER, 7.0f, -3.2f))));
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<ArmorItem> SILVER_HELMET = ITEMS.register("silver_helmet",
            () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final DeferredItem<ArmorItem> SILVER_BOOTS = ITEMS.register("silver_boots",
            () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(15))));
    public static final DeferredItem<ArmorItem> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final DeferredItem<ArmorItem> SILVER_LEGGINGS = ITEMS.register("silver_leggings",
            () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(15))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
