package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;
import p000.ye0;

/* renamed from: com.google.firebase.installations.b */
/* loaded from: classes2.dex */
public final class C1040b extends InstallationTokenResult {

    /* renamed from: a */
    public final String f15590a;

    /* renamed from: b */
    public final long f15591b;

    /* renamed from: c */
    public final long f15592c;

    public C1040b(String str, long j, long j2) {
        this.f15590a = str;
        this.f15591b = j;
        this.f15592c = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.f15590a.equals(installationTokenResult.getToken()) && this.f15591b == installationTokenResult.getTokenExpirationTimestamp() && this.f15592c == installationTokenResult.getTokenCreationTimestamp()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final String getToken() {
        return this.f15590a;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long getTokenCreationTimestamp() {
        return this.f15592c;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long getTokenExpirationTimestamp() {
        return this.f15591b;
    }

    public final int hashCode() {
        int hashCode = (this.f15590a.hashCode() ^ 1000003) * 1000003;
        long j = this.f15591b;
        long j2 = this.f15592c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.installations.a, com.google.firebase.installations.InstallationTokenResult$Builder] */
    @Override // com.google.firebase.installations.InstallationTokenResult
    public final InstallationTokenResult.Builder toBuilder() {
        ?? builder = new InstallationTokenResult.Builder();
        builder.f15587a = getToken();
        builder.f15588b = Long.valueOf(getTokenExpirationTimestamp());
        builder.f15589c = Long.valueOf(getTokenCreationTimestamp());
        return builder;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationTokenResult{token=");
        sb.append(this.f15590a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f15591b);
        sb.append(", tokenCreationTimestamp=");
        return ye0.m8297q(sb, this.f15592c, "}");
    }
}
