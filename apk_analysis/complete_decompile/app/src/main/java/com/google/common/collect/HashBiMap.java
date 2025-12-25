package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.gz0;
import p000.hz0;
import p000.o63;
import p000.p63;

@GwtCompatible
/* loaded from: classes.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {

    /* renamed from: a */
    public transient Object[] f14642a;

    /* renamed from: b */
    public transient Object[] f14643b;

    /* renamed from: c */
    public transient int f14644c;

    /* renamed from: d */
    public transient int f14645d;

    /* renamed from: e */
    public transient int[] f14646e;

    /* renamed from: f */
    public transient int[] f14647f;

    /* renamed from: g */
    public transient int[] f14648g;

    /* renamed from: h */
    public transient int[] f14649h;

    /* renamed from: i */
    public transient int f14650i;

    /* renamed from: j */
    public transient int f14651j;

    /* renamed from: k */
    public transient int[] f14652k;

    /* renamed from: l */
    public transient int[] f14653l;

    /* renamed from: m */
    public transient gz0 f14654m;

    /* renamed from: n */
    public transient gz0 f14655n;

    /* renamed from: o */
    public transient gz0 f14656o;

    /* renamed from: p */
    public transient hz0 f14657p;

    /* renamed from: c */
    public static int[] m3863c(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        m3870j(16);
        AbstractC0924q2.m4159b(this, objectInputStream, readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        AbstractC0924q2.m4162e(this, objectOutputStream);
    }

    /* renamed from: a */
    public final int m3864a(int i) {
        return i & (this.f14646e.length - 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f14642a, 0, this.f14644c, (Object) null);
        Arrays.fill(this.f14643b, 0, this.f14644c, (Object) null);
        Arrays.fill(this.f14646e, -1);
        Arrays.fill(this.f14647f, -1);
        Arrays.fill(this.f14648g, 0, this.f14644c, -1);
        Arrays.fill(this.f14649h, 0, this.f14644c, -1);
        Arrays.fill(this.f14652k, 0, this.f14644c, -1);
        Arrays.fill(this.f14653l, 0, this.f14644c, -1);
        this.f14644c = 0;
        this.f14650i = -2;
        this.f14651j = -2;
        this.f14645d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (m3868h(o63.m6454N(obj), obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        if (m3869i(o63.m6454N(obj), obj) != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final void m3865e(int i, int i2) {
        boolean z;
        if (i != -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int m3864a = m3864a(i2);
        int[] iArr = this.f14646e;
        int i3 = iArr[m3864a];
        if (i3 == i) {
            int[] iArr2 = this.f14648g;
            iArr[m3864a] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.f14648g[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 != -1) {
                if (i3 == i) {
                    int[] iArr3 = this.f14648g;
                    iArr3[i5] = iArr3[i];
                    iArr3[i] = -1;
                    return;
                }
                i4 = this.f14648g[i3];
            } else {
                String valueOf = String.valueOf(this.f14642a[i]);
                throw new AssertionError(AbstractC1726qj.m7054j(valueOf.length() + 32, "Expected to find entry with key ", valueOf));
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        gz0 gz0Var = this.f14656o;
        if (gz0Var == null) {
            gz0 gz0Var2 = new gz0(this, 0);
            this.f14656o = gz0Var2;
            return gz0Var2;
        }
        return gz0Var;
    }

    /* renamed from: f */
    public final void m3866f(int i, int i2) {
        boolean z;
        if (i != -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int m3864a = m3864a(i2);
        int[] iArr = this.f14647f;
        int i3 = iArr[m3864a];
        if (i3 == i) {
            int[] iArr2 = this.f14649h;
            iArr[m3864a] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.f14649h[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 != -1) {
                if (i3 == i) {
                    int[] iArr3 = this.f14649h;
                    iArr3[i5] = iArr3[i];
                    iArr3[i] = -1;
                    return;
                }
                i4 = this.f14649h[i3];
            } else {
                String valueOf = String.valueOf(this.f14643b[i]);
                throw new AssertionError(AbstractC1726qj.m7054j(valueOf.length() + 34, "Expected to find entry with value ", valueOf));
            }
        }
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V forcePut(K k, V v) {
        return (V) m3873m(k, v, true);
    }

    /* renamed from: g */
    public final void m3867g(int i) {
        int[] iArr = this.f14648g;
        if (iArr.length < i) {
            int m3900a = ImmutableCollection.Builder.m3900a(iArr.length, i);
            this.f14642a = Arrays.copyOf(this.f14642a, m3900a);
            this.f14643b = Arrays.copyOf(this.f14643b, m3900a);
            int[] iArr2 = this.f14648g;
            int length = iArr2.length;
            int[] copyOf = Arrays.copyOf(iArr2, m3900a);
            Arrays.fill(copyOf, length, m3900a, -1);
            this.f14648g = copyOf;
            int[] iArr3 = this.f14649h;
            int length2 = iArr3.length;
            int[] copyOf2 = Arrays.copyOf(iArr3, m3900a);
            Arrays.fill(copyOf2, length2, m3900a, -1);
            this.f14649h = copyOf2;
            int[] iArr4 = this.f14652k;
            int length3 = iArr4.length;
            int[] copyOf3 = Arrays.copyOf(iArr4, m3900a);
            Arrays.fill(copyOf3, length3, m3900a, -1);
            this.f14652k = copyOf3;
            int[] iArr5 = this.f14653l;
            int length4 = iArr5.length;
            int[] copyOf4 = Arrays.copyOf(iArr5, m3900a);
            Arrays.fill(copyOf4, length4, m3900a, -1);
            this.f14653l = copyOf4;
        }
        if (this.f14646e.length < i) {
            int m6465h = o63.m6465h(1.0d, i);
            this.f14646e = m3863c(m6465h);
            this.f14647f = m3863c(m6465h);
            for (int i2 = 0; i2 < this.f14644c; i2++) {
                int m3864a = m3864a(o63.m6454N(this.f14642a[i2]));
                int[] iArr6 = this.f14648g;
                int[] iArr7 = this.f14646e;
                iArr6[i2] = iArr7[m3864a];
                iArr7[m3864a] = i2;
                int m3864a2 = m3864a(o63.m6454N(this.f14643b[i2]));
                int[] iArr8 = this.f14649h;
                int[] iArr9 = this.f14647f;
                iArr8[i2] = iArr9[m3864a2];
                iArr9[m3864a2] = i2;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int m3868h = m3868h(o63.m6454N(obj), obj);
        if (m3868h == -1) {
            return null;
        }
        return (V) this.f14643b[m3868h];
    }

    /* renamed from: h */
    public final int m3868h(int i, Object obj) {
        int[] iArr = this.f14646e;
        int[] iArr2 = this.f14648g;
        Object[] objArr = this.f14642a;
        for (int i2 = iArr[m3864a(i)]; i2 != -1; i2 = iArr2[i2]) {
            if (Objects.equal(objArr[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: i */
    public final int m3869i(int i, Object obj) {
        int[] iArr = this.f14647f;
        int[] iArr2 = this.f14649h;
        Object[] objArr = this.f14643b;
        for (int i2 = iArr[m3864a(i)]; i2 != -1; i2 = iArr2[i2]) {
            if (Objects.equal(objArr[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        hz0 hz0Var = this.f14657p;
        if (hz0Var == null) {
            hz0 hz0Var2 = new hz0(this);
            this.f14657p = hz0Var2;
            return hz0Var2;
        }
        return hz0Var;
    }

    /* renamed from: j */
    public final void m3870j(int i) {
        p63.m6869m(i, "expectedSize");
        int m6465h = o63.m6465h(1.0d, i);
        this.f14644c = 0;
        this.f14642a = new Object[i];
        this.f14643b = new Object[i];
        this.f14646e = m3863c(m6465h);
        this.f14647f = m3863c(m6465h);
        this.f14648g = m3863c(i);
        this.f14649h = m3863c(i);
        this.f14650i = -2;
        this.f14651j = -2;
        this.f14652k = m3863c(i);
        this.f14653l = m3863c(i);
    }

    /* renamed from: k */
    public final void m3871k(int i, int i2) {
        boolean z;
        if (i != -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int m3864a = m3864a(i2);
        int[] iArr = this.f14648g;
        int[] iArr2 = this.f14646e;
        iArr[i] = iArr2[m3864a];
        iArr2[m3864a] = i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        gz0 gz0Var = this.f14654m;
        if (gz0Var == null) {
            gz0 gz0Var2 = new gz0(this, 1);
            this.f14654m = gz0Var2;
            return gz0Var2;
        }
        return gz0Var;
    }

    /* renamed from: l */
    public final void m3872l(int i, int i2) {
        boolean z;
        if (i != -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int m3864a = m3864a(i2);
        int[] iArr = this.f14649h;
        int[] iArr2 = this.f14647f;
        iArr[i] = iArr2[m3864a];
        iArr2[m3864a] = i;
    }

    /* renamed from: m */
    public final Object m3873m(Object obj, Object obj2, boolean z) {
        boolean z2;
        int m6454N = o63.m6454N(obj);
        int m3868h = m3868h(m6454N, obj);
        if (m3868h != -1) {
            Object obj3 = this.f14643b[m3868h];
            if (Objects.equal(obj3, obj2)) {
                return obj2;
            }
            m3879s(obj2, m3868h, z);
            return obj3;
        }
        int m6454N2 = o63.m6454N(obj2);
        int m3869i = m3869i(m6454N2, obj2);
        if (z) {
            if (m3869i != -1) {
                m3877q(m3869i, m6454N2);
            }
        } else {
            if (m3869i == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Value already present: %s", obj2);
        }
        m3867g(this.f14644c + 1);
        Object[] objArr = this.f14642a;
        int i = this.f14644c;
        objArr[i] = obj;
        this.f14643b[i] = obj2;
        m3871k(i, m6454N);
        m3872l(this.f14644c, m6454N2);
        m3880t(this.f14651j, this.f14644c);
        m3880t(this.f14644c, -2);
        this.f14644c++;
        this.f14645d++;
        return null;
    }

    /* renamed from: n */
    public final Object m3874n(Object obj, Object obj2, boolean z) {
        boolean z2;
        int i;
        int m6454N = o63.m6454N(obj);
        int m3869i = m3869i(m6454N, obj);
        if (m3869i != -1) {
            Object obj3 = this.f14642a[m3869i];
            if (Objects.equal(obj3, obj2)) {
                return obj2;
            }
            m3878r(obj2, m3869i, z);
            return obj3;
        }
        int i2 = this.f14651j;
        int m6454N2 = o63.m6454N(obj2);
        int m3868h = m3868h(m6454N2, obj2);
        if (z) {
            if (m3868h != -1) {
                i2 = this.f14652k[m3868h];
                m3876p(m3868h, m6454N2);
            }
        } else {
            if (m3868h == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Key already present: %s", obj2);
        }
        m3867g(this.f14644c + 1);
        Object[] objArr = this.f14642a;
        int i3 = this.f14644c;
        objArr[i3] = obj2;
        this.f14643b[i3] = obj;
        m3871k(i3, m6454N2);
        m3872l(this.f14644c, m6454N);
        if (i2 == -2) {
            i = this.f14650i;
        } else {
            i = this.f14653l[i2];
        }
        m3880t(i2, this.f14644c);
        m3880t(this.f14644c, i);
        this.f14644c++;
        this.f14645d++;
        return null;
    }

    /* renamed from: o */
    public final void m3875o(int i, int i2, int i3) {
        boolean z;
        int i4;
        int i5;
        if (i != -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        m3865e(i, i2);
        m3866f(i, i3);
        m3880t(this.f14652k[i], this.f14653l[i]);
        int i6 = this.f14644c - 1;
        if (i6 != i) {
            int i7 = this.f14652k[i6];
            int i8 = this.f14653l[i6];
            m3880t(i7, i);
            m3880t(i, i8);
            Object[] objArr = this.f14642a;
            Object obj = objArr[i6];
            Object[] objArr2 = this.f14643b;
            Object obj2 = objArr2[i6];
            objArr[i] = obj;
            objArr2[i] = obj2;
            int m3864a = m3864a(o63.m6454N(obj));
            int[] iArr = this.f14646e;
            int i9 = iArr[m3864a];
            if (i9 == i6) {
                iArr[m3864a] = i;
            } else {
                int i10 = this.f14648g[i9];
                while (true) {
                    i4 = i9;
                    i9 = i10;
                    if (i9 == i6) {
                        break;
                    } else {
                        i10 = this.f14648g[i9];
                    }
                }
                this.f14648g[i4] = i;
            }
            int[] iArr2 = this.f14648g;
            iArr2[i] = iArr2[i6];
            iArr2[i6] = -1;
            int m3864a2 = m3864a(o63.m6454N(obj2));
            int[] iArr3 = this.f14647f;
            int i11 = iArr3[m3864a2];
            if (i11 == i6) {
                iArr3[m3864a2] = i;
            } else {
                int i12 = this.f14649h[i11];
                while (true) {
                    i5 = i11;
                    i11 = i12;
                    if (i11 == i6) {
                        break;
                    } else {
                        i12 = this.f14649h[i11];
                    }
                }
                this.f14649h[i5] = i;
            }
            int[] iArr4 = this.f14649h;
            iArr4[i] = iArr4[i6];
            iArr4[i6] = -1;
        }
        Object[] objArr3 = this.f14642a;
        int i13 = this.f14644c;
        objArr3[i13 - 1] = null;
        this.f14643b[i13 - 1] = null;
        this.f14644c = i13 - 1;
        this.f14645d++;
    }

    /* renamed from: p */
    public final void m3876p(int i, int i2) {
        m3875o(i, i2, o63.m6454N(this.f14643b[i]));
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k, V v) {
        return (V) m3873m(k, v, false);
    }

    /* renamed from: q */
    public final void m3877q(int i, int i2) {
        m3875o(i, o63.m6454N(this.f14642a[i]), i2);
    }

    /* renamed from: r */
    public final void m3878r(Object obj, int i, boolean z) {
        boolean z2;
        int i2;
        if (i != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        int m6454N = o63.m6454N(obj);
        int m3868h = m3868h(m6454N, obj);
        int i3 = this.f14651j;
        if (m3868h != -1) {
            if (z) {
                i3 = this.f14652k[m3868h];
                i2 = this.f14653l[m3868h];
                m3876p(m3868h, m6454N);
                if (i == this.f14644c) {
                    i = m3868h;
                }
            } else {
                String valueOf = String.valueOf(obj);
                throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 28, "Key already present in map: ", valueOf));
            }
        } else {
            i2 = -2;
        }
        if (i3 == i) {
            i3 = this.f14652k[i];
        } else if (i3 == this.f14644c) {
            i3 = m3868h;
        }
        if (i2 == i) {
            m3868h = this.f14653l[i];
        } else if (i2 != this.f14644c) {
            m3868h = i2;
        }
        m3880t(this.f14652k[i], this.f14653l[i]);
        m3865e(i, o63.m6454N(this.f14642a[i]));
        this.f14642a[i] = obj;
        m3871k(i, o63.m6454N(obj));
        m3880t(i3, i);
        m3880t(i, m3868h);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        int m6454N = o63.m6454N(obj);
        int m3868h = m3868h(m6454N, obj);
        if (m3868h == -1) {
            return null;
        }
        V v = (V) this.f14643b[m3868h];
        m3876p(m3868h, m6454N);
        return v;
    }

    /* renamed from: s */
    public final void m3879s(Object obj, int i, boolean z) {
        boolean z2;
        if (i != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        int m6454N = o63.m6454N(obj);
        int m3869i = m3869i(m6454N, obj);
        if (m3869i != -1) {
            if (z) {
                m3877q(m3869i, m6454N);
                if (i == this.f14644c) {
                    i = m3869i;
                }
            } else {
                String valueOf = String.valueOf(obj);
                throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 30, "Value already present in map: ", valueOf));
            }
        }
        m3866f(i, o63.m6454N(this.f14643b[i]));
        this.f14643b[i] = obj;
        m3872l(i, m6454N);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f14644c;
    }

    /* renamed from: t */
    public final void m3880t(int i, int i2) {
        if (i == -2) {
            this.f14650i = i2;
        } else {
            this.f14653l[i] = i2;
        }
        if (i2 == -2) {
            this.f14651j = i;
        } else {
            this.f14652k[i2] = i;
        }
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        HashBiMap<K, V> hashBiMap = (HashBiMap<K, V>) new AbstractMap();
        hashBiMap.m3870j(i);
        return hashBiMap;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        gz0 gz0Var = this.f14655n;
        if (gz0Var != null) {
            return gz0Var;
        }
        gz0 gz0Var2 = new gz0(this, 2);
        this.f14655n = gz0Var2;
        return gz0Var2;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
