package p000;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class ef1 extends ReentrantLock {

    /* renamed from: g */
    public static final /* synthetic */ int f16785g = 0;

    /* renamed from: a */
    public final zf1 f16786a;

    /* renamed from: b */
    public volatile int f16787b;

    /* renamed from: c */
    public int f16788c;

    /* renamed from: d */
    public int f16789d;

    /* renamed from: e */
    public volatile AtomicReferenceArray f16790e;

    /* renamed from: f */
    public final AtomicInteger f16791f = new AtomicInteger();

    public ef1(zf1 zf1Var, int i) {
        this.f16786a = zf1Var;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
        int length = (atomicReferenceArray.length() * 3) / 4;
        this.f16789d = length;
        if (length == -1) {
            this.f16789d = length + 1;
        }
        this.f16790e = atomicReferenceArray;
    }

    /* renamed from: a */
    public final void m4700a(ReferenceQueue referenceQueue) {
        int i = 0;
        do {
            Object poll = referenceQueue.poll();
            if (poll != null) {
                cf1 cf1Var = (cf1) poll;
                zf1 zf1Var = this.f16786a;
                zf1Var.getClass();
                int mo2230c = cf1Var.mo2230c();
                ef1 m8415e = zf1Var.m8415e(mo2230c);
                m8415e.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = m8415e.f16790e;
                    int length = mo2230c & (atomicReferenceArray.length() - 1);
                    cf1 cf1Var2 = (cf1) atomicReferenceArray.get(length);
                    cf1 cf1Var3 = cf1Var2;
                    while (true) {
                        if (cf1Var3 == null) {
                            break;
                        }
                        if (cf1Var3 == cf1Var) {
                            m8415e.f16788c++;
                            cf1 m4708i = m8415e.m4708i(cf1Var2, cf1Var3);
                            int i2 = m8415e.f16787b - 1;
                            atomicReferenceArray.set(length, m4708i);
                            m8415e.f16787b = i2;
                            break;
                        }
                        cf1Var3 = cf1Var3.mo2229a();
                    }
                    i++;
                } finally {
                    m8415e.unlock();
                }
            } else {
                return;
            }
        } while (i != 16);
    }

    /* renamed from: b */
    public final void m4701b(ReferenceQueue referenceQueue) {
        int i = 0;
        do {
            Object poll = referenceQueue.poll();
            if (poll != null) {
                wf1 wf1Var = (wf1) poll;
                zf1 zf1Var = this.f16786a;
                zf1Var.getClass();
                cf1 mo8054a = wf1Var.mo8054a();
                int mo2230c = mo8054a.mo2230c();
                ef1 m8415e = zf1Var.m8415e(mo2230c);
                Object key = mo8054a.getKey();
                m8415e.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = m8415e.f16790e;
                    int length = (atomicReferenceArray.length() - 1) & mo2230c;
                    cf1 cf1Var = (cf1) atomicReferenceArray.get(length);
                    cf1 cf1Var2 = cf1Var;
                    while (true) {
                        if (cf1Var2 == null) {
                            break;
                        }
                        Object key2 = cf1Var2.getKey();
                        if (cf1Var2.mo2230c() == mo2230c && key2 != null && m8415e.f16786a.f29354e.equivalent(key, key2)) {
                            if (((vf1) cf1Var2).mo6348b() == wf1Var) {
                                m8415e.f16788c++;
                                cf1 m4708i = m8415e.m4708i(cf1Var, cf1Var2);
                                int i2 = m8415e.f16787b - 1;
                                atomicReferenceArray.set(length, m4708i);
                                m8415e.f16787b = i2;
                            }
                        } else {
                            cf1Var2 = cf1Var2.mo2229a();
                        }
                    }
                    i++;
                } finally {
                    m8415e.unlock();
                }
            } else {
                return;
            }
        } while (i != 16);
    }

    /* renamed from: c */
    public final void m4702c() {
        AtomicReferenceArray atomicReferenceArray = this.f16790e;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i = this.f16787b;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
        this.f16789d = (atomicReferenceArray2.length() * 3) / 4;
        int length2 = atomicReferenceArray2.length() - 1;
        for (int i2 = 0; i2 < length; i2++) {
            cf1 cf1Var = (cf1) atomicReferenceArray.get(i2);
            if (cf1Var != null) {
                cf1 mo2229a = cf1Var.mo2229a();
                int mo2230c = cf1Var.mo2230c() & length2;
                if (mo2229a == null) {
                    atomicReferenceArray2.set(mo2230c, cf1Var);
                } else {
                    cf1 cf1Var2 = cf1Var;
                    while (mo2229a != null) {
                        int mo2230c2 = mo2229a.mo2230c() & length2;
                        if (mo2230c2 != mo2230c) {
                            cf1Var2 = mo2229a;
                            mo2230c = mo2230c2;
                        }
                        mo2229a = mo2229a.mo2229a();
                    }
                    atomicReferenceArray2.set(mo2230c, cf1Var2);
                    while (cf1Var != cf1Var2) {
                        int mo2230c3 = cf1Var.mo2230c() & length2;
                        cf1 mo4576g = this.f16786a.f29355f.mo4576g(mo4710k(), cf1Var, (cf1) atomicReferenceArray2.get(mo2230c3));
                        if (mo4576g != null) {
                            atomicReferenceArray2.set(mo2230c3, mo4576g);
                        } else {
                            i--;
                        }
                        cf1Var = cf1Var.mo2229a();
                    }
                }
            }
        }
        this.f16790e = atomicReferenceArray2;
        this.f16787b = i;
    }

    /* renamed from: d */
    public final cf1 m4703d(int i, Object obj) {
        if (this.f16787b != 0) {
            for (cf1 cf1Var = (cf1) this.f16790e.get((r0.length() - 1) & i); cf1Var != null; cf1Var = cf1Var.mo2229a()) {
                if (cf1Var.mo2230c() == i) {
                    Object key = cf1Var.getKey();
                    if (key == null) {
                        m4712m();
                    } else if (this.f16786a.f29354e.equivalent(obj, key)) {
                        return cf1Var;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: g */
    public final void m4706g() {
        if ((this.f16791f.incrementAndGet() & 63) == 0) {
            m4709j();
        }
    }

    /* renamed from: h */
    public final Object m4707h(int i, Object obj, Object obj2, boolean z) {
        lock();
        try {
            m4709j();
            int i2 = this.f16787b + 1;
            if (i2 > this.f16789d) {
                m4702c();
                i2 = this.f16787b + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f16790e;
            int length = (atomicReferenceArray.length() - 1) & i;
            cf1 cf1Var = (cf1) atomicReferenceArray.get(length);
            for (cf1 cf1Var2 = cf1Var; cf1Var2 != null; cf1Var2 = cf1Var2.mo2229a()) {
                Object key = cf1Var2.getKey();
                if (cf1Var2.mo2230c() == i && key != null && this.f16786a.f29354e.equivalent(obj, key)) {
                    Object value = cf1Var2.getValue();
                    if (value == null) {
                        this.f16788c++;
                        m4711l(cf1Var2, obj2);
                        this.f16787b = this.f16787b;
                        unlock();
                        return null;
                    }
                    if (z) {
                        unlock();
                        return value;
                    }
                    this.f16788c++;
                    m4711l(cf1Var2, obj2);
                    unlock();
                    return value;
                }
            }
            this.f16788c++;
            cf1 mo4578n = this.f16786a.f29355f.mo4578n(mo4710k(), obj, i, cf1Var);
            m4711l(mo4578n, obj2);
            atomicReferenceArray.set(length, mo4578n);
            this.f16787b = i2;
            unlock();
            return null;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* renamed from: i */
    public final cf1 m4708i(cf1 cf1Var, cf1 cf1Var2) {
        int i = this.f16787b;
        cf1 mo2229a = cf1Var2.mo2229a();
        while (cf1Var != cf1Var2) {
            cf1 mo4576g = this.f16786a.f29355f.mo4576g(mo4710k(), cf1Var, mo2229a);
            if (mo4576g != null) {
                mo2229a = mo4576g;
            } else {
                i--;
            }
            cf1Var = cf1Var.mo2229a();
        }
        this.f16787b = i;
        return mo2229a;
    }

    /* renamed from: j */
    public final void m4709j() {
        if (tryLock()) {
            try {
                mo4705f();
                this.f16791f.set(0);
            } finally {
                unlock();
            }
        }
    }

    /* renamed from: k */
    public abstract ef1 mo4710k();

    /* renamed from: l */
    public final void m4711l(cf1 cf1Var, Object obj) {
        this.f16786a.f29355f.mo4577i(mo4710k(), cf1Var, obj);
    }

    /* renamed from: m */
    public final void m4712m() {
        if (tryLock()) {
            try {
                mo4705f();
            } finally {
                unlock();
            }
        }
    }

    /* renamed from: e */
    public void mo4704e() {
    }

    /* renamed from: f */
    public void mo4705f() {
    }
}
