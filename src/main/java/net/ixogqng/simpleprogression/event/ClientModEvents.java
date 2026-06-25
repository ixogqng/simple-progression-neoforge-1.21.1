package net.ixogqng.simpleprogression.event;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.client.gui.screens.recipebook.BasicForgeRecipeBookComponent;
import net.ixogqng.simpleprogression.recipe.ModRecipes;
import net.ixogqng.simpleprogression.screen.ModMenuTypes;
import net.ixogqng.simpleprogression.screen.custom.BasicForgeMenu;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.RecipeBookType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

import java.util.List;

@EventBusSubscriber(modid = SimpleProgression.MODID)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.BASIC_FORGE_MENU.get(), BasicForgeScreen::new);
    }

    private static class BasicForgeScreen extends AbstractFurnaceScreen<BasicForgeMenu> {

        private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/lit_progress");
        private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/burn_progress");
        private static final ResourceLocation TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/container/furnace.png");

        public BasicForgeScreen(BasicForgeMenu menu, Inventory playerInventory, Component title) {
            super(menu, new BasicForgeRecipeBookComponent(), playerInventory, title, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE);
        }
    }

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof AbstractFurnaceScreen<?> screen) {
            if (screen.getMenu() instanceof BasicForgeMenu) {
                for (var widget : event.getListenersList()) {
                    if (widget instanceof ImageButton button) {
                        button.visible = false;
                        button.active = false;
                    }
                }
            }
        }
    }
}
