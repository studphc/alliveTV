package p000;

import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import androidx.core.content.UnusedAppRestrictionsBackportCallback;
import androidx.core.content.UnusedAppRestrictionsBackportService;

/* loaded from: classes.dex */
public final class s03 extends IUnusedAppRestrictionsBackportService.Stub {

    /* renamed from: a */
    public final /* synthetic */ UnusedAppRestrictionsBackportService f26202a;

    public s03(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService) {
        this.f26202a = unusedAppRestrictionsBackportService;
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
    public final void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        if (iUnusedAppRestrictionsBackportCallback == null) {
            return;
        }
        this.f26202a.isPermissionRevocationEnabled(new UnusedAppRestrictionsBackportCallback(iUnusedAppRestrictionsBackportCallback));
    }
}
