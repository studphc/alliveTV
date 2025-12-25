package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {

    /* renamed from: a */
    public final Comparator f19966a;

    public SorterFunction(Comparator<? super T> comparator) {
        this.f19966a = comparator;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public List<T> apply(List<T> list) {
        Collections.sort(list, this.f19966a);
        return list;
    }
}
