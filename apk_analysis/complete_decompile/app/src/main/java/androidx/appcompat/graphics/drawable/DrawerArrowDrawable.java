package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;

    /* renamed from: m */
    public static final float f765m = (float) Math.toRadians(45.0d);

    /* renamed from: a */
    public final Paint f766a;

    /* renamed from: b */
    public float f767b;

    /* renamed from: c */
    public float f768c;

    /* renamed from: d */
    public float f769d;

    /* renamed from: e */
    public float f770e;

    /* renamed from: f */
    public boolean f771f;

    /* renamed from: g */
    public final Path f772g;

    /* renamed from: h */
    public final int f773h;

    /* renamed from: i */
    public boolean f774i;

    /* renamed from: j */
    public float f775j;

    /* renamed from: k */
    public float f776k;

    /* renamed from: l */
    public int f777l;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f766a = paint;
        this.f772g = new Path();
        this.f774i = false;
        this.f777l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, RecyclerView.f7068F0));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, RecyclerView.f7068F0)));
        this.f773h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f768c = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, RecyclerView.f7068F0));
        this.f767b = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, RecyclerView.f7068F0));
        this.f769d = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, RecyclerView.f7068F0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public static float m203a(float f, float f2, float f3) {
        return AbstractC1726qj.m7051g(f2, f, f3, f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        float f2;
        int i;
        Rect bounds = getBounds();
        int i2 = this.f777l;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f3 = this.f767b;
        float m203a = m203a(this.f768c, (float) Math.sqrt(f3 * f3 * 2.0f), this.f775j);
        float m203a2 = m203a(this.f768c, this.f769d, this.f775j);
        float round = Math.round(m203a(RecyclerView.f7068F0, this.f776k, this.f775j));
        float m203a3 = m203a(RecyclerView.f7068F0, f765m, this.f775j);
        if (z) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (z) {
            f2 = 180.0f;
        } else {
            f2 = 0.0f;
        }
        float m203a4 = m203a(f, f2, this.f775j);
        double d = m203a;
        double d2 = m203a3;
        boolean z2 = z;
        float round2 = (float) Math.round(Math.cos(d2) * d);
        float round3 = (float) Math.round(Math.sin(d2) * d);
        Path path = this.f772g;
        path.rewind();
        float f4 = this.f770e;
        Paint paint = this.f766a;
        float m203a5 = m203a(paint.getStrokeWidth() + f4, -this.f776k, this.f775j);
        float f5 = (-m203a2) / 2.0f;
        path.moveTo(f5 + round, RecyclerView.f7068F0);
        path.rLineTo(m203a2 - (round * 2.0f), RecyclerView.f7068F0);
        path.moveTo(f5, m203a5);
        path.rLineTo(round2, round3);
        path.moveTo(f5, -m203a5);
        path.rLineTo(round2, -round3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        float f6 = this.f770e;
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + f6 + ((((int) (height - (2.0f * f6))) / 4) * 2));
        if (this.f771f) {
            if (this.f774i ^ z2) {
                i = -1;
            } else {
                i = 1;
            }
            canvas.rotate(m203a4 * i);
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.f767b;
    }

    public float getArrowShaftLength() {
        return this.f769d;
    }

    public float getBarLength() {
        return this.f768c;
    }

    public float getBarThickness() {
        return this.f766a.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.f766a.getColor();
    }

    public int getDirection() {
        return this.f777l;
    }

    public float getGapSize() {
        return this.f770e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f773h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f773h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.f766a;
    }

    @FloatRange(from = 0.0d, m152to = 1.0d)
    public float getProgress() {
        return this.f775j;
    }

    public boolean isSpinEnabled() {
        return this.f771f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.f766a;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f) {
        if (this.f767b != f) {
            this.f767b = f;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f) {
        if (this.f769d != f) {
            this.f769d = f;
            invalidateSelf();
        }
    }

    public void setBarLength(float f) {
        if (this.f768c != f) {
            this.f768c = f;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f) {
        Paint paint = this.f766a;
        if (paint.getStrokeWidth() != f) {
            paint.setStrokeWidth(f);
            this.f776k = (float) (Math.cos(f765m) * (f / 2.0f));
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i) {
        Paint paint = this.f766a;
        if (i != paint.getColor()) {
            paint.setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f766a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i) {
        if (i != this.f777l) {
            this.f777l = i;
            invalidateSelf();
        }
    }

    public void setGapSize(float f) {
        if (f != this.f770e) {
            this.f770e = f;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        if (this.f775j != f) {
            this.f775j = f;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.f771f != z) {
            this.f771f = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.f774i != z) {
            this.f774i = z;
            invalidateSelf();
        }
    }
}
