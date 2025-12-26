package p000;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class ey2 {

    /* renamed from: a */
    public static final by2 f17040a = new by2(0);

    /* renamed from: b */
    public static final by2 f17041b = new by2(1);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final int m4762a(Object obj, HashMap hashMap) {
        Integer num = (Integer) hashMap.get(obj);
        if (num != null) {
            return num.intValue();
        }
        boolean isInterface = mo2176d(obj).isInterface();
        Iterator it = mo2175c(obj).iterator();
        int i = isInterface;
        while (it.hasNext()) {
            i = Math.max(i, m4762a(it.next(), hashMap));
        }
        Object mo2177e = mo2177e(obj);
        int i2 = i;
        if (mo2177e != null) {
            i2 = Math.max(i, m4762a(mo2177e, hashMap));
        }
        int i3 = i2 + 1;
        hashMap.put(obj, Integer.valueOf(i3));
        return i3;
    }

    /* renamed from: b */
    public ImmutableList mo4506b(ImmutableCollection immutableCollection) {
        HashMap newHashMap = Maps.newHashMap();
        Iterator<E> it = immutableCollection.iterator();
        while (it.hasNext()) {
            m4762a(it.next(), newHashMap);
        }
        return new l12(Ordering.natural().reverse(), newHashMap).immutableSortedCopy(newHashMap.keySet());
    }

    /* renamed from: c */
    public abstract Iterable mo2175c(Object obj);

    /* renamed from: d */
    public abstract Class mo2176d(Object obj);

    /* renamed from: e */
    public abstract Object mo2177e(Object obj);
}
