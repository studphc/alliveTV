package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromCompletable<T> extends Flowable<T> implements HasUpstreamCompletableSource {

    /* renamed from: b */
    public final CompletableSource f18869b;

    /* loaded from: classes2.dex */
    public static final class FromCompletableObserver<T> extends AbstractEmptyQueueFuseable<T> implements CompletableObserver {

        /* renamed from: a */
        public final Subscriber f18870a;

        /* renamed from: b */
        public Disposable f18871b;

        public FromCompletableObserver(Subscriber<? super T> subscriber) {
            this.f18870a = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, org.reactivestreams.Subscription
        public void cancel() {
            this.f18871b.dispose();
            this.f18871b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.f18871b = DisposableHelper.DISPOSED;
            this.f18870a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.f18871b = DisposableHelper.DISPOSED;
            this.f18870a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18871b, disposable)) {
                this.f18871b = disposable;
                this.f18870a.onSubscribe(this);
            }
        }
    }

    public FlowableFromCompletable(CompletableSource completableSource) {
        this.f18869b = completableSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource
    public CompletableSource source() {
        return this.f18869b;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18869b.subscribe(new FromCompletableObserver(subscriber));
    }
}
