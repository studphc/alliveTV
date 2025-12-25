package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* renamed from: androidx.vectordrawable.graphics.drawable.a */
/* loaded from: classes.dex */
public final class C0521a extends Animatable2.AnimationCallback {

    /* renamed from: a */
    public final /* synthetic */ Animatable2Compat.AnimationCallback f7566a;

    public C0521a(Animatable2Compat.AnimationCallback animationCallback) {
        this.f7566a = animationCallback;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        this.f7566a.onAnimationEnd(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        this.f7566a.onAnimationStart(drawable);
    }
}
