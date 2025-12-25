package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.C0855c3;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class cn2 extends oh2 {

    /* renamed from: a */
    public final /* synthetic */ C0855c3 f8427a;

    /* renamed from: b */
    public final /* synthetic */ int f8428b;

    /* renamed from: c */
    public final /* synthetic */ Object f8429c;

    public cn2(C0855c3 c0855c3, byte b) {
        this.f8427a = c0855c3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f8427a.f14788c.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map map;
        switch (this.f8428b) {
            case 0:
                return ((C0855c3) this.f8429c).containsColumn(obj);
            case 1:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    dn2 dn2Var = (dn2) this.f8429c;
                    if (dn2Var.f16446e.containsColumn(entry.getKey())) {
                        Object key = entry.getKey();
                        C0855c3 c0855c3 = dn2Var.f16446e;
                        if (c0855c3.containsColumn(key)) {
                            Objects.requireNonNull(key);
                            map = c0855c3.column(key);
                        } else {
                            map = null;
                        }
                        Objects.requireNonNull(map);
                        return map.equals(entry.getValue());
                    }
                }
                return false;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry2 = (Map.Entry) obj;
                if (entry2.getKey() == null || !(entry2.getValue() instanceof Map) || !Collections2.m3836c(((dn2) this.f8429c).f16446e.f14788c.entrySet(), entry2)) {
                    return false;
                }
                return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f8427a.f14788c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f8428b) {
            case 0:
                return ((C0855c3) this.f8429c).mo4073f();
            case 1:
                Set columnKeySet = ((dn2) this.f8429c).f16446e.columnKeySet();
                return new w51(columnKeySet.iterator(), new C1291i2(6, this), 1);
            default:
                Set keySet = ((dn2) this.f8429c).f16446e.f14788c.keySet();
                return new w51(keySet.iterator(), new C1291i2(7, this), 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f8428b) {
            case 0:
                boolean z = false;
                if (obj != null) {
                    Iterator it = ((C0855c3) this.f8429c).f14788c.values().iterator();
                    while (it.hasNext()) {
                        Map map = (Map) it.next();
                        if (map.keySet().remove(obj)) {
                            if (map.isEmpty()) {
                                it.remove();
                            }
                            z = true;
                        }
                    }
                }
                return z;
            case 1:
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    C0855c3.m4085e(((dn2) this.f8429c).f16446e, ((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !((dn2) this.f8429c).f16446e.f14788c.entrySet().remove(entry)) {
                    return false;
                }
                return true;
        }
    }

    @Override // p000.oh2, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        switch (this.f8428b) {
            case 0:
                Preconditions.checkNotNull(collection);
                Iterator it = ((C0855c3) this.f8429c).f14788c.values().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map map = (Map) it.next();
                    if (Iterators.removeAll(map.keySet().iterator(), collection)) {
                        if (map.isEmpty()) {
                            it.remove();
                        }
                        z = true;
                    }
                }
                return z;
            case 1:
                Preconditions.checkNotNull(collection);
                return Sets.m4072d(this, collection.iterator());
            default:
                return super.removeAll(collection);
        }
    }

    @Override // p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        switch (this.f8428b) {
            case 0:
                Preconditions.checkNotNull(collection);
                Iterator it = ((C0855c3) this.f8429c).f14788c.values().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map map = (Map) it.next();
                    if (map.keySet().retainAll(collection)) {
                        if (map.isEmpty()) {
                            it.remove();
                        }
                        z = true;
                    }
                }
                return z;
            case 1:
                Preconditions.checkNotNull(collection);
                dn2 dn2Var = (dn2) this.f8429c;
                Iterator it2 = Lists.newArrayList(dn2Var.f16446e.columnKeySet().iterator()).iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    C0855c3 c0855c3 = dn2Var.f16446e;
                    if (!collection.contains(Maps.immutableEntry(next, c0855c3.column(next)))) {
                        C0855c3.m4085e(c0855c3, next);
                        z2 = true;
                    }
                }
                return z2;
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f8428b) {
            case 0:
                return Iterators.size(((C0855c3) this.f8429c).mo4073f());
            case 1:
                return ((dn2) this.f8429c).f16446e.columnKeySet().size();
            default:
                return ((dn2) this.f8429c).f16446e.f14788c.size();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cn2(C0855c3 c0855c3) {
        this(c0855c3, (byte) 0);
        this.f8428b = 0;
        this.f8429c = c0855c3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cn2(dn2 dn2Var, byte b) {
        this(dn2Var.f16446e, (byte) 0);
        this.f8428b = 2;
        this.f8429c = dn2Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cn2(dn2 dn2Var) {
        this(dn2Var.f16446e, (byte) 0);
        this.f8428b = 1;
        this.f8429c = dn2Var;
    }
}
