package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: android.support.v4.os.a */
/* loaded from: classes.dex */
public final class C0066a implements IResultReceiver {

    /* renamed from: a */
    public IBinder f451a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f451a;
    }

    @Override // android.support.v4.os.IResultReceiver
    public final void send(int i, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IResultReceiver.DESCRIPTOR);
            obtain.writeInt(i);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f451a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
