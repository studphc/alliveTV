package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class WebvttExtractor implements Extractor {

    /* renamed from: g */
    public static final Pattern f11441g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h */
    public static final Pattern f11442h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a */
    public final String f11443a;

    /* renamed from: b */
    public final TimestampAdjuster f11444b;

    /* renamed from: d */
    public ExtractorOutput f11446d;

    /* renamed from: f */
    public int f11448f;

    /* renamed from: c */
    public final ParsableByteArray f11445c = new ParsableByteArray();

    /* renamed from: e */
    public byte[] f11447e = new byte[1024];

    public WebvttExtractor(@Nullable String str, TimestampAdjuster timestampAdjuster) {
        this.f11443a = str;
        this.f11444b = timestampAdjuster;
    }

    /* renamed from: a */
    public final TrackOutput m2795a(long j) {
        TrackOutput track = this.f11446d.track(0, 3);
        track.format(new Format.Builder().setSampleMimeType(MimeTypes.TEXT_VTT).setLanguage(this.f11443a).setSubsampleOffsetUs(j).build());
        this.f11446d.endTracks();
        return track;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f11446d = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(C0643C.TIME_UNSET));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int length;
        Assertions.checkNotNull(this.f11446d);
        int length2 = (int) extractorInput.getLength();
        int i = this.f11448f;
        byte[] bArr = this.f11447e;
        if (i == bArr.length) {
            if (length2 != -1) {
                length = length2;
            } else {
                length = bArr.length;
            }
            this.f11447e = Arrays.copyOf(bArr, (length * 3) / 2);
        }
        byte[] bArr2 = this.f11447e;
        int i2 = this.f11448f;
        int read = extractorInput.read(bArr2, i2, bArr2.length - i2);
        if (read != -1) {
            int i3 = this.f11448f + read;
            this.f11448f = i3;
            if (length2 == -1 || i3 != length2) {
                return 0;
            }
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f11447e);
        WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
        long j = 0;
        long j2 = 0;
        for (String readLine = parsableByteArray.readLine(); !TextUtils.isEmpty(readLine); readLine = parsableByteArray.readLine()) {
            if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f11441g.matcher(readLine);
                if (matcher.find()) {
                    Matcher matcher2 = f11442h.matcher(readLine);
                    if (matcher2.find()) {
                        j2 = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(1)));
                        j = TimestampAdjuster.ptsToUs(Long.parseLong((String) Assertions.checkNotNull(matcher2.group(1))));
                    } else {
                        throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(readLine), null);
                    }
                } else {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(readLine), null);
                }
            }
        }
        Matcher findNextCueHeader = WebvttParserUtil.findNextCueHeader(parsableByteArray);
        if (findNextCueHeader == null) {
            m2795a(0L);
        } else {
            long parseTimestampUs = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(findNextCueHeader.group(1)));
            long adjustTsTimestamp = this.f11444b.adjustTsTimestamp(TimestampAdjuster.usToWrappedPts((j + parseTimestampUs) - j2));
            TrackOutput m2795a = m2795a(adjustTsTimestamp - parseTimestampUs);
            byte[] bArr3 = this.f11447e;
            int i4 = this.f11448f;
            ParsableByteArray parsableByteArray2 = this.f11445c;
            parsableByteArray2.reset(bArr3, i4);
            m2795a.sampleData(parsableByteArray2, this.f11448f);
            m2795a.sampleMetadata(adjustTsTimestamp, 1, this.f11448f, 0, null);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        extractorInput.peekFully(this.f11447e, 0, 6, false);
        byte[] bArr = this.f11447e;
        ParsableByteArray parsableByteArray = this.f11445c;
        parsableByteArray.reset(bArr, 6);
        if (WebvttParserUtil.isWebvttHeaderLine(parsableByteArray)) {
            return true;
        }
        extractorInput.peekFully(this.f11447e, 6, 3, false);
        parsableByteArray.reset(this.f11447e, 9);
        return WebvttParserUtil.isWebvttHeaderLine(parsableByteArray);
    }
}
