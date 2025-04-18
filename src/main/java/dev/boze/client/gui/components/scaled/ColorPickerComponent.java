package dev.boze.client.gui.components.scaled;

import dev.boze.client.enums.BottomRow;
import dev.boze.client.font.IFontRender;
import dev.boze.client.gui.components.*;
import dev.boze.client.gui.components.slider.floats.fr;
import dev.boze.client.gui.components.toggle.ToggleColorPickerChangingComponent;
import dev.boze.client.gui.components.toggle.ToggleColorPickerComponent;
import dev.boze.client.gui.notification.Notifications;
import dev.boze.client.gui.screens.ClickGUI;
import dev.boze.client.systems.modules.client.Colors;
import dev.boze.client.systems.modules.client.Theme;
import dev.boze.client.utils.render.RenderUtil;
import dev.boze.client.utils.render.color.ChangingColor;
import dev.boze.client.utils.render.color.StaticColor;
import mapped.Class2776;
import mapped.Class2777;
import mapped.Class2778;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

public class ColorPickerComponent extends BottomRowScaledComponent {
    private final ChangingColor field1439;
    private final FloatSliderComponent field1440;
    private final ToggleComponent field1441;
    private final ToggleComponent field1442;
    private final String field1443;
    private final ScaledBaseComponent field1444;

    public ColorPickerComponent(String colorName, ChangingColor color, ScaledBaseComponent previousPopup) {
        super("Edit " + colorName, BottomRow.AddClose, 0.125, 0.4, 2);
        this.field1439 = color;
        this.field1443 = colorName;
        this.field1444 = previousPopup;
        this.field1440 = new fr(this, "Speed", 0.0, 0.0, 0.0, 0.0, color);
        this.field1441 = new ToggleColorPickerChangingComponent(this, "HSB", 0.0, 0.0, 0.0, 0.0, color);
        this.field1442 = new ToggleColorPickerComponent(this, "Mirror", 0.0, 0.0, 0.0, 0.0, color);
    }

    @Override
    protected void method1198() {
        double var3 = Math.max(
                IFontRender.method499().method501("Add"), Math.max(IFontRender.method499().method501("Save"), IFontRender.method499().method501("Close"))
        )
                + BaseComponent.scaleFactor * 6.0;
        double var5 = IFontRender.method499().method1390() + BaseComponent.scaleFactor * 6.0;
        double var7 = this.field1389 + this.field1391 - var5 - BaseComponent.scaleFactor * 6.0;
        double var9 = BaseComponent.scaleFactor * 6.0;
        double var11 = var3 * 3.0 + var9 * 2.0;
        double var13 = this.field1388 + (this.field1390 - var11) / 2.0;
        RenderUtil.field3963.method2257(var13, var7, var3, var5, 15, 24, Theme.method1387() ? BaseComponent.scaleFactor * 6.0 : 0.0, Theme.method1347());
        IFontRender.method499()
                .drawShadowedText(
                        "Add",
                        var13 + var3 * 0.5 - IFontRender.method499().method501("Add") * 0.5,
                        var7 + var5 * 0.5 - IFontRender.method499().method1390() * 0.5,
                        Theme.method1350()
                );
        double var15 = var13 + var3 + var9;
        RenderUtil.field3963.method2257(var15, var7, var3, var5, 15, 24, Theme.method1387() ? BaseComponent.scaleFactor * 6.0 : 0.0, Theme.method1347());
        IFontRender.method499()
                .drawShadowedText(
                        "Save",
                        var15 + var3 * 0.5 - IFontRender.method499().method501("Save") * 0.5,
                        var7 + var5 * 0.5 - IFontRender.method499().method1390() * 0.5,
                        Theme.method1350()
                );
        double var17 = var15 + var3 + var9;
        RenderUtil.field3963.method2257(var17, var7, var3, var5, 15, 24, Theme.method1387() ? BaseComponent.scaleFactor * 6.0 : 0.0, Theme.method1347());
        IFontRender.method499()
                .drawShadowedText(
                        "Close",
                        var17 + var3 * 0.5 - IFontRender.method499().method501("Close") * 0.5,
                        var7 + var5 * 0.5 - IFontRender.method499().method1390() * 0.5,
                        Theme.method1350()
                );
    }

