package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: android.support.v4.os.b */
/* loaded from: classes.dex */
public final class C0067b implements IResultReceiver2 {

    /* renamed from: a */
    public IBinder f452a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f452a;
    }

    @Override // android.support.v4.os.IResultReceiver2
    public final void send(int i, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IResultReceiver2.DESCRIPTOR);
            obtain.writeInt(i);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f452a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
