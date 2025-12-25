package p000;

import com.google.firebase.heartbeatinfo.SdkHeartBeatResult;

/* renamed from: vd */
/* loaded from: classes2.dex */
public final class C1905vd extends SdkHeartBeatResult {

    /* renamed from: a */
    public final String f27742a;

    /* renamed from: b */
    public final long f27743b;

    public C1905vd(String str, long j) {
        if (str != null) {
            this.f27742a = str;
            this.f27743b = j;
            return;
        }
        throw new NullPointerException("Null sdkName");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkHeartBeatResult)) {
            return false;
        }
        SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
        if (this.f27742a.equals(sdkHeartBeatResult.getSdkName()) && this.f27743b == sdkHeartBeatResult.getMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public final long getMillis() {
        return this.f27743b;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public final String getSdkName() {
        return this.f27742a;
    }

    public final int hashCode() {
        int hashCode = (this.f27742a.hashCode() ^ 1000003) * 1000003;
        long j = this.f27743b;
        return hashCode ^ ((int) ((j >>> 32) ^ j));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SdkHeartBeatResult{sdkName=");
        sb.append(this.f27742a);
        sb.append(", millis=");
        return ye0.m8297q(sb, this.f27743b, "}");
    }
}
