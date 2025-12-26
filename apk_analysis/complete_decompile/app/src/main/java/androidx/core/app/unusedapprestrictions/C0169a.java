package androidx.core.app.unusedapprestrictions;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: androidx.core.app.unusedapprestrictions.a */
/* loaded from: classes.dex */
public final class C0169a implements IUnusedAppRestrictionsBackportCallback {

    /* renamed from: a */
    public IBinder f3522a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3522a;
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public final void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeInt(z2 ? 1 : 0);
            this.f3522a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
