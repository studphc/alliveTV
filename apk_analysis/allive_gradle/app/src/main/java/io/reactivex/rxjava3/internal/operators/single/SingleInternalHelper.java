package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import p000.i12;
import p000.mj2;
import p000.nj2;

/* loaded from: classes2.dex */
public final class SingleInternalHelper {
    public static Supplier<NoSuchElementException> emptyThrower() {
        return mj2.f22961a;
    }

    public static <T> Iterable<? extends Flowable<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> iterable) {
        return new i12(iterable, 1);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable() {
        return nj2.f23383a;
    }
}
