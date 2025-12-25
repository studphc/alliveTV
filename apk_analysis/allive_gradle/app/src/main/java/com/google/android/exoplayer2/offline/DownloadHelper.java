package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.C1255h3;
import p000.RunnableC0006a5;
import p000.RunnableC0583c7;
import p000.u50;

/* loaded from: classes.dex */
public final class DownloadHelper {
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).setConstrainAudioChannelCountToDeviceCapabilities(false).build();

    /* renamed from: a */
    public final MediaItem.LocalConfiguration f10781a;

    /* renamed from: b */
    public final MediaSource f10782b;

    /* renamed from: c */
    public final DefaultTrackSelector f10783c;

    /* renamed from: d */
    public final RendererCapabilities[] f10784d;

    /* renamed from: e */
    public final SparseIntArray f10785e;

    /* renamed from: f */
    public final Handler f10786f;

    /* renamed from: g */
    public final Timeline.Window f10787g;

    /* renamed from: h */
    public boolean f10788h;

    /* renamed from: i */
    public Callback f10789i;

    /* renamed from: j */
    public C0680a f10790j;

    /* renamed from: k */
    public TrackGroupArray[] f10791k;

    /* renamed from: l */
    public MappingTrackSelector.MappedTrackInfo[] f10792l;

    /* renamed from: m */
    public List[][] f10793m;

    /* renamed from: n */
    public List[][] f10794n;

    /* loaded from: classes.dex */
    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    /* loaded from: classes.dex */
    public static class LiveContentUnsupportedException extends IOException {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.exoplayer2.trackselection.ExoTrackSelection$Factory, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.exoplayer2.upstream.BandwidthMeter, java.lang.Object] */
    public DownloadHelper(MediaItem mediaItem, @Nullable MediaSource mediaSource, TrackSelectionParameters trackSelectionParameters, RendererCapabilities[] rendererCapabilitiesArr) {
        this.f10781a = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        this.f10782b = mediaSource;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(trackSelectionParameters, (ExoTrackSelection.Factory) new Object());
        this.f10783c = defaultTrackSelector;
        this.f10784d = rendererCapabilitiesArr;
        this.f10785e = new SparseIntArray();
        defaultTrackSelector.init(new C1255h3(21), new Object());
        this.f10786f = Util.createHandlerForCurrentOrMainLooper();
        this.f10787g = new Timeline.Window();
    }

    /* renamed from: a */
    public static void m2703a(DownloadHelper downloadHelper) {
        Assertions.checkNotNull(downloadHelper.f10790j);
        Assertions.checkNotNull(downloadHelper.f10790j.f10858i);
        Assertions.checkNotNull(downloadHelper.f10790j.f10857h);
        int length = downloadHelper.f10790j.f10858i.length;
        int length2 = downloadHelper.f10784d.length;
        downloadHelper.f10793m = (List[][]) Array.newInstance((Class<?>) List.class, length, length2);
        downloadHelper.f10794n = (List[][]) Array.newInstance((Class<?>) List.class, length, length2);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                downloadHelper.f10793m[i][i2] = new ArrayList();
                downloadHelper.f10794n[i][i2] = Collections.unmodifiableList(downloadHelper.f10793m[i][i2]);
            }
        }
        downloadHelper.f10791k = new TrackGroupArray[length];
        downloadHelper.f10792l = new MappingTrackSelector.MappedTrackInfo[length];
        for (int i3 = 0; i3 < length; i3++) {
            downloadHelper.f10791k[i3] = downloadHelper.f10790j.f10858i[i3].getTrackGroups();
            Object obj = downloadHelper.m2706d(i3).info;
            DefaultTrackSelector defaultTrackSelector = downloadHelper.f10783c;
            defaultTrackSelector.onSelectionActivated(obj);
            downloadHelper.f10792l[i3] = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(defaultTrackSelector.getCurrentMappedTrackInfo());
        }
        downloadHelper.f10788h = true;
        ((Handler) Assertions.checkNotNull(downloadHelper.f10786f)).post(new RunnableC0006a5(14, downloadHelper));
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory) {
        return createMediaSource(downloadRequest, factory, null);
    }

    @Deprecated
    public static DownloadHelper forDash(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forDash(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    @Deprecated
    public static DownloadHelper forHls(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forHls(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public static DownloadHelper forMediaItem(Context context, MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        Assertions.checkArgument(Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType) == 4);
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), null, null, null);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Context context, Uri uri) {
        return forMediaItem(context, new MediaItem.Builder().setUri(uri).build());
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT);
    }

    public static DefaultTrackSelector.Parameters getDefaultTrackSelectorParameters(Context context) {
        return DefaultTrackSelector.Parameters.getDefaults(context).buildUpon().setForceHighestSupportedBitrate(true).setConstrainAudioChannelCountToDeviceCapabilities(false).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, com.google.android.exoplayer2.video.VideoRendererEventListener] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, com.google.android.exoplayer2.audio.AudioRendererEventListener] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, com.google.android.exoplayer2.text.TextOutput] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.exoplayer2.metadata.MetadataOutput, java.lang.Object] */
    public static RendererCapabilities[] getRendererCapabilities(RenderersFactory renderersFactory) {
        Renderer[] createRenderers = renderersFactory.createRenderers(Util.createHandlerForCurrentOrMainLooper(), new Object(), new Object(), new Object(), new Object());
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[createRenderers.length];
        for (int i = 0; i < createRenderers.length; i++) {
            rendererCapabilitiesArr[i] = createRenderers[i].getCapabilities();
        }
        return rendererCapabilitiesArr;
    }

    public void addAudioLanguagesToSelection(String... strArr) {
        boolean z;
        try {
            m2705c();
            DefaultTrackSelector.Parameters.Builder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            buildUpon.setForceHighestSupportedBitrate(true);
            for (RendererCapabilities rendererCapabilities : this.f10784d) {
                int trackType = rendererCapabilities.getTrackType();
                if (trackType != 1) {
                    z = true;
                } else {
                    z = false;
                }
                buildUpon.setTrackTypeDisabled(trackType, z);
            }
            int periodCount = getPeriodCount();
            for (String str : strArr) {
                TrackSelectionParameters build = buildUpon.setPreferredAudioLanguage(str).build();
                for (int i = 0; i < periodCount; i++) {
                    m2704b(i, build);
                }
            }
        } catch (ExoPlaybackException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addTextLanguagesToSelection(boolean z, String... strArr) {
        boolean z2;
        try {
            m2705c();
            DefaultTrackSelector.Parameters.Builder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            buildUpon.setSelectUndeterminedTextLanguage(z);
            buildUpon.setForceHighestSupportedBitrate(true);
            for (RendererCapabilities rendererCapabilities : this.f10784d) {
                int trackType = rendererCapabilities.getTrackType();
                if (trackType != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                buildUpon.setTrackTypeDisabled(trackType, z2);
            }
            int periodCount = getPeriodCount();
            for (String str : strArr) {
                TrackSelectionParameters build = buildUpon.setPreferredTextLanguage(str).build();
                for (int i = 0; i < periodCount; i++) {
                    m2704b(i, build);
                }
            }
        } catch (ExoPlaybackException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addTrackSelection(int i, TrackSelectionParameters trackSelectionParameters) {
        try {
            m2705c();
            m2704b(i, trackSelectionParameters);
        } catch (ExoPlaybackException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addTrackSelectionForSingleRenderer(int i, int i2, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        boolean z;
        try {
            m2705c();
            DefaultTrackSelector.Parameters.Builder buildUpon = parameters.buildUpon();
            for (int i3 = 0; i3 < this.f10792l[i].getRendererCount(); i3++) {
                if (i3 != i2) {
                    z = true;
                } else {
                    z = false;
                }
                buildUpon.setRendererDisabled(i3, z);
            }
            if (list.isEmpty()) {
                m2704b(i, buildUpon.build());
                return;
            }
            TrackGroupArray trackGroups = this.f10792l[i].getTrackGroups(i2);
            for (int i4 = 0; i4 < list.size(); i4++) {
                buildUpon.setSelectionOverride(i2, trackGroups, list.get(i4));
                m2704b(i, buildUpon.build());
            }
        } catch (ExoPlaybackException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    public final void m2704b(int i, TrackSelectionParameters trackSelectionParameters) {
        DefaultTrackSelector defaultTrackSelector = this.f10783c;
        defaultTrackSelector.setParameters(trackSelectionParameters);
        m2706d(i);
        UnmodifiableIterator<TrackSelectionOverride> it = trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            defaultTrackSelector.setParameters(trackSelectionParameters.buildUpon().setOverrideForType(it.next()).build());
            m2706d(i);
        }
    }

    /* renamed from: c */
    public final void m2705c() {
        Assertions.checkState(this.f10788h);
    }

    public void clearTrackSelections(int i) {
        m2705c();
        for (int i2 = 0; i2 < this.f10784d.length; i2++) {
            this.f10793m[i][i2].clear();
        }
    }

    /* renamed from: d */
    public final TrackSelectorResult m2706d(int i) {
        TrackSelectorResult selectTracks = this.f10783c.selectTracks(this.f10784d, this.f10791k[i], new MediaSource.MediaPeriodId(this.f10790j.f10857h.getUidOfPeriod(i)), this.f10790j.f10857h);
        for (int i2 = 0; i2 < selectTracks.length; i2++) {
            ExoTrackSelection exoTrackSelection = selectTracks.selections[i2];
            if (exoTrackSelection != null) {
                List list = this.f10793m[i][i2];
                int i3 = 0;
                while (true) {
                    if (i3 < list.size()) {
                        ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) list.get(i3);
                        if (exoTrackSelection2.getTrackGroup().equals(exoTrackSelection.getTrackGroup())) {
                            SparseIntArray sparseIntArray = this.f10785e;
                            sparseIntArray.clear();
                            for (int i4 = 0; i4 < exoTrackSelection2.length(); i4++) {
                                sparseIntArray.put(exoTrackSelection2.getIndexInTrackGroup(i4), 0);
                            }
                            for (int i5 = 0; i5 < exoTrackSelection.length(); i5++) {
                                sparseIntArray.put(exoTrackSelection.getIndexInTrackGroup(i5), 0);
                            }
                            int[] iArr = new int[sparseIntArray.size()];
                            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                                iArr[i6] = sparseIntArray.keyAt(i6);
                            }
                            list.set(i3, new BaseTrackSelection(exoTrackSelection2.getTrackGroup(), iArr));
                        } else {
                            i3++;
                        }
                    } else {
                        list.add(exoTrackSelection);
                        break;
                    }
                }
            }
        }
        return selectTracks;
    }

    public DownloadRequest getDownloadRequest(@Nullable byte[] bArr) {
        return getDownloadRequest(this.f10781a.uri.toString(), bArr);
    }

    @Nullable
    public Object getManifest() {
        if (this.f10782b == null) {
            return null;
        }
        m2705c();
        if (this.f10790j.f10857h.getWindowCount() <= 0) {
            return null;
        }
        return this.f10790j.f10857h.getWindow(0, this.f10787g).manifest;
    }

    public MappingTrackSelector.MappedTrackInfo getMappedTrackInfo(int i) {
        m2705c();
        return this.f10792l[i];
    }

    public int getPeriodCount() {
        if (this.f10782b == null) {
            return 0;
        }
        m2705c();
        return this.f10791k.length;
    }

    public TrackGroupArray getTrackGroups(int i) {
        m2705c();
        return this.f10791k[i];
    }

    public List<ExoTrackSelection> getTrackSelections(int i, int i2) {
        m2705c();
        return this.f10794n[i][i2];
    }

    public Tracks getTracks(int i) {
        m2705c();
        return TrackSelectionUtil.buildTracks(this.f10792l[i], (List<? extends TrackSelection>[]) this.f10794n[i]);
    }

    public void prepare(Callback callback) {
        boolean z;
        if (this.f10789i == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f10789i = callback;
        MediaSource mediaSource = this.f10782b;
        if (mediaSource != null) {
            this.f10790j = new C0680a(mediaSource, this);
        } else {
            this.f10786f.post(new RunnableC0583c7(15, this, callback));
        }
    }

    public void release() {
        C0680a c0680a = this.f10790j;
        if (c0680a != null && !c0680a.f10859j) {
            c0680a.f10859j = true;
            c0680a.f10856g.sendEmptyMessage(3);
        }
        this.f10783c.release();
    }

    public void replaceTrackSelections(int i, TrackSelectionParameters trackSelectionParameters) {
        try {
            m2705c();
            clearTrackSelections(i);
            m2704b(i, trackSelectionParameters);
        } catch (ExoPlaybackException e) {
            throw new IllegalStateException(e);
        }
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        MediaItem mediaItem = downloadRequest.toMediaItem();
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(factory, ExtractorsFactory.EMPTY);
        if (drmSessionManager != null) {
            defaultMediaSourceFactory.setDrmSessionManagerProvider((DrmSessionManagerProvider) new u50(0, drmSessionManager));
        }
        return defaultMediaSourceFactory.createMediaSource(mediaItem);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Context context, Uri uri, @Nullable String str) {
        return forMediaItem(context, new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build());
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public DownloadRequest getDownloadRequest(String str, @Nullable byte[] bArr) {
        MediaItem.LocalConfiguration localConfiguration = this.f10781a;
        DownloadRequest.Builder mimeType = new DownloadRequest.Builder(str, localConfiguration.uri).setMimeType(localConfiguration.mimeType);
        MediaItem.DrmConfiguration drmConfiguration = localConfiguration.drmConfiguration;
        DownloadRequest.Builder data = mimeType.setKeySetId(drmConfiguration != null ? drmConfiguration.getKeySetId() : null).setCustomCacheKey(localConfiguration.customCacheKey).setData(bArr);
        if (this.f10782b == null) {
            return data.build();
        }
        m2705c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f10793m.length;
        for (int i = 0; i < length; i++) {
            arrayList2.clear();
            int length2 = this.f10793m[i].length;
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.addAll(this.f10793m[i][i2]);
            }
            arrayList.addAll(this.f10790j.f10858i[i].getStreamKeys(arrayList2));
        }
        return data.setStreamKeys(arrayList).build();
    }

    @Deprecated
    public static DownloadHelper forDash(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, TrackSelectionParameters trackSelectionParameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_MPD).build(), trackSelectionParameters, renderersFactory, factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper forHls(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, TrackSelectionParameters trackSelectionParameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_M3U8).build(), trackSelectionParameters, renderersFactory, factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, TrackSelectionParameters trackSelectionParameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_SS).build(), trackSelectionParameters, renderersFactory, factory, drmSessionManager);
    }

    public static DownloadHelper forMediaItem(Context context, MediaItem mediaItem, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), renderersFactory, factory, null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, TrackSelectionParameters trackSelectionParameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return forMediaItem(mediaItem, trackSelectionParameters, renderersFactory, factory, null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, TrackSelectionParameters trackSelectionParameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        MediaSource createMediaSource;
        RendererCapabilities[] rendererCapabilitiesArr;
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        boolean z = true;
        boolean z2 = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType) == 4;
        if (!z2 && factory == null) {
            z = false;
        }
        Assertions.checkArgument(z);
        if (z2) {
            createMediaSource = null;
        } else {
            DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory((DataSource.Factory) Util.castNonNull(factory), ExtractorsFactory.EMPTY);
            if (drmSessionManager != null) {
                defaultMediaSourceFactory.setDrmSessionManagerProvider((DrmSessionManagerProvider) new u50(0, drmSessionManager));
            }
            createMediaSource = defaultMediaSourceFactory.createMediaSource(mediaItem);
        }
        if (renderersFactory != null) {
            rendererCapabilitiesArr = getRendererCapabilities(renderersFactory);
        } else {
            rendererCapabilitiesArr = new RendererCapabilities[0];
        }
        return new DownloadHelper(mediaItem, createMediaSource, trackSelectionParameters, rendererCapabilitiesArr);
    }
}
