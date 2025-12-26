package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.p002ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.p002ts.AdtsExtractor;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: h3 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1255h3 implements ExtractorsFactory, Bundleable.Creator, ChunkExtractor.Factory, CacheKeyFactory, ComponentRegistrarProcessor, ListenerSet.IterationFinishedEvent, DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier, TrackSelector.InvalidationListener, DrmSessionManager.DrmSessionReference, ListenerSet.Event, LibraryVersionComponent.VersionExtractor {

    /* renamed from: a */
    public final /* synthetic */ int f17935a;

    public /* synthetic */ C1255h3(int i) {
        this.f17935a = i;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
    public String buildCacheKey(DataSpec dataSpec) {
        String str = dataSpec.key;
        if (str == null) {
            return dataSpec.uri.toString();
        }
        return str;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        int i = this.f17935a;
        return zb0.m8410a(this, uri, map);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.Factory
    public ChunkExtractor createProgressiveMediaExtractor(int i, Format format, boolean z, List list, TrackOutput trackOutput, PlayerId playerId) {
        int i2;
        Extractor fragmentedMp4Extractor;
        ChunkExtractor.Factory factory = BundledChunkExtractor.FACTORY;
        String str = format.containerMimeType;
        if (MimeTypes.isText(str)) {
            return null;
        }
        if (MimeTypes.isMatroska(str)) {
            fragmentedMp4Extractor = new MatroskaExtractor(1);
        } else {
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            fragmentedMp4Extractor = new FragmentedMp4Extractor(i2, null, null, list, trackOutput);
        }
        return new BundledChunkExtractor(fragmentedMp4Extractor, i, format);
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        int i;
        Context context = (Context) obj;
        switch (this.f17935a) {
            case 28:
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    return String.valueOf(applicationInfo.targetSdkVersion);
                }
                return "";
            default:
                ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                if (applicationInfo2 != null && Build.VERSION.SDK_INT >= 24) {
                    i = applicationInfo2.minSdkVersion;
                    return String.valueOf(i);
                }
                return "";
        }
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public Bundleable fromBundle(Bundle bundle) {
        AdPlaybackState.AdGroup[] adGroupArr;
        int[] iArr;
        long[] jArr;
        ImmutableList fromBundleList;
        boolean z = true;
        switch (this.f17935a) {
            case 2:
                int i = AdPlaybackState.AD_STATE_UNAVAILABLE;
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(1, 36));
                if (parcelableArrayList == null) {
                    adGroupArr = new AdPlaybackState.AdGroup[0];
                } else {
                    AdPlaybackState.AdGroup[] adGroupArr2 = new AdPlaybackState.AdGroup[parcelableArrayList.size()];
                    for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                        adGroupArr2[i2] = AdPlaybackState.AdGroup.CREATOR.fromBundle((Bundle) parcelableArrayList.get(i2));
                    }
                    adGroupArr = adGroupArr2;
                }
                return new AdPlaybackState(null, adGroupArr, bundle.getLong(Integer.toString(2, 36), 0L), bundle.getLong(Integer.toString(3, 36), C0643C.TIME_UNSET), bundle.getInt(Integer.toString(4, 36)));
            case 3:
                long j = bundle.getLong(Integer.toString(0, 36));
                int i3 = bundle.getInt(Integer.toString(1, 36), -1);
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(Integer.toString(2, 36));
                int[] intArray = bundle.getIntArray(Integer.toString(3, 36));
                long[] longArray = bundle.getLongArray(Integer.toString(4, 36));
                long j2 = bundle.getLong(Integer.toString(5, 36));
                boolean z2 = bundle.getBoolean(Integer.toString(6, 36));
                if (intArray == null) {
                    iArr = new int[0];
                } else {
                    iArr = intArray;
                }
                Uri[] uriArr = new Uri[0];
                if (parcelableArrayList2 != null) {
                    uriArr = (Uri[]) parcelableArrayList2.toArray(uriArr);
                }
                Uri[] uriArr2 = uriArr;
                if (longArray == null) {
                    jArr = new long[0];
                } else {
                    jArr = longArray;
                }
                return new AdPlaybackState.AdGroup(j, i3, iArr, uriArr2, jArr, j2, z2);
            case 4:
            case 5:
            case 7:
            case 8:
            case 10:
            case 13:
            case 14:
            case 15:
            default:
                return new ExoPlaybackException(bundle);
            case 6:
                AudioAttributes audioAttributes = AudioAttributes.DEFAULT;
                AudioAttributes.Builder builder = new AudioAttributes.Builder();
                if (bundle.containsKey(Integer.toString(0, 36))) {
                    builder.setContentType(bundle.getInt(Integer.toString(0, 36)));
                }
                if (bundle.containsKey(Integer.toString(1, 36))) {
                    builder.setFlags(bundle.getInt(Integer.toString(1, 36)));
                }
                if (bundle.containsKey(Integer.toString(2, 36))) {
                    builder.setUsage(bundle.getInt(Integer.toString(2, 36)));
                }
                if (bundle.containsKey(Integer.toString(3, 36))) {
                    builder.setAllowedCapturePolicy(bundle.getInt(Integer.toString(3, 36)));
                }
                if (bundle.containsKey(Integer.toString(4, 36))) {
                    builder.setSpatializationBehavior(bundle.getInt(Integer.toString(4, 36)));
                }
                return builder.build();
            case 9:
                return new ColorInfo(bundle.getInt(Integer.toString(0, 36), -1), bundle.getInt(Integer.toString(1, 36), -1), bundle.getInt(Integer.toString(2, 36), -1), bundle.getByteArray(Integer.toString(3, 36)));
            case 11:
                Cue cue = Cue.EMPTY;
                Cue.Builder builder2 = new Cue.Builder();
                CharSequence charSequence = bundle.getCharSequence(Integer.toString(0, 36));
                if (charSequence != null) {
                    builder2.setText(charSequence);
                }
                Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(Integer.toString(1, 36));
                if (alignment != null) {
                    builder2.setTextAlignment(alignment);
                }
                Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(Integer.toString(2, 36));
                if (alignment2 != null) {
                    builder2.setMultiRowAlignment(alignment2);
                }
                Bitmap bitmap = (Bitmap) bundle.getParcelable(Integer.toString(3, 36));
                if (bitmap != null) {
                    builder2.setBitmap(bitmap);
                }
                if (bundle.containsKey(Integer.toString(4, 36)) && bundle.containsKey(Integer.toString(5, 36))) {
                    builder2.setLine(bundle.getFloat(Integer.toString(4, 36)), bundle.getInt(Integer.toString(5, 36)));
                }
                if (bundle.containsKey(Integer.toString(6, 36))) {
                    builder2.setLineAnchor(bundle.getInt(Integer.toString(6, 36)));
                }
                if (bundle.containsKey(Integer.toString(7, 36))) {
                    builder2.setPosition(bundle.getFloat(Integer.toString(7, 36)));
                }
                if (bundle.containsKey(Integer.toString(8, 36))) {
                    builder2.setPositionAnchor(bundle.getInt(Integer.toString(8, 36)));
                }
                if (bundle.containsKey(Integer.toString(10, 36)) && bundle.containsKey(Integer.toString(9, 36))) {
                    builder2.setTextSize(bundle.getFloat(Integer.toString(10, 36)), bundle.getInt(Integer.toString(9, 36)));
                }
                if (bundle.containsKey(Integer.toString(11, 36))) {
                    builder2.setSize(bundle.getFloat(Integer.toString(11, 36)));
                }
                if (bundle.containsKey(Integer.toString(12, 36))) {
                    builder2.setBitmapHeight(bundle.getFloat(Integer.toString(12, 36)));
                }
                if (bundle.containsKey(Integer.toString(13, 36))) {
                    builder2.setWindowColor(bundle.getInt(Integer.toString(13, 36)));
                }
                if (!bundle.getBoolean(Integer.toString(14, 36), false)) {
                    builder2.clearWindowColor();
                }
                if (bundle.containsKey(Integer.toString(15, 36))) {
                    builder2.setVerticalType(bundle.getInt(Integer.toString(15, 36)));
                }
                if (bundle.containsKey(Integer.toString(16, 36))) {
                    builder2.setShearDegrees(bundle.getFloat(Integer.toString(16, 36)));
                }
                return builder2.build();
            case 12:
                CueGroup cueGroup = CueGroup.EMPTY;
                ArrayList parcelableArrayList3 = bundle.getParcelableArrayList(Integer.toString(0, 36));
                if (parcelableArrayList3 == null) {
                    fromBundleList = ImmutableList.m3902of();
                } else {
                    fromBundleList = BundleableUtil.fromBundleList(Cue.CREATOR, parcelableArrayList3);
                }
                return new CueGroup(fromBundleList);
            case 16:
                DefaultTrackSelector.Parameters parameters = DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT;
                return new DefaultTrackSelector.Parameters.Builder(bundle).build();
            case 17:
                int i4 = bundle.getInt(Integer.toString(0, 36), -1);
                int[] intArray2 = bundle.getIntArray(Integer.toString(1, 36));
                int i5 = bundle.getInt(Integer.toString(2, 36), -1);
                if (i4 < 0 || i5 < 0) {
                    z = false;
                }
                Assertions.checkArgument(z);
                Assertions.checkNotNull(intArray2);
                return new DefaultTrackSelector.SelectionOverride(i4, intArray2, i5);
            case 18:
                int i6 = DeviceInfo.PLAYBACK_TYPE_LOCAL;
                return new DeviceInfo(bundle.getInt(Integer.toString(0, 36), 0), bundle.getInt(Integer.toString(1, 36), 0), bundle.getInt(Integer.toString(2, 36), 0));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier
    public Constructor getConstructor() {
        switch (this.f17935a) {
            case 14:
                int[] iArr = DefaultExtractorsFactory.f10071m;
                if (!Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return null;
                }
                return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
            default:
                int[] iArr2 = DefaultExtractorsFactory.f10071m;
                return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(null);
        }
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        DefaultTrackSelector.Parameters parameters = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    }

    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List processRegistrar(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager.DrmSessionReference
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        switch (this.f17935a) {
            case 0:
                return new Extractor[]{new Ac3Extractor()};
            case 1:
                return new Extractor[]{new Ac4Extractor()};
            case 2:
            case 3:
            default:
                return new Extractor[0];
            case 4:
                return new Extractor[]{new AdtsExtractor()};
            case 5:
                return new Extractor[]{new AmrExtractor()};
        }
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f17935a) {
            case 24:
                listener.onSeekProcessed();
                return;
            case 25:
                listener.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
                return;
            default:
                listener.onRenderedFirstFrame();
                return;
        }
    }
}
