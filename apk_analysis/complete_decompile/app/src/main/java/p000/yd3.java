package p000;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class yd3 extends AbstractMap {

    /* renamed from: g */
    public static final /* synthetic */ int f28913g = 0;

    /* renamed from: a */
    public Object[] f28914a;

    /* renamed from: b */
    public int f28915b;

    /* renamed from: d */
    public boolean f28917d;

    /* renamed from: e */
    public volatile C1251h f28918e;

    /* renamed from: c */
    public Map f28916c = Collections.emptyMap();

    /* renamed from: f */
    public Map f28919f = Collections.emptyMap();

    /* renamed from: a */
    public final int m8267a() {
        return this.f28915b;
    }

    /* renamed from: c */
    public final Set m8268c() {
        if (this.f28916c.isEmpty()) {
            return Collections.emptySet();
        }
        return this.f28916c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        m8274j();
        if (this.f28915b != 0) {
            this.f28914a = null;
            this.f28915b = 0;
        }
        if (!this.f28916c.isEmpty()) {
            this.f28916c.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (m8271g(comparable) < 0 && !this.f28916c.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        m8274j();
        int m8271g = m8271g(comparable);
        if (m8271g >= 0) {
            return ((zd3) this.f28914a[m8271g]).setValue(obj);
        }
        m8274j();
        if (this.f28914a == null) {
            this.f28914a = new Object[16];
        }
        int i = -(m8271g + 1);
        if (i >= 16) {
            return m8273i().put(comparable, obj);
        }
        if (this.f28915b == 16) {
            zd3 zd3Var = (zd3) this.f28914a[15];
            this.f28915b = 15;
            m8273i().put(zd3Var.f29326a, zd3Var.f29327b);
        }
        Object[] objArr = this.f28914a;
        int length = objArr.length;
        System.arraycopy(objArr, i, objArr, i + 1, 15 - i);
        this.f28914a[i] = new zd3(this, comparable, obj);
        this.f28915b++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f28918e == null) {
            this.f28918e = new C1251h(4, this);
        }
        return this.f28918e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yd3)) {
            return super.equals(obj);
        }
        yd3 yd3Var = (yd3) obj;
        int size = size();
        if (size != yd3Var.size()) {
            return false;
        }
        int i = this.f28915b;
        if (i == yd3Var.f28915b) {
            for (int i2 = 0; i2 < i; i2++) {
                if (!m8270f(i2).equals(yd3Var.m8270f(i2))) {
                    return false;
                }
            }
            if (i == size) {
                return true;
            }
            return this.f28916c.equals(yd3Var.f28916c);
        }
        return entrySet().equals(yd3Var.entrySet());
    }

    /* renamed from: f */
    public final zd3 m8270f(int i) {
        if (i < this.f28915b) {
            return (zd3) this.f28914a[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    /* renamed from: g */
    public final int m8271g(Comparable comparable) {
        int i = this.f28915b;
        int i2 = i - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int compareTo = comparable.compareTo(((zd3) this.f28914a[i2]).f29326a);
            if (compareTo > 0) {
                return -(i + 1);
            }
            if (compareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int compareTo2 = comparable.compareTo(((zd3) this.f28914a[i4]).f29326a);
            if (compareTo2 < 0) {
                i2 = i4 - 1;
            } else if (compareTo2 > 0) {
                i3 = i4 + 1;
            } else {
                return i4;
            }
        }
        return -(i3 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int m8271g = m8271g(comparable);
        if (m8271g >= 0) {
            return ((zd3) this.f28914a[m8271g]).f29327b;
        }
        return this.f28916c.get(comparable);
    }

    /* renamed from: h */
    public final Object m8272h(int i) {
        m8274j();
        Object[] objArr = this.f28914a;
        Object obj = ((zd3) objArr[i]).f29327b;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f28915b - i) - 1);
        this.f28915b--;
        if (!this.f28916c.isEmpty()) {
            Iterator it = m8273i().entrySet().iterator();
            Object[] objArr2 = this.f28914a;
            int i2 = this.f28915b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i2] = new zd3(this, (Comparable) entry.getKey(), entry.getValue());
            this.f28915b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.f28915b;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += this.f28914a[i3].hashCode();
        }
        if (this.f28916c.size() > 0) {
            return this.f28916c.hashCode() + i2;
        }
        return i2;
    }

    /* renamed from: i */
    public final SortedMap m8273i() {
        m8274j();
        if (this.f28916c.isEmpty() && !(this.f28916c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f28916c = treeMap;
            this.f28919f = treeMap.descendingMap();
        }
        return (SortedMap) this.f28916c;
    }

    /* renamed from: j */
    public final void m8274j() {
        if (!this.f28917d) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m8274j();
        Comparable comparable = (Comparable) obj;
        int m8271g = m8271g(comparable);
        if (m8271g >= 0) {
            return m8272h(m8271g);
        }
        if (this.f28916c.isEmpty()) {
            return null;
        }
        return this.f28916c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f28916c.size() + this.f28915b;
    }
}
