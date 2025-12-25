package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.p63;
import p000.r90;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class EnumMultiset<E extends Enum<E>> extends AbstractC0856d implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient Class f14630c;

    /* renamed from: d */
    public transient Enum[] f14631d;

    /* renamed from: e */
    public transient int[] f14632e;

    /* renamed from: f */
    public transient int f14633f;

    /* renamed from: g */
    public transient long f14634g;

    public EnumMultiset(Class cls) {
        this.f14630c = cls;
        Preconditions.checkArgument(cls.isEnum());
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.f14631d = enumArr;
        this.f14632e = new int[enumArr.length];
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Class cls = (Class) objectInputStream.readObject();
        this.f14630c = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.f14631d = enumArr;
        this.f14632e = new int[enumArr.length];
        AbstractC0924q2.m4161d(this, objectInputStream, objectInputStream.readInt());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f14630c);
        AbstractC0924q2.m4164g(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public final int mo3838b() {
        return this.f14633f;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        return new r90(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.f14632e, 0);
        this.f14634g = 0L;
        this.f14633f = 0;
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        if (obj != null && m3854f(obj)) {
            return this.f14632e[((Enum) obj).ordinal()];
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0937u(this);
    }

    /* renamed from: e */
    public final void m3853e(Enum r6) {
        Preconditions.checkNotNull(r6);
        if (m3854f(r6)) {
            return;
        }
        String valueOf = String.valueOf(this.f14630c);
        String valueOf2 = String.valueOf(r6);
        throw new ClassCastException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 21, "Expected an ", valueOf, " but got ", valueOf2));
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* renamed from: f */
    public final boolean m3854f(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        int ordinal = r5.ordinal();
        Enum[] enumArr = this.f14631d;
        if (ordinal >= enumArr.length || enumArr[ordinal] != r5) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractC0856d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.m4062c(this);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i) {
        if (obj == null || !m3854f(obj)) {
            return 0;
        }
        Enum r1 = (Enum) obj;
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = r1.ordinal();
        int[] iArr = this.f14632e;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.f14633f--;
            this.f14634g -= i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.f14634g -= i;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.f14634g);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        m3853e(e);
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i2 = this.f14632e[ordinal];
        long j = i;
        long j2 = i2 + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.f14632e[ordinal] = (int) j2;
        if (i2 == 0) {
            this.f14633f++;
        }
        this.f14634g += j;
        return i2;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(Object obj, int i, int i2) {
        return Multisets.m4064e(this, obj, i, i2);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        m3853e(e);
        p63.m6869m(i, "count");
        int ordinal = e.ordinal();
        int[] iArr = this.f14632e;
        int i2 = iArr[ordinal];
        iArr[ordinal] = i;
        this.f14634g += i - i2;
        if (i2 == 0 && i > 0) {
            this.f14633f++;
        } else if (i2 > 0 && i == 0) {
            this.f14633f--;
        }
        return i2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }
}
