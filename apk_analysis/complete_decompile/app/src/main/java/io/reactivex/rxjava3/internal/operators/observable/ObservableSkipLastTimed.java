package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.sy1;

/* loaded from: classes2.dex */
public final class ObservableSkipLastTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19561a;

    /* renamed from: b */
    public final TimeUnit f19562b;

    /* renamed from: c */
    public final Scheduler f19563c;

    /* renamed from: d */
    public final int f19564d;

    /* renamed from: e */
    public final boolean f19565e;

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.f19561a = j;
        this.f19562b = timeUnit;
        this.f19563c = scheduler;
        this.f19564d = i;
        this.f19565e = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new sy1(observer, this.f19561a, this.f19562b, this.f19563c, this.f19564d, this.f19565e));
    }
}
