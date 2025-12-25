package com.google.android.exoplayer2.extractor.p002ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes.dex */
public final class AdtsReader implements ElementaryStreamReader {

    /* renamed from: v */
    public static final byte[] f10377v = {73, 68, 51};

    /* renamed from: a */
    public final boolean f10378a;

    /* renamed from: b */
    public final ParsableBitArray f10379b;

    /* renamed from: c */
    public final ParsableByteArray f10380c;

    /* renamed from: d */
    public final String f10381d;

    /* renamed from: e */
    public String f10382e;

    /* renamed from: f */
    public TrackOutput f10383f;

    /* renamed from: g */
    public TrackOutput f10384g;

    /* renamed from: h */
    public int f10385h;

    /* renamed from: i */
    public int f10386i;

    /* renamed from: j */
    public int f10387j;

    /* renamed from: k */
    public boolean f10388k;

    /* renamed from: l */
    public boolean f10389l;

    /* renamed from: m */
    public int f10390m;

    /* renamed from: n */
    public int f10391n;

    /* renamed from: o */
    public int f10392o;

    /* renamed from: p */
    public boolean f10393p;

    /* renamed from: q */
    public long f10394q;

    /* renamed from: r */
    public int f10395r;

    /* renamed from: s */
    public long f10396s;

    /* renamed from: t */
    public TrackOutput f10397t;

    /* renamed from: u */
    public long f10398u;

    public AdtsReader(boolean z) {
        this(z, null);
    }

