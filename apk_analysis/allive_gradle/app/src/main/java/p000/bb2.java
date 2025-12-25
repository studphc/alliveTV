package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class bb2 extends AtomicReference implements za2 {
    private static final long serialVersionUID = -8056260896137901749L;

    /* renamed from: a */
    public final int f7949a;

    /* renamed from: b */
    public final long f7950b;

    /* renamed from: c */
    public final TimeUnit f7951c;

    /* renamed from: d */
    public final Scheduler f7952d;

    /* renamed from: e */
    public int f7953e;

    /* renamed from: f */
    public volatile db2 f7954f;

    /* renamed from: g */
    public db2 f7955g;

    /* renamed from: h */
    public volatile boolean f7956h;

    public bb2(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7949a = i;
        this.f7950b = j;
        this.f7951c = timeUnit;
        this.f7952d = scheduler;
        db2 db2Var = new db2(null, 0L);
        this.f7955g = db2Var;
        this.f7954f = db2Var;
    }

    /* renamed from: f */
    public static int m2074f(db2 db2Var) {
        int i = 0;
        while (i != Integer.MAX_VALUE) {
            db2 db2Var2 = (db2) db2Var.get();
            if (db2Var2 == null) {
                Object obj = db2Var.f16329a;
                if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                    return i - 1;
                }
                return i;
            }
            i++;
            db2Var = db2Var2;
        }
        return i;
    }

    @Override // p000.za2
    /* renamed from: a */
    public final void mo2075a(Object obj) {
        db2 db2Var = new db2(obj, Long.MAX_VALUE);
        db2 db2Var2 = this.f7955g;
        this.f7955g = db2Var;
        this.f7953e++;
        db2Var2.lazySet(db2Var);
        long now = this.f7952d.now(this.f7951c) - this.f7950b;
        db2 db2Var3 = this.f7954f;
        while (true) {
            db2 db2Var4 = (db2) db2Var3.get();
            if (db2Var4.get() == null) {
                if (db2Var3.f16329a != null) {
                    db2 db2Var5 = new db2(null, 0L);
                    db2Var5.lazySet(db2Var3.get());
                    this.f7954f = db2Var5;
                } else {
                    this.f7954f = db2Var3;
                }
            } else if (db2Var4.f16330b > now) {
                if (db2Var3.f16329a != null) {
                    db2 db2Var6 = new db2(null, 0L);
                    db2Var6.lazySet(db2Var3.get());
                    this.f7954f = db2Var6;
                } else {
                    this.f7954f = db2Var3;
                }
            } else {
                db2Var3 = db2Var4;
            }
        }
        this.f7956h = true;
    }

    @Override // p000.za2
    public final void add(Object obj) {
        db2 db2Var = new db2(obj, this.f7952d.now(this.f7951c));
        db2 db2Var2 = this.f7955g;
        this.f7955g = db2Var;
        this.f7953e++;
        db2Var2.set(db2Var);
        int i = this.f7953e;
        if (i > this.f7949a) {
            this.f7953e = i - 1;
            this.f7954f = (db2) this.f7954f.get();
        }
        long now = this.f7952d.now(this.f7951c) - this.f7950b;
        db2 db2Var3 = this.f7954f;
        while (this.f7953e > 1) {
            db2 db2Var4 = (db2) db2Var3.get();
            if (db2Var4.f16330b > now) {
                this.f7954f = db2Var3;
                return;
            } else {
                this.f7953e--;
                db2Var3 = db2Var4;
            }
        }
        this.f7954f = db2Var3;
    }

    @Override // p000.za2
    /* renamed from: b */
    public final void mo2076b(ab2 ab2Var) {
        if (ab2Var.getAndIncrement() != 0) {
            return;
        }
        Observer observer = ab2Var.f110a;
        db2 db2Var = (db2) ab2Var.f112c;
        if (db2Var == null) {
            db2Var = m2079e();
        }
        int i = 1;
        while (!ab2Var.f113d) {
            db2 db2Var2 = (db2) db2Var.get();
            if (db2Var2 == null) {
                ab2Var.f112c = db2Var;
                i = ab2Var.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object obj = db2Var2.f16329a;
                if (this.f7956h && db2Var2.get() == null) {
                    if (NotificationLite.isComplete(obj)) {
                        observer.onComplete();
                    } else {
                        observer.onError(NotificationLite.getError(obj));
                    }
                    ab2Var.f112c = null;
                    ab2Var.f113d = true;
                    return;
                }
                observer.onNext(obj);
                db2Var = db2Var2;
            }
        }
        ab2Var.f112c = null;
    }

    @Override // p000.za2
    /* renamed from: c */
    public final void mo2077c() {
        db2 db2Var = this.f7954f;
        if (db2Var.f16329a != null) {
            db2 db2Var2 = new db2(null, 0L);
            db2Var2.lazySet(db2Var.get());
            this.f7954f = db2Var2;
        }
    }

    @Override // p000.za2
    /* renamed from: d */
    public final Object[] mo2078d(Object[] objArr) {
        db2 m2079e = m2079e();
        int m2074f = m2074f(m2079e);
        if (m2074f == 0) {
            if (objArr.length != 0) {
                objArr[0] = null;
            }
        } else {
            if (objArr.length < m2074f) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), m2074f);
            }
            for (int i = 0; i != m2074f; i++) {
                m2079e = (db2) m2079e.get();
                objArr[i] = m2079e.f16329a;
            }
            if (objArr.length > m2074f) {
                objArr[m2074f] = null;
            }
        }
        return objArr;
    }

    /* renamed from: e */
    public final db2 m2079e() {
        db2 db2Var;
        db2 db2Var2 = this.f7954f;
        long now = this.f7952d.now(this.f7951c) - this.f7950b;
        Object obj = db2Var2.get();
        while (true) {
            db2 db2Var3 = (db2) obj;
            db2Var = db2Var2;
            db2Var2 = db2Var3;
            if (db2Var2 == null || db2Var2.f16330b > now) {
                break;
            }
            obj = db2Var2.get();
        }
        return db2Var;
    }

    @Override // p000.za2
    public final Object getValue() {
        Object obj;
        db2 db2Var = this.f7954f;
        db2 db2Var2 = null;
        while (true) {
            db2 db2Var3 = (db2) db2Var.get();
            if (db2Var3 == null) {
                break;
            }
            db2Var2 = db2Var;
            db2Var = db2Var3;
        }
        if (db2Var.f16330b < this.f7952d.now(this.f7951c) - this.f7950b || (obj = db2Var.f16329a) == null) {
            return null;
        }
        if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            return obj;
        }
        return db2Var2.f16329a;
    }

    @Override // p000.za2
    public final int size() {
        return m2074f(m2079e());
    }
}
