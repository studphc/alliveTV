package com.google.android.exoplayer2.source;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import p000.ae2;
import p000.be2;
import p000.ce2;
import p000.de2;
import p000.dv2;
import p000.h71;
import p000.t82;

/* loaded from: classes.dex */
public class SampleQueue implements TrackOutput {

    /* renamed from: A */
    public Format f11014A;

    /* renamed from: B */
    public Format f11015B;

    /* renamed from: C */
    public int f11016C;

    /* renamed from: D */
    public boolean f11017D;

    /* renamed from: E */
    public boolean f11018E;

    /* renamed from: F */
    public long f11019F;

    /* renamed from: G */
    public boolean f11020G;

    /* renamed from: a */
    public final be2 f11021a;

    /* renamed from: d */
    public final DrmSessionManager f11024d;

    /* renamed from: e */
    public final DrmSessionEventListener.EventDispatcher f11025e;

    /* renamed from: f */
    public UpstreamFormatChangedListener f11026f;

    /* renamed from: g */
    public Format f11027g;

    /* renamed from: h */
    public DrmSession f11028h;

    /* renamed from: p */
    public int f11036p;

    /* renamed from: q */
    public int f11037q;

    /* renamed from: r */
    public int f11038r;

    /* renamed from: s */
    public int f11039s;

    /* renamed from: w */
    public boolean f11043w;

    /* renamed from: z */
    public boolean f11046z;

    /* renamed from: b */
    public final ce2 f11022b = new Object();

    /* renamed from: i */
    public int f11029i = 1000;

    /* renamed from: j */
    public int[] f11030j = new int[1000];

    /* renamed from: k */
    public long[] f11031k = new long[1000];

    /* renamed from: n */
    public long[] f11034n = new long[1000];

    /* renamed from: m */
    public int[] f11033m = new int[1000];

    /* renamed from: l */
    public int[] f11032l = new int[1000];

    /* renamed from: o */
    public TrackOutput.CryptoData[] f11035o = new TrackOutput.CryptoData[1000];

    /* renamed from: c */
    public final h71 f11023c = new h71(new t82(1));

    /* renamed from: t */
    public long f11040t = Long.MIN_VALUE;

    /* renamed from: u */
    public long f11041u = Long.MIN_VALUE;

    /* renamed from: v */
    public long f11042v = Long.MIN_VALUE;

    /* renamed from: y */
    public boolean f11045y = true;

    /* renamed from: x */
    public boolean f11044x = true;

    /* loaded from: classes.dex */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [ce2, java.lang.Object] */
    public SampleQueue(Allocator allocator, @Nullable DrmSessionManager drmSessionManager, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f11024d = drmSessionManager;
        this.f11025e = eventDispatcher;
        this.f11021a = new be2(allocator);
    }

