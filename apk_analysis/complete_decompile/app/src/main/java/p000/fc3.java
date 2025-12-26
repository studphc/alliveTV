package p000;

import com.google.android.gms.measurement.internal.AbstractC0811m;
import com.google.android.gms.measurement.internal.zzio;

/* loaded from: classes.dex */
public abstract class fc3 extends AbstractC0811m {

    /* renamed from: a */
    public boolean f17212a;

    public fc3(zzio zzioVar) {
        super(zzioVar);
        this.zzu.f14250D++;
    }

    public abstract boolean zzc();

    public final void zzv() {
        if (this.f17212a) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzw() {
        if (!this.f17212a) {
            if (!zzc()) {
                this.zzu.f14252F.incrementAndGet();
                this.f17212a = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void zzx() {
        if (!this.f17212a) {
            zzaZ();
            this.zzu.f14252F.incrementAndGet();
            this.f17212a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public void zzaZ() {
    }
}
