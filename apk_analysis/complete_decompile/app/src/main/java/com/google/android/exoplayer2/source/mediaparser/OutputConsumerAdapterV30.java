package com.google.android.exoplayer2.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.MediaParser$InputReader;
import android.media.MediaParser$OutputConsumer;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.os.EnvironmentCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.r12;
import p000.s12;

@RequiresApi(30)
@SuppressLint({"Override"})
/* loaded from: classes.dex */
public final class OutputConsumerAdapterV30 implements MediaParser$OutputConsumer {

    /* renamed from: u */
    public static final Pair f11590u;

    /* renamed from: v */
    public static final Pattern f11591v;

    /* renamed from: a */
    public final ArrayList f11592a;

    /* renamed from: b */
    public final ArrayList f11593b;

    /* renamed from: c */
    public final ArrayList f11594c;

    /* renamed from: d */
    public final ArrayList f11595d;

    /* renamed from: e */
    public final r12 f11596e;

    /* renamed from: f */
    public final boolean f11597f;

    /* renamed from: g */
    public final int f11598g;

    /* renamed from: h */
    public final Format f11599h;

    /* renamed from: i */
    public ExtractorOutput f11600i;

    /* renamed from: j */
    public MediaParser.SeekMap f11601j;

    /* renamed from: k */
    public MediaParser.SeekMap f11602k;

    /* renamed from: l */
    public String f11603l;

    /* renamed from: m */
    public ChunkIndex f11604m;

    /* renamed from: n */
    public TimestampAdjuster f11605n;

    /* renamed from: o */
    public List f11606o;

    /* renamed from: p */
    public int f11607p;

    /* renamed from: q */
    public long f11608q;

    /* renamed from: r */
    public boolean f11609r;

    /* renamed from: s */
    public boolean f11610s;

    /* renamed from: t */
    public boolean f11611t;

    static {
        MediaParser.SeekPoint seekPoint;
        MediaParser.SeekPoint seekPoint2;
        seekPoint = MediaParser.SeekPoint.START;
        seekPoint2 = MediaParser.SeekPoint.START;
        f11590u = Pair.create(seekPoint, seekPoint2);
        f11591v = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    }

    public OutputConsumerAdapterV30() {
        this(null, -2, false);
    }

    /* renamed from: a */
    public final void m2825a(int i) {
        for (int size = this.f11592a.size(); size <= i; size++) {
            this.f11592a.add(null);
            this.f11593b.add(null);
            this.f11594c.add(null);
            this.f11595d.add(null);
        }
    }

    /* renamed from: b */
    public final void m2826b() {
        if (this.f11609r && !this.f11610s) {
            int size = this.f11592a.size();
            for (int i = 0; i < size; i++) {
                if (this.f11592a.get(i) == null) {
                    return;
                }
            }
            this.f11600i.endTracks();
            this.f11610s = true;
        }
    }

    public void disableSeeking() {
        this.f11611t = true;
    }

    @Nullable
    public ChunkIndex getChunkIndex() {
        return this.f11604m;
    }

    @Nullable
    public MediaParser.SeekMap getDummySeekMap() {
        return this.f11601j;
    }

