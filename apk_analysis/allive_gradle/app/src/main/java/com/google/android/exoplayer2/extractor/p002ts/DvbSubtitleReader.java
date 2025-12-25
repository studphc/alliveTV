package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* renamed from: a */
    public final List f10412a;

    /* renamed from: b */
    public final TrackOutput[] f10413b;

    /* renamed from: c */
    public boolean f10414c;

    /* renamed from: d */
    public int f10415d;

    /* renamed from: e */
    public int f10416e;

    /* renamed from: f */
    public long f10417f = C0643C.TIME_UNSET;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.f10412a = list;
        this.f10413b = new TrackOutput[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        boolean z;
        boolean z2;
        if (this.f10414c) {
            if (this.f10415d == 2) {
                if (parsableByteArray.bytesLeft() == 0) {
                    z2 = false;
                } else {
                    if (parsableByteArray.readUnsignedByte() != 32) {
                        this.f10414c = false;
                    }
                    this.f10415d--;
                    z2 = this.f10414c;
                }
                if (!z2) {
                    return;
                }
            }
            if (this.f10415d == 1) {
                if (parsableByteArray.bytesLeft() == 0) {
                    z = false;
                } else {
                    if (parsableByteArray.readUnsignedByte() != 0) {
                        this.f10414c = false;
                    }
                    this.f10415d--;
                    z = this.f10414c;
                }
                if (!z) {
                    return;
                }
            }
            int position = parsableByteArray.getPosition();
            int bytesLeft = parsableByteArray.bytesLeft();
            for (TrackOutput trackOutput : this.f10413b) {
                parsableByteArray.setPosition(position);
                trackOutput.sampleData(parsableByteArray, bytesLeft);
            }
            this.f10416e += bytesLeft;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        int i = 0;
        while (true) {
            TrackOutput[] trackOutputArr = this.f10413b;
            if (i < trackOutputArr.length) {
                TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = (TsPayloadReader.DvbSubtitleInfo) this.f10412a.get(i);
                trackIdGenerator.generateNewId();
                TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
                track.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_DVBSUBS).setInitializationData(Collections.singletonList(dvbSubtitleInfo.initializationData)).setLanguage(dvbSubtitleInfo.language).build());
                trackOutputArr[i] = track;
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.f10414c) {
            if (this.f10417f != C0643C.TIME_UNSET) {
                for (TrackOutput trackOutput : this.f10413b) {
                    trackOutput.sampleMetadata(this.f10417f, 1, this.f10416e, 0, null);
                }
            }
            this.f10414c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f10414c = true;
        if (j != C0643C.TIME_UNSET) {
            this.f10417f = j;
        }
        this.f10416e = 0;
        this.f10415d = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10414c = false;
        this.f10417f = C0643C.TIME_UNSET;
    }
}
