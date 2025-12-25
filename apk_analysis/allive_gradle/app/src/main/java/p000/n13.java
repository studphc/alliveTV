package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* loaded from: classes.dex */
public final class n13 extends Drawable.ConstantState {

    /* renamed from: a */
    public final Drawable.ConstantState f23197a;

    public n13(Drawable.ConstantState constantState) {
        this.f23197a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f23197a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f23197a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.f17083a = (VectorDrawable) this.f23197a.newDrawable();
        return vectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.f17083a = (VectorDrawable) this.f23197a.newDrawable(resources);
        return vectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.f17083a = (VectorDrawable) this.f23197a.newDrawable(resources, theme);
        return vectorDrawableCompat;
    }
}
