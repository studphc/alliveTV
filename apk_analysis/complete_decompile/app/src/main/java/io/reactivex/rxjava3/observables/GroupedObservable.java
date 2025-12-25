package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;

/* loaded from: classes2.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {

    /* renamed from: a */
    public final Object f19968a;

    public GroupedObservable(@Nullable K k) {
        this.f19968a = k;
    }

    @Nullable
    public K getKey() {
        return (K) this.f19968a;
    }
}
