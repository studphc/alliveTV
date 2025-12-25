package p000;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class vl1 {

    /* renamed from: a */
    public final MediaSource.MediaPeriodId f27854a;

    /* renamed from: b */
    public final long f27855b;

    /* renamed from: c */
    public final long f27856c;

    /* renamed from: d */
    public final long f27857d;

    /* renamed from: e */
    public final long f27858e;

    /* renamed from: f */
    public final boolean f27859f;

    /* renamed from: g */
    public final boolean f27860g;

    /* renamed from: h */
    public final boolean f27861h;

    /* renamed from: i */
    public final boolean f27862i;

    public vl1(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7 = true;
        if (z4 && !z2) {
            z5 = false;
        } else {
            z5 = true;
        }
        Assertions.checkArgument(z5);
        if (z3 && !z2) {
            z6 = false;
        } else {
            z6 = true;
        }
        Assertions.checkArgument(z6);
        if (z && (z2 || z3 || z4)) {
            z7 = false;
        }
        Assertions.checkArgument(z7);
        this.f27854a = mediaPeriodId;
        this.f27855b = j;
        this.f27856c = j2;
        this.f27857d = j3;
        this.f27858e = j4;
        this.f27859f = z;
        this.f27860g = z2;
        this.f27861h = z3;
        this.f27862i = z4;
    }

    /* renamed from: a */
    public final vl1 m7923a(long j) {
        if (j == this.f27856c) {
            return this;
        }
        return new vl1(this.f27854a, this.f27855b, j, this.f27857d, this.f27858e, this.f27859f, this.f27860g, this.f27861h, this.f27862i);
    }

    /* renamed from: b */
    public final vl1 m7924b(long j) {
        if (j == this.f27855b) {
            return this;
        }
        return new vl1(this.f27854a, j, this.f27856c, this.f27857d, this.f27858e, this.f27859f, this.f27860g, this.f27861h, this.f27862i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vl1.class != obj.getClass()) {
            return false;
        }
        vl1 vl1Var = (vl1) obj;
        if (this.f27855b == vl1Var.f27855b && this.f27856c == vl1Var.f27856c && this.f27857d == vl1Var.f27857d && this.f27858e == vl1Var.f27858e && this.f27859f == vl1Var.f27859f && this.f27860g == vl1Var.f27860g && this.f27861h == vl1Var.f27861h && this.f27862i == vl1Var.f27862i && Util.areEqual(this.f27854a, vl1Var.f27854a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((this.f27854a.hashCode() + 527) * 31) + ((int) this.f27855b)) * 31) + ((int) this.f27856c)) * 31) + ((int) this.f27857d)) * 31) + ((int) this.f27858e)) * 31) + (this.f27859f ? 1 : 0)) * 31) + (this.f27860g ? 1 : 0)) * 31) + (this.f27861h ? 1 : 0)) * 31) + (this.f27862i ? 1 : 0);
    }
}
