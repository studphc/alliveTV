package p000;

import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class ev2 {

    /* renamed from: a */
    public final Track f16998a;

    /* renamed from: b */
    public final int f16999b;

    /* renamed from: c */
    public final long[] f17000c;

    /* renamed from: d */
    public final int[] f17001d;

    /* renamed from: e */
    public final int f17002e;

    /* renamed from: f */
    public final long[] f17003f;

    /* renamed from: g */
    public final int[] f17004g;

    /* renamed from: h */
    public final long f17005h;

    public ev2(Track track, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        boolean z;
        boolean z2;
        if (iArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        if (jArr.length == jArr2.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        Assertions.checkArgument(iArr2.length == jArr2.length);
        this.f16998a = track;
        this.f17000c = jArr;
        this.f17001d = iArr;
        this.f17002e = i;
        this.f17003f = jArr2;
        this.f17004g = iArr2;
        this.f17005h = j;
        this.f16999b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    /* renamed from: a */
    public final int m4759a(long j) {
        long[] jArr = this.f17003f;
        for (int binarySearchCeil = Util.binarySearchCeil(jArr, j, true, false); binarySearchCeil < jArr.length; binarySearchCeil++) {
            if ((this.f17004g[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
