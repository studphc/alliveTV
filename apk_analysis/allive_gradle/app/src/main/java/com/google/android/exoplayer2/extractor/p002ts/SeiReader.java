package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

/* loaded from: classes.dex */
public final class SeiReader {

    /* renamed from: a */
    public final List f10547a;

    /* renamed from: b */
    public final TrackOutput[] f10548b;

    public SeiReader(List<Format> list) {
        this.f10547a = list;
        this.f10548b = new TrackOutput[list.size()];
    }

    public void consume(long j, ParsableByteArray parsableByteArray) {
        CeaUtil.consume(j, parsableByteArray, this.f10548b);
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z;
        int i = 0;
        while (true) {
            TrackOutput[] trackOutputArr = this.f10548b;
            if (i < trackOutputArr.length) {
                trackIdGenerator.generateNewId();
                TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
                Format format = (Format) this.f10547a.get(i);
                String str = format.sampleMimeType;
                if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                    z = false;
                } else {
                    z = true;
                }
                Assertions.checkArgument(z, "Invalid closed caption mime type provided: " + str);
                String str2 = format.f9354id;
                if (str2 == null) {
                    str2 = trackIdGenerator.getFormatId();
                }
                track.format(new Format.Builder().setId(str2).setSampleMimeType(str).setSelectionFlags(format.selectionFlags).setLanguage(format.language).setAccessibilityChannel(format.accessibilityChannel).setInitializationData(format.initializationData).build());
                trackOutputArr[i] = track;
                i++;
            } else {
                return;
            }
        }
    }
}
