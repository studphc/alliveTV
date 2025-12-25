package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class sg1 extends ih1 {

    /* renamed from: d */
    public final Map f26415d;

    /* renamed from: e */
    public final Predicate f26416e;

    /* renamed from: f */
    public final /* synthetic */ int f26417f;

    /* renamed from: g */
    public final Object f26418g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sg1(Map map, Predicate predicate, Predicate predicate2) {
        this(map, predicate2, (byte) 0);
        this.f26417f = 1;
        this.f26418g = predicate;
    }

    /* renamed from: h */
    public static boolean m7370h(Map map, Predicate predicate, Collection collection) {
        Iterator it = map.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (predicate.apply(entry) && collection.contains(entry.getKey())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: i */
    public static boolean m7371i(Map map, Predicate predicate, Collection collection) {
        Iterator it = map.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (predicate.apply(entry) && !collection.contains(entry.getKey())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // p000.ih1
    /* renamed from: a */
    public final Set mo4593a() {
        switch (this.f26417f) {
            case 0:
                return new C1669p(this, 2);
            default:
                return Sets.filter(this.f26415d.entrySet(), this.f26416e);
        }
    }

    @Override // p000.ih1
    /* renamed from: c */
    public Set mo5238c() {
        switch (this.f26417f) {
            case 0:
                return new C1375k1(this, 2);
            default:
                return Sets.filter(this.f26415d.keySet(), (Predicate) this.f26418g);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        switch (this.f26417f) {
            case 1:
                if (this.f26415d.containsKey(obj) && ((Predicate) this.f26418g).apply(obj)) {
                    return true;
                }
                return false;
            default:
                return m7373g(obj);
        }
    }

    @Override // p000.ih1
    /* renamed from: e */
    public final Collection mo4594e() {
        return new xg1(this, this.f26415d, this.f26416e);
    }

    /* renamed from: f */
    public final boolean m7372f(Object obj, Object obj2) {
        return this.f26416e.apply(Maps.immutableEntry(obj, obj2));
    }

    /* renamed from: g */
    public final boolean m7373g(Object obj) {
        Map map = this.f26415d;
        if (map.containsKey(obj) && m7372f(obj, map.get(obj))) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = this.f26415d.get(obj);
        if (obj2 == null || !m7372f(obj, obj2)) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Preconditions.checkArgument(m7372f(obj, obj2));
        return this.f26415d.put(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            Preconditions.checkArgument(m7372f(entry.getKey(), entry.getValue()));
        }
        this.f26415d.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (containsKey(obj)) {
            return this.f26415d.remove(obj);
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sg1(Map map, Predicate predicate) {
        this(map, predicate, (byte) 0);
        this.f26417f = 0;
        this.f26418g = Sets.filter(map.entrySet(), this.f26416e);
    }

    public sg1(Map map, Predicate predicate, byte b) {
        this.f26415d = map;
        this.f26416e = predicate;
    }
}
