package p000;

import android.graphics.Bitmap;
import androidx.annotation.DoNotInline;

/* renamed from: ng */
/* loaded from: classes.dex */
public abstract class AbstractC1584ng {
    @DoNotInline
    /* renamed from: a */
    public static Bitmap.Config m6349a(Bitmap bitmap) {
        if (bitmap.getHardwareBuffer().getFormat() == 22) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }
}
