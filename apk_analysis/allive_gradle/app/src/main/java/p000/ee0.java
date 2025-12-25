package p000;

import android.content.Context;
import android.media.MediaParser;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.HeartRating;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PercentageRating;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Rating;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.source.MediaParserExtractorAdapter;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.MediaParserChunkExtractor;
import com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.MediaParserHlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.WebvttExtractor;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes2.dex */
public final /* synthetic */ class ee0 implements LibraryVersionComponent.VersionExtractor, ExtractorsFactory, Bundleable.Creator, Id3Decoder.FramePredicate, fl1, ChunkExtractor.Factory, ProgressiveMediaExtractor.Factory, HlsExtractorFactory, Deferred.DeferredHandler {

    /* renamed from: a */
    public final /* synthetic */ int f16781a;

    public /* synthetic */ ee0(int i) {
        this.f16781a = i;
    }

    @Override // p000.fl1
    /* renamed from: a */
    public int mo4692a(Object obj) {
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) obj;
        switch (this.f16781a) {
            case 9:
                Pattern pattern = MediaCodecUtil.f10723a;
                String str = mediaCodecInfo.name;
                if (!str.startsWith("OMX.google") && !str.startsWith("c2.android")) {
                    if (Util.SDK_INT < 26 && str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                        return -1;
                    }
                    return 0;
                }
                return 1;
            default:
                Pattern pattern2 = MediaCodecUtil.f10723a;
                return mediaCodecInfo.name.startsWith("OMX.google") ? 1 : 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public HlsMediaChunkExtractor createExtractor(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId) {
        boolean z;
        if (FileTypes.inferFileTypeFromMimeType(format.sampleMimeType) == 13) {
            return new BundledHlsMediaChunkExtractor(new WebvttExtractor(format.language, timestampAdjuster), format, timestampAdjuster);
        }
        if (list != null) {
            z = true;
        } else {
            z = false;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.add((ImmutableList.Builder) MediaParserUtil.toCaptionsMediaFormat((Format) list.get(i)));
            }
        } else {
            builder.add((ImmutableList.Builder) MediaParserUtil.toCaptionsMediaFormat(new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).build()));
        }
        ImmutableList build = builder.build();
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        if (list == null) {
            list = ImmutableList.m3902of();
        }
        outputConsumerAdapterV30.setMuxedCaptionFormats(list);
        outputConsumerAdapterV30.setTimestampAdjuster(timestampAdjuster);
        MediaParser m2794a = MediaParserHlsMediaChunkExtractor.m2794a(outputConsumerAdapterV30, format, z, build, playerId, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        rl1 rl1Var = new rl1(extractorInput);
        ql1.m7094l(m2794a, rl1Var);
        outputConsumerAdapterV30.setSelectedParserName(ql1.m7092j(m2794a));
        return new MediaParserHlsMediaChunkExtractor(m2794a, outputConsumerAdapterV30, format, z, build, rl1Var.f26018b, playerId);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        int i = this.f16781a;
        return zb0.m8410a(this, uri, map);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
    public ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
        return new MediaParserExtractorAdapter(playerId);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
    public boolean evaluate(int i, int i2, int i3, int i4, int i5) {
        switch (this.f16781a) {
            case 7:
                return false;
            default:
                return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.f16781a) {
            case 0:
                int i = Build.VERSION.SDK_INT;
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                    return "tv";
                }
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                    return "watch";
                }
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                    return DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                }
                if (i >= 26 && context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                    return "embedded";
                }
                return "";
            default:
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName != null) {
                    return FirebaseCommonRegistrar.m4367a(installerPackageName);
                }
                return "";
        }
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public Bundleable fromBundle(Bundle bundle) {
        MediaItem.LiveConfiguration fromBundle;
        MediaMetadata fromBundle2;
        MediaItem.ClippingProperties fromBundle3;
        MediaItem.RequestMetadata fromBundle4;
        Bundle bundle2;
        Bundle bundle3;
        switch (this.f16781a) {
            case 4:
                int i = Format.NO_VALUE;
                Format.Builder builder = new Format.Builder();
                BundleableUtil.ensureClassLoader(bundle);
                String string = bundle.getString(Integer.toString(0, 36));
                Format format = Format.f9352b;
                String str = format.f9354id;
                if (string == null) {
                    string = str;
                }
                Format.Builder id = builder.setId(string);
                String string2 = bundle.getString(Integer.toString(1, 36));
                String str2 = format.label;
                if (string2 == null) {
                    string2 = str2;
                }
                Format.Builder label = id.setLabel(string2);
                String string3 = bundle.getString(Integer.toString(2, 36));
                String str3 = format.language;
                if (string3 == null) {
                    string3 = str3;
                }
                Format.Builder peakBitrate = label.setLanguage(string3).setSelectionFlags(bundle.getInt(Integer.toString(3, 36), format.selectionFlags)).setRoleFlags(bundle.getInt(Integer.toString(4, 36), format.roleFlags)).setAverageBitrate(bundle.getInt(Integer.toString(5, 36), format.averageBitrate)).setPeakBitrate(bundle.getInt(Integer.toString(6, 36), format.peakBitrate));
                String string4 = bundle.getString(Integer.toString(7, 36));
                String str4 = format.codecs;
                if (string4 == null) {
                    string4 = str4;
                }
                Format.Builder codecs = peakBitrate.setCodecs(string4);
                Metadata metadata = (Metadata) bundle.getParcelable(Integer.toString(8, 36));
                Metadata metadata2 = format.metadata;
                if (metadata == null) {
                    metadata = metadata2;
                }
                Format.Builder metadata3 = codecs.setMetadata(metadata);
                String string5 = bundle.getString(Integer.toString(9, 36));
                String str5 = format.containerMimeType;
                if (string5 == null) {
                    string5 = str5;
                }
                Format.Builder containerMimeType = metadata3.setContainerMimeType(string5);
                String string6 = bundle.getString(Integer.toString(10, 36));
                String str6 = format.sampleMimeType;
                if (string6 == null) {
                    string6 = str6;
                }
                containerMimeType.setSampleMimeType(string6).setMaxInputSize(bundle.getInt(Integer.toString(11, 36), format.maxInputSize));
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (true) {
                    byte[] byteArray = bundle.getByteArray(Format.m2416a(i2));
                    if (byteArray == null) {
                        builder.setInitializationData(arrayList).setDrmInitData((DrmInitData) bundle.getParcelable(Integer.toString(13, 36))).setSubsampleOffsetUs(bundle.getLong(Integer.toString(14, 36), format.subsampleOffsetUs)).setWidth(bundle.getInt(Integer.toString(15, 36), format.width)).setHeight(bundle.getInt(Integer.toString(16, 36), format.height)).setFrameRate(bundle.getFloat(Integer.toString(17, 36), format.frameRate)).setRotationDegrees(bundle.getInt(Integer.toString(18, 36), format.rotationDegrees)).setPixelWidthHeightRatio(bundle.getFloat(Integer.toString(19, 36), format.pixelWidthHeightRatio)).setProjectionData(bundle.getByteArray(Integer.toString(20, 36))).setStereoMode(bundle.getInt(Integer.toString(21, 36), format.stereoMode));
                        Bundle bundle4 = bundle.getBundle(Integer.toString(22, 36));
                        if (bundle4 != null) {
                            builder.setColorInfo(ColorInfo.CREATOR.fromBundle(bundle4));
                        }
                        builder.setChannelCount(bundle.getInt(Integer.toString(23, 36), format.channelCount)).setSampleRate(bundle.getInt(Integer.toString(24, 36), format.sampleRate)).setPcmEncoding(bundle.getInt(Integer.toString(25, 36), format.pcmEncoding)).setEncoderDelay(bundle.getInt(Integer.toString(26, 36), format.encoderDelay)).setEncoderPadding(bundle.getInt(Integer.toString(27, 36), format.encoderPadding)).setAccessibilityChannel(bundle.getInt(Integer.toString(28, 36), format.accessibilityChannel)).setCryptoType(bundle.getInt(Integer.toString(29, 36), format.cryptoType));
                        return builder.build();
                    }
                    arrayList.add(byteArray);
                    i2++;
                }
            case 6:
                Assertions.checkArgument(bundle.getInt(Integer.toString(0, 36), -1) == 0);
                if (bundle.getBoolean(Integer.toString(1, 36), false)) {
                    return new HeartRating(bundle.getBoolean(Integer.toString(2, 36), false));
                }
                return new HeartRating();
            case 11:
                String str7 = MediaItem.DEFAULT_MEDIA_ID;
                String str8 = (String) Assertions.checkNotNull(bundle.getString(Integer.toString(0, 36), ""));
                Bundle bundle5 = bundle.getBundle(Integer.toString(1, 36));
                if (bundle5 == null) {
                    fromBundle = MediaItem.LiveConfiguration.UNSET;
                } else {
                    fromBundle = MediaItem.LiveConfiguration.CREATOR.fromBundle(bundle5);
                }
                MediaItem.LiveConfiguration liveConfiguration = fromBundle;
                Bundle bundle6 = bundle.getBundle(Integer.toString(2, 36));
                if (bundle6 == null) {
                    fromBundle2 = MediaMetadata.EMPTY;
                } else {
                    fromBundle2 = MediaMetadata.CREATOR.fromBundle(bundle6);
                }
                MediaMetadata mediaMetadata = fromBundle2;
                Bundle bundle7 = bundle.getBundle(Integer.toString(3, 36));
                if (bundle7 == null) {
                    fromBundle3 = MediaItem.ClippingProperties.UNSET;
                } else {
                    fromBundle3 = MediaItem.ClippingConfiguration.CREATOR.fromBundle(bundle7);
                }
                MediaItem.ClippingProperties clippingProperties = fromBundle3;
                Bundle bundle8 = bundle.getBundle(Integer.toString(4, 36));
                if (bundle8 == null) {
                    fromBundle4 = MediaItem.RequestMetadata.EMPTY;
                } else {
                    fromBundle4 = MediaItem.RequestMetadata.CREATOR.fromBundle(bundle8);
                }
                return new MediaItem(str8, clippingProperties, null, liveConfiguration, mediaMetadata, fromBundle4);
            case 12:
                MediaItem.ClippingConfiguration clippingConfiguration = MediaItem.ClippingConfiguration.UNSET;
                return new MediaItem.ClippingConfiguration.Builder().setStartPositionMs(bundle.getLong(Integer.toString(0, 36), 0L)).setEndPositionMs(bundle.getLong(Integer.toString(1, 36), Long.MIN_VALUE)).setRelativeToLiveWindow(bundle.getBoolean(Integer.toString(2, 36), false)).setRelativeToDefaultPosition(bundle.getBoolean(Integer.toString(3, 36), false)).setStartsAtKeyFrame(bundle.getBoolean(Integer.toString(4, 36), false)).buildClippingProperties();
            case 13:
                return new MediaItem.LiveConfiguration(bundle.getLong(Integer.toString(0, 36), C0643C.TIME_UNSET), bundle.getLong(Integer.toString(1, 36), C0643C.TIME_UNSET), bundle.getLong(Integer.toString(2, 36), C0643C.TIME_UNSET), bundle.getFloat(Integer.toString(3, 36), -3.4028235E38f), bundle.getFloat(Integer.toString(4, 36), -3.4028235E38f));
            case 14:
                MediaItem.RequestMetadata requestMetadata = MediaItem.RequestMetadata.EMPTY;
                return new MediaItem.RequestMetadata.Builder().setMediaUri((Uri) bundle.getParcelable(Integer.toString(0, 36))).setSearchQuery(bundle.getString(Integer.toString(1, 36))).setExtras(bundle.getBundle(Integer.toString(2, 36))).build();
            case 15:
                int i3 = MediaMetadata.FOLDER_TYPE_NONE;
                MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
                builder2.setTitle(bundle.getCharSequence(Integer.toString(0, 36))).setArtist(bundle.getCharSequence(Integer.toString(1, 36))).setAlbumTitle(bundle.getCharSequence(Integer.toString(2, 36))).setAlbumArtist(bundle.getCharSequence(Integer.toString(3, 36))).setDisplayTitle(bundle.getCharSequence(Integer.toString(4, 36))).setSubtitle(bundle.getCharSequence(Integer.toString(5, 36))).setDescription(bundle.getCharSequence(Integer.toString(6, 36))).setArtworkData(bundle.getByteArray(Integer.toString(10, 36)), bundle.containsKey(Integer.toString(29, 36)) ? Integer.valueOf(bundle.getInt(Integer.toString(29, 36))) : null).setArtworkUri((Uri) bundle.getParcelable(Integer.toString(11, 36))).setWriter(bundle.getCharSequence(Integer.toString(22, 36))).setComposer(bundle.getCharSequence(Integer.toString(23, 36))).setConductor(bundle.getCharSequence(Integer.toString(24, 36))).setGenre(bundle.getCharSequence(Integer.toString(27, 36))).setCompilation(bundle.getCharSequence(Integer.toString(28, 36))).setStation(bundle.getCharSequence(Integer.toString(30, 36))).setExtras(bundle.getBundle(Integer.toString(1000, 36)));
                if (bundle.containsKey(Integer.toString(8, 36)) && (bundle3 = bundle.getBundle(Integer.toString(8, 36))) != null) {
                    builder2.setUserRating(Rating.CREATOR.fromBundle(bundle3));
                }
                if (bundle.containsKey(Integer.toString(9, 36)) && (bundle2 = bundle.getBundle(Integer.toString(9, 36))) != null) {
                    builder2.setOverallRating(Rating.CREATOR.fromBundle(bundle2));
                }
                if (bundle.containsKey(Integer.toString(12, 36))) {
                    builder2.setTrackNumber(Integer.valueOf(bundle.getInt(Integer.toString(12, 36))));
                }
                if (bundle.containsKey(Integer.toString(13, 36))) {
                    builder2.setTotalTrackCount(Integer.valueOf(bundle.getInt(Integer.toString(13, 36))));
                }
                if (bundle.containsKey(Integer.toString(14, 36))) {
                    builder2.setFolderType(Integer.valueOf(bundle.getInt(Integer.toString(14, 36))));
                }
                if (bundle.containsKey(Integer.toString(15, 36))) {
                    builder2.setIsPlayable(Boolean.valueOf(bundle.getBoolean(Integer.toString(15, 36))));
                }
                if (bundle.containsKey(Integer.toString(16, 36))) {
                    builder2.setRecordingYear(Integer.valueOf(bundle.getInt(Integer.toString(16, 36))));
                }
                if (bundle.containsKey(Integer.toString(17, 36))) {
                    builder2.setRecordingMonth(Integer.valueOf(bundle.getInt(Integer.toString(17, 36))));
                }
                if (bundle.containsKey(Integer.toString(18, 36))) {
                    builder2.setRecordingDay(Integer.valueOf(bundle.getInt(Integer.toString(18, 36))));
                }
                if (bundle.containsKey(Integer.toString(19, 36))) {
                    builder2.setReleaseYear(Integer.valueOf(bundle.getInt(Integer.toString(19, 36))));
                }
                if (bundle.containsKey(Integer.toString(20, 36))) {
                    builder2.setReleaseMonth(Integer.valueOf(bundle.getInt(Integer.toString(20, 36))));
                }
                if (bundle.containsKey(Integer.toString(21, 36))) {
                    builder2.setReleaseDay(Integer.valueOf(bundle.getInt(Integer.toString(21, 36))));
                }
                if (bundle.containsKey(Integer.toString(25, 36))) {
                    builder2.setDiscNumber(Integer.valueOf(bundle.getInt(Integer.toString(25, 36))));
                }
                if (bundle.containsKey(Integer.toString(26, 36))) {
                    builder2.setTotalDiscCount(Integer.valueOf(bundle.getInt(Integer.toString(26, 36))));
                }
                return builder2.build();
            case 24:
                Assertions.checkArgument(bundle.getInt(Integer.toString(0, 36), -1) == 1);
                float f = bundle.getFloat(Integer.toString(1, 36), -1.0f);
                return f == -1.0f ? new PercentageRating() : new PercentageRating(f);
            case 25:
                return new PlaybackException(bundle);
            case 26:
                PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
                return new PlaybackParameters(bundle.getFloat(Integer.toString(0, 36), 1.0f), bundle.getFloat(Integer.toString(1, 36), 1.0f));
            case 27:
                Player.Commands commands = Player.Commands.EMPTY;
                ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(Integer.toString(0, 36));
                if (integerArrayList == null) {
                    return Player.Commands.EMPTY;
                }
                Player.Commands.Builder builder3 = new Player.Commands.Builder();
                for (int i4 = 0; i4 < integerArrayList.size(); i4++) {
                    builder3.add(integerArrayList.get(i4).intValue());
                }
                return builder3.build();
            default:
                int i5 = bundle.getInt(Integer.toString(0, 36), -1);
                Bundle bundle9 = bundle.getBundle(Integer.toString(1, 36));
                return new Player.PositionInfo(null, i5, bundle9 == null ? null : MediaItem.CREATOR.fromBundle(bundle9), null, bundle.getInt(Integer.toString(2, 36), -1), bundle.getLong(Integer.toString(3, 36), C0643C.TIME_UNSET), bundle.getLong(Integer.toString(4, 36), C0643C.TIME_UNSET), bundle.getInt(Integer.toString(5, 36), -1), bundle.getInt(Integer.toString(6, 36), -1));
        }
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        switch (this.f16781a) {
            case 2:
                return new Extractor[]{new FlacExtractor()};
            case 3:
                return new Extractor[]{new FlvExtractor()};
            case 5:
                return new Extractor[]{new FragmentedMp4Extractor()};
            case 8:
                return new Extractor[]{new MatroskaExtractor()};
            case 19:
                return new Extractor[]{new Mp3Extractor()};
            case 21:
                return new Extractor[]{new Mp4Extractor()};
            case 22:
                return new Extractor[]{new OggExtractor()};
            default:
                return new Extractor[]{new PsExtractor()};
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.Factory
    public ChunkExtractor createProgressiveMediaExtractor(int i, Format format, boolean z, List list, TrackOutput trackOutput, PlayerId playerId) {
        if (!MimeTypes.isText(format.containerMimeType)) {
            return new MediaParserChunkExtractor(i, format, list, playerId);
        }
        Log.m3027w("MediaPrsrChunkExtractor", "Ignoring an unsupported text track.");
        return null;
    }
}
