package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface MaybeOperator<Downstream, Upstream> {
    @NonNull
    MaybeObserver<? super Upstream> apply(@NonNull MaybeObserver<? super Downstream> maybeObserver);
}
