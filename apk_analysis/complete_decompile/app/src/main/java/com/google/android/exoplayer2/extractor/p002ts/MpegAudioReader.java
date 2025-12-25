package com.google.android.exoplayer2.extractor.p002ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class MpegAudioReader implements ElementaryStreamReader {

    /* renamed from: a */
    public final ParsableByteArray f10503a;

    /* renamed from: b */
    public final MpegAudioUtil.Header f10504b;

    /* renamed from: c */
    public final String f10505c;

    /* renamed from: d */
    public TrackOutput f10506d;

    /* renamed from: e */
    public String f10507e;

    /* renamed from: f */
    public int f10508f;

    /* renamed from: g */
    public int f10509g;

    /* renamed from: h */
    public boolean f10510h;

    /* renamed from: i */
    public boolean f10511i;

    /* renamed from: j */
    public long f10512j;

    /* renamed from: k */
    public int f10513k;

    /* renamed from: l */
    public long f10514l;

    public MpegAudioReader() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        boolean z;
        boolean z2;
        Assertions.checkStateNotNull(this.f10506d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f10508f;
            ParsableByteArray parsableByteArray2 = this.f10503a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.f10513k - this.f10509g);
                        this.f10506d.sampleData(parsableByteArray, min);
                        int i2 = this.f10509g + min;
                        this.f10509g = i2;
                        int i3 = this.f10513k;
                        if (i2 >= i3) {
                            long j = this.f10514l;
                            if (j != C0643C.TIME_UNSET) {
                                this.f10506d.sampleMetadata(j, 1, i3, 0, null);
                                this.f10514l += this.f10512j;
                            }
                            this.f10509g = 0;
                            this.f10508f = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    int min2 = Math.min(parsableByteArray.bytesLeft(), 4 - this.f10509g);
                    parsableByteArray.readBytes(parsableByteArray2.getData(), this.f10509g, min2);
                    int i4 = this.f10509g + min2;
                    this.f10509g = i4;
                    if (i4 >= 4) {
                        parsableByteArray2.setPosition(0);
                        int readInt = parsableByteArray2.readInt();
                        MpegAudioUtil.Header header = this.f10504b;
                        if (!header.setForHeaderData(readInt)) {
                            this.f10509g = 0;
                            this.f10508f = 1;
                        } else {
                            this.f10513k = header.frameSize;
                            if (!this.f10510h) {
                                this.f10512j = (header.samplesPerFrame * 1000000) / header.sampleRate;
                                this.f10506d.format(new Format.Builder().setId(this.f10507e).setSampleMimeType(header.mimeType).setMaxInputSize(4096).setChannelCount(header.channels).setSampleRate(header.sampleRate).setLanguage(this.f10505c).build());
                                this.f10510h = true;
                            }
                            parsableByteArray2.setPosition(0);
                            this.f10506d.sampleData(parsableByteArray2, 4);
                            this.f10508f = 2;
                        }
                    }
                }
            } else {
                byte[] data = parsableByteArray.getData();
                int position = parsableByteArray.getPosition();
                int limit = parsableByteArray.limit();
                while (true) {
                    if (position < limit) {
                        byte b = data[position];
                        if ((b & 255) == 255) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.f10511i && (b & 224) == 224) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f10511i = z;
                        if (z2) {
                            parsableByteArray.setPosition(position + 1);
                            this.f10511i = false;
                            parsableByteArray2.getData()[1] = data[position];
                            this.f10509g = 2;
                            this.f10508f = 1;
                            break;
                        }
                        position++;
                    } else {
                        parsableByteArray.setPosition(limit);
                        break;
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10507e = trackIdGenerator.getFormatId();
        this.f10506d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10514l = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10508f = 0;
        this.f10509g = 0;
        this.f10511i = false;
        this.f10514l = C0643C.TIME_UNSET;
    }

    public MpegAudioReader(@Nullable String str) {
        this.f10508f = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f10503a = parsableByteArray;
        parsableByteArray.getData()[0] = -1;
        this.f10504b = new MpegAudioUtil.Header();
        this.f10514l = C0643C.TIME_UNSET;
        this.f10505c = str;
    }
}
