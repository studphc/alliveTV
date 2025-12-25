package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import p000.vy1;

/* loaded from: classes2.dex */
public final class ObservableFirstStageObserver<T> extends vy1 {

    /* renamed from: c */
    public final boolean f18558c;

    /* renamed from: d */
    public final Object f18559d;

    public ObservableFirstStageObserver(boolean z, T t) {
        this.f18558c = z;
        this.f18559d = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        boolean isDone;
        isDone = isDone();
        if (!isDone) {
            clear();
            if (this.f18558c) {
                complete(this.f18559d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        complete(t);
    }
}
