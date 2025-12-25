package androidx.media;

import p000.tk1;

/* renamed from: androidx.media.o */
/* loaded from: classes.dex */
public class C0438o extends AbstractC0436m {

    /* renamed from: e */
    public final /* synthetic */ MediaBrowserServiceCompat f6719e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0438o(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f6719e = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.InterfaceC0432i
    public void onCreate() {
        tk1 tk1Var = new tk1(this, this.f6719e);
        this.f6715b = tk1Var;
        tk1Var.onCreate();
    }
}
