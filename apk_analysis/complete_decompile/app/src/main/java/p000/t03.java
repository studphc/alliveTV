package p000;

import android.util.Log;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.content.PackageManagerCompat;

/* loaded from: classes.dex */
public final class t03 extends IUnusedAppRestrictionsBackportCallback.Stub {

    /* renamed from: a */
    public final /* synthetic */ u03 f26654a;

    public t03(u03 u03Var) {
        this.f26654a = u03Var;
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public final void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) {
        u03 u03Var = this.f26654a;
        if (z) {
            if (z2) {
                u03Var.f27060b.set(3);
                return;
            } else {
                u03Var.f27060b.set(2);
                return;
            }
        }
        u03Var.f27060b.set(0);
        Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
    }
}
