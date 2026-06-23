package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.minecraft.world.item.*;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
