package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.C1366jt;

/* loaded from: classes2.dex */
public final class CompletableUsing<R> extends Completable {

    /* renamed from: a */
    public final Supplier f18720a;

    /* renamed from: b */
    public final Function f18721b;

    /* renamed from: c */
    public final Consumer f18722c;

    /* renamed from: d */
    public final boolean f18723d;

    public CompletableUsing(Supplier<R> supplier, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        this.f18720a = supplier;
        this.f18721b = function;
        this.f18722c = consumer;
        this.f18723d = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        boolean z = this.f18723d;
        Consumer consumer = this.f18722c;
        try {
            Object obj = this.f18720a.get();
            try {
                Object apply = this.f18721b.apply(obj);
                Objects.requireNonNull(apply, "The completableFunction returned a null CompletableSource");
                ((CompletableSource) apply).subscribe(new C1366jt(completableObserver, obj, consumer, z));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (z) {
                    try {
                        consumer.accept(obj);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptyDisposable.error(new CompositeException(th, th2), completableObserver);
                        return;
                    }
                }
                EmptyDisposable.error(th, completableObserver);
                if (!z) {
                    try {
                        consumer.accept(obj);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        RxJavaPlugins.onError(th3);
                    }
                }
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            EmptyDisposable.error(th4, completableObserver);
        }
    }
}
