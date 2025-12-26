package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0566bq;
import p000.f40;
import p000.g40;
import p000.j40;
import p000.k40;
import p000.mx0;

/* renamed from: com.google.common.graph.b */
/* loaded from: classes2.dex */
public final class C0963b implements mx0 {

    /* renamed from: e */
    public static final Object f15045e = new Object();

    /* renamed from: a */
    public final Map f15046a;

    /* renamed from: b */
    public final AbstractCollection f15047b;

    /* renamed from: c */
    public int f15048c;

    /* renamed from: d */
    public int f15049d;

    /* JADX WARN: Multi-variable type inference failed */
    public C0963b(HashMap hashMap, List list, int i, int i2) {
        boolean z;
        this.f15046a = (Map) Preconditions.checkNotNull(hashMap);
        this.f15047b = (AbstractCollection) list;
        Graphs.m4172a(i);
        this.f15048c = i;
        Graphs.m4172a(i2);
        this.f15049d = i2;
        if (i <= hashMap.size() && i2 <= hashMap.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    /* renamed from: j */
    public static C0963b m4178j(Object obj, Set set, Function function) {
        boolean z;
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(function);
        HashMap hashMap = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        Iterator it = set.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            EndpointPair endpointPair = (EndpointPair) it.next();
            if (endpointPair.nodeU().equals(obj) && endpointPair.nodeV().equals(obj)) {
                hashMap.put(obj, new k40(function.apply(obj)));
                builder.add((ImmutableList.Builder) new j40(obj));
                builder.add((ImmutableList.Builder) new j40(obj));
                i++;
            } else {
                boolean equals = endpointPair.nodeV().equals(obj);
                Object obj2 = f15045e;
                if (equals) {
                    Object nodeU = endpointPair.nodeU();
                    Object put = hashMap.put(nodeU, obj2);
                    if (put != null) {
                        hashMap.put(nodeU, new k40(put));
                    }
                    builder.add((ImmutableList.Builder) new j40(nodeU));
                    i++;
                } else {
                    Preconditions.checkArgument(endpointPair.nodeU().equals(obj));
                    Object nodeV = endpointPair.nodeV();
                    Object apply = function.apply(nodeV);
                    Object put2 = hashMap.put(nodeV, apply);
                    if (put2 != null) {
                        if (put2 == obj2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Preconditions.checkArgument(z);
                        hashMap.put(nodeV, new k40(apply));
                    }
                    builder.add((ImmutableList.Builder) new j40(nodeV));
                }
            }
            i2++;
        }
        return new C0963b(hashMap, builder.build(), i, i2);
    }

    @Override // p000.mx0
    /* renamed from: a */
    public final Set mo4179a() {
        if (this.f15047b == null) {
            return Collections.unmodifiableSet(this.f15046a.keySet());
        }
        return new g40(this, 0);
    }

    @Override // p000.mx0
    /* renamed from: b */
    public final Set mo4180b() {
        return new g40(this, 2);
    }

    @Override // p000.mx0
    /* renamed from: c */
    public final Set mo4181c() {
        return new g40(this, 1);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.AbstractCollection, java.util.List] */
    @Override // p000.mx0
    /* renamed from: d */
    public final Object mo4182d(Object obj) {
        Object obj2;
        Preconditions.checkNotNull(obj);
        Map map = this.f15046a;
        Object obj3 = map.get(obj);
        if (obj3 != null && obj3 != (obj2 = f15045e)) {
            if (obj3 instanceof k40) {
                map.put(obj, obj2);
                obj3 = ((k40) obj3).f20745a;
            } else {
                map.remove(obj);
            }
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            int i = this.f15049d - 1;
            this.f15049d = i;
            Graphs.m4172a(i);
            ?? r0 = this.f15047b;
            if (r0 != 0) {
                r0.remove(new j40(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return obj3;
    }

    @Override // p000.mx0
    /* renamed from: e */
    public final Object mo4183e(Object obj) {
        Preconditions.checkNotNull(obj);
        Object obj2 = this.f15046a.get(obj);
        if (obj2 == f15045e) {
            return null;
        }
        if (obj2 instanceof k40) {
            return ((k40) obj2).f20745a;
        }
        return obj2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.AbstractCollection, java.util.List] */
    @Override // p000.mx0
    /* renamed from: f */
    public final void mo4184f(Object obj) {
        Preconditions.checkNotNull(obj);
        Map map = this.f15046a;
        Object obj2 = map.get(obj);
        if (obj2 == f15045e) {
            map.remove(obj);
        } else if (obj2 instanceof k40) {
            map.put(obj, ((k40) obj2).f20745a);
        } else {
            return;
        }
        int i = this.f15048c - 1;
        this.f15048c = i;
        Graphs.m4172a(i);
        ?? r0 = this.f15047b;
        if (r0 != 0) {
            r0.remove(new j40(obj));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // p000.mx0
    /* renamed from: g */
    public final Iterator mo4185g(Object obj) {
        Iterator transform;
        Preconditions.checkNotNull(obj);
        ?? r0 = this.f15047b;
        if (r0 == 0) {
            transform = Iterators.concat(Iterators.transform(new g40(this, 1).iterator(), new f40(0, obj)), Iterators.transform(new g40(this, 2).iterator(), new f40(1, obj)));
        } else {
            transform = Iterators.transform(r0.iterator(), new f40(2, obj));
        }
        return new C0566bq(transform, new AtomicBoolean(false), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002b  */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.AbstractCollection, java.util.List] */
    @Override // p000.mx0
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4186h(Object obj, Object obj2) {
        Map map = this.f15046a;
        Object put = map.put(obj, obj2);
        if (put != null) {
            if (put instanceof k40) {
                map.put(obj, new k40(obj2));
                put = ((k40) put).f20745a;
            } else if (put == f15045e) {
                map.put(obj, new k40(obj2));
            }
            if (put == null) {
                boolean z = true;
                int i = this.f15049d + 1;
                this.f15049d = i;
                if (i <= 0) {
                    z = false;
                }
                Preconditions.checkArgument(z, "Not true that %s is positive.", i);
                ?? r6 = this.f15047b;
                if (r6 != 0) {
                    r6.add(new j40(obj));
                }
            }
            if (put != null) {
                return null;
            }
            return put;
        }
        put = null;
        if (put == null) {
        }
        if (put != null) {
        }
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.AbstractCollection, java.util.List] */
    @Override // p000.mx0
    /* renamed from: i */
    public final void mo4187i(Object obj, Object obj2) {
        Object obj3 = f15045e;
        Map map = this.f15046a;
        Object put = map.put(obj, obj3);
        if (put != null) {
            if (put instanceof k40) {
                map.put(obj, put);
                return;
            } else if (put != obj3) {
                map.put(obj, new k40(put));
            } else {
                return;
            }
        }
        boolean z = true;
        int i = this.f15048c + 1;
        this.f15048c = i;
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Not true that %s is positive.", i);
        ?? r5 = this.f15047b;
        if (r5 != 0) {
            r5.add(new j40(obj));
        }
    }
}
