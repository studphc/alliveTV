package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import p000.AbstractC1726qj;
import p000.EnumC1985xj;
import p000.gb1;
import p000.j92;
import p000.lb1;
import p000.nu0;
import p000.rb1;
import p000.ub1;
import p000.zb1;

/* renamed from: com.google.common.cache.d */
/* loaded from: classes.dex */
public final class C0839d extends ReentrantLock {

    /* renamed from: a */
    public final ConcurrentMapC0840e f14570a;

    /* renamed from: b */
    public volatile int f14571b;

    /* renamed from: c */
    public long f14572c;

    /* renamed from: d */
    public int f14573d;

    /* renamed from: e */
    public int f14574e;

    /* renamed from: f */
    public volatile AtomicReferenceArray f14575f;

    /* renamed from: g */
    public final long f14576g;

    /* renamed from: h */
    public final ReferenceQueue f14577h;

    /* renamed from: i */
    public final ReferenceQueue f14578i;

    /* renamed from: j */
    public final AbstractQueue f14579j;

    /* renamed from: k */
    public final AtomicInteger f14580k = new AtomicInteger();

    /* renamed from: l */
    public final AbstractQueue f14581l;

    /* renamed from: m */
    public final AbstractQueue f14582m;

    /* renamed from: n */
    public final AbstractCache.StatsCounter f14583n;

    public C0839d(ConcurrentMapC0840e concurrentMapC0840e, int i, long j, AbstractCache.StatsCounter statsCounter) {
        ReferenceQueue referenceQueue;
        AbstractQueue concurrentLinkedQueue;
        AbstractQueue abstractQueue;
        AbstractQueue gb1Var;
        this.f14570a = concurrentMapC0840e;
        this.f14576g = j;
        this.f14583n = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
        int length = (atomicReferenceArray.length() * 3) / 4;
        this.f14574e = length;
        if (concurrentMapC0840e.f14596j == EnumC1985xj.f28583a && length == j) {
            this.f14574e = length + 1;
        }
        this.f14575f = atomicReferenceArray;
        rb1 rb1Var = ub1.f27185a;
        if (concurrentMapC0840e.f14593g != rb1Var) {
            referenceQueue = new ReferenceQueue();
        } else {
            referenceQueue = null;
        }
        this.f14577h = referenceQueue;
        this.f14578i = concurrentMapC0840e.f14594h != rb1Var ? new ReferenceQueue() : null;
        if (!concurrentMapC0840e.m3823e() && !concurrentMapC0840e.m3822c()) {
            concurrentLinkedQueue = ConcurrentMapC0840e.f14586y;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
        }
        this.f14579j = concurrentLinkedQueue;
        if (concurrentMapC0840e.m3824f()) {
            abstractQueue = new gb1(1);
        } else {
            abstractQueue = ConcurrentMapC0840e.f14586y;
        }
        this.f14581l = abstractQueue;
        if (!concurrentMapC0840e.m3823e() && !concurrentMapC0840e.m3822c()) {
            gb1Var = ConcurrentMapC0840e.f14586y;
        } else {
            gb1Var = new gb1(0);
        }
        this.f14582m = gb1Var;
    }

    /* renamed from: A */
    public final void m3793A() {
        if (tryLock()) {
            try {
                m3797c();
            } finally {
                unlock();
            }
        }
    }

