package androidx.leanback.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PagingIndicator extends View {

    /* renamed from: A */
    public static final DecelerateInterpolator f5930A = new DecelerateInterpolator();

    /* renamed from: B */
    public static final C0378q1 f5931B = new Property(Float.class, "alpha");

    /* renamed from: C */
    public static final C0381r1 f5932C = new Property(Float.class, "diameter");

    /* renamed from: D */
    public static final C0385s1 f5933D = new Property(Float.class, "translation_x");

    /* renamed from: a */
    public boolean f5934a;

    /* renamed from: b */
    public final int f5935b;

    /* renamed from: c */
    public final int f5936c;

    /* renamed from: d */
    public final int f5937d;

    /* renamed from: e */
    public final int f5938e;

    /* renamed from: f */
    public final int f5939f;

    /* renamed from: g */
    public final int f5940g;

    /* renamed from: h */
    public final int f5941h;

    /* renamed from: i */
    public Dot[] f5942i;

    /* renamed from: j */
    public int[] f5943j;

    /* renamed from: k */
    public int[] f5944k;

    /* renamed from: l */
    public int[] f5945l;

    /* renamed from: m */
    public int f5946m;

    /* renamed from: n */
    public int f5947n;

    /* renamed from: o */
    public int f5948o;

    /* renamed from: p */
    public int f5949p;

    /* renamed from: q */
    public int f5950q;

    /* renamed from: r */
    public final Paint f5951r;

    /* renamed from: s */
    public final Paint f5952s;

    /* renamed from: t */
    public final AnimatorSet f5953t;

    /* renamed from: u */
    public final AnimatorSet f5954u;

    /* renamed from: v */
    public final AnimatorSet f5955v;

    /* renamed from: w */
    public Bitmap f5956w;

    /* renamed from: x */
    public Paint f5957x;

    /* renamed from: y */
    public final Rect f5958y;

    /* renamed from: z */
    public final float f5959z;

    /* loaded from: classes.dex */
    public class Dot {

        /* renamed from: a */
        public float f5960a;

        /* renamed from: b */
        public int f5961b;

        /* renamed from: c */
        public float f5962c;

        /* renamed from: d */
        public float f5963d;

        /* renamed from: e */
        public float f5964e;

        /* renamed from: f */
        public float f5965f;

        /* renamed from: g */
        public float f5966g;

        /* renamed from: h */
        public float f5967h = 1.0f;

        /* renamed from: i */
        public float f5968i;

        public Dot() {
            this.f5968i = PagingIndicator.this.f5934a ? 1.0f : -1.0f;
        }

        /* renamed from: a */
        public final void m1456a() {
            this.f5962c = RecyclerView.f7068F0;
            this.f5963d = RecyclerView.f7068F0;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.f5964e = pagingIndicator.f5935b;
            float f = pagingIndicator.f5936c;
            this.f5965f = f;
            this.f5966g = f * pagingIndicator.f5959z;
            this.f5960a = RecyclerView.f7068F0;
            adjustAlpha();
        }

        public void adjustAlpha() {
            int round = Math.round(this.f5960a * 255.0f);
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.f5961b = Color.argb(round, Color.red(pagingIndicator.f5950q), Color.green(pagingIndicator.f5950q), Color.blue(pagingIndicator.f5950q));
        }

        public float getAlpha() {
            return this.f5960a;
        }

        public float getDiameter() {
            return this.f5964e;
        }

        public float getTranslationX() {
            return this.f5962c;
        }

        public void setAlpha(float f) {
            this.f5960a = f;
            adjustAlpha();
            PagingIndicator.this.invalidate();
        }

        public void setDiameter(float f) {
            this.f5964e = f;
            float f2 = f / 2.0f;
            this.f5965f = f2;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.f5966g = f2 * pagingIndicator.f5959z;
            pagingIndicator.invalidate();
        }

        public void setTranslationX(float f) {
            this.f5962c = f * this.f5967h * this.f5968i;
            PagingIndicator.this.invalidate();
        }
    }

    public PagingIndicator(Context context) {
        this(context, null, 0);
    }

    private int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + this.f5938e + this.f5941h;
    }

    private int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getRequiredWidth();
    }

    private int getRequiredWidth() {
        return ((this.f5947n - 3) * this.f5937d) + (this.f5940g * 2) + (this.f5936c * 2);
    }

    private void setSelectedPage(int i) {
        if (i == this.f5948o) {
            return;
        }
        this.f5948o = i;
        m1452a();
    }

    /* renamed from: a */
    public final void m1452a() {
        int i;
        float f;
        int i2 = 0;
        while (true) {
            i = this.f5948o;
            f = -1.0f;
            if (i2 >= i) {
                break;
            }
            this.f5942i[i2].m1456a();
            Dot dot = this.f5942i[i2];
            if (i2 != this.f5949p) {
                f = 1.0f;
            }
            dot.f5967h = f;
            dot.f5963d = this.f5944k[i2];
            i2++;
        }
        Dot dot2 = this.f5942i[i];
        dot2.f5962c = RecyclerView.f7068F0;
        dot2.f5963d = RecyclerView.f7068F0;
        PagingIndicator pagingIndicator = PagingIndicator.this;
        dot2.f5964e = pagingIndicator.f5938e;
        float f2 = pagingIndicator.f5939f;
        dot2.f5965f = f2;
        dot2.f5966g = f2 * pagingIndicator.f5959z;
        dot2.f5960a = 1.0f;
        dot2.adjustAlpha();
        Dot[] dotArr = this.f5942i;
        int i3 = this.f5948o;
        Dot dot3 = dotArr[i3];
        if (this.f5949p >= i3) {
            f = 1.0f;
        }
        dot3.f5967h = f;
        dot3.f5963d = this.f5943j[i3];
        while (true) {
            i3++;
            if (i3 < this.f5947n) {
                this.f5942i[i3].m1456a();
                Dot dot4 = this.f5942i[i3];
                dot4.f5967h = 1.0f;
                dot4.f5963d = this.f5945l[i3];
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m1453b() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i = (paddingLeft + width) / 2;
        int i2 = this.f5947n;
        int[] iArr = new int[i2];
        this.f5943j = iArr;
        int[] iArr2 = new int[i2];
        this.f5944k = iArr2;
        int[] iArr3 = new int[i2];
        this.f5945l = iArr3;
        boolean z = this.f5934a;
        int i3 = this.f5936c;
        int i4 = this.f5940g;
        int i5 = this.f5937d;
        int i6 = 1;
        if (z) {
            int i7 = i - (requiredWidth / 2);
            iArr[0] = ((i7 + i3) - i5) + i4;
            iArr2[0] = i7 + i3;
            iArr3[0] = (i4 * 2) + ((i7 + i3) - (i5 * 2));
            while (i6 < this.f5947n) {
                int[] iArr4 = this.f5943j;
                int[] iArr5 = this.f5944k;
                int i8 = i6 - 1;
                iArr4[i6] = iArr5[i8] + i4;
                iArr5[i6] = iArr5[i8] + i5;
                this.f5945l[i6] = iArr4[i8] + i4;
                i6++;
            }
        } else {
            int i9 = (requiredWidth / 2) + i;
            iArr[0] = ((i9 - i3) + i5) - i4;
            iArr2[0] = i9 - i3;
            iArr3[0] = ((i5 * 2) + (i9 - i3)) - (i4 * 2);
            while (i6 < this.f5947n) {
                int[] iArr6 = this.f5943j;
                int[] iArr7 = this.f5944k;
                int i10 = i6 - 1;
                iArr6[i6] = iArr7[i10] - i4;
                iArr7[i6] = iArr7[i10] - i5;
                this.f5945l[i6] = iArr6[i10] - i4;
                i6++;
            }
        }
        this.f5946m = paddingTop + this.f5939f;
        m1452a();
    }

    /* renamed from: c */
    public final ObjectAnimator m1454c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, f5933D, (-this.f5940g) + this.f5937d, RecyclerView.f7068F0);
        ofFloat.setDuration(417L);
        ofFloat.setInterpolator(f5930A);
        return ofFloat;
    }

    /* renamed from: d */
    public final Bitmap m1455d() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), androidx.leanback.R.drawable.lb_ic_nav_arrow);
        if (this.f5934a) {
            return decodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
    }

    @VisibleForTesting
    public int[] getDotSelectedLeftX() {
        return this.f5944k;
    }

    @VisibleForTesting
    public int[] getDotSelectedRightX() {
        return this.f5945l;
    }

    @VisibleForTesting
    public int[] getDotSelectedX() {
        return this.f5943j;
    }

    @VisibleForTesting
    public int getPageCount() {
        return this.f5947n;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        for (int i = 0; i < this.f5947n; i++) {
            Dot dot = this.f5942i[i];
            float f = dot.f5963d + dot.f5962c;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            canvas.drawCircle(f, pagingIndicator.f5946m, dot.f5965f, pagingIndicator.f5951r);
            if (dot.f5960a > RecyclerView.f7068F0) {
                Paint paint = pagingIndicator.f5952s;
                paint.setColor(dot.f5961b);
                canvas.drawCircle(f, pagingIndicator.f5946m, dot.f5965f, paint);
                Bitmap bitmap = pagingIndicator.f5956w;
                float f2 = dot.f5966g;
                float f3 = pagingIndicator.f5946m;
                canvas.drawBitmap(bitmap, pagingIndicator.f5958y, new Rect((int) (f - f2), (int) (f3 - f2), (int) (f + f2), (int) (f3 + f2)), pagingIndicator.f5957x);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                desiredHeight = View.MeasureSpec.getSize(i2);
            }
        } else {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i2));
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 1073741824) {
                desiredWidth = View.MeasureSpec.getSize(i);
            }
        } else {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i));
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    public void onPageSelected(int i, boolean z) {
        if (this.f5948o == i) {
            return;
        }
        AnimatorSet animatorSet = this.f5955v;
        if (animatorSet.isStarted()) {
            animatorSet.end();
        }
        int i2 = this.f5948o;
        this.f5949p = i2;
        if (z) {
            this.f5954u.setTarget(this.f5942i[i2]);
            this.f5953t.setTarget(this.f5942i[i]);
            animatorSet.start();
        }
        setSelectedPage(i);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        boolean z;
        float f;
        super.onRtlPropertiesChanged(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f5934a != z) {
            this.f5934a = z;
            this.f5956w = m1455d();
            Dot[] dotArr = this.f5942i;
            if (dotArr != null) {
                for (Dot dot : dotArr) {
                    if (PagingIndicator.this.f5934a) {
                        f = 1.0f;
                    } else {
                        f = -1.0f;
                    }
                    dot.f5968i = f;
                }
            }
            m1453b();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        setMeasuredDimension(i, i2);
        m1453b();
    }

    public void setArrowBackgroundColor(@ColorInt int i) {
        this.f5950q = i;
    }

    public void setArrowColor(@ColorInt int i) {
        if (this.f5957x == null) {
            this.f5957x = new Paint();
        }
        this.f5957x.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(@ColorInt int i) {
        this.f5951r.setColor(i);
    }

    public void setPageCount(int i) {
        if (i > 0) {
            this.f5947n = i;
            this.f5942i = new Dot[i];
            for (int i2 = 0; i2 < this.f5947n; i2++) {
                this.f5942i[i2] = new Dot();
            }
            m1453b();
            setSelectedPage(0);
            return;
        }
        throw new IllegalArgumentException("The page count should be a positive integer");
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5955v = animatorSet;
        Resources resources = getResources();
        int[] iArr = androidx.leanback.R.styleable.PagingIndicator;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.PagingIndicator_lbDotRadius, getResources().getDimensionPixelOffset(androidx.leanback.R.dimen.lb_page_indicator_dot_radius));
        this.f5936c = dimensionPixelOffset;
        int i2 = dimensionPixelOffset * 2;
        this.f5935b = i2;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.PagingIndicator_arrowRadius, getResources().getDimensionPixelOffset(androidx.leanback.R.dimen.lb_page_indicator_arrow_radius));
        this.f5939f = dimensionPixelOffset2;
        int i3 = dimensionPixelOffset2 * 2;
        this.f5938e = i3;
        this.f5937d = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.PagingIndicator_dotToDotGap, getResources().getDimensionPixelOffset(androidx.leanback.R.dimen.lb_page_indicator_dot_gap));
        this.f5940g = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.PagingIndicator_dotToArrowGap, getResources().getDimensionPixelOffset(androidx.leanback.R.dimen.lb_page_indicator_arrow_gap));
        int color = obtainStyledAttributes.getColor(androidx.leanback.R.styleable.PagingIndicator_dotBgColor, getResources().getColor(androidx.leanback.R.color.lb_page_indicator_dot));
        Paint paint = new Paint(1);
        this.f5951r = paint;
        paint.setColor(color);
        this.f5950q = obtainStyledAttributes.getColor(androidx.leanback.R.styleable.PagingIndicator_arrowBgColor, getResources().getColor(androidx.leanback.R.color.lb_page_indicator_arrow_background));
        if (this.f5957x == null) {
            int i4 = androidx.leanback.R.styleable.PagingIndicator_arrowColor;
            if (obtainStyledAttributes.hasValue(i4)) {
                setArrowColor(obtainStyledAttributes.getColor(i4, 0));
            }
        }
        obtainStyledAttributes.recycle();
        this.f5934a = resources.getConfiguration().getLayoutDirection() == 0;
        int color2 = resources.getColor(androidx.leanback.R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.f5941h = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.f5952s = paint2;
        float dimensionPixelSize2 = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color2);
        this.f5956w = m1455d();
        this.f5958y = new Rect(0, 0, this.f5956w.getWidth(), this.f5956w.getHeight());
        float f = i3;
        this.f5959z = this.f5956w.getWidth() / f;
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f5953t = animatorSet2;
        float[] fArr = {RecyclerView.f7068F0, 1.0f};
        C0378q1 c0378q1 = f5931B;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, c0378q1, fArr);
        ofFloat.setDuration(167L);
        DecelerateInterpolator decelerateInterpolator = f5930A;
        ofFloat.setInterpolator(decelerateInterpolator);
        float f2 = i2;
        C0381r1 c0381r1 = f5932C;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((Object) null, c0381r1, f2, f);
        ofFloat2.setDuration(417L);
        ofFloat2.setInterpolator(decelerateInterpolator);
        animatorSet2.playTogether(ofFloat, ofFloat2, m1454c());
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f5954u = animatorSet3;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((Object) null, c0378q1, 1.0f, RecyclerView.f7068F0);
        ofFloat3.setDuration(167L);
        ofFloat3.setInterpolator(decelerateInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((Object) null, c0381r1, f, f2);
        ofFloat4.setDuration(417L);
        ofFloat4.setInterpolator(decelerateInterpolator);
        animatorSet3.playTogether(ofFloat3, ofFloat4, m1454c());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        setLayerType(1, null);
    }
}
