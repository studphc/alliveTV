package p000;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes2.dex */
public final class ma0 implements AsyncCallable {

    /* renamed from: a */
    public final /* synthetic */ oa0 f22873a;

    /* renamed from: b */
    public final /* synthetic */ AsyncCallable f22874b;

    public ma0(oa0 oa0Var, AsyncCallable asyncCallable) {
        this.f22873a = oa0Var;
        this.f22874b = asyncCallable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        int i = oa0.f23677e;
        if (!this.f22873a.compareAndSet(na0.f23309a, na0.f23311c)) {
            return Futures.immediateCancelledFuture();
        }
        return this.f22874b.call();
    }

    public final String toString() {
        return this.f22874b.toString();
    }
}
