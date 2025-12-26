package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import p000.vy1;

/* loaded from: classes2.dex */
public final class ObservableLastStageObserver<T> extends vy1 {

    /* renamed from: c */
    public final boolean f18564c;

    /* renamed from: d */
    public final Object f18565d;

    public ObservableLastStageObserver(boolean z, T t) {
        this.f18564c = z;
        this.f18565d = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        boolean isDone;
        isDone = isDone();
        if (!isDone) {
            Object obj = this.f28012b;
            clear();
            if (obj != null) {
                complete(obj);
            } else if (this.f18564c) {
                complete(this.f18565d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.f28012b = t;
    }
}
