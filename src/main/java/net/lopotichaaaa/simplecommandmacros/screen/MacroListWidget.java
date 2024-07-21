package net.lopotichaaaa.simplecommandmacros.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.gui.widget.ModListWidget;

import java.util.Iterator;
import java.util.List;

public class MacroListWidget extends ObjectSelectionList<MacroListWidget.MacroEntry> {

    private EditMacrosScreen parent;
    public MacroListWidget(EditMacrosScreen parent,int listWidth, int top, int bottom ) {
        super(parent.getMinecraft(), listWidth, parent.height,top, bottom, parent.getFont().lineHeight * 2 + 8);
        this.parent = parent;


    }

    public void updateMacroList(List<IMacroInfo> macroInfoList){
        clearEntries();
        Iterator<IMacroInfo> it = macroInfoList.iterator();
        while (it.hasNext()){
            addEntry(new MacroEntry(it.next()));
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        int entryHeight = getHeight()/10;
        for (int i = 0; i<getItemCount(); i++) {
            int entryTop = getTop() + entryHeight * i;
            int entryLeft = getLeft();

            boolean hovering = getEntry(i).isMouseOver(pMouseX, pMouseY);
            getEntry(i).render(pGuiGraphics, i, entryTop, entryLeft, getWidth(), entryHeight, pMouseX, pMouseY, hovering, pPartialTick);

        }
    }

    public void checkSelection(double mouseX, double mouseY, boolean buttonPressed){
        if (!buttonPressed)return;
        for (int i = 0; i < getItemCount(); i++) {
            if (getEntry(i).mouseClicked(mouseX,mouseY,1)){
                setSelected(getEntry(i));
                System.out.println(getEntry(i).macroInfo.getDisplayName()+ " selected");
                return;
            }
        }
    }

    public class MacroEntry extends ObjectSelectionList.Entry<MacroEntry>{
        IMacroInfo macroInfo;

        MacroEntry(IMacroInfo macroInfo){
            this.macroInfo = macroInfo;
        }

        @Override
        public Component getNarration() {
            return Component.translatable("narrator.select",macroInfo.getDisplayName());
        }

        @Override
        public void render(GuiGraphics graphics, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pHovering, float pPartialTick) {
            renderBackground(graphics);
            if (pHovering){
                graphics.fill(pLeft,pTop,pLeft+pWidth,pTop+pHeight,0x000000E0);
            }
            Component name = Component.literal(macroInfo.getDisplayName());
            Font font = parent.getFont();

            graphics.drawString(font,name,pLeft+3,pTop+4,0xFFFFFF,false);

        }

        @Override
        public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
            return isMouseOver(pMouseX,pMouseY) && pButton==1;
        }
    }



}
