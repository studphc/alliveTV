package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class op0 extends ep0 {
    private static final long serialVersionUID = 3457957419649567404L;

    /* renamed from: e */
    public final Scheduler f24851e;

    /* renamed from: f */
    public final long f24852f;

    /* renamed from: g */
    public final TimeUnit f24853g;

    /* renamed from: h */
    public final int f24854h;

    public op0(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(z);
        this.f24851e = scheduler;
        this.f24854h = i;
        this.f24852f = j;
        this.f24853g = timeUnit;
    }

    @Override // p000.ep0
    /* renamed from: d */
    public final Object mo4743d(Object obj, boolean z) {
        long now;
        TimeUnit timeUnit = this.f24853g;
        if (z) {
            now = Long.MAX_VALUE;
        } else {
            now = this.f24851e.now(timeUnit);
        }
        return new Timed(obj, now, timeUnit);
    }

    @Override // p000.ep0
    /* renamed from: e */
    public final ip0 mo4744e() {
        ip0 ip0Var;
        long now = this.f24851e.now(this.f24853g) - this.f24852f;
        ip0 ip0Var2 = (ip0) get();
        Object obj = ip0Var2.get();
        while (true) {
            ip0 ip0Var3 = (ip0) obj;
            ip0Var = ip0Var2;
            ip0Var2 = ip0Var3;
            if (ip0Var2 != null) {
                Timed timed = (Timed) ip0Var2.f20168a;
                if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                    break;
                }
                obj = ip0Var2.get();
            } else {
                break;
            }
        }
        return ip0Var;
    }

    @Override // p000.ep0
    /* renamed from: f */
    public final Object mo4745f(Object obj) {
        return ((Timed) obj).value();
    }

    @Override // p000.ep0
    /* renamed from: h */
    public final void mo4747h() {
        ip0 ip0Var;
        long now = this.f24851e.now(this.f24853g) - this.f24852f;
        ip0 ip0Var2 = (ip0) get();
        ip0 ip0Var3 = (ip0) ip0Var2.get();
        int i = 0;
        while (true) {
            ip0 ip0Var4 = ip0Var3;
            ip0Var = ip0Var2;
            ip0Var2 = ip0Var4;
            int i2 = this.f16940c;
            if (i2 > 1) {
                if (i2 > this.f24854h) {
                    i++;
                    this.f16940c = i2 - 1;
                    ip0Var3 = (ip0) ip0Var2.get();
                } else {
                    if (((Timed) ip0Var2.f20168a).time() > now) {
                        break;
                    }
                    i++;
                    this.f16940c--;
                    ip0Var3 = (ip0) ip0Var2.get();
                }
            } else {
                break;
            }
        }
        if (i != 0) {
            m4746g(ip0Var);
        }
    }

    @Override // p000.ep0
    /* renamed from: i */
    public final void mo4748i() {
        ip0 ip0Var;
        long now = this.f24851e.now(this.f24853g) - this.f24852f;
        ip0 ip0Var2 = (ip0) get();
        ip0 ip0Var3 = (ip0) ip0Var2.get();
        int i = 0;
        while (true) {
            ip0 ip0Var4 = ip0Var3;
            ip0Var = ip0Var2;
            ip0Var2 = ip0Var4;
            if (this.f16940c <= 1 || ((Timed) ip0Var2.f20168a).time() > now) {
                break;
            }
            i++;
            this.f16940c--;
            ip0Var3 = (ip0) ip0Var2.get();
        }
        if (i != 0) {
            m4746g(ip0Var);
        }
    }
}
