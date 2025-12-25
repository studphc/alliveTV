package p000;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
public final class z73 implements o83 {

    /* renamed from: a */
    public final /* synthetic */ Bundle f29267a;

    /* renamed from: b */
    public final /* synthetic */ DeferredLifecycleHelper f29268b;

    public z73(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.f29268b = deferredLifecycleHelper;
        this.f29267a = bundle;
    }

    @Override // p000.o83
    public final int zaa() {
        return 1;
    }

    @Override // p000.o83
    public final void zab() {
        this.f29268b.f13692a.onCreate(this.f29267a);
    }
}
