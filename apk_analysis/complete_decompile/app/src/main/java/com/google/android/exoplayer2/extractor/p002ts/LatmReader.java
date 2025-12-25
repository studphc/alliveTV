package com.google.android.exoplayer2.extractor.p002ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

/* loaded from: classes.dex */
public final class LatmReader implements ElementaryStreamReader {

    /* renamed from: a */
    public final String f10482a;

    /* renamed from: b */
    public final ParsableByteArray f10483b;

    /* renamed from: c */
    public final ParsableBitArray f10484c;

    /* renamed from: d */
    public TrackOutput f10485d;

    /* renamed from: e */
    public String f10486e;

    /* renamed from: f */
    public Format f10487f;

    /* renamed from: g */
    public int f10488g;

    /* renamed from: h */
    public int f10489h;

    /* renamed from: i */
    public int f10490i;

    /* renamed from: j */
    public int f10491j;

    /* renamed from: k */
    public long f10492k;

    /* renamed from: l */
    public boolean f10493l;

    /* renamed from: m */
    public int f10494m;

    /* renamed from: n */
    public int f10495n;

    /* renamed from: o */
    public int f10496o;

    /* renamed from: p */
    public boolean f10497p;

    /* renamed from: q */
    public long f10498q;

    /* renamed from: r */
    public int f10499r;

    /* renamed from: s */
    public long f10500s;

    /* renamed from: t */
    public int f10501t;

    /* renamed from: u */
    public String f10502u;

