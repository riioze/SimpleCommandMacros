package net.lopotichaaaa.simplecommandmacros.screen;


import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class EditMacrosScreen extends Screen {

    private Font font;
    private MacroListWidget macroListWidget;
    private List<IMacroInfo> macroList;

    public EditMacrosScreen() {
        super(Component.translatable("menu.simplecommandmacros.editmacros.title"));
        macroList = new ArrayList<IMacroInfo>();
        macroList.add(new IMacroInfo() {
            @Override
            public String getDisplayName() {
                return "test";
            }

            @Override
            public String getCommand() {
                return "/time set day";
            }
        });
        macroList.add(new IMacroInfo() {
            @Override
            public String getDisplayName() {
                return "test2";
            }

            @Override
            public String getCommand() {
                return "/time set day";
            }
        });
    }

    @Override
    protected void init() {
        super.init();
        font = minecraft.font;
        macroListWidget = new MacroListWidget(this,100, 30,200);
        macroListWidget.setLeftPos(6);
        addRenderableWidget(macroListWidget);
        macroListWidget.updateMacroList(macroList);




    }

    @Override
    public void render(GuiGraphics graphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(graphics);
        super.render(graphics, pMouseX, pMouseY, pPartialTick);
        graphics.drawString(getFont(),title,0,0,0xFFFFFF);
        macroListWidget.render(graphics,pMouseX,pMouseY,pPartialTick);

    }

    @Override
    public void tick() {
        super.tick();
        MouseHandler mouseHandler = minecraft.mouseHandler;
        boolean buttonPressed = mouseHandler.isLeftPressed();
        double mouseX = mouseHandler.xpos();
        double mouseY = mouseHandler.ypos();
        macroListWidget.checkSelection(mouseX,mouseY,buttonPressed);


    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics) {
        renderDirtBackground(pGuiGraphics);
    }

    public Font getFont() {
        return font;
    }
}
