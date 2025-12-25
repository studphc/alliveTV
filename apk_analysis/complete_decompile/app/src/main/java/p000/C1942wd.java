package p000;

import com.google.firebase.StartupTime;

/* renamed from: wd */
/* loaded from: classes2.dex */
public final class C1942wd extends StartupTime {

    /* renamed from: a */
    public final long f28138a;

    /* renamed from: b */
    public final long f28139b;

    /* renamed from: c */
    public final long f28140c;

    public C1942wd(long j, long j2, long j3) {
        this.f28138a = j;
        this.f28139b = j2;
        this.f28140c = j3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        if (this.f28138a == startupTime.getEpochMillis() && this.f28139b == startupTime.getElapsedRealtime() && this.f28140c == startupTime.getUptimeMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.StartupTime
    public final long getElapsedRealtime() {
        return this.f28139b;
    }

    @Override // com.google.firebase.StartupTime
    public final long getEpochMillis() {
        return this.f28138a;
    }

    @Override // com.google.firebase.StartupTime
    public final long getUptimeMillis() {
        return this.f28140c;
    }

    public final int hashCode() {
        long j = this.f28138a;
        long j2 = this.f28139b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f28140c;
        return i ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartupTime{epochMillis=");
        sb.append(this.f28138a);
        sb.append(", elapsedRealtime=");
        sb.append(this.f28139b);
        sb.append(", uptimeMillis=");
        return ye0.m8297q(sb, this.f28140c, "}");
    }
}
