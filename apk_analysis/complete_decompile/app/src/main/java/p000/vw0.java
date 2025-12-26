package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes.dex */
public final class vw0 extends Drawable.ConstantState {

    /* renamed from: a */
    public final zw0 f27980a;

    public vw0(zw0 zw0Var) {
        this.f27980a = zw0Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new GifDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new GifDrawable(this);
    }
}
