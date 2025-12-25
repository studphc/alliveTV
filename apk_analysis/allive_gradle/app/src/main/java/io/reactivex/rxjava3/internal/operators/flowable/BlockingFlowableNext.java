package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.Iterator;
import org.reactivestreams.Publisher;
import p000.C0018ah;
import p000.C2056zg;

/* loaded from: classes2.dex */
public final class BlockingFlowableNext<T> implements Iterable<T> {

    /* renamed from: a */
    public final Publisher f18729a;

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.f18729a = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new C2056zg(this.f18729a, new C0018ah(), 0);
    }
}
