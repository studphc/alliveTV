package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    /* loaded from: classes.dex */
    public static abstract class AnimationCallback {

        /* renamed from: a */
        public C0521a f7548a;

        /* renamed from: a */
        public final Animatable2.AnimationCallback m1912a() {
            if (this.f7548a == null) {
                this.f7548a = new C0521a(this);
            }
            return this.f7548a;
        }

        public void onAnimationEnd(Drawable drawable) {
        }

        public void onAnimationStart(Drawable drawable) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(@NonNull AnimationCallback animationCallback);
}
