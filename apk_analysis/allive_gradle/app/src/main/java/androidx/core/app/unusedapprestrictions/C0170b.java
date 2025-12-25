package androidx.core.app.unusedapprestrictions;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: androidx.core.app.unusedapprestrictions.b */
/* loaded from: classes.dex */
public final class C0170b implements IUnusedAppRestrictionsBackportService {

    /* renamed from: a */
    public IBinder f3523a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3523a;
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
    public final void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
            obtain.writeStrongInterface(iUnusedAppRestrictionsBackportCallback);
            this.f3523a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
