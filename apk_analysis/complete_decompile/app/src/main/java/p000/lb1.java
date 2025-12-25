package p000;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ConcurrentMapC0840e;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class lb1 implements zb1 {

    /* renamed from: a */
    public volatile zb1 f22433a;

    /* renamed from: b */
    public final SettableFuture f22434b;

    /* renamed from: c */
    public final Stopwatch f22435c;

    public lb1() {
        this(ConcurrentMapC0840e.f14585x);
    }

    @Override // p000.zb1
    /* renamed from: a */
    public final j92 mo2069a() {
        return null;
    }

    @Override // p000.zb1
    /* renamed from: b */
    public final void mo2070b(Object obj) {
        if (obj != null) {
            this.f22434b.set(obj);
        } else {
            this.f22433a = ConcurrentMapC0840e.f14585x;
        }
    }

    @Override // p000.zb1
    /* renamed from: c */
    public final int mo2071c() {
        return this.f22433a.mo2071c();
    }

    @Override // p000.zb1
    /* renamed from: d */
    public final Object mo2072d() {
        return Uninterruptibles.getUninterruptibly(this.f22434b);
    }

    /* renamed from: f */
    public final ListenableFuture m5914f(Object obj, CacheLoader cacheLoader) {
        ListenableFuture immediateFailedFuture;
        try {
            this.f22435c.start();
            Object obj2 = this.f22433a.get();
            if (obj2 == null) {
                Object load = cacheLoader.load(obj);
                if (this.f22434b.set(load)) {
                    return this.f22434b;
                }
                return Futures.immediateFuture(load);
            }
            ListenableFuture reload = cacheLoader.reload(obj, obj2);
            if (reload == null) {
                return Futures.immediateFuture(null);
            }
            return Futures.transform(reload, new C1291i2(4, this), MoreExecutors.directExecutor());
        } catch (Throwable th) {
            if (this.f22434b.setException(th)) {
                immediateFailedFuture = this.f22434b;
            } else {
                immediateFailedFuture = Futures.immediateFailedFuture(th);
            }
            if (th instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            return immediateFailedFuture;
        }
    }

    @Override // p000.zb1
    public final Object get() {
        return this.f22433a.get();
    }

    @Override // p000.zb1
    public final boolean isActive() {
        return this.f22433a.isActive();
    }

    @Override // p000.zb1
    public final boolean isLoading() {
        return true;
    }

    public lb1(zb1 zb1Var) {
        this.f22434b = SettableFuture.create();
        this.f22435c = Stopwatch.createUnstarted();
        this.f22433a = zb1Var;
    }

    @Override // p000.zb1
    /* renamed from: e */
    public final zb1 mo2073e(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        return this;
    }
}
