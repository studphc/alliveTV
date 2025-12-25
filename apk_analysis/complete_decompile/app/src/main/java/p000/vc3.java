package p000;

import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzld;
import com.google.android.gms.internal.measurement.zzli;
import com.google.android.gms.internal.measurement.zzlk;
import com.google.android.gms.internal.measurement.zzmk;
import com.google.android.gms.internal.measurement.zznh;
import java.util.Locale;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class vc3 extends zzlk {

    /* renamed from: d */
    public final byte[] f27739d;

    /* renamed from: e */
    public final int f27740e;

    /* renamed from: f */
    public int f27741f;

    public vc3(byte[] bArr, int i) {
        int length = bArr.length;
        if (((length - i) | i) >= 0) {
            this.f27739d = bArr;
            this.f27741f = 0;
            this.f27740e = i;
            return;
        }
        Locale locale = Locale.US;
        throw new IllegalArgumentException(ye0.m8293m(length, "Array range is invalid. Buffer.length=", ", offset=0, length=", i));
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    /* renamed from: a */
    public final void mo3467a(int i, zznh zznhVar, xd3 xd3Var) {
        zzt((i << 3) | 2);
        zzt(((zzko) zznhVar).mo3461a(xd3Var));
        xd3Var.mo3235b(zznhVar, this.f13879a);
    }

    /* renamed from: d */
    public final void m7908d(int i, byte[] bArr) {
        try {
            System.arraycopy(bArr, 0, this.f27739d, this.f27741f, i);
            this.f27741f += i;
        } catch (IndexOutOfBoundsException e) {
            throw new zzli(this.f27741f, this.f27740e, i, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final int zza() {
        return this.f27740e - this.f27741f;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzb(byte b) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i = this.f27741f;
        try {
            int i2 = i + 1;
            try {
                this.f27739d[i] = b;
                this.f27741f = i2;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                i = i2;
                throw new zzli(i, this.f27740e, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e2) {
            indexOutOfBoundsException = e2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzd(int i, boolean z) {
        zzt(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zze(int i, zzld zzldVar) {
        zzt((i << 3) | 2);
        zzt(zzldVar.zzd());
        zzldVar.mo3464b(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzf(int i, int i2) {
        zzt((i << 3) | 5);
        zzg(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzg(int i) {
        int i2 = this.f27741f;
        try {
            byte[] bArr = this.f27739d;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.f27741f = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzli(i2, this.f27740e, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzh(int i, long j) {
        zzt((i << 3) | 1);
        zzi(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzi(long j) {
        int i = this.f27741f;
        try {
            byte[] bArr = this.f27739d;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.f27741f = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzli(i, this.f27740e, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzj(int i, int i2) {
        zzt(i << 3);
        zzk(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzk(int i) {
        if (i >= 0) {
            zzt(i);
        } else {
            zzv(i);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzl(byte[] bArr, int i, int i2) {
        m7908d(i2, bArr);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzn(int i, zznh zznhVar) {
        zzt(11);
        zzs(2, i);
        zzt(26);
        zzt(zznhVar.zzcf());
        zznhVar.zzcB(this);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzo(int i, zzld zzldVar) {
        zzt(11);
        zzs(2, i);
        zze(3, zzldVar);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzp(int i, String str) {
        zzt((i << 3) | 2);
        int i2 = this.f27741f;
        try {
            int zzz = zzlk.zzz(str.length() * 3);
            int zzz2 = zzlk.zzz(str.length());
            int i3 = this.f27740e;
            byte[] bArr = this.f27739d;
            if (zzz2 == zzz) {
                int i4 = i2 + zzz2;
                this.f27741f = i4;
                int m5524b = ke3.m5524b(str, bArr, i4, i3 - i4);
                this.f27741f = i2;
                zzt((m5524b - i2) - zzz2);
                this.f27741f = m5524b;
            } else {
                zzt(ke3.m5525c(str));
                int i5 = this.f27741f;
                this.f27741f = ke3.m5524b(str, bArr, i5, i3 - i5);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new zzli(e);
        } catch (je3 e2) {
            this.f27741f = i2;
            zzlk.f13877b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
            byte[] bytes = str.getBytes(zzmk.f13887a);
            try {
                int length = bytes.length;
                zzt(length);
                m7908d(length, bytes);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzli(e3);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzr(int i, int i2) {
        zzt((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzs(int i, int i2) {
        zzt(i << 3);
        zzt(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzt(int i) {
        int i2;
        int i3 = this.f27741f;
        while (true) {
            int i4 = i & (-128);
            byte[] bArr = this.f27739d;
            if (i4 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) i;
                this.f27741f = i2;
                return;
            } else {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzli(i2, this.f27740e, 1, e);
                }
            }
            throw new zzli(i2, this.f27740e, 1, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzu(int i, long j) {
        zzt(i << 3);
        zzv(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final void zzv(long j) {
        int i;
        int i2 = this.f27741f;
        boolean z = zzlk.f13878c;
        int i3 = this.f27740e;
        byte[] bArr = this.f27739d;
        if (z && i3 - i2 >= 10) {
            long j2 = j;
            while ((j2 & (-128)) != 0) {
                ie3.f18388c.mo4696m(bArr, ie3.f18391f + i2, (byte) (((int) j2) | 128));
                j2 >>>= 7;
                i2++;
            }
            i = i2 + 1;
            ie3.f18388c.mo4696m(bArr, ie3.f18391f + i2, (byte) j2);
        } else {
            long j3 = j;
            while ((j3 & (-128)) != 0) {
                i = i2 + 1;
                try {
                    bArr[i2] = (byte) (((int) j3) | 128);
                    j3 >>>= 7;
                    i2 = i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzli(i, i3, 1, e);
                }
            }
            i = i2 + 1;
            bArr[i2] = (byte) j3;
        }
        this.f27741f = i;
    }
}
