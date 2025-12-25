package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
public class UnusedAppRestrictionsBackportCallback {

    /* renamed from: a */
    public final IUnusedAppRestrictionsBackportCallback f3567a;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public UnusedAppRestrictionsBackportCallback(@NonNull IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        this.f3567a = iUnusedAppRestrictionsBackportCallback;
    }

    public void onResult(boolean z, boolean z2) {
        this.f3567a.onIsPermissionRevocationEnabledForAppResult(z, z2);
    }
}
