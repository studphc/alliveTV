package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;
import p000.qu1;
import p000.su1;

/* loaded from: classes2.dex */
public final class ObservableConcatMapScheduler<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19377a;

    /* renamed from: b */
    public final int f19378b;

    /* renamed from: c */
    public final ErrorMode f19379c;

    /* renamed from: d */
    public final Scheduler f19380d;

    public ObservableConcatMapScheduler(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode, Scheduler scheduler) {
        super(observableSource);
        this.f19377a = function;
        this.f19379c = errorMode;
        this.f19378b = Math.max(8, i);
        this.f19380d = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        boolean z;
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        Scheduler scheduler = this.f19380d;
        ErrorMode errorMode2 = this.f19379c;
        if (errorMode2 == errorMode) {
            SerializedObserver serializedObserver = new SerializedObserver(observer);
            this.source.subscribe(new su1(serializedObserver, this.f19377a, this.f19378b, scheduler.createWorker()));
            return;
        }
        ObservableSource<Object> observableSource = this.source;
        if (errorMode2 == ErrorMode.END) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        observableSource.subscribe(new qu1(observer, this.f19377a, this.f19378b, z2, scheduler.createWorker()));
    }
}
