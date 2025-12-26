package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 13, 17, 20, 33})
/* loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    @SafeParcelable.Field(defaultValue = "", m3159id = 31)
    public final String zzA;

    @SafeParcelable.Field(m3159id = 32)
    public final int zzB;

    @SafeParcelable.Field(m3159id = 34)
    public final long zzC;

    @Nullable
    @SafeParcelable.Field(m3159id = 35)
    public final String zzD;

    @SafeParcelable.Field(defaultValue = "", m3159id = 36)
    public final String zzE;

    @SafeParcelable.Field(m3159id = 37)
    public final long zzF;

    @SafeParcelable.Field(m3159id = 38)
    public final int zzG;

    @Nullable
    @SafeParcelable.Field(m3159id = 2)
    public final String zza;

    @Nullable
    @SafeParcelable.Field(m3159id = 3)
    public final String zzb;

    @Nullable
    @SafeParcelable.Field(m3159id = 4)
    public final String zzc;

    @Nullable
    @SafeParcelable.Field(m3159id = 5)
    public final String zzd;

    @SafeParcelable.Field(m3159id = 6)
    public final long zze;

    @SafeParcelable.Field(m3159id = 7)
    public final long zzf;

    @Nullable
    @SafeParcelable.Field(m3159id = 8)
    public final String zzg;

    @SafeParcelable.Field(defaultValue = "true", m3159id = 9)
    public final boolean zzh;

    @SafeParcelable.Field(m3159id = 10)
    public final boolean zzi;

    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", m3159id = 11)
    public final long zzj;

    @Nullable
    @SafeParcelable.Field(m3159id = 12)
    public final String zzk;

    @SafeParcelable.Field(m3159id = 14)
    public final long zzl;

    @SafeParcelable.Field(m3159id = 15)
    public final int zzm;

    @SafeParcelable.Field(defaultValue = "true", m3159id = 16)
    public final boolean zzn;

    @SafeParcelable.Field(m3159id = 18)
    public final boolean zzo;

    @Nullable
    @SafeParcelable.Field(m3159id = 19)
    public final String zzp;

    @Nullable
    @SafeParcelable.Field(m3159id = 21)
    public final Boolean zzq;

    @SafeParcelable.Field(m3159id = 22)
    public final long zzr;

    @Nullable
    @SafeParcelable.Field(m3159id = 23)
    public final List zzs;

    @Nullable
    @SafeParcelable.Field(m3159id = 24)
    public final String zzt;

    @SafeParcelable.Field(defaultValue = "", m3159id = 25)
    public final String zzu;

    @SafeParcelable.Field(defaultValue = "", m3159id = 26)
    public final String zzv;

    @Nullable
    @SafeParcelable.Field(m3159id = 27)
    public final String zzw;

    @SafeParcelable.Field(defaultValue = "false", m3159id = 28)
    public final boolean zzx;

    @SafeParcelable.Field(m3159id = 29)
    public final long zzy;

    @SafeParcelable.Field(defaultValue = "100", m3159id = 30)
    public final int zzz;

    public zzr(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, int i, boolean z3, boolean z4, String str7, Boolean bool, long j5, List list, String str8, String str9, String str10, String str11, boolean z5, long j6, int i2, String str12, int i3, long j7, String str13, String str14, long j8, int i4) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = true == TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = i;
        this.zzn = z3;
        this.zzo = z4;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j5;
        this.zzs = list;
        this.zzt = str8;
        this.zzu = str9;
        this.zzv = str10;
        this.zzw = str11;
        this.zzx = z5;
        this.zzy = j6;
        this.zzz = i2;
        this.zzA = str12;
        this.zzB = i3;
        this.zzC = j7;
        this.zzD = str13;
        this.zzE = str14;
        this.zzF = j8;
        this.zzG = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzl);
        SafeParcelWriter.writeInt(parcel, 15, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.writeString(parcel, 19, this.zzp, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzr);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzw, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzx);
        SafeParcelWriter.writeLong(parcel, 29, this.zzy);
        SafeParcelWriter.writeInt(parcel, 30, this.zzz);
        SafeParcelWriter.writeString(parcel, 31, this.zzA, false);
        SafeParcelWriter.writeInt(parcel, 32, this.zzB);
        SafeParcelWriter.writeLong(parcel, 34, this.zzC);
        SafeParcelWriter.writeString(parcel, 35, this.zzD, false);
        SafeParcelWriter.writeString(parcel, 36, this.zzE, false);
        SafeParcelWriter.writeLong(parcel, 37, this.zzF);
        SafeParcelWriter.writeInt(parcel, 38, this.zzG);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzr(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, int i, boolean z3, boolean z4, String str7, Boolean bool, long j5, ArrayList arrayList, String str8, String str9, String str10, String str11, boolean z5, long j6, int i2, String str12, int i3, long j7, String str13, String str14, long j8, int i4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = i;
        this.zzn = z3;
        this.zzo = z4;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j5;
        this.zzs = arrayList;
        this.zzt = str8;
        this.zzu = str9;
        this.zzv = str10;
        this.zzw = str11;
        this.zzx = z5;
        this.zzy = j6;
        this.zzz = i2;
        this.zzA = str12;
        this.zzB = i3;
        this.zzC = j7;
        this.zzD = str13;
        this.zzE = str14;
        this.zzF = j8;
        this.zzG = i4;
    }
}
