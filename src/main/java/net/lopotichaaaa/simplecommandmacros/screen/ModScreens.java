package net.lopotichaaaa.simplecommandmacros.screen;

import net.minecraftforge.common.util.Lazy;

public class ModScreens {
    public static final Lazy<EditMacrosScreen> EDIT_MACRO_SCREEN = Lazy.of(
            EditMacrosScreen::new
    );
}
