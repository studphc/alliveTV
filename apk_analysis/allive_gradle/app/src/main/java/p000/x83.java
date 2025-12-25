package p000;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class x83 extends zaa {

    /* renamed from: a */
    public final /* synthetic */ int f28476a;

    /* renamed from: b */
    public final /* synthetic */ TaskCompletionSource f28477b;

    public /* synthetic */ x83(int i, TaskCompletionSource taskCompletionSource) {
        this.f28476a = i;
        this.f28477b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public void zab(Status status) {
        switch (this.f28476a) {
            case 1:
                TaskUtil.trySetResultOrApiException(status, null, this.f28477b);
                return;
            default:
                super.zab(status);
                return;
        }
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public void zac(Status status, ModuleInstallIntentResponse moduleInstallIntentResponse) {
        switch (this.f28476a) {
            case 3:
                TaskUtil.trySetResultOrApiException(status, moduleInstallIntentResponse, this.f28477b);
                return;
            default:
                super.zac(status, moduleInstallIntentResponse);
                return;
        }
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public void zad(Status status, ModuleInstallResponse moduleInstallResponse) {
        switch (this.f28476a) {
            case 2:
                TaskUtil.trySetResultOrApiException(status, moduleInstallResponse, this.f28477b);
                return;
            default:
                super.zad(status, moduleInstallResponse);
                return;
        }
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public void zae(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        switch (this.f28476a) {
            case 0:
                TaskUtil.trySetResultOrApiException(status, moduleAvailabilityResponse, this.f28477b);
                return;
            default:
                super.zae(status, moduleAvailabilityResponse);
                return;
        }
    }
}
