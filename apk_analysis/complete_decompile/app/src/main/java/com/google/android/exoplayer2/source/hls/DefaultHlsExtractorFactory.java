package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.p002ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {

    /* renamed from: c */
    public static final int[] f11380c = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: a */
    public final int f11381a;

    /* renamed from: b */
    public final boolean f11382b;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    /* renamed from: a */
    public static void m2790a(ArrayList arrayList, int i) {
        if (Ints.indexOf(f11380c, i) != -1 && !arrayList.contains(Integer.valueOf(i))) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public /* bridge */ /* synthetic */ HlsMediaChunkExtractor createExtractor(Uri uri, Format format, @Nullable List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId) {
        return createExtractor(uri, format, (List<Format>) list, timestampAdjuster, (Map<String, List<String>>) map, extractorInput, playerId);
    }

    public DefaultHlsExtractorFactory(int i, boolean z) {
        this.f11381a = i;
        this.f11382b = z;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public BundledHlsMediaChunkExtractor createExtractor(Uri uri, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) {
        boolean z;
        Object ac3Extractor;
        boolean z2;
        boolean z3;
        List<Format> emptyList;
        int inferFileTypeFromMimeType = FileTypes.inferFileTypeFromMimeType(format.sampleMimeType);
        int inferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
        int inferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
        int i = 7;
        ArrayList arrayList = new ArrayList(7);
        m2790a(arrayList, inferFileTypeFromMimeType);
        m2790a(arrayList, inferFileTypeFromResponseHeaders);
        m2790a(arrayList, inferFileTypeFromUri);
        int[] iArr = f11380c;
        for (int i2 = 0; i2 < 7; i2++) {
            m2790a(arrayList, iArr[i2]);
        }
        extractorInput.resetPeekPosition();
        int i3 = 0;
        Extractor extractor = null;
        while (i3 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            if (intValue == 0) {
                z = false;
                ac3Extractor = new Ac3Extractor();
            } else if (intValue == 1) {
                z = false;
                ac3Extractor = new Ac4Extractor();
            } else if (intValue == 2) {
                z = false;
                ac3Extractor = new AdtsExtractor();
            } else if (intValue != i) {
                if (intValue == 8) {
                    Metadata metadata = format.metadata;
                    if (metadata != null) {
                        for (int i4 = 0; i4 < metadata.length(); i4++) {
                            Metadata.Entry entry = metadata.get(i4);
                            if (entry instanceof HlsTrackMetadataEntry) {
                                z3 = !((HlsTrackMetadataEntry) entry).variantInfos.isEmpty();
                                break;
                            }
                        }
                    }
                    z3 = false;
                    ac3Extractor = new FragmentedMp4Extractor(z3 ? 4 : 0, timestampAdjuster, null, list != null ? list : Collections.emptyList());
                } else if (intValue != 11) {
                    ac3Extractor = intValue != 13 ? null : new WebvttExtractor(format.language, timestampAdjuster);
                } else {
                    int i5 = this.f11381a;
                    int i6 = i5 | 16;
                    if (list != null) {
                        i6 = i5 | 48;
                        emptyList = list;
                    } else if (this.f11382b) {
                        emptyList = Collections.singletonList(new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).build());
                    } else {
                        emptyList = Collections.emptyList();
                    }
                    String str = format.codecs;
                    if (!TextUtils.isEmpty(str)) {
                        if (!MimeTypes.containsCodecsCorrespondingToMimeType(str, MimeTypes.AUDIO_AAC)) {
                            i6 |= 2;
                        }
                        if (!MimeTypes.containsCodecsCorrespondingToMimeType(str, MimeTypes.VIDEO_H264)) {
                            i6 |= 4;
                        }
                    }
                    ac3Extractor = new TsExtractor(2, timestampAdjuster, new DefaultTsPayloadReaderFactory(i6, emptyList));
                }
                z = false;
            } else {
                z = false;
                ac3Extractor = new Mp3Extractor(0, 0L);
            }
            Extractor extractor2 = (Extractor) Assertions.checkNotNull(ac3Extractor);
            try {
                z2 = extractor2.sniff(extractorInput);
                extractorInput.resetPeekPosition();
            } catch (EOFException unused) {
                extractorInput.resetPeekPosition();
                z2 = z;
            } catch (Throwable th) {
                extractorInput.resetPeekPosition();
                throw th;
            }
            if (z2) {
                return new BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster);
            }
            if (extractor == null && (intValue == inferFileTypeFromMimeType || intValue == inferFileTypeFromResponseHeaders || intValue == inferFileTypeFromUri || intValue == 11)) {
                extractor = extractor2;
            }
            i3++;
            i = 7;
        }
        return new BundledHlsMediaChunkExtractor((Extractor) Assertions.checkNotNull(extractor), format, timestampAdjuster);
    }
}
