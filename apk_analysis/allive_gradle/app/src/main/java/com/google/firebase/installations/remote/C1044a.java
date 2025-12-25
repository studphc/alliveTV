package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* renamed from: com.google.firebase.installations.remote.a */
/* loaded from: classes2.dex */
public final class C1044a extends InstallationResponse.Builder {

    /* renamed from: a */
    public String f15624a;

    /* renamed from: b */
    public String f15625b;

    /* renamed from: c */
    public String f15626c;

    /* renamed from: d */
    public TokenResult f15627d;

    /* renamed from: e */
    public InstallationResponse.ResponseCode f15628e;

    @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
    public final InstallationResponse build() {
        return new C1045b(this.f15624a, this.f15625b, this.f15626c, this.f15627d, this.f15628e);
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
    public final InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
        this.f15627d = tokenResult;
        return this;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
    public final InstallationResponse.Builder setFid(String str) {
        this.f15625b = str;
        return this;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
    public final InstallationResponse.Builder setRefreshToken(String str) {
        this.f15626c = str;
        return this;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
    public final InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
        this.f15628e = responseCode;
        return this;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
    public final InstallationResponse.Builder setUri(String str) {
        this.f15624a = str;
        return this;
    }
}
