package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.fragment.app.k */
/* loaded from: classes.dex */
public final class C0256k {

    /* renamed from: a */
    public final FragmentManager.FragmentLifecycleCallbacks f4681a;

    /* renamed from: b */
    public final boolean f4682b;

    public C0256k(FragmentManager.FragmentLifecycleCallbacks callback, boolean z) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f4681a = callback;
        this.f4682b = z;
    }
}
