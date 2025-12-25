package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ay1 extends rx1 {
    private static final long serialVersionUID = 3457957419649567404L;

    /* renamed from: d */
    public final Scheduler f7794d;

    /* renamed from: e */
    public final long f7795e;

    /* renamed from: f */
    public final TimeUnit f7796f;

    /* renamed from: g */
    public final int f7797g;

    public ay1(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(z);
        this.f7794d = scheduler;
        this.f7797g = i;
        this.f7795e = j;
        this.f7796f = timeUnit;
    }

    @Override // p000.rx1
    /* renamed from: d */
    public final Object mo1976d(Object obj) {
        Scheduler scheduler = this.f7794d;
        TimeUnit timeUnit = this.f7796f;
        return new Timed(obj, scheduler.now(timeUnit), timeUnit);
    }

    @Override // p000.rx1
    /* renamed from: e */
    public final vx1 mo1977e() {
        vx1 vx1Var;
        long now = this.f7794d.now(this.f7796f) - this.f7795e;
        vx1 vx1Var2 = (vx1) get();
        Object obj = vx1Var2.get();
        while (true) {
            vx1 vx1Var3 = (vx1) obj;
            vx1Var = vx1Var2;
            vx1Var2 = vx1Var3;
            if (vx1Var2 != null) {
                Timed timed = (Timed) vx1Var2.f27987a;
                if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                    break;
                }
                obj = vx1Var2.get();
            } else {
                break;
            }
        }
        return vx1Var;
    }

    @Override // p000.rx1
    /* renamed from: f */
    public final Object mo1978f(Object obj) {
        return ((Timed) obj).value();
    }

    @Override // p000.rx1
    /* renamed from: h */
    public final void mo1979h() {
        vx1 vx1Var;
        long now = this.f7794d.now(this.f7796f) - this.f7795e;
        vx1 vx1Var2 = (vx1) get();
        vx1 vx1Var3 = (vx1) vx1Var2.get();
        int i = 0;
        while (true) {
            vx1 vx1Var4 = vx1Var3;
            vx1Var = vx1Var2;
            vx1Var2 = vx1Var4;
            int i2 = this.f26176b;
            if (i2 > 1) {
                if (i2 > this.f7797g) {
                    i++;
                    this.f26176b = i2 - 1;
                    vx1Var3 = (vx1) vx1Var2.get();
                } else {
                    if (((Timed) vx1Var2.f27987a).time() > now) {
                        break;
                    }
                    i++;
                    this.f26176b--;
                    vx1Var3 = (vx1) vx1Var2.get();
                }
            } else {
                break;
            }
        }
        if (i != 0) {
            m7308g(vx1Var);
        }
    }

    @Override // p000.rx1
    /* renamed from: i */
    public final void mo1980i() {
        vx1 vx1Var;
        long now = this.f7794d.now(this.f7796f) - this.f7795e;
        vx1 vx1Var2 = (vx1) get();
        vx1 vx1Var3 = (vx1) vx1Var2.get();
        int i = 0;
        while (true) {
            vx1 vx1Var4 = vx1Var3;
            vx1Var = vx1Var2;
            vx1Var2 = vx1Var4;
            if (this.f26176b <= 1 || ((Timed) vx1Var2.f27987a).time() > now) {
                break;
            }
            i++;
            this.f26176b--;
            vx1Var3 = (vx1) vx1Var2.get();
        }
        if (i != 0) {
            m7308g(vx1Var);
        }
    }
}
