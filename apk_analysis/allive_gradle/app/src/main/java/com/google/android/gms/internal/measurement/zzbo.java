package com.google.android.gms.internal.measurement;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzbo {

    /* renamed from: a */
    public static final ClassLoader f13794a = zzbo.class.getClassLoader();
    public static final /* synthetic */ int zza = 0;

    public static Parcelable zza(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static HashMap zzb(Parcel parcel) {
        return parcel.readHashMap(f13794a);
    }

    public static void zzc(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
        } else {
            throw new BadParcelableException(ye0.m8291k(dataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void zze(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static boolean zzf(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }
}
