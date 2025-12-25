package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.C0578c2;
import p000.EnumC1948wj;
import p000.EnumC1985xj;
import p000.bb1;
import p000.cb1;
import p000.ib1;
import p000.j92;
import p000.rb1;
import p000.ub1;
import p000.zb1;

/* renamed from: com.google.common.cache.e */
/* loaded from: classes.dex */
public final class ConcurrentMapC0840e extends AbstractMap implements ConcurrentMap {

    /* renamed from: w */
    public static final Logger f14584w = Logger.getLogger(ConcurrentMapC0840e.class.getName());

    /* renamed from: x */
    public static final bb1 f14585x = new Object();

    /* renamed from: y */
    public static final cb1 f14586y = new cb1();

    /* renamed from: a */
    public final int f14587a;

    /* renamed from: b */
    public final int f14588b;

    /* renamed from: c */
    public final C0839d[] f14589c;

    /* renamed from: d */
    public final int f14590d;

    /* renamed from: e */
    public final Equivalence f14591e;

    /* renamed from: f */
    public final Equivalence f14592f;

    /* renamed from: g */
    public final ub1 f14593g;

    /* renamed from: h */
    public final ub1 f14594h;

    /* renamed from: i */
    public final long f14595i;

    /* renamed from: j */
    public final Weigher f14596j;

    /* renamed from: k */
    public final long f14597k;

    /* renamed from: l */
    public final long f14598l;

    /* renamed from: m */
    public final long f14599m;

    /* renamed from: n */
    public final AbstractQueue f14600n;

    /* renamed from: o */
    public final RemovalListener f14601o;

    /* renamed from: p */
    public final Ticker f14602p;

    /* renamed from: q */
    public final int f14603q;

    /* renamed from: r */
    public final AbstractCache.StatsCounter f14604r;

    /* renamed from: s */
    public final CacheLoader f14605s;

    /* renamed from: t */
    public ib1 f14606t;

    /* renamed from: u */
    public C0578c2 f14607u;

    /* renamed from: v */
    public ib1 f14608v;

