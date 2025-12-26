package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.d21;

/* loaded from: classes.dex */
public class ImageViewCompat {
    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView imageView) {
        return d21.m4510a(imageView);
    }

    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView imageView) {
        return d21.m4511b(imageView);
    }

    public static void setImageTintList(@NonNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        d21.m4512c(imageView, colorStateList);
    }

    public static void setImageTintMode(@NonNull ImageView imageView, @Nullable PorterDuff.Mode mode) {
        d21.m4513d(imageView, mode);
    }
}
