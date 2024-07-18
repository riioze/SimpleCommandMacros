package net.lopotichaaaa.simplecommandmacros;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
   public static final Lazy<KeyMapping> OPEN_MACRO_MENU = Lazy.of(() -> new KeyMapping(
           "key.simplecommandmacros.open_macro_menu",
           KeyConflictContext.IN_GAME,
           InputConstants.Type.KEYSYM,
           GLFW.GLFW_KEY_M,
           "key.categories.misc"
           ));


   public static void register(RegisterKeyMappingsEvent event){
       event.register(OPEN_MACRO_MENU.get());
   }


}