    @Override
    protected void handleAddAndCloseClick(double mouseX, double mouseY) {
        double d;
        double d2;
        double d3;
        double d4 = Math.max(IFontRender.method499().method501("Add"), Math.max(IFontRender.method499().method501("Save"), IFontRender.method499().method501("Close"))) + BaseComponent.scaleFactor * 6.0;
        double d5 = d4 * 3.0 + (d3 = BaseComponent.scaleFactor * 6.0) * 2.0;
        double d6 = this.field1388 + (this.field1390 - d5) / 2.0;
        if (ColorPickerComponent.isMouseWithinBounds(mouseX, mouseY, d6, d2 = this.field1389 + this.field1391 - (d = IFontRender.method499().method1390() + BaseComponent.scaleFactor * 6.0) - BaseComponent.scaleFactor * 6.0, d4, d)) {
            mc.getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            StaticColor staticColor = new StaticColor(148, 123, 211);
            ClickGUI.field1335.method580(new NewColorComponent("New Color", staticColor, this, this::lambda$handleAddAndCloseClick$0));
            return;
        }
        double d7 = d6 + d4 + d3;
        if (ColorPickerComponent.isMouseWithinBounds(mouseX, mouseY, d7, d2, d4, d)) {
            mc.getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            Colors.INSTANCE.field2343.put(this.field1443, this.field1439);
            ClickGUI.field1335.method580(this.field1444);
            return;
        }
        double d8 = d7 + d4 + d3;
        if (ColorPickerComponent.isMouseWithinBounds(mouseX, mouseY, d8, d2, d4, d)) {
            mc.getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            ClickGUI.field1335.method580(this.field1444);
            return;
        }
        double d9 = BaseComponent.scaleFactor * 24.0;
        double d10 = this.field1389 + BaseComponent.scaleFactor * 36.0;
        double d11 = this.field1390 - BaseComponent.scaleFactor * 24.0;
        double d12 = this.field1388 + BaseComponent.scaleFactor * 12.0;
        for (int i = 0; i < this.field1439.field416.size(); ++i) {
            double d13 = Class2778.method5440(d10, d9);
            int n = 0;
            if (this.field1439.field416.size() > 2) {
                ++n;
            }
            ++n;
            if (i < this.field1439.field416.size() - 1 && Class2778.method5441(mouseX, mouseY, Class2778.method5439(d12, d11, n++), d13)) {
                Class2778.method5437();
                StaticColor staticColor = this.field1439.field416.get(i);
                this.field1439.field416.set(i, this.field1439.field416.get(i + 1));
                this.field1439.field416.set(i + 1, staticColor);
                return;
            }
            if (i > 0 && Class2778.method5441(mouseX, mouseY, Class2778.method5439(d12, d11, n), d13)) {
                Class2778.method5437();
                StaticColor staticColor = this.field1439.field416.get(i);
                this.field1439.field416.set(i, this.field1439.field416.get(i - 1));
                this.field1439.field416.set(i - 1, staticColor);
                return;
            }
            d10 += d9 + BaseComponent.scaleFactor * 6.0;
        }
    }

    @Override
    protected int method2010() {
        return this.field1439.field416.size();
    }

    @Override
    protected void method639(DrawContext context, int index, double itemX, double itemY, double itemWidth, double itemHeight) {
        StaticColor var14 = this.field1439.field416.get(index);
        Class2776.method5432(itemX, itemY, itemWidth, itemHeight, false);
        Class2776.method5430(itemX, itemY, itemHeight, var14);
        Class2776.method5431(String.format("#%02X%02X%02X", var14.field430, var14.field431, var14.field432), itemX, itemY, itemHeight);
        double var15 = Class2778.method5440(itemY, itemHeight);
        int var17 = 0;
        if (this.field1439.field416.size() > 2) {
            Class2777.method5433(Notifications.DELETE, Class2778.method5439(itemX, itemWidth, var17++), var15);
        }

        Class2777.method5433(Notifications.EDIT, Class2778.method5439(itemX, itemWidth, var17++), var15);
        if (index < this.field1439.field416.size() - 1) {
            Class2777.method5433(Notifications.EXPAND_MORE, Class2778.method5439(itemX, itemWidth, var17++), var15);
        }

        if (index > 0) {
            Class2777.method5433(Notifications.EXPAND_LESS, Class2778.method5439(itemX, itemWidth, var17), var15);
        }
    }