    /* renamed from: B */
    public final Object m3794B(j92 j92Var, Object obj, zb1 zb1Var) {
        AbstractCache.StatsCounter statsCounter = this.f14583n;
        if (zb1Var.isLoading()) {
            Preconditions.checkState(!Thread.holdsLock(j92Var), "Recursive load of: %s", obj);
            try {
                Object mo2072d = zb1Var.mo2072d();
                if (mo2072d != null) {
                    m3810p(j92Var, this.f14570a.f14602p.read());
                    return mo2072d;
                }
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 35);
                sb.append("CacheLoader returned null for key ");
                sb.append(valueOf);
                sb.append(".");
                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
            } finally {
                statsCounter.recordMisses(1);
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public final j92 m3795a(j92 j92Var, j92 j92Var2) {
        if (j92Var.getKey() == null) {
            return null;
        }
        zb1 mo2221b = j92Var.mo2221b();
        Object obj = mo2221b.get();
        if (obj == null && mo2221b.isActive()) {
            return null;
        }
        j92 m7048d = AbstractC1726qj.m7048d(this.f14570a.f14603q, this, j92Var, j92Var2);
        m7048d.mo2223e(mo2221b.mo2073e(this.f14578i, obj, m7048d));
        return m7048d;
    }

    /* renamed from: b */
    public final void m3796b() {
        while (true) {
            j92 j92Var = (j92) this.f14579j.poll();
            if (j92Var != null) {
                AbstractQueue abstractQueue = this.f14582m;
                if (abstractQueue.contains(j92Var)) {
                    abstractQueue.add(j92Var);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0121, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010f, code lost:
    
        if (r14.isHeldByCurrentThread() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011e, code lost:
    
        if (r14.isHeldByCurrentThread() == false) goto L45;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3797c() {
        boolean z;
        ConcurrentMapC0840e concurrentMapC0840e = this.f14570a;
        rb1 rb1Var = ub1.f27185a;
        if (concurrentMapC0840e.f14593g != rb1Var) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i = 0;
            do {
                Object poll = this.f14577h.poll();
                if (poll == null) {
                    break;
                }
                j92 j92Var = (j92) poll;
                ConcurrentMapC0840e concurrentMapC0840e2 = this.f14570a;
                concurrentMapC0840e2.getClass();
                int mo2222c = j92Var.mo2222c();
                C0839d m3829k = concurrentMapC0840e2.m3829k(mo2222c);
                m3829k.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = m3829k.f14575f;
                    int length = mo2222c & (atomicReferenceArray.length() - 1);
                    j92 j92Var2 = (j92) atomicReferenceArray.get(length);
                    j92 j92Var3 = j92Var2;
                    while (true) {
                        if (j92Var3 == null) {
                            break;
                        }
                        if (j92Var3 == j92Var) {
                            m3829k.f14573d++;
                            j92 m3815u = m3829k.m3815u(j92Var2, j92Var3, j92Var3.getKey(), mo2222c, j92Var3.mo2221b().get(), j92Var3.mo2221b(), RemovalCause.COLLECTED);
                            int i2 = m3829k.f14571b - 1;
                            atomicReferenceArray.set(length, m3815u);
                            m3829k.f14571b = i2;
                            break;
                        }
                        int i3 = length;
                        AtomicReferenceArray atomicReferenceArray2 = atomicReferenceArray;
                        j92Var3 = j92Var3.mo2220a();
                        length = i3;
                        atomicReferenceArray = atomicReferenceArray2;
                    }
                    i++;
                } finally {
                    m3829k.unlock();
                    m3829k.m3817w();
                }
            } while (i != 16);
        }
        if (this.f14570a.f14594h != rb1Var) {
            int i4 = 0;
            do {
                Object poll2 = this.f14578i.poll();
                if (poll2 != null) {
                    zb1 zb1Var = (zb1) poll2;
                    ConcurrentMapC0840e concurrentMapC0840e3 = this.f14570a;
                    concurrentMapC0840e3.getClass();
                    j92 mo2069a = zb1Var.mo2069a();
                    int mo2222c2 = mo2069a.mo2222c();
                    C0839d m3829k2 = concurrentMapC0840e3.m3829k(mo2222c2);
                    Object key = mo2069a.getKey();
                    m3829k2.lock();
                    try {
                        AtomicReferenceArray atomicReferenceArray3 = m3829k2.f14575f;
                        int length2 = mo2222c2 & (atomicReferenceArray3.length() - 1);
                        j92 j92Var4 = (j92) atomicReferenceArray3.get(length2);
                        for (j92 j92Var5 = j92Var4; j92Var5 != null; j92Var5 = j92Var5.mo2220a()) {
                            Object key2 = j92Var5.getKey();
                            if (j92Var5.mo2222c() == mo2222c2 && key2 != null && m3829k2.f14570a.f14591e.equivalent(key, key2)) {
                                if (j92Var5.mo2221b() == zb1Var) {
                                    m3829k2.f14573d++;
                                    j92 m3815u2 = m3829k2.m3815u(j92Var4, j92Var5, key2, mo2222c2, zb1Var.get(), zb1Var, RemovalCause.COLLECTED);
                                    int i5 = m3829k2.f14571b - 1;
                                    atomicReferenceArray3.set(length2, m3815u2);
                                    m3829k2.f14571b = i5;
                                } else {
                                    m3829k2.unlock();
                                }
                            }
                        }
                        m3829k2.unlock();
                    } finally {
                        m3829k2.unlock();
                        if (!m3829k2.isHeldByCurrentThread()) {
                            m3829k2.m3817w();
                        }
                    }
                } else {
                    return;
                }
            } while (i4 != 16);
        }
    }

    /* renamed from: d */
    public final void m3798d(Object obj, Object obj2, int i, RemovalCause removalCause) {
        this.f14572c -= i;
        if (removalCause.mo3792a()) {
            this.f14583n.recordEviction();
        }
        ConcurrentMapC0840e concurrentMapC0840e = this.f14570a;
        if (concurrentMapC0840e.f14600n != ConcurrentMapC0840e.f14586y) {
            concurrentMapC0840e.f14600n.offer(RemovalNotification.create(obj, obj2, removalCause));
        }
    }

    /* renamed from: e */
    public final void m3799e(j92 j92Var) {
        if (!this.f14570a.m3822c()) {
            return;
        }
        m3796b();
        long mo2071c = j92Var.mo2221b().mo2071c();
        long j = this.f14576g;
        if (mo2071c > j && !m3813s(j92Var, j92Var.mo2222c(), RemovalCause.SIZE)) {
            throw new AssertionError();
        }
        while (this.f14572c > j) {
            for (j92 j92Var2 : this.f14582m) {
                if (j92Var2.mo2221b().mo2071c() > 0) {
                    if (!m3813s(j92Var2, j92Var2.mo2222c(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
            throw new AssertionError();
        }
    }

    /* renamed from: f */
    public final void m3800f() {
        AtomicReferenceArray atomicReferenceArray = this.f14575f;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i = this.f14571b;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
        this.f14574e = (atomicReferenceArray2.length() * 3) / 4;
        int length2 = atomicReferenceArray2.length() - 1;
        for (int i2 = 0; i2 < length; i2++) {
            j92 j92Var = (j92) atomicReferenceArray.get(i2);
            if (j92Var != null) {
                j92 mo2220a = j92Var.mo2220a();
                int mo2222c = j92Var.mo2222c() & length2;
                if (mo2220a == null) {
                    atomicReferenceArray2.set(mo2222c, j92Var);
                } else {
                    j92 j92Var2 = j92Var;
                    while (mo2220a != null) {
                        int mo2222c2 = mo2220a.mo2222c() & length2;
                        if (mo2222c2 != mo2222c) {
                            j92Var2 = mo2220a;
                            mo2222c = mo2222c2;
                        }
                        mo2220a = mo2220a.mo2220a();
                    }
                    atomicReferenceArray2.set(mo2222c, j92Var2);
                    while (j92Var != j92Var2) {
                        int mo2222c3 = j92Var.mo2222c() & length2;
                        j92 m3795a = m3795a(j92Var, (j92) atomicReferenceArray2.get(mo2222c3));
                        if (m3795a != null) {
                            atomicReferenceArray2.set(mo2222c3, m3795a);
                        } else {
                            m3812r(j92Var);
                            i--;
                        }
                        j92Var = j92Var.mo2220a();
                    }
                }
            }
        }
        this.f14575f = atomicReferenceArray2;
        this.f14571b = i;
    }

    /* renamed from: g */
    public final void m3801g(long j) {
        j92 j92Var;
        j92 j92Var2;
        m3796b();
        do {
            j92Var = (j92) this.f14581l.peek();
            ConcurrentMapC0840e concurrentMapC0840e = this.f14570a;
            if (j92Var == null || !concurrentMapC0840e.m3827i(j92Var, j)) {
                do {
                    j92Var2 = (j92) this.f14582m.peek();
                    if (j92Var2 == null || !concurrentMapC0840e.m3827i(j92Var2, j)) {
                        return;
                    }
                } while (m3813s(j92Var2, j92Var2.mo2222c(), RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        } while (m3813s(j92Var, j92Var.mo2222c(), RemovalCause.EXPIRED));
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[Catch: all -> 0x0055, TRY_ENTER, TryCatch #0 {all -> 0x0055, blocks: (B:2:0x0000, B:4:0x0005, B:11:0x0036, B:13:0x0040, B:16:0x0057, B:17:0x0015, B:19:0x001d, B:23:0x0026, B:26:0x002b, B:27:0x002e, B:22:0x0023), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032 A[DONT_GENERATE] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3802h(Object obj, int i) {
        j92 j92Var;
        try {
            if (this.f14571b != 0) {
                long read = this.f14570a.f14602p.read();
                j92 m3804j = m3804j(i, obj);
                if (m3804j != null) {
                    if (this.f14570a.m3827i(m3804j, read)) {
                        if (tryLock()) {
                            try {
                                m3801g(read);
                                unlock();
                            } catch (Throwable th) {
                                unlock();
                                throw th;
                            }
                        }
                    } else {
                        j92Var = m3804j;
                        if (j92Var != null) {
                            return null;
                        }
                        Object obj2 = j92Var.mo2221b().get();
                        if (obj2 != null) {
                            m3810p(j92Var, read);
                            return m3818x(j92Var, j92Var.getKey(), i, obj2, read, this.f14570a.f14605s);
                        }
                        m3793A();
                    }
                }
                j92Var = null;
                if (j92Var != null) {
                }
            }
            return null;
        } finally {
            m3807m();
        }
    }

    /* renamed from: i */
    public final Object m3803i(Object obj, int i, lb1 lb1Var, ListenableFuture listenableFuture) {
        Object obj2;
        AbstractCache.StatsCounter statsCounter = this.f14583n;
        try {
            obj2 = Uninterruptibles.getUninterruptibly(listenableFuture);
            try {
                if (obj2 != null) {
                    statsCounter.recordLoadSuccess(lb1Var.f22435c.elapsed(TimeUnit.NANOSECONDS));
                    m3820z(obj, i, lb1Var, obj2);
                    return obj2;
                }
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 35);
                sb.append("CacheLoader returned null for key ");
                sb.append(valueOf);
                sb.append(".");
                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
            } catch (Throwable th) {
                th = th;
                if (obj2 == null) {
                    statsCounter.recordLoadException(lb1Var.f22435c.elapsed(TimeUnit.NANOSECONDS));
                    lock();
                    try {
                        AtomicReferenceArray atomicReferenceArray = this.f14575f;
                        int length = (atomicReferenceArray.length() - 1) & i;
                        j92 j92Var = (j92) atomicReferenceArray.get(length);
                        j92 j92Var2 = j92Var;
                        while (true) {
                            if (j92Var2 == null) {
                                break;
                            }
                            Object key = j92Var2.getKey();
                            if (j92Var2.mo2222c() == i && key != null && this.f14570a.f14591e.equivalent(obj, key)) {
                                if (j92Var2.mo2221b() == lb1Var) {
                                    if (lb1Var.f22433a.isActive()) {
                                        j92Var2.mo2223e(lb1Var.f22433a);
                                    } else {
                                        atomicReferenceArray.set(length, m3814t(j92Var, j92Var2));
                                    }
                                }
                            } else {
                                j92Var2 = j92Var2.mo2220a();
                            }
                        }
                        unlock();
                        m3817w();
                    } catch (Throwable th2) {
                        unlock();
                        m3817w();
                        throw th2;
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            obj2 = null;
        }
    }

    /* renamed from: j */
    public final j92 m3804j(int i, Object obj) {
        for (j92 j92Var = (j92) this.f14575f.get((r0.length() - 1) & i); j92Var != null; j92Var = j92Var.mo2220a()) {
            if (j92Var.mo2222c() == i) {
                Object key = j92Var.getKey();
                if (key == null) {
                    m3793A();
                } else if (this.f14570a.f14591e.equivalent(obj, key)) {
                    return j92Var;
                }
            }
        }
        return null;
    }

    /* renamed from: k */
    public final Object m3805k(j92 j92Var, long j) {
        if (j92Var.getKey() == null) {
            m3793A();
            return null;
        }
        Object obj = j92Var.mo2221b().get();
        if (obj == null) {
            m3793A();
            return null;
        }
        if (this.f14570a.m3827i(j92Var, j)) {
            if (tryLock()) {
                try {
                    m3801g(j);
                } finally {
                    unlock();
                }
            }
            return null;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0094, code lost:
    
        if (r3 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0096, code lost:
    
        r11 = new p000.lb1();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009b, code lost:
    
        if (r10 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        r10 = p000.AbstractC1726qj.m7049e(r16.f14570a.f14603q, r16, com.google.common.base.Preconditions.checkNotNull(r17), r18, r9);
        r10.mo2223e(r11);
        r7.set(r8, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b0, code lost:
    
        r10.mo2223e(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b3, code lost:
    
        unlock();
        m3817w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
    
        if (r3 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00db, code lost:
    
        return m3794B(r10, r17, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bb, code lost:
    
        monitor-enter(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
    
        r0 = m3803i(r17, r18, r11, r11.m5914f(r17, r19));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        monitor-exit(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d1, code lost:
    
        r16.f14583n.recordMisses(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d6, code lost:
    
        throw r0;
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3806l(Object obj, int i, CacheLoader cacheLoader) {
        boolean z;
        zb1 zb1Var;
        lock();
        try {
            long read = this.f14570a.f14602p.read();
            m3816v(read);
            int i2 = this.f14571b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f14575f;
            int length = (atomicReferenceArray.length() - 1) & i;
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            j92 j92Var2 = j92Var;
            while (true) {
                lb1 lb1Var = null;
                if (j92Var2 != null) {
                    Object key = j92Var2.getKey();
                    if (j92Var2.mo2222c() == i && key != null && this.f14570a.f14591e.equivalent(obj, key)) {
                        zb1Var = j92Var2.mo2221b();
                        if (zb1Var.isLoading()) {
                            z = false;
                        } else {
                            Object obj2 = zb1Var.get();
                            if (obj2 == null) {
                                m3798d(key, obj2, zb1Var.mo2071c(), RemovalCause.COLLECTED);
                            } else if (this.f14570a.m3827i(j92Var2, read)) {
                                m3798d(key, obj2, zb1Var.mo2071c(), RemovalCause.EXPIRED);
                            } else {
                                m3809o(j92Var2, read);
                                this.f14583n.recordHits(1);
                                unlock();
                                m3817w();
                                return obj2;
                            }
                            this.f14581l.remove(j92Var2);
                            this.f14582m.remove(j92Var2);
                            this.f14571b = i2;
                            z = true;
                        }
                    } else {
                        j92Var2 = j92Var2.mo2220a();
                    }
                } else {
                    z = true;
                    zb1Var = null;
                    break;
                }
            }
        } catch (Throwable th) {
            unlock();
            m3817w();
            throw th;
        }
    }

    /* renamed from: m */
    public final void m3807m() {
        if ((this.f14580k.incrementAndGet() & 63) == 0) {
            m3816v(this.f14570a.f14602p.read());
            m3817w();
        }
    }

    /* renamed from: n */
    public final Object m3808n(int i, Object obj, Object obj2, boolean z) {
        int i2;
        lock();
        try {
            long read = this.f14570a.f14602p.read();
            m3816v(read);
            if (this.f14571b + 1 > this.f14574e) {
                m3800f();
            }
            AtomicReferenceArray atomicReferenceArray = this.f14575f;
            int length = i & (atomicReferenceArray.length() - 1);
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            for (j92 j92Var2 = j92Var; j92Var2 != null; j92Var2 = j92Var2.mo2220a()) {
                Object key = j92Var2.getKey();
                if (j92Var2.mo2222c() == i && key != null && this.f14570a.f14591e.equivalent(obj, key)) {
                    zb1 mo2221b = j92Var2.mo2221b();
                    Object obj3 = mo2221b.get();
                    if (obj3 == null) {
                        this.f14573d++;
                        if (mo2221b.isActive()) {
                            m3798d(obj, obj3, mo2221b.mo2071c(), RemovalCause.COLLECTED);
                            m3819y(j92Var2, obj, obj2, read);
                            i2 = this.f14571b;
                        } else {
                            m3819y(j92Var2, obj, obj2, read);
                            i2 = this.f14571b + 1;
                        }
                        this.f14571b = i2;
                        m3799e(j92Var2);
                        unlock();
                        m3817w();
                        return null;
                    }
                    if (z) {
                        m3809o(j92Var2, read);
                        unlock();
                        m3817w();
                        return obj3;
                    }
                    this.f14573d++;
                    m3798d(obj, obj3, mo2221b.mo2071c(), RemovalCause.REPLACED);
                    m3819y(j92Var2, obj, obj2, read);
                    m3799e(j92Var2);
                    unlock();
                    m3817w();
                    return obj3;
                }
            }
            this.f14573d++;
            j92 m7049e = AbstractC1726qj.m7049e(this.f14570a.f14603q, this, Preconditions.checkNotNull(obj), i, j92Var);
            m3819y(m7049e, obj, obj2, read);
            atomicReferenceArray.set(length, m7049e);
            this.f14571b++;
            m3799e(m7049e);
            unlock();
            m3817w();
            return null;
        } catch (Throwable th) {
            unlock();
            m3817w();
            throw th;
        }
    }

    /* renamed from: o */
    public final void m3809o(j92 j92Var, long j) {
        if (this.f14570a.m3823e()) {
            j92Var.mo54i(j);
        }
        this.f14582m.add(j92Var);
    }

    /* renamed from: p */
    public final void m3810p(j92 j92Var, long j) {
        if (this.f14570a.m3823e()) {
            j92Var.mo54i(j);
        }
        this.f14579j.add(j92Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        m3817w();
        r5 = r1;
     */
    /* JADX WARN: Finally extract failed */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3811q(Object obj, int i, CacheLoader cacheLoader, boolean z) {
        lb1 lb1Var;
        lb1 lb1Var2;
        lock();
        try {
            long read = this.f14570a.f14602p.read();
            m3816v(read);
            AtomicReferenceArray atomicReferenceArray = this.f14575f;
            int length = (atomicReferenceArray.length() - 1) & i;
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            j92 j92Var2 = j92Var;
            while (true) {
                if (j92Var2 != null) {
                    Object key = j92Var2.getKey();
                    if (j92Var2.mo2222c() == i && key != null && this.f14570a.f14591e.equivalent(obj, key)) {
                        zb1 mo2221b = j92Var2.mo2221b();
                        if (!mo2221b.isLoading() && (!z || read - j92Var2.mo51f() >= this.f14570a.f14599m)) {
                            this.f14573d++;
                            lb1Var = new lb1(mo2221b);
                            j92Var2.mo2223e(lb1Var);
                            unlock();
                        }
                        unlock();
                        m3817w();
                        lb1Var2 = null;
                    } else {
                        j92Var2 = j92Var2.mo2220a();
                    }
                } else {
                    this.f14573d++;
                    lb1Var = new lb1();
                    j92 m7049e = AbstractC1726qj.m7049e(this.f14570a.f14603q, this, Preconditions.checkNotNull(obj), i, j92Var);
                    m7049e.mo2223e(lb1Var);
                    atomicReferenceArray.set(length, m7049e);
                    unlock();
                    break;
                }
            }
            if (lb1Var2 == null) {
                return null;
            }
            ListenableFuture m5914f = lb1Var2.m5914f(obj, cacheLoader);
            m5914f.addListener(new nu0(this, obj, i, lb1Var2, m5914f), MoreExecutors.directExecutor());
            if (m5914f.isDone()) {
                try {
                    return Uninterruptibles.getUninterruptibly(m5914f);
                } catch (Throwable unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            unlock();
            m3817w();
            throw th;
        }
    }

    /* renamed from: r */
    public final void m3812r(j92 j92Var) {
        Object key = j92Var.getKey();
        j92Var.mo2222c();
        m3798d(key, j92Var.mo2221b().get(), j92Var.mo2221b().mo2071c(), RemovalCause.COLLECTED);
        this.f14581l.remove(j92Var);
        this.f14582m.remove(j92Var);
    }

    /* renamed from: s */
    public final boolean m3813s(j92 j92Var, int i, RemovalCause removalCause) {
        AtomicReferenceArray atomicReferenceArray = this.f14575f;
        int length = (atomicReferenceArray.length() - 1) & i;
        j92 j92Var2 = (j92) atomicReferenceArray.get(length);
        for (j92 j92Var3 = j92Var2; j92Var3 != null; j92Var3 = j92Var3.mo2220a()) {
            if (j92Var3 == j92Var) {
                this.f14573d++;
                j92 m3815u = m3815u(j92Var2, j92Var3, j92Var3.getKey(), i, j92Var3.mo2221b().get(), j92Var3.mo2221b(), removalCause);
                int i2 = this.f14571b - 1;
                atomicReferenceArray.set(length, m3815u);
                this.f14571b = i2;
                return true;
            }
        }
        return false;
    }

    /* renamed from: t */
    public final j92 m3814t(j92 j92Var, j92 j92Var2) {
        int i = this.f14571b;
        j92 mo2220a = j92Var2.mo2220a();
        while (j92Var != j92Var2) {
            j92 m3795a = m3795a(j92Var, mo2220a);
            if (m3795a != null) {
                mo2220a = m3795a;
            } else {
                m3812r(j92Var);
                i--;
            }
            j92Var = j92Var.mo2220a();
        }
        this.f14571b = i;
        return mo2220a;
    }

    /* renamed from: u */
    public final j92 m3815u(j92 j92Var, j92 j92Var2, Object obj, int i, Object obj2, zb1 zb1Var, RemovalCause removalCause) {
        m3798d(obj, obj2, zb1Var.mo2071c(), removalCause);
        this.f14581l.remove(j92Var2);
        this.f14582m.remove(j92Var2);
        if (zb1Var.isLoading()) {
            zb1Var.mo2070b(null);
            return j92Var;
        }
        return m3814t(j92Var, j92Var2);
    }

    /* renamed from: v */
    public final void m3816v(long j) {
        if (tryLock()) {
            try {
                m3797c();
                m3801g(j);
                this.f14580k.set(0);
            } finally {
                unlock();
            }
        }
    }

    /* renamed from: w */
    public final void m3817w() {
        if (isHeldByCurrentThread()) {
            return;
        }
        while (true) {
            ConcurrentMapC0840e concurrentMapC0840e = this.f14570a;
            RemovalNotification removalNotification = (RemovalNotification) concurrentMapC0840e.f14600n.poll();
            if (removalNotification != null) {
                try {
                    concurrentMapC0840e.f14601o.onRemoval(removalNotification);
                } catch (Throwable th) {
                    ConcurrentMapC0840e.f14584w.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: x */
    public final Object m3818x(j92 j92Var, Object obj, int i, Object obj2, long j, CacheLoader cacheLoader) {
        Object m3811q;
        ConcurrentMapC0840e concurrentMapC0840e = this.f14570a;
        if (concurrentMapC0840e.f14599m > 0 && j - j92Var.mo51f() > concurrentMapC0840e.f14599m && !j92Var.mo2221b().isLoading() && (m3811q = m3811q(obj, i, cacheLoader, true)) != null) {
            return m3811q;
        }
        return obj2;
    }

    /* renamed from: y */
    public final void m3819y(j92 j92Var, Object obj, Object obj2, long j) {
        boolean z;
        zb1 mo2221b = j92Var.mo2221b();
        ConcurrentMapC0840e concurrentMapC0840e = this.f14570a;
        int weigh = concurrentMapC0840e.f14596j.weigh(obj, obj2);
        if (weigh >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Weights must be non-negative");
        j92Var.mo2223e(concurrentMapC0840e.f14594h.mo7265b(this, j92Var, obj2, weigh));
        m3796b();
        this.f14572c += weigh;
        if (concurrentMapC0840e.m3823e()) {
            j92Var.mo54i(j);
        }
        if (concurrentMapC0840e.m3824f() || concurrentMapC0840e.f14599m > 0) {
            j92Var.mo58m(j);
        }
        this.f14582m.add(j92Var);
        this.f14581l.add(j92Var);
        mo2221b.mo2070b(obj2);
    }

    /* renamed from: z */
    public final void m3820z(Object obj, int i, lb1 lb1Var, Object obj2) {
        RemovalCause removalCause;
        lock();
        try {
            long read = this.f14570a.f14602p.read();
            m3816v(read);
            int i2 = this.f14571b + 1;
            if (i2 > this.f14574e) {
                m3800f();
                i2 = this.f14571b + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f14575f;
            int length = i & (atomicReferenceArray.length() - 1);
            j92 j92Var = (j92) atomicReferenceArray.get(length);
            for (j92 j92Var2 = j92Var; j92Var2 != null; j92Var2 = j92Var2.mo2220a()) {
                Object key = j92Var2.getKey();
                if (j92Var2.mo2222c() == i && key != null && this.f14570a.f14591e.equivalent(obj, key)) {
                    zb1 mo2221b = j92Var2.mo2221b();
                    Object obj3 = mo2221b.get();
                    if (lb1Var != mo2221b && (obj3 != null || mo2221b == ConcurrentMapC0840e.f14585x)) {
                        m3798d(obj, obj2, 0, RemovalCause.REPLACED);
                        unlock();
                        m3817w();
                        return;
                    }
                    this.f14573d++;
                    if (lb1Var.f22433a.isActive()) {
                        if (obj3 == null) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            removalCause = RemovalCause.REPLACED;
                        }
                        m3798d(obj, obj3, lb1Var.f22433a.mo2071c(), removalCause);
                        i2--;
                    }
                    m3819y(j92Var2, obj, obj2, read);
                    this.f14571b = i2;
                    m3799e(j92Var2);
                    unlock();
                    m3817w();
                    return;
                }
            }
            this.f14573d++;
            j92 m7049e = AbstractC1726qj.m7049e(this.f14570a.f14603q, this, Preconditions.checkNotNull(obj), i, j92Var);
            m3819y(m7049e, obj, obj2, read);
            atomicReferenceArray.set(length, m7049e);
            this.f14571b = i2;
            m3799e(m7049e);
            unlock();
            m3817w();
        } catch (Throwable th) {
            unlock();
            m3817w();
            throw th;
        }
    }
}
