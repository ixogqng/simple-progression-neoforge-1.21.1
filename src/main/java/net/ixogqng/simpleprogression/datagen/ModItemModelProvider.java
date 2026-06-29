package net.ixogqng.simpleprogression.datagen;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SimpleProgression.MODID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = SimpleProgression.MODID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }


    @Override
    protected void registerModels() {
        basicItem(ModItems.KINDLING.get());

        handheldItem(ModItems.FLINT_PICKAXE.get());
        handheldItem(ModItems.FLINT_SWORD.get());
        handheldItem(ModItems.FLINT_HOE.get());
        handheldItem(ModItems.FLINT_AXE.get());
        handheldItem(ModItems.FLINT_SHOVEL.get());

        basicItem(ModItems.TIN_INGOT.get());
        trimmedArmorItem(ModItems.TIN_HELMET);
        trimmedArmorItem(ModItems.TIN_BOOTS);
        trimmedArmorItem(ModItems.TIN_LEGGINGS);
        trimmedArmorItem(ModItems.TIN_CHESTPLATE);
        handheldItem(ModItems.TIN_PICKAXE.get());
        handheldItem(ModItems.TIN_SWORD.get());
        handheldItem(ModItems.TIN_HOE.get());
        handheldItem(ModItems.TIN_AXE.get());
        handheldItem(ModItems.TIN_SHOVEL.get());
        basicItem(ModItems.RAW_TIN.get());
        handheldItem(ModItems.COPPER_PICKAXE.get());
        handheldItem(ModItems.COPPER_SWORD.get());
        handheldItem(ModItems.COPPER_HOE.get());
        handheldItem(ModItems.COPPER_AXE.get());
        handheldItem(ModItems.COPPER_SHOVEL.get());
        trimmedArmorItem(ModItems.COPPER_HELMET);
        trimmedArmorItem(ModItems.COPPER_BOOTS);
        trimmedArmorItem(ModItems.COPPER_LEGGINGS);
        trimmedArmorItem(ModItems.COPPER_CHESTPLATE);
        basicItem(ModItems.BAG_OF_WIND.get());
        handheldItem(ModItems.DIAMOND_PAXEL.get());
        handheldItem(ModItems.BRONZE_PICKAXE.get());
        handheldItem(ModItems.BRONZE_SWORD.get());
        handheldItem(ModItems.BRONZE_HOE.get());
        handheldItem(ModItems.BRONZE_AXE.get());
        handheldItem(ModItems.BRONZE_SHOVEL.get());
        basicItem(ModItems.BRONZE_INGOT.get());
        trimmedArmorItem(ModItems.BRONZE_HELMET);
        trimmedArmorItem(ModItems.BRONZE_BOOTS);
        trimmedArmorItem(ModItems.BRONZE_LEGGINGS);
        trimmedArmorItem(ModItems.BRONZE_CHESTPLATE);
        handheldItem(ModItems.ECLIPSITE_PICKAXE.get());
        handheldItem(ModItems.ECLIPSITE_SWORD.get());
        handheldItem(ModItems.ECLIPSITE_AXE.get());
        handheldItem(ModItems.ECLIPSITE_HOE.get());
        handheldItem(ModItems.ECLIPSITE_SHOVEL.get());
        basicItem(ModItems.RAW_ECLIPSITE.get());
        basicItem(ModItems.ECLIPSITE_INGOT.get());
        trimmedArmorItem(ModItems.ECLIPSITE_HELMET);
        trimmedArmorItem(ModItems.ECLIPSITE_BOOTS);
        trimmedArmorItem(ModItems.ECLIPSITE_LEGGINGS);
        trimmedArmorItem(ModItems.ECLIPSITE_CHESTPLATE);
        handheldItem(ModItems.SILVER_PICKAXE.get());
        handheldItem(ModItems.SILVER_SWORD.get());
        handheldItem(ModItems.SILVER_AXE.get());
        handheldItem(ModItems.SILVER_HOE.get());
        handheldItem(ModItems.SILVER_SHOVEL.get());
        trimmedArmorItem(ModItems.SILVER_HELMET);
        trimmedArmorItem(ModItems.SILVER_BOOTS);
        trimmedArmorItem(ModItems.SILVER_LEGGINGS);
        trimmedArmorItem(ModItems.SILVER_CHESTPLATE);
        basicItem(ModItems.RAW_SILVER.get());
        basicItem(ModItems.SILVER_INGOT.get());
        handheldItem(ModItems.WOODEN_PAXEL.get());
        handheldItem(ModItems.FLINT_PAXEL.get());
        handheldItem(ModItems.IRON_PAXEL.get());
        handheldItem(ModItems.TIN_PAXEL.get());
        handheldItem(ModItems.GOLD_PAXEL.get());
        handheldItem(ModItems.COPPER_PAXEL.get());
        handheldItem(ModItems.SILVER_PAXEL.get());
        handheldItem(ModItems.ECLIPSITE_PAXEL.get());
    }
}
