package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class bn1 {
    @DoNotInline
    /* renamed from: a */
    public static int m2109a(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    @DoNotInline
    /* renamed from: b */
    public static CharSequence m2110b(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    @DoNotInline
    /* renamed from: c */
    public static ColorStateList m2111c(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    @DoNotInline
    /* renamed from: d */
    public static PorterDuff.Mode m2112d(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    @DoNotInline
    /* renamed from: e */
    public static int m2113e(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    @DoNotInline
    /* renamed from: f */
    public static CharSequence m2114f(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    @DoNotInline
    /* renamed from: g */
    public static MenuItem m2115g(MenuItem menuItem, char c, int i) {
        return menuItem.setAlphabeticShortcut(c, i);
    }

    @DoNotInline
    /* renamed from: h */
    public static MenuItem m2116h(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    @DoNotInline
    /* renamed from: i */
    public static MenuItem m2117i(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    @DoNotInline
    /* renamed from: j */
    public static MenuItem m2118j(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    @DoNotInline
    /* renamed from: k */
    public static MenuItem m2119k(MenuItem menuItem, char c, int i) {
        return menuItem.setNumericShortcut(c, i);
    }

    @DoNotInline
    /* renamed from: l */
    public static MenuItem m2120l(MenuItem menuItem, char c, char c2, int i, int i2) {
        return menuItem.setShortcut(c, c2, i, i2);
    }

    @DoNotInline
    /* renamed from: m */
    public static MenuItem m2121m(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}
