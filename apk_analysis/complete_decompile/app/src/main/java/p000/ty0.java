package p000;

import com.google.android.exoplayer2.extractor.TrackOutput;

/* loaded from: classes.dex */
public final class ty0 {

    /* renamed from: a */
    public final TrackOutput f27017a;

    /* renamed from: b */
    public boolean f27018b;

    /* renamed from: c */
    public boolean f27019c;

    /* renamed from: d */
    public boolean f27020d;

    /* renamed from: e */
    public int f27021e;

    /* renamed from: f */
    public int f27022f;

    /* renamed from: g */
    public long f27023g;

    /* renamed from: h */
    public long f27024h;

    public ty0(TrackOutput trackOutput) {
        this.f27017a = trackOutput;
    }

    /* renamed from: a */
    public final void m7513a(byte[] bArr, int i, int i2) {
        boolean z;
        if (this.f27019c) {
            int i3 = this.f27022f;
            int i4 = (i + 1) - i3;
            if (i4 < i2) {
                if (((bArr[i4] & 192) >> 6) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f27020d = z;
                this.f27019c = false;
                return;
            }
            this.f27022f = (i2 - i) + i3;
        }
    }
}
