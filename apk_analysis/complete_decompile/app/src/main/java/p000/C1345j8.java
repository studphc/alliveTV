package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

/* renamed from: j8 */
/* loaded from: classes.dex */
public final class C1345j8 {

    /* renamed from: a */
    public final View f20408a;

    /* renamed from: d */
    public TintInfo f20411d;

    /* renamed from: e */
    public TintInfo f20412e;

    /* renamed from: f */
    public TintInfo f20413f;

    /* renamed from: c */
    public int f20410c = -1;

    /* renamed from: b */
    public final AppCompatDrawableManager f20409b = AppCompatDrawableManager.get();

    public C1345j8(View view) {
        this.f20408a = view;
    }

    /* renamed from: a */
    public final void m5407a() {
        View view = this.f20408a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f20411d != null) {
                if (this.f20413f == null) {
                    this.f20413f = new TintInfo();
                }
                TintInfo tintInfo = this.f20413f;
                tintInfo.mTintList = null;
                tintInfo.mHasTintList = false;
                tintInfo.mTintMode = null;
                tintInfo.mHasTintMode = false;
                ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
                if (backgroundTintList != null) {
                    tintInfo.mHasTintList = true;
                    tintInfo.mTintList = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(view);
                if (backgroundTintMode != null) {
                    tintInfo.mHasTintMode = true;
                    tintInfo.mTintMode = backgroundTintMode;
                }
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    AppCompatDrawableManager.m240a(background, tintInfo, view.getDrawableState());
                    return;
                }
            }
            TintInfo tintInfo2 = this.f20412e;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.m240a(background, tintInfo2, view.getDrawableState());
                return;
            }
            TintInfo tintInfo3 = this.f20411d;
            if (tintInfo3 != null) {
                AppCompatDrawableManager.m240a(background, tintInfo3, view.getDrawableState());
            }
        }
    }

    /* renamed from: b */
    public final ColorStateList m5408b() {
        TintInfo tintInfo = this.f20412e;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* renamed from: c */
    public final PorterDuff.Mode m5409c() {
        TintInfo tintInfo = this.f20412e;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* renamed from: d */
    public final void m5410d(AttributeSet attributeSet, int i) {
        ColorStateList m257e;
        View view = this.f20408a;
        Context context = view.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        View view2 = this.f20408a;
        ViewCompat.saveAttributeDataForStyleable(view2, view2.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i2 = R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f20410c = obtainStyledAttributes.getResourceId(i2, -1);
                AppCompatDrawableManager appCompatDrawableManager = this.f20409b;
                Context context2 = view.getContext();
                int i3 = this.f20410c;
                synchronized (appCompatDrawableManager) {
                    m257e = appCompatDrawableManager.f1149a.m257e(i3, context2);
                }
                if (m257e != null) {
                    m5413g(m257e);
                }
            }
            int i4 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i4)) {
                ViewCompat.setBackgroundTintList(view, obtainStyledAttributes.getColorStateList(i4));
            }
            int i5 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i5)) {
                ViewCompat.setBackgroundTintMode(view, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i5, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e */
    public final void m5411e() {
        this.f20410c = -1;
        m5413g(null);
        m5407a();
    }

    /* renamed from: f */
    public final void m5412f(int i) {
        ColorStateList colorStateList;
        this.f20410c = i;
        AppCompatDrawableManager appCompatDrawableManager = this.f20409b;
        if (appCompatDrawableManager != null) {
            Context context = this.f20408a.getContext();
            synchronized (appCompatDrawableManager) {
                colorStateList = appCompatDrawableManager.f1149a.m257e(i, context);
            }
        } else {
            colorStateList = null;
        }
        m5413g(colorStateList);
        m5407a();
    }

    /* renamed from: g */
    public final void m5413g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f20411d == null) {
                this.f20411d = new TintInfo();
            }
            TintInfo tintInfo = this.f20411d;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.f20411d = null;
        }
        m5407a();
    }

    /* renamed from: h */
    public final void m5414h(ColorStateList colorStateList) {
        if (this.f20412e == null) {
            this.f20412e = new TintInfo();
        }
        TintInfo tintInfo = this.f20412e;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        m5407a();
    }

    /* renamed from: i */
    public final void m5415i(PorterDuff.Mode mode) {
        if (this.f20412e == null) {
            this.f20412e = new TintInfo();
        }
        TintInfo tintInfo = this.f20412e;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        m5407a();
    }
}