    @Nullable
    public Format[] getSampleFormats() {
        if (!this.f11609r) {
            return null;
        }
        Format[] formatArr = new Format[this.f11593b.size()];
        for (int i = 0; i < this.f11593b.size(); i++) {
            formatArr[i] = (Format) Assertions.checkNotNull((Format) this.f11593b.get(i));
        }
        return formatArr;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> getSeekPoints(long j) {
        Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> seekPoints;
        MediaParser.SeekMap seekMap = this.f11602k;
        if (seekMap != null) {
            seekPoints = seekMap.getSeekPoints(j);
            return seekPoints;
        }
        return f11590u;
    }

    public void onSampleCompleted(int i, long j, int i2, int i3, int i4, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        int i5;
        int i6;
        TrackOutput.CryptoData cryptoData;
        long j2 = this.f11608q;
        if (j2 != C0643C.TIME_UNSET && j >= j2) {
            return;
        }
        TimestampAdjuster timestampAdjuster = this.f11605n;
        if (timestampAdjuster != null) {
            j = timestampAdjuster.adjustSampleTimestamp(j);
        }
        long j3 = j;
        TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull((TrackOutput) this.f11592a.get(i));
        if (cryptoInfo == null) {
            cryptoData = null;
        } else if (((MediaCodec.CryptoInfo) this.f11594c.get(i)) == cryptoInfo) {
            cryptoData = (TrackOutput.CryptoData) Assertions.checkNotNull((TrackOutput.CryptoData) this.f11595d.get(i));
        } else {
            try {
                Matcher matcher = f11591v.matcher(cryptoInfo.toString());
                matcher.find();
                i5 = Integer.parseInt((String) Util.castNonNull(matcher.group(1)));
                i6 = Integer.parseInt((String) Util.castNonNull(matcher.group(2)));
            } catch (RuntimeException e) {
                Log.m3024e("OConsumerAdapterV30", "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e);
                i5 = 0;
                i6 = 0;
            }
            TrackOutput.CryptoData cryptoData2 = new TrackOutput.CryptoData(cryptoInfo.mode, cryptoInfo.key, i5, i6);
            this.f11594c.set(i, cryptoInfo);
            this.f11595d.set(i, cryptoData2);
            cryptoData = cryptoData2;
        }
        trackOutput.sampleMetadata(j3, i2, i3, i4, cryptoData);
    }

    public void onSampleDataFound(int i, MediaParser$InputReader mediaParser$InputReader) {
        long length;
        m2825a(i);
        this.f11596e.f25834a = mediaParser$InputReader;
        TrackOutput trackOutput = (TrackOutput) this.f11592a.get(i);
        if (trackOutput == null) {
            trackOutput = this.f11600i.track(i, -1);
            this.f11592a.set(i, trackOutput);
        }
        r12 r12Var = this.f11596e;
        length = mediaParser$InputReader.getLength();
        trackOutput.sampleData((DataReader) r12Var, (int) length, true);
    }

    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        long durationMicros;
        SeekMap s12Var;
        if (this.f11597f && this.f11601j == null) {
            this.f11601j = seekMap;
            return;
        }
        this.f11602k = seekMap;
        durationMicros = seekMap.getDurationMicros();
        ExtractorOutput extractorOutput = this.f11600i;
        if (this.f11611t) {
            if (durationMicros == -2147483648L) {
                durationMicros = C0643C.TIME_UNSET;
            }
            s12Var = new SeekMap.Unseekable(durationMicros);
        } else {
            s12Var = new s12(seekMap);
        }
        extractorOutput.seekMap(s12Var);
    }

    public void onTrackCountFound(int i) {
        this.f11609r = true;
        m2826b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0097 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTrackDataFound(int i, MediaParser.TrackData trackData) {
        MediaFormat mediaFormat;
        TrackOutput trackOutput;
        MediaFormat mediaFormat2;
        int integer;
        DrmInitData drmInitData;
        int schemeInitDataCount;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData2;
        DrmInitData.SchemeInitData schemeInitDataAt;
        UUID uuid;
        String str;
        byte[] bArr;
        int integer2;
        int integer3;
        byte[] bArr2;
        int integer4;
        int integer5;
        int integer6;
        ColorInfo colorInfo;
        float f;
        int integer7;
        int integer8;
        int integer9;
        int integer10;
        int integer11;
        int integer12;
        int integer13;
        int i2;
        int integer14;
        int i3;
        int integer15;
        int i4;
        int integer16;
        int integer17;
        float f2;
        long j;
        Format format;
        MediaFormat mediaFormat3;
        MediaFormat mediaFormat4;
        String string;
        char c;
        int i5 = 3;
        ArrayList arrayList = this.f11592a;
        mediaFormat = trackData.mediaFormat;
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("chunk-index-int-sizes");
        if (byteBuffer == null) {
            m2825a(i);
            TrackOutput trackOutput2 = (TrackOutput) arrayList.get(i);
            if (trackOutput2 == null) {
                mediaFormat3 = trackData.mediaFormat;
                String string2 = mediaFormat3.getString("track-type-string");
                if (string2 == null) {
                    mediaFormat4 = trackData.mediaFormat;
                    string = mediaFormat4.getString("mime");
                } else {
                    string = string2;
                }
                if (string != null) {
                    switch (string.hashCode()) {
                        case -450004177:
                            if (string.equals("metadata")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -284840886:
                            if (string.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3556653:
                            if (string.equals(MimeTypes.BASE_TYPE_TEXT)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 93166550:
                            if (string.equals(MimeTypes.BASE_TYPE_AUDIO)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 112202875:
                            if (string.equals(MimeTypes.BASE_TYPE_VIDEO)) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            i5 = 5;
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            i5 = 1;
                            break;
                        case 4:
                            i5 = 2;
                            break;
                        default:
                            i5 = MimeTypes.getTrackType(string);
                            break;
                    }
                    if (i5 == this.f11598g) {
                        this.f11607p = i;
                    }
                    trackOutput = this.f11600i.track(i, i5);
                    arrayList.set(i, trackOutput);
                    if (string2 != null) {
                        return;
                    }
                }
                i5 = -1;
                if (i5 == this.f11598g) {
                }
                trackOutput = this.f11600i.track(i, i5);
                arrayList.set(i, trackOutput);
                if (string2 != null) {
                }
            } else {
                trackOutput = trackOutput2;
            }
            mediaFormat2 = trackData.mediaFormat;
            String string3 = mediaFormat2.getString("mime");
            integer = mediaFormat2.getInteger("caption-service-number", -1);
            Format.Builder builder = new Format.Builder();
            String string4 = mediaFormat2.getString("crypto-mode-fourcc");
            drmInitData = trackData.drmInitData;
            if (drmInitData != null) {
                schemeInitDataCount = drmInitData.getSchemeInitDataCount();
                DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
                for (int i6 = 0; i6 < schemeInitDataCount; i6++) {
                    schemeInitDataAt = drmInitData.getSchemeInitDataAt(i6);
                    uuid = schemeInitDataAt.uuid;
                    str = schemeInitDataAt.mimeType;
                    bArr = schemeInitDataAt.data;
                    schemeDataArr[i6] = new DrmInitData.SchemeData(uuid, str, bArr);
                }
                drmInitData2 = new com.google.android.exoplayer2.drm.DrmInitData(string4, schemeDataArr);
            } else {
                drmInitData2 = null;
            }
            Format.Builder containerMimeType = builder.setDrmInitData(drmInitData2).setContainerMimeType(this.f11603l);
            integer2 = mediaFormat2.getInteger("bitrate", -1);
            Format.Builder peakBitrate = containerMimeType.setPeakBitrate(integer2);
            integer3 = mediaFormat2.getInteger("channel-count", -1);
            Format.Builder channelCount = peakBitrate.setChannelCount(integer3);
            ByteBuffer byteBuffer2 = mediaFormat2.getByteBuffer("hdr-static-info");
            if (byteBuffer2 != null) {
                bArr2 = new byte[byteBuffer2.remaining()];
                byteBuffer2.get(bArr2);
            } else {
                bArr2 = null;
            }
            integer4 = mediaFormat2.getInteger("color-transfer", -1);
            integer5 = mediaFormat2.getInteger("color-range", -1);
            integer6 = mediaFormat2.getInteger("color-standard", -1);
            if (bArr2 == null && integer4 == -1 && integer5 == -1 && integer6 == -1) {
                colorInfo = null;
            } else {
                colorInfo = new ColorInfo(integer6, integer5, integer4, bArr2);
            }
            Format.Builder codecs = channelCount.setColorInfo(colorInfo).setSampleMimeType(string3).setCodecs(mediaFormat2.getString("codecs-string"));
            f = mediaFormat2.getFloat("frame-rate", -1.0f);
            Format.Builder frameRate = codecs.setFrameRate(f);
            integer7 = mediaFormat2.getInteger("width", -1);
            Format.Builder width = frameRate.setWidth(integer7);
            integer8 = mediaFormat2.getInteger("height", -1);
            Format.Builder height = width.setHeight(integer8);
            ArrayList arrayList2 = new ArrayList();
            int i7 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder("csd-");
                int i8 = i7 + 1;
                sb.append(i7);
                ByteBuffer byteBuffer3 = mediaFormat2.getByteBuffer(sb.toString());
                if (byteBuffer3 == null) {
                    Format.Builder language = height.setInitializationData(arrayList2).setLanguage(mediaFormat2.getString("language"));
                    integer9 = mediaFormat2.getInteger("max-input-size", -1);
                    Format.Builder maxInputSize = language.setMaxInputSize(integer9);
                    integer10 = mediaFormat2.getInteger("exo-pcm-encoding", -1);
                    Format.Builder pcmEncoding = maxInputSize.setPcmEncoding(integer10);
                    integer11 = mediaFormat2.getInteger("rotation-degrees", 0);
                    Format.Builder rotationDegrees = pcmEncoding.setRotationDegrees(integer11);
                    integer12 = mediaFormat2.getInteger("sample-rate", -1);
                    Format.Builder sampleRate = rotationDegrees.setSampleRate(integer12);
                    integer13 = mediaFormat2.getInteger("is-autoselect", 0);
                    if (integer13 != 0) {
                        i2 = 4;
                    } else {
                        i2 = 0;
                    }
                    integer14 = mediaFormat2.getInteger("is-default", 0);
                    if (integer14 != 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    int i9 = i2 | i3;
                    integer15 = mediaFormat2.getInteger("is-forced-subtitle", 0);
                    if (integer15 != 0) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    Format.Builder selectionFlags = sampleRate.setSelectionFlags(i9 | i4);
                    integer16 = mediaFormat2.getInteger("encoder-delay", 0);
                    Format.Builder encoderDelay = selectionFlags.setEncoderDelay(integer16);
                    integer17 = mediaFormat2.getInteger("encoder-padding", 0);
                    Format.Builder encoderPadding = encoderDelay.setEncoderPadding(integer17);
                    f2 = mediaFormat2.getFloat("pixel-width-height-ratio-float", 1.0f);
                    Format.Builder pixelWidthHeightRatio = encoderPadding.setPixelWidthHeightRatio(f2);
                    j = mediaFormat2.getLong("subsample-offset-us-long", Long.MAX_VALUE);
                    Format.Builder accessibilityChannel = pixelWidthHeightRatio.setSubsampleOffsetUs(j).setAccessibilityChannel(integer);
                    int i10 = 0;
                    while (true) {
                        if (i10 < this.f11606o.size()) {
                            Format format2 = (Format) this.f11606o.get(i10);
                            if (Util.areEqual(format2.sampleMimeType, string3) && format2.accessibilityChannel == integer) {
                                accessibilityChannel.setLanguage(format2.language).setRoleFlags(format2.roleFlags).setSelectionFlags(format2.selectionFlags).setLabel(format2.label).setMetadata(format2.metadata);
                            } else {
                                i10++;
                            }
                        }
                    }
                    Format build = accessibilityChannel.build();
                    Format format3 = this.f11599h;
                    if (format3 != null && i == this.f11607p) {
                        format = build.withManifestFormatInfo(format3);
                    } else {
                        format = build;
                    }
                    trackOutput.format(format);
                    this.f11593b.set(i, build);
                    m2826b();
                    return;
                }
                byte[] bArr3 = new byte[byteBuffer3.remaining()];
                byteBuffer3.get(bArr3);
                arrayList2.add(bArr3);
                i7 = i8;
            }
        } else {
            IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
            LongBuffer asLongBuffer = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer("chunk-index-long-offsets"))).asLongBuffer();
            LongBuffer asLongBuffer2 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer("chunk-index-long-us-durations"))).asLongBuffer();
            LongBuffer asLongBuffer3 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer("chunk-index-long-us-times"))).asLongBuffer();
            int[] iArr = new int[asIntBuffer.remaining()];
            long[] jArr = new long[asLongBuffer.remaining()];
            long[] jArr2 = new long[asLongBuffer2.remaining()];
            long[] jArr3 = new long[asLongBuffer3.remaining()];
            asIntBuffer.get(iArr);
            asLongBuffer.get(jArr);
            asLongBuffer2.get(jArr2);
            asLongBuffer3.get(jArr3);
            ChunkIndex chunkIndex = new ChunkIndex(iArr, jArr, jArr2, jArr3);
            this.f11604m = chunkIndex;
            this.f11600i.seekMap(chunkIndex);
        }
    }

