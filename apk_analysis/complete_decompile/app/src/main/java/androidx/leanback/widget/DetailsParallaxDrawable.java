package androidx.leanback.widget;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.leanback.graphics.CompositeDrawable;
import androidx.leanback.graphics.FitWidthBitmapDrawable;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxTarget;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DetailsParallaxDrawable extends CompositeDrawable {

    /* renamed from: c */
    public Drawable f5642c;

    public DetailsParallaxDrawable(@NonNull Context context, @NonNull DetailsParallax detailsParallax, @NonNull Drawable drawable, @NonNull ParallaxTarget parallaxTarget) {
        m1392a(context, detailsParallax, drawable, new ColorDrawable(), parallaxTarget);
    }

    /* renamed from: a */
    public final void m1392a(Context context, DetailsParallax detailsParallax, Drawable drawable, Drawable drawable2, ParallaxTarget parallaxTarget) {
        int color;
        if (drawable2 instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable2;
            if (colorDrawable.getColor() == 0) {
                TypedValue typedValue = new TypedValue();
                if (context.getTheme().resolveAttribute(androidx.leanback.R.attr.defaultBrandColorDark, typedValue, true)) {
                    color = context.getResources().getColor(typedValue.resourceId);
                } else {
                    color = context.getResources().getColor(androidx.leanback.R.color.lb_default_brand_color_dark);
                }
                colorDrawable.setColor(color);
            }
        }
        addChildDrawable(drawable);
        this.f5642c = drawable2;
        addChildDrawable(drawable2);
        Parallax.IntProperty overviewRowTop = detailsParallax.getOverviewRowTop();
        Parallax.IntProperty overviewRowBottom = detailsParallax.getOverviewRowBottom();
        detailsParallax.addEffect(overviewRowTop.atAbsolute(context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_align_pos_for_actions)), overviewRowTop.atAbsolute(context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_align_pos_for_description))).target(parallaxTarget);
        detailsParallax.addEffect(overviewRowBottom.atMax(), overviewRowBottom.atMin()).target((ParallaxEffect) getChildAt(1), (Property<ParallaxEffect, V>) CompositeDrawable.ChildDrawable.TOP_ABSOLUTE);
        detailsParallax.addEffect(overviewRowTop.atMax(), overviewRowTop.atMin()).target((ParallaxEffect) getChildAt(0), (Property<ParallaxEffect, V>) CompositeDrawable.ChildDrawable.BOTTOM_ABSOLUTE);
    }

    @NonNull
    public Drawable getBottomDrawable() {
        return this.f5642c;
    }

    @NonNull
    public Drawable getCoverDrawable() {
        return getChildAt(0).getDrawable();
    }

    @ColorInt
    public int getSolidColor() {
        return ((ColorDrawable) this.f5642c).getColor();
    }

    public void setSolidColor(@ColorInt int i) {
        ((ColorDrawable) this.f5642c).setColor(i);
    }

    public DetailsParallaxDrawable(@NonNull Context context, @NonNull DetailsParallax detailsParallax, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull ParallaxTarget parallaxTarget) {
        m1392a(context, detailsParallax, drawable, drawable2, parallaxTarget);
    }

    public DetailsParallaxDrawable(@NonNull Context context, @NonNull DetailsParallax detailsParallax) {
        int i = -context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_cover_drawable_parallax_movement);
        FitWidthBitmapDrawable fitWidthBitmapDrawable = new FitWidthBitmapDrawable();
        m1392a(context, detailsParallax, fitWidthBitmapDrawable, new ColorDrawable(), new ParallaxTarget.PropertyValuesHolderTarget(fitWidthBitmapDrawable, PropertyValuesHolder.ofInt("verticalOffset", 0, i)));
    }
}
