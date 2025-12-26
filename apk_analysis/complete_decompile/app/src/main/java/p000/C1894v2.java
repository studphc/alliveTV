package p000;

import androidx.concurrent.futures.AbstractResolvableFuture;

/* renamed from: v2 */
/* loaded from: classes.dex */
public final class C1894v2 extends o63 {
    @Override // p000.o63
    /* renamed from: d */
    public final boolean mo6480d(AbstractResolvableFuture abstractResolvableFuture, C1783s2 c1783s2, C1783s2 c1783s22) {
        synchronized (abstractResolvableFuture) {
            try {
                if (abstractResolvableFuture.f1809b == c1783s2) {
                    abstractResolvableFuture.f1809b = c1783s22;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.o63
    /* renamed from: e */
    public final boolean mo6481e(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
        synchronized (abstractResolvableFuture) {
            try {
                if (abstractResolvableFuture.f1808a == obj) {
                    abstractResolvableFuture.f1808a = obj2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.o63
    /* renamed from: f */
    public final boolean mo6482f(AbstractResolvableFuture abstractResolvableFuture, C1931w2 c1931w2, C1931w2 c1931w22) {
        synchronized (abstractResolvableFuture) {
            try {
                if (abstractResolvableFuture.f1810c == c1931w2) {
                    abstractResolvableFuture.f1810c = c1931w22;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.o63
    /* renamed from: y */
    public final void mo6483y(C1931w2 c1931w2, C1931w2 c1931w22) {
        c1931w2.f28046b = c1931w22;
    }

    @Override // p000.o63
    /* renamed from: z */
    public final void mo6484z(C1931w2 c1931w2, Thread thread) {
        c1931w2.f28045a = thread;
    }
}
