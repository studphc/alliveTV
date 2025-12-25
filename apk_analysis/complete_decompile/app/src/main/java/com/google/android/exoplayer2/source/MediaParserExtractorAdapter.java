package com.google.android.exoplayer2.source;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;
import p000.ee0;
import p000.ql1;

@RequiresApi(30)
/* loaded from: classes.dex */
public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor {
    public static final ProgressiveMediaExtractor.Factory FACTORY = new ee0(17);

    /* renamed from: a */
    public final OutputConsumerAdapterV30 f10979a;

    /* renamed from: b */
    public final InputReaderAdapterV30 f10980b;

    /* renamed from: c */
    public final MediaParser f10981c;

    /* renamed from: d */
    public String f10982d;

    @SuppressLint({"WrongConstant"})
    public MediaParserExtractorAdapter(PlayerId playerId) {
        MediaParser create;
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        this.f10979a = outputConsumerAdapterV30;
        this.f10980b = new InputReaderAdapterV30();
        create = MediaParser.create(outputConsumerAdapterV30, new String[0]);
        this.f10981c = create;
        create.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, Boolean.TRUE);
        create.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, Boolean.TRUE);
        create.setParameter(MediaParserUtil.PARAMETER_INCLUDE_SUPPLEMENTAL_DATA, Boolean.TRUE);
        this.f10982d = "android.media.mediaparser.UNKNOWN";
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(create, playerId);
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void disableSeekingOnMp3Streams() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.f10982d)) {
            this.f10979a.disableSeeking();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long getCurrentInputPosition() {
        return this.f10980b.getPosition();
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void init(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) {
        String parserName;
        String parserName2;
        String parserName3;
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = this.f10979a;
        outputConsumerAdapterV30.setExtractorOutput(extractorOutput);
        InputReaderAdapterV30 inputReaderAdapterV30 = this.f10980b;
        inputReaderAdapterV30.setDataReader(dataReader, j2);
        inputReaderAdapterV30.setCurrentPosition(j);
        parserName = this.f10981c.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(parserName)) {
            this.f10981c.advance(inputReaderAdapterV30);
            parserName3 = this.f10981c.getParserName();
            this.f10982d = parserName3;
            outputConsumerAdapterV30.setSelectedParserName(parserName3);
            return;
        }
        if (!parserName.equals(this.f10982d)) {
            parserName2 = this.f10981c.getParserName();
            this.f10982d = parserName2;
            outputConsumerAdapterV30.setSelectedParserName(parserName2);
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int read(PositionHolder positionHolder) {
        boolean advance;
        MediaParser mediaParser = this.f10981c;
        InputReaderAdapterV30 inputReaderAdapterV30 = this.f10980b;
        advance = mediaParser.advance(inputReaderAdapterV30);
        long andResetSeekPosition = inputReaderAdapterV30.getAndResetSeekPosition();
        positionHolder.position = andResetSeekPosition;
        if (!advance) {
            return -1;
        }
        if (andResetSeekPosition != -1) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        this.f10981c.release();
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long j, long j2) {
        long j3;
        Object obj;
        this.f10980b.setCurrentPosition(j);
        Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> seekPoints = this.f10979a.getSeekPoints(j2);
        MediaParser mediaParser = this.f10981c;
        j3 = ql1.m7087e(seekPoints.second).position;
        if (j3 == j) {
            obj = seekPoints.second;
        } else {
            obj = seekPoints.first;
        }
        mediaParser.seek(ql1.m7087e(obj));
    }
}
