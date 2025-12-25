package androidx.core.graphics;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.AbstractC1760rg;
import p000.AbstractC1834tg;
import p000.yy2;

/* loaded from: classes.dex */
public class BlendModeColorFilterCompat {
    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int i, @NonNull BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object m7495a = AbstractC1834tg.m7495a(blendModeCompat);
            if (m7495a == null) {
                return null;
            }
            return AbstractC1760rg.m7271a(i, m7495a);
        }
        PorterDuff.Mode m8336F = yy2.m8336F(blendModeCompat);
        if (m8336F == null) {
            return null;
        }
        return new PorterDuffColorFilter(i, m8336F);
    }
}
