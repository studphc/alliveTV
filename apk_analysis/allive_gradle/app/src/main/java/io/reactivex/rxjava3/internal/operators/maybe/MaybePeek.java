package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import p000.AbstractC0003a2;
import p000.bi1;

/* loaded from: classes2.dex */
public final class MaybePeek<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Consumer f19193a;

    /* renamed from: b */
    public final Consumer f19194b;

    /* renamed from: c */
    public final Consumer f19195c;

    /* renamed from: d */
    public final Action f19196d;

    /* renamed from: e */
    public final Action f19197e;

    /* renamed from: f */
    public final Action f19198f;

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.f19193a = consumer;
        this.f19194b = consumer2;
        this.f19195c = consumer3;
        this.f19196d = action;
        this.f19197e = action2;
        this.f19198f = action3;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new bi1(4, maybeObserver, this));
    }
}
