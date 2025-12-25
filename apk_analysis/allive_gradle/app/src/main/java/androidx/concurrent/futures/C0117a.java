package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: androidx.concurrent.futures.a */
/* loaded from: classes.dex */
public final class C0117a extends AbstractResolvableFuture {

    /* renamed from: h */
    public final /* synthetic */ C0118b f1816h;

    public C0117a(C0118b c0118b) {
        this.f1816h = c0118b;
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final String pendingToString() {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.f1816h.f1817a.get();
        if (completer == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + completer.f1811a + "]";
    }
}
