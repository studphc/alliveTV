package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class zza implements IInterface {

    /* renamed from: a */
    public final IBinder f13715a;

    public zza(IBinder iBinder, String str) {
        this.f13715a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13715a;
    }

    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return obtain;
    }

    public final Parcel zzb(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f13715a.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
