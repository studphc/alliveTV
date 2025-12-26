package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.analytics.b */
/* loaded from: classes.dex */
public final class C0646b {

    /* renamed from: A */
    public long f9582A;

    /* renamed from: B */
    public long f9583B;

    /* renamed from: C */
    public long f9584C;

    /* renamed from: D */
    public long f9585D;

    /* renamed from: E */
    public long f9586E;

    /* renamed from: F */
    public int f9587F;

    /* renamed from: G */
    public int f9588G;

    /* renamed from: H */
    public int f9589H;

    /* renamed from: I */
    public long f9590I;

    /* renamed from: J */
    public boolean f9591J;

    /* renamed from: K */
    public boolean f9592K;

    /* renamed from: L */
    public boolean f9593L;

    /* renamed from: M */
    public boolean f9594M;

    /* renamed from: N */
    public boolean f9595N;

    /* renamed from: O */
    public long f9596O;

    /* renamed from: P */
    public Format f9597P;

    /* renamed from: Q */
    public Format f9598Q;

    /* renamed from: R */
    public long f9599R;

    /* renamed from: S */
    public long f9600S;

    /* renamed from: T */
    public float f9601T;

    /* renamed from: a */
    public final boolean f9602a;

    /* renamed from: b */
    public final long[] f9603b = new long[16];

    /* renamed from: c */
    public final List f9604c;

    /* renamed from: d */
    public final List f9605d;

    /* renamed from: e */
    public final List f9606e;

    /* renamed from: f */
    public final List f9607f;

    /* renamed from: g */
    public final List f9608g;

    /* renamed from: h */
    public final List f9609h;

    /* renamed from: i */
    public final boolean f9610i;

    /* renamed from: j */
    public long f9611j;

    /* renamed from: k */
    public boolean f9612k;

    /* renamed from: l */
    public boolean f9613l;

    /* renamed from: m */
    public boolean f9614m;

    /* renamed from: n */
    public int f9615n;

    /* renamed from: o */
    public int f9616o;

    /* renamed from: p */
    public int f9617p;

    /* renamed from: q */
    public int f9618q;

    /* renamed from: r */
    public long f9619r;

    /* renamed from: s */
    public int f9620s;

    /* renamed from: t */
    public long f9621t;

    /* renamed from: u */
    public long f9622u;

    /* renamed from: v */
    public long f9623v;

    /* renamed from: w */
    public long f9624w;

    /* renamed from: x */
    public long f9625x;

    /* renamed from: y */
    public long f9626y;

    /* renamed from: z */
    public long f9627z;

