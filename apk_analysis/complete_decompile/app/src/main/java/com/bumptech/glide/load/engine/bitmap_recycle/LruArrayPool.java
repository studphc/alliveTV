package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.TreeMap;
import p000.C1540m9;
import p000.InterfaceC1939wa;
import p000.ke1;
import p000.le1;
import p000.n62;

/* loaded from: classes.dex */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: a */
    public final C1540m9 f8691a;

    /* renamed from: b */
    public final le1 f8692b;

    /* renamed from: c */
    public final HashMap f8693c;

    /* renamed from: d */
    public final HashMap f8694d;

    /* renamed from: e */
    public final int f8695e;

    /* renamed from: f */
    public int f8696f;

    @VisibleForTesting
    public LruArrayPool() {
        this.f8691a = new C1540m9(14);
        this.f8692b = new le1(0);
        this.f8693c = new HashMap();
        this.f8694d = new HashMap();
        this.f8695e = 4194304;
    }

    /* renamed from: a */
    public final void m2321a(int i, Class cls) {
        NavigableMap m2325e = m2325e(cls);
        Integer num = (Integer) m2325e.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                m2325e.remove(Integer.valueOf(i));
                return;
            } else {
                m2325e.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    /* renamed from: b */
    public final void m2322b(int i) {
        while (this.f8696f > i) {
            Object m6105o = this.f8691a.m6105o();
            Preconditions.checkNotNull(m6105o);
            InterfaceC1939wa m2323c = m2323c(m6105o.getClass());
            this.f8696f -= m2323c.getElementSizeInBytes() * m2323c.getArrayLength(m6105o);
            m2321a(m2323c.getArrayLength(m6105o), m6105o.getClass());
            if (Log.isLoggable(m2323c.getTag(), 2)) {
                Log.v(m2323c.getTag(), "evicted: " + m2323c.getArrayLength(m6105o));
            }
        }
    }

    /* renamed from: c */
    public final InterfaceC1939wa m2323c(Class cls) {
        HashMap hashMap = this.f8694d;
        InterfaceC1939wa interfaceC1939wa = (InterfaceC1939wa) hashMap.get(cls);
        if (interfaceC1939wa == null) {
            if (cls.equals(int[].class)) {
                interfaceC1939wa = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                interfaceC1939wa = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            hashMap.put(cls, interfaceC1939wa);
        }
        return interfaceC1939wa;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        m2322b(0);
    }

    /* renamed from: d */
    public final Object m2324d(ke1 ke1Var, Class cls) {
        InterfaceC1939wa m2323c = m2323c(cls);
        Object m6094d = this.f8691a.m6094d(ke1Var);
        if (m6094d != null) {
            this.f8696f -= m2323c.getElementSizeInBytes() * m2323c.getArrayLength(m6094d);
            m2321a(m2323c.getArrayLength(m6094d), cls);
        }
        if (m6094d == null) {
            if (Log.isLoggable(m2323c.getTag(), 2)) {
                Log.v(m2323c.getTag(), "Allocated " + ke1Var.f20836b + " bytes");
            }
            return m2323c.newArray(ke1Var.f20836b);
        }
        return m6094d;
    }

    /* renamed from: e */
    public final NavigableMap m2325e(Class cls) {
        HashMap hashMap = this.f8693c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, Class<T> cls) {
        ke1 ke1Var;
        int i2;
        try {
            Integer num = (Integer) m2325e(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i2 = this.f8696f) != 0 && this.f8695e / i2 < 2 && num.intValue() > i * 8)) {
                le1 le1Var = this.f8692b;
                n62 n62Var = (n62) ((Queue) le1Var.f17677a).poll();
                if (n62Var == null) {
                    n62Var = le1Var.m5922q();
                }
                ke1Var = (ke1) n62Var;
                ke1Var.f20836b = i;
                ke1Var.f20837c = cls;
            }
            le1 le1Var2 = this.f8692b;
            int intValue = num.intValue();
            n62 n62Var2 = (n62) ((Queue) le1Var2.f17677a).poll();
            if (n62Var2 == null) {
                n62Var2 = le1Var2.m5922q();
            }
            ke1Var = (ke1) n62Var2;
            ke1Var.f20836b = intValue;
            ke1Var.f20837c = cls;
        } catch (Throwable th) {
            throw th;
        }
        return (T) m2324d(ke1Var, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, Class<T> cls) {
        ke1 ke1Var;
        le1 le1Var = this.f8692b;
        n62 n62Var = (n62) ((Queue) le1Var.f17677a).poll();
        if (n62Var == null) {
            n62Var = le1Var.m5922q();
        }
        ke1Var = (ke1) n62Var;
        ke1Var.f20836b = i;
        ke1Var.f20837c = cls;
        return (T) m2324d(ke1Var, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        try {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                m2322b(this.f8695e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        InterfaceC1939wa m2323c = m2323c(cls);
        int arrayLength = m2323c.getArrayLength(t);
        int elementSizeInBytes = m2323c.getElementSizeInBytes() * arrayLength;
        if (elementSizeInBytes <= this.f8695e / 2) {
            le1 le1Var = this.f8692b;
            n62 n62Var = (n62) ((Queue) le1Var.f17677a).poll();
            if (n62Var == null) {
                n62Var = le1Var.m5922q();
            }
            ke1 ke1Var = (ke1) n62Var;
            ke1Var.f20836b = arrayLength;
            ke1Var.f20837c = cls;
            this.f8691a.m6101k(ke1Var, t);
            NavigableMap m2325e = m2325e(cls);
            Integer num = (Integer) m2325e.get(Integer.valueOf(ke1Var.f20836b));
            Integer valueOf = Integer.valueOf(ke1Var.f20836b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            m2325e.put(valueOf, Integer.valueOf(i));
            this.f8696f += elementSizeInBytes;
            m2322b(this.f8695e);
        }
    }

    public LruArrayPool(int i) {
        this.f8691a = new C1540m9(14);
        this.f8692b = new le1(0);
        this.f8693c = new HashMap();
        this.f8694d = new HashMap();
        this.f8695e = i;
    }
}
