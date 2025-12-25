package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: android.support.v4.app.a */
/* loaded from: classes.dex */
public final class C0025a implements INotificationSideChannel {

    /* renamed from: a */
    public IBinder f273a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f273a;
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public final void cancel(String str, int i, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            this.f273a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public final void cancelAll(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);
            obtain.writeString(str);
            this.f273a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public final void notify(String str, int i, String str2, Notification notification) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            if (notification != null) {
                obtain.writeInt(1);
                notification.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f273a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
