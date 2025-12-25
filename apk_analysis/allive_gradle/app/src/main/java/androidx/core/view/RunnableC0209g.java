package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;

/* renamed from: androidx.core.view.g */
/* loaded from: classes.dex */
public final class RunnableC0209g implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ View f3981a;

    /* renamed from: b */
    public final /* synthetic */ WindowInsetsAnimationCompat f3982b;

    /* renamed from: c */
    public final /* synthetic */ WindowInsetsAnimationCompat.BoundsCompat f3983c;

    /* renamed from: d */
    public final /* synthetic */ ValueAnimator f3984d;

    public RunnableC0209g(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat, ValueAnimator valueAnimator) {
        this.f3981a = view;
        this.f3982b = windowInsetsAnimationCompat;
        this.f3983c = boundsCompat;
        this.f3984d = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0211i.m954j(this.f3981a, this.f3982b, this.f3983c);
        this.f3984d.start();
    }
}
