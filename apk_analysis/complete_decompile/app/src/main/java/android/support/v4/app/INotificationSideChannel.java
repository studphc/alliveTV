package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import kotlin.text.Typography;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$app$INotificationSideChannel".replace(Typography.dollar, '.');

    /* loaded from: classes.dex */
    public static class Default implements INotificationSideChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int i, String str2) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int i, String str2, Notification notification) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements INotificationSideChannel {
        public Stub() {
            attachInterface(this, INotificationSideChannel.DESCRIPTOR);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v4.app.INotificationSideChannel, android.support.v4.app.a, java.lang.Object] */
        public static INotificationSideChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INotificationSideChannel.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INotificationSideChannel)) {
                return (INotificationSideChannel) queryLocalInterface;
            }
            ?? obj = new Object();
            obj.f273a = iBinder;
            return obj;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Object obj;
            String str = INotificationSideChannel.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    cancelAll(parcel.readString());
                } else {
                    cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                }
            } else {
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                String readString2 = parcel.readString();
                Parcelable.Creator creator = Notification.CREATOR;
                if (parcel.readInt() != 0) {
                    obj = creator.createFromParcel(parcel);
                } else {
                    obj = null;
                }
                notify(readString, readInt, readString2, (Notification) obj);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class _Parcel {
    }

    void cancel(String str, int i, String str2);

    void cancelAll(String str);

    void notify(String str, int i, String str2, Notification notification);
}
