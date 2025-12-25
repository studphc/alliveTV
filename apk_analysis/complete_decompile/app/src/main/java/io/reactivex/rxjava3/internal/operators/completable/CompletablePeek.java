package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import p000.C2068zs;

/* loaded from: classes2.dex */
public final class CompletablePeek extends Completable {

    /* renamed from: a */
    public final CompletableSource f18694a;

    /* renamed from: b */
    public final Consumer f18695b;

    /* renamed from: c */
    public final Consumer f18696c;

    /* renamed from: d */
    public final Action f18697d;

    /* renamed from: e */
    public final Action f18698e;

    /* renamed from: f */
    public final Action f18699f;

    /* renamed from: g */
    public final Action f18700g;

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f18694a = completableSource;
        this.f18695b = consumer;
        this.f18696c = consumer2;
        this.f18697d = action;
        this.f18698e = action2;
        this.f18699f = action3;
        this.f18700g = action4;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18694a.subscribe(new C2068zs(this, completableObserver));
    }
}
