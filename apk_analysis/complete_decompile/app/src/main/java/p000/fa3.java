package p000;

import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcc;

/* loaded from: classes.dex */
public final class fa3 extends zzcb {

    /* renamed from: a */
    public String f17191a;

    /* renamed from: b */
    public byte f17192b;

    /* renamed from: c */
    public int f17193c;

    /* renamed from: d */
    public int f17194d;

    @Override // com.google.android.gms.internal.measurement.zzcb
    public final zzcb zzb(boolean z) {
        this.f17192b = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcb
    public final zzcc zzc() {
        if (this.f17192b == 1 && this.f17191a != null && this.f17193c != 0 && this.f17194d != 0) {
            return new ga3(this.f17191a, this.f17193c, this.f17194d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f17191a == null) {
            sb.append(" fileOwner");
        }
        if (this.f17192b == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.f17193c == 0) {
            sb.append(" fileChecks");
        }
        if (this.f17194d == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcb
    public final zzcb zze(int i) {
        this.f17194d = 1;
        return this;
    }
}
