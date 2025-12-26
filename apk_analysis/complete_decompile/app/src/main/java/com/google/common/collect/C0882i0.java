package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.google.common.collect.i0 */
/* loaded from: classes.dex */
public final class C0882i0 implements Serializable {

    /* renamed from: a */
    public final Comparator f14847a;

    /* renamed from: b */
    public final Object[] f14848b;

    /* renamed from: c */
    public final int[] f14849c;

    public C0882i0(ImmutableSortedMultiset immutableSortedMultiset) {
        this.f14847a = immutableSortedMultiset.comparator();
        int size = immutableSortedMultiset.entrySet().size();
        this.f14848b = new Object[size];
        this.f14849c = new int[size];
        Iterator it = immutableSortedMultiset.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            this.f14848b[i] = entry.getElement();
            this.f14849c[i] = entry.getCount();
            i++;
        }
    }

    public Object readResolve() {
        Object[] objArr = this.f14848b;
        int length = objArr.length;
        ImmutableSortedMultiset.Builder builder = new ImmutableSortedMultiset.Builder(this.f14847a);
        for (int i = 0; i < length; i++) {
            builder.addCopies((ImmutableSortedMultiset.Builder) objArr[i], this.f14849c[i]);
        }
        return builder.build();
    }
}
