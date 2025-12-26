package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.C0839d;
import com.google.common.cache.ConcurrentMapC0840e;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class jb1 implements Iterator {

    /* renamed from: b */
    public int f20446b;

    /* renamed from: d */
    public AtomicReferenceArray f20448d;

    /* renamed from: e */
    public ReentrantLock f20449e;

    /* renamed from: f */
    public Object f20450f;

    /* renamed from: g */
    public Map.Entry f20451g;

    /* renamed from: h */
    public Map.Entry f20452h;

    /* renamed from: i */
    public final /* synthetic */ AbstractMap f20453i;

    /* renamed from: a */
    public final /* synthetic */ int f20445a = 0;

    /* renamed from: c */
    public int f20447c = -1;

    public jb1(zf1 zf1Var) {
        this.f20453i = zf1Var;
        this.f20446b = zf1Var.f29352c.length - 1;
        m5424a();
    }

    /* renamed from: a */
    public final void m5424a() {
        switch (this.f20445a) {
            case 0:
                this.f20451g = null;
                if (m5429f() || m5430g()) {
                    return;
                }
                while (true) {
                    int i = this.f20446b;
                    if (i >= 0) {
                        C0839d[] c0839dArr = ((ConcurrentMapC0840e) this.f20453i).f14589c;
                        this.f20446b = i - 1;
                        C0839d c0839d = c0839dArr[i];
                        this.f20449e = c0839d;
                        if (c0839d.f14571b != 0) {
                            this.f20448d = ((C0839d) this.f20449e).f14575f;
                            this.f20447c = r0.length() - 1;
                            if (m5430g()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                break;
            default:
                this.f20451g = null;
                if (m5429f() || m5430g()) {
                    return;
                }
                while (true) {
                    int i2 = this.f20446b;
                    if (i2 >= 0) {
                        ef1[] ef1VarArr = ((zf1) this.f20453i).f29352c;
                        this.f20446b = i2 - 1;
                        ef1 ef1Var = ef1VarArr[i2];
                        this.f20449e = ef1Var;
                        if (ef1Var.f16787b != 0) {
                            this.f20448d = ((ef1) this.f20449e).f16790e;
                            this.f20447c = r0.length() - 1;
                            if (m5430g()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                break;
        }
    }

    /* renamed from: b */
    public boolean m5425b(cf1 cf1Var) {
        Object value;
        zf1 zf1Var = (zf1) this.f20453i;
        try {
            Object key = cf1Var.getKey();
            zf1Var.getClass();
            if (cf1Var.getKey() == null) {
                value = null;
            } else {
                value = cf1Var.getValue();
            }
            if (value != null) {
                this.f20451g = new yf1(zf1Var, key, value);
                ((ef1) this.f20449e).m4706g();
                return true;
            }
            ((ef1) this.f20449e).m4706g();
            return false;
        } catch (Throwable th) {
            ((ef1) this.f20449e).m4706g();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
    
        r6.f20451g = new p000.hc1(r0, r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        ((com.google.common.cache.C0839d) r6.f20449e).m3807m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
    
        return true;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m5426c(j92 j92Var) {
        Object obj;
        ConcurrentMapC0840e concurrentMapC0840e = (ConcurrentMapC0840e) this.f20453i;
        try {
            long read = concurrentMapC0840e.f14602p.read();
            Object key = j92Var.getKey();
            Object obj2 = null;
            if (j92Var.getKey() != null && (obj = j92Var.mo2221b().get()) != null && !concurrentMapC0840e.m3827i(j92Var, read)) {
                obj2 = obj;
            }
            ((C0839d) this.f20449e).m3807m();
            return false;
        } catch (Throwable th) {
            ((C0839d) this.f20449e).m3807m();
            throw th;
        }
    }

    /* renamed from: d */
    public hc1 m5427d() {
        hc1 hc1Var = (hc1) this.f20451g;
        if (hc1Var != null) {
            this.f20452h = hc1Var;
            m5424a();
            return (hc1) this.f20452h;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: e */
    public yf1 m5428e() {
        yf1 yf1Var = (yf1) this.f20451g;
        if (yf1Var != null) {
            this.f20452h = yf1Var;
            m5424a();
            return (yf1) this.f20452h;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: f */
    public final boolean m5429f() {
        switch (this.f20445a) {
            case 0:
                j92 j92Var = (j92) this.f20450f;
                if (j92Var != null) {
                    while (true) {
                        this.f20450f = j92Var.mo2220a();
                        j92 j92Var2 = (j92) this.f20450f;
                        if (j92Var2 != null) {
                            if (m5426c(j92Var2)) {
                                return true;
                            }
                            j92Var = (j92) this.f20450f;
                        }
                    }
                }
                return false;
            default:
                cf1 cf1Var = (cf1) this.f20450f;
                if (cf1Var != null) {
                    while (true) {
                        this.f20450f = cf1Var.mo2229a();
                        cf1 cf1Var2 = (cf1) this.f20450f;
                        if (cf1Var2 != null) {
                            if (m5425b(cf1Var2)) {
                                return true;
                            }
                            cf1Var = (cf1) this.f20450f;
                        }
                    }
                }
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        return true;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m5430g() {
        switch (this.f20445a) {
            case 0:
                while (true) {
                    int i = this.f20447c;
                    if (i >= 0) {
                        AtomicReferenceArray atomicReferenceArray = this.f20448d;
                        this.f20447c = i - 1;
                        j92 j92Var = (j92) atomicReferenceArray.get(i);
                        this.f20450f = j92Var;
                        if (j92Var == null || (!m5426c(j92Var) && !m5429f())) {
                        }
                    } else {
                        return false;
                    }
                }
                break;
            default:
                while (true) {
                    int i2 = this.f20447c;
                    if (i2 >= 0) {
                        AtomicReferenceArray atomicReferenceArray2 = this.f20448d;
                        this.f20447c = i2 - 1;
                        cf1 cf1Var = (cf1) atomicReferenceArray2.get(i2);
                        this.f20450f = cf1Var;
                        if (cf1Var == null || (!m5425b(cf1Var) && !m5429f())) {
                        }
                    } else {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f20445a) {
            case 0:
                if (((hc1) this.f20451g) != null) {
                    return true;
                }
                return false;
            default:
                if (((yf1) this.f20451g) != null) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f20445a) {
            case 0:
                return m5427d();
            default:
                return m5428e();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        boolean z2;
        switch (this.f20445a) {
            case 0:
                if (((hc1) this.f20452h) != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                ((ConcurrentMapC0840e) this.f20453i).remove(((hc1) this.f20452h).f18017a);
                this.f20452h = null;
                return;
            default:
                if (((yf1) this.f20452h) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                p63.m6876t(z2);
                ((zf1) this.f20453i).remove(((yf1) this.f20452h).f28936a);
                this.f20452h = null;
                return;
        }
    }

    public jb1(ConcurrentMapC0840e concurrentMapC0840e) {
        this.f20453i = concurrentMapC0840e;
        this.f20446b = concurrentMapC0840e.f14589c.length - 1;
        m5424a();
    }
}
