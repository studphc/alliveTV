package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class i50 implements Future {

    /* renamed from: a */
    public final Disposable f18298a;

    public i50(Disposable disposable) {
        this.f18298a = disposable;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.f18298a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return null;
    }
}
