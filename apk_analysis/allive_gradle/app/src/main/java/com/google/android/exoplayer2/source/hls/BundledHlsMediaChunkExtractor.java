package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes.dex */
public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: d */
    public static final PositionHolder f11375d = new PositionHolder();

    /* renamed from: a */
    public final Extractor f11376a;

    /* renamed from: b */
    public final Format f11377b;

    /* renamed from: c */
    public final TimestampAdjuster f11378c;

    public BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster) {
        this.f11376a = extractor;
        this.f11377b = format;
        this.f11378c = timestampAdjuster;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void init(ExtractorOutput extractorOutput) {
        this.f11376a.init(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isPackedAudioExtractor() {
        Extractor extractor = this.f11376a;
        if (!(extractor instanceof AdtsExtractor) && !(extractor instanceof Ac3Extractor) && !(extractor instanceof Ac4Extractor) && !(extractor instanceof Mp3Extractor)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isReusable() {
        Extractor extractor = this.f11376a;
        if (!(extractor instanceof TsExtractor) && !(extractor instanceof FragmentedMp4Extractor)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void onTruncatedSegmentParsed() {
        this.f11376a.seek(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean read(ExtractorInput extractorInput) {
        if (this.f11376a.read(extractorInput, f11375d) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor recreate() {
        Extractor mp3Extractor;
        Assertions.checkState(!isReusable());
        Extractor extractor = this.f11376a;
        boolean z = extractor instanceof WebvttExtractor;
        TimestampAdjuster timestampAdjuster = this.f11378c;
        Format format = this.f11377b;
        if (z) {
            mp3Extractor = new WebvttExtractor(format.language, timestampAdjuster);
        } else if (extractor instanceof AdtsExtractor) {
            mp3Extractor = new AdtsExtractor();
        } else if (extractor instanceof Ac3Extractor) {
            mp3Extractor = new Ac3Extractor();
        } else if (extractor instanceof Ac4Extractor) {
            mp3Extractor = new Ac4Extractor();
        } else if (extractor instanceof Mp3Extractor) {
            mp3Extractor = new Mp3Extractor();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: ".concat(extractor.getClass().getSimpleName()));
        }
        return new BundledHlsMediaChunkExtractor(mp3Extractor, format, timestampAdjuster);
    }
}
