package p000;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zak;

/* loaded from: classes.dex */
public final class s83 extends Drawable.ConstantState {

    /* renamed from: a */
    public int f26315a;

    /* renamed from: b */
    public int f26316b;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f26315a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zak(this);
    }
}
