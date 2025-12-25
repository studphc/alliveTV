package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import p000.AbstractC1726qj;
import p000.nc3;
import p000.o63;
import p000.qc3;
import p000.uc3;
import p000.vc3;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class zzld implements Iterable, Serializable {
    public static final zzld zzb = new uc3(zzmk.zzb);

    /* renamed from: a */
    public int f13876a;

    static {
        int i = nc3.f23326a;
    }

    /* renamed from: c */
    public static int m3462c(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i >= 0) {
                if (i2 < i) {
                    throw new IndexOutOfBoundsException(ye0.m8293m(i, "Beginning index larger than ending index: ", ", ", i2));
                }
                throw new IndexOutOfBoundsException(ye0.m8293m(i2, "End index: ", " >= ", i3));
            }
            throw new IndexOutOfBoundsException(ye0.m8292l(i, "Beginning index: ", " < 0"));
        }
        return i4;
    }

    public static zzld zzj(byte[] bArr, int i, int i2) {
        m3462c(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new uc3(bArr2);
    }

    /* renamed from: a */
    public abstract byte mo3463a(int i);

    /* renamed from: b */
    public abstract void mo3464b(vc3 vc3Var);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f13876a;
        if (i == 0) {
            int zzd = zzd();
            i = zze(zzd, 0, zzd);
            if (i == 0) {
                i = 1;
            }
            this.f13876a = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new qc3(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzd = zzd();
        if (zzd() <= 50) {
            concat = o63.m6461X(this);
        } else {
            concat = o63.m6461X(zzf(0, 47)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(zzd);
        sb.append(" contents=\"");
        return AbstractC1726qj.m7061q(sb, concat, "\">");
    }

    public abstract byte zza(int i);

    public abstract int zzd();

    public abstract int zze(int i, int i2, int i3);

    public abstract zzld zzf(int i, int i2);

    public final int zzi() {
        return this.f13876a;
    }
}
