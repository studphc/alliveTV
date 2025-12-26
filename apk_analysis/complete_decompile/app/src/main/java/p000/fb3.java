package p000;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.measurement.internal.zzkc;

/* loaded from: classes.dex */
public final class fb3 extends zzdd {

    /* renamed from: a */
    public final zzkc f17202a;

    public fb3(zzkc zzkcVar) {
        this.f17202a = zzkcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final int zze() {
        return System.identityHashCode(this.f17202a);
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final void zzf(String str, String str2, Bundle bundle, long j) {
        this.f17202a.onEvent(str, str2, bundle, j);
    }
}
