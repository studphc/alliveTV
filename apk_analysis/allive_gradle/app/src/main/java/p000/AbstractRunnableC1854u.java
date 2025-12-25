package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.ExecutionException;

/* renamed from: u */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC1854u extends os0 implements Runnable {

    /* renamed from: k */
    public static final /* synthetic */ int f27044k = 0;

    /* renamed from: h */
    public ListenableFuture f27045h;

    /* renamed from: i */
    public Class f27046i;

    /* renamed from: j */
    public Object f27047j;

    public AbstractRunnableC1854u(ListenableFuture listenableFuture, Class cls, Object obj) {
        this.f27045h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.f27046i = (Class) Preconditions.checkNotNull(cls);
        this.f27047j = Preconditions.checkNotNull(obj);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        m4312h(this.f27045h);
        this.f27045h = null;
        this.f27046i = null;
        this.f27047j = null;
    }

    /* renamed from: j */
    public abstract Object mo7313j(Object obj, Throwable th);

    /* renamed from: k */
    public abstract void mo7314k(Object obj);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        String str;
        ListenableFuture listenableFuture = this.f27045h;
        Class cls = this.f27046i;
        Object obj = this.f27047j;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            String valueOf = String.valueOf(listenableFuture);
            str = AbstractC1726qj.m7059o("inputFuture=[", valueOf, "], ", valueOf.length() + 16);
        } else {
            str = "";
        }
        if (cls != null && obj != null) {
            String valueOf2 = String.valueOf(cls);
            String valueOf3 = String.valueOf(obj);
            return AbstractC1726qj.m7061q(AbstractC1726qj.m7062r(valueOf3.length() + valueOf2.length() + AbstractC1726qj.m7052h(29, str), str, "exceptionType=[", valueOf2, "], fallback=["), valueOf3, "]");
        }
        if (pendingToString != null) {
            String valueOf4 = String.valueOf(str);
            if (pendingToString.length() != 0) {
                return valueOf4.concat(pendingToString);
            }
            return new String(valueOf4);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        boolean z2;
        Object obj;
        ListenableFuture listenableFuture = this.f27045h;
        Class cls = this.f27046i;
        Object obj2 = this.f27047j;
        boolean z3 = false;
        if (listenableFuture == 0) {
            z = true;
        } else {
            z = false;
        }
        if (cls == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z4 = z | z2;
        if (obj2 == null) {
            z3 = true;
        }
        if (!(z3 | z4) && !isCancelled()) {
            this.f27045h = null;
            try {
                if (listenableFuture instanceof InternalFutureFailureAccess) {
                    th = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture);
                } else {
                    th = null;
                }
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    String valueOf = String.valueOf(listenableFuture.getClass());
                    String valueOf2 = String.valueOf(e.getClass());
                    StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 35, "Future type ", valueOf, " threw ", valueOf2);
                    m7062r.append(" without a cause");
                    cause = new NullPointerException(m7062r.toString());
                }
                th = cause;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                obj = Futures.getDone(listenableFuture);
                if (th != null) {
                    set(obj);
                    return;
                }
                if (!cls.isInstance(th)) {
                    setFuture(listenableFuture);
                    return;
                }
                try {
                    Object mo7313j = mo7313j(obj2, th);
                    this.f27046i = null;
                    this.f27047j = null;
                    mo7314k(mo7313j);
                    return;
                } catch (Throwable th2) {
                    try {
                        setException(th2);
                        return;
                    } finally {
                        this.f27046i = null;
                        this.f27047j = null;
                    }
                }
            }
            obj = null;
            if (th != null) {
            }
        }
    }
}
