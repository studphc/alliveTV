package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* renamed from: kr */
/* loaded from: classes.dex */
public class C1484kr extends AbstractSet implements Serializable {

    /* renamed from: a */
    public transient Object f22160a;

    /* renamed from: b */
    public transient int[] f22161b;

    /* renamed from: c */
    public transient Object[] f22162c;

    /* renamed from: d */
    public transient int f22163d;

    /* renamed from: e */
    public transient int f22164e;

    public C1484kr(int i) {
        mo5772h(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kr, java.util.AbstractSet] */
    /* renamed from: d */
    public static C1484kr m5765d() {
        ?? abstractSet = new AbstractSet();
        abstractSet.mo5772h(3);
        return abstractSet;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            mo5772h(readInt);
            for (int i = 0; i < readInt; i++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException(ye0.m8290j(25, readInt, "Invalid size: "));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    /* renamed from: a */
    public int mo5766a(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int min;
        if (m5775k()) {
            mo5767b();
        }
        Set m5769e = m5769e();
        if (m5769e != null) {
            return m5769e.add(obj);
        }
        int[] m5777m = m5777m();
        Object[] m5776l = m5776l();
        int i = this.f22164e;
        int i2 = i + 1;
        int m6454N = o63.m6454N(obj);
        int i3 = (1 << (this.f22163d & 31)) - 1;
        int i4 = m6454N & i3;
        Object obj2 = this.f22160a;
        Objects.requireNonNull(obj2);
        int m8341P = yy2.m8341P(i4, obj2);
        if (m8341P == 0) {
            if (i2 > i3) {
                i3 = m5779o(i3, yy2.m8335E(i3), m6454N, i);
            } else {
                Object obj3 = this.f22160a;
                Objects.requireNonNull(obj3);
                yy2.m8342Q(i4, i2, obj3);
            }
        } else {
            int i5 = ~i3;
            int i6 = m6454N & i5;
            int i7 = 0;
            while (true) {
                int i8 = m8341P - 1;
                int i9 = m5777m[i8];
                if ((i9 & i5) == i6 && com.google.common.base.Objects.equal(obj, m5776l[i8])) {
                    return false;
                }
                int i10 = i9 & i3;
                i7++;
                if (i10 == 0) {
                    if (i7 >= 9) {
                        return mo5768c().add(obj);
                    }
                    if (i2 > i3) {
                        i3 = m5779o(i3, yy2.m8335E(i3), m6454N, i);
                    } else {
                        m5777m[i8] = yy2.m8334D(i9, i2, i3);
                    }
                } else {
                    m8341P = i10;
                }
            }
        }
        int length = m5777m().length;
        if (i2 > length && (min = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            mo5778n(min);
        }
        mo5773i(i, m6454N, i3, obj);
        this.f22164e = i2;
        this.f22163d += 32;
        return true;
    }

    /* renamed from: b */
    public int mo5767b() {
        Preconditions.checkState(m5775k(), "Arrays already allocated");
        int i = this.f22163d;
        int max = Math.max(4, o63.m6465h(1.0d, i + 1));
        this.f22160a = yy2.m8367m(max);
        this.f22163d = yy2.m8334D(this.f22163d, 32 - Integer.numberOfLeadingZeros(max - 1), 31);
        this.f22161b = new int[i];
        this.f22162c = new Object[i];
        return i;
    }

    /* renamed from: c */
    public LinkedHashSet mo5768c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(1 << (this.f22163d & 31), 1.0f);
        int mo5770f = mo5770f();
        while (mo5770f >= 0) {
            linkedHashSet.add(m5776l()[mo5770f]);
            mo5770f = mo5771g(mo5770f);
        }
        this.f22160a = linkedHashSet;
        this.f22161b = null;
        this.f22162c = null;
        this.f22163d += 32;
        return linkedHashSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (m5775k()) {
            return;
        }
        this.f22163d += 32;
        Set m5769e = m5769e();
        if (m5769e != null) {
            this.f22163d = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            m5769e.clear();
            this.f22160a = null;
            this.f22164e = 0;
            return;
        }
        Arrays.fill(m5776l(), 0, this.f22164e, (Object) null);
        Object obj = this.f22160a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(m5777m(), 0, this.f22164e, 0);
        this.f22164e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (m5775k()) {
            return false;
        }
        Set m5769e = m5769e();
        if (m5769e != null) {
            return m5769e.contains(obj);
        }
        int m6454N = o63.m6454N(obj);
        int i = (1 << (this.f22163d & 31)) - 1;
        Object obj2 = this.f22160a;
        Objects.requireNonNull(obj2);
        int m8341P = yy2.m8341P(m6454N & i, obj2);
        if (m8341P == 0) {
            return false;
        }
        int i2 = ~i;
        int i3 = m6454N & i2;
        do {
            int i4 = m8341P - 1;
            int i5 = m5777m()[i4];
            if ((i5 & i2) == i3 && com.google.common.base.Objects.equal(obj, m5776l()[i4])) {
                return true;
            }
            m8341P = i5 & i;
        } while (m8341P != 0);
        return false;
    }

    /* renamed from: e */
    public final Set m5769e() {
        Object obj = this.f22160a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    /* renamed from: f */
    public int mo5770f() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    /* renamed from: g */
    public int mo5771g(int i) {
        int i2 = i + 1;
        if (i2 >= this.f22164e) {
            return -1;
        }
        return i2;
    }

    /* renamed from: h */
    public void mo5772h(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected size must be >= 0");
        this.f22163d = Ints.constrainToRange(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* renamed from: i */
    public void mo5773i(int i, int i2, int i3, Object obj) {
        m5777m()[i] = yy2.m8334D(i2, 0, i3);
        m5776l()[i] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Set m5769e = m5769e();
        if (m5769e != null) {
            return m5769e.iterator();
        }
        return new C1364jr(this);
    }

    /* renamed from: j */
    public void mo5774j(int i, int i2) {
        Object obj = this.f22160a;
        Objects.requireNonNull(obj);
        int[] m5777m = m5777m();
        Object[] m5776l = m5776l();
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            Object obj2 = m5776l[i3];
            m5776l[i] = obj2;
            m5776l[i3] = null;
            m5777m[i] = m5777m[i3];
            m5777m[i3] = 0;
            int m6454N = o63.m6454N(obj2) & i2;
            int m8341P = yy2.m8341P(m6454N, obj);
            if (m8341P == size) {
                yy2.m8342Q(m6454N, i + 1, obj);
                return;
            }
            while (true) {
                int i4 = m8341P - 1;
                int i5 = m5777m[i4];
                int i6 = i5 & i2;
                if (i6 == size) {
                    m5777m[i4] = yy2.m8334D(i5, i + 1, i2);
                    return;
                }
                m8341P = i6;
            }
        } else {
            m5776l[i] = null;
            m5777m[i] = 0;
        }
    }

    /* renamed from: k */
    public final boolean m5775k() {
        if (this.f22160a == null) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public final Object[] m5776l() {
        Object[] objArr = this.f22162c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* renamed from: m */
    public final int[] m5777m() {
        int[] iArr = this.f22161b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* renamed from: n */
    public void mo5778n(int i) {
        this.f22161b = Arrays.copyOf(m5777m(), i);
        this.f22162c = Arrays.copyOf(m5776l(), i);
    }

    /* renamed from: o */
    public final int m5779o(int i, int i2, int i3, int i4) {
        Object m8367m = yy2.m8367m(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            yy2.m8342Q(i3 & i5, i4 + 1, m8367m);
        }
        Object obj = this.f22160a;
        Objects.requireNonNull(obj);
        int[] m5777m = m5777m();
        for (int i6 = 0; i6 <= i; i6++) {
            int m8341P = yy2.m8341P(i6, obj);
            while (m8341P != 0) {
                int i7 = m8341P - 1;
                int i8 = m5777m[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int m8341P2 = yy2.m8341P(i10, m8367m);
                yy2.m8342Q(i10, m8341P, m8367m);
                m5777m[i7] = yy2.m8334D(i9, m8341P2, i5);
                m8341P = i8 & i;
            }
        }
        this.f22160a = m8367m;
        this.f22163d = yy2.m8334D(this.f22163d, 32 - Integer.numberOfLeadingZeros(i5), 31);
        return i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (m5775k()) {
            return false;
        }
        Set m5769e = m5769e();
        if (m5769e != null) {
            return m5769e.remove(obj);
        }
        int i = (1 << (this.f22163d & 31)) - 1;
        Object obj2 = this.f22160a;
        Objects.requireNonNull(obj2);
        int m8340L = yy2.m8340L(obj, null, i, obj2, m5777m(), m5776l(), null);
        if (m8340L == -1) {
            return false;
        }
        mo5774j(m8340L, i);
        this.f22164e--;
        this.f22163d += 32;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set m5769e = m5769e();
        if (m5769e != null) {
            return m5769e.size();
        }
        return this.f22164e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (m5775k()) {
            return new Object[0];
        }
        Set m5769e = m5769e();
        return m5769e != null ? m5769e.toArray() : Arrays.copyOf(m5776l(), this.f22164e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (m5775k()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set m5769e = m5769e();
        if (m5769e != null) {
            return m5769e.toArray(objArr);
        }
        Object[] m5776l = m5776l();
        int i = this.f22164e;
        Preconditions.checkPositionIndexes(0, i, m5776l.length);
        if (objArr.length < i) {
            objArr = ObjectArrays.newArray(objArr, i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        System.arraycopy(m5776l, 0, objArr, 0, i);
        return objArr;
    }
}
