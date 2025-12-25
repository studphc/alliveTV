package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.hy1;
import p000.jy1;

/* loaded from: classes2.dex */
public final class ObservableSampleTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19537a;

    /* renamed from: b */
    public final TimeUnit f19538b;

    /* renamed from: c */
    public final Scheduler f19539c;

    /* renamed from: d */
    public final boolean f19540d;

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.f19537a = j;
        this.f19538b = timeUnit;
        this.f19539c = scheduler;
        this.f19540d = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f19540d) {
            this.source.subscribe(new hy1(serializedObserver, this.f19537a, this.f19538b, this.f19539c));
        } else {
            this.source.subscribe(new jy1(serializedObserver, this.f19537a, this.f19538b, this.f19539c));
        }
    }
}
