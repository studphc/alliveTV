package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class zaa implements IInterface {

    /* renamed from: a */
    public final IBinder f13716a;

    /* renamed from: b */
    public final String f13717b;

    public zaa(IBinder iBinder, String str) {
        this.f13716a = iBinder;
        this.f13717b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13716a;
    }

    public final Parcel zaa() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f13717b);
        return obtain;
    }

    public final Parcel zab(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f13716a.transact(2, parcel, obtain, 0);
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

    public final void zac(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f13716a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zad(int i, Parcel parcel) {
        try {
            this.f13716a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
