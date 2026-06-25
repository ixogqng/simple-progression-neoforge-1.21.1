package net.ixogqng.simpleprogression.screen;

import net.ixogqng.simpleprogression.SimpleProgression;
import net.ixogqng.simpleprogression.screen.custom.BasicForgeMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, SimpleProgression.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<BasicForgeMenu>> BASIC_FORGE_MENU =
            MENUS.register("basic_forge_menu", () ->
                    new MenuType<>(BasicForgeMenu::new, FeatureFlags.REGISTRY.allFlags()));
    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> containerFactory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(containerFactory));
    }
}