    public C0646b(AnalyticsListener.EventTime eventTime, boolean z) {
        List emptyList;
        List emptyList2;
        List emptyList3;
        List emptyList4;
        List emptyList5;
        List emptyList6;
        this.f9602a = z;
        if (z) {
            emptyList = new ArrayList();
        } else {
            emptyList = Collections.emptyList();
        }
        this.f9604c = emptyList;
        if (z) {
            emptyList2 = new ArrayList();
        } else {
            emptyList2 = Collections.emptyList();
        }
        this.f9605d = emptyList2;
        if (z) {
            emptyList3 = new ArrayList();
        } else {
            emptyList3 = Collections.emptyList();
        }
        this.f9606e = emptyList3;
        if (z) {
            emptyList4 = new ArrayList();
        } else {
            emptyList4 = Collections.emptyList();
        }
        this.f9607f = emptyList4;
        if (z) {
            emptyList5 = new ArrayList();
        } else {
            emptyList5 = Collections.emptyList();
        }
        this.f9608g = emptyList5;
        if (z) {
            emptyList6 = new ArrayList();
        } else {
            emptyList6 = Collections.emptyList();
        }
        this.f9609h = emptyList6;
        boolean z2 = false;
        this.f9589H = 0;
        this.f9590I = eventTime.realtimeMs;
        this.f9611j = C0643C.TIME_UNSET;
        this.f9619r = C0643C.TIME_UNSET;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null && mediaPeriodId.isAd()) {
            z2 = true;
        }
        this.f9610i = z2;
        this.f9622u = -1L;
        this.f9621t = -1L;
        this.f9620s = -1;
        this.f9601T = 1.0f;
    }

    /* renamed from: c */
    public static boolean m2433c(int i) {
        return i == 6 || i == 7 || i == 10;
    }

    /* renamed from: a */
    public final PlaybackStats m2434a(boolean z) {
        long[] jArr;
        List list;
        int i;
        long j;
        int i2;
        List arrayList;
        List arrayList2;
        List arrayList3;
        int i3;
        long j2;
        int i4;
        long j3;
        int i5;
        int i6;
        long[] jArr2 = this.f9603b;
        List list2 = this.f9605d;
        if (!z) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long[] copyOf = Arrays.copyOf(jArr2, 16);
            long max = Math.max(0L, elapsedRealtime - this.f9590I);
            int i7 = this.f9589H;
            copyOf[i7] = copyOf[i7] + max;
            m2439g(elapsedRealtime);
            m2437e(elapsedRealtime);
            m2436d(elapsedRealtime);
            ArrayList arrayList4 = new ArrayList(list2);
            if (this.f9602a && this.f9589H == 3) {
                arrayList4.add(m2435b(elapsedRealtime));
            }
            jArr = copyOf;
            list = arrayList4;
        } else {
            jArr = jArr2;
            list = list2;
        }
        if (!this.f9614m && this.f9612k) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            j = C0643C.TIME_UNSET;
        } else {
            j = jArr[2];
        }
        long j4 = j;
        if (jArr[1] > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        List list3 = this.f9606e;
        if (z) {
            arrayList = list3;
        } else {
            arrayList = new ArrayList(list3);
        }
        List list4 = this.f9607f;
        if (z) {
            arrayList2 = list4;
        } else {
            arrayList2 = new ArrayList(list4);
        }
        List list5 = this.f9604c;
        if (z) {
            arrayList3 = list5;
        } else {
            arrayList3 = new ArrayList(list5);
        }
        long j5 = this.f9611j;
        boolean z2 = this.f9592K;
        int i8 = !this.f9612k ? 1 : 0;
        boolean z3 = this.f9613l;
        int i9 = i ^ 1;
        int i10 = this.f9615n;
        int i11 = this.f9616o;
        int i12 = this.f9617p;
        int i13 = this.f9618q;
        long j6 = this.f9619r;
        long[] jArr3 = jArr;
        long j7 = this.f9623v;
        long j8 = this.f9624w;
        long j9 = this.f9625x;
        long j10 = this.f9626y;
        long j11 = this.f9627z;
        long j12 = this.f9582A;
        int i14 = this.f9620s;
        if (i14 == -1) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        long j13 = this.f9621t;
        if (j13 == -1) {
            j2 = j13;
            i4 = 0;
        } else {
            j2 = j13;
            i4 = 1;
        }
        long j14 = this.f9622u;
        if (j14 == -1) {
            j3 = j14;
            i5 = 0;
        } else {
            j3 = j14;
            i5 = 1;
        }
        long j15 = this.f9583B;
        long j16 = this.f9584C;
        long j17 = this.f9585D;
        long j18 = this.f9586E;
        int i15 = this.f9587F;
        if (i15 > 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        int i16 = this.f9588G;
        long j19 = j2;
        boolean z4 = this.f9610i;
        return new PlaybackStats(1, jArr3, arrayList3, list, j5, z2 ? 1 : 0, i8, z3 ? 1 : 0, i2, j4, i9, i10, i11, i12, i13, j6, z4 ? 1 : 0, arrayList, arrayList2, j7, j8, j9, j10, j11, j12, i3, i4, i14, j19, i5, j3, j15, j16, j17, j18, i6, i15, i16, this.f9608g, this.f9609h);
    }

    /* renamed from: b */
    public final long[] m2435b(long j) {
        List list = this.f9605d;
        return new long[]{j, ((long[]) list.get(list.size() - 1))[1] + (((float) (j - r0[0])) * this.f9601T)};
    }

    /* renamed from: d */
    public final void m2436d(long j) {
        Format format;
        int i;
        if (this.f9589H == 3 && (format = this.f9598Q) != null && (i = format.bitrate) != -1) {
            long j2 = ((float) (j - this.f9600S)) * this.f9601T;
            this.f9627z += j2;
            this.f9582A = (j2 * i) + this.f9582A;
        }
        this.f9600S = j;
    }

    /* renamed from: e */
    public final void m2437e(long j) {
        Format format;
        if (this.f9589H == 3 && (format = this.f9597P) != null) {
            long j2 = ((float) (j - this.f9599R)) * this.f9601T;
            int i = format.height;
            if (i != -1) {
                this.f9623v += j2;
                this.f9624w = (i * j2) + this.f9624w;
            }
            int i2 = format.bitrate;
            if (i2 != -1) {
                this.f9625x += j2;
                this.f9626y = (j2 * i2) + this.f9626y;
            }
        }
        this.f9599R = j;
    }

    /* renamed from: f */
    public final void m2438f(AnalyticsListener.EventTime eventTime, Format format) {
        int i;
        if (Util.areEqual(this.f9598Q, format)) {
            return;
        }
        m2436d(eventTime.realtimeMs);
        if (format != null && this.f9622u == -1 && (i = format.bitrate) != -1) {
            this.f9622u = i;
        }
        this.f9598Q = format;
        if (this.f9602a) {
            this.f9607f.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
        }
    }

    /* renamed from: g */
    public final void m2439g(long j) {
        if (m2433c(this.f9589H)) {
            long j2 = j - this.f9596O;
            long j3 = this.f9619r;
            if (j3 == C0643C.TIME_UNSET || j2 > j3) {
                this.f9619r = j2;
            }
        }
    }

    /* renamed from: h */
    public final void m2440h(long j, long j2) {
        if (!this.f9602a) {
            return;
        }
        int i = this.f9589H;
        List list = this.f9605d;
        if (i != 3) {
            if (j2 == C0643C.TIME_UNSET) {
                return;
            }
            if (!list.isEmpty()) {
                long j3 = ((long[]) list.get(list.size() - 1))[1];
                if (j3 != j2) {
                    list.add(new long[]{j, j3});
                }
            }
        }
        if (j2 != C0643C.TIME_UNSET) {
            list.add(new long[]{j, j2});
        } else if (!list.isEmpty()) {
            list.add(m2435b(j));
        }
    }

    /* renamed from: i */
    public final void m2441i(AnalyticsListener.EventTime eventTime, Format format) {
        int i;
        int i2;
        if (Util.areEqual(this.f9597P, format)) {
            return;
        }
        m2437e(eventTime.realtimeMs);
        if (format != null) {
            if (this.f9620s == -1 && (i2 = format.height) != -1) {
                this.f9620s = i2;
            }
            if (this.f9621t == -1 && (i = format.bitrate) != -1) {
                this.f9621t = i;
            }
        }
        this.f9597P = format;
        if (this.f9602a) {
            this.f9606e.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
        }
    }

    /* renamed from: j */
    public final void m2442j(AnalyticsListener.EventTime eventTime, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (eventTime.realtimeMs >= this.f9590I) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        long j = eventTime.realtimeMs;
        long j2 = j - this.f9590I;
        int i2 = this.f9589H;
        long[] jArr = this.f9603b;
        jArr[i2] = jArr[i2] + j2;
        if (this.f9611j == C0643C.TIME_UNSET) {
            this.f9611j = j;
        }
        boolean z5 = this.f9614m;
        if ((i2 != 1 && i2 != 2 && i2 != 14) || i == 1 || i == 2 || i == 14 || i == 3 || i == 4 || i == 9 || i == 11) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f9614m = z5 | z2;
        boolean z6 = this.f9612k;
        if (i != 3 && i != 4 && i != 9) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f9612k = z6 | z3;
        boolean z7 = this.f9613l;
        if (i == 11) {
            z4 = true;
        }
        this.f9613l = z4 | z7;
        if (i2 != 4 && i2 != 7 && (i == 4 || i == 7)) {
            this.f9615n++;
        }
        if (i == 5) {
            this.f9617p++;
        }
        if (!m2433c(i2) && m2433c(i)) {
            this.f9618q++;
            this.f9596O = eventTime.realtimeMs;
        }
        if (m2433c(this.f9589H) && this.f9589H != 7 && i == 7) {
            this.f9616o++;
        }
        m2439g(eventTime.realtimeMs);
        this.f9589H = i;
        this.f9590I = eventTime.realtimeMs;
        if (this.f9602a) {
            this.f9604c.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, i));
        }
    }
}
