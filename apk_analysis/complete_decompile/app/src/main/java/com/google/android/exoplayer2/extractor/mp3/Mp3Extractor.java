package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.C0534av;
import p000.e13;
import p000.ee0;
import p000.f41;
import p000.jo1;
import p000.k63;
import p000.tf2;

/* loaded from: classes.dex */
public final class Mp3Extractor implements Extractor {
    public static final int FLAG_DISABLE_ID3_METADATA = 8;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS = 2;
    public static final int FLAG_ENABLE_INDEX_SEEKING = 4;

    /* renamed from: a */
    public final int f10249a;

    /* renamed from: b */
    public final long f10250b;

    /* renamed from: c */
    public final ParsableByteArray f10251c;

    /* renamed from: d */
    public final MpegAudioUtil.Header f10252d;

    /* renamed from: e */
    public final GaplessInfoHolder f10253e;

    /* renamed from: f */
    public final Id3Peeker f10254f;

    /* renamed from: g */
    public final DummyTrackOutput f10255g;

    /* renamed from: h */
    public ExtractorOutput f10256h;

    /* renamed from: i */
    public TrackOutput f10257i;

    /* renamed from: j */
    public TrackOutput f10258j;

    /* renamed from: k */
    public int f10259k;

    /* renamed from: l */
    public Metadata f10260l;

    /* renamed from: m */
    public long f10261m;

    /* renamed from: n */
    public long f10262n;

    /* renamed from: o */
    public long f10263o;

    /* renamed from: p */
    public int f10264p;

    /* renamed from: q */
    public tf2 f10265q;

    /* renamed from: r */
    public boolean f10266r;

    /* renamed from: s */
    public boolean f10267s;

    /* renamed from: t */
    public long f10268t;
    public static final ExtractorsFactory FACTORY = new ee0(19);

