package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import p000.o63;
import p000.q43;
import p000.r43;
import p000.s43;
import p000.t43;
import p000.t82;

/* loaded from: classes.dex */
public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new t82(22);

    /* renamed from: a */
    public ExtractorOutput f10582a;

    /* renamed from: b */
    public TrackOutput f10583b;

    /* renamed from: e */
    public r43 f10586e;

    /* renamed from: c */
    public int f10584c = 0;

    /* renamed from: d */
    public long f10585d = -1;

    /* renamed from: f */
    public int f10587f = -1;

    /* renamed from: g */
    public long f10588g = -1;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10582a = extractorOutput;
        this.f10583b = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [pc, java.lang.Object] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z;
        byte[] bArr;
        Assertions.checkStateNotNull(this.f10583b);
        Util.castNonNull(this.f10582a);
        int i = this.f10584c;
        boolean z2 = true;
        if (i != 0) {
            long j = -1;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.f10588g == -1) {
                                z2 = false;
                            }
                            Assertions.checkState(z2);
                            if (((r43) Assertions.checkNotNull(this.f10586e)).mo6998c(extractorInput, this.f10588g - extractorInput.getPosition())) {
                                return -1;
                            }
                            return 0;
                        }
                        throw new IllegalStateException();
                    }
                    extractorInput.resetPeekPosition();
                    t43 m6452L = o63.m6452L(WavUtil.DATA_FOURCC, extractorInput, new ParsableByteArray(8));
                    extractorInput.skipFully(8);
                    Pair create = Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(m6452L.f26694b));
                    this.f10587f = ((Long) create.first).intValue();
                    long longValue = ((Long) create.second).longValue();
                    long j2 = this.f10585d;
                    if (j2 != -1 && longValue == 4294967295L) {
                        longValue = j2;
                    }
                    this.f10588g = this.f10587f + longValue;
                    long length = extractorInput.getLength();
                    if (length != -1 && this.f10588g > length) {
                        Log.m3027w("WavExtractor", "Data exceeds input length: " + this.f10588g + ", " + length);
                        this.f10588g = length;
                    }
                    ((r43) Assertions.checkNotNull(this.f10586e)).mo6997b(this.f10587f, this.f10588g);
                    this.f10584c = 4;
                    return 0;
                }
                ParsableByteArray parsableByteArray = new ParsableByteArray(16);
                long j3 = o63.m6452L(WavUtil.FMT_FOURCC, extractorInput, parsableByteArray).f26694b;
                if (j3 < 16) {
                    z2 = false;
                }
                Assertions.checkState(z2);
                extractorInput.peekFully(parsableByteArray.getData(), 0, 16);
                parsableByteArray.setPosition(0);
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
                int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
                parsableByteArray.readLittleEndianUnsignedIntToInt();
                int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
                int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
                int i2 = ((int) j3) - 16;
                if (i2 > 0) {
                    bArr = new byte[i2];
                    extractorInput.peekFully(bArr, 0, i2);
                } else {
                    bArr = Util.EMPTY_BYTE_ARRAY;
                }
                extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
                ?? obj = new Object();
                obj.f25112a = readLittleEndianUnsignedShort2;
                obj.f25113b = readLittleEndianUnsignedIntToInt;
                obj.f25114c = readLittleEndianUnsignedShort3;
                obj.f25115d = readLittleEndianUnsignedShort4;
                obj.f25116e = bArr;
                if (readLittleEndianUnsignedShort == 17) {
                    this.f10586e = new q43(this.f10582a, this.f10583b, obj);
                } else if (readLittleEndianUnsignedShort == 6) {
                    this.f10586e = new s43(this.f10582a, this.f10583b, obj, MimeTypes.AUDIO_ALAW, -1);
                } else if (readLittleEndianUnsignedShort == 7) {
                    this.f10586e = new s43(this.f10582a, this.f10583b, obj, MimeTypes.AUDIO_MLAW, -1);
                } else {
                    int pcmEncodingForType = WavUtil.getPcmEncodingForType(readLittleEndianUnsignedShort, readLittleEndianUnsignedShort4);
                    if (pcmEncodingForType != 0) {
                        this.f10586e = new s43(this.f10582a, this.f10583b, obj, MimeTypes.AUDIO_RAW, pcmEncodingForType);
                    } else {
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + readLittleEndianUnsignedShort);
                    }
                }
                this.f10584c = 3;
                return 0;
            }
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(8);
            t43 m7449a = t43.m7449a(extractorInput, parsableByteArray2);
            if (m7449a.f26693a != 1685272116) {
                extractorInput.resetPeekPosition();
            } else {
                extractorInput.advancePeekPosition(8);
                parsableByteArray2.setPosition(0);
                extractorInput.peekFully(parsableByteArray2.getData(), 0, 8);
                j = parsableByteArray2.readLittleEndianLong();
                extractorInput.skipFully(((int) m7449a.f26694b) + 8);
            }
            this.f10585d = j;
            this.f10584c = 2;
            return 0;
        }
        if (extractorInput.getPosition() == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        int i3 = this.f10587f;
        if (i3 != -1) {
            extractorInput.skipFully(i3);
            this.f10584c = 4;
        } else if (o63.m6464g(extractorInput)) {
            extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
            this.f10584c = 1;
        } else {
            throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        int i;
        if (j == 0) {
            i = 0;
        } else {
            i = 4;
        }
        this.f10584c = i;
        r43 r43Var = this.f10586e;
        if (r43Var != null) {
            r43Var.mo6996a(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        return o63.m6464g(extractorInput);
    }
}
