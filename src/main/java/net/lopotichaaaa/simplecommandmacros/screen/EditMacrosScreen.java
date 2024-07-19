package net.lopotichaaaa.simplecommandmacros.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class EditMacrosScreen extends Screen {
    public EditMacrosScreen() {
        super(Component.translatable("simplecommandmacros.menu.editmacros.title"));
    }

    @Override
    protected void init() {
        super.init();

    }

    @Override
    public void render(GuiGraphics graphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(graphics);
        super.render(graphics, pMouseX, pMouseY, pPartialTick);
    }
}
