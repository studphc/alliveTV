package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.AbstractC0003a2;
import p000.ai1;

/* loaded from: classes2.dex */
public final class MaybeDelay<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final long f19132a;

    /* renamed from: b */
    public final TimeUnit f19133b;

    /* renamed from: c */
    public final Scheduler f19134c;

    /* renamed from: d */
    public final boolean f19135d;

    public MaybeDelay(MaybeSource<T> maybeSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(maybeSource);
        this.f19132a = j;
        this.f19133b = timeUnit;
        this.f19134c = scheduler;
        this.f19135d = z;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ai1(maybeObserver, this.f19132a, this.f19133b, this.f19134c, this.f19135d));
    }
}
