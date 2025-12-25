package p000;

import com.google.android.gms.measurement.internal.zzd;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class pq0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f25259a;

    /* renamed from: b */
    public final long f25260b;

    /* renamed from: c */
    public final Object f25261c;

    public /* synthetic */ pq0(Object obj, long j, int i) {
        this.f25259a = i;
        this.f25261c = obj;
        this.f25260b = j;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Number, qr0] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, uz1] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f25259a) {
            case 0:
                ((Subscription) this.f25261c).request(this.f25260b);
                return;
            case 1:
                ((Number) this.f25261c).mo5780a(this.f25260b);
                return;
            case 2:
                this.f25261c.mo6936a(this.f25260b);
                return;
            default:
                ((zzd) this.f25261c).m3523c(this.f25260b);
                return;
        }
    }

    public pq0(long j, uz1 uz1Var) {
        this.f25259a = 2;
        this.f25260b = j;
        this.f25261c = uz1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public pq0(long j, qr0 qr0Var) {
        this.f25259a = 1;
        this.f25260b = j;
        this.f25261c = (Number) qr0Var;
    }
}
