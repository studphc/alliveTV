package p000;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;

/* loaded from: classes.dex */
public final class an1 {

    /* renamed from: a */
    public final Lifecycle f271a;

    /* renamed from: b */
    public LifecycleEventObserver f272b;

    public an1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        this.f271a = lifecycle;
        this.f272b = lifecycleEventObserver;
        lifecycle.addObserver(lifecycleEventObserver);
    }
}
