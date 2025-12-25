package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* renamed from: ir */
/* loaded from: classes.dex */
public class C1328ir extends AbstractMap implements Serializable {

    /* renamed from: j */
    public static final Object f20226j = new Object();

    /* renamed from: a */
    public transient Object f20227a;

    /* renamed from: b */
    public transient int[] f20228b;

    /* renamed from: c */
    public transient Object[] f20229c;

    /* renamed from: d */
    public transient Object[] f20230d;

    /* renamed from: e */
    public transient int f20231e;

    /* renamed from: f */
    public transient int f20232f;

    /* renamed from: g */
    public transient C1279hr f20233g;

    /* renamed from: h */
    public transient C1279hr f20234h;

    /* renamed from: i */
    public transient C0578c2 f20235i;

    public C1328ir(int i) {
        mo5352o(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractMap, ir] */
    /* renamed from: g */
    public static C1328ir m5340g() {
        ?? abstractMap = new AbstractMap();
        abstractMap.mo5352o(3);
        return abstractMap;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            mo5352o(readInt);
            for (int i = 0; i < readInt; i++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException(ye0.m8290j(25, readInt, "Invalid size: "));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Iterator c1242gr;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Map m5346i = m5346i();
        if (m5346i != null) {
            c1242gr = m5346i.entrySet().iterator();
        } else {
            c1242gr = new C1242gr(this, 1);
        }
        while (c1242gr.hasNext()) {
            Map.Entry entry = (Map.Entry) c1242gr.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* renamed from: c */
    public int mo5342c(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (m5355r()) {
            return;
        }
        m5350m();
        Map m5346i = m5346i();
        if (m5346i != null) {
            this.f20231e = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            m5346i.clear();
            this.f20227a = null;
            this.f20232f = 0;
            return;
        }
        Arrays.fill(m5358u(), 0, this.f20232f, (Object) null);
        Arrays.fill(m5359v(), 0, this.f20232f, (Object) null);
        Object obj = this.f20227a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(m5357t(), 0, this.f20232f, 0);
        this.f20232f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map m5346i = m5346i();
        if (m5346i != null) {
            return m5346i.containsKey(obj);
        }
        if (m5351n(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map m5346i = m5346i();
        if (m5346i != null) {
            return m5346i.containsValue(obj);
        }
        for (int i = 0; i < this.f20232f; i++) {
            if (com.google.common.base.Objects.equal(obj, m5359v()[i])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public int mo5343e() {
        Preconditions.checkState(m5355r(), "Arrays already allocated");
        int i = this.f20231e;
        int max = Math.max(4, o63.m6465h(1.0d, i + 1));
        this.f20227a = yy2.m8367m(max);
        this.f20231e = yy2.m8334D(this.f20231e, 32 - Integer.numberOfLeadingZeros(max - 1), 31);
        this.f20228b = new int[i];
        this.f20229c = new Object[i];
        this.f20230d = new Object[i];
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        C1279hr c1279hr = this.f20234h;
        if (c1279hr == null) {
            C1279hr c1279hr2 = new C1279hr(this, 0);
            this.f20234h = c1279hr2;
            return c1279hr2;
        }
        return c1279hr;
    }

    /* renamed from: f */
    public Map mo5344f() {
        LinkedHashMap mo5345h = mo5345h(m5349l() + 1);
        int mo5347j = mo5347j();
        while (mo5347j >= 0) {
            mo5345h.put(m5358u()[mo5347j], m5359v()[mo5347j]);
            mo5347j = mo5348k(mo5347j);
        }
        this.f20227a = mo5345h;
        this.f20228b = null;
        this.f20229c = null;
        this.f20230d = null;
        m5350m();
        return mo5345h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map m5346i = m5346i();
        if (m5346i != null) {
            return m5346i.get(obj);
        }
        int m5351n = m5351n(obj);
        if (m5351n == -1) {
            return null;
        }
        mo5341a(m5351n);
        return m5359v()[m5351n];
    }

    /* renamed from: h */
    public LinkedHashMap mo5345h(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    /* renamed from: i */
    public final Map m5346i() {
        Object obj = this.f20227a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public int mo5347j() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    /* renamed from: k */
    public int mo5348k(int i) {
        int i2 = i + 1;
        if (i2 >= this.f20232f) {
            return -1;
        }
        return i2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        C1279hr c1279hr = this.f20233g;
        if (c1279hr == null) {
            C1279hr c1279hr2 = new C1279hr(this, 1);
            this.f20233g = c1279hr2;
            return c1279hr2;
        }
        return c1279hr;
    }

    /* renamed from: l */
    public final int m5349l() {
        return (1 << (this.f20231e & 31)) - 1;
    }

    /* renamed from: m */
    public final void m5350m() {
        this.f20231e += 32;
    }

    /* renamed from: n */
    public final int m5351n(Object obj) {
        if (m5355r()) {
            return -1;
        }
        int m6454N = o63.m6454N(obj);
        int m5349l = m5349l();
        Object obj2 = this.f20227a;
        Objects.requireNonNull(obj2);
        int m8341P = yy2.m8341P(m6454N & m5349l, obj2);
        if (m8341P == 0) {
            return -1;
        }
        int i = ~m5349l;
        int i2 = m6454N & i;
        do {
            int i3 = m8341P - 1;
            int i4 = m5357t()[i3];
            if ((i4 & i) == i2 && com.google.common.base.Objects.equal(obj, m5358u()[i3])) {
                return i3;
            }
            m8341P = i4 & m5349l;
        } while (m8341P != 0);
        return -1;
    }

    /* renamed from: o */
    public void mo5352o(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected size must be >= 0");
        this.f20231e = Ints.constrainToRange(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* renamed from: p */
    public void mo5353p(int i, Object obj, Object obj2, int i2, int i3) {
        m5357t()[i] = yy2.m8334D(i2, 0, i3);
        m5358u()[i] = obj;
        m5359v()[i] = obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int m5361x;
        int length;
        int min;
        if (m5355r()) {
            mo5343e();
        }
        Map m5346i = m5346i();
        if (m5346i != null) {
            return m5346i.put(obj, obj2);
        }
        int[] m5357t = m5357t();
        Object[] m5358u = m5358u();
        Object[] m5359v = m5359v();
        int i = this.f20232f;
        int i2 = i + 1;
        int m6454N = o63.m6454N(obj);
        int m5349l = m5349l();
        int i3 = m6454N & m5349l;
        Object obj3 = this.f20227a;
        Objects.requireNonNull(obj3);
        int m8341P = yy2.m8341P(i3, obj3);
        int i4 = 1;
        if (m8341P == 0) {
            if (i2 > m5349l) {
                m5361x = m5361x(m5349l, yy2.m8335E(m5349l), m6454N, i);
                m5349l = m5361x;
                length = m5357t().length;
                if (i2 > length && (min = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
                    mo5360w(min);
                }
                mo5353p(i, obj, obj2, m6454N, m5349l);
                this.f20232f = i2;
                m5350m();
                return null;
            }
            Object obj4 = this.f20227a;
            Objects.requireNonNull(obj4);
            yy2.m8342Q(i3, i2, obj4);
            length = m5357t().length;
            if (i2 > length) {
                mo5360w(min);
            }
            mo5353p(i, obj, obj2, m6454N, m5349l);
            this.f20232f = i2;
            m5350m();
            return null;
        }
        int i5 = ~m5349l;
        int i6 = m6454N & i5;
        int i7 = 0;
        while (true) {
            int i8 = m8341P - i4;
            int i9 = m5357t[i8];
            if ((i9 & i5) == i6 && com.google.common.base.Objects.equal(obj, m5358u[i8])) {
                Object obj5 = m5359v[i8];
                m5359v[i8] = obj2;
                mo5341a(i8);
                return obj5;
            }
            int i10 = i9 & m5349l;
            i7++;
            if (i10 == 0) {
                if (i7 >= 9) {
                    return mo5344f().put(obj, obj2);
                }
                if (i2 > m5349l) {
                    m5361x = m5361x(m5349l, yy2.m8335E(m5349l), m6454N, i);
                } else {
                    m5357t[i8] = yy2.m8334D(i9, i2, m5349l);
                }
            } else {
                m8341P = i10;
                i4 = 1;
            }
        }
    }

    /* renamed from: q */
    public void mo5354q(int i, int i2) {
        Object obj = this.f20227a;
        Objects.requireNonNull(obj);
        int[] m5357t = m5357t();
        Object[] m5358u = m5358u();
        Object[] m5359v = m5359v();
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            Object obj2 = m5358u[i3];
            m5358u[i] = obj2;
            m5359v[i] = m5359v[i3];
            m5358u[i3] = null;
            m5359v[i3] = null;
            m5357t[i] = m5357t[i3];
            m5357t[i3] = 0;
            int m6454N = o63.m6454N(obj2) & i2;
            int m8341P = yy2.m8341P(m6454N, obj);
            if (m8341P == size) {
                yy2.m8342Q(m6454N, i + 1, obj);
                return;
            }
            while (true) {
                int i4 = m8341P - 1;
                int i5 = m5357t[i4];
                int i6 = i5 & i2;
                if (i6 == size) {
                    m5357t[i4] = yy2.m8334D(i5, i + 1, i2);
                    return;
                }
                m8341P = i6;
            }
        } else {
            m5358u[i] = null;
            m5359v[i] = null;
            m5357t[i] = 0;
        }
    }

    /* renamed from: r */
    public final boolean m5355r() {
        if (this.f20227a == null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map m5346i = m5346i();
        if (m5346i != null) {
            return m5346i.remove(obj);
        }
        Object m5356s = m5356s(obj);
        if (m5356s == f20226j) {
            return null;
        }
        return m5356s;
    }

    /* renamed from: s */
    public final Object m5356s(Object obj) {
        boolean m5355r = m5355r();
        Object obj2 = f20226j;
        if (m5355r) {
            return obj2;
        }
        int m5349l = m5349l();
        Object obj3 = this.f20227a;
        Objects.requireNonNull(obj3);
        int m8340L = yy2.m8340L(obj, null, m5349l, obj3, m5357t(), m5358u(), null);
        if (m8340L == -1) {
            return obj2;
        }
        Object obj4 = m5359v()[m8340L];
        mo5354q(m8340L, m5349l);
        this.f20232f--;
        m5350m();
        return obj4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map m5346i = m5346i();
        if (m5346i != null) {
            return m5346i.size();
        }
        return this.f20232f;
    }

    /* renamed from: t */
    public final int[] m5357t() {
        int[] iArr = this.f20228b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* renamed from: u */
    public final Object[] m5358u() {
        Object[] objArr = this.f20229c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* renamed from: v */
    public final Object[] m5359v() {
        Object[] objArr = this.f20230d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        C0578c2 c0578c2 = this.f20235i;
        if (c0578c2 == null) {
            C0578c2 c0578c22 = new C0578c2(4, this);
            this.f20235i = c0578c22;
            return c0578c22;
        }
        return c0578c2;
    }

    /* renamed from: w */
    public void mo5360w(int i) {
        this.f20228b = Arrays.copyOf(m5357t(), i);
        this.f20229c = Arrays.copyOf(m5358u(), i);
        this.f20230d = Arrays.copyOf(m5359v(), i);
    }

    /* renamed from: x */
    public final int m5361x(int i, int i2, int i3, int i4) {
        Object m8367m = yy2.m8367m(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            yy2.m8342Q(i3 & i5, i4 + 1, m8367m);
        }
        Object obj = this.f20227a;
        Objects.requireNonNull(obj);
        int[] m5357t = m5357t();
        for (int i6 = 0; i6 <= i; i6++) {
            int m8341P = yy2.m8341P(i6, obj);
            while (m8341P != 0) {
                int i7 = m8341P - 1;
                int i8 = m5357t[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int m8341P2 = yy2.m8341P(i10, m8367m);
                yy2.m8342Q(i10, m8341P, m8367m);
                m5357t[i7] = yy2.m8334D(i9, m8341P2, i5);
                m8341P = i8 & i;
            }
        }
        this.f20227a = m8367m;
        this.f20231e = yy2.m8334D(this.f20231e, 32 - Integer.numberOfLeadingZeros(i5), 31);
        return i5;
    }

    /* renamed from: a */
    public void mo5341a(int i) {
    }
}
