package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import p000.bc3;
import p000.kc3;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
/* loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* renamed from: a */
    public final String f13688a;

    /* renamed from: b */
    public final bc3 f13689b;

    /* renamed from: c */
    public final boolean f13690c;

    /* renamed from: d */
    public final boolean f13691d;

    public zzs(String str, bc3 bc3Var, boolean z, boolean z2) {
        this.f13688a = str;
        this.f13689b = bc3Var;
        this.f13690c = z;
        this.f13691d = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f13688a, false);
        bc3 bc3Var = this.f13689b;
        if (bc3Var == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            bc3Var = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, bc3Var, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f13690c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f13691d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzs(String str, IBinder iBinder, boolean z, boolean z2) {
        this.f13688a = str;
        kc3 kc3Var = null;
        if (iBinder != null) {
            try {
                IObjectWrapper zzd = com.google.android.gms.common.internal.zzz.zzg(iBinder).zzd();
                byte[] bArr = zzd == null ? null : (byte[]) ObjectWrapper.unwrap(zzd);
                if (bArr != null) {
                    kc3Var = new kc3(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.f13689b = kc3Var;
        this.f13690c = z;
        this.f13691d = z2;
    }
}
