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

/* renamed from: com.google.android.exoplayer2.extractor.ts.c */
/* loaded from: classes.dex */
public final class C0671c {

    /* renamed from: a */
    public final List f10580a;

    /* renamed from: b */
    public final TrackOutput[] f10581b;

    public C0671c(List list) {
        this.f10580a = list;
        this.f10581b = new TrackOutput[list.size()];
    }

    /* renamed from: a */
    public final void m2568a(long j, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 9) {
            return;
        }
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (readInt == 434 && readInt2 == 1195456820 && readUnsignedByte == 3) {
            CeaUtil.consumeCcData(j, parsableByteArray, this.f10581b);
        }
    }

    /* renamed from: b */
    public final void m2569b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z;
        int i = 0;
        while (true) {
            TrackOutput[] trackOutputArr = this.f10581b;
            if (i < trackOutputArr.length) {
                trackIdGenerator.generateNewId();
                TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
                Format format = (Format) this.f10580a.get(i);
                String str = format.sampleMimeType;
                if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                    z = false;
                } else {
                    z = true;
                }
                Assertions.checkArgument(z, "Invalid closed caption mime type provided: " + str);
                track.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(str).setSelectionFlags(format.selectionFlags).setLanguage(format.language).setAccessibilityChannel(format.accessibilityChannel).setInitializationData(format.initializationData).build());
                trackOutputArr[i] = track;
                i++;
            } else {
                return;
            }
        }
    }
}