    public LatmReader(@Nullable String str) {
        this.f10482a = str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f10483b = parsableByteArray;
        this.f10484c = new ParsableBitArray(parsableByteArray.getData());
        this.f10492k = C0643C.TIME_UNSET;
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x019d, code lost:
    
        if (r19.f10493l == false) goto L88;
     */
    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void consume(ParsableByteArray parsableByteArray) {
        int readBits;
        int i;
        boolean readBit;
        Assertions.checkStateNotNull(this.f10485d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i2 = this.f10488g;
            if (i2 != 0) {
                if (i2 != 1) {
                    ParsableByteArray parsableByteArray2 = this.f10483b;
                    ParsableBitArray parsableBitArray = this.f10484c;
                    if (i2 != 2) {
                        if (i2 == 3) {
                            int min = Math.min(parsableByteArray.bytesLeft(), this.f10490i - this.f10489h);
                            parsableByteArray.readBytes(parsableBitArray.data, this.f10489h, min);
                            int i3 = this.f10489h + min;
                            this.f10489h = i3;
                            if (i3 == this.f10490i) {
                                parsableBitArray.setPosition(0);
                                if (!parsableBitArray.readBit()) {
                                    this.f10493l = true;
                                    int readBits2 = parsableBitArray.readBits(1);
                                    if (readBits2 == 1) {
                                        i = parsableBitArray.readBits(1);
                                    } else {
                                        i = 0;
                                    }
                                    this.f10494m = i;
                                    if (i == 0) {
                                        if (readBits2 == 1) {
                                            parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8);
                                        }
                                        if (parsableBitArray.readBit()) {
                                            this.f10495n = parsableBitArray.readBits(6);
                                            int readBits3 = parsableBitArray.readBits(4);
                                            int readBits4 = parsableBitArray.readBits(3);
                                            if (readBits3 == 0 && readBits4 == 0) {
                                                if (readBits2 == 0) {
                                                    int position = parsableBitArray.getPosition();
                                                    int bitsLeft = parsableBitArray.bitsLeft();
                                                    AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(parsableBitArray, true);
                                                    this.f10502u = parseAudioSpecificConfig.codecs;
                                                    this.f10499r = parseAudioSpecificConfig.sampleRateHz;
                                                    this.f10501t = parseAudioSpecificConfig.channelCount;
                                                    int bitsLeft2 = bitsLeft - parsableBitArray.bitsLeft();
                                                    parsableBitArray.setPosition(position);
                                                    byte[] bArr = new byte[(bitsLeft2 + 7) / 8];
                                                    parsableBitArray.readBits(bArr, 0, bitsLeft2);
                                                    Format build = new Format.Builder().setId(this.f10486e).setSampleMimeType(MimeTypes.AUDIO_AAC).setCodecs(this.f10502u).setChannelCount(this.f10501t).setSampleRate(this.f10499r).setInitializationData(Collections.singletonList(bArr)).setLanguage(this.f10482a).build();
                                                    if (!build.equals(this.f10487f)) {
                                                        this.f10487f = build;
                                                        this.f10500s = 1024000000 / build.sampleRate;
                                                        this.f10485d.format(build);
                                                    }
                                                } else {
                                                    int bitsLeft3 = parsableBitArray.bitsLeft();
                                                    AacUtil.Config parseAudioSpecificConfig2 = AacUtil.parseAudioSpecificConfig(parsableBitArray, true);
                                                    this.f10502u = parseAudioSpecificConfig2.codecs;
                                                    this.f10499r = parseAudioSpecificConfig2.sampleRateHz;
                                                    this.f10501t = parseAudioSpecificConfig2.channelCount;
                                                    parsableBitArray.skipBits(parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8) - (bitsLeft3 - parsableBitArray.bitsLeft()));
                                                }
                                                int readBits5 = parsableBitArray.readBits(3);
                                                this.f10496o = readBits5;
                                                if (readBits5 != 0) {
                                                    if (readBits5 != 1) {
                                                        if (readBits5 != 3 && readBits5 != 4 && readBits5 != 5) {
                                                            if (readBits5 != 6 && readBits5 != 7) {
                                                                throw new IllegalStateException();
                                                            }
                                                            parsableBitArray.skipBits(1);
                                                        } else {
                                                            parsableBitArray.skipBits(6);
                                                        }
                                                    } else {
                                                        parsableBitArray.skipBits(9);
                                                    }
                                                } else {
                                                    parsableBitArray.skipBits(8);
                                                }
                                                boolean readBit2 = parsableBitArray.readBit();
                                                this.f10497p = readBit2;
                                                this.f10498q = 0L;
                                                if (readBit2) {
                                                    if (readBits2 == 1) {
                                                        this.f10498q = parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8);
                                                    }
                                                    do {
                                                        readBit = parsableBitArray.readBit();
                                                        this.f10498q = (this.f10498q << 8) + parsableBitArray.readBits(8);
                                                    } while (readBit);
                                                }
                                                if (parsableBitArray.readBit()) {
                                                    parsableBitArray.skipBits(8);
                                                }
                                            } else {
                                                throw ParserException.createForMalformedContainer(null, null);
                                            }
                                        } else {
                                            throw ParserException.createForMalformedContainer(null, null);
                                        }
                                    } else {
                                        throw ParserException.createForMalformedContainer(null, null);
                                    }
                                }
                                if (this.f10494m == 0) {
                                    if (this.f10495n == 0) {
                                        if (this.f10496o == 0) {
                                            int i4 = 0;
                                            do {
                                                readBits = parsableBitArray.readBits(8);
                                                i4 += readBits;
                                            } while (readBits == 255);
                                            int position2 = parsableBitArray.getPosition();
                                            if ((position2 & 7) == 0) {
                                                parsableByteArray2.setPosition(position2 >> 3);
                                            } else {
                                                parsableBitArray.readBits(parsableByteArray2.getData(), 0, i4 * 8);
                                                parsableByteArray2.setPosition(0);
                                            }
                                            this.f10485d.sampleData(parsableByteArray2, i4);
                                            long j = this.f10492k;
                                            if (j != C0643C.TIME_UNSET) {
                                                this.f10485d.sampleMetadata(j, 1, i4, 0, null);
                                                this.f10492k += this.f10500s;
                                            }
                                            if (this.f10497p) {
                                                parsableBitArray.skipBits((int) this.f10498q);
                                            }
                                            this.f10488g = 0;
                                        } else {
                                            throw ParserException.createForMalformedContainer(null, null);
                                        }
                                    } else {
                                        throw ParserException.createForMalformedContainer(null, null);
                                    }
                                } else {
                                    throw ParserException.createForMalformedContainer(null, null);
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        int readUnsignedByte = ((this.f10491j & (-225)) << 8) | parsableByteArray.readUnsignedByte();
                        this.f10490i = readUnsignedByte;
                        if (readUnsignedByte > parsableByteArray2.getData().length) {
                            parsableByteArray2.reset(this.f10490i);
                            parsableBitArray.reset(parsableByteArray2.getData());
                        }
                        this.f10489h = 0;
                        this.f10488g = 3;
                    }
                } else {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    if ((readUnsignedByte2 & 224) == 224) {
                        this.f10491j = readUnsignedByte2;
                        this.f10488g = 2;
                    } else if (readUnsignedByte2 != 86) {
                        this.f10488g = 0;
                    }
                }
            } else if (parsableByteArray.readUnsignedByte() == 86) {
                this.f10488g = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10485d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.f10486e = trackIdGenerator.getFormatId();
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10492k = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10488g = 0;
        this.f10492k = C0643C.TIME_UNSET;
        this.f10493l = false;
    }
}