    @Override
    protected boolean handleItemClick(int index, int button, double itemX, double itemY, double itemWidth, double itemHeight, double mouseX, double mouseY) {
        double d = Class2778.method5440(itemY, itemHeight);
        int n = 0;
        if (this.field1439.field416.size() > 2 && Class2778.method5441(mouseX, mouseY, Class2778.method5439(itemX, itemWidth, n++), d)) {
            Class2778.method5437();
            this.field1439.field416.remove(index);
            return true;
        }
        if (Class2778.method5441(mouseX, mouseY, Class2778.method5439(itemX, itemWidth, n++), d)) {
            Class2778.method5437();
            ClickGUI.field1335.method580(new NewColorComponent("Color " + (index + 1), this.field1439.field416.get(index), this, arg_0 -> this.lambda$handleItemClick$1(index, arg_0)));
            return true;
        }
        if (index < this.field1439.field416.size() - 1 && Class2778.method5441(mouseX, mouseY, Class2778.method5439(itemX, itemWidth, n++), d)) {
            Class2778.method5437();
            StaticColor staticColor = this.field1439.field416.get(index);
            this.field1439.field416.set(index, this.field1439.field416.get(index + 1));
            this.field1439.field416.set(index + 1, staticColor);
            return true;
        }
        if (index > 0 && Class2778.method5441(mouseX, mouseY, Class2778.method5439(itemX, itemWidth, n), d)) {
            Class2778.method5437();
            StaticColor staticColor = this.field1439.field416.get(index);
            this.field1439.field416.set(index, this.field1439.field416.get(index - 1));
            this.field1439.field416.set(index - 1, staticColor);
            return true;
        }
        return false;
    }

    @Override
    protected void method641(DrawContext context, double startY, double height) {
        this.field1440.field1133 = this.field1388 + BaseComponent.scaleFactor * 12.0;
        this.field1440.field1134 = startY;
        this.field1440.field1135 = this.field1390 - BaseComponent.scaleFactor * 24.0;
        this.field1440.field1136 = height;
        this.field1440.render(context, 0, 0, 0.0F);
        this.field1441.field1133 = this.field1388 + BaseComponent.scaleFactor * 12.0;
        this.field1441.field1134 = startY + height + BaseComponent.scaleFactor * 6.0;
        this.field1441.field1135 = (this.field1390 - BaseComponent.scaleFactor * 30.0) / 2.0;
        this.field1441.field1136 = height;
        this.field1441.render(context, 0, 0, 0.0F);
        this.field1442.field1133 = this.field1388 + BaseComponent.scaleFactor * 18.0 + (this.field1390 - BaseComponent.scaleFactor * 30.0) / 2.0;
        this.field1442.field1134 = startY + height + BaseComponent.scaleFactor * 6.0;
        this.field1442.field1135 = (this.field1390 - BaseComponent.scaleFactor * 30.0) / 2.0;
        this.field1442.field1136 = height;
        this.field1442.render(context, 0, 0, 0.0F);
    }

    @Override
    protected void method1904() {
        Class2778.method5437();
        StaticColor var3 = new StaticColor(148, 123, 211);
        ClickGUI.field1335.method580(new NewColorComponent("New Color", var3, this, this.field1439.field416::add));
    }

    @Override
    public boolean isMouseOver(double mouseX, double mouseY, int button) {
        return this.field1440.mouseClicked(mouseX, mouseY, button)
                || this.field1441.mouseClicked(mouseX, mouseY, button)
                || this.field1442.mouseClicked(mouseX, mouseY, button) || super.isMouseOver(mouseX, mouseY, button);
    }

    @Override
    public boolean onDrag(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return this.field1440.onDrag(mouseX, mouseY, button, deltaX, deltaY) || super.onDrag(mouseX, mouseY, button, deltaX, deltaY);
    }

    private void lambda$handleItemClick$1(int var1, StaticColor var2) {
        this.field1439.field416.set(var1, var2);
    }

    private void lambda$handleAddAndCloseClick$0(StaticColor var1) {
        this.field1439.field416.add(var1);
    }
}
