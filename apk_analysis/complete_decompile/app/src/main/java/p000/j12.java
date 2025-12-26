package p000;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class j12 implements Provider, Deferred {

    /* renamed from: c */
    public static final ee0 f20343c = new ee0(23);

    /* renamed from: d */
    public static final C2069zt f20344d = new C2069zt(5);

    /* renamed from: a */
    public Deferred.DeferredHandler f20345a;

    /* renamed from: b */
    public volatile Provider f20346b;

    public j12(ee0 ee0Var, Provider provider) {
        this.f20345a = ee0Var;
        this.f20346b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.f20346b.get();
    }

    @Override // com.google.firebase.inject.Deferred
    public final void whenAvailable(Deferred.DeferredHandler deferredHandler) {
        Provider provider;
        Provider provider2;
        Provider provider3 = this.f20346b;
        C2069zt c2069zt = f20344d;
        if (provider3 != c2069zt) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.f20346b;
            if (provider != c2069zt) {
                provider2 = provider;
            } else {
                this.f20345a = new C1702pw(14, this.f20345a, deferredHandler);
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }
}
