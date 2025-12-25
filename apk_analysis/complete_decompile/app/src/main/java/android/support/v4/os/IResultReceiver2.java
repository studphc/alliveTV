package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import kotlin.text.Typography;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface IResultReceiver2 extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace(Typography.dollar, '.');

    /* loaded from: classes.dex */
    public static class Default implements IResultReceiver2 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver2
        public void send(int i, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IResultReceiver2 {
        public Stub() {
            attachInterface(this, IResultReceiver2.DESCRIPTOR);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, android.support.v4.os.b, android.support.v4.os.IResultReceiver2] */
        public static IResultReceiver2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IResultReceiver2.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IResultReceiver2)) {
                return (IResultReceiver2) queryLocalInterface;
            }
            ?? obj = new Object();
            obj.f452a = iBinder;
            return obj;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Object obj;
            String str = IResultReceiver2.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            int readInt = parcel.readInt();
            Parcelable.Creator creator = Bundle.CREATOR;
            if (parcel.readInt() != 0) {
                obj = creator.createFromParcel(parcel);
            } else {
                obj = null;
            }
            send(readInt, (Bundle) obj);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class _Parcel {
    }

    void send(int i, Bundle bundle);
}
