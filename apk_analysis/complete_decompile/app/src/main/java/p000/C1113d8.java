package p000;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.collection.ArrayMap;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.ArrayList;

/* renamed from: d8 */
/* loaded from: classes.dex */
public final class C1113d8 extends Drawable.ConstantState {

    /* renamed from: a */
    public VectorDrawableCompat f16281a;

    /* renamed from: b */
    public AnimatorSet f16282b;

    /* renamed from: c */
    public ArrayList f16283c;

    /* renamed from: d */
    public ArrayMap f16284d;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
