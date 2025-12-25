package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* renamed from: com.google.firebase.installations.remote.b */
/* loaded from: classes2.dex */
public final class C1045b extends InstallationResponse {

    /* renamed from: a */
    public final String f15629a;

    /* renamed from: b */
    public final String f15630b;

    /* renamed from: c */
    public final String f15631c;

    /* renamed from: d */
    public final TokenResult f15632d;

    /* renamed from: e */
    public final InstallationResponse.ResponseCode f15633e;

    public C1045b(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f15629a = str;
        this.f15630b = str2;
        this.f15631c = str3;
        this.f15632d = tokenResult;
        this.f15633e = responseCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f15629a;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.f15630b;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.f15631c;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.f15632d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f15633e;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final TokenResult getAuthToken() {
        return this.f15632d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getFid() {
        return this.f15630b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getRefreshToken() {
        return this.f15631c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.ResponseCode getResponseCode() {
        return this.f15633e;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getUri() {
        return this.f15629a;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i = 0;
        String str = this.f15629a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i2 = (hashCode ^ 1000003) * 1000003;
        String str2 = this.f15630b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i3 = (i2 ^ hashCode2) * 1000003;
        String str3 = this.f15631c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i4 = (i3 ^ hashCode3) * 1000003;
        TokenResult tokenResult = this.f15632d;
        if (tokenResult == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = tokenResult.hashCode();
        }
        int i5 = (i4 ^ hashCode4) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f15633e;
        if (responseCode != null) {
            i = responseCode.hashCode();
        }
        return i ^ i5;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.installations.remote.InstallationResponse$Builder, com.google.firebase.installations.remote.a] */
    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.Builder toBuilder() {
        ?? builder = new InstallationResponse.Builder();
        builder.f15624a = getUri();
        builder.f15625b = getFid();
        builder.f15626c = getRefreshToken();
        builder.f15627d = getAuthToken();
        builder.f15628e = getResponseCode();
        return builder;
    }

    public final String toString() {
        return "InstallationResponse{uri=" + this.f15629a + ", fid=" + this.f15630b + ", refreshToken=" + this.f15631c + ", authToken=" + this.f15632d + ", responseCode=" + this.f15633e + "}";
    }
}
