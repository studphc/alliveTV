package p000;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import androidx.annotation.DoNotInline;

/* renamed from: lg */
/* loaded from: classes.dex */
public abstract class AbstractC1510lg {
    @DoNotInline
    /* renamed from: a */
    public static Bitmap m5923a(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = AbstractC1584ng.m6349a(bitmap);
            }
            return bitmap.copy(config, true);
        }
        return bitmap;
    }

    @DoNotInline
    /* renamed from: b */
    public static Bitmap m5924b(int i, int i2, Bitmap bitmap, boolean z) {
        Bitmap.Config config = bitmap.getConfig();
        ColorSpace colorSpace = bitmap.getColorSpace();
        ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
            config = Bitmap.Config.RGBA_F16;
            colorSpace = colorSpace2;
        } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = AbstractC1584ng.m6349a(bitmap);
            }
        }
        return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m5925c(Bitmap bitmap) {
        ColorSpace colorSpace = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        if (bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(colorSpace)) {
            return true;
        }
        return false;
    }
}
