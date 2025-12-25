package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class zzbm implements IInterface {

    /* renamed from: a */
    public final IBinder f13792a;

    /* renamed from: b */
    public final String f13793b;

    public zzbm(IBinder iBinder, String str) {
        this.f13792a = iBinder;
        this.f13793b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13792a;
    }

    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f13793b);
        return obtain;
    }

    public final Parcel zzb(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f13792a.transact(i, parcel, obtain, 0);
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

    public final void zzc(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f13792a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zzd(int i, Parcel parcel) {
        try {
            this.f13792a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
