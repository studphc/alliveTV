package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class AdtsExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new C1255h3(4);
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS = 2;

    /* renamed from: a */
    public final int f10365a;

    /* renamed from: b */
    public final AdtsReader f10366b;

    /* renamed from: c */
    public final ParsableByteArray f10367c;

    /* renamed from: d */
    public final ParsableByteArray f10368d;

    /* renamed from: e */
    public final ParsableBitArray f10369e;

    /* renamed from: f */
    public ExtractorOutput f10370f;

    /* renamed from: g */
    public long f10371g;

    /* renamed from: h */
    public long f10372h;

    /* renamed from: i */
    public int f10373i;

    /* renamed from: j */
    public boolean f10374j;

    /* renamed from: k */
    public boolean f10375k;

    /* renamed from: l */
    public boolean f10376l;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    /* renamed from: a */
    public final int m2562a(ExtractorInput extractorInput) {
        int i = 0;
        while (true) {
            ParsableByteArray parsableByteArray = this.f10368d;
            extractorInput.peekFully(parsableByteArray.getData(), 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            i += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        if (this.f10372h == -1) {
            this.f10372h = i;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10370f = extractorOutput;
        this.f10366b.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0089, code lost:
    
        r19.f10374j = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0092, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("Malformed ADTS stream", null);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i;
        int read;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Assertions.checkStateNotNull(this.f10370f);
        long length = extractorInput.getLength();
        int i2 = this.f10365a;
        int i3 = i2 & 2;
        int i4 = 4;
        if (i3 != 0 || ((i2 & 1) != 0 && length != -1)) {
            ParsableBitArray parsableBitArray = this.f10369e;
            ParsableByteArray parsableByteArray = this.f10368d;
            if (!this.f10374j) {
                this.f10373i = -1;
                extractorInput.resetPeekPosition();
                long j = 0;
                if (extractorInput.getPosition() == 0) {
                    m2562a(extractorInput);
                }
                int i5 = 0;
                while (true) {
                    try {
                        if (!extractorInput.peekFully(parsableByteArray.getData(), 0, 2, true)) {
                            break;
                        }
                        parsableByteArray.setPosition(0);
                        if (!AdtsReader.isAdtsSyncWord(parsableByteArray.readUnsignedShort())) {
                            i5 = 0;
                            break;
                        }
                        if (!extractorInput.peekFully(parsableByteArray.getData(), 0, i4, true)) {
                            break;
                        }
                        parsableBitArray.setPosition(14);
                        int readBits = parsableBitArray.readBits(13);
                        if (readBits <= 6) {
                            break;
                        }
                        j += readBits;
                        i5++;
                        if (i5 != 1000 && extractorInput.advancePeekPosition(readBits - 6, true)) {
                            i4 = 4;
                        }
                    } catch (EOFException unused) {
                    }
                }
                extractorInput.resetPeekPosition();
                if (i5 > 0) {
                    this.f10373i = (int) (j / i5);
                    i = -1;
                } else {
                    i = -1;
                    this.f10373i = -1;
                }
                this.f10374j = true;
                ParsableByteArray parsableByteArray2 = this.f10367c;
                read = extractorInput.read(parsableByteArray2.getData(), 0, 2048);
                if (read != i) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = this.f10376l;
                AdtsReader adtsReader = this.f10366b;
                if (!z2) {
                    if ((i2 & 1) != 0 && this.f10373i > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3 || adtsReader.getSampleDurationUs() != C0643C.TIME_UNSET || z) {
                        if (z3 && adtsReader.getSampleDurationUs() != C0643C.TIME_UNSET) {
                            ExtractorOutput extractorOutput = this.f10370f;
                            if (i3 != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            extractorOutput.seekMap(new ConstantBitrateSeekMap(length, this.f10372h, (int) ((this.f10373i * 8000000) / adtsReader.getSampleDurationUs()), this.f10373i, z4));
                        } else {
                            this.f10370f.seekMap(new SeekMap.Unseekable(C0643C.TIME_UNSET));
                        }
                        this.f10376l = true;
                    }
                }
                if (!z) {
                    return -1;
                }
                parsableByteArray2.setPosition(0);
                parsableByteArray2.setLimit(read);
                if (!this.f10375k) {
                    adtsReader.packetStarted(this.f10371g, 4);
                    this.f10375k = true;
                }
                adtsReader.consume(parsableByteArray2);
                return 0;
            }
        }
        i = -1;
        ParsableByteArray parsableByteArray22 = this.f10367c;
        read = extractorInput.read(parsableByteArray22.getData(), 0, 2048);
        if (read != i) {
        }
        z2 = this.f10376l;
        AdtsReader adtsReader2 = this.f10366b;
        if (!z2) {
        }
        if (!z) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f10375k = false;
        this.f10366b.seek();
        this.f10371g = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        int m2562a = m2562a(extractorInput);
        int i = m2562a;
        int i2 = 0;
        int i3 = 0;
        do {
            ParsableByteArray parsableByteArray = this.f10368d;
            extractorInput.peekFully(parsableByteArray.getData(), 0, 2);
            parsableByteArray.setPosition(0);
            if (!AdtsReader.isAdtsSyncWord(parsableByteArray.readUnsignedShort())) {
                i++;
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i);
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
                ParsableBitArray parsableBitArray = this.f10369e;
                parsableBitArray.setPosition(14);
                int readBits = parsableBitArray.readBits(13);
                if (readBits <= 6) {
                    i++;
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(i);
                } else {
                    extractorInput.advancePeekPosition(readBits - 6);
                    i3 += readBits;
                }
            }
            i2 = 0;
            i3 = 0;
        } while (i - m2562a < 8192);
        return false;
    }

    public AdtsExtractor(int i) {
        this.f10365a = (i & 2) != 0 ? i | 1 : i;
        this.f10366b = new AdtsReader(true);
        this.f10367c = new ParsableByteArray(2048);
        this.f10373i = -1;
        this.f10372h = -1L;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f10368d = parsableByteArray;
        this.f10369e = new ParsableBitArray(parsableByteArray.getData());
    }
}
