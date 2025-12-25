package p000;

import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzcc;

/* loaded from: classes.dex */
public final class ga3 extends zzcc {

    /* renamed from: b */
    public final String f17624b;

    /* renamed from: c */
    public final int f17625c;

    /* renamed from: d */
    public final int f17626d;

    public /* synthetic */ ga3(String str, int i, int i2) {
        this.f17624b = str;
        this.f17625c = i;
        this.f17626d = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcc) {
            zzcc zzccVar = (zzcc) obj;
            if (this.f17624b.equals(zzccVar.zzc())) {
                zzccVar.zzd();
                int zze = zzccVar.zze();
                int i = this.f17625c;
                if (i != 0) {
                    if (i == zze) {
                        zzccVar.zza();
                        zzccVar.zzb();
                        int zzf = zzccVar.zzf();
                        if (this.f17626d != 0) {
                            if (zzf == 1) {
                                return true;
                            }
                        } else {
                            throw null;
                        }
                    }
                } else {
                    throw null;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f17624b.hashCode() ^ 1000003;
        int i = this.f17625c;
        if (i != 0) {
            int i2 = (((hashCode * 1000003) ^ 1237) * 1000003) ^ i;
            if (this.f17626d != 0) {
                return (i2 * 583896283) ^ 1;
            }
            throw null;
        }
        throw null;
    }

    public final String toString() {
        String str;
        String str2 = "null";
        int i = this.f17625c;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str = "null";
                    } else {
                        str = "NO_CHECKS";
                    }
                } else {
                    str = "SKIP_SECURITY_CHECK";
                }
            } else {
                str = "SKIP_COMPLIANCE_CHECK";
            }
        } else {
            str = "ALL_CHECKS";
        }
        if (this.f17626d == 1) {
            str2 = "READ_AND_WRITE";
        }
        StringBuilder sb = new StringBuilder("FileComplianceOptions{fileOwner=");
        sb.append(this.f17624b);
        sb.append(", hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str);
        sb.append(", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=");
        return AbstractC1726qj.m7061q(sb, str2, "}");
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final zzbs zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final zzbt zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final String zzc() {
        return this.f17624b;
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final int zze() {
        return this.f17625c;
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final int zzf() {
        return this.f17626d;
    }
}
