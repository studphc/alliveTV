package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import p000.g50;
import p000.ie2;
import p000.le2;
import p000.ne2;

/* loaded from: classes2.dex */
public class SchedulerWhen extends Scheduler implements Disposable {

    /* renamed from: f */
    public static final ne2 f19868f = new Object();

    /* renamed from: g */
    public static final Disposable f19869g = g50.m4919a();

    /* renamed from: c */
    public final Scheduler f19870c;

    /* renamed from: d */
    public final FlowableProcessor f19871d;

    /* renamed from: e */
    public final Disposable f19872e;

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.f19870c = scheduler;
        FlowableProcessor<T> serialized = UnicastProcessor.create().toSerialized();
        this.f19871d = serialized;
        try {
            this.f19872e = function.apply(serialized).subscribe();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.f19870c.createWorker();
        FlowableProcessor<T> serialized = UnicastProcessor.create().toSerialized();
        Flowable map = serialized.map(new ie2(createWorker));
        le2 le2Var = new le2(serialized, createWorker);
        this.f19871d.onNext(map);
        return le2Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f19872e.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f19872e.isDisposed();
    }
}
