package p000;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class la0 implements AsyncCallable {

    /* renamed from: a */
    public final /* synthetic */ Callable f22424a;

    public la0(Callable callable) {
        this.f22424a = callable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        return Futures.immediateFuture(this.f22424a.call());
    }

    public final String toString() {
        return this.f22424a.toString();
    }
}
