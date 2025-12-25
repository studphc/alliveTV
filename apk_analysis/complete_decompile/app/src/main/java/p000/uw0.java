package p000;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes2.dex */
public final class uw0 implements sn2 {

    /* renamed from: a */
    public final TaskCompletionSource f27501a;

    public uw0(TaskCompletionSource taskCompletionSource) {
        this.f27501a = taskCompletionSource;
    }

    @Override // p000.sn2
    /* renamed from: a */
    public final boolean mo4390a(Exception exc) {
        return false;
    }

    @Override // p000.sn2
    /* renamed from: b */
    public final boolean mo4391b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.f27501a.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }
}
