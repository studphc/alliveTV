package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.bk1;

/* loaded from: classes2.dex */
public final class MaybeUsing<T, D> extends Maybe<T> {

    /* renamed from: a */
    public final Supplier f19222a;

    /* renamed from: b */
    public final Function f19223b;

    /* renamed from: c */
    public final Consumer f19224c;

    /* renamed from: d */
    public final boolean f19225d;

    public MaybeUsing(Supplier<? extends D> supplier, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f19222a = supplier;
        this.f19223b = function;
        this.f19224c = consumer;
        this.f19225d = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        boolean z = this.f19225d;
        Consumer consumer = this.f19224c;
        try {
            Object obj = this.f19222a.get();
            try {
                Object apply = this.f19223b.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null MaybeSource");
                ((MaybeSource) apply).subscribe(new bk1(maybeObserver, obj, consumer, z));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (z) {
                    try {
                        consumer.accept(obj);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptyDisposable.error(new CompositeException(th, th2), maybeObserver);
                        return;
                    }
                }
                EmptyDisposable.error(th, maybeObserver);
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
            EmptyDisposable.error(th4, maybeObserver);
        }
    }
}
