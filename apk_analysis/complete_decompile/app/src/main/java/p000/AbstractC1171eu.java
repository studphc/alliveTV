package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;

/* renamed from: eu */
/* loaded from: classes.dex */
public abstract class AbstractC1171eu {
    @DoNotInline
    /* renamed from: a */
    public static ColorStateList m4755a(CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    @DoNotInline
    /* renamed from: b */
    public static PorterDuff.Mode m4756b(CompoundButton compoundButton) {
        return compoundButton.getButtonTintMode();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m4757c(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m4758d(CompoundButton compoundButton, PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}
