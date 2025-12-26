package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import p000.AbstractC1726qj;

/* renamed from: com.google.firebase.installations.local.a */
/* loaded from: classes2.dex */
public final class C1042a extends PersistedInstallationEntry.Builder {

    /* renamed from: a */
    public String f15601a;

    /* renamed from: b */
    public PersistedInstallation.RegistrationStatus f15602b;

    /* renamed from: c */
    public String f15603c;

    /* renamed from: d */
    public String f15604d;

    /* renamed from: e */
    public Long f15605e;

    /* renamed from: f */
    public Long f15606f;

    /* renamed from: g */
    public String f15607g;

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry build() {
        String str;
        if (this.f15602b == null) {
            str = " registrationStatus";
        } else {
            str = "";
        }
        if (this.f15605e == null) {
            str = str.concat(" expiresInSecs");
        }
        if (this.f15606f == null) {
            str = AbstractC1726qj.m7057m(str, " tokenCreationEpochInSecs");
        }
        if (str.isEmpty()) {
            return new C1043b(this.f15601a, this.f15602b, this.f15603c, this.f15604d, this.f15605e.longValue(), this.f15606f.longValue(), this.f15607g);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setAuthToken(String str) {
        this.f15603c = str;
        return this;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setExpiresInSecs(long j) {
        this.f15605e = Long.valueOf(j);
        return this;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setFirebaseInstallationId(String str) {
        this.f15601a = str;
        return this;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setFisError(String str) {
        this.f15607g = str;
        return this;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setRefreshToken(String str) {
        this.f15604d = str;
        return this;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
        if (registrationStatus != null) {
            this.f15602b = registrationStatus;
            return this;
        }
        throw new NullPointerException("Null registrationStatus");
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
    public final PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j) {
        this.f15606f = Long.valueOf(j);
        return this;
    }
}
