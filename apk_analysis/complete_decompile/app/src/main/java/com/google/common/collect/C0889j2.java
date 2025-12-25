package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.Iterator;

/* renamed from: com.google.common.collect.j2 */
/* loaded from: classes.dex */
public final class C0889j2 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object[] f14856a;

    /* renamed from: b */
    public final int[] f14857b;

    public C0889j2(C0894k2 c0894k2) {
        int size = c0894k2.entrySet().size();
        this.f14856a = new Object[size];
        this.f14857b = new int[size];
        Iterator it = c0894k2.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            this.f14856a[i] = entry.getElement();
            this.f14857b[i] = entry.getCount();
            i++;
        }
    }

    public Object readResolve() {
        Object[] objArr = this.f14856a;
        ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            builder.addCopies(objArr[i], this.f14857b[i]);
        }
        return builder.build();
    }
}
