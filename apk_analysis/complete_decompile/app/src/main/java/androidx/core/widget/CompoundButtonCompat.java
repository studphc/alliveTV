package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.AbstractC1171eu;
import p000.AbstractC1208fu;

/* loaded from: classes.dex */
public final class CompoundButtonCompat {
    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton compoundButton) {
        return AbstractC1208fu.m4840a(compoundButton);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton compoundButton) {
        return AbstractC1171eu.m4755a(compoundButton);
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton compoundButton) {
        return AbstractC1171eu.m4756b(compoundButton);
    }

    public static void setButtonTintList(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        AbstractC1171eu.m4757c(compoundButton, colorStateList);
    }

    public static void setButtonTintMode(@NonNull CompoundButton compoundButton, @Nullable PorterDuff.Mode mode) {
        AbstractC1171eu.m4758d(compoundButton, mode);
    }
}
