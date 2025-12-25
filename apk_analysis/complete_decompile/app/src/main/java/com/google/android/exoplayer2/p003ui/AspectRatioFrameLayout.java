package com.google.android.exoplayer2.p003ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;

    /* renamed from: a */
    public final RunnableC0719a f12001a;

    /* renamed from: b */
    public AspectRatioListener f12002b;

    /* renamed from: c */
    public float f12003c;

    /* renamed from: d */
    public int f12004d;

    /* loaded from: classes.dex */
    public interface AspectRatioListener {
        void onAspectRatioUpdated(float f, float f2, boolean z);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ResizeMode {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.f12004d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.f12003c <= RecyclerView.f7068F0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        float f5 = f3 / f4;
        float f6 = (this.f12003c / f5) - 1.0f;
        float abs = Math.abs(f6);
        RunnableC0719a runnableC0719a = this.f12001a;
        if (abs <= 0.01f) {
            runnableC0719a.f12324a = this.f12003c;
            runnableC0719a.f12325b = f5;
            runnableC0719a.f12326c = false;
            if (!runnableC0719a.f12327d) {
                runnableC0719a.f12327d = true;
                runnableC0719a.f12328e.post(runnableC0719a);
                return;
            }
            return;
        }
        int i3 = this.f12004d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        if (f6 > RecyclerView.f7068F0) {
                            f = this.f12003c;
                        } else {
                            f2 = this.f12003c;
                        }
                    }
                } else {
                    f = this.f12003c;
                }
                measuredWidth = (int) (f4 * f);
            } else {
                f2 = this.f12003c;
            }
            measuredHeight = (int) (f3 / f2);
        } else if (f6 > RecyclerView.f7068F0) {
            f2 = this.f12003c;
            measuredHeight = (int) (f3 / f2);
        } else {
            f = this.f12003c;
            measuredWidth = (int) (f4 * f);
        }
        runnableC0719a.f12324a = this.f12003c;
        runnableC0719a.f12325b = f5;
        runnableC0719a.f12326c = true;
        if (!runnableC0719a.f12327d) {
            runnableC0719a.f12327d = true;
            runnableC0719a.f12328e.post(runnableC0719a);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f) {
        if (this.f12003c != f) {
            this.f12003c = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioListener aspectRatioListener) {
        this.f12002b = aspectRatioListener;
    }

    public void setResizeMode(int i) {
        if (this.f12004d != i) {
            this.f12004d = i;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12004d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f12004d = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f12001a = new RunnableC0719a(this);
    }
}
