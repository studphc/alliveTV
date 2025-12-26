package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.C0855c3;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class en2 extends yg1 {

    /* renamed from: a */
    public final Object f16917a;

    /* renamed from: b */
    public Map f16918b;

    /* renamed from: c */
    public final /* synthetic */ C0855c3 f16919c;

    public en2(C0855c3 c0855c3, Object obj) {
        this.f16919c = c0855c3;
        this.f16917a = Preconditions.checkNotNull(obj);
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        m4736f();
        Map map = this.f16918b;
        if (map == null) {
            return b61.f7906a;
        }
        return new C1982xg(this, map.entrySet().iterator());
    }

    /* renamed from: c */
    public Map mo4491c() {
        return (Map) this.f16919c.f14788c.get(this.f16917a);
    }

    @Override // p000.yg1, java.util.AbstractMap, java.util.Map
    public final void clear() {
        m4736f();
        Map map = this.f16918b;
        if (map != null) {
            map.clear();
        }
        mo4492e();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map map;
        m4736f();
        if (obj != null && (map = this.f16918b) != null && Maps.m4051g(map, obj)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void mo4492e() {
        m4736f();
        Map map = this.f16918b;
        if (map != null && map.isEmpty()) {
            this.f16919c.f14788c.remove(this.f16917a);
            this.f16918b = null;
        }
    }

    /* renamed from: f */
    public final void m4736f() {
        Map map = this.f16918b;
        if (map == null || (map.isEmpty() && this.f16919c.f14788c.containsKey(this.f16917a))) {
            this.f16918b = mo4491c();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map map;
        m4736f();
        if (obj != null && (map = this.f16918b) != null) {
            return Maps.m4052h(map, obj);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        Map map = this.f16918b;
        if (map != null && !map.isEmpty()) {
            return this.f16918b.put(obj, obj2);
        }
        return this.f16919c.put(this.f16917a, obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m4736f();
        Map map = this.f16918b;
        Object obj2 = null;
        if (map == null) {
            return null;
        }
        Preconditions.checkNotNull(map);
        try {
            obj2 = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
        }
        mo4492e();
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        m4736f();
        Map map = this.f16918b;
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
