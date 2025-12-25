package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;
import p000.AbstractC1726qj;

/* renamed from: com.google.firebase.installations.a */
/* loaded from: classes2.dex */
public final class C1039a extends InstallationTokenResult.Builder {

    /* renamed from: a */
    public String f15587a;

    /* renamed from: b */
    public Long f15588b;

    /* renamed from: c */
    public Long f15589c;

    @Override // com.google.firebase.installations.InstallationTokenResult.Builder
    public final InstallationTokenResult build() {
        String str;
        if (this.f15587a == null) {
            str = " token";
        } else {
            str = "";
        }
        if (this.f15588b == null) {
            str = str.concat(" tokenExpirationTimestamp");
        }
        if (this.f15589c == null) {
            str = AbstractC1726qj.m7057m(str, " tokenCreationTimestamp");
        }
        if (str.isEmpty()) {
            return new C1040b(this.f15587a, this.f15588b.longValue(), this.f15589c.longValue());
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    @Override // com.google.firebase.installations.InstallationTokenResult.Builder
    public final InstallationTokenResult.Builder setToken(String str) {
        if (str != null) {
            this.f15587a = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    @Override // com.google.firebase.installations.InstallationTokenResult.Builder
    public final InstallationTokenResult.Builder setTokenCreationTimestamp(long j) {
        this.f15589c = Long.valueOf(j);
        return this;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult.Builder
    public final InstallationTokenResult.Builder setTokenExpirationTimestamp(long j) {
        this.f15588b = Long.valueOf(j);
        return this;
    }
}
