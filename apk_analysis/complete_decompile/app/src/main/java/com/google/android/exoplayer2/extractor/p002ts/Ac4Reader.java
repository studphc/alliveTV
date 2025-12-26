package com.google.android.exoplayer2.extractor.p002ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class Ac4Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final ParsableBitArray f10352a;

    /* renamed from: b */
    public final ParsableByteArray f10353b;

    /* renamed from: c */
    public final String f10354c;

    /* renamed from: d */
    public String f10355d;

    /* renamed from: e */
    public TrackOutput f10356e;

    /* renamed from: f */
    public int f10357f;

    /* renamed from: g */
    public int f10358g;

    /* renamed from: h */
    public boolean f10359h;

    /* renamed from: i */
    public boolean f10360i;

    /* renamed from: j */
    public long f10361j;

    /* renamed from: k */
    public Format f10362k;

    /* renamed from: l */
    public int f10363l;

    /* renamed from: m */
    public long f10364m;

    public Ac4Reader() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        boolean z;
        boolean z2;
        boolean z3;
        Assertions.checkStateNotNull(this.f10356e);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f10357f;
            ParsableByteArray parsableByteArray2 = this.f10353b;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.f10363l - this.f10358g);
                        this.f10356e.sampleData(parsableByteArray, min);
                        int i2 = this.f10358g + min;
                        this.f10358g = i2;
                        int i3 = this.f10363l;
                        if (i2 == i3) {
                            long j = this.f10364m;
                            if (j != C0643C.TIME_UNSET) {
                                this.f10356e.sampleMetadata(j, 1, i3, 0, null);
                                this.f10364m += this.f10361j;
                            }
                            this.f10357f = 0;
                        }
                    }
                } else {
                    byte[] data = parsableByteArray2.getData();
                    int min2 = Math.min(parsableByteArray.bytesLeft(), 16 - this.f10358g);
                    parsableByteArray.readBytes(data, this.f10358g, min2);
                    int i4 = this.f10358g + min2;
                    this.f10358g = i4;
                    if (i4 == 16) {
                        ParsableBitArray parsableBitArray = this.f10352a;
                        parsableBitArray.setPosition(0);
                        Ac4Util.SyncFrameInfo parseAc4SyncframeInfo = Ac4Util.parseAc4SyncframeInfo(parsableBitArray);
                        Format format = this.f10362k;
                        if (format == null || parseAc4SyncframeInfo.channelCount != format.channelCount || parseAc4SyncframeInfo.sampleRate != format.sampleRate || !MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
                            Format build = new Format.Builder().setId(this.f10355d).setSampleMimeType(MimeTypes.AUDIO_AC4).setChannelCount(parseAc4SyncframeInfo.channelCount).setSampleRate(parseAc4SyncframeInfo.sampleRate).setLanguage(this.f10354c).build();
                            this.f10362k = build;
                            this.f10356e.format(build);
                        }
                        this.f10363l = parseAc4SyncframeInfo.frameSize;
                        this.f10361j = (parseAc4SyncframeInfo.sampleCount * 1000000) / this.f10362k.sampleRate;
                        parsableByteArray2.setPosition(0);
                        this.f10356e.sampleData(parsableByteArray2, 16);
                        this.f10357f = 2;
                    }
                }
            } else {
                while (parsableByteArray.bytesLeft() > 0) {
                    if (!this.f10359h) {
                        if (parsableByteArray.readUnsignedByte() == 172) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.f10359h = z;
                    } else {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        if (readUnsignedByte == 172) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f10359h = z2;
                        int i5 = 65;
                        if (readUnsignedByte == 64 || readUnsignedByte == 65) {
                            if (readUnsignedByte == 65) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            this.f10360i = z3;
                            this.f10357f = 1;
                            parsableByteArray2.getData()[0] = -84;
                            byte[] data2 = parsableByteArray2.getData();
                            if (!this.f10360i) {
                                i5 = 64;
                            }
                            data2[1] = (byte) i5;
                            this.f10358g = 2;
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10355d = trackIdGenerator.getFormatId();
        this.f10356e = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10364m = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10357f = 0;
        this.f10358g = 0;
        this.f10359h = false;
        this.f10360i = false;
        this.f10364m = C0643C.TIME_UNSET;
    }

    public Ac4Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.f10352a = parsableBitArray;
        this.f10353b = new ParsableByteArray(parsableBitArray.data);
        this.f10357f = 0;
        this.f10358g = 0;
        this.f10359h = false;
        this.f10360i = false;
        this.f10364m = C0643C.TIME_UNSET;
        this.f10354c = str;
    }
}
