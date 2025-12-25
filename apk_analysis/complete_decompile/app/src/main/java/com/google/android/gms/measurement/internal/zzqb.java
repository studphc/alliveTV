package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import p000.ye3;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
/* loaded from: classes.dex */
public final class zzqb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqb> CREATOR = new zzqc();

    @SafeParcelable.Field(m3159id = 1)
    public final int zza;

    @SafeParcelable.Field(m3159id = 2)
    public final String zzb;

    @SafeParcelable.Field(m3159id = 3)
    public final long zzc;

    @Nullable
    @SafeParcelable.Field(m3159id = 4)
    public final Long zzd;

    @Nullable
    @SafeParcelable.Field(m3159id = 6)
    public final String zze;

    @SafeParcelable.Field(m3159id = 7)
    public final String zzf;

    @Nullable
    @SafeParcelable.Field(m3159id = 8)
    public final Double zzg;

    public zzqb(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.zza = i;
        this.zzb = str;
        this.zzc = j;
        this.zzd = l;
        this.zzg = i == 1 ? f != null ? Double.valueOf(f.doubleValue()) : null : d;
        this.zze = str2;
        this.zzf = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzqc.m3697a(this, parcel);
    }

    @Nullable
    public final Object zza() {
        Long l = this.zzd;
        if (l != null) {
            return l;
        }
        Double d = this.zzg;
        if (d != null) {
            return d;
        }
        String str = this.zze;
        if (str != null) {
            return str;
        }
        return null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzqb(ye3 ye3Var) {
        this(ye3Var.f28931d, ye3Var.f28932e, r4, ye3Var.f28929b);
        String str = ye3Var.f28930c;
    }

    public zzqb(long j, Object obj, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        this.zza = 2;
        this.zzb = str;
        this.zzc = j;
        this.zzf = str2;
        if (obj == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzd = (Long) obj;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof String) {
            this.zzd = null;
            this.zzg = null;
            this.zze = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.zzd = null;
                this.zzg = (Double) obj;
                this.zze = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
