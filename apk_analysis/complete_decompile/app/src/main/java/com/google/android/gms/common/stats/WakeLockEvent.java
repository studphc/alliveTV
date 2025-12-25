package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    /* renamed from: a */
    public final int f13619a;

    /* renamed from: b */
    public final long f13620b;

    /* renamed from: c */
    public final int f13621c;

    /* renamed from: d */
    public final String f13622d;

    /* renamed from: e */
    public final String f13623e;

    /* renamed from: f */
    public final String f13624f;

    /* renamed from: g */
    public final int f13625g;

    /* renamed from: h */
    public final ArrayList f13626h;

    /* renamed from: i */
    public final String f13627i;

    /* renamed from: j */
    public final long f13628j;

    /* renamed from: k */
    public final int f13629k;

    /* renamed from: l */
    public final String f13630l;

    /* renamed from: m */
    public final float f13631m;

    /* renamed from: n */
    public final long f13632n;

    /* renamed from: o */
    public final boolean f13633o;

    public WakeLockEvent(int i, long j, int i2, String str, int i3, ArrayList arrayList, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5, boolean z) {
        this.f13619a = i;
        this.f13620b = j;
        this.f13621c = i2;
        this.f13622d = str;
        this.f13623e = str3;
        this.f13624f = str5;
        this.f13625g = i3;
        this.f13626h = arrayList;
        this.f13627i = str2;
        this.f13628j = j2;
        this.f13629k = i4;
        this.f13630l = str4;
        this.f13631m = f;
        this.f13632n = j3;
        this.f13633o = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13619a);
        SafeParcelWriter.writeLong(parcel, 2, this.f13620b);
        SafeParcelWriter.writeString(parcel, 4, this.f13622d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f13625g);
        SafeParcelWriter.writeStringList(parcel, 6, this.f13626h, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f13628j);
        SafeParcelWriter.writeString(parcel, 10, this.f13623e, false);
        SafeParcelWriter.writeInt(parcel, 11, this.f13621c);
        SafeParcelWriter.writeString(parcel, 12, this.f13627i, false);
        SafeParcelWriter.writeString(parcel, 13, this.f13630l, false);
        SafeParcelWriter.writeInt(parcel, 14, this.f13629k);
        SafeParcelWriter.writeFloat(parcel, 15, this.f13631m);
        SafeParcelWriter.writeLong(parcel, 16, this.f13632n);
        SafeParcelWriter.writeString(parcel, 17, this.f13624f, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.f13633o);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.f13621c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.f13620b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String zzc() {
        String join;
        String str = "";
        ArrayList arrayList = this.f13626h;
        if (arrayList == null) {
            join = "";
        } else {
            join = TextUtils.join(",", arrayList);
        }
        StringBuilder sb = new StringBuilder("\t");
        sb.append(this.f13622d);
        sb.append("\t");
        sb.append(this.f13625g);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(this.f13629k);
        sb.append("\t");
        String str2 = this.f13623e;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("\t");
        String str3 = this.f13630l;
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append("\t");
        sb.append(this.f13631m);
        sb.append("\t");
        String str4 = this.f13624f;
        if (str4 != null) {
            str = str4;
        }
        sb.append(str);
        sb.append("\t");
        sb.append(this.f13633o);
        return sb.toString();
    }
}
