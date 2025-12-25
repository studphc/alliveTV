package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import p000.vy1;

/* loaded from: classes2.dex */
public final class ObservableSingleStageObserver<T> extends vy1 {

    /* renamed from: c */
    public final boolean f18568c;

    /* renamed from: d */
    public final Object f18569d;

    public ObservableSingleStageObserver(boolean z, T t) {
        this.f18568c = z;
        this.f18569d = t;
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
            } else if (this.f18568c) {
                complete(this.f18569d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.f28012b != null) {
            this.f28012b = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
        } else {
            this.f28012b = t;
        }
    }
}
