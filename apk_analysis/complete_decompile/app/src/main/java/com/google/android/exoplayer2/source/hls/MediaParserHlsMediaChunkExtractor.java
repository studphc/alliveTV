package com.google.android.exoplayer2.source.hls;

import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.MediaParser$OutputConsumer;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import p000.ee0;

@RequiresApi(30)
/* loaded from: classes.dex */
public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    public static final HlsExtractorFactory FACTORY = new ee0(18);

    /* renamed from: a */
    public final OutputConsumerAdapterV30 f11432a;

    /* renamed from: b */
    public final InputReaderAdapterV30 f11433b = new InputReaderAdapterV30();

    /* renamed from: c */
    public final MediaParser f11434c;

    /* renamed from: d */
    public final Format f11435d;

    /* renamed from: e */
    public final boolean f11436e;

    /* renamed from: f */
    public final ImmutableList f11437f;

    /* renamed from: g */
    public final PlayerId f11438g;

    /* renamed from: h */
    public int f11439h;

    public MediaParserHlsMediaChunkExtractor(MediaParser mediaParser, OutputConsumerAdapterV30 outputConsumerAdapterV30, Format format, boolean z, ImmutableList<MediaFormat> immutableList, int i, PlayerId playerId) {
        this.f11434c = mediaParser;
        this.f11432a = outputConsumerAdapterV30;
        this.f11436e = z;
        this.f11437f = immutableList;
        this.f11435d = format;
        this.f11438g = playerId;
        this.f11439h = i;
    }

    /* renamed from: a */
    public static MediaParser m2794a(MediaParser$OutputConsumer mediaParser$OutputConsumer, Format format, boolean z, ImmutableList immutableList, PlayerId playerId, String... strArr) {
        MediaParser createByName = strArr.length == 1 ? MediaParser.createByName(strArr[0], mediaParser$OutputConsumer) : MediaParser.create(mediaParser$OutputConsumer, strArr);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, immutableList);
        createByName.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, Boolean.valueOf(z));
        createByName.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, Boolean.TRUE);
        createByName.setParameter(MediaParserUtil.PARAMETER_IGNORE_TIMESTAMP_OFFSET, Boolean.TRUE);
        createByName.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", Boolean.TRUE);
        createByName.setParameter("android.media.mediaparser.ts.mode", "hls");
        String str = format.codecs;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.AUDIO_AAC.equals(MimeTypes.getAudioMediaMimeType(str))) {
                createByName.setParameter("android.media.mediaparser.ts.ignoreAacStream", Boolean.TRUE);
            }
            if (!MimeTypes.VIDEO_H264.equals(MimeTypes.getVideoMediaMimeType(str))) {
                createByName.setParameter("android.media.mediaparser.ts.ignoreAvcStream", Boolean.TRUE);
            }
        }
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(createByName, playerId);
        }
        return createByName;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void init(ExtractorOutput extractorOutput) {
        this.f11432a.setExtractorOutput(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isPackedAudioExtractor() {
        String parserName;
        parserName = this.f11434c.getParserName();
        if (!"android.media.mediaparser.Ac3Parser".equals(parserName) && !"android.media.mediaparser.Ac4Parser".equals(parserName) && !"android.media.mediaparser.AdtsParser".equals(parserName) && !"android.media.mediaparser.Mp3Parser".equals(parserName)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isReusable() {
        String parserName;
        parserName = this.f11434c.getParserName();
        if (!"android.media.mediaparser.FragmentedMp4Parser".equals(parserName) && !"android.media.mediaparser.TsParser".equals(parserName)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void onTruncatedSegmentParsed() {
        MediaParser.SeekPoint seekPoint;
        MediaParser mediaParser = this.f11434c;
        seekPoint = MediaParser.SeekPoint.START;
        mediaParser.seek(seekPoint);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean read(ExtractorInput extractorInput) {
        boolean advance;
        extractorInput.skipFully(this.f11439h);
        this.f11439h = 0;
        long length = extractorInput.getLength();
        InputReaderAdapterV30 inputReaderAdapterV30 = this.f11433b;
        inputReaderAdapterV30.setDataReader(extractorInput, length);
        advance = this.f11434c.advance(inputReaderAdapterV30);
        return advance;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor recreate() {
        String parserName;
        Assertions.checkState(!isReusable());
        parserName = this.f11434c.getParserName();
        return new MediaParserHlsMediaChunkExtractor(m2794a(this.f11432a, this.f11435d, this.f11436e, this.f11437f, this.f11438g, parserName), this.f11432a, this.f11435d, this.f11436e, this.f11437f, 0, this.f11438g);
    }
}
