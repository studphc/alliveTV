package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.stream.Stream;
import p000.jw1;

/* loaded from: classes2.dex */
public final class ObservableFromStream<T> extends Observable<T> {

    /* renamed from: a */
    public final Stream f18563a;

    public ObservableFromStream(Stream<T> stream) {
        this.f18563a = stream;
    }

    public static <T> void subscribeStream(Observer<? super T> observer, Stream<T> stream) {
        Iterator it;
        try {
            it = stream.iterator();
            if (!it.hasNext()) {
                EmptyDisposable.complete(observer);
                try {
                    stream.close();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                    return;
                }
            }
            jw1 jw1Var = new jw1(observer, it, stream);
            observer.onSubscribe(jw1Var);
            jw1Var.m5464a();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
            try {
                stream.close();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        subscribeStream(observer, this.f18563a);
    }
}
