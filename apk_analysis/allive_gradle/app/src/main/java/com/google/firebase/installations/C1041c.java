package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import p000.sn2;

/* renamed from: com.google.firebase.installations.c */
/* loaded from: classes2.dex */
public final class C1041c implements sn2 {

    /* renamed from: a */
    public final Utils f15593a;

    /* renamed from: b */
    public final TaskCompletionSource f15594b;

    public C1041c(Utils utils, TaskCompletionSource taskCompletionSource) {
        this.f15593a = utils;
        this.f15594b = taskCompletionSource;
    }

    @Override // p000.sn2
    /* renamed from: a */
    public final boolean mo4390a(Exception exc) {
        this.f15594b.trySetException(exc);
        return true;
    }

    @Override // p000.sn2
    /* renamed from: b */
    public final boolean mo4391b(PersistedInstallationEntry persistedInstallationEntry) {
        if (persistedInstallationEntry.isRegistered() && !this.f15593a.isAuthTokenExpired(persistedInstallationEntry)) {
            this.f15594b.setResult(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
            return true;
        }
        return false;
    }
}
