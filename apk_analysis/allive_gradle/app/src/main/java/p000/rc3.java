package p000;

import com.google.android.gms.internal.measurement.zzld;

/* loaded from: classes.dex */
public final class rc3 extends uc3 {

    /* renamed from: c */
    public final int f25932c;

    public rc3(byte[] bArr, int i) {
        super(bArr);
        zzld.m3462c(0, i, bArr.length);
        this.f25932c = i;
    }

    @Override // p000.uc3, com.google.android.gms.internal.measurement.zzld
    /* renamed from: a */
    public final byte mo3463a(int i) {
        return this.f27225b[i];
    }

    @Override // p000.uc3, com.google.android.gms.internal.measurement.zzld
    public final byte zza(int i) {
        int i2 = this.f25932c;
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(ye0.m8291k(i, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(ye0.m8293m(i, "Index > length: ", ", ", i2));
        }
        return this.f27225b[i];
    }

    @Override // p000.uc3, com.google.android.gms.internal.measurement.zzld
    public final int zzd() {
        return this.f25932c;
    }
}