    public static SampleQueue createWithDrm(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        return new SampleQueue(allocator, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        if (((p000.de2) r9.valueAt(r9.size() - 1)).f16352a.equals(r8.f11015B) == false) goto L23;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void m2743a(long j, int i, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        boolean z;
        boolean z2;
        DrmSessionManager.DrmSessionReference drmSessionReference;
        boolean z3;
        boolean z4;
        boolean z5;
        try {
            int i3 = this.f11036p;
            if (i3 > 0) {
                if (this.f11031k[m2749g(i3 - 1)] + this.f11032l[r0] <= j2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Assertions.checkArgument(z5);
            }
            if ((536870912 & i) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.f11043w = z;
            this.f11042v = Math.max(this.f11042v, j);
            int m2749g = m2749g(this.f11036p);
            this.f11034n[m2749g] = j;
            this.f11031k[m2749g] = j2;
            this.f11032l[m2749g] = i2;
            this.f11033m[m2749g] = i;
            this.f11035o[m2749g] = cryptoData;
            this.f11030j[m2749g] = this.f11016C;
            if (((SparseArray) this.f11023c.f17965b).size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                SparseArray sparseArray = (SparseArray) this.f11023c.f17965b;
            }
            DrmSessionManager drmSessionManager = this.f11024d;
            if (drmSessionManager != null) {
                drmSessionReference = drmSessionManager.preacquireSession(this.f11025e, this.f11015B);
            } else {
                drmSessionReference = DrmSessionManager.DrmSessionReference.EMPTY;
            }
            h71 h71Var = this.f11023c;
            int writeIndex = getWriteIndex();
            de2 de2Var = new de2((Format) Assertions.checkNotNull(this.f11015B), drmSessionReference);
            int i4 = h71Var.f17964a;
            SparseArray sparseArray2 = (SparseArray) h71Var.f17965b;
            if (i4 == -1) {
                if (sparseArray2.size() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.checkState(z4);
                h71Var.f17964a = 0;
            }
            if (sparseArray2.size() > 0) {
                int keyAt = sparseArray2.keyAt(sparseArray2.size() - 1);
                if (writeIndex >= keyAt) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.checkArgument(z3);
                if (keyAt == writeIndex) {
                    ((t82) h71Var.f17966c).accept(sparseArray2.valueAt(sparseArray2.size() - 1));
                }
            }
            sparseArray2.append(writeIndex, de2Var);
            int i5 = this.f11036p + 1;
            this.f11036p = i5;
            int i6 = this.f11029i;
            if (i5 == i6) {
                int i7 = i6 + 1000;
                int[] iArr = new int[i7];
                long[] jArr = new long[i7];
                long[] jArr2 = new long[i7];
                int[] iArr2 = new int[i7];
                int[] iArr3 = new int[i7];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i7];
                int i8 = this.f11038r;
                int i9 = i6 - i8;
                System.arraycopy(this.f11031k, i8, jArr, 0, i9);
                System.arraycopy(this.f11034n, this.f11038r, jArr2, 0, i9);
                System.arraycopy(this.f11033m, this.f11038r, iArr2, 0, i9);
                System.arraycopy(this.f11032l, this.f11038r, iArr3, 0, i9);
                System.arraycopy(this.f11035o, this.f11038r, cryptoDataArr, 0, i9);
                System.arraycopy(this.f11030j, this.f11038r, iArr, 0, i9);
                int i10 = this.f11038r;
                System.arraycopy(this.f11031k, 0, jArr, i9, i10);
                System.arraycopy(this.f11034n, 0, jArr2, i9, i10);
                System.arraycopy(this.f11033m, 0, iArr2, i9, i10);
                System.arraycopy(this.f11032l, 0, iArr3, i9, i10);
                System.arraycopy(this.f11035o, 0, cryptoDataArr, i9, i10);
                System.arraycopy(this.f11030j, 0, iArr, i9, i10);
                this.f11031k = jArr;
                this.f11034n = jArr2;
                this.f11033m = iArr2;
                this.f11032l = iArr3;
                this.f11035o = cryptoDataArr;
                this.f11030j = iArr;
                this.f11038r = 0;
                this.f11029i = i7;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b */
    public final int m2744b(long j) {
        int i = this.f11036p;
        int m2749g = m2749g(i - 1);
        while (i > this.f11039s && this.f11034n[m2749g] >= j) {
            i--;
            m2749g--;
            if (m2749g == -1) {
                m2749g = this.f11029i - 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public final long m2745c(int i) {
        this.f11041u = Math.max(this.f11041u, m2748f(i));
        this.f11036p -= i;
        int i2 = this.f11037q + i;
        this.f11037q = i2;
        int i3 = this.f11038r + i;
        this.f11038r = i3;
        int i4 = this.f11029i;
        if (i3 >= i4) {
            this.f11038r = i3 - i4;
        }
        int i5 = this.f11039s - i;
        this.f11039s = i5;
        int i6 = 0;
        if (i5 < 0) {
            this.f11039s = 0;
        }
        while (true) {
            h71 h71Var = this.f11023c;
            SparseArray sparseArray = (SparseArray) h71Var.f17965b;
            if (i6 >= sparseArray.size() - 1) {
                break;
            }
            int i7 = i6 + 1;
            if (i2 < sparseArray.keyAt(i7)) {
                break;
            }
            ((t82) h71Var.f17966c).accept(sparseArray.valueAt(i6));
            sparseArray.removeAt(i6);
            int i8 = h71Var.f17964a;
            if (i8 > 0) {
                h71Var.f17964a = i8 - 1;
            }
            i6 = i7;
        }
        if (this.f11036p == 0) {
            int i9 = this.f11038r;
            if (i9 == 0) {
                i9 = this.f11029i;
            }
            return this.f11031k[i9 - 1] + this.f11032l[r7];
        }
        return this.f11031k[this.f11038r];
    }

    /* renamed from: d */
    public final long m2746d(int i) {
        boolean z;
        int i2;
        int writeIndex = getWriteIndex() - i;
        boolean z2 = false;
        if (writeIndex >= 0 && writeIndex <= this.f11036p - this.f11039s) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int i3 = this.f11036p - writeIndex;
        this.f11036p = i3;
        this.f11042v = Math.max(this.f11041u, m2748f(i3));
        if (writeIndex == 0 && this.f11043w) {
            z2 = true;
        }
        this.f11043w = z2;
        h71 h71Var = this.f11023c;
        SparseArray sparseArray = (SparseArray) h71Var.f17965b;
        for (int size = sparseArray.size() - 1; size >= 0 && i < sparseArray.keyAt(size); size--) {
            ((t82) h71Var.f17966c).accept(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
        }
        if (sparseArray.size() > 0) {
            i2 = Math.min(h71Var.f17964a, sparseArray.size() - 1);
        } else {
            i2 = -1;
        }
        h71Var.f17964a = i2;
        int i4 = this.f11036p;
        if (i4 != 0) {
            return this.f11031k[m2749g(i4 - 1)] + this.f11032l[r9];
        }
        return 0L;
    }

    public synchronized long discardSampleMetadataToRead() {
        int i = this.f11039s;
        if (i == 0) {
            return -1L;
        }
        return m2745c(i);
    }

    public final void discardTo(long j, boolean z, boolean z2) {
        long j2;
        int i;
        be2 be2Var = this.f11021a;
        synchronized (this) {
            try {
                int i2 = this.f11036p;
                j2 = -1;
                if (i2 != 0) {
                    long[] jArr = this.f11034n;
                    int i3 = this.f11038r;
                    if (j >= jArr[i3]) {
                        if (z2 && (i = this.f11039s) != i2) {
                            i2 = i + 1;
                        }
                        int m2747e = m2747e(z, i3, i2, j);
                        if (m2747e != -1) {
                            j2 = m2745c(m2747e);
                        }
                    }
                }
            } finally {
            }
        }
        be2Var.m2090a(j2);
    }

    public final void discardToEnd() {
        long m2745c;
        be2 be2Var = this.f11021a;
        synchronized (this) {
            int i = this.f11036p;
            if (i == 0) {
                m2745c = -1;
            } else {
                m2745c = m2745c(i);
            }
        }
        be2Var.m2090a(m2745c);
    }

    public final void discardToRead() {
        this.f11021a.m2090a(discardSampleMetadataToRead());
    }

    public final void discardUpstreamFrom(long j) {
        boolean z;
        if (this.f11036p == 0) {
            return;
        }
        if (j > getLargestReadTimestampUs()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        discardUpstreamSamples(this.f11037q + m2744b(j));
    }

    public final void discardUpstreamSamples(int i) {
        boolean z;
        long m2746d = m2746d(i);
        be2 be2Var = this.f11021a;
        if (m2746d <= be2Var.f7986g) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        be2Var.f7986g = m2746d;
        Allocator allocator = be2Var.f7980a;
        int i2 = be2Var.f7981b;
        if (m2746d != 0) {
            ae2 ae2Var = be2Var.f7983d;
            if (m2746d != ae2Var.f151a) {
                while (be2Var.f7986g > ae2Var.f152b) {
                    ae2Var = ae2Var.f154d;
                }
                ae2 ae2Var2 = (ae2) Assertions.checkNotNull(ae2Var.f154d);
                if (ae2Var2.f153c != null) {
                    allocator.release(ae2Var2);
                    ae2Var2.f153c = null;
                    ae2Var2.f154d = null;
                }
                ae2 ae2Var3 = new ae2(ae2Var.f152b, i2);
                ae2Var.f154d = ae2Var3;
                if (be2Var.f7986g == ae2Var.f152b) {
                    ae2Var = ae2Var3;
                }
                be2Var.f7985f = ae2Var;
                if (be2Var.f7984e == ae2Var2) {
                    be2Var.f7984e = ae2Var3;
                    return;
                }
                return;
            }
        }
        ae2 ae2Var4 = be2Var.f7983d;
        if (ae2Var4.f153c != null) {
            allocator.release(ae2Var4);
            ae2Var4.f153c = null;
            ae2Var4.f154d = null;
        }
        ae2 ae2Var5 = new ae2(be2Var.f7986g, i2);
        be2Var.f7983d = ae2Var5;
        be2Var.f7984e = ae2Var5;
        be2Var.f7985f = ae2Var5;
    }

    /* renamed from: e */
    public final int m2747e(boolean z, int i, int i2, long j) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.f11034n[i];
            if (j2 <= j) {
                if (!z || (this.f11033m[i] & 1) != 0) {
                    if (j2 == j) {
                        return i4;
                    }
                    i3 = i4;
                }
                i++;
                if (i == this.f11029i) {
                    i = 0;
                }
            } else {
                return i3;
            }
        }
        return i3;
    }

    /* renamed from: f */
    public final long m2748f(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int m2749g = m2749g(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.f11034n[m2749g]);
            if ((this.f11033m[m2749g] & 1) != 0) {
                break;
            }
            m2749g--;
            if (m2749g == -1) {
                m2749g = this.f11029i - 1;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(Format format) {
        boolean z;
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        boolean z2 = false;
        this.f11046z = false;
        this.f11014A = format;
        synchronized (this) {
            try {
                this.f11045y = false;
                if (!Util.areEqual(adjustedUpstreamFormat, this.f11015B)) {
                    if (((SparseArray) this.f11023c.f17965b).size() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        SparseArray sparseArray = (SparseArray) this.f11023c.f17965b;
                        if (((de2) sparseArray.valueAt(sparseArray.size() - 1)).f16352a.equals(adjustedUpstreamFormat)) {
                            SparseArray sparseArray2 = (SparseArray) this.f11023c.f17965b;
                            this.f11015B = ((de2) sparseArray2.valueAt(sparseArray2.size() - 1)).f16352a;
                            Format format2 = this.f11015B;
                            this.f11017D = MimeTypes.allSamplesAreSyncSamples(format2.sampleMimeType, format2.codecs);
                            this.f11018E = false;
                            z2 = true;
                        }
                    }
                    this.f11015B = adjustedUpstreamFormat;
                    Format format22 = this.f11015B;
                    this.f11017D = MimeTypes.allSamplesAreSyncSamples(format22.sampleMimeType, format22.codecs);
                    this.f11018E = false;
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f11026f;
        if (upstreamFormatChangedListener != null && z2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
        }
    }

    /* renamed from: g */
    public final int m2749g(int i) {
        int i2 = this.f11038r + i;
        int i3 = this.f11029i;
        if (i2 >= i3) {
            return i2 - i3;
        }
        return i2;
    }

    @CallSuper
    public Format getAdjustedUpstreamFormat(Format format) {
        if (this.f11019F != 0 && format.subsampleOffsetUs != Long.MAX_VALUE) {
            return format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.f11019F).build();
        }
        return format;
    }

    public final int getFirstIndex() {
        return this.f11037q;
    }

    public final synchronized long getFirstTimestampUs() {
        long j;
        if (this.f11036p == 0) {
            j = Long.MIN_VALUE;
        } else {
            j = this.f11034n[this.f11038r];
        }
        return j;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.f11042v;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return Math.max(this.f11041u, m2748f(this.f11039s));
    }

    public final int getReadIndex() {
        return this.f11037q + this.f11039s;
    }

    public final synchronized int getSkipCount(long j, boolean z) {
        int m2749g = m2749g(this.f11039s);
        if (m2750h() && j >= this.f11034n[m2749g]) {
            if (j > this.f11042v && z) {
                return this.f11036p - this.f11039s;
            }
            int m2747e = m2747e(true, m2749g, this.f11036p - this.f11039s, j);
            if (m2747e == -1) {
                return 0;
            }
            return m2747e;
        }
        return 0;
    }

    @Nullable
    public final synchronized Format getUpstreamFormat() {
        Format format;
        if (this.f11045y) {
            format = null;
        } else {
            format = this.f11015B;
        }
        return format;
    }

    public final int getWriteIndex() {
        return this.f11037q + this.f11036p;
    }

    /* renamed from: h */
    public final boolean m2750h() {
        if (this.f11039s != this.f11036p) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public final boolean m2751i(int i) {
        DrmSession drmSession = this.f11028h;
        if (drmSession != null && drmSession.getState() != 4 && ((this.f11033m[i] & 1073741824) != 0 || !this.f11028h.playClearSamplesWithoutKeys())) {
            return false;
        }
        return true;
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.f11046z = true;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.f11043w;
    }

    @CallSuper
    public synchronized boolean isReady(boolean z) {
        Format format;
        boolean z2 = true;
        if (!m2750h()) {
            if (!z && !this.f11043w && ((format = this.f11015B) == null || format == this.f11027g)) {
                z2 = false;
            }
            return z2;
        }
        if (((de2) this.f11023c.m5041b(getReadIndex())).f16352a != this.f11027g) {
            return true;
        }
        return m2751i(m2749g(this.f11039s));
    }

    /* renamed from: j */
    public final void m2752j(Format format, FormatHolder formatHolder) {
        boolean z;
        DrmInitData drmInitData;
        Format format2;
        Format format3 = this.f11027g;
        if (format3 == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            drmInitData = null;
        } else {
            drmInitData = format3.drmInitData;
        }
        this.f11027g = format;
        DrmInitData drmInitData2 = format.drmInitData;
        DrmSessionManager drmSessionManager = this.f11024d;
        if (drmSessionManager != null) {
            format2 = format.copyWithCryptoType(drmSessionManager.getCryptoType(format));
        } else {
            format2 = format;
        }
        formatHolder.format = format2;
        formatHolder.drmSession = this.f11028h;
        if (drmSessionManager == null) {
            return;
        }
        if (!z && Util.areEqual(drmInitData, drmInitData2)) {
            return;
        }
        DrmSession drmSession = this.f11028h;
        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f11025e;
        DrmSession acquireSession = drmSessionManager.acquireSession(eventDispatcher, format);
        this.f11028h = acquireSession;
        formatHolder.drmSession = acquireSession;
        if (drmSession != null) {
            drmSession.release(eventDispatcher);
        }
    }

    /* renamed from: k */
    public final synchronized void m2753k() {
        this.f11039s = 0;
        be2 be2Var = this.f11021a;
        be2Var.f7984e = be2Var.f7983d;
    }

    @CallSuper
    public void maybeThrowError() {
        DrmSession drmSession = this.f11028h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.f11028h.getError()));
        }
    }

    public final synchronized int peekSourceId() {
        int i;
        try {
            int m2749g = m2749g(this.f11039s);
            if (m2750h()) {
                i = this.f11030j[m2749g];
            } else {
                i = this.f11016C;
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    @CallSuper
    public void preRelease() {
        discardToEnd();
        DrmSession drmSession = this.f11028h;
        if (drmSession != null) {
            drmSession.release(this.f11025e);
            this.f11028h = null;
            this.f11027g = null;
        }
    }

    @CallSuper
    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        boolean z2;
        int i2;
        boolean z3 = false;
        if ((i & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ce2 ce2Var = this.f11022b;
        synchronized (this) {
            try {
                decoderInputBuffer.waitingForKeys = false;
                i2 = -3;
                if (!m2750h()) {
                    if (!z && !this.f11043w) {
                        Format format = this.f11015B;
                        if (format == null || (!z2 && format == this.f11027g)) {
                        }
                        m2752j((Format) Assertions.checkNotNull(format), formatHolder);
                        i2 = -5;
                    }
                    decoderInputBuffer.setFlags(4);
                    i2 = -4;
                } else {
                    Format format2 = ((de2) this.f11023c.m5041b(getReadIndex())).f16352a;
                    if (!z2 && format2 == this.f11027g) {
                        int m2749g = m2749g(this.f11039s);
                        if (!m2751i(m2749g)) {
                            decoderInputBuffer.waitingForKeys = true;
                        } else {
                            decoderInputBuffer.setFlags(this.f11033m[m2749g]);
                            long j = this.f11034n[m2749g];
                            decoderInputBuffer.timeUs = j;
                            if (j < this.f11040t) {
                                decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                            }
                            ce2Var.f8346a = this.f11032l[m2749g];
                            ce2Var.f8347b = this.f11031k[m2749g];
                            ce2Var.f8348c = this.f11035o[m2749g];
                            i2 = -4;
                        }
                    }
                    m2752j(format2, formatHolder);
                    i2 = -5;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 == -4 && !decoderInputBuffer.isEndOfStream()) {
            if ((i & 1) != 0) {
                z3 = true;
            }
            if ((i & 4) == 0) {
                if (z3) {
                    be2 be2Var = this.f11021a;
                    be2.m2089e(be2Var.f7984e, decoderInputBuffer, this.f11022b, be2Var.f7982c);
                } else {
                    be2 be2Var2 = this.f11021a;
                    be2Var2.f7984e = be2.m2089e(be2Var2.f7984e, decoderInputBuffer, this.f11022b, be2Var2.f7982c);
                }
            }
            if (!z3) {
                this.f11039s++;
            }
        }
        return i2;
    }

    @CallSuper
    public void release() {
        reset(true);
        DrmSession drmSession = this.f11028h;
        if (drmSession != null) {
            drmSession.release(this.f11025e);
            this.f11028h = null;
            this.f11027g = null;
        }
    }

    @CallSuper
    public void reset(boolean z) {
        h71 h71Var;
        SparseArray sparseArray;
        be2 be2Var = this.f11021a;
        ae2 ae2Var = be2Var.f7983d;
        Allocation allocation = ae2Var.f153c;
        Allocator allocator = be2Var.f7980a;
        if (allocation != null) {
            allocator.release(ae2Var);
            ae2Var.f153c = null;
            ae2Var.f154d = null;
        }
        ae2 ae2Var2 = be2Var.f7983d;
        int i = 0;
        Assertions.checkState(ae2Var2.f153c == null);
        ae2Var2.f151a = 0L;
        ae2Var2.f152b = be2Var.f7981b;
        ae2 ae2Var3 = be2Var.f7983d;
        be2Var.f7984e = ae2Var3;
        be2Var.f7985f = ae2Var3;
        be2Var.f7986g = 0L;
        allocator.trim();
        this.f11036p = 0;
        this.f11037q = 0;
        this.f11038r = 0;
        this.f11039s = 0;
        this.f11044x = true;
        this.f11040t = Long.MIN_VALUE;
        this.f11041u = Long.MIN_VALUE;
        this.f11042v = Long.MIN_VALUE;
        this.f11043w = false;
        while (true) {
            h71Var = this.f11023c;
            sparseArray = (SparseArray) h71Var.f17965b;
            if (i >= sparseArray.size()) {
                break;
            }
            ((t82) h71Var.f17966c).accept(sparseArray.valueAt(i));
            i++;
        }
        h71Var.f17964a = -1;
        sparseArray.clear();
        if (z) {
            this.f11014A = null;
            this.f11015B = null;
            this.f11045y = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
        return dv2.m4620a(this, dataReader, i, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
        boolean z;
        int i4;
        if (this.f11046z) {
            format((Format) Assertions.checkStateNotNull(this.f11014A));
        }
        int i5 = i & 1;
        boolean z2 = true;
        if (i5 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f11044x) {
            if (!z) {
                return;
            } else {
                this.f11044x = false;
            }
        }
        long j2 = this.f11019F + j;
        if (this.f11017D) {
            if (j2 < this.f11040t) {
                return;
            }
            if (i5 == 0) {
                if (!this.f11018E) {
                    Log.m3027w("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.f11015B);
                    this.f11018E = true;
                }
                i4 = i | 1;
                if (this.f11020G) {
                    if (z) {
                        synchronized (this) {
                            if (this.f11036p == 0) {
                                if (j2 <= this.f11041u) {
                                    z2 = false;
                                }
                            } else if (getLargestReadTimestampUs() >= j2) {
                                z2 = false;
                            } else {
                                m2746d(this.f11037q + m2744b(j2));
                            }
                        }
                        if (z2) {
                            this.f11020G = false;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                m2743a(j2, i4, (this.f11021a.f7986g - i2) - i3, i2, cryptoData);
            }
        }
        i4 = i;
        if (this.f11020G) {
        }
        m2743a(j2, i4, (this.f11021a.f7986g - i2) - i3, i2, cryptoData);
    }

    public final synchronized boolean seekTo(int i) {
        m2753k();
        int i2 = this.f11037q;
        if (i >= i2 && i <= this.f11036p + i2) {
            this.f11040t = Long.MIN_VALUE;
            this.f11039s = i - i2;
            return true;
        }
        return false;
    }

    public final void setSampleOffsetUs(long j) {
        if (this.f11019F != j) {
            this.f11019F = j;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setStartTimeUs(long j) {
        this.f11040t = j;
    }

    public final void setUpstreamFormatChangeListener(@Nullable UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f11026f = upstreamFormatChangedListener;
    }

    public final synchronized void skip(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.f11039s + i <= this.f11036p) {
                    z = true;
                    Assertions.checkArgument(z);
                    this.f11039s += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        Assertions.checkArgument(z);
        this.f11039s += i;
    }

    public final void sourceId(int i) {
        this.f11016C = i;
    }

    public final void splice() {
        this.f11020G = true;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
        dv2.m4621b(this, parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(DataReader dataReader, int i, boolean z, int i2) {
        be2 be2Var = this.f11021a;
        int m2091b = be2Var.m2091b(i);
        ae2 ae2Var = be2Var.f7985f;
        Allocation allocation = ae2Var.f153c;
        int read = dataReader.read(allocation.data, ((int) (be2Var.f7986g - ae2Var.f151a)) + allocation.offset, m2091b);
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        long j = be2Var.f7986g + read;
        be2Var.f7986g = j;
        ae2 ae2Var2 = be2Var.f7985f;
        if (j != ae2Var2.f152b) {
            return read;
        }
        be2Var.f7985f = ae2Var2.f154d;
        return read;
    }

    @Deprecated
    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager.setPlayer(looper, PlayerId.UNSET);
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    public final synchronized boolean seekTo(long j, boolean z) {
        m2753k();
        int m2749g = m2749g(this.f11039s);
        if (m2750h() && j >= this.f11034n[m2749g] && (j <= this.f11042v || z)) {
            int m2747e = m2747e(true, m2749g, this.f11036p - this.f11039s, j);
            if (m2747e == -1) {
                return false;
            }
            this.f11040t = j;
            this.f11039s += m2747e;
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        while (true) {
            be2 be2Var = this.f11021a;
            if (i > 0) {
                int m2091b = be2Var.m2091b(i);
                ae2 ae2Var = be2Var.f7985f;
                Allocation allocation = ae2Var.f153c;
                parsableByteArray.readBytes(allocation.data, ((int) (be2Var.f7986g - ae2Var.f151a)) + allocation.offset, m2091b);
                i -= m2091b;
                long j = be2Var.f7986g + m2091b;
                be2Var.f7986g = j;
                ae2 ae2Var2 = be2Var.f7985f;
                if (j == ae2Var2.f152b) {
                    be2Var.f7985f = ae2Var2.f154d;
                }
            } else {
                be2Var.getClass();
                return;
            }
        }
    }

    public final void reset() {
        reset(false);
    }
}
