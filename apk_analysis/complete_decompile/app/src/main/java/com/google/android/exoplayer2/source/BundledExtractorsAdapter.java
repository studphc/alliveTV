package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.util.List;
import java.util.Map;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a */
    public final ExtractorsFactory f10906a;

    /* renamed from: b */
    public Extractor f10907b;

    /* renamed from: c */
    public DefaultExtractorInput f10908c;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.f10906a = extractorsFactory;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void disableSeekingOnMp3Streams() {
        Extractor extractor = this.f10907b;
        if (extractor instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor).disableSeeking();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long getCurrentInputPosition() {
        DefaultExtractorInput defaultExtractorInput = this.f10908c;
        if (defaultExtractorInput != null) {
            return defaultExtractorInput.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r6.getPosition() != r11) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        if (r6.getPosition() != r11) goto L22;
     */
    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) {
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataReader, j, j2);
        this.f10908c = defaultExtractorInput;
        if (this.f10907b != null) {
            return;
        }
        Extractor[] createExtractors = this.f10906a.createExtractors(uri, map);
        boolean z = true;
        if (createExtractors.length == 1) {
            this.f10907b = createExtractors[0];
        } else {
            int length = createExtractors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Extractor extractor = createExtractors[i];
                try {
                } catch (EOFException unused) {
                    if (this.f10907b == null) {
                    }
                } catch (Throwable th) {
                    if (this.f10907b == null && defaultExtractorInput.getPosition() != j) {
                        z = false;
                    }
                    Assertions.checkState(z);
                    defaultExtractorInput.resetPeekPosition();
                    throw th;
                }
                if (extractor.sniff(defaultExtractorInput)) {
                    this.f10907b = extractor;
                    Assertions.checkState(true);
                    defaultExtractorInput.resetPeekPosition();
                    break;
                } else {
                    if (this.f10907b == null) {
                    }
                    boolean z2 = true;
                    Assertions.checkState(z2);
                    defaultExtractorInput.resetPeekPosition();
                    i++;
                }
            }
            if (this.f10907b == null) {
                throw new UnrecognizedInputFormatException(AbstractC1726qj.m7061q(new StringBuilder("None of the available extractors ("), Util.getCommaDelimitedSimpleClassNames(createExtractors), ") could read the stream."), (Uri) Assertions.checkNotNull(uri));
            }
        }
        this.f10907b.init(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int read(PositionHolder positionHolder) {
        return ((Extractor) Assertions.checkNotNull(this.f10907b)).read((ExtractorInput) Assertions.checkNotNull(this.f10908c), positionHolder);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        Extractor extractor = this.f10907b;
        if (extractor != null) {
            extractor.release();
            this.f10907b = null;
        }
        this.f10908c = null;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long j, long j2) {
        ((Extractor) Assertions.checkNotNull(this.f10907b)).seek(j, j2);
    }
}
