package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class bc2 {
    @DoNotInline
    /* renamed from: a */
    public static Drawable m2080a(Resources resources, int i, Resources.Theme theme) {
        return resources.getDrawable(i, theme);
    }

    @DoNotInline
    /* renamed from: b */
    public static Drawable m2081b(Resources resources, int i, int i2, Resources.Theme theme) {
        return resources.getDrawableForDensity(i, i2, theme);
    }
}
