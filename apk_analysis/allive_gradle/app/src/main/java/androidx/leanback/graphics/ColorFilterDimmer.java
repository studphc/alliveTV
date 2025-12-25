package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ColorFilterDimmer {

    /* renamed from: a */
    public final ColorFilterCache f5358a;

    /* renamed from: b */
    public final float f5359b;

    /* renamed from: c */
    public final float f5360c;

    /* renamed from: d */
    public final Paint f5361d;

    /* renamed from: e */
    public ColorFilter f5362e;

    public ColorFilterDimmer(ColorFilterCache colorFilterCache, float f, float f2) {
        this.f5358a = colorFilterCache;
        f = f > 1.0f ? 1.0f : f;
        float f3 = RecyclerView.f7068F0;
        f = f < RecyclerView.f7068F0 ? 0.0f : f;
        f2 = f2 > 1.0f ? 1.0f : f2;
        f3 = f2 >= RecyclerView.f7068F0 ? f2 : f3;
        this.f5359b = f;
        this.f5360c = f3;
        this.f5361d = new Paint();
    }

    public static ColorFilterDimmer create(ColorFilterCache colorFilterCache, float f, float f2) {
        return new ColorFilterDimmer(colorFilterCache, f, f2);
    }

    public static ColorFilterDimmer createDefault(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = obtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        obtainStyledAttributes.recycle();
        return new ColorFilterDimmer(ColorFilterCache.getColorFilterCache(color), fraction, fraction2);
    }

    public void applyFilterToView(View view) {
        if (this.f5362e != null) {
            view.setLayerType(2, this.f5361d);
        } else {
            view.setLayerType(0, null);
        }
        view.invalidate();
    }

    public ColorFilter getColorFilter() {
        return this.f5362e;
    }

    public Paint getPaint() {
        return this.f5361d;
    }

    public void setActiveLevel(float f) {
        if (f < RecyclerView.f7068F0) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f2 = this.f5359b;
        float f3 = this.f5360c;
        ColorFilter filterForLevel = this.f5358a.getFilterForLevel(((f2 - f3) * f) + f3);
        this.f5362e = filterForLevel;
        this.f5361d.setColorFilter(filterForLevel);
    }
}