    /* renamed from: u */
    public static final ee0 f10248u = new ee0(20);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    /* renamed from: b */
    public static long m2552b(Metadata metadata) {
        if (metadata != null) {
            int length = metadata.length();
            for (int i = 0; i < length; i++) {
                Metadata.Entry entry = metadata.get(i);
                if (entry instanceof TextInformationFrame) {
                    TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                    if (textInformationFrame.f10763id.equals("TLEN")) {
                        return Util.msToUs(Long.parseLong(textInformationFrame.value));
                    }
                }
            }
            return C0643C.TIME_UNSET;
        }
        return C0643C.TIME_UNSET;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [av, com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap] */
    /* renamed from: a */
    public final C0534av m2553a(ExtractorInput extractorInput, boolean z) {
        ParsableByteArray parsableByteArray = this.f10251c;
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        MpegAudioUtil.Header header = this.f10252d;
        header.setForHeaderData(readInt);
        return new ConstantBitrateSeekMap(extractorInput.getLength(), extractorInput.getPosition(), header.bitrate, header.frameSize, z);
    }

    /* renamed from: c */
    public final boolean m2554c(ExtractorInput extractorInput) {
        tf2 tf2Var = this.f10265q;
        if (tf2Var != null) {
            long dataEndPosition = tf2Var.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.f10251c.getData(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a3, code lost:
    
        if (r19 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a5, code lost:
    
        r18.skipFully(r3 + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
    
        r17.f10259k = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00af, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00aa, code lost:
    
        r18.resetPeekPosition();
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m2555d(ExtractorInput extractorInput, boolean z) {
        int i;
        int i2;
        int i3;
        int frameSize;
        ee0 ee0Var;
        if (z) {
            i = 32768;
        } else {
            i = 131072;
        }
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            if ((this.f10249a & 8) == 0) {
                ee0Var = null;
            } else {
                ee0Var = f10248u;
            }
            Metadata peekId3Data = this.f10254f.peekId3Data(extractorInput, ee0Var);
            this.f10260l = peekId3Data;
            if (peekId3Data != null) {
                this.f10253e.setFromMetadata(peekId3Data);
            }
            i2 = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(i2);
            }
            i3 = 0;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i4 = i3;
        int i5 = i4;
        while (true) {
            if (m2554c(extractorInput)) {
                if (i4 <= 0) {
                    throw new EOFException();
                }
            } else {
                ParsableByteArray parsableByteArray = this.f10251c;
                parsableByteArray.setPosition(0);
                int readInt = parsableByteArray.readInt();
                if ((i3 != 0 && ((-128000) & readInt) != (i3 & (-128000))) || (frameSize = MpegAudioUtil.getFrameSize(readInt)) == -1) {
                    int i6 = i5 + 1;
                    if (i5 == i) {
                        if (z) {
                            return false;
                        }
                        throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                    }
                    if (z) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i2 + i6);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i4 = 0;
                    i5 = i6;
                    i3 = 0;
                } else {
                    i4++;
                    if (i4 == 1) {
                        this.f10252d.setForHeaderData(readInt);
                        i3 = readInt;
                    } else if (i4 == 4) {
                        break;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                }
            }
        }
    }

    public void disableSeeking() {
        this.f10266r = true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10256h = extractorOutput;
        TrackOutput track = extractorOutput.track(0, 1);
        this.f10257i = track;
        this.f10258j = track;
        this.f10256h.endTracks();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
    
        if (r12 != 1231971951) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02b5  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        Mp3Extractor mp3Extractor;
        int i;
        int i2;
        ExtractorInput extractorInput2;
        ParsableByteArray parsableByteArray;
        int i3;
        int i4;
        int readInt;
        int i5;
        tf2 tf2Var;
        int readUnsignedIntToInt;
        Metadata metadata;
        GaplessInfoHolder gaplessInfoHolder;
        jo1 jo1Var;
        boolean z;
        int i6;
        boolean z2;
        long m2552b;
        Metadata metadata2;
        ParsableByteArray parsableByteArray2;
        int i7;
        char c;
        int readUnsignedByte;
        Assertions.checkStateNotNull(this.f10257i);
        Util.castNonNull(this.f10256h);
        int i8 = this.f10259k;
        MpegAudioUtil.Header header = this.f10252d;
        if (i8 == 0) {
            try {
                m2555d(extractorInput, false);
            } catch (EOFException unused) {
                mp3Extractor = this;
                i = -1;
                i2 = -1;
            }
        }
        tf2 tf2Var2 = this.f10265q;
        ParsableByteArray parsableByteArray3 = this.f10251c;
        if (tf2Var2 == null) {
            ParsableByteArray parsableByteArray4 = new ParsableByteArray(header.frameSize);
            extractorInput.peekFully(parsableByteArray4.getData(), 0, header.frameSize);
            int i9 = 21;
            if ((header.version & 1) != 0) {
                if (header.channels != 1) {
                    i9 = 36;
                }
            } else if (header.channels == 1) {
                i9 = 13;
            }
            if (parsableByteArray4.limit() >= i9 + 4) {
                parsableByteArray4.setPosition(i9);
                i4 = parsableByteArray4.readInt();
                if (i4 != 1483304551) {
                }
                GaplessInfoHolder gaplessInfoHolder2 = this.f10253e;
                long j = -1;
                if (i4 != 1483304551 || i4 == 1231971951) {
                    extractorInput2 = extractorInput;
                    long length = extractorInput.getLength();
                    long position = extractorInput.getPosition();
                    int i10 = header.samplesPerFrame;
                    int i11 = header.sampleRate;
                    readInt = parsableByteArray4.readInt();
                    if ((readInt & 1) == 1 || (readUnsignedIntToInt = parsableByteArray4.readUnsignedIntToInt()) == 0) {
                        i5 = i4;
                        tf2Var = null;
                    } else {
                        i5 = i4;
                        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedIntToInt, i10 * 1000000, i11);
                        if ((readInt & 6) != 6) {
                            tf2Var = new k63(position, header.frameSize, scaleLargeTimestamp, -1L, null);
                        } else {
                            long readUnsignedInt = parsableByteArray4.readUnsignedInt();
                            long[] jArr = new long[100];
                            for (int i12 = 0; i12 < 100; i12++) {
                                jArr[i12] = parsableByteArray4.readUnsignedByte();
                            }
                            if (length != -1) {
                                long j2 = position + readUnsignedInt;
                                if (length != j2) {
                                    Log.m3027w("XingSeeker", "XING data size mismatch: " + length + ", " + j2);
                                }
                            }
                            tf2Var = new k63(position, header.frameSize, scaleLargeTimestamp, readUnsignedInt, jArr);
                        }
                    }
                    if (tf2Var == null && !gaplessInfoHolder2.hasGaplessInfo()) {
                        extractorInput.resetPeekPosition();
                        extractorInput2.advancePeekPosition(i9 + ModuleDescriptor.MODULE_VERSION);
                        extractorInput2.peekFully(parsableByteArray3.getData(), 0, 3);
                        parsableByteArray = parsableByteArray3;
                        parsableByteArray.setPosition(0);
                        gaplessInfoHolder2.setFromXingHeaderValue(parsableByteArray.readUnsignedInt24());
                    } else {
                        parsableByteArray = parsableByteArray3;
                    }
                    extractorInput2.skipFully(header.frameSize);
                    if (tf2Var == null && !tf2Var.isSeekable() && i5 == 1231971951) {
                        mp3Extractor = this;
                        tf2Var = mp3Extractor.m2553a(extractorInput2, false);
                    } else {
                        mp3Extractor = this;
                    }
                } else {
                    if (i4 == 1447187017) {
                        long length2 = extractorInput.getLength();
                        long position2 = extractorInput.getPosition();
                        parsableByteArray4.skipBytes(10);
                        int readInt2 = parsableByteArray4.readInt();
                        if (readInt2 <= 0) {
                            parsableByteArray2 = parsableByteArray3;
                        } else {
                            int i13 = header.sampleRate;
                            parsableByteArray2 = parsableByteArray3;
                            long j3 = readInt2;
                            if (i13 >= 32000) {
                                i7 = 1152;
                            } else {
                                i7 = 576;
                            }
                            long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j3, i7 * 1000000, i13);
                            int readUnsignedShort = parsableByteArray4.readUnsignedShort();
                            int readUnsignedShort2 = parsableByteArray4.readUnsignedShort();
                            int readUnsignedShort3 = parsableByteArray4.readUnsignedShort();
                            parsableByteArray4.skipBytes(2);
                            long j4 = header.frameSize + position2;
                            long[] jArr2 = new long[readUnsignedShort];
                            long[] jArr3 = new long[readUnsignedShort];
                            long j5 = position2;
                            int i14 = 0;
                            while (i14 < readUnsignedShort) {
                                long j6 = j4;
                                long j7 = length2;
                                jArr2[i14] = (i14 * scaleLargeTimestamp2) / readUnsignedShort;
                                jArr3[i14] = Math.max(j5, j6);
                                if (readUnsignedShort3 != 1) {
                                    c = 2;
                                    if (readUnsignedShort3 != 2) {
                                        if (readUnsignedShort3 != 3) {
                                            if (readUnsignedShort3 == 4) {
                                                readUnsignedByte = parsableByteArray4.readUnsignedIntToInt();
                                            }
                                        } else {
                                            readUnsignedByte = parsableByteArray4.readUnsignedInt24();
                                        }
                                    } else {
                                        readUnsignedByte = parsableByteArray4.readUnsignedShort();
                                    }
                                } else {
                                    c = 2;
                                    readUnsignedByte = parsableByteArray4.readUnsignedByte();
                                }
                                j5 += readUnsignedByte * readUnsignedShort2;
                                i14++;
                                readUnsignedShort3 = readUnsignedShort3;
                                j4 = j6;
                                length2 = j7;
                            }
                            long j8 = length2;
                            if (j8 != -1 && j8 != j5) {
                                Log.m3027w("VbriSeeker", "VBRI data size mismatch: " + j8 + ", " + j5);
                            }
                            tf2Var = new e13(jArr2, jArr3, scaleLargeTimestamp2, j5);
                            extractorInput2 = extractorInput;
                            extractorInput2.skipFully(header.frameSize);
                        }
                        tf2Var = null;
                        extractorInput2 = extractorInput;
                        extractorInput2.skipFully(header.frameSize);
                    } else {
                        extractorInput2 = extractorInput;
                        parsableByteArray2 = parsableByteArray3;
                        extractorInput.resetPeekPosition();
                        tf2Var = null;
                    }
                    mp3Extractor = this;
                    parsableByteArray = parsableByteArray2;
                }
                metadata = mp3Extractor.f10260l;
                long position3 = extractorInput.getPosition();
                if (metadata != null) {
                    int length3 = metadata.length();
                    for (int i15 = 0; i15 < length3; i15++) {
                        Metadata.Entry entry = metadata.get(i15);
                        if (entry instanceof MlltFrame) {
                            long m2552b2 = m2552b(metadata);
                            int length4 = ((MlltFrame) entry).bytesDeviations.length;
                            int i16 = length4 + 1;
                            long[] jArr4 = new long[i16];
                            long[] jArr5 = new long[i16];
                            jArr4[0] = position3;
                            jArr5[0] = 0;
                            int i17 = 1;
                            long j9 = 0;
                            while (i17 <= length4) {
                                int i18 = i17 - 1;
                                position3 += r10.bytesBetweenReference + r10.bytesDeviations[i18];
                                j9 += r10.millisecondsBetweenReference + r10.millisecondsDeviations[i18];
                                jArr4[i17] = position3;
                                jArr5[i17] = j9;
                                i17++;
                                length4 = length4;
                                gaplessInfoHolder2 = gaplessInfoHolder2;
                            }
                            gaplessInfoHolder = gaplessInfoHolder2;
                            jo1Var = new jo1(jArr4, jArr5, m2552b2);
                            z = mp3Extractor.f10266r;
                            i6 = mp3Extractor.f10249a;
                            if (!z) {
                                tf2Var = new Seeker$UnseekableSeeker();
                            } else {
                                if ((i6 & 4) != 0) {
                                    if (jo1Var != null) {
                                        m2552b = jo1Var.f20569c;
                                    } else if (tf2Var != null) {
                                        m2552b = tf2Var.getDurationUs();
                                        j = tf2Var.getDataEndPosition();
                                    } else {
                                        m2552b = m2552b(mp3Extractor.f10260l);
                                    }
                                    tf2Var = new f41(m2552b, extractorInput.getPosition(), j);
                                } else if (jo1Var != null) {
                                    tf2Var = jo1Var;
                                } else if (tf2Var == null) {
                                    tf2Var = null;
                                }
                                if (tf2Var == null || (!tf2Var.isSeekable() && (i6 & 1) != 0)) {
                                    if ((i6 & 2) != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    tf2Var = mp3Extractor.m2553a(extractorInput2, z2);
                                }
                            }
                            mp3Extractor.f10265q = tf2Var;
                            mp3Extractor.f10256h.seekMap(tf2Var);
                            TrackOutput trackOutput = mp3Extractor.f10258j;
                            GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                            Format.Builder encoderPadding = new Format.Builder().setSampleMimeType(header.mimeType).setMaxInputSize(4096).setChannelCount(header.channels).setSampleRate(header.sampleRate).setEncoderDelay(gaplessInfoHolder3.encoderDelay).setEncoderPadding(gaplessInfoHolder3.encoderPadding);
                            if ((i6 & 8) == 0) {
                                metadata2 = null;
                            } else {
                                metadata2 = mp3Extractor.f10260l;
                            }
                            trackOutput.format(encoderPadding.setMetadata(metadata2).build());
                            mp3Extractor.f10263o = extractorInput.getPosition();
                        }
                    }
                }
                gaplessInfoHolder = gaplessInfoHolder2;
                jo1Var = null;
                z = mp3Extractor.f10266r;
                i6 = mp3Extractor.f10249a;
                if (!z) {
                }
                mp3Extractor.f10265q = tf2Var;
                mp3Extractor.f10256h.seekMap(tf2Var);
                TrackOutput trackOutput2 = mp3Extractor.f10258j;
                GaplessInfoHolder gaplessInfoHolder32 = gaplessInfoHolder;
                Format.Builder encoderPadding2 = new Format.Builder().setSampleMimeType(header.mimeType).setMaxInputSize(4096).setChannelCount(header.channels).setSampleRate(header.sampleRate).setEncoderDelay(gaplessInfoHolder32.encoderDelay).setEncoderPadding(gaplessInfoHolder32.encoderPadding);
                if ((i6 & 8) == 0) {
                }
                trackOutput2.format(encoderPadding2.setMetadata(metadata2).build());
                mp3Extractor.f10263o = extractorInput.getPosition();
            }
            if (parsableByteArray4.limit() >= 40) {
                parsableByteArray4.setPosition(36);
                if (parsableByteArray4.readInt() == 1447187017) {
                    i4 = 1447187017;
                    GaplessInfoHolder gaplessInfoHolder22 = this.f10253e;
                    long j10 = -1;
                    if (i4 != 1483304551) {
                    }
                    extractorInput2 = extractorInput;
                    long length5 = extractorInput.getLength();
                    long position4 = extractorInput.getPosition();
                    int i102 = header.samplesPerFrame;
                    int i112 = header.sampleRate;
                    readInt = parsableByteArray4.readInt();
                    if ((readInt & 1) == 1) {
                    }
                    i5 = i4;
                    tf2Var = null;
                    if (tf2Var == null) {
                    }
                    parsableByteArray = parsableByteArray3;
                    extractorInput2.skipFully(header.frameSize);
                    if (tf2Var == null) {
                    }
                    mp3Extractor = this;
                    metadata = mp3Extractor.f10260l;
                    long position32 = extractorInput.getPosition();
                    if (metadata != null) {
                    }
                    gaplessInfoHolder = gaplessInfoHolder22;
                    jo1Var = null;
                    z = mp3Extractor.f10266r;
                    i6 = mp3Extractor.f10249a;
                    if (!z) {
                    }
                    mp3Extractor.f10265q = tf2Var;
                    mp3Extractor.f10256h.seekMap(tf2Var);
                    TrackOutput trackOutput22 = mp3Extractor.f10258j;
                    GaplessInfoHolder gaplessInfoHolder322 = gaplessInfoHolder;
                    Format.Builder encoderPadding22 = new Format.Builder().setSampleMimeType(header.mimeType).setMaxInputSize(4096).setChannelCount(header.channels).setSampleRate(header.sampleRate).setEncoderDelay(gaplessInfoHolder322.encoderDelay).setEncoderPadding(gaplessInfoHolder322.encoderPadding);
                    if ((i6 & 8) == 0) {
                    }
                    trackOutput22.format(encoderPadding22.setMetadata(metadata2).build());
                    mp3Extractor.f10263o = extractorInput.getPosition();
                }
            }
            i4 = 0;
            GaplessInfoHolder gaplessInfoHolder222 = this.f10253e;
            long j102 = -1;
            if (i4 != 1483304551) {
            }
            extractorInput2 = extractorInput;
            long length52 = extractorInput.getLength();
            long position42 = extractorInput.getPosition();
            int i1022 = header.samplesPerFrame;
            int i1122 = header.sampleRate;
            readInt = parsableByteArray4.readInt();
            if ((readInt & 1) == 1) {
            }
            i5 = i4;
            tf2Var = null;
            if (tf2Var == null) {
            }
            parsableByteArray = parsableByteArray3;
            extractorInput2.skipFully(header.frameSize);
            if (tf2Var == null) {
            }
            mp3Extractor = this;
            metadata = mp3Extractor.f10260l;
            long position322 = extractorInput.getPosition();
            if (metadata != null) {
            }
            gaplessInfoHolder = gaplessInfoHolder222;
            jo1Var = null;
            z = mp3Extractor.f10266r;
            i6 = mp3Extractor.f10249a;
            if (!z) {
            }
            mp3Extractor.f10265q = tf2Var;
            mp3Extractor.f10256h.seekMap(tf2Var);
            TrackOutput trackOutput222 = mp3Extractor.f10258j;
            GaplessInfoHolder gaplessInfoHolder3222 = gaplessInfoHolder;
            Format.Builder encoderPadding222 = new Format.Builder().setSampleMimeType(header.mimeType).setMaxInputSize(4096).setChannelCount(header.channels).setSampleRate(header.sampleRate).setEncoderDelay(gaplessInfoHolder3222.encoderDelay).setEncoderPadding(gaplessInfoHolder3222.encoderPadding);
            if ((i6 & 8) == 0) {
            }
            trackOutput222.format(encoderPadding222.setMetadata(metadata2).build());
            mp3Extractor.f10263o = extractorInput.getPosition();
        } else {
            mp3Extractor = this;
            extractorInput2 = extractorInput;
            parsableByteArray = parsableByteArray3;
            if (mp3Extractor.f10263o != 0) {
                long position5 = extractorInput.getPosition();
                long j11 = mp3Extractor.f10263o;
                if (position5 < j11) {
                    extractorInput2.skipFully((int) (j11 - position5));
                }
            }
        }
        if (mp3Extractor.f10264p == 0) {
            extractorInput.resetPeekPosition();
            if (!m2554c(extractorInput)) {
                parsableByteArray.setPosition(0);
                int readInt3 = parsableByteArray.readInt();
                if (((-128000) & readInt3) == (mp3Extractor.f10259k & (-128000)) && MpegAudioUtil.getFrameSize(readInt3) != -1) {
                    header.setForHeaderData(readInt3);
                    if (mp3Extractor.f10261m == C0643C.TIME_UNSET) {
                        mp3Extractor.f10261m = mp3Extractor.f10265q.getTimeUs(extractorInput.getPosition());
                        long j12 = mp3Extractor.f10250b;
                        if (j12 != C0643C.TIME_UNSET) {
                            mp3Extractor.f10261m = (j12 - mp3Extractor.f10265q.getTimeUs(0L)) + mp3Extractor.f10261m;
                        }
                    }
                    mp3Extractor.f10264p = header.frameSize;
                    tf2 tf2Var3 = mp3Extractor.f10265q;
                    if (tf2Var3 instanceof f41) {
                        f41 f41Var = (f41) tf2Var3;
                        long j13 = (((mp3Extractor.f10262n + header.samplesPerFrame) * 1000000) / header.sampleRate) + mp3Extractor.f10261m;
                        long position6 = extractorInput.getPosition() + header.frameSize;
                        if (!f41Var.m4768a(j13)) {
                            f41Var.f17122b.add(j13);
                            f41Var.f17123c.add(position6);
                        }
                        if (mp3Extractor.f10267s && f41Var.m4768a(mp3Extractor.f10268t)) {
                            mp3Extractor.f10267s = false;
                            mp3Extractor.f10258j = mp3Extractor.f10257i;
                        }
                    }
                } else {
                    extractorInput2.skipFully(1);
                    mp3Extractor.f10259k = 0;
                    i3 = 0;
                    i2 = i3;
                    i = -1;
                    if (i2 == i) {
                        tf2 tf2Var4 = mp3Extractor.f10265q;
                        if (tf2Var4 instanceof f41) {
                            long j14 = ((mp3Extractor.f10262n * 1000000) / header.sampleRate) + mp3Extractor.f10261m;
                            if (tf2Var4.getDurationUs() != j14) {
                                tf2 tf2Var5 = mp3Extractor.f10265q;
                                ((f41) tf2Var5).f17124d = j14;
                                mp3Extractor.f10256h.seekMap(tf2Var5);
                            }
                        }
                    }
                    return i2;
                }
            }
            i3 = -1;
            i2 = i3;
            i = -1;
            if (i2 == i) {
            }
            return i2;
        }
        int sampleData = mp3Extractor.f10258j.sampleData((DataReader) extractorInput2, mp3Extractor.f10264p, true);
        if (sampleData != -1) {
            int i19 = mp3Extractor.f10264p - sampleData;
            mp3Extractor.f10264p = i19;
            if (i19 <= 0) {
                mp3Extractor.f10258j.sampleMetadata(((mp3Extractor.f10262n * 1000000) / header.sampleRate) + mp3Extractor.f10261m, 1, header.frameSize, 0, null);
                mp3Extractor.f10262n += header.samplesPerFrame;
                mp3Extractor.f10264p = 0;
                i3 = 0;
                i2 = i3;
                i = -1;
                if (i2 == i) {
                }
                return i2;
            }
            i3 = 0;
            i2 = i3;
            i = -1;
            if (i2 == i) {
            }
            return i2;
        }
        i3 = -1;
        i2 = i3;
        i = -1;
        if (i2 == i) {
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f10259k = 0;
        this.f10261m = C0643C.TIME_UNSET;
        this.f10262n = 0L;
        this.f10264p = 0;
        this.f10268t = j2;
        tf2 tf2Var = this.f10265q;
        if ((tf2Var instanceof f41) && !((f41) tf2Var).m4768a(j2)) {
            this.f10267s = true;
            this.f10258j = this.f10255g;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        return m2555d(extractorInput, true);
    }

    public Mp3Extractor(int i) {
        this(i, C0643C.TIME_UNSET);
    }

    public Mp3Extractor(int i, long j) {
        this.f10249a = (i & 2) != 0 ? i | 1 : i;
        this.f10250b = j;
        this.f10251c = new ParsableByteArray(10);
        this.f10252d = new MpegAudioUtil.Header();
        this.f10253e = new GaplessInfoHolder();
        this.f10261m = C0643C.TIME_UNSET;
        this.f10254f = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.f10255g = dummyTrackOutput;
        this.f10258j = dummyTrackOutput;
    }
}
