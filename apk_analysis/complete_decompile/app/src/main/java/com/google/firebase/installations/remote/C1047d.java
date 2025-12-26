package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* renamed from: com.google.firebase.installations.remote.d */
/* loaded from: classes2.dex */
public final class C1047d extends TokenResult {

    /* renamed from: a */
    public final String f15637a;

    /* renamed from: b */
    public final long f15638b;

    /* renamed from: c */
    public final TokenResult.ResponseCode f15639c;

    public C1047d(String str, long j, TokenResult.ResponseCode responseCode) {
        this.f15637a = str;
        this.f15638b = j;
        this.f15639c = responseCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f15637a;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.f15638b == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.f15639c;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.ResponseCode getResponseCode() {
        return this.f15639c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final String getToken() {
        return this.f15637a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final long getTokenExpirationTimestamp() {
        return this.f15638b;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        String str = this.f15637a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j = this.f15638b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f15639c;
        if (responseCode != null) {
            i = responseCode.hashCode();
        }
        return i ^ i2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.installations.remote.TokenResult$Builder, com.google.firebase.installations.remote.c] */
    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.Builder toBuilder() {
        ?? builder = new TokenResult.Builder();
        builder.f15634a = getToken();
        builder.f15635b = Long.valueOf(getTokenExpirationTimestamp());
        builder.f15636c = getResponseCode();
        return builder;
    }

    public final String toString() {
        return "TokenResult{token=" + this.f15637a + ", tokenExpirationTimestamp=" + this.f15638b + ", responseCode=" + this.f15639c + "}";
    }
}
