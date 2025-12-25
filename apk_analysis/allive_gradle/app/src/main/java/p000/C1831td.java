package p000;

import com.google.firebase.heartbeatinfo.HeartBeatResult;
import java.util.List;

/* renamed from: td */
/* loaded from: classes2.dex */
public final class C1831td extends HeartBeatResult {

    /* renamed from: a */
    public final String f26777a;

    /* renamed from: b */
    public final List f26778b;

    public C1831td(String str, List list) {
        if (str != null) {
            this.f26777a = str;
            if (list != null) {
                this.f26778b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        if (this.f26777a.equals(heartBeatResult.getUserAgent()) && this.f26778b.equals(heartBeatResult.getUsedDates())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final List getUsedDates() {
        return this.f26778b;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final String getUserAgent() {
        return this.f26777a;
    }

    public final int hashCode() {
        return ((this.f26777a.hashCode() ^ 1000003) * 1000003) ^ this.f26778b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f26777a + ", usedDates=" + this.f26778b + "}";
    }
}
