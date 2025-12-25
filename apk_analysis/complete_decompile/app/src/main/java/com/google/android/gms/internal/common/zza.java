package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class zza implements IInterface {

    /* renamed from: a */
    public final IBinder f13737a;

    /* renamed from: b */
    public final String f13738b;

    public zza(IBinder iBinder, String str) {
        this.f13737a = iBinder;
        this.f13738b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13737a;
    }

    public final Parcel zzB(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f13737a.transact(i, parcel, obtain, 0);
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

    public final void zzC(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f13737a.transact(1, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zzD(int i, Parcel parcel) {
        try {
            this.f13737a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f13738b);
        return obtain;
    }
}
