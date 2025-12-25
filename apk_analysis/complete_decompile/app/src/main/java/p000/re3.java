package p000;

import com.google.android.gms.measurement.internal.AbstractC0818p0;
import com.google.android.gms.measurement.internal.zzpv;

/* loaded from: classes.dex */
public abstract class re3 extends AbstractC0818p0 {

    /* renamed from: a */
    public boolean f25950a;

    public re3(zzpv zzpvVar) {
        super(zzpvVar);
        this.zzg.f14386r++;
    }

    public final void zzav() {
        if (this.f25950a) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaw() {
        if (!this.f25950a) {
            zzb();
            this.zzg.f14387s++;
            this.f25950a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzb();
}
