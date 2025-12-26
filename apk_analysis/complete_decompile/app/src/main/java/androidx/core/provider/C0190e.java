package androidx.core.provider;

import androidx.core.util.Consumer;

/* renamed from: androidx.core.provider.e */
/* loaded from: classes.dex */
public final class C0190e implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ C0188c f3747a;

    public C0190e(C0188c c0188c) {
        this.f3747a = c0188c;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        C0192g c0192g = (C0192g) obj;
        if (c0192g == null) {
            c0192g = new C0192g(-3);
        }
        this.f3747a.m881a(c0192g);
    }
}
