package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p000.cn2;
import p000.dn2;
import p000.en2;
import p000.gh2;
import p000.ig1;

/* renamed from: com.google.common.collect.c3 */
/* loaded from: classes.dex */
public class C0855c3 extends AbstractC0881i implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public final Map f14788c;

    /* renamed from: d */
    public final Supplier f14789d;

    /* renamed from: e */
    public transient cn2 f14790e;

    /* renamed from: f */
    public transient Map f14791f;

    /* renamed from: g */
    public transient dn2 f14792g;

    public C0855c3(Map map, Supplier supplier) {
        this.f14788c = map;
        this.f14789d = supplier;
    }

    /* renamed from: e */
    public static LinkedHashMap m4085e(C0855c3 c0855c3, Object obj) {
        c0855c3.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = c0855c3.f14788c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object remove = ((Map) entry.getValue()).remove(obj);
            if (remove != null) {
                linkedHashMap.put(entry.getKey(), remove);
                if (((Map) entry.getValue()).isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.google.common.collect.AbstractC0881i
    /* renamed from: a */
    public final Iterator mo3830a() {
        return new C0850b3(this);
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        this.f14788c.clear();
    }

    @Override // com.google.common.collect.Table
    public Map column(Object obj) {
        return new ig1(this, obj);
    }

    @Override // com.google.common.collect.Table
    public Set columnKeySet() {
        cn2 cn2Var = this.f14790e;
        if (cn2Var == null) {
            cn2 cn2Var2 = new cn2(this);
            this.f14790e = cn2Var2;
            return cn2Var2;
        }
        return cn2Var;
    }

    @Override // com.google.common.collect.Table
    public Map columnMap() {
        dn2 dn2Var = this.f14792g;
        if (dn2Var == null) {
            dn2 dn2Var2 = new dn2(this, 0);
            this.f14792g = dn2Var2;
            return dn2Var2;
        }
        return dn2Var;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean contains(Object obj, Object obj2) {
        if (obj != null && obj2 != null && super.contains(obj, obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator it = this.f14788c.values().iterator();
        while (it.hasNext()) {
            if (Maps.m4051g((Map) it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsRow(Object obj) {
        if (obj != null && Maps.m4051g(this.f14788c, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        if (obj != null && super.containsValue(obj)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public Iterator mo4073f() {
        return new gh2(this);
    }

    /* renamed from: g */
    public Map mo116g() {
        return new dn2(this, 1);
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public Object get(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return super.get(obj, obj2);
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractC0881i, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.f14788c.isEmpty();
    }

    @Override // com.google.common.collect.Table
    public Object put(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        Preconditions.checkNotNull(obj3);
        Map map = this.f14788c;
        Map map2 = (Map) map.get(obj);
        if (map2 == null) {
            map2 = (Map) this.f14789d.get();
            map.put(obj, map2);
        }
        return map2.put(obj2, obj3);
    }

    @Override // com.google.common.collect.Table
    public Object remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        Map map = this.f14788c;
        Map map2 = (Map) Maps.m4052h(map, obj);
        if (map2 == null) {
            return null;
        }
        Object remove = map2.remove(obj2);
        if (map2.isEmpty()) {
            map.remove(obj);
        }
        return remove;
    }

    @Override // com.google.common.collect.Table
    public Map row(Object obj) {
        return new en2(this, obj);
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public Set rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table, com.google.common.collect.RowSortedTable
    public Map rowMap() {
        Map map = this.f14791f;
        if (map == null) {
            Map mo116g = mo116g();
            this.f14791f = mo116g;
            return mo116g;
        }
        return map;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator it = this.f14788c.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map) it.next()).size();
        }
        return i;
    }
}
