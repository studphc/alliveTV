package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.common.graph.Graphs;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: z */
/* loaded from: classes2.dex */
public abstract class AbstractC2039z implements mr1 {

    /* renamed from: a */
    public final Map f29203a;

    /* renamed from: b */
    public final Map f29204b;

    /* renamed from: c */
    public int f29205c;

    public AbstractC2039z(Map map, Map map2, int i) {
        boolean z;
        this.f29203a = (Map) Preconditions.checkNotNull(map);
        this.f29204b = (Map) Preconditions.checkNotNull(map2);
        Graphs.m4172a(i);
        this.f29205c = i;
        if (i <= map.size() && i <= map2.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    @Override // p000.mr1
    /* renamed from: a */
    public final Set mo6243a() {
        return Sets.union(mo4903c(), mo4902b());
    }

    @Override // p000.mr1
    /* renamed from: d */
    public Object mo4904d(Object obj, boolean z) {
        if (z) {
            int i = this.f29205c - 1;
            this.f29205c = i;
            Graphs.m4172a(i);
        }
        Object remove = this.f29203a.remove(obj);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // p000.mr1
    /* renamed from: e */
    public final Set mo4905e() {
        return new C2002y(this);
    }

    @Override // p000.mr1
    /* renamed from: f */
    public final Object mo4906f(Object obj) {
        Object obj2 = this.f29204b.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }

    @Override // p000.mr1
    /* renamed from: g */
    public final Set mo4907g() {
        return Collections.unmodifiableSet(this.f29203a.keySet());
    }

    @Override // p000.mr1
    /* renamed from: h */
    public Object mo4908h(Object obj) {
        Object remove = this.f29204b.remove(obj);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // p000.mr1
    /* renamed from: i */
    public final Set mo4909i() {
        return Collections.unmodifiableSet(this.f29204b.keySet());
    }

    @Override // p000.mr1
    /* renamed from: j */
    public void mo4910j(Object obj, Object obj2) {
        boolean z;
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        if (this.f29204b.put(obj, obj2) == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    @Override // p000.mr1
    /* renamed from: l */
    public void mo4911l(Object obj, Object obj2, boolean z) {
        boolean z2;
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        boolean z3 = false;
        if (z) {
            int i = this.f29205c + 1;
            this.f29205c = i;
            if (i > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Not true that %s is positive.", i);
        }
        if (this.f29203a.put(obj, obj2) == null) {
            z3 = true;
        }
        Preconditions.checkState(z3);
    }
}
