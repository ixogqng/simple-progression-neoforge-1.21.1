package net.ixogqng.simpleprogression.util;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Blocks {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SimpleProgression.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> STICK_ITEMS = createTag("stick_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SimpleProgression.MODID, name));
        }
    }
}
