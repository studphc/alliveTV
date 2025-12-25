package p000;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.zaa;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class z83 extends zaa {

    /* renamed from: a */
    public final /* synthetic */ AtomicReference f29283a;

    /* renamed from: b */
    public final /* synthetic */ TaskCompletionSource f29284b;

    /* renamed from: c */
    public final /* synthetic */ InstallStatusListener f29285c;

    /* renamed from: d */
    public final /* synthetic */ zay f29286d;

    public z83(zay zayVar, AtomicReference atomicReference, TaskCompletionSource taskCompletionSource, InstallStatusListener installStatusListener) {
        this.f29286d = zayVar;
        this.f29283a = atomicReference;
        this.f29284b = taskCompletionSource;
        this.f29285c = installStatusListener;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.f29283a.set(moduleInstallResponse);
        }
        TaskUtil.trySetResultOrApiException(status, null, this.f29284b);
        if (status.isSuccess() && (moduleInstallResponse == null || !moduleInstallResponse.zaa())) {
            return;
        }
        this.f29286d.doUnregisterEventListener(ListenerHolders.createListenerKey(this.f29285c, "InstallStatusListener"), 27306);
    }
}
