package io.reactivex.rxjava3.flowables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;

/* loaded from: classes2.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {

    /* renamed from: b */
    public final Object f18512b;

    public GroupedFlowable(@Nullable K k) {
        this.f18512b = k;
    }

    @Nullable
    public K getKey() {
        return (K) this.f18512b;
    }
}
