package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class SeekBar extends View {

    /* renamed from: a */
    public final RectF f6172a;

    /* renamed from: b */
    public final RectF f6173b;

    /* renamed from: c */
    public final RectF f6174c;

    /* renamed from: d */
    public final Paint f6175d;

    /* renamed from: e */
    public final Paint f6176e;

    /* renamed from: f */
    public final Paint f6177f;

    /* renamed from: g */
    public final Paint f6178g;

    /* renamed from: h */
    public int f6179h;

    /* renamed from: i */
    public int f6180i;

    /* renamed from: j */
    public int f6181j;

    /* renamed from: k */
    public int f6182k;

    /* renamed from: l */
    public int f6183l;

    /* renamed from: m */
    public int f6184m;

    /* renamed from: n */
    public int f6185n;

    /* renamed from: o */
    public AccessibilitySeekListener f6186o;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static abstract class AccessibilitySeekListener {
        public abstract boolean onAccessibilitySeekBackward();

        public abstract boolean onAccessibilitySeekForward();
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6172a = new RectF();
        this.f6173b = new RectF();
        this.f6174c = new RectF();
        Paint paint = new Paint(1);
        this.f6175d = paint;
        Paint paint2 = new Paint(1);
        this.f6176e = paint2;
        Paint paint3 = new Paint(1);
        this.f6177f = paint3;
        Paint paint4 = new Paint(1);
        this.f6178g = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint4.setColor(-1);
        this.f6184m = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_bar_height);
        this.f6185n = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.f6183l = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    /* renamed from: a */
    public final void m1486a() {
        int i;
        int i2;
        if (isFocused()) {
            i = this.f6185n;
        } else {
            i = this.f6184m;
        }
        int width = getWidth();
        int height = getHeight();
        int i3 = (height - i) / 2;
        RectF rectF = this.f6174c;
        int i4 = this.f6184m;
        float f = i3;
        float f2 = height - i3;
        rectF.set(i4 / 2, f, width - (i4 / 2), f2);
        if (isFocused()) {
            i2 = this.f6183l;
        } else {
            i2 = this.f6184m / 2;
        }
        float f3 = width - (i2 * 2);
        float f4 = (this.f6179h / this.f6181j) * f3;
        RectF rectF2 = this.f6172a;
        int i5 = this.f6184m;
        rectF2.set(i5 / 2, f, (i5 / 2) + f4, f2);
        this.f6173b.set(rectF2.right, f, (this.f6184m / 2) + ((this.f6180i / this.f6181j) * f3), f2);
        this.f6182k = i2 + ((int) f4);
        invalidate();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.f6181j;
    }

    public int getProgress() {
        return this.f6179h;
    }

    public int getSecondProgress() {
        return this.f6180i;
    }

    public int getSecondaryProgressColor() {
        return this.f6175d.getColor();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isFocused()) {
            i = this.f6183l;
        } else {
            i = this.f6184m / 2;
        }
        float f = i;
        canvas.drawRoundRect(this.f6174c, f, f, this.f6177f);
        RectF rectF = this.f6173b;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f, f, this.f6175d);
        }
        canvas.drawRoundRect(this.f6172a, f, f, this.f6176e);
        canvas.drawCircle(this.f6182k, getHeight() / 2, f, this.f6178g);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        m1486a();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m1486a();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        AccessibilitySeekListener accessibilitySeekListener = this.f6186o;
        if (accessibilitySeekListener != null) {
            if (i != 4096) {
                if (i == 8192) {
                    return accessibilitySeekListener.onAccessibilitySeekBackward();
                }
            } else {
                return accessibilitySeekListener.onAccessibilitySeekForward();
            }
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public void setAccessibilitySeekListener(AccessibilitySeekListener accessibilitySeekListener) {
        this.f6186o = accessibilitySeekListener;
    }

    public void setActiveBarHeight(int i) {
        this.f6185n = i;
        m1486a();
    }

    public void setActiveRadius(int i) {
        this.f6183l = i;
        m1486a();
    }

    public void setBarHeight(int i) {
        this.f6184m = i;
        m1486a();
    }

    public void setMax(int i) {
        this.f6181j = i;
        m1486a();
    }

    public void setProgress(int i) {
        int i2 = this.f6181j;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.f6179h = i;
        m1486a();
    }

    public void setProgressColor(int i) {
        this.f6176e.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.f6181j;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.f6180i = i;
        m1486a();
    }

    public void setSecondaryProgressColor(int i) {
        this.f6175d.setColor(i);
    }
}
