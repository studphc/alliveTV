package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.FixedSizeDrawable;

/* loaded from: classes.dex */
public final class oe0 extends Drawable.ConstantState {

    /* renamed from: a */
    public final Drawable.ConstantState f23786a;

    /* renamed from: b */
    public final int f23787b;

    /* renamed from: c */
    public final int f23788c;

    public oe0(Drawable.ConstantState constantState, int i, int i2) {
        this.f23786a = constantState;
        this.f23787b = i;
        this.f23788c = i2;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new FixedSizeDrawable(this, this.f23786a.newDrawable());
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new FixedSizeDrawable(this, this.f23786a.newDrawable(resources));
    }
}
