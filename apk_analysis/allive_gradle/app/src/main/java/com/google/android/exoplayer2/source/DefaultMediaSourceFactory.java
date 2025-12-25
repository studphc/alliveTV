package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.p003ui.AdViewProvider;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.HashMap;
import java.util.Iterator;
import p000.y00;

/* loaded from: classes.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {

    /* renamed from: a */
    public final C0697f f10943a;

    /* renamed from: b */
    public DataSource.Factory f10944b;

    /* renamed from: c */
    public MediaSource.Factory f10945c;

    /* renamed from: d */
    public AdsLoader.Provider f10946d;

    /* renamed from: e */
    public AdViewProvider f10947e;

    /* renamed from: f */
    public LoadErrorHandlingPolicy f10948f;

    /* renamed from: g */
    public long f10949g;

    /* renamed from: h */
    public long f10950h;

    /* renamed from: i */
    public long f10951i;

    /* renamed from: j */
    public float f10952j;

    /* renamed from: k */
    public float f10953k;

    /* renamed from: l */
    public boolean f10954l;

    @Deprecated
    /* loaded from: classes.dex */
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    public DefaultMediaSourceFactory(Context context) {
        this(new DefaultDataSource.Factory(context));
    }

    /* renamed from: a */
    public static MediaSource.Factory m2739a(Class cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public DefaultMediaSourceFactory clearLocalAdInsertionComponents() {
        this.f10946d = null;
        this.f10947e = null;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public MediaSource createMediaSource(MediaItem mediaItem) {
        MediaSource clippingMediaSource;
        MediaItem mediaItem2 = mediaItem;
        Assertions.checkNotNull(mediaItem2.localConfiguration);
        String scheme = mediaItem2.localConfiguration.uri.getScheme();
        if (scheme != null && scheme.equals(C0643C.SSAI_SCHEME)) {
            return ((MediaSource.Factory) Assertions.checkNotNull(this.f10945c)).createMediaSource(mediaItem2);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem2.localConfiguration;
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
        C0697f c0697f = this.f10943a;
        HashMap hashMap = c0697f.f11364d;
        MediaSource.Factory factory = (MediaSource.Factory) hashMap.get(Integer.valueOf(inferContentTypeForUriAndMimeType));
        if (factory == null) {
            Supplier m2789a = c0697f.m2789a(inferContentTypeForUriAndMimeType);
            if (m2789a == null) {
                factory = null;
            } else {
                factory = (MediaSource.Factory) m2789a.get();
                DrmSessionManagerProvider drmSessionManagerProvider = c0697f.f11366f;
                if (drmSessionManagerProvider != null) {
                    factory.setDrmSessionManagerProvider(drmSessionManagerProvider);
                }
                LoadErrorHandlingPolicy loadErrorHandlingPolicy = c0697f.f11367g;
                if (loadErrorHandlingPolicy != null) {
                    factory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
                }
                hashMap.put(Integer.valueOf(inferContentTypeForUriAndMimeType), factory);
            }
        }
        Assertions.checkStateNotNull(factory, "No suitable media source factory found for content type: " + inferContentTypeForUriAndMimeType);
        MediaItem.LiveConfiguration.Builder buildUpon = mediaItem2.liveConfiguration.buildUpon();
        if (mediaItem2.liveConfiguration.targetOffsetMs == C0643C.TIME_UNSET) {
            buildUpon.setTargetOffsetMs(this.f10949g);
        }
        if (mediaItem2.liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMinPlaybackSpeed(this.f10952j);
        }
        if (mediaItem2.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMaxPlaybackSpeed(this.f10953k);
        }
        if (mediaItem2.liveConfiguration.minOffsetMs == C0643C.TIME_UNSET) {
            buildUpon.setMinOffsetMs(this.f10950h);
        }
        if (mediaItem2.liveConfiguration.maxOffsetMs == C0643C.TIME_UNSET) {
            buildUpon.setMaxOffsetMs(this.f10951i);
        }
        MediaItem.LiveConfiguration build = buildUpon.build();
        if (!build.equals(mediaItem2.liveConfiguration)) {
            mediaItem2 = mediaItem.buildUpon().setLiveConfiguration(build).build();
        }
        MediaSource createMediaSource = factory.createMediaSource(mediaItem2);
        ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.castNonNull(mediaItem2.localConfiguration)).subtitleConfigurations;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[immutableList.size() + 1];
            mediaSourceArr[0] = createMediaSource;
            for (int i = 0; i < immutableList.size(); i++) {
                if (this.f10954l) {
                    ProgressiveMediaSource.Factory factory2 = new ProgressiveMediaSource.Factory(this.f10944b, new y00(new Format.Builder().setSampleMimeType(immutableList.get(i).mimeType).setLanguage(immutableList.get(i).language).setSelectionFlags(immutableList.get(i).selectionFlags).setRoleFlags(immutableList.get(i).roleFlags).setLabel(immutableList.get(i).label).setId(immutableList.get(i).f9425id).build()));
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f10948f;
                    if (loadErrorHandlingPolicy2 != null) {
                        factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
                    }
                    mediaSourceArr[i + 1] = factory2.createMediaSource(MediaItem.fromUri(immutableList.get(i).uri.toString()));
                } else {
                    SingleSampleMediaSource.Factory factory3 = new SingleSampleMediaSource.Factory(this.f10944b);
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy3 = this.f10948f;
                    if (loadErrorHandlingPolicy3 != null) {
                        factory3.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy3);
                    }
                    mediaSourceArr[i + 1] = factory3.createMediaSource(immutableList.get(i), C0643C.TIME_UNSET);
                }
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        MediaSource mediaSource = createMediaSource;
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem2.clippingConfiguration;
        long j = clippingConfiguration.startPositionMs;
        if (j == 0 && clippingConfiguration.endPositionMs == Long.MIN_VALUE && !clippingConfiguration.relativeToDefaultPosition) {
            clippingMediaSource = mediaSource;
        } else {
            long msToUs = Util.msToUs(j);
            long msToUs2 = Util.msToUs(mediaItem2.clippingConfiguration.endPositionMs);
            MediaItem.ClippingConfiguration clippingConfiguration2 = mediaItem2.clippingConfiguration;
            clippingMediaSource = new ClippingMediaSource(mediaSource, msToUs, msToUs2, !clippingConfiguration2.startsAtKeyFrame, clippingConfiguration2.relativeToLiveWindow, clippingConfiguration2.relativeToDefaultPosition);
        }
        Assertions.checkNotNull(mediaItem2.localConfiguration);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem2.localConfiguration.adsConfiguration;
        if (adsConfiguration != null) {
            AdsLoader.Provider provider = this.f10946d;
            AdViewProvider adViewProvider = this.f10947e;
            if (provider != null && adViewProvider != null) {
                AdsLoader adsLoader = provider.getAdsLoader(adsConfiguration);
                if (adsLoader == null) {
                    Log.m3027w("DMediaSourceFactory", "Playing media without ads, as no AdsLoader was provided.");
                    return clippingMediaSource;
                }
                DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
                Object obj = adsConfiguration.adsId;
                if (obj == null) {
                    obj = ImmutableList.m3905of((Uri) mediaItem2.mediaId, mediaItem2.localConfiguration.uri, adsConfiguration.adTagUri);
                }
                return new AdsMediaSource(clippingMediaSource, dataSpec, obj, this, adsLoader, adViewProvider);
            }
            Log.m3027w("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return clippingMediaSource;
        }
        return clippingMediaSource;
    }

    public DefaultMediaSourceFactory experimentalUseProgressiveMediaSourceForSubtitles(boolean z) {
        this.f10954l = z;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public int[] getSupportedTypes() {
        C0697f c0697f = this.f10943a;
        c0697f.m2789a(0);
        c0697f.m2789a(1);
        c0697f.m2789a(2);
        c0697f.m2789a(3);
        c0697f.m2789a(4);
        return Ints.toArray(c0697f.f11363c);
    }

    @Deprecated
    public DefaultMediaSourceFactory setAdViewProvider(@Nullable AdViewProvider adViewProvider) {
        this.f10947e = adViewProvider;
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory setAdsLoaderProvider(@Nullable AdsLoader.Provider provider) {
        this.f10946d = provider;
        return this;
    }

    public DefaultMediaSourceFactory setDataSourceFactory(DataSource.Factory factory) {
        this.f10944b = factory;
        C0697f c0697f = this.f10943a;
        if (factory != c0697f.f11365e) {
            c0697f.f11365e = factory;
            c0697f.f11362b.clear();
            c0697f.f11364d.clear();
        }
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j) {
        this.f10951i = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxSpeed(float f) {
        this.f10953k = f;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j) {
        this.f10950h = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinSpeed(float f) {
        this.f10952j = f;
        return this;
    }

    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j) {
        this.f10949g = j;
        return this;
    }

    public DefaultMediaSourceFactory setLocalAdInsertionComponents(AdsLoader.Provider provider, AdViewProvider adViewProvider) {
        this.f10946d = (AdsLoader.Provider) Assertions.checkNotNull(provider);
        this.f10947e = (AdViewProvider) Assertions.checkNotNull(adViewProvider);
        return this;
    }

    public DefaultMediaSourceFactory setServerSideAdInsertionMediaSourceFactory(@Nullable MediaSource.Factory factory) {
        this.f10945c = factory;
        return this;
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSource.Factory(context), extractorsFactory);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        DrmSessionManagerProvider drmSessionManagerProvider2 = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
        C0697f c0697f = this.f10943a;
        c0697f.f11366f = drmSessionManagerProvider2;
        Iterator it = c0697f.f11364d.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).setDrmSessionManagerProvider(drmSessionManagerProvider2);
        }
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f10948f = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        C0697f c0697f = this.f10943a;
        c0697f.f11367g = loadErrorHandlingPolicy;
        Iterator it = c0697f.f11364d.values().iterator();
        while (it.hasNext()) {
            ((MediaSource.Factory) it.next()).setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
        }
        return this;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.f10944b = factory;
        C0697f c0697f = new C0697f(extractorsFactory);
        this.f10943a = c0697f;
        if (factory != c0697f.f11365e) {
            c0697f.f11365e = factory;
            c0697f.f11362b.clear();
            c0697f.f11364d.clear();
        }
        this.f10949g = C0643C.TIME_UNSET;
        this.f10950h = C0643C.TIME_UNSET;
        this.f10951i = C0643C.TIME_UNSET;
        this.f10952j = -3.4028235E38f;
        this.f10953k = -3.4028235E38f;
    }
}