    public ConcurrentMapC0840e(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        long j;
        AbstractQueue concurrentLinkedQueue;
        boolean z;
        boolean z2;
        char c;
        boolean z3;
        char c2;
        int i;
        int i2 = cacheBuilder.f14528c;
        this.f14590d = Math.min(i2 == -1 ? 4 : i2, 65536);
        ub1 ub1Var = cacheBuilder.f14532g;
        rb1 rb1Var = ub1.f27185a;
        ub1 ub1Var2 = (ub1) MoreObjects.firstNonNull(ub1Var, rb1Var);
        this.f14593g = ub1Var2;
        this.f14594h = (ub1) MoreObjects.firstNonNull(cacheBuilder.f14533h, rb1Var);
        this.f14591e = (Equivalence) MoreObjects.firstNonNull(cacheBuilder.f14537l, ((ub1) MoreObjects.firstNonNull(cacheBuilder.f14532g, rb1Var)).mo7264a());
        this.f14592f = (Equivalence) MoreObjects.firstNonNull(cacheBuilder.f14538m, ((ub1) MoreObjects.firstNonNull(cacheBuilder.f14533h, rb1Var)).mo7264a());
        if (cacheBuilder.f14534i != 0 && cacheBuilder.f14535j != 0) {
            if (cacheBuilder.f14531f == null) {
                j = cacheBuilder.f14529d;
            } else {
                j = cacheBuilder.f14530e;
            }
        } else {
            j = 0;
        }
        this.f14595i = j;
        Weigher weigher = cacheBuilder.f14531f;
        EnumC1985xj enumC1985xj = EnumC1985xj.f28583a;
        Weigher weigher2 = (Weigher) MoreObjects.firstNonNull(weigher, enumC1985xj);
        this.f14596j = weigher2;
        long j2 = cacheBuilder.f14535j;
        this.f14597k = j2 == -1 ? 0L : j2;
        long j3 = cacheBuilder.f14534i;
        this.f14598l = j3 == -1 ? 0L : j3;
        long j4 = cacheBuilder.f14536k;
        j4 = j4 == -1 ? 0L : j4;
        this.f14599m = j4;
        RemovalListener removalListener = cacheBuilder.f14539n;
        EnumC1948wj enumC1948wj = EnumC1948wj.f28200a;
        RemovalListener removalListener2 = (RemovalListener) MoreObjects.firstNonNull(removalListener, enumC1948wj);
        this.f14601o = removalListener2;
        if (removalListener2 == enumC1948wj) {
            concurrentLinkedQueue = f14586y;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
        }
        this.f14600n = concurrentLinkedQueue;
        int i3 = 0;
        int i4 = 1;
        if (!m3824f() && j4 <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z && !m3823e()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Ticker ticker = cacheBuilder.f14540o;
        if (ticker == null) {
            if (z2) {
                ticker = Ticker.systemTicker();
            } else {
                ticker = CacheBuilder.f14524t;
            }
        }
        this.f14602p = ticker;
        if (!m3823e() && !m3822c() && !m3823e()) {
            c = 0;
        } else {
            c = 1;
        }
        if (!m3824f() && !m3824f() && j4 <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (ub1Var2 == ub1.f27187c) {
            c2 = 4;
        } else {
            c2 = 0;
        }
        int i5 = c2 | c;
        if (z3) {
            i = 2;
        } else {
            i = 0;
        }
        this.f14603q = AbstractC1726qj.f25610b[i5 | i];
        this.f14604r = (AbstractCache.StatsCounter) cacheBuilder.f14541p.get();
        this.f14605s = cacheLoader;
        int i6 = cacheBuilder.f14527b;
        int min = Math.min(i6 == -1 ? 16 : i6, 1073741824);
        if (m3822c() && weigher2 == enumC1985xj) {
            min = (int) Math.min(min, j);
        }
        int i7 = 0;
        int i8 = 1;
        while (i8 < this.f14590d && (!m3822c() || i8 * 20 <= this.f14595i)) {
            i7++;
            i8 <<= 1;
        }
        this.f14588b = 32 - i7;
        this.f14587a = i8 - 1;
        this.f14589c = new C0839d[i8];
        int i9 = min / i8;
        while (i4 < (i9 * i8 < min ? i9 + 1 : i9)) {
            i4 <<= 1;
        }
        if (m3822c()) {
            long j5 = this.f14595i;
            long j6 = i8;
            long j7 = (j5 / j6) + 1;
            long j8 = j5 % j6;
            while (true) {
                C0839d[] c0839dArr = this.f14589c;
                if (i3 < c0839dArr.length) {
                    if (i3 == j8) {
                        j7--;
                    }
                    long j9 = j7;
                    c0839dArr[i3] = new C0839d(this, i4, j9, (AbstractCache.StatsCounter) cacheBuilder.f14541p.get());
                    i3++;
                    j7 = j9;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                C0839d[] c0839dArr2 = this.f14589c;
                if (i3 < c0839dArr2.length) {
                    c0839dArr2[i3] = new C0839d(this, i4, -1L, (AbstractCache.StatsCounter) cacheBuilder.f14541p.get());
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static ArrayList m3821a(AbstractCollection abstractCollection) {
        ArrayList arrayList = new ArrayList(abstractCollection.size());
        Iterators.addAll(arrayList, abstractCollection.iterator());
        return arrayList;
    }

    /* renamed from: c */
    public final boolean m3822c() {
        if (this.f14595i >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        boolean z;
        boolean z2;
        RemovalCause removalCause;
        for (C0839d c0839d : this.f14589c) {
            if (c0839d.f14571b != 0) {
                c0839d.lock();
                try {
                    c0839d.m3816v(c0839d.f14570a.f14602p.read());
                    AtomicReferenceArray atomicReferenceArray = c0839d.f14575f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (j92 j92Var = (j92) atomicReferenceArray.get(i); j92Var != null; j92Var = j92Var.mo2220a()) {
                            if (j92Var.mo2221b().isActive()) {
                                Object key = j92Var.getKey();
                                Object obj = j92Var.mo2221b().get();
                                if (key != null && obj != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    j92Var.mo2222c();
                                    c0839d.m3798d(key, obj, j92Var.mo2221b().mo2071c(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                j92Var.mo2222c();
                                c0839d.m3798d(key, obj, j92Var.mo2221b().mo2071c(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    ConcurrentMapC0840e concurrentMapC0840e = c0839d.f14570a;
                    rb1 rb1Var = ub1.f27185a;
                    if (concurrentMapC0840e.f14593g != rb1Var) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        do {
                        } while (c0839d.f14577h.poll() != null);
                    }
                    if (concurrentMapC0840e.f14594h != rb1Var) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        do {
                        } while (c0839d.f14578i.poll() != null);
                    }
                    c0839d.f14581l.clear();
                    c0839d.f14582m.clear();
                    c0839d.f14580k.set(0);
                    c0839d.f14573d++;
                    c0839d.f14571b = 0;
                    c0839d.unlock();
                    c0839d.m3817w();
                } catch (Throwable th) {
                    c0839d.unlock();
                    c0839d.m3817w();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        int m3826h = m3826h(obj);
        C0839d m3829k = m3829k(m3826h);
        m3829k.getClass();
        try {
            if (m3829k.f14571b != 0) {
                long read = m3829k.f14570a.f14602p.read();
                j92 m3804j = m3829k.m3804j(m3826h, obj);
                if (m3804j != null) {
                    if (m3829k.f14570a.m3827i(m3804j, read)) {
                        if (m3829k.tryLock()) {
                            try {
                                m3829k.m3801g(read);
                                m3829k.unlock();
                            } catch (Throwable th) {
                                m3829k.unlock();
                                throw th;
                            }
                        }
                    }
                    if (m3804j != null && m3804j.mo2221b().get() != null) {
                        z = true;
                    }
                }
                m3804j = null;
                if (m3804j != null) {
                    z = true;
                }
            }
            return z;
        } finally {
            m3829k.m3807m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        long read = this.f14602p.read();
        C0839d[] c0839dArr = this.f14589c;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = c0839dArr.length;
            long j2 = 0;
            for (?? r12 = z; r12 < length; r12++) {
                C0839d c0839d = c0839dArr[r12];
                int i2 = c0839d.f14571b;
                ?? r14 = c0839d.f14575f;
                for (?? r15 = z; r15 < r14.length(); r15++) {
                    j92 j92Var = (j92) r14.get(r15);
                    while (j92Var != null) {
                        C0839d[] c0839dArr2 = c0839dArr;
                        Object m3805k = c0839d.m3805k(j92Var, read);
                        long j3 = read;
                        if (m3805k != null && this.f14592f.equivalent(obj, m3805k)) {
                            return true;
                        }
                        j92Var = j92Var.mo2220a();
                        c0839dArr = c0839dArr2;
                        read = j3;
                    }
                }
                j2 += c0839d.f14573d;
                read = read;
                z = false;
            }
            long j4 = read;
            C0839d[] c0839dArr3 = c0839dArr;
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            c0839dArr = c0839dArr3;
            read = j4;
            z = false;
        }
        return z;
    }

    /* renamed from: e */
    public final boolean m3823e() {
        if (this.f14597k > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        ib1 ib1Var = this.f14608v;
        if (ib1Var == null) {
            ib1 ib1Var2 = new ib1(this, 0);
            this.f14608v = ib1Var2;
            return ib1Var2;
        }
        return ib1Var;
    }

    /* renamed from: f */
    public final boolean m3824f() {
        if (this.f14598l > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public final Object m3825g(Object obj, CacheLoader cacheLoader) {
        Object m3806l;
        j92 m3804j;
        int m3826h = m3826h(Preconditions.checkNotNull(obj));
        C0839d m3829k = m3829k(m3826h);
        m3829k.getClass();
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(cacheLoader);
        try {
            try {
                if (m3829k.f14571b != 0 && (m3804j = m3829k.m3804j(m3826h, obj)) != null) {
                    long read = m3829k.f14570a.f14602p.read();
                    Object m3805k = m3829k.m3805k(m3804j, read);
                    if (m3805k != null) {
                        m3829k.m3810p(m3804j, read);
                        m3829k.f14583n.recordHits(1);
                        m3806l = m3829k.m3818x(m3804j, obj, m3826h, m3805k, read, cacheLoader);
                    } else {
                        zb1 mo2221b = m3804j.mo2221b();
                        if (mo2221b.isLoading()) {
                            m3806l = m3829k.m3794B(m3804j, obj, mo2221b);
                        }
                    }
                    return m3806l;
                }
                m3806l = m3829k.m3806l(obj, m3826h, cacheLoader);
                return m3806l;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (!(cause instanceof Error)) {
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e;
                }
                throw new ExecutionError((Error) cause);
            }
        } finally {
            m3829k.m3807m();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int m3826h = m3826h(obj);
        return m3829k(m3826h).m3802h(obj, m3826h);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    /* renamed from: h */
    public final int m3826h(Object obj) {
        int hash = this.f14591e.hash(obj);
        int i = hash + ((hash << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = (i4 << 2) + (i4 << 14) + i4;
        return (i5 >>> 16) ^ i5;
    }

    /* renamed from: i */
    public final boolean m3827i(j92 j92Var, long j) {
        Preconditions.checkNotNull(j92Var);
        if (m3823e() && j - j92Var.mo57l() >= this.f14597k) {
            return true;
        }
        if (m3824f() && j - j92Var.mo51f() >= this.f14598l) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        C0839d[] c0839dArr = this.f14589c;
        long j = 0;
        for (int i = 0; i < c0839dArr.length; i++) {
            if (c0839dArr[i].f14571b != 0) {
                return false;
            }
            j += c0839dArr[i].f14573d;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < c0839dArr.length; i2++) {
            if (c0839dArr[i2].f14571b != 0) {
                return false;
            }
            j -= c0839dArr[i2].f14573d;
        }
        if (j != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map m3828j(Set set, CacheLoader cacheLoader) {
        AbstractCache.StatsCounter statsCounter = this.f14604r;
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        Stopwatch createStarted = Stopwatch.createStarted();
        boolean z = true;
        boolean z2 = false;
        try {
            try {
                try {
                    try {
                        Map loadAll = cacheLoader.loadAll(set);
                        if (loadAll != null) {
                            createStarted.stop();
                            for (Map.Entry entry : loadAll.entrySet()) {
                                Object key = entry.getKey();
                                Object value = entry.getValue();
                                if (key != null && value != null) {
                                    put(key, value);
                                } else {
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                statsCounter.recordLoadSuccess(createStarted.elapsed(TimeUnit.NANOSECONDS));
                                return loadAll;
                            }
                            statsCounter.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
                            String valueOf = String.valueOf(cacheLoader);
                            throw new CacheLoader.InvalidCacheLoadException(AbstractC1726qj.m7054j(valueOf.length() + 42, valueOf, " returned null keys or values from loadAll"));
                        }
                        statsCounter.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
                        String valueOf2 = String.valueOf(cacheLoader);
                        throw new CacheLoader.InvalidCacheLoadException(AbstractC1726qj.m7054j(valueOf2.length() + 31, valueOf2, " returned null map from loadAll"));
                    } catch (Exception e) {
                        throw new ExecutionException(e);
                    }
                } catch (Error e2) {
                    throw new ExecutionError(e2);
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                    throw new ExecutionException(e3);
                }
            } catch (CacheLoader.UnsupportedLoadingOperationException e4) {
                try {
                    throw e4;
                } catch (Throwable th) {
                    th = th;
                    if (!z) {
                        statsCounter.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
                    }
                    throw th;
                }
            } catch (RuntimeException e5) {
                throw new UncheckedExecutionException(e5);
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            if (!z) {
            }
            throw th;
        }
    }

    /* renamed from: k */
    public final C0839d m3829k(int i) {
        return this.f14589c[(i >>> this.f14588b) & this.f14587a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        ib1 ib1Var = this.f14606t;
        if (ib1Var == null) {
            ib1 ib1Var2 = new ib1(this, 1);
            this.f14606t = ib1Var2;
            return ib1Var2;
        }
        return ib1Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int m3826h = m3826h(obj);
        return m3829k(m3826h).m3808n(m3826h, obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int m3826h = m3826h(obj);
        return m3829k(m3826h).m3808n(m3826h, obj, obj2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        r7 = r3.mo2221b();
        r13 = r7.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r13 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        r0 = com.google.common.cache.RemovalCause.EXPLICIT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        r9.f14573d++;
        r0 = r9.m3815u(r2, r3, r4, r5, r13, r7, r8);
        r1 = r9.f14571b - 1;
        r10.set(r11, r0);
        r9.f14571b = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
    
        r9.unlock();
        r9.m3817w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        if (r7.isActive() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r0 = com.google.common.cache.RemovalCause.COLLECTED;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int m3826h = m3826h(obj);
        C0839d m3829k = m3829k(m3826h);
        m3829k.lock();
        try {
            m3829k.m3816v(m3829k.f14570a.f14602p.read());
            AtomicReferenceArray atomicReferenceArray = m3829k.f14575f;
            int length = m3826h & (atomicReferenceArray.length() - 1);
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            j92 j92Var2 = j92Var;
            while (true) {
                if (j92Var2 == null) {
                    break;
                }
                Object key = j92Var2.getKey();
                if (j92Var2.mo2222c() == m3826h && key != null && m3829k.f14570a.f14591e.equivalent(obj, key)) {
                    break;
                }
                j92Var2 = j92Var2.mo2220a();
            }
            m3829k.unlock();
            m3829k.m3817w();
            return null;
        } catch (Throwable th) {
            m3829k.unlock();
            m3829k.m3817w();
            throw th;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj3);
        if (obj2 == null) {
            return false;
        }
        int m3826h = m3826h(obj);
        C0839d m3829k = m3829k(m3826h);
        m3829k.lock();
        try {
            long read = m3829k.f14570a.f14602p.read();
            m3829k.m3816v(read);
            AtomicReferenceArray atomicReferenceArray = m3829k.f14575f;
            int length = m3826h & (atomicReferenceArray.length() - 1);
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            j92 j92Var2 = j92Var;
            while (true) {
                if (j92Var2 == null) {
                    break;
                }
                Object key = j92Var2.getKey();
                if (j92Var2.mo2222c() == m3826h && key != null && m3829k.f14570a.f14591e.equivalent(obj, key)) {
                    zb1 mo2221b = j92Var2.mo2221b();
                    Object obj4 = mo2221b.get();
                    if (obj4 == null) {
                        if (mo2221b.isActive()) {
                            m3829k.f14573d++;
                            j92 m3815u = m3829k.m3815u(j92Var, j92Var2, key, m3826h, obj4, mo2221b, RemovalCause.COLLECTED);
                            int i = m3829k.f14571b - 1;
                            atomicReferenceArray.set(length, m3815u);
                            m3829k.f14571b = i;
                        }
                    } else {
                        if (m3829k.f14570a.f14592f.equivalent(obj2, obj4)) {
                            m3829k.f14573d++;
                            m3829k.m3798d(obj, obj4, mo2221b.mo2071c(), RemovalCause.REPLACED);
                            m3829k.m3819y(j92Var2, obj, obj3, read);
                            m3829k.m3799e(j92Var2);
                            return true;
                        }
                        m3829k.m3809o(j92Var2, read);
                    }
                } else {
                    j92Var2 = j92Var2.mo2220a();
                }
            }
            return false;
        } finally {
            m3829k.unlock();
            m3829k.m3817w();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long j = 0;
        for (int i = 0; i < this.f14589c.length; i++) {
            j += Math.max(0, r0[i].f14571b);
        }
        return Ints.saturatedCast(j);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        C0578c2 c0578c2 = this.f14607u;
        if (c0578c2 == null) {
            C0578c2 c0578c22 = new C0578c2(6, this);
            this.f14607u = c0578c22;
            return c0578c22;
        }
        return c0578c2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r7 = r3.mo2221b();
        r6 = r7.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r9.f14570a.f14592f.equivalent(r15, r6) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r14 = com.google.common.cache.RemovalCause.EXPLICIT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
    
        r9.f14573d++;
        r15 = r9.m3815u(r2, r3, r4, r5, r6, r7, r14);
        r1 = r9.f14571b - 1;
        r10.set(r12, r15);
        r9.f14571b = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007d, code lost:
    
        if (r14 != com.google.common.cache.RemovalCause.EXPLICIT) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r6 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (r7.isActive() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r14 = com.google.common.cache.RemovalCause.COLLECTED;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(Object obj, Object obj2) {
        boolean z = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int m3826h = m3826h(obj);
        C0839d m3829k = m3829k(m3826h);
        m3829k.lock();
        try {
            m3829k.m3816v(m3829k.f14570a.f14602p.read());
            AtomicReferenceArray atomicReferenceArray = m3829k.f14575f;
            int length = m3826h & (atomicReferenceArray.length() - 1);
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            j92 j92Var2 = j92Var;
            while (true) {
                if (j92Var2 == null) {
                    break;
                }
                Object key = j92Var2.getKey();
                if (j92Var2.mo2222c() == m3826h && key != null && m3829k.f14570a.f14591e.equivalent(obj, key)) {
                    break;
                }
                j92Var2 = j92Var2.mo2220a();
            }
            m3829k.unlock();
            m3829k.m3817w();
            return z;
        } catch (Throwable th) {
            m3829k.unlock();
            m3829k.m3817w();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a6, code lost:
    
        return null;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object replace(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int m3826h = m3826h(obj);
        C0839d m3829k = m3829k(m3826h);
        m3829k.lock();
        try {
            long read = m3829k.f14570a.f14602p.read();
            m3829k.m3816v(read);
            AtomicReferenceArray atomicReferenceArray = m3829k.f14575f;
            int length = m3826h & (atomicReferenceArray.length() - 1);
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            j92 j92Var2 = j92Var;
            while (true) {
                if (j92Var2 == null) {
                    break;
                }
                Object key = j92Var2.getKey();
                if (j92Var2.mo2222c() == m3826h && key != null && m3829k.f14570a.f14591e.equivalent(obj, key)) {
                    zb1 mo2221b = j92Var2.mo2221b();
                    Object obj3 = mo2221b.get();
                    if (obj3 == null) {
                        if (mo2221b.isActive()) {
                            m3829k.f14573d++;
                            j92 m3815u = m3829k.m3815u(j92Var, j92Var2, key, m3826h, obj3, mo2221b, RemovalCause.COLLECTED);
                            int i = m3829k.f14571b - 1;
                            atomicReferenceArray.set(length, m3815u);
                            m3829k.f14571b = i;
                        }
                    } else {
                        m3829k.f14573d++;
                        m3829k.m3798d(obj, obj3, mo2221b.mo2071c(), RemovalCause.REPLACED);
                        m3829k.m3819y(j92Var2, obj, obj2, read);
                        m3829k.m3799e(j92Var2);
                        return obj3;
                    }
                } else {
                    j92Var2 = j92Var2.mo2220a();
                }
            }
        } finally {
            m3829k.unlock();
            m3829k.m3817w();
        }
    }
}
