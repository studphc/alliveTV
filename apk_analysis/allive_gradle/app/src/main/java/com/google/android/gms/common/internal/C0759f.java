package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.f */
/* loaded from: classes.dex */
public final class C0759f implements IGmsServiceBroker {

    /* renamed from: a */
    public final IBinder f13482a;

    public C0759f(IBinder iBinder) {
        this.f13482a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13482a;
    }

    @Override // com.google.android.gms.common.internal.IGmsServiceBroker
    public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (iGmsCallbacks != null) {
                iBinder = iGmsCallbacks.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                zzn.m3167a(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f13482a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
