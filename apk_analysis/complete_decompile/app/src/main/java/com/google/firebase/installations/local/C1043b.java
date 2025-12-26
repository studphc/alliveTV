package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import p000.AbstractC1726qj;

/* renamed from: com.google.firebase.installations.local.b */
/* loaded from: classes2.dex */
public final class C1043b extends PersistedInstallationEntry {

    /* renamed from: a */
    public final String f15608a;

    /* renamed from: b */
    public final PersistedInstallation.RegistrationStatus f15609b;

    /* renamed from: c */
    public final String f15610c;

    /* renamed from: d */
    public final String f15611d;

    /* renamed from: e */
    public final long f15612e;

    /* renamed from: f */
    public final long f15613f;

    /* renamed from: g */
    public final String f15614g;

    public C1043b(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j, long j2, String str4) {
        this.f15608a = str;
        this.f15609b = registrationStatus;
        this.f15610c = str2;
        this.f15611d = str3;
        this.f15612e = j;
        this.f15613f = j2;
        this.f15614g = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f15608a;
        if (str3 != null ? str3.equals(persistedInstallationEntry.getFirebaseInstallationId()) : persistedInstallationEntry.getFirebaseInstallationId() == null) {
            if (this.f15609b.equals(persistedInstallationEntry.getRegistrationStatus()) && ((str = this.f15610c) != null ? str.equals(persistedInstallationEntry.getAuthToken()) : persistedInstallationEntry.getAuthToken() == null) && ((str2 = this.f15611d) != null ? str2.equals(persistedInstallationEntry.getRefreshToken()) : persistedInstallationEntry.getRefreshToken() == null) && this.f15612e == persistedInstallationEntry.getExpiresInSecs() && this.f15613f == persistedInstallationEntry.getTokenCreationEpochInSecs()) {
                String str4 = this.f15614g;
                if (str4 == null) {
                    if (persistedInstallationEntry.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getAuthToken() {
        return this.f15610c;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final long getExpiresInSecs() {
        return this.f15612e;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getFirebaseInstallationId() {
        return this.f15608a;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getFisError() {
        return this.f15614g;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getRefreshToken() {
        return this.f15611d;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.f15609b;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final long getTokenCreationEpochInSecs() {
        return this.f15613f;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i = 0;
        String str = this.f15608a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode4 = (((hashCode ^ 1000003) * 1000003) ^ this.f15609b.hashCode()) * 1000003;
        String str2 = this.f15610c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i2 = (hashCode4 ^ hashCode2) * 1000003;
        String str3 = this.f15611d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i3 = (i2 ^ hashCode3) * 1000003;
        long j = this.f15612e;
        int i4 = (i3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f15613f;
        int i5 = (i4 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f15614g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i ^ i5;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.installations.local.PersistedInstallationEntry$Builder, com.google.firebase.installations.local.a] */
    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final PersistedInstallationEntry.Builder toBuilder() {
        ?? builder = new PersistedInstallationEntry.Builder();
        builder.f15601a = getFirebaseInstallationId();
        builder.f15602b = getRegistrationStatus();
        builder.f15603c = getAuthToken();
        builder.f15604d = getRefreshToken();
        builder.f15605e = Long.valueOf(getExpiresInSecs());
        builder.f15606f = Long.valueOf(getTokenCreationEpochInSecs());
        builder.f15607g = getFisError();
        return builder;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f15608a);
        sb.append(", registrationStatus=");
        sb.append(this.f15609b);
        sb.append(", authToken=");
        sb.append(this.f15610c);
        sb.append(", refreshToken=");
        sb.append(this.f15611d);
        sb.append(", expiresInSecs=");
        sb.append(this.f15612e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f15613f);
        sb.append(", fisError=");
        return AbstractC1726qj.m7061q(sb, this.f15614g, "}");
    }
}
