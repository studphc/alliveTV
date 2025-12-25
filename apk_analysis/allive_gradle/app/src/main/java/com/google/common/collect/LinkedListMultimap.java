package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC1143e2;
import p000.C1328ir;
import p000.b91;
import p000.kd0;
import p000.t81;
import p000.u81;
import p000.v81;
import p000.y81;
import p000.z81;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public class LinkedListMultimap<K, V> extends AbstractC1143e2 implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public transient z81 f14725f;

    /* renamed from: g */
    public transient z81 f14726g;

    /* renamed from: h */
    public transient C1328ir f14727h;

    /* renamed from: i */
    public transient int f14728i;

    /* renamed from: j */
    public transient int f14729j;

    public LinkedListMultimap(int i) {
        this.f14727h = new C1328ir(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>(12);
    }

    /* renamed from: i */
    public static void m4038i(LinkedListMultimap linkedListMultimap, z81 z81Var) {
        linkedListMultimap.getClass();
        z81 z81Var2 = z81Var.f29272d;
        if (z81Var2 != null) {
            z81Var2.f29271c = z81Var.f29271c;
        } else {
            linkedListMultimap.f14725f = z81Var.f29271c;
        }
        z81 z81Var3 = z81Var.f29271c;
        if (z81Var3 != null) {
            z81Var3.f29272d = z81Var2;
        } else {
            linkedListMultimap.f14726g = z81Var2;
        }
        z81 z81Var4 = z81Var.f29274f;
        Object obj = z81Var.f29269a;
        if (z81Var4 == null && z81Var.f29273e == null) {
            y81 y81Var = (y81) linkedListMultimap.f14727h.remove(obj);
            Objects.requireNonNull(y81Var);
            y81Var.f28865c = 0;
            linkedListMultimap.f14729j++;
        } else {
            y81 y81Var2 = (y81) linkedListMultimap.f14727h.get(obj);
            Objects.requireNonNull(y81Var2);
            y81Var2.f28865c--;
            z81 z81Var5 = z81Var.f29274f;
            if (z81Var5 == null) {
                z81 z81Var6 = z81Var.f29273e;
                Objects.requireNonNull(z81Var6);
                y81Var2.f28863a = z81Var6;
            } else {
                z81Var5.f29273e = z81Var.f29273e;
            }
            z81 z81Var7 = z81Var.f29273e;
            if (z81Var7 == null) {
                z81 z81Var8 = z81Var.f29274f;
                Objects.requireNonNull(z81Var8);
                y81Var2.f28864b = z81Var8;
            } else {
                z81Var7.f29274f = z81Var.f29274f;
            }
        }
        linkedListMultimap.f14728i--;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f14727h = new C1328ir(3);
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return new kd0(this);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.f14725f = null;
        this.f14726g = null;
        this.f14727h.clear();
        this.f14728i = 0;
        this.f14729j++;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f14727h.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public final Collection mo3948d() {
        return new u81(this, 0);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return new v81(0, this);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return new C0893k1(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        return new u81(this, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        throw new AssertionError("should never be called");
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public boolean isEmpty() {
        if (this.f14725f == null) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final z81 m4039j(Object obj, Object obj2, z81 z81Var) {
        z81 z81Var2 = new z81(obj, obj2);
        if (this.f14725f == null) {
            this.f14726g = z81Var2;
            this.f14725f = z81Var2;
            this.f14727h.put(obj, new y81(z81Var2));
            this.f14729j++;
        } else if (z81Var == null) {
            z81 z81Var3 = this.f14726g;
            Objects.requireNonNull(z81Var3);
            z81Var3.f29271c = z81Var2;
            z81Var2.f29272d = this.f14726g;
            this.f14726g = z81Var2;
            y81 y81Var = (y81) this.f14727h.get(obj);
            if (y81Var == null) {
                this.f14727h.put(obj, new y81(z81Var2));
                this.f14729j++;
            } else {
                y81Var.f28865c++;
                z81 z81Var4 = y81Var.f28864b;
                z81Var4.f29273e = z81Var2;
                z81Var2.f29274f = z81Var4;
                y81Var.f28864b = z81Var2;
            }
        } else {
            y81 y81Var2 = (y81) this.f14727h.get(obj);
            Objects.requireNonNull(y81Var2);
            y81Var2.f28865c++;
            z81Var2.f29272d = z81Var.f29272d;
            z81Var2.f29274f = z81Var.f29274f;
            z81Var2.f29271c = z81Var;
            z81Var2.f29273e = z81Var;
            z81 z81Var5 = z81Var.f29274f;
            if (z81Var5 == null) {
                y81Var2.f28863a = z81Var2;
            } else {
                z81Var5.f29273e = z81Var2;
            }
            z81 z81Var6 = z81Var.f29272d;
            if (z81Var6 == null) {
                this.f14725f = z81Var2;
            } else {
                z81Var6.f29271c = z81Var2;
            }
            z81Var.f29272d = z81Var2;
            z81Var.f29274f = z81Var2;
        }
        this.f14728i++;
        return z81Var2;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(K k, V v) {
        m4039j(k, v, null);
        return true;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f14728i;
    }

    @Override // p000.AbstractC1143e2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public List<V> get(K k) {
        return new t81(this, k);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        List<V> unmodifiableList = Collections.unmodifiableList(Lists.newArrayList(new b91(this, obj)));
        Iterators.m4034b(new b91(this, obj));
        return unmodifiableList;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        List<V> unmodifiableList = Collections.unmodifiableList(Lists.newArrayList(new b91(this, k)));
        b91 b91Var = new b91(this, k);
        Iterator<? extends V> it = iterable.iterator();
        while (b91Var.hasNext() && it.hasNext()) {
            b91Var.next();
            b91Var.set(it.next());
        }
        while (b91Var.hasNext()) {
            b91Var.next();
            b91Var.remove();
        }
        while (it.hasNext()) {
            b91Var.add(it.next());
        }
        return unmodifiableList;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedListMultimap<K, V> linkedListMultimap = new LinkedListMultimap<>(multimap.keySet().size());
        linkedListMultimap.putAll(multimap);
        return linkedListMultimap;
    }
}