    public void setExtractorOutput(ExtractorOutput extractorOutput) {
        this.f11600i = extractorOutput;
    }

    public void setMuxedCaptionFormats(List<Format> list) {
        this.f11606o = list;
    }

    public void setSampleTimestampUpperLimitFilterUs(long j) {
        this.f11608q = j;
    }

    public void setSelectedParserName(String str) {
        String str2;
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -2063506020:
                if (str.equals("android.media.mediaparser.Mp4Parser")) {
                    c = 0;
                    break;
                }
                break;
            case -1870824006:
                if (str.equals("android.media.mediaparser.OggParser")) {
                    c = 1;
                    break;
                }
                break;
            case -1566427438:
                if (str.equals("android.media.mediaparser.TsParser")) {
                    c = 2;
                    break;
                }
                break;
            case -900207883:
                if (str.equals("android.media.mediaparser.AdtsParser")) {
                    c = 3;
                    break;
                }
                break;
            case -589864617:
                if (str.equals("android.media.mediaparser.WavParser")) {
                    c = 4;
                    break;
                }
                break;
            case 52265814:
                if (str.equals("android.media.mediaparser.PsParser")) {
                    c = 5;
                    break;
                }
                break;
            case 116768877:
                if (str.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    c = 6;
                    break;
                }
                break;
            case 376876796:
                if (str.equals("android.media.mediaparser.Ac3Parser")) {
                    c = 7;
                    break;
                }
                break;
            case 703268017:
                if (str.equals("android.media.mediaparser.AmrParser")) {
                    c = '\b';
                    break;
                }
                break;
            case 768643067:
                if (str.equals("android.media.mediaparser.FlacParser")) {
                    c = '\t';
                    break;
                }
                break;
            case 965962719:
                if (str.equals("android.media.mediaparser.MatroskaParser")) {
                    c = '\n';
                    break;
                }
                break;
            case 1264380477:
                if (str.equals("android.media.mediaparser.Ac4Parser")) {
                    c = 11;
                    break;
                }
                break;
            case 1343957595:
                if (str.equals("android.media.mediaparser.Mp3Parser")) {
                    c = '\f';
                    break;
                }
                break;
            case 2063134683:
                if (str.equals("android.media.mediaparser.FlvParser")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 6:
                str2 = MimeTypes.VIDEO_MP4;
                break;
            case 1:
                str2 = MimeTypes.AUDIO_OGG;
                break;
            case 2:
                str2 = MimeTypes.VIDEO_MP2T;
                break;
            case 3:
                str2 = MimeTypes.AUDIO_AAC;
                break;
            case 4:
                str2 = MimeTypes.AUDIO_RAW;
                break;
            case 5:
                str2 = MimeTypes.VIDEO_PS;
                break;
            case 7:
                str2 = MimeTypes.AUDIO_AC3;
                break;
            case '\b':
                str2 = MimeTypes.AUDIO_AMR;
                break;
            case '\t':
                str2 = MimeTypes.AUDIO_FLAC;
                break;
            case '\n':
                str2 = MimeTypes.VIDEO_WEBM;
                break;
            case 11:
                str2 = MimeTypes.AUDIO_AC4;
                break;
            case '\f':
                str2 = MimeTypes.AUDIO_MPEG;
                break;
            case '\r':
                str2 = MimeTypes.VIDEO_FLV;
                break;
            default:
                throw new IllegalArgumentException("Illegal parser name: ".concat(str));
        }
        this.f11603l = str2;
    }

    public void setTimestampAdjuster(TimestampAdjuster timestampAdjuster) {
        this.f11605n = timestampAdjuster;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [r12, java.lang.Object] */
    public OutputConsumerAdapterV30(@Nullable Format format, int i, boolean z) {
        this.f11597f = z;
        this.f11599h = format;
        this.f11598g = i;
        this.f11592a = new ArrayList();
        this.f11593b = new ArrayList();
        this.f11594c = new ArrayList();
        this.f11595d = new ArrayList();
        this.f11596e = new Object();
        this.f11600i = new DummyExtractorOutput();
        this.f11608q = C0643C.TIME_UNSET;
        this.f11606o = ImmutableList.m3902of();
    }
}
