package p000;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.measurement.internal.zzkb;

/* loaded from: classes.dex */
public final class eb3 extends zzdd {

    /* renamed from: a */
    public final zzkb f16755a;

    public eb3(zzkb zzkbVar) {
        this.f16755a = zzkbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final int zze() {
        return System.identityHashCode(this.f16755a);
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final void zzf(String str, String str2, Bundle bundle, long j) {
        this.f16755a.interceptEvent(str, str2, bundle, j);
    }
}
