package p000;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AsyncCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* loaded from: classes2.dex */
public final class yw2 extends os0 implements RunnableFuture {

    /* renamed from: h */
    public volatile a51 f29156h;

    public yw2(Callable callable) {
        this.f29156h = new xw2(this, callable);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [yw2, com.google.common.util.concurrent.AbstractFuture] */
    /* renamed from: j */
    public static yw2 m8329j(AsyncCallable asyncCallable) {
        ?? abstractFuture = new AbstractFuture();
        abstractFuture.f29156h = new xw2((yw2) abstractFuture, asyncCallable);
        return abstractFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        a51 a51Var;
        super.afterDone();
        if (wasInterrupted() && (a51Var = this.f29156h) != null) {
            a51Var.m23c();
        }
        this.f29156h = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        a51 a51Var = this.f29156h;
        if (a51Var != null) {
            String valueOf = String.valueOf(a51Var);
            return AbstractC1726qj.m7059o("task=[", valueOf, "]", valueOf.length() + 7);
        }
        return super.pendingToString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        a51 a51Var = this.f29156h;
        if (a51Var != null) {
            a51Var.run();
        }
        this.f29156h = null;
    }
}
