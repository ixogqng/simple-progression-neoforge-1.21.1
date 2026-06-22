package net.ixogqng.simpleprogression.item;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleProgression.MODID);

    // Items
    public static final DeferredItem<Item> KINDLING = ITEMS.register("kindling",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
