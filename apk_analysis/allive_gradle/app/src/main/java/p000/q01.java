package p000;

import android.net.Uri;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class q01 extends MediaChunk {

    /* renamed from: C */
    public static final AtomicInteger f25364C = new AtomicInteger();

    /* renamed from: A */
    public boolean f25365A;

    /* renamed from: B */
    public boolean f25366B;

    /* renamed from: a */
    public final int f25367a;

    /* renamed from: b */
    public final int f25368b;

    /* renamed from: c */
    public final Uri f25369c;

    /* renamed from: d */
    public final boolean f25370d;

    /* renamed from: e */
    public final int f25371e;

    /* renamed from: f */
    public final DataSource f25372f;

    /* renamed from: g */
    public final DataSpec f25373g;

    /* renamed from: h */
    public final HlsMediaChunkExtractor f25374h;

    /* renamed from: i */
    public final boolean f25375i;

    /* renamed from: j */
    public final boolean f25376j;

    /* renamed from: k */
    public final TimestampAdjuster f25377k;

    /* renamed from: l */
    public final HlsExtractorFactory f25378l;

    /* renamed from: m */
    public final List f25379m;

    /* renamed from: n */
    public final DrmInitData f25380n;

    /* renamed from: o */
    public final Id3Decoder f25381o;

    /* renamed from: p */
    public final ParsableByteArray f25382p;

    /* renamed from: q */
    public final boolean f25383q;

    /* renamed from: r */
    public final boolean f25384r;

    /* renamed from: s */
    public final PlayerId f25385s;

    /* renamed from: t */
    public HlsMediaChunkExtractor f25386t;

    /* renamed from: u */
    public v01 f25387u;

    /* renamed from: v */
    public int f25388v;

    /* renamed from: w */
    public boolean f25389w;

    /* renamed from: x */
    public volatile boolean f25390x;

    /* renamed from: y */
    public boolean f25391y;

    /* renamed from: z */
    public ImmutableList f25392z;

    public q01(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z, DataSource dataSource2, DataSpec dataSpec2, boolean z2, Uri uri, List list, int i, Object obj, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, TimestampAdjuster timestampAdjuster, DrmInitData drmInitData, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean z6, PlayerId playerId) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3);
        this.f25383q = z;
        this.f25371e = i2;
        this.f25366B = z3;
        this.f25368b = i3;
        this.f25373g = dataSpec2;
        this.f25372f = dataSource2;
        this.f25389w = dataSpec2 != null;
        this.f25384r = z2;
        this.f25369c = uri;
        this.f25375i = z5;
        this.f25377k = timestampAdjuster;
        this.f25376j = z4;
        this.f25378l = hlsExtractorFactory;
        this.f25379m = list;
        this.f25380n = drmInitData;
        this.f25374h = hlsMediaChunkExtractor;
        this.f25381o = id3Decoder;
        this.f25382p = parsableByteArray;
        this.f25370d = z6;
        this.f25385s = playerId;
        this.f25392z = ImmutableList.m3902of();
        this.f25367a = f25364C.getAndIncrement();
    }

    /* renamed from: b */
    public static byte[] m6942b(String str) {
        int i;
        if (Ascii.toLowerCase(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        if (byteArray.length > 16) {
            i = byteArray.length - 16;
        } else {
            i = 0;
        }
        System.arraycopy(byteArray, i, bArr, (16 - byteArray.length) + i, byteArray.length - i);
        return bArr;
    }

    /* renamed from: a */
    public final void m6943a(DataSource dataSource, DataSpec dataSpec, boolean z, boolean z2) {
        DataSpec subrange;
        long position;
        long j;
        boolean z3 = false;
        if (z) {
            if (this.f25388v != 0) {
                z3 = true;
            }
            subrange = dataSpec;
        } else {
            subrange = dataSpec.subrange(this.f25388v);
        }
        try {
            DefaultExtractorInput m6944c = m6944c(dataSource, subrange, z2);
            if (z3) {
                m6944c.skipFully(this.f25388v);
            }
            while (!this.f25390x && this.f25386t.read(m6944c)) {
                try {
                    try {
                    } catch (EOFException e) {
                        if ((this.trackFormat.roleFlags & 16384) != 0) {
                            this.f25386t.onTruncatedSegmentParsed();
                            position = m6944c.getPosition();
                            j = dataSpec.position;
                        } else {
                            throw e;
                        }
                    }
                } catch (Throwable th) {
                    this.f25388v = (int) (m6944c.getPosition() - dataSpec.position);
                    throw th;
                }
            }
            position = m6944c.getPosition();
            j = dataSpec.position;
            this.f25388v = (int) (position - j);
        } finally {
            DataSourceUtil.closeQuietly(dataSource);
        }
    }

    /* renamed from: c */
    public final DefaultExtractorInput m6944c(DataSource dataSource, DataSpec dataSpec, boolean z) {
        DefaultExtractorInput defaultExtractorInput;
        long j;
        long j2;
        HlsMediaChunkExtractor createExtractor;
        long j3;
        long open = dataSource.open(dataSpec);
        TimestampAdjuster timestampAdjuster = this.f25377k;
        if (z) {
            try {
                timestampAdjuster.sharedInitializeOrWait(this.f25375i, this.startTimeUs);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(dataSource, dataSpec.position, open);
        int i = 0;
        if (this.f25386t == null) {
            ParsableByteArray parsableByteArray = this.f25382p;
            defaultExtractorInput2.resetPeekPosition();
            try {
                parsableByteArray.reset(10);
                defaultExtractorInput2.peekFully(parsableByteArray.getData(), 0, 10);
                if (parsableByteArray.readUnsignedInt24() == 4801587) {
                    parsableByteArray.skipBytes(3);
                    int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
                    int i2 = readSynchSafeInt + 10;
                    if (i2 > parsableByteArray.capacity()) {
                        byte[] data = parsableByteArray.getData();
                        parsableByteArray.reset(i2);
                        System.arraycopy(data, 0, parsableByteArray.getData(), 0, 10);
                    }
                    defaultExtractorInput2.peekFully(parsableByteArray.getData(), 10, readSynchSafeInt);
                    Metadata decode = this.f25381o.decode(parsableByteArray.getData(), readSynchSafeInt);
                    if (decode != null) {
                        int length = decode.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            Metadata.Entry entry = decode.get(i3);
                            if (entry instanceof PrivFrame) {
                                PrivFrame privFrame = (PrivFrame) entry;
                                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                                    System.arraycopy(privFrame.privateData, 0, parsableByteArray.getData(), 0, 8);
                                    parsableByteArray.setPosition(0);
                                    parsableByteArray.setLimit(8);
                                    j = parsableByteArray.readLong() & 8589934591L;
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (EOFException unused2) {
            }
            j = -9223372036854775807L;
            defaultExtractorInput2.resetPeekPosition();
            HlsMediaChunkExtractor hlsMediaChunkExtractor = this.f25374h;
            if (hlsMediaChunkExtractor != null) {
                createExtractor = hlsMediaChunkExtractor.recreate();
                j2 = j;
                defaultExtractorInput = defaultExtractorInput2;
            } else {
                j2 = j;
                defaultExtractorInput = defaultExtractorInput2;
                createExtractor = this.f25378l.createExtractor(dataSpec.uri, this.trackFormat, this.f25379m, this.f25377k, dataSource.getResponseHeaders(), defaultExtractorInput2, this.f25385s);
            }
            this.f25386t = createExtractor;
            if (createExtractor.isPackedAudioExtractor()) {
                v01 v01Var = this.f25387u;
                long j4 = j2;
                if (j4 != C0643C.TIME_UNSET) {
                    j3 = timestampAdjuster.adjustTsTimestamp(j4);
                } else {
                    j3 = this.startTimeUs;
                }
                if (v01Var.f27584V != j3) {
                    v01Var.f27584V = j3;
                    for (u01 u01Var : v01Var.f27608v) {
                        u01Var.setSampleOffsetUs(j3);
                    }
                }
            } else {
                v01 v01Var2 = this.f25387u;
                if (v01Var2.f27584V != 0) {
                    v01Var2.f27584V = 0L;
                    for (u01 u01Var2 : v01Var2.f27608v) {
                        u01Var2.setSampleOffsetUs(0L);
                    }
                }
            }
            this.f25387u.f27610x.clear();
            this.f25386t.init(this.f25387u);
        } else {
            defaultExtractorInput = defaultExtractorInput2;
        }
        v01 v01Var3 = this.f25387u;
        DrmInitData drmInitData = v01Var3.f27585W;
        DrmInitData drmInitData2 = this.f25380n;
        if (!Util.areEqual(drmInitData, drmInitData2)) {
            v01Var3.f27585W = drmInitData2;
            while (true) {
                u01[] u01VarArr = v01Var3.f27608v;
                if (i >= u01VarArr.length) {
                    break;
                }
                if (v01Var3.f27577O[i]) {
                    u01 u01Var3 = u01VarArr[i];
                    u01Var3.f27056I = drmInitData2;
                    u01Var3.invalidateUpstreamFormatAdjustment();
                }
                i++;
            }
        }
        return defaultExtractorInput;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.f25390x = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getFirstSampleIndex(int i) {
        Assertions.checkState(!this.f25370d);
        if (i >= this.f25392z.size()) {
            return 0;
        }
        return ((Integer) this.f25392z.get(i)).intValue();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public final boolean isLoadCompleted() {
        return this.f25391y;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        Assertions.checkNotNull(this.f25387u);
        if (this.f25386t == null && (hlsMediaChunkExtractor = this.f25374h) != null && hlsMediaChunkExtractor.isReusable()) {
            this.f25386t = this.f25374h;
            this.f25389w = false;
        }
        if (this.f25389w) {
            DataSource dataSource = this.f25372f;
            Assertions.checkNotNull(dataSource);
            DataSpec dataSpec = this.f25373g;
            Assertions.checkNotNull(dataSpec);
            m6943a(dataSource, dataSpec, this.f25384r, false);
            this.f25388v = 0;
            this.f25389w = false;
        }
        if (!this.f25390x) {
            if (!this.f25376j) {
                m6943a(this.dataSource, this.dataSpec, this.f25383q, true);
            }
            this.f25391y = !this.f25390x;
        }
    }
}
