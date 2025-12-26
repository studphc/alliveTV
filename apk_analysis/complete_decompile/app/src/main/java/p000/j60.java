package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.DoNotInline;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class j60 {
    @DoNotInline
    /* renamed from: a */
    public static void m5394a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m5395b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    @DoNotInline
    /* renamed from: c */
    public static ColorFilter m5396c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    @DoNotInline
    /* renamed from: d */
    public static void m5397d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m5398e(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m5399f(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    @DoNotInline
    /* renamed from: g */
    public static void m5400g(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    @DoNotInline
    /* renamed from: h */
    public static void m5401h(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    @DoNotInline
    /* renamed from: i */
    public static void m5402i(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }
}
