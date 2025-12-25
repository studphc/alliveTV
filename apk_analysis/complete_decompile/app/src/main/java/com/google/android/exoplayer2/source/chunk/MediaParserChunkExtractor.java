package com.google.android.exoplayer2.source.chunk;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import p000.ee0;
import p000.ql1;

@RequiresApi(30)
/* loaded from: classes.dex */
public final class MediaParserChunkExtractor implements ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = new ee0(16);

    /* renamed from: a */
    public final OutputConsumerAdapterV30 f11188a;

    /* renamed from: b */
    public final InputReaderAdapterV30 f11189b;

    /* renamed from: c */
    public final MediaParser f11190c;

    /* renamed from: d */
    public final C0692b f11191d;

    /* renamed from: e */
    public final DummyTrackOutput f11192e;

    /* renamed from: f */
    public long f11193f;

    /* renamed from: g */
    public ChunkExtractor.TrackOutputProvider f11194g;

    /* renamed from: h */
    public Format[] f11195h;

    @SuppressLint({"WrongConstant"})
    public MediaParserChunkExtractor(int i, Format format, List<Format> list, PlayerId playerId) {
        String str;
        MediaParser createByName;
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30(format, i, true);
        this.f11188a = outputConsumerAdapterV30;
        this.f11189b = new InputReaderAdapterV30();
        if (MimeTypes.isMatroska((String) Assertions.checkNotNull(format.containerMimeType))) {
            str = "android.media.mediaparser.MatroskaParser";
        } else {
            str = "android.media.mediaparser.FragmentedMp4Parser";
        }
        outputConsumerAdapterV30.setSelectedParserName(str);
        createByName = MediaParser.createByName(str, outputConsumerAdapterV30);
        this.f11190c = createByName;
        createByName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_INCLUDE_SUPPLEMENTAL_DATA, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_DUMMY_SEEK_MAP, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CHUNK_INDEX_AS_MEDIA_FORMAT, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, Boolean.TRUE);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(MediaParserUtil.toCaptionsMediaFormat(list.get(i2)));
        }
        this.f11190c.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, arrayList);
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(this.f11190c, playerId);
        }
        this.f11188a.setMuxedCaptionFormats(list);
        this.f11191d = new C0692b(this);
        this.f11192e = new DummyTrackOutput();
        this.f11193f = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public ChunkIndex getChunkIndex() {
        return this.f11188a.getChunkIndex();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public Format[] getSampleFormats() {
        return this.f11195h;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void init(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.f11194g = trackOutputProvider;
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = this.f11188a;
        outputConsumerAdapterV30.setSampleTimestampUpperLimitFilterUs(j2);
        outputConsumerAdapterV30.setExtractorOutput(this.f11191d);
        this.f11193f = j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean read(ExtractorInput extractorInput) {
        boolean advance;
        Pair seekPoints;
        MediaParser.SeekMap dummySeekMap = this.f11188a.getDummySeekMap();
        long j = this.f11193f;
        if (j != C0643C.TIME_UNSET && dummySeekMap != null) {
            MediaParser mediaParser = this.f11190c;
            seekPoints = dummySeekMap.getSeekPoints(j);
            mediaParser.seek(ql1.m7087e(seekPoints.first));
            this.f11193f = C0643C.TIME_UNSET;
        }
        long length = extractorInput.getLength();
        InputReaderAdapterV30 inputReaderAdapterV30 = this.f11189b;
        inputReaderAdapterV30.setDataReader(extractorInput, length);
        advance = this.f11190c.advance(inputReaderAdapterV30);
        return advance;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void release() {
        this.f11190c.release();
    }
}
