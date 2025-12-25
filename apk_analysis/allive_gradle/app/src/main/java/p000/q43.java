package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import okhttp3.internal.http.HttpStatusCodesKt;

/* loaded from: classes.dex */
public final class q43 implements r43 {

    /* renamed from: m */
    public static final int[] f25432m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* renamed from: n */
    public static final int[] f25433n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, HttpStatusCodesKt.HTTP_CLIENT_TIMEOUT, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: a */
    public final ExtractorOutput f25434a;

    /* renamed from: b */
    public final TrackOutput f25435b;

    /* renamed from: c */
    public final C1682pc f25436c;

    /* renamed from: d */
    public final int f25437d;

    /* renamed from: e */
    public final byte[] f25438e;

    /* renamed from: f */
    public final ParsableByteArray f25439f;

    /* renamed from: g */
    public final int f25440g;

    /* renamed from: h */
    public final Format f25441h;

    /* renamed from: i */
    public int f25442i;

    /* renamed from: j */
    public long f25443j;

    /* renamed from: k */
    public int f25444k;

    /* renamed from: l */
    public long f25445l;

    public q43(ExtractorOutput extractorOutput, TrackOutput trackOutput, C1682pc c1682pc) {
        this.f25434a = extractorOutput;
        this.f25435b = trackOutput;
        this.f25436c = c1682pc;
        int i = c1682pc.f25113b;
        int max = Math.max(1, i / 10);
        this.f25440g = max;
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[]) c1682pc.f25116e);
        parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        this.f25437d = readLittleEndianUnsignedShort;
        int i2 = c1682pc.f25112a;
        int i3 = c1682pc.f25114c;
        int i4 = (((i3 - (i2 * 4)) * 8) / (c1682pc.f25115d * i2)) + 1;
        if (readLittleEndianUnsignedShort == i4) {
            int ceilDivide = Util.ceilDivide(max, readLittleEndianUnsignedShort);
            this.f25438e = new byte[ceilDivide * i3];
            this.f25439f = new ParsableByteArray(readLittleEndianUnsignedShort * 2 * i2 * ceilDivide);
            int i5 = ((i3 * i) * 8) / readLittleEndianUnsignedShort;
            this.f25441h = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setAverageBitrate(i5).setPeakBitrate(i5).setMaxInputSize(max * 2 * i2).setChannelCount(i2).setSampleRate(i).setPcmEncoding(2).build();
            return;
        }
        throw ParserException.createForMalformedContainer("Expected frames per block: " + i4 + "; got: " + readLittleEndianUnsignedShort, null);
    }

    @Override // p000.r43
    /* renamed from: a */
    public final void mo6996a(long j) {
        this.f25442i = 0;
        this.f25443j = j;
        this.f25444k = 0;
        this.f25445l = 0L;
    }

    @Override // p000.r43
    /* renamed from: b */
    public final void mo6997b(int i, long j) {
        this.f25434a.seekMap(new u43(this.f25436c, this.f25437d, i, j));
        this.f25435b.format(this.f25441h);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0045 A[ADDED_TO_REGION, EDGE_INSN: B:50:0x0045->B:14:0x0045 BREAK  A[LOOP:0: B:5:0x0023->B:11:0x003f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003c -> B:3:0x0020). Please report as a decompilation issue!!! */
    @Override // p000.r43
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean mo6998c(com.google.android.exoplayer2.extractor.ExtractorInput r26, long r27) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.q43.mo6998c(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
    }

    /* renamed from: d */
    public final void m6999d(int i) {
        long j = this.f25443j;
        long j2 = this.f25445l;
        C1682pc c1682pc = this.f25436c;
        long scaleLargeTimestamp = j + Util.scaleLargeTimestamp(j2, 1000000L, c1682pc.f25113b);
        int i2 = i * 2 * c1682pc.f25112a;
        this.f25435b.sampleMetadata(scaleLargeTimestamp, 1, i2, this.f25444k - i2, null);
        this.f25445l += i;
        this.f25444k -= i2;
    }
}
