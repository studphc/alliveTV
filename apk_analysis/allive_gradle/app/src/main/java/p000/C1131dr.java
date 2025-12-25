package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: dr */
/* loaded from: classes2.dex */
public final class C1131dr extends a51 {

    /* renamed from: c */
    public final Executor f16493c;

    /* renamed from: d */
    public final /* synthetic */ C1168er f16494d;

    /* renamed from: e */
    public final /* synthetic */ int f16495e;

    /* renamed from: f */
    public final /* synthetic */ C1168er f16496f;

    /* renamed from: g */
    public final Object f16497g;

    public C1131dr(C1168er c1168er, Executor executor) {
        this.f16494d = c1168er;
        this.f16493c = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // p000.a51
    /* renamed from: a */
    public final void mo21a(Throwable th) {
        C1168er c1168er = this.f16494d;
        c1168er.f16955p = null;
        if (th instanceof ExecutionException) {
            c1168er.setException(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            c1168er.cancel(false);
        } else {
            c1168er.setException(th);
        }
    }

    @Override // p000.a51
    /* renamed from: b */
    public final void mo22b(Object obj) {
        this.f16494d.f16955p = null;
        switch (this.f16495e) {
            case 0:
                this.f16496f.setFuture((ListenableFuture) obj);
                return;
            default:
                this.f16496f.set(obj);
                return;
        }
    }

    @Override // p000.a51
    /* renamed from: d */
    public final boolean mo24d() {
        return this.f16494d.isDone();
    }

    @Override // p000.a51
    /* renamed from: e */
    public final Object mo25e() {
        switch (this.f16495e) {
            case 0:
                AsyncCallable asyncCallable = (AsyncCallable) this.f16497g;
                return (ListenableFuture) Preconditions.checkNotNull(asyncCallable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncCallable);
            default:
                return ((Callable) this.f16497g).call();
        }
    }

    @Override // p000.a51
    /* renamed from: f */
    public final String mo26f() {
        switch (this.f16495e) {
            case 0:
                return ((AsyncCallable) this.f16497g).toString();
            default:
                return ((Callable) this.f16497g).toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1131dr(C1168er c1168er, AsyncCallable asyncCallable, Executor executor) {
        this(c1168er, executor);
        this.f16495e = 0;
        this.f16496f = c1168er;
        this.f16497g = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1131dr(C1168er c1168er, Callable callable, Executor executor) {
        this(c1168er, executor);
        this.f16495e = 1;
        this.f16496f = c1168er;
        this.f16497g = (Callable) Preconditions.checkNotNull(callable);
    }
}
