package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class s11 {
    @DoNotInline
    /* renamed from: a */
    public static Drawable m7316a(Drawable drawable, Drawable drawable2) {
        return new AdaptiveIconDrawable(drawable, drawable2);
    }

    @DoNotInline
    /* renamed from: b */
    public static Icon m7317b(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }
}
