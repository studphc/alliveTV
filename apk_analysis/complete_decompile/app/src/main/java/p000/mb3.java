package p000;

import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzio;

/* loaded from: classes.dex */
public abstract class mb3 extends hb3 {

    /* renamed from: a */
    public boolean f22888a;

    public mb3(zzio zzioVar) {
        super(zzioVar);
        this.zzu.f14250D++;
    }

    public final void zza() {
        if (this.f22888a) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzb() {
        if (!this.f22888a) {
            if (!zzf()) {
                this.zzu.f14252F.incrementAndGet();
                this.f22888a = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void zzc() {
        if (!this.f22888a) {
            zzd();
            this.zzu.f14252F.incrementAndGet();
            this.f22888a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzf();

    @WorkerThread
    public void zzd() {
    }
}
