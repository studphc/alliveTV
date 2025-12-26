package p000;

import com.google.android.gms.internal.measurement.zzld;
import com.google.android.gms.internal.measurement.zzmk;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class uc3 extends zzld {

    /* renamed from: b */
    public final byte[] f27225b;

    public uc3(byte[] bArr) {
        this.f13876a = 0;
        bArr.getClass();
        this.f27225b = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    /* renamed from: a */
    public byte mo3463a(int i) {
        return this.f27225b[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    /* renamed from: b */
    public final void mo3464b(vc3 vc3Var) {
        vc3Var.m7908d(zzd(), this.f27225b);
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzld) || zzd() != ((zzld) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof uc3) {
            uc3 uc3Var = (uc3) obj;
            int zzi = zzi();
            int zzi2 = uc3Var.zzi();
            if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= uc3Var.zzd()) {
                if (zzd <= uc3Var.zzd()) {
                    int i = 0;
                    int i2 = 0;
                    while (i < zzd) {
                        if (this.f27225b[i] != uc3Var.f27225b[i2]) {
                            return false;
                        }
                        i++;
                        i2++;
                    }
                    return true;
                }
                throw new IllegalArgumentException(ye0.m8293m(zzd, "Ran off end of other: 0, ", ", ", uc3Var.zzd()));
            }
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public byte zza(int i) {
        return this.f27225b[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public int zzd() {
        return this.f27225b.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final int zze(int i, int i2, int i3) {
        Charset charset = zzmk.f13887a;
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + this.f27225b[i4];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final zzld zzf(int i, int i2) {
        int m3462c = zzld.m3462c(0, i2, zzd());
        if (m3462c == 0) {
            return zzld.zzb;
        }
        return new rc3(this.f27225b, m3462c);
    }
}
