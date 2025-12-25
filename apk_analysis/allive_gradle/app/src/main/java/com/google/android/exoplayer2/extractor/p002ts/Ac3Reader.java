package com.google.android.exoplayer2.extractor.p002ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public final class Ac3Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final ParsableBitArray f10337a;

    /* renamed from: b */
    public final ParsableByteArray f10338b;

    /* renamed from: c */
    public final String f10339c;

    /* renamed from: d */
    public String f10340d;

    /* renamed from: e */
    public TrackOutput f10341e;

    /* renamed from: f */
    public int f10342f;

    /* renamed from: g */
    public int f10343g;

    /* renamed from: h */
    public boolean f10344h;

    /* renamed from: i */
    public long f10345i;

    /* renamed from: j */
    public Format f10346j;

    /* renamed from: k */
    public int f10347k;

    /* renamed from: l */
    public long f10348l;

    public Ac3Reader() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        boolean z;
        boolean z2;
        Assertions.checkStateNotNull(this.f10341e);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f10342f;
            ParsableByteArray parsableByteArray2 = this.f10338b;
            if (i == 0) {
                while (true) {
                    if (parsableByteArray.bytesLeft() <= 0) {
                        break;
                    }
                    if (!this.f10344h) {
                        if (parsableByteArray.readUnsignedByte() == 11) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.f10344h = z;
                    } else {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        if (readUnsignedByte == 119) {
                            this.f10344h = false;
                            this.f10342f = 1;
                            parsableByteArray2.getData()[0] = Ascii.f14468VT;
                            parsableByteArray2.getData()[1] = 119;
                            this.f10343g = 2;
                            break;
                        }
                        if (readUnsignedByte == 11) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f10344h = z2;
                    }
                }
            } else if (i != 1) {
                if (i == 2) {
                    int min = Math.min(parsableByteArray.bytesLeft(), this.f10347k - this.f10343g);
                    this.f10341e.sampleData(parsableByteArray, min);
                    int i2 = this.f10343g + min;
                    this.f10343g = i2;
                    int i3 = this.f10347k;
                    if (i2 == i3) {
                        long j = this.f10348l;
                        if (j != C0643C.TIME_UNSET) {
                            this.f10341e.sampleMetadata(j, 1, i3, 0, null);
                            this.f10348l += this.f10345i;
                        }
                        this.f10342f = 0;
                    }
                }
            } else {
                byte[] data = parsableByteArray2.getData();
                int min2 = Math.min(parsableByteArray.bytesLeft(), 128 - this.f10343g);
                parsableByteArray.readBytes(data, this.f10343g, min2);
                int i4 = this.f10343g + min2;
                this.f10343g = i4;
                if (i4 == 128) {
                    ParsableBitArray parsableBitArray = this.f10337a;
                    parsableBitArray.setPosition(0);
                    Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = Ac3Util.parseAc3SyncframeInfo(parsableBitArray);
                    Format format = this.f10346j;
                    if (format == null || parseAc3SyncframeInfo.channelCount != format.channelCount || parseAc3SyncframeInfo.sampleRate != format.sampleRate || !Util.areEqual(parseAc3SyncframeInfo.mimeType, format.sampleMimeType)) {
                        Format build = new Format.Builder().setId(this.f10340d).setSampleMimeType(parseAc3SyncframeInfo.mimeType).setChannelCount(parseAc3SyncframeInfo.channelCount).setSampleRate(parseAc3SyncframeInfo.sampleRate).setLanguage(this.f10339c).build();
                        this.f10346j = build;
                        this.f10341e.format(build);
                    }
                    this.f10347k = parseAc3SyncframeInfo.frameSize;
                    this.f10345i = (parseAc3SyncframeInfo.sampleCount * 1000000) / this.f10346j.sampleRate;
                    parsableByteArray2.setPosition(0);
                    this.f10341e.sampleData(parsableByteArray2, 128);
                    this.f10342f = 2;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10340d = trackIdGenerator.getFormatId();
        this.f10341e = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10348l = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10342f = 0;
        this.f10343g = 0;
        this.f10344h = false;
        this.f10348l = C0643C.TIME_UNSET;
    }

    public Ac3Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.f10337a = parsableBitArray;
        this.f10338b = new ParsableByteArray(parsableBitArray.data);
        this.f10342f = 0;
        this.f10348l = C0643C.TIME_UNSET;
        this.f10339c = str;
    }
}
