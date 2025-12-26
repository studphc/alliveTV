package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.C1294i5;
import p000.ee0;
import p000.pe0;
import p000.qe0;

/* loaded from: classes.dex */
public final class FlacExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ee0(2);
    public static final int FLAG_DISABLE_ID3_METADATA = 1;

    /* renamed from: a */
    public final byte[] f10144a;

    /* renamed from: b */
    public final ParsableByteArray f10145b;

    /* renamed from: c */
    public final boolean f10146c;

    /* renamed from: d */
    public final FlacFrameReader.SampleNumberHolder f10147d;

    /* renamed from: e */
    public ExtractorOutput f10148e;

    /* renamed from: f */
    public TrackOutput f10149f;

    /* renamed from: g */
    public int f10150g;

    /* renamed from: h */
    public Metadata f10151h;

    /* renamed from: i */
    public FlacStreamMetadata f10152i;

    /* renamed from: j */
    public int f10153j;

    /* renamed from: k */
    public int f10154k;

    /* renamed from: l */
    public qe0 f10155l;

    /* renamed from: m */
    public int f10156m;

    /* renamed from: n */
    public long f10157n;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    /* renamed from: a */
    public final void m2537a() {
        ((TrackOutput) Util.castNonNull(this.f10149f)).sampleMetadata((this.f10157n * 1000000) / ((FlacStreamMetadata) Util.castNonNull(this.f10152i)).sampleRate, 1, this.f10156m, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10148e = extractorOutput;
        this.f10149f = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.exoplayer2.extractor.BinarySearchSeeker, qe0] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        SeekMap unseekable;
        long j;
        boolean z;
        int i = this.f10150g;
        boolean z2 = true;
        if (i != 0) {
            byte[] bArr = this.f10144a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                Assertions.checkNotNull(this.f10149f);
                                Assertions.checkNotNull(this.f10152i);
                                qe0 qe0Var = this.f10155l;
                                if (qe0Var != null && qe0Var.isSeeking()) {
                                    return this.f10155l.handlePendingSeek(extractorInput, positionHolder);
                                }
                                if (this.f10157n == -1) {
                                    this.f10157n = FlacFrameReader.getFirstSampleNumber(extractorInput, this.f10152i);
                                    return 0;
                                }
                                ParsableByteArray parsableByteArray = this.f10145b;
                                int limit = parsableByteArray.limit();
                                if (limit < 32768) {
                                    int read = extractorInput.read(parsableByteArray.getData(), limit, 32768 - limit);
                                    if (read != -1) {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        parsableByteArray.setLimit(limit + read);
                                    } else if (parsableByteArray.bytesLeft() == 0) {
                                        m2537a();
                                        return -1;
                                    }
                                } else {
                                    z2 = false;
                                }
                                int position = parsableByteArray.getPosition();
                                int i2 = this.f10156m;
                                int i3 = this.f10153j;
                                if (i2 < i3) {
                                    parsableByteArray.skipBytes(Math.min(i3 - i2, parsableByteArray.bytesLeft()));
                                }
                                Assertions.checkNotNull(this.f10152i);
                                int position2 = parsableByteArray.getPosition();
                                while (true) {
                                    int limit2 = parsableByteArray.limit() - 16;
                                    FlacFrameReader.SampleNumberHolder sampleNumberHolder = this.f10147d;
                                    if (position2 <= limit2) {
                                        parsableByteArray.setPosition(position2);
                                        if (FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, this.f10152i, this.f10154k, sampleNumberHolder)) {
                                            parsableByteArray.setPosition(position2);
                                            j = sampleNumberHolder.sampleNumber;
                                            break;
                                        }
                                        position2++;
                                    } else {
                                        if (z2) {
                                            while (position2 <= parsableByteArray.limit() - this.f10153j) {
                                                parsableByteArray.setPosition(position2);
                                                try {
                                                    z = FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, this.f10152i, this.f10154k, sampleNumberHolder);
                                                } catch (IndexOutOfBoundsException unused) {
                                                    z = false;
                                                }
                                                if (parsableByteArray.getPosition() > parsableByteArray.limit()) {
                                                    z = false;
                                                }
                                                if (z) {
                                                    parsableByteArray.setPosition(position2);
                                                    j = sampleNumberHolder.sampleNumber;
                                                    break;
                                                }
                                                position2++;
                                            }
                                            parsableByteArray.setPosition(parsableByteArray.limit());
                                        } else {
                                            parsableByteArray.setPosition(position2);
                                        }
                                        j = -1;
                                    }
                                }
                                int position3 = parsableByteArray.getPosition() - position;
                                parsableByteArray.setPosition(position);
                                this.f10149f.sampleData(parsableByteArray, position3);
                                this.f10156m += position3;
                                if (j != -1) {
                                    m2537a();
                                    this.f10156m = 0;
                                    this.f10157n = j;
                                }
                                if (parsableByteArray.bytesLeft() >= 16) {
                                    return 0;
                                }
                                int bytesLeft = parsableByteArray.bytesLeft();
                                System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray.getData(), 0, bytesLeft);
                                parsableByteArray.setPosition(0);
                                parsableByteArray.setLimit(bytesLeft);
                                return 0;
                            }
                            throw new IllegalStateException();
                        }
                        this.f10154k = FlacMetadataReader.getFrameStartMarker(extractorInput);
                        ExtractorOutput extractorOutput = (ExtractorOutput) Util.castNonNull(this.f10148e);
                        long position4 = extractorInput.getPosition();
                        long length = extractorInput.getLength();
                        Assertions.checkNotNull(this.f10152i);
                        FlacStreamMetadata flacStreamMetadata = this.f10152i;
                        if (flacStreamMetadata.seekTable != null) {
                            unseekable = new FlacSeekTableSeekMap(flacStreamMetadata, position4);
                        } else if (length != -1 && flacStreamMetadata.totalSamples > 0) {
                            ?? binarySearchSeeker = new BinarySearchSeeker(new C1294i5(14, flacStreamMetadata), new pe0(flacStreamMetadata, this.f10154k), flacStreamMetadata.getDurationUs(), 0L, flacStreamMetadata.totalSamples, position4, length, flacStreamMetadata.getApproxBytesPerFrame(), Math.max(6, flacStreamMetadata.minFrameSize));
                            this.f10155l = binarySearchSeeker;
                            unseekable = binarySearchSeeker.getSeekMap();
                        } else {
                            unseekable = new SeekMap.Unseekable(flacStreamMetadata.getDurationUs());
                        }
                        extractorOutput.seekMap(unseekable);
                        this.f10150g = 5;
                        return 0;
                    }
                    FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.f10152i);
                    boolean z3 = false;
                    while (!z3) {
                        z3 = FlacMetadataReader.readMetadataBlock(extractorInput, flacStreamMetadataHolder);
                        this.f10152i = (FlacStreamMetadata) Util.castNonNull(flacStreamMetadataHolder.flacStreamMetadata);
                    }
                    Assertions.checkNotNull(this.f10152i);
                    this.f10153j = Math.max(this.f10152i.minFrameSize, 6);
                    ((TrackOutput) Util.castNonNull(this.f10149f)).format(this.f10152i.getFormat(bArr, this.f10151h));
                    this.f10150g = 4;
                    return 0;
                }
                FlacMetadataReader.readStreamMarker(extractorInput);
                this.f10150g = 3;
                return 0;
            }
            extractorInput.peekFully(bArr, 0, bArr.length);
            extractorInput.resetPeekPosition();
            this.f10150g = 2;
            return 0;
        }
        this.f10151h = FlacMetadataReader.readId3Metadata(extractorInput, !this.f10146c);
        this.f10150g = 1;
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.f10150g = 0;
        } else {
            qe0 qe0Var = this.f10155l;
            if (qe0Var != null) {
                qe0Var.setSeekTargetUs(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.f10157n = j3;
        this.f10156m = 0;
        this.f10145b.reset(0);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        FlacMetadataReader.peekId3Metadata(extractorInput, false);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput);
    }

    public FlacExtractor(int i) {
        this.f10144a = new byte[42];
        this.f10145b = new ParsableByteArray(new byte[32768], 0);
        this.f10146c = (i & 1) != 0;
        this.f10147d = new FlacFrameReader.SampleNumberHolder();
        this.f10150g = 0;
    }
}
