package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d21 {
    @DoNotInline
    /* renamed from: a */
    public static ColorStateList m4510a(ImageView imageView) {
        return imageView.getImageTintList();
    }

    @DoNotInline
    /* renamed from: b */
    public static PorterDuff.Mode m4511b(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m4512c(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m4513d(ImageView imageView, PorterDuff.Mode mode) {
        imageView.setImageTintMode(mode);
    }
}
