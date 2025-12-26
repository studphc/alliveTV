package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.common.util.DeviceProperties;
import p000.ye0;

/* loaded from: classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    /* renamed from: a */
    public static final int m3163a(int i, int i2, int i3, int i4) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return i4;
                }
                throw new IllegalStateException(ye0.m8291k(i, "Unknown color scheme: "));
            }
            return i3;
        }
        return i2;
    }

    public final void zaa(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark;
        int i5 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light;
        int m3163a = m3163a(i2, i4, i5, i5);
        int i6 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_dark;
        int i7 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_light;
        int m3163a2 = m3163a(i2, i6, i7, i7);
        if (i != 0 && i != 1) {
            if (i != 2) {
                throw new IllegalStateException(ye0.m8291k(i, "Unknown button size: "));
            }
        } else {
            m3163a = m3163a2;
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(m3163a));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(com.google.android.gms.base.R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        int i8 = com.google.android.gms.base.R.color.common_google_signin_btn_text_dark;
        int i9 = com.google.android.gms.base.R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(m3163a(i2, i8, i9, i9))));
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    setText((CharSequence) null);
                } else {
                    throw new IllegalStateException(ye0.m8291k(i, "Unknown button size: "));
                }
            } else {
                setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text_long));
            }
        } else {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text));
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
