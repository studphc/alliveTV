package p000;

import io.reactivex.rxjava3.core.Scheduler;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ua2 implements sa2 {

    /* renamed from: a */
    public final int f27167a;

    /* renamed from: b */
    public final long f27168b;

    /* renamed from: c */
    public final TimeUnit f27169c;

    /* renamed from: d */
    public final Scheduler f27170d;

    /* renamed from: e */
    public int f27171e;

    /* renamed from: f */
    public volatile wa2 f27172f;

    /* renamed from: g */
    public wa2 f27173g;

    /* renamed from: h */
    public Throwable f27174h;

    /* renamed from: i */
    public volatile boolean f27175i;

    public ua2(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f27167a = i;
        this.f27168b = j;
        this.f27169c = timeUnit;
        this.f27170d = scheduler;
        wa2 wa2Var = new wa2(null, 0L);
        this.f27173g = wa2Var;
        this.f27172f = wa2Var;
    }

    @Override // p000.sa2
    /* renamed from: a */
    public final void mo7349a(Object obj) {
        wa2 wa2Var = new wa2(obj, this.f27170d.now(this.f27169c));
        wa2 wa2Var2 = this.f27173g;
        this.f27173g = wa2Var;
        this.f27171e++;
        wa2Var2.set(wa2Var);
        int i = this.f27171e;
        if (i > this.f27167a) {
            this.f27171e = i - 1;
            this.f27172f = (wa2) this.f27172f.get();
        }
        long now = this.f27170d.now(this.f27169c) - this.f27168b;
        wa2 wa2Var3 = this.f27172f;
        while (this.f27171e > 1) {
            wa2 wa2Var4 = (wa2) wa2Var3.get();
            if (wa2Var4.f28121b > now) {
                this.f27172f = wa2Var3;
                return;
            } else {
                this.f27171e--;
                wa2Var3 = wa2Var4;
            }
        }
        this.f27172f = wa2Var3;
    }

    @Override // p000.sa2
    /* renamed from: b */
    public final void mo7350b(Throwable th) {
        m7690g();
        this.f27174h = th;
        this.f27175i = true;
    }

    @Override // p000.sa2
    /* renamed from: c */
    public final void mo7351c() {
        if (this.f27172f.f28120a != null) {
            wa2 wa2Var = new wa2(null, 0L);
            wa2Var.lazySet(this.f27172f.get());
            this.f27172f = wa2Var;
        }
    }

    @Override // p000.sa2
    public final void complete() {
        m7690g();
        this.f27175i = true;
    }

    @Override // p000.sa2
    /* renamed from: d */
    public final Object[] mo7352d(Object[] objArr) {
        wa2 m7689f = m7689f();
        wa2 wa2Var = m7689f;
        int i = 0;
        while (i != Integer.MAX_VALUE && (wa2Var = (wa2) wa2Var.get()) != null) {
            i++;
        }
        if (i == 0) {
            if (objArr.length != 0) {
                objArr[0] = null;
            }
        } else {
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 != i; i2++) {
                m7689f = (wa2) m7689f.get();
                objArr[i2] = m7689f.f28120a;
            }
            if (objArr.length > i) {
                objArr[i] = null;
            }
        }
        return objArr;
    }

    @Override // p000.sa2
    /* renamed from: e */
    public final void mo7353e(ta2 ta2Var) {
        boolean z;
        if (ta2Var.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = ta2Var.f26750a;
        wa2 wa2Var = (wa2) ta2Var.f26752c;
        if (wa2Var == null) {
            wa2Var = m7689f();
        }
        long j = ta2Var.f26755f;
        int i = 1;
        do {
            long j2 = ta2Var.f26753d.get();
            while (j != j2) {
                if (ta2Var.f26754e) {
                    ta2Var.f26752c = null;
                    return;
                }
                boolean z2 = this.f27175i;
                wa2 wa2Var2 = (wa2) wa2Var.get();
                if (wa2Var2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    ta2Var.f26752c = null;
                    ta2Var.f26754e = true;
                    Throwable th = this.f27174h;
                    if (th == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(th);
                        return;
                    }
                }
                if (z) {
                    break;
                }
                subscriber.onNext(wa2Var2.f28120a);
                j++;
                wa2Var = wa2Var2;
            }
            if (j == j2) {
                if (ta2Var.f26754e) {
                    ta2Var.f26752c = null;
                    return;
                }
                if (this.f27175i && wa2Var.get() == null) {
                    ta2Var.f26752c = null;
                    ta2Var.f26754e = true;
                    Throwable th2 = this.f27174h;
                    if (th2 == null) {
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onError(th2);
                        return;
                    }
                }
            }
            ta2Var.f26752c = wa2Var;
            ta2Var.f26755f = j;
            i = ta2Var.addAndGet(-i);
        } while (i != 0);
    }

    /* renamed from: f */
    public final wa2 m7689f() {
        wa2 wa2Var;
        wa2 wa2Var2 = this.f27172f;
        long now = this.f27170d.now(this.f27169c) - this.f27168b;
        Object obj = wa2Var2.get();
        while (true) {
            wa2 wa2Var3 = (wa2) obj;
            wa2Var = wa2Var2;
            wa2Var2 = wa2Var3;
            if (wa2Var2 == null || wa2Var2.f28121b > now) {
                break;
            }
            obj = wa2Var2.get();
        }
        return wa2Var;
    }

    /* renamed from: g */
    public final void m7690g() {
        long now = this.f27170d.now(this.f27169c) - this.f27168b;
        wa2 wa2Var = this.f27172f;
        while (true) {
            wa2 wa2Var2 = (wa2) wa2Var.get();
            if (wa2Var2 == null) {
                if (wa2Var.f28120a != null) {
                    this.f27172f = new wa2(null, 0L);
                    return;
                } else {
                    this.f27172f = wa2Var;
                    return;
                }
            }
            if (wa2Var2.f28121b > now) {
                if (wa2Var.f28120a != null) {
                    wa2 wa2Var3 = new wa2(null, 0L);
                    wa2Var3.lazySet(wa2Var.get());
                    this.f27172f = wa2Var3;
                    return;
                }
                this.f27172f = wa2Var;
                return;
            }
            wa2Var = wa2Var2;
        }
    }

    @Override // p000.sa2
    public final Throwable getError() {
        return this.f27174h;
    }

    @Override // p000.sa2
    public final Object getValue() {
        wa2 wa2Var = this.f27172f;
        while (true) {
            wa2 wa2Var2 = (wa2) wa2Var.get();
            if (wa2Var2 == null) {
                break;
            }
            wa2Var = wa2Var2;
        }
        if (wa2Var.f28121b < this.f27170d.now(this.f27169c) - this.f27168b) {
            return null;
        }
        return wa2Var.f28120a;
    }

    @Override // p000.sa2
    public final boolean isDone() {
        return this.f27175i;
    }

    @Override // p000.sa2
    public final int size() {
        wa2 m7689f = m7689f();
        int i = 0;
        while (i != Integer.MAX_VALUE && (m7689f = (wa2) m7689f.get()) != null) {
            i++;
        }
        return i;
    }
}
