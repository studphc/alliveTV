package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ParallelFlatMapStream<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f18572a;

    /* renamed from: b */
    public final Function f18573b;

    /* renamed from: c */
    public final int f18574c;

    public ParallelFlatMapStream(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        this.f18572a = parallelFlowable;
        this.f18573b = function;
        this.f18574c = i;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f18572a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (!validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            subscriberArr2[i] = FlowableFlatMapStream.subscribe(subscriberArr[i], this.f18573b, this.f18574c);
        }
        this.f18572a.subscribe(subscriberArr2);
    }
}
