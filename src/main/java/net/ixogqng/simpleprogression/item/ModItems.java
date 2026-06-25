package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.SimpleProgression;
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
    public static final DeferredItem<Item> KINDLING = ITEMS.register("kindling",
            () -> new Item(new Item.Properties()));

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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
