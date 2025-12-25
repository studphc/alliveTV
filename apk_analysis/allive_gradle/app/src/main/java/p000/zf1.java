package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class zf1 extends AbstractMap implements ConcurrentMap, Serializable {

    /* renamed from: j */
    public static final we1 f29349j = new Object();
    private static final long serialVersionUID = 5;

    /* renamed from: a */
    public final transient int f29350a;

    /* renamed from: b */
    public final transient int f29351b;

    /* renamed from: c */
    public final transient ef1[] f29352c;

    /* renamed from: d */
    public final int f29353d;

    /* renamed from: e */
    public final Equivalence f29354e;

    /* renamed from: f */
    public final transient df1 f29355f;

    /* renamed from: g */
    public transient bf1 f29356g;

    /* renamed from: h */
    public transient C0578c2 f29357h;

    /* renamed from: i */
    public transient bf1 f29358i;

    public zf1(MapMaker mapMaker, df1 df1Var) {
        int i = mapMaker.f14732c;
        this.f29353d = Math.min(i == -1 ? 4 : i, 65536);
        this.f29354e = (Equivalence) MoreObjects.firstNonNull(mapMaker.f14735f, mapMaker.m4043a().mo4950a());
        this.f29355f = df1Var;
        int i2 = mapMaker.f14731b;
        int min = Math.min(i2 == -1 ? 16 : i2, 1073741824);
        int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i5 < this.f29353d) {
            i6++;
            i5 <<= 1;
        }
        this.f29351b = 32 - i6;
        this.f29350a = i5 - 1;
        this.f29352c = new ef1[i5];
        int i7 = min / i5;
        while (i3 < (i5 * i7 < min ? i7 + 1 : i7)) {
            i3 <<= 1;
        }
        while (true) {
            ef1[] ef1VarArr = this.f29352c;
            if (i4 < ef1VarArr.length) {
                ef1VarArr[i4] = this.f29355f.mo4573b(this, i3);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static ArrayList m8413a(AbstractCollection abstractCollection) {
        ArrayList arrayList = new ArrayList(abstractCollection.size());
        Iterators.addAll(arrayList, abstractCollection.iterator());
        return arrayList;
    }

    /* renamed from: c */
    public final int m8414c(Object obj) {
        int hash = this.f29354e.hash(obj);
        int i = hash + ((hash << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = (i4 << 2) + (i4 << 14) + i4;
        return (i5 >>> 16) ^ i5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        for (ef1 ef1Var : this.f29352c) {
            if (ef1Var.f16787b != 0) {
                ef1Var.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = ef1Var.f16790e;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    ef1Var.mo4704e();
                    ef1Var.f16791f.set(0);
                    ef1Var.f16788c++;
                    ef1Var.f16787b = 0;
                    ef1Var.unlock();
                } catch (Throwable th) {
                    ef1Var.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        cf1 m4703d;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        int m8414c = m8414c(obj);
        ef1 m8415e = m8415e(m8414c);
        m8415e.getClass();
        try {
            if (m8415e.f16787b != 0 && (m4703d = m8415e.m4703d(m8414c, obj)) != null) {
                if (m4703d.getValue() != null) {
                    z = true;
                }
            }
            return z;
        } finally {
            m8415e.m4706g();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Object value;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        ef1[] ef1VarArr = this.f29352c;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = ef1VarArr.length;
            long j2 = 0;
            for (?? r10 = z; r10 < length; r10++) {
                ef1 ef1Var = ef1VarArr[r10];
                int i2 = ef1Var.f16787b;
                ?? r12 = ef1Var.f16790e;
                for (?? r13 = z; r13 < r12.length(); r13++) {
                    for (cf1 cf1Var = (cf1) r12.get(r13); cf1Var != null; cf1Var = cf1Var.mo2229a()) {
                        if (cf1Var.getKey() == null) {
                            ef1Var.m4712m();
                        } else {
                            value = cf1Var.getValue();
                            if (value == null) {
                                ef1Var.m4712m();
                            }
                            if (value == null && this.f29355f.mo4575d().mo4950a().equivalent(obj, value)) {
                                return true;
                            }
                        }
                        value = null;
                        if (value == null) {
                        }
                    }
                }
                j2 += ef1Var.f16788c;
                z = false;
            }
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            z = false;
        }
        return z;
    }

    /* renamed from: e */
    public final ef1 m8415e(int i) {
        return this.f29352c[(i >>> this.f29351b) & this.f29350a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        bf1 bf1Var = this.f29358i;
        if (bf1Var == null) {
            bf1 bf1Var2 = new bf1(this, 0);
            this.f29358i = bf1Var2;
            return bf1Var2;
        }
        return bf1Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = null;
        if (obj == null) {
            return null;
        }
        int m8414c = m8414c(obj);
        ef1 m8415e = m8415e(m8414c);
        m8415e.getClass();
        try {
            cf1 m4703d = m8415e.m4703d(m8414c, obj);
            if (m4703d != null && (obj2 = m4703d.getValue()) == null) {
                m8415e.m4712m();
            }
            return obj2;
        } finally {
            m8415e.m4706g();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        ef1[] ef1VarArr = this.f29352c;
        long j = 0;
        for (int i = 0; i < ef1VarArr.length; i++) {
            if (ef1VarArr[i].f16787b != 0) {
                return false;
            }
            j += ef1VarArr[i].f16788c;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < ef1VarArr.length; i2++) {
            if (ef1VarArr[i2].f16787b != 0) {
                return false;
            }
            j -= ef1VarArr[i2].f16788c;
        }
        if (j != 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        bf1 bf1Var = this.f29356g;
        if (bf1Var == null) {
            bf1 bf1Var2 = new bf1(this, 1);
            this.f29356g = bf1Var2;
            return bf1Var2;
        }
        return bf1Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int m8414c = m8414c(obj);
        return m8415e(m8414c).m4707h(m8414c, obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int m8414c = m8414c(obj);
        return m8415e(m8414c).m4707h(m8414c, obj, obj2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r10 = r6.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r10 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        r2.f16788c++;
        r0 = r2.m4708i(r5, r6);
        r1 = r2.f16787b - 1;
        r3.set(r4, r0);
        r2.f16787b = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        if (r6.getValue() != null) goto L22;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int m8414c = m8414c(obj);
        ef1 m8415e = m8415e(m8414c);
        m8415e.lock();
        try {
            m8415e.m4709j();
            AtomicReferenceArray atomicReferenceArray = m8415e.f16790e;
            int length = (atomicReferenceArray.length() - 1) & m8414c;
            cf1 cf1Var = (cf1) atomicReferenceArray.get(length);
            cf1 cf1Var2 = cf1Var;
            while (true) {
                if (cf1Var2 == null) {
                    break;
                }
                Object key = cf1Var2.getKey();
                if (cf1Var2.mo2230c() == m8414c && key != null && m8415e.f16786a.f29354e.equivalent(obj, key)) {
                    break;
                }
                cf1Var2 = cf1Var2.mo2229a();
            }
            return null;
        } finally {
            m8415e.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj3);
        if (obj2 == null) {
            return false;
        }
        int m8414c = m8414c(obj);
        ef1 m8415e = m8415e(m8414c);
        m8415e.lock();
        try {
            m8415e.m4709j();
            AtomicReferenceArray atomicReferenceArray = m8415e.f16790e;
            int length = (atomicReferenceArray.length() - 1) & m8414c;
            cf1 cf1Var = (cf1) atomicReferenceArray.get(length);
            cf1 cf1Var2 = cf1Var;
            while (true) {
                if (cf1Var2 == null) {
                    break;
                }
                Object key = cf1Var2.getKey();
                if (cf1Var2.mo2230c() == m8414c && key != null && m8415e.f16786a.f29354e.equivalent(obj, key)) {
                    Object value = cf1Var2.getValue();
                    if (value == null) {
                        if (cf1Var2.getValue() == null) {
                            m8415e.f16788c++;
                            cf1 m4708i = m8415e.m4708i(cf1Var, cf1Var2);
                            int i = m8415e.f16787b - 1;
                            atomicReferenceArray.set(length, m4708i);
                            m8415e.f16787b = i;
                        }
                    } else if (m8415e.f16786a.f29355f.mo4575d().mo4950a().equivalent(obj2, value)) {
                        m8415e.f16788c++;
                        m8415e.m4711l(cf1Var2, obj3);
                        return true;
                    }
                } else {
                    cf1Var2 = cf1Var2.mo2229a();
                }
            }
            return false;
        } finally {
            m8415e.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long j = 0;
        for (int i = 0; i < this.f29352c.length; i++) {
            j += r0[i].f16787b;
        }
        return Ints.saturatedCast(j);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        C0578c2 c0578c2 = this.f29357h;
        if (c0578c2 == null) {
            C0578c2 c0578c22 = new C0578c2(7, this);
            this.f29357h = c0578c22;
            return c0578c22;
        }
        return c0578c2;
    }

    public Object writeReplace() {
        df1 df1Var = this.f29355f;
        if1 mo4574c = df1Var.mo4574c();
        if1 mo4575d = df1Var.mo4575d();
        df1Var.mo4575d().mo4950a();
        return new xe1(mo4574c, mo4575d, this.f29354e, this.f29353d, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        if (r2.f16786a.f29355f.mo4575d().mo4950a().equivalent(r12, r7.getValue()) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        r2.f16788c++;
        r11 = r2.m4708i(r6, r7);
        r12 = r2.f16787b - 1;
        r3.set(r4, r11);
        r2.f16787b = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        if (r7.getValue() != null) goto L20;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(Object obj, Object obj2) {
        boolean z = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int m8414c = m8414c(obj);
        ef1 m8415e = m8415e(m8414c);
        m8415e.lock();
        try {
            m8415e.m4709j();
            AtomicReferenceArray atomicReferenceArray = m8415e.f16790e;
            int length = (atomicReferenceArray.length() - 1) & m8414c;
            cf1 cf1Var = (cf1) atomicReferenceArray.get(length);
            cf1 cf1Var2 = cf1Var;
            while (true) {
                if (cf1Var2 == null) {
                    break;
                }
                Object key = cf1Var2.getKey();
                if (cf1Var2.mo2230c() == m8414c && key != null && m8415e.f16786a.f29354e.equivalent(obj, key)) {
                    break;
                }
                cf1Var2 = cf1Var2.mo2229a();
            }
            return z;
        } finally {
            m8415e.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        return null;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object replace(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int m8414c = m8414c(obj);
        ef1 m8415e = m8415e(m8414c);
        m8415e.lock();
        try {
            m8415e.m4709j();
            AtomicReferenceArray atomicReferenceArray = m8415e.f16790e;
            int length = (atomicReferenceArray.length() - 1) & m8414c;
            cf1 cf1Var = (cf1) atomicReferenceArray.get(length);
            cf1 cf1Var2 = cf1Var;
            while (true) {
                if (cf1Var2 == null) {
                    break;
                }
                Object key = cf1Var2.getKey();
                if (cf1Var2.mo2230c() == m8414c && key != null && m8415e.f16786a.f29354e.equivalent(obj, key)) {
                    Object value = cf1Var2.getValue();
                    if (value == null) {
                        if (cf1Var2.getValue() == null) {
                            m8415e.f16788c++;
                            cf1 m4708i = m8415e.m4708i(cf1Var, cf1Var2);
                            int i = m8415e.f16787b - 1;
                            atomicReferenceArray.set(length, m4708i);
                            m8415e.f16787b = i;
                        }
                    } else {
                        m8415e.f16788c++;
                        m8415e.m4711l(cf1Var2, obj2);
                        return value;
                    }
                } else {
                    cf1Var2 = cf1Var2.mo2229a();
                }
            }
        } finally {
            m8415e.unlock();
        }
    }
}
