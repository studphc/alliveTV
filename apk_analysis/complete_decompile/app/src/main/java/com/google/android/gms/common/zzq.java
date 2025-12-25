package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import p000.yy2;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    /* renamed from: a */
    public final boolean f13684a;

    /* renamed from: b */
    public final String f13685b;

    /* renamed from: c */
    public final int f13686c;

    /* renamed from: d */
    public final int f13687d;

    public zzq(String str, int i, int i2, boolean z) {
        this.f13684a = z;
        this.f13685b = str;
        this.f13686c = yy2.m8347V(i) - 1;
        int i3 = 1;
        int[] iArr = {1, 2, 3};
        int i4 = 0;
        while (true) {
            if (i4 >= 3) {
                break;
            }
            int i5 = iArr[i4];
            int i6 = i5 - 1;
            if (i5 != 0) {
                if (i6 == i2) {
                    i3 = i5;
                    break;
                }
                i4++;
            } else {
                throw null;
            }
        }
        this.f13687d = i3 - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f13684a);
        SafeParcelWriter.writeString(parcel, 2, this.f13685b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f13686c);
        SafeParcelWriter.writeInt(parcel, 4, this.f13687d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.f13685b;
    }

    public final boolean zzb() {
        return this.f13684a;
    }

    public final int zzc() {
        int[] iArr = {1, 2, 3};
        for (int i = 0; i < 3; i++) {
            int i2 = iArr[i];
            int i3 = i2 - 1;
            if (i2 != 0) {
                if (i3 == this.f13687d) {
                    return i2;
                }
            } else {
                throw null;
            }
        }
        return 1;
    }

    public final int zzd() {
        return yy2.m8347V(this.f13686c);
    }
}
