package p000;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
public final class l83 implements o83 {

    /* renamed from: a */
    public final /* synthetic */ int f22387a;

    /* renamed from: b */
    public final /* synthetic */ DeferredLifecycleHelper f22388b;

    public /* synthetic */ l83(DeferredLifecycleHelper deferredLifecycleHelper, int i) {
        this.f22387a = i;
        this.f22388b = deferredLifecycleHelper;
    }

    @Override // p000.o83
    public final int zaa() {
        switch (this.f22387a) {
            case 0:
                return 4;
            default:
                return 5;
        }
    }

    @Override // p000.o83
    public final void zab() {
        switch (this.f22387a) {
            case 0:
                this.f22388b.f13692a.onStart();
                return;
            default:
                this.f22388b.f13692a.onResume();
                return;
        }
    }
}
