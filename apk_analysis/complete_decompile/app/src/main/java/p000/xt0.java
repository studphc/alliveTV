package p000;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;

/* loaded from: classes.dex */
public final class xt0 implements FragmentResultListener {

    /* renamed from: a */
    public final Lifecycle f28728a;

    /* renamed from: b */
    public final FragmentResultListener f28729b;

    /* renamed from: c */
    public final LifecycleEventObserver f28730c;

    public xt0(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
        this.f28728a = lifecycle;
        this.f28729b = fragmentResultListener;
        this.f28730c = lifecycleEventObserver;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String str, Bundle bundle) {
        this.f28729b.onFragmentResult(str, bundle);
    }
}
