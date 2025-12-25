package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class xw2 extends a51 {

    /* renamed from: c */
    public final /* synthetic */ int f28754c = 0;

    /* renamed from: d */
    public final /* synthetic */ yw2 f28755d;

    /* renamed from: e */
    public final Object f28756e;

    public xw2(yw2 yw2Var, Callable callable) {
        this.f28755d = yw2Var;
        this.f28756e = (Callable) Preconditions.checkNotNull(callable);
    }

    @Override // p000.a51
    /* renamed from: a */
    public final void mo21a(Throwable th) {
        switch (this.f28754c) {
            case 0:
                this.f28755d.setException(th);
                return;
            default:
                this.f28755d.setException(th);
                return;
        }
    }

    @Override // p000.a51
    /* renamed from: b */
    public final void mo22b(Object obj) {
        switch (this.f28754c) {
            case 0:
                this.f28755d.setFuture((ListenableFuture) obj);
                return;
            default:
                this.f28755d.set(obj);
                return;
        }
    }

    @Override // p000.a51
    /* renamed from: d */
    public final boolean mo24d() {
        switch (this.f28754c) {
            case 0:
                return this.f28755d.isDone();
            default:
                return this.f28755d.isDone();
        }
    }

    @Override // p000.a51
    /* renamed from: e */
    public final Object mo25e() {
        switch (this.f28754c) {
            case 0:
                AsyncCallable asyncCallable = (AsyncCallable) this.f28756e;
                return (ListenableFuture) Preconditions.checkNotNull(asyncCallable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncCallable);
            default:
                return ((Callable) this.f28756e).call();
        }
    }

    @Override // p000.a51
    /* renamed from: f */
    public final String mo26f() {
        switch (this.f28754c) {
            case 0:
                return ((AsyncCallable) this.f28756e).toString();
            default:
                return ((Callable) this.f28756e).toString();
        }
    }

    public xw2(yw2 yw2Var, AsyncCallable asyncCallable) {
        this.f28755d = yw2Var;
        this.f28756e = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
    }
}
