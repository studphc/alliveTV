package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;

/* renamed from: com.google.common.collect.b0 */
/* loaded from: classes.dex */
public class C0847b0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object[] f14775a;

    /* renamed from: b */
    public final Object[] f14776b;

    public C0847b0(ImmutableMap immutableMap) {
        Object[] objArr = new Object[immutableMap.size()];
        Object[] objArr2 = new Object[immutableMap.size()];
        UnmodifiableIterator it = immutableMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            objArr[i] = entry.getKey();
            objArr2[i] = entry.getValue();
            i++;
        }
        this.f14775a = objArr;
        this.f14776b = objArr2;
    }

    /* renamed from: a */
    public ImmutableMap.Builder mo4084a(int i) {
        return new ImmutableMap.Builder(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object readResolve() {
        Object[] objArr = this.f14775a;
        boolean z = objArr instanceof ImmutableSet;
        Object[] objArr2 = this.f14776b;
        if (!z) {
            ImmutableMap.Builder mo4084a = mo4084a(objArr.length);
            for (int i = 0; i < objArr.length; i++) {
                mo4084a.put(objArr[i], objArr2[i]);
            }
            return mo4084a.buildOrThrow();
        }
        ImmutableSet immutableSet = (ImmutableSet) objArr;
        ImmutableMap.Builder mo4084a2 = mo4084a(immutableSet.size());
        UnmodifiableIterator it = immutableSet.iterator();
        UnmodifiableIterator it2 = ((ImmutableCollection) objArr2).iterator();
        while (it.hasNext()) {
            mo4084a2.put(it.next(), it2.next());
        }
        return mo4084a2.buildOrThrow();
    }
}
