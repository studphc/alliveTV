package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* renamed from: f3 */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC1181f3 extends os0 implements Runnable {

    /* renamed from: j */
    public static final /* synthetic */ int f17111j = 0;

    /* renamed from: h */
    public ListenableFuture f17112h;

    /* renamed from: i */
    public Object f17113i;

    public AbstractRunnableC1181f3(ListenableFuture listenableFuture, Object obj) {
        this.f17112h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.f17113i = Preconditions.checkNotNull(obj);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        m4312h(this.f17112h);
        this.f17112h = null;
        this.f17113i = null;
    }

    /* renamed from: j */
    public abstract Object mo4515j(Object obj, Object obj2);

    /* renamed from: k */
    public abstract void mo4516k(Object obj);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        String str;
        ListenableFuture listenableFuture = this.f17112h;
        Object obj = this.f17113i;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            String valueOf = String.valueOf(listenableFuture);
            str = AbstractC1726qj.m7059o("inputFuture=[", valueOf, "], ", valueOf.length() + 16);
        } else {
            str = "";
        }
        if (obj != null) {
            String valueOf2 = String.valueOf(obj);
            return AbstractC1726qj.m7055k(valueOf2.length() + AbstractC1726qj.m7052h(11, str), str, "function=[", valueOf2, "]");
        }
        if (pendingToString != null) {
            String valueOf3 = String.valueOf(str);
            if (pendingToString.length() != 0) {
                return valueOf3.concat(pendingToString);
            }
            return new String(valueOf3);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        ListenableFuture listenableFuture = this.f17112h;
        Object obj = this.f17113i;
        boolean isCancelled = isCancelled();
        boolean z2 = true;
        if (listenableFuture == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = isCancelled | z;
        if (obj != null) {
            z2 = false;
        }
        if (z3 | z2) {
            return;
        }
        this.f17112h = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object mo4515j = mo4515j(obj, Futures.getDone(listenableFuture));
                this.f17113i = null;
                mo4516k(mo4515j);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.f17113i = null;
                }
            }
        } catch (Error e) {
            setException(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            setException(e2);
        } catch (ExecutionException e3) {
            setException(e3.getCause());
        }
    }
}
