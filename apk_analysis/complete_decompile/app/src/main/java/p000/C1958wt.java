package p000;

import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.inject.Provider;

/* renamed from: wt */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1958wt implements Provider {

    /* renamed from: a */
    public final /* synthetic */ int f28320a;

    /* renamed from: b */
    public final /* synthetic */ Object f28321b;

    public /* synthetic */ C1958wt(int i, Object obj) {
        this.f28320a = i;
        this.f28321b = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f28320a) {
            case 0:
                return ComponentDiscovery.m4373a((String) this.f28321b);
            default:
                return (ComponentRegistrar) this.f28321b;
        }
    }
}
