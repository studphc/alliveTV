package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {

    /* renamed from: a */
    public final Comparator f19959a;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.f19959a = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0037, code lost:
    
        r3 = null;
     */
    @Override // io.reactivex.rxjava3.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<T> apply(List<T> list, List<T> list2) {
        T t;
        int size = list2.size() + list.size();
        if (size == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = list.iterator();
        Iterator<T> it2 = list2.iterator();
        T next = it.hasNext() ? it.next() : null;
        if (it2.hasNext()) {
            t = it2.next();
            while (next != null && t != null) {
                if (this.f19959a.compare(next, t) < 0) {
                    arrayList.add(next);
                    next = it.hasNext() ? it.next() : null;
                } else {
                    arrayList.add(t);
                    if (it2.hasNext()) {
                        t = it2.next();
                    }
                }
            }
            if (next != null) {
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                arrayList.add(t);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            return arrayList;
        }
        t = null;
    }
}
