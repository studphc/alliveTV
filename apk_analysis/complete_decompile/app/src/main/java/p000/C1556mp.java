package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* renamed from: mp */
/* loaded from: classes.dex */
public final class C1556mp {

    /* renamed from: a */
    public final TrackOutput f23024a;

    /* renamed from: b */
    public final int f23025b;

    /* renamed from: c */
    public final int f23026c;

    /* renamed from: d */
    public final long f23027d;

    /* renamed from: e */
    public final int f23028e;

    /* renamed from: f */
    public int f23029f;

    /* renamed from: g */
    public int f23030g;

    /* renamed from: h */
    public int f23031h;

    /* renamed from: i */
    public int f23032i;

    /* renamed from: j */
    public int f23033j;

    /* renamed from: k */
    public long[] f23034k;

    /* renamed from: l */
    public int[] f23035l;

    public C1556mp(int i, int i2, long j, int i3, TrackOutput trackOutput) {
        int i4;
        int i5;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f23027d = j;
        this.f23028e = i3;
        this.f23024a = trackOutput;
        if (i2 == 2) {
            i4 = 1667497984;
        } else {
            i4 = 1651965952;
        }
        int i6 = (((i % 10) + 48) << 8) | ((i / 10) + 48);
        this.f23025b = i4 | i6;
        if (i2 == 2) {
            i5 = i6 | 1650720768;
        } else {
            i5 = -1;
        }
        this.f23026c = i5;
        this.f23034k = new long[512];
        this.f23035l = new int[512];
    }

    /* renamed from: a */
    public final SeekPoint m6204a(int i) {
        return new SeekPoint(((this.f23027d * 1) / this.f23028e) * this.f23035l[i], this.f23034k[i]);
    }

    /* renamed from: b */
    public final SeekMap.SeekPoints m6205b(long j) {
        int i = (int) (j / ((this.f23027d * 1) / this.f23028e));
        int binarySearchFloor = Util.binarySearchFloor(this.f23035l, i, true, true);
        if (this.f23035l[binarySearchFloor] == i) {
            return new SeekMap.SeekPoints(m6204a(binarySearchFloor));
        }
        SeekPoint m6204a = m6204a(binarySearchFloor);
        int i2 = binarySearchFloor + 1;
        if (i2 < this.f23034k.length) {
            return new SeekMap.SeekPoints(m6204a, m6204a(i2));
        }
        return new SeekMap.SeekPoints(m6204a);
    }
}
