package p000;

import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class gw0 implements Runnable {

    /* renamed from: a */
    public final ListenableFuture f17852a;

    /* renamed from: b */
    public final FutureCallback f17853b;

    public gw0(ListenableFuture listenableFuture, FutureCallback futureCallback) {
        this.f17852a = listenableFuture;
        this.f17853b = futureCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable tryInternalFastPathGetFailure;
        ListenableFuture listenableFuture = this.f17852a;
        boolean z = listenableFuture instanceof InternalFutureFailureAccess;
        FutureCallback futureCallback = this.f17853b;
        if (z && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            futureCallback.onFailure(tryInternalFastPathGetFailure);
            return;
        }
        try {
            futureCallback.onSuccess(Futures.getDone(listenableFuture));
        } catch (Error e) {
            e = e;
            futureCallback.onFailure(e);
        } catch (RuntimeException e2) {
            e = e2;
            futureCallback.onFailure(e);
        } catch (ExecutionException e3) {
            futureCallback.onFailure(e3.getCause());
        }
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.f17853b).toString();
    }
}
