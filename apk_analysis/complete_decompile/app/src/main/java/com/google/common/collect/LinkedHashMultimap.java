package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.AbstractC0004a3;
import p000.C1328ir;
import p000.C1484kr;
import p000.C1493l;
import p000.fg1;
import p000.p63;
import p000.p81;
import p000.r81;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes.dex */
public final class LinkedHashMultimap<K, V> extends AbstractC0004a3 {

    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: h */
    public transient int f14723h;

    /* renamed from: i */
    public transient p81 f14724i;

    public LinkedHashMultimap(int i, int i2) {
        super(new C1328ir(i));
        this.f14723h = 2;
        p63.m6869m(i2, "expectedValuesPerKey");
        this.f14723h = i2;
        p81 p81Var = new p81(null, null, 0, null);
        this.f14724i = p81Var;
        p81Var.f25066h = p81Var;
        p81Var.f25065g = p81Var;
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        p81 p81Var = new p81(null, null, 0, null);
        this.f14724i = p81Var;
        p81Var.f25066h = p81Var;
        p81Var.f25065g = p81Var;
        this.f14723h = 2;
        int readInt = objectInputStream.readInt();
        C1328ir c1328ir = new C1328ir(12);
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            c1328ir.put(readObject, mo4036j(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            Object readObject2 = objectInputStream.readObject();
            Object readObject3 = objectInputStream.readObject();
            Collection collection = (Collection) c1328ir.get(readObject2);
            Objects.requireNonNull(collection);
            collection.add(readObject3);
        }
        m7963n(c1328ir);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
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

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        p81 p81Var = this.f14724i;
        p81Var.f25066h = p81Var;
        p81Var.f25065g = p81Var;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f28031f.containsKey(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        return new C1493l(this);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: i */
    public final Collection mo2006i() {
        return new C1484kr(this.f14723h);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: j */
    public final Collection mo4036j(Object obj) {
        return new r81(this, obj, this.f14723h);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: p */
    public final Iterator mo4037p() {
        return new fg1(new C1493l(this), 1);
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
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

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap
    public int size() {
        return this.f28032g;
    }

    @Override // p000.AbstractC1143e2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(Maps.m4047c(i), Maps.m4047c(i2));
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k, (Iterable) iterable);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }
}
