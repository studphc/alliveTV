package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.AbstractC1834tg;
import p000.x12;
import p000.y12;
import p000.yy2;

/* loaded from: classes.dex */
public final class PaintCompat {
    static {
        new ThreadLocal();
    }

    public static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        return x12.m8087a(paint, str);
    }

    public static boolean setBlendMode(@NonNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        PorterDuffXfermode porterDuffXfermode = null;
        Object obj = null;
        if (Build.VERSION.SDK_INT >= 29) {
            if (blendModeCompat != null) {
                obj = AbstractC1834tg.m7495a(blendModeCompat);
            }
            y12.m8208a(paint, obj);
            return true;
        }
        if (blendModeCompat != null) {
            PorterDuff.Mode m8336F = yy2.m8336F(blendModeCompat);
            if (m8336F != null) {
                porterDuffXfermode = new PorterDuffXfermode(m8336F);
            }
            paint.setXfermode(porterDuffXfermode);
            if (m8336F != null) {
                return true;
            }
            return false;
        }
        paint.setXfermode(null);
        return true;
    }
}
