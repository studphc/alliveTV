package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;
import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class ColorOverlayDimmer {

    /* renamed from: a */
    public final float f5363a;

    /* renamed from: b */
    public final float f5364b;

    /* renamed from: c */
    public final Paint f5365c;

    /* renamed from: d */
    public int f5366d;

    /* renamed from: e */
    public float f5367e;

    public ColorOverlayDimmer(int i, float f, float f2) {
        f = f > 1.0f ? 1.0f : f;
        float f3 = RecyclerView.f7068F0;
        f = f < RecyclerView.f7068F0 ? 0.0f : f;
        f2 = f2 > 1.0f ? 1.0f : f2;
        f3 = f2 >= RecyclerView.f7068F0 ? f2 : f3;
        Paint paint = new Paint();
        this.f5365c = paint;
        paint.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.f5363a = f;
        this.f5364b = f3;
        setActiveLevel(1.0f);
    }

    public static ColorOverlayDimmer createColorOverlayDimmer(int i, float f, float f2) {
        return new ColorOverlayDimmer(i, f, f2);
    }

    public static ColorOverlayDimmer createDefault(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = obtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        obtainStyledAttributes.recycle();
        return new ColorOverlayDimmer(color, fraction, fraction2);
    }

    public int applyToColor(int i) {
        float f = 1.0f - this.f5367e;
        return Color.argb(Color.alpha(i), (int) (Color.red(i) * f), (int) (Color.green(i) * f), (int) (Color.blue(i) * f));
    }

    public void drawColorOverlay(Canvas canvas, View view, boolean z) {
        canvas.save();
        float translationX = view.getTranslationX() + view.getLeft();
        float translationY = view.getTranslationY() + view.getTop();
        canvas.translate(translationX, translationY);
        canvas.concat(view.getMatrix());
        canvas.translate(-translationX, -translationY);
        Paint paint = this.f5365c;
        if (z) {
            canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), paint);
        } else {
            canvas.drawRect(view.getPaddingLeft() + view.getLeft(), view.getPaddingTop() + view.getTop(), view.getRight() - view.getPaddingRight(), view.getBottom() - view.getPaddingBottom(), paint);
        }
        canvas.restore();
    }

    public int getAlpha() {
        return this.f5366d;
    }

    public float getAlphaFloat() {
        return this.f5367e;
    }

    public Paint getPaint() {
        return this.f5365c;
    }

    public boolean needsDraw() {
        if (this.f5366d != 0) {
            return true;
        }
        return false;
    }

    public void setActiveLevel(float f) {
        float f2 = this.f5363a;
        float f3 = this.f5364b;
        float m7051g = AbstractC1726qj.m7051g(f2, f3, f, f3);
        this.f5367e = m7051g;
        int i = (int) (m7051g * 255.0f);
        this.f5366d = i;
        this.f5365c.setAlpha(i);
    }
}
