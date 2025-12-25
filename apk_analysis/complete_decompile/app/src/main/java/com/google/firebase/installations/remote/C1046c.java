package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* renamed from: com.google.firebase.installations.remote.c */
/* loaded from: classes2.dex */
public final class C1046c extends TokenResult.Builder {

    /* renamed from: a */
    public String f15634a;

    /* renamed from: b */
    public Long f15635b;

    /* renamed from: c */
    public TokenResult.ResponseCode f15636c;

    @Override // com.google.firebase.installations.remote.TokenResult.Builder
    public final TokenResult build() {
        String str;
        if (this.f15635b == null) {
            str = " tokenExpirationTimestamp";
        } else {
            str = "";
        }
        if (str.isEmpty()) {
            return new C1047d(this.f15634a, this.f15635b.longValue(), this.f15636c);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    @Override // com.google.firebase.installations.remote.TokenResult.Builder
    public final TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
        this.f15636c = responseCode;
        return this;
    }

    @Override // com.google.firebase.installations.remote.TokenResult.Builder
    public final TokenResult.Builder setToken(String str) {
        this.f15634a = str;
        return this;
    }

    @Override // com.google.firebase.installations.remote.TokenResult.Builder
    public final TokenResult.Builder setTokenExpirationTimestamp(long j) {
        this.f15635b = Long.valueOf(j);
        return this;
    }
}
