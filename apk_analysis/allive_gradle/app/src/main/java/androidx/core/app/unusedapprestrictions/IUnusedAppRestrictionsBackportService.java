package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import kotlin.text.Typography;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public static final String DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace(Typography.dollar, '.');

    /* loaded from: classes.dex */
    public static class Default implements IUnusedAppRestrictionsBackportService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.DESCRIPTOR);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.core.app.unusedapprestrictions.b, androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService, java.lang.Object] */
        public static IUnusedAppRestrictionsBackportService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUnusedAppRestrictionsBackportService)) {
                return (IUnusedAppRestrictionsBackportService) queryLocalInterface;
            }
            ?? obj = new Object();
            obj.f3523a = iBinder;
            return obj;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = IUnusedAppRestrictionsBackportService.DESCRIPTOR;
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
            isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.Stub.asInterface(parcel.readStrongBinder()));
            return true;
        }
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback);
}
