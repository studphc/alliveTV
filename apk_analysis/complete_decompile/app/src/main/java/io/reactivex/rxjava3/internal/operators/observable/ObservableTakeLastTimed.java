package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.iz1;

/* loaded from: classes2.dex */
public final class ObservableTakeLastTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19575a;

    /* renamed from: b */
    public final long f19576b;

    /* renamed from: c */
    public final TimeUnit f19577c;

    /* renamed from: d */
    public final Scheduler f19578d;

    /* renamed from: e */
    public final int f19579e;

    /* renamed from: f */
    public final boolean f19580f;

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.f19575a = j;
        this.f19576b = j2;
        this.f19577c = timeUnit;
        this.f19578d = scheduler;
        this.f19579e = i;
        this.f19580f = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource<Object> observableSource = this.source;
        TimeUnit timeUnit = this.f19577c;
        Scheduler scheduler = this.f19578d;
        observableSource.subscribe(new iz1(this.f19579e, this.f19575a, this.f19576b, observer, scheduler, timeUnit, this.f19580f));
    }
}
