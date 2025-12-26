package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import p000.AbstractC0003a2;

/* loaded from: classes2.dex */
public final class MaybeOnErrorComplete<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Predicate f19187a;

    /* loaded from: classes2.dex */
    public static final class OnErrorCompleteMultiObserver<T> implements MaybeObserver<T>, SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final MaybeObserver f19188a;

        /* renamed from: b */
        public final Predicate f19189b;

        /* renamed from: c */
        public Disposable f19190c;

        public OnErrorCompleteMultiObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super Throwable> predicate) {
            this.f19188a = maybeObserver;
            this.f19189b = predicate;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.f19190c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f19190c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public void onComplete() {
            this.f19188a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public void onError(Throwable th) {
            MaybeObserver maybeObserver = this.f19188a;
            try {
                if (this.f19189b.test(th)) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                maybeObserver.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19190c, disposable)) {
                this.f19190c = disposable;
                this.f19188a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public void onSuccess(T t) {
            this.f19188a.onSuccess(t);
        }
    }

    public MaybeOnErrorComplete(MaybeSource<T> maybeSource, Predicate<? super Throwable> predicate) {
        super(maybeSource);
        this.f19187a = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new OnErrorCompleteMultiObserver(maybeObserver, this.f19187a));
    }
}