    public static boolean isAdtsSyncWord(int i) {
        return (i & 65526) == 65520;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        byte b;
        char c;
        int i3;
        char c2;
        char c3;
        boolean z;
        int i4;
        Assertions.checkNotNull(this.f10383f);
        Util.castNonNull(this.f10397t);
        Util.castNonNull(this.f10384g);
        while (parsableByteArray.bytesLeft() > 0) {
            int i5 = this.f10385h;
            int i6 = 2;
            char c4 = 65535;
            int i7 = 4;
            int i8 = 1;
            ParsableByteArray parsableByteArray2 = this.f10380c;
            ParsableBitArray parsableBitArray = this.f10379b;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                int min = Math.min(parsableByteArray.bytesLeft(), this.f10395r - this.f10386i);
                                this.f10397t.sampleData(parsableByteArray, min);
                                int i9 = this.f10386i + min;
                                this.f10386i = i9;
                                int i10 = this.f10395r;
                                if (i9 == i10) {
                                    long j = this.f10396s;
                                    if (j != C0643C.TIME_UNSET) {
                                        this.f10397t.sampleMetadata(j, 1, i10, 0, null);
                                        this.f10396s += this.f10398u;
                                    }
                                    this.f10385h = 0;
                                    this.f10386i = 0;
                                    this.f10387j = 256;
                                }
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            if (this.f10388k) {
                                i = 7;
                            } else {
                                i = 5;
                            }
                            byte[] bArr = parsableBitArray.data;
                            int min2 = Math.min(parsableByteArray.bytesLeft(), i - this.f10386i);
                            parsableByteArray.readBytes(bArr, this.f10386i, min2);
                            int i11 = this.f10386i + min2;
                            this.f10386i = i11;
                            if (i11 == i) {
                                parsableBitArray.setPosition(0);
                                if (!this.f10393p) {
                                    int readBits = parsableBitArray.readBits(2) + 1;
                                    if (readBits != 2) {
                                        Log.m3027w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
                                    } else {
                                        i6 = readBits;
                                    }
                                    parsableBitArray.skipBits(5);
                                    byte[] buildAudioSpecificConfig = AacUtil.buildAudioSpecificConfig(i6, this.f10391n, parsableBitArray.readBits(3));
                                    AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(buildAudioSpecificConfig);
                                    Format build = new Format.Builder().setId(this.f10382e).setSampleMimeType(MimeTypes.AUDIO_AAC).setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(buildAudioSpecificConfig)).setLanguage(this.f10381d).build();
                                    this.f10394q = 1024000000 / build.sampleRate;
                                    this.f10383f.format(build);
                                    this.f10393p = true;
                                } else {
                                    parsableBitArray.skipBits(10);
                                }
                                parsableBitArray.skipBits(4);
                                int readBits2 = parsableBitArray.readBits(13);
                                int i12 = readBits2 - 7;
                                if (this.f10388k) {
                                    i12 = readBits2 - 9;
                                }
                                TrackOutput trackOutput = this.f10383f;
                                long j2 = this.f10394q;
                                this.f10385h = 4;
                                this.f10386i = 0;
                                this.f10397t = trackOutput;
                                this.f10398u = j2;
                                this.f10395r = i12;
                            }
                        }
                    } else {
                        byte[] data = parsableByteArray2.getData();
                        int min3 = Math.min(parsableByteArray.bytesLeft(), 10 - this.f10386i);
                        parsableByteArray.readBytes(data, this.f10386i, min3);
                        int i13 = this.f10386i + min3;
                        this.f10386i = i13;
                        if (i13 == 10) {
                            this.f10384g.sampleData(parsableByteArray2, 10);
                            parsableByteArray2.setPosition(6);
                            TrackOutput trackOutput2 = this.f10384g;
                            int readSynchSafeInt = parsableByteArray2.readSynchSafeInt() + 10;
                            this.f10385h = 4;
                            this.f10386i = 10;
                            this.f10397t = trackOutput2;
                            this.f10398u = 0L;
                            this.f10395r = readSynchSafeInt;
                        }
                    }
                } else if (parsableByteArray.bytesLeft() != 0) {
                    parsableBitArray.data[0] = parsableByteArray.getData()[parsableByteArray.getPosition()];
                    parsableBitArray.setPosition(2);
                    int readBits3 = parsableBitArray.readBits(4);
                    int i14 = this.f10391n;
                    if (i14 != -1 && readBits3 != i14) {
                        this.f10389l = false;
                        this.f10385h = 0;
                        this.f10386i = 0;
                        this.f10387j = 256;
                    } else {
                        if (!this.f10389l) {
                            this.f10389l = true;
                            this.f10390m = this.f10392o;
                            this.f10391n = readBits3;
                        }
                        this.f10385h = 3;
                        this.f10386i = 0;
                    }
                }
            } else {
                byte[] data2 = parsableByteArray.getData();
                int position = parsableByteArray.getPosition();
                int limit = parsableByteArray.limit();
                while (true) {
                    if (position < limit) {
                        i2 = position + 1;
                        b = data2[position];
                        int i15 = b & 255;
                        if (this.f10387j == 512 && isAdtsSyncWord(65280 | (((byte) i15) & 255))) {
                            if (this.f10389l) {
                                break;
                            }
                            int i16 = position - 1;
                            parsableByteArray.setPosition(position);
                            byte[] bArr2 = parsableBitArray.data;
                            if (parsableByteArray.bytesLeft() >= i8) {
                                parsableByteArray.readBytes(bArr2, 0, i8);
                                parsableBitArray.setPosition(i7);
                                int readBits4 = parsableBitArray.readBits(i8);
                                int i17 = this.f10390m;
                                c = 65535;
                                if (i17 == -1 || readBits4 == i17) {
                                    if (this.f10391n != -1) {
                                        byte[] bArr3 = parsableBitArray.data;
                                        if (parsableByteArray.bytesLeft() < i8) {
                                            break;
                                        }
                                        parsableByteArray.readBytes(bArr3, 0, i8);
                                        parsableBitArray.setPosition(2);
                                        i4 = 4;
                                        if (parsableBitArray.readBits(4) == this.f10391n) {
                                            parsableByteArray.setPosition(i2);
                                        }
                                    } else {
                                        i4 = 4;
                                    }
                                    byte[] bArr4 = parsableBitArray.data;
                                    if (parsableByteArray.bytesLeft() >= i4) {
                                        parsableByteArray.readBytes(bArr4, 0, i4);
                                        parsableBitArray.setPosition(14);
                                        int readBits5 = parsableBitArray.readBits(13);
                                        if (readBits5 >= 7) {
                                            byte[] data3 = parsableByteArray.getData();
                                            int limit2 = parsableByteArray.limit();
                                            int i18 = i16 + readBits5;
                                            if (i18 < limit2) {
                                                byte b2 = data3[i18];
                                                c = 65535;
                                                if (b2 == -1) {
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                i3 = 1;
                            }
                            c = 65535;
                            i3 = 1;
                        } else {
                            c = c4;
                            i3 = i8;
                        }
                        int i19 = this.f10387j;
                        int i20 = i15 | i19;
                        if (i20 != 329) {
                            if (i20 != 511) {
                                if (i20 != 836) {
                                    if (i20 != 1075) {
                                        c2 = 256;
                                        if (i19 != 256) {
                                            this.f10387j = 256;
                                            c3 = 2;
                                            i8 = i3;
                                            c4 = c;
                                            i7 = 4;
                                        } else {
                                            c3 = 2;
                                        }
                                    } else {
                                        this.f10385h = 2;
                                        this.f10386i = 3;
                                        this.f10395r = 0;
                                        parsableByteArray2.setPosition(0);
                                        parsableByteArray.setPosition(i2);
                                        break;
                                    }
                                } else {
                                    c2 = 256;
                                    c3 = 2;
                                    this.f10387j = 1024;
                                }
                            } else {
                                c2 = 256;
                                c3 = 2;
                                this.f10387j = 512;
                            }
                        } else {
                            c2 = 256;
                            c3 = 2;
                            this.f10387j = 768;
                        }
                        position = i2;
                        i8 = i3;
                        c4 = c;
                        i7 = 4;
                    } else {
                        parsableByteArray.setPosition(position);
                        break;
                    }
                }
                this.f10392o = (b & 8) >> 3;
                if ((b & 1) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f10388k = z;
                if (!this.f10389l) {
                    this.f10385h = 1;
                    this.f10386i = 0;
                } else {
                    this.f10385h = 3;
                    this.f10386i = 0;
                }
                parsableByteArray.setPosition(i2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10382e = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.f10383f = track;
        this.f10397t = track;
        if (this.f10378a) {
            trackIdGenerator.generateNewId();
            TrackOutput track2 = extractorOutput.track(trackIdGenerator.getTrackId(), 5);
            this.f10384g = track2;
            track2.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
            return;
        }
        this.f10384g = new DummyTrackOutput();
    }

    public long getSampleDurationUs() {
        return this.f10394q;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10396s = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10396s = C0643C.TIME_UNSET;
        this.f10389l = false;
        this.f10385h = 0;
        this.f10386i = 0;
        this.f10387j = 256;
    }

    public AdtsReader(boolean z, @Nullable String str) {
        this.f10379b = new ParsableBitArray(new byte[7]);
        this.f10380c = new ParsableByteArray(Arrays.copyOf(f10377v, 10));
        this.f10385h = 0;
        this.f10386i = 0;
        this.f10387j = 256;
        this.f10390m = -1;
        this.f10391n = -1;
        this.f10394q = C0643C.TIME_UNSET;
        this.f10396s = C0643C.TIME_UNSET;
        this.f10378a = z;
        this.f10381d = str;
    }
}
