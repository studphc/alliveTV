package p000;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
public final class k73 implements o83 {

    /* renamed from: a */
    public final /* synthetic */ Activity f20770a;

    /* renamed from: b */
    public final /* synthetic */ Bundle f20771b;

    /* renamed from: c */
    public final /* synthetic */ Bundle f20772c;

    /* renamed from: d */
    public final /* synthetic */ DeferredLifecycleHelper f20773d;

    public k73(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f20773d = deferredLifecycleHelper;
        this.f20770a = activity;
        this.f20771b = bundle;
        this.f20772c = bundle2;
    }

    @Override // p000.o83
    public final int zaa() {
        return 0;
    }

    @Override // p000.o83
    public final void zab() {
        this.f20773d.f13692a.onInflate(this.f20770a, this.f20771b, this.f20772c);
    }
}
