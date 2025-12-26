package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* renamed from: e8 */
/* loaded from: classes.dex */
public final class C1149e8 extends Drawable.ConstantState {

    /* renamed from: a */
    public final Drawable.ConstantState f16705a;

    public C1149e8(Drawable.ConstantState constantState) {
        this.f16705a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f16705a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f16705a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
        Drawable newDrawable = this.f16705a.newDrawable();
        animatedVectorDrawableCompat.f17083a = newDrawable;
        newDrawable.setCallback(animatedVectorDrawableCompat.f7553f);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
        Drawable newDrawable = this.f16705a.newDrawable(resources);
        animatedVectorDrawableCompat.f17083a = newDrawable;
        newDrawable.setCallback(animatedVectorDrawableCompat.f7553f);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
        Drawable newDrawable = this.f16705a.newDrawable(resources, theme);
        animatedVectorDrawableCompat.f17083a = newDrawable;
        newDrawable.setCallback(animatedVectorDrawableCompat.f7553f);
        return animatedVectorDrawableCompat;
    }
}
