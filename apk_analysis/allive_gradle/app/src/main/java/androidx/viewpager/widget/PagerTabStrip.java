package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import p000.v12;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: A */
    public boolean f7584A;

    /* renamed from: B */
    public final int f7585B;

    /* renamed from: C */
    public boolean f7586C;

    /* renamed from: D */
    public float f7587D;

    /* renamed from: E */
    public float f7588E;

    /* renamed from: F */
    public final int f7589F;

    /* renamed from: q */
    public int f7590q;

    /* renamed from: r */
    public final int f7591r;

    /* renamed from: s */
    public final int f7592s;

    /* renamed from: t */
    public final int f7593t;

    /* renamed from: u */
    public final int f7594u;

    /* renamed from: v */
    public final int f7595v;

    /* renamed from: w */
    public final Paint f7596w;

    /* renamed from: x */
    public final Rect f7597x;

    /* renamed from: y */
    public int f7598y;

    /* renamed from: z */
    public boolean f7599z;

    public PagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    /* renamed from: c */
    public final void mo1928c(int i, boolean z, float f) {
        int height = getHeight();
        TextView textView = this.f7604c;
        int left = textView.getLeft();
        int i2 = this.f7595v;
        int right = textView.getRight() + i2;
        int i3 = height - this.f7591r;
        Rect rect = this.f7597x;
        rect.set(left - i2, i3, right, height);
        super.mo1928c(i, z, f);
        this.f7598y = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(textView.getLeft() - i2, i3, textView.getRight() + i2, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f7599z;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f7594u);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f7590q;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        TextView textView = this.f7604c;
        int left = textView.getLeft();
        int i = this.f7595v;
        int i2 = left - i;
        int right = textView.getRight() + i;
        int i3 = height - this.f7591r;
        Paint paint = this.f7596w;
        paint.setColor((this.f7598y << 24) | (this.f7590q & ViewCompat.MEASURED_SIZE_MASK));
        float f = right;
        float f2 = height;
        canvas.drawRect(i2, i3, f, f2, paint);
        if (this.f7599z) {
            paint.setColor((this.f7590q & ViewCompat.MEASURED_SIZE_MASK) | ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(getPaddingLeft(), height - this.f7585B, getWidth() - getPaddingRight(), f2, paint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f7586C) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float abs = Math.abs(x - this.f7587D);
                    float f = this.f7589F;
                    if (abs > f || Math.abs(y - this.f7588E) > f) {
                        this.f7586C = true;
                    }
                }
            } else {
                int left = this.f7604c.getLeft();
                int i = this.f7595v;
                if (x < left - i) {
                    ViewPager viewPager = this.f7602a;
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                } else if (x > r5.getRight() + i) {
                    ViewPager viewPager2 = this.f7602a;
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }
            }
        } else {
            this.f7587D = x;
            this.f7588E = y;
            this.f7586C = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        boolean z;
        super.setBackgroundColor(i);
        if (!this.f7584A) {
            if ((i & ViewCompat.MEASURED_STATE_MASK) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f7599z = z;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z;
        super.setBackgroundDrawable(drawable);
        if (!this.f7584A) {
            if (drawable == null) {
                z = true;
            } else {
                z = false;
            }
            this.f7599z = z;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        boolean z;
        super.setBackgroundResource(i);
        if (!this.f7584A) {
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f7599z = z;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f7599z = z;
        this.f7584A = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.f7592s;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.f7590q = i;
        this.f7596w.setColor(i);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        int i2 = this.f7593t;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f7596w = paint;
        this.f7597x = new Rect();
        this.f7598y = 255;
        this.f7599z = false;
        this.f7584A = false;
        int i = this.f7615n;
        this.f7590q = i;
        paint.setColor(i);
        float f = context.getResources().getDisplayMetrics().density;
        this.f7591r = (int) ((3.0f * f) + 0.5f);
        this.f7592s = (int) ((6.0f * f) + 0.5f);
        this.f7593t = (int) (64.0f * f);
        this.f7595v = (int) ((16.0f * f) + 0.5f);
        this.f7585B = (int) ((1.0f * f) + 0.5f);
        this.f7594u = (int) ((f * 32.0f) + 0.5f);
        this.f7589F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f7603b.setFocusable(true);
        this.f7603b.setOnClickListener(new v12(this, 0));
        this.f7605d.setFocusable(true);
        this.f7605d.setOnClickListener(new v12(this, 1));
        if (getBackground() == null) {
            this.f7599z = true;
        }
    }
}
