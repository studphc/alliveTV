package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.common.internal.zaz;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.errorprone.annotations.InlineMe;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;

    /* renamed from: a */
    public int f13002a;

    /* renamed from: b */
    public int f13003b;

    /* renamed from: c */
    public View f13004c;

    /* renamed from: d */
    public View.OnClickListener f13005d;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ColorScheme {
    }

    public SignInButton(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        View.OnClickListener onClickListener = this.f13005d;
        if (onClickListener != null && view == this.f13004c) {
            onClickListener.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.f13002a, i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f13004c.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f13005d = onClickListener;
        View view = this.f13004c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(@NonNull Scope[] scopeArr) {
        setStyle(this.f13002a, this.f13003b);
    }

    public void setSize(int i) {
        setStyle(i, this.f13003b);
    }

    public void setStyle(int i, int i2) {
        this.f13002a = i;
        this.f13003b = i2;
        Context context = getContext();
        View view = this.f13004c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f13004c = zaz.zaa(context, this.f13002a, this.f13003b);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f13002a;
            int i4 = this.f13003b;
            zaaa zaaaVar = new zaaa(context, null);
            zaaaVar.zaa(context.getResources(), i3, i4);
            this.f13004c = zaaaVar;
        }
        addView(this.f13004c);
        this.f13004c.setEnabled(isEnabled());
        this.f13004c.setOnClickListener(this);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13005d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.gms.base.R.styleable.SignInButton, 0, 0);
        try {
            this.f13002a = obtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_buttonSize, 0);
            this.f13003b = obtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.f13002a, this.f13003b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @InlineMe(replacement = "this.setStyle(buttonSize, colorScheme)")
    @Deprecated
    public void setStyle(int i, int i2, @NonNull Scope[] scopeArr) {
        setStyle(i, i2);
    }
}
