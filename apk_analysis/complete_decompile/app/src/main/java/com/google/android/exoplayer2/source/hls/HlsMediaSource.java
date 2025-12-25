package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* loaded from: classes.dex */
public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;

    /* renamed from: h */
    public final HlsExtractorFactory f11407h;

    /* renamed from: i */
    public final MediaItem.LocalConfiguration f11408i;

    /* renamed from: j */
    public final HlsDataSourceFactory f11409j;

    /* renamed from: k */
    public final CompositeSequenceableLoaderFactory f11410k;

    /* renamed from: l */
    public final DrmSessionManager f11411l;

    /* renamed from: m */
    public final LoadErrorHandlingPolicy f11412m;

    /* renamed from: n */
    public final boolean f11413n;

    /* renamed from: o */
    public final int f11414o;

    /* renamed from: p */
    public final boolean f11415p;

    /* renamed from: q */
    public final HlsPlaylistTracker f11416q;

    /* renamed from: r */
    public final long f11417r;

    /* renamed from: s */
    public final MediaItem f11418s;

    /* renamed from: t */
    public MediaItem.LiveConfiguration f11419t;

    /* renamed from: u */
    public TransferListener f11420u;

    /* loaded from: classes.dex */
    public static final class Factory implements MediaSourceFactory {

        /* renamed from: a */
        public final HlsDataSourceFactory f11421a;

        /* renamed from: b */
        public HlsExtractorFactory f11422b;

        /* renamed from: c */
        public HlsPlaylistParserFactory f11423c;

        /* renamed from: d */
        public HlsPlaylistTracker.Factory f11424d;

        /* renamed from: e */
        public CompositeSequenceableLoaderFactory f11425e;

        /* renamed from: f */
        public DrmSessionManagerProvider f11426f;

        /* renamed from: g */
        public LoadErrorHandlingPolicy f11427g;

        /* renamed from: h */
        public boolean f11428h;

        /* renamed from: i */
        public int f11429i;

        /* renamed from: j */
        public boolean f11430j;

        /* renamed from: k */
        public final long f11431k;

        public Factory(DataSource.Factory factory) {
            this(new DefaultHlsDataSourceFactory(factory));
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        public Factory setAllowChunklessPreparation(boolean z) {
            this.f11428h = z;
            return this;
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f11425e = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory, "HlsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory setExtractorFactory(@Nullable HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = HlsExtractorFactory.DEFAULT;
            }
            this.f11422b = hlsExtractorFactory;
            return this;
        }

        public Factory setMetadataType(int i) {
            this.f11429i = i;
            return this;
        }

        public Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            this.f11423c = (HlsPlaylistParserFactory) Assertions.checkNotNull(hlsPlaylistParserFactory, "HlsMediaSource.Factory#setPlaylistParserFactory no longer handles null by instantiating a new DefaultHlsPlaylistParserFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory setPlaylistTrackerFactory(HlsPlaylistTracker.Factory factory) {
            this.f11424d = (HlsPlaylistTracker.Factory) Assertions.checkNotNull(factory, "HlsMediaSource.Factory#setPlaylistTrackerFactory no longer handles null by defaulting to DefaultHlsPlaylistTracker.FACTORY. Explicitly pass a reference to this instance in order to retain the old behavior.");
            return this;
        }

        public Factory setUseSessionKeys(boolean z) {
            this.f11430j = z;
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.f11421a = (HlsDataSourceFactory) Assertions.checkNotNull(hlsDataSourceFactory);
            this.f11426f = new DefaultDrmSessionManagerProvider();
            this.f11423c = new DefaultHlsPlaylistParserFactory();
            this.f11424d = DefaultHlsPlaylistTracker.FACTORY;
            this.f11422b = HlsExtractorFactory.DEFAULT;
            this.f11427g = new DefaultLoadErrorHandlingPolicy();
            this.f11425e = new DefaultCompositeSequenceableLoaderFactory();
            this.f11429i = 1;
            this.f11431k = C0643C.TIME_UNSET;
            this.f11428h = true;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public HlsMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.f11423c;
            List<StreamKey> list = mediaItem.localConfiguration.streamKeys;
            if (!list.isEmpty()) {
                hlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            }
            HlsExtractorFactory hlsExtractorFactory = this.f11422b;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f11425e;
            DrmSessionManager drmSessionManager = this.f11426f.get(mediaItem);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11427g;
            return new HlsMediaSource(mediaItem, this.f11421a, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, this.f11424d.createTracker(this.f11421a, loadErrorHandlingPolicy, hlsPlaylistParserFactory), this.f11431k, this.f11428h, this.f11429i, this.f11430j);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f11426f = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f11427g = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MetadataType {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    public HlsMediaSource(MediaItem mediaItem, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long j, boolean z, int i, boolean z2) {
        this.f11408i = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        this.f11418s = mediaItem;
        this.f11419t = mediaItem.liveConfiguration;
        this.f11409j = hlsDataSourceFactory;
        this.f11407h = hlsExtractorFactory;
        this.f11410k = compositeSequenceableLoaderFactory;
        this.f11411l = drmSessionManager;
        this.f11412m = loadErrorHandlingPolicy;
        this.f11416q = hlsPlaylistTracker;
        this.f11417r = j;
        this.f11413n = z;
        this.f11414o = i;
        this.f11415p = z2;
    }

    /* renamed from: a */
    public static HlsMediaPlaylist.Part m2793a(long j, List list) {
        HlsMediaPlaylist.Part part = null;
        for (int i = 0; i < list.size(); i++) {
            HlsMediaPlaylist.Part part2 = (HlsMediaPlaylist.Part) list.get(i);
            long j2 = part2.relativeStartTimeUs;
            if (j2 <= j && part2.isIndependent) {
                part = part2;
            } else if (j2 > j) {
                break;
            }
        }
        return part;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher createDrmEventDispatcher = createDrmEventDispatcher(mediaPeriodId);
        return new HlsMediaPeriod(this.f11407h, this.f11416q, this.f11409j, this.f11420u, this.f11411l, createDrmEventDispatcher, this.f11412m, createEventDispatcher, allocator, this.f11410k, this.f11413n, this.f11414o, this.f11415p, getPlayerId());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11418s;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        this.f11416q.maybeThrowPrimaryPlaylistRefreshError();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e7  */
    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        long j;
        long j2;
        long j3;
        SinglePeriodTimeline singlePeriodTimeline;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        boolean z;
        float f;
        long j10;
        long j11;
        boolean z2;
        if (hlsMediaPlaylist.hasProgramDateTime) {
            j = Util.usToMs(hlsMediaPlaylist.startTimeUs);
        } else {
            j = -9223372036854775807L;
        }
        int i = hlsMediaPlaylist.playlistType;
        if (i != 2 && i != 1) {
            j2 = -9223372036854775807L;
        } else {
            j2 = j;
        }
        HlsPlaylistTracker hlsPlaylistTracker = this.f11416q;
        HlsManifest hlsManifest = new HlsManifest((HlsMultivariantPlaylist) Assertions.checkNotNull(hlsPlaylistTracker.getMultivariantPlaylist()), hlsMediaPlaylist);
        if (hlsPlaylistTracker.isLive()) {
            long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - hlsPlaylistTracker.getInitialStartTimeUs();
            if (hlsMediaPlaylist.hasEndTag) {
                j5 = initialStartTimeUs + hlsMediaPlaylist.durationUs;
            } else {
                j5 = -9223372036854775807L;
            }
            if (hlsMediaPlaylist.hasProgramDateTime) {
                j6 = Util.msToUs(Util.getNowUnixTimeMs(this.f11417r)) - hlsMediaPlaylist.getEndTimeUs();
            } else {
                j6 = 0;
            }
            long j12 = this.f11419t.targetOffsetMs;
            if (j12 != C0643C.TIME_UNSET) {
                j9 = Util.msToUs(j12);
                j7 = j2;
            } else {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.serverControl;
                long j13 = hlsMediaPlaylist.startOffsetUs;
                if (j13 != C0643C.TIME_UNSET) {
                    j7 = j2;
                    j8 = hlsMediaPlaylist.durationUs - j13;
                } else {
                    j7 = j2;
                    j8 = serverControl.partHoldBackUs;
                    if (j8 == C0643C.TIME_UNSET || hlsMediaPlaylist.partTargetDurationUs == C0643C.TIME_UNSET) {
                        j8 = serverControl.holdBackUs;
                        if (j8 == C0643C.TIME_UNSET) {
                            j8 = hlsMediaPlaylist.targetDurationUs * 3;
                        }
                    }
                }
                j9 = j8 + j6;
            }
            long constrainValue = Util.constrainValue(j9, j6, hlsMediaPlaylist.durationUs + j6);
            MediaItem.LiveConfiguration liveConfiguration = this.f11418s.liveConfiguration;
            if (liveConfiguration.minPlaybackSpeed == -3.4028235E38f && liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
                HlsMediaPlaylist.ServerControl serverControl2 = hlsMediaPlaylist.serverControl;
                if (serverControl2.holdBackUs == C0643C.TIME_UNSET && serverControl2.partHoldBackUs == C0643C.TIME_UNSET) {
                    z = true;
                    MediaItem.LiveConfiguration.Builder targetOffsetMs = new MediaItem.LiveConfiguration.Builder().setTargetOffsetMs(Util.usToMs(constrainValue));
                    float f2 = 1.0f;
                    if (!z) {
                        f = 1.0f;
                    } else {
                        f = this.f11419t.minPlaybackSpeed;
                    }
                    MediaItem.LiveConfiguration.Builder minPlaybackSpeed = targetOffsetMs.setMinPlaybackSpeed(f);
                    if (!z) {
                        f2 = this.f11419t.maxPlaybackSpeed;
                    }
                    MediaItem.LiveConfiguration build = minPlaybackSpeed.setMaxPlaybackSpeed(f2).build();
                    this.f11419t = build;
                    j10 = hlsMediaPlaylist.startOffsetUs;
                    if (j10 == C0643C.TIME_UNSET) {
                        j10 = (hlsMediaPlaylist.durationUs + j6) - Util.msToUs(build.targetOffsetMs);
                    }
                    if (!hlsMediaPlaylist.preciseStart) {
                        j11 = j10;
                    } else {
                        HlsMediaPlaylist.Part m2793a = m2793a(j10, hlsMediaPlaylist.trailingParts);
                        if (m2793a != null) {
                            j11 = m2793a.relativeStartTimeUs;
                        } else if (hlsMediaPlaylist.segments.isEmpty()) {
                            j11 = 0;
                        } else {
                            List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
                            HlsMediaPlaylist.Segment segment = list.get(Util.binarySearchFloor((List<? extends Comparable<? super Long>>) list, Long.valueOf(j10), true, true));
                            HlsMediaPlaylist.Part m2793a2 = m2793a(j10, segment.parts);
                            if (m2793a2 != null) {
                                j11 = m2793a2.relativeStartTimeUs;
                            } else {
                                j11 = segment.relativeStartTimeUs;
                            }
                        }
                    }
                    if (hlsMediaPlaylist.playlistType != 2 && hlsMediaPlaylist.hasPositiveStartOffset) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    singlePeriodTimeline = new SinglePeriodTimeline(j7, j, C0643C.TIME_UNSET, j5, hlsMediaPlaylist.durationUs, initialStartTimeUs, j11, true, !hlsMediaPlaylist.hasEndTag, z2, hlsManifest, this.f11418s, this.f11419t);
                }
            }
            z = false;
            MediaItem.LiveConfiguration.Builder targetOffsetMs2 = new MediaItem.LiveConfiguration.Builder().setTargetOffsetMs(Util.usToMs(constrainValue));
            float f22 = 1.0f;
            if (!z) {
            }
            MediaItem.LiveConfiguration.Builder minPlaybackSpeed2 = targetOffsetMs2.setMinPlaybackSpeed(f);
            if (!z) {
            }
            MediaItem.LiveConfiguration build2 = minPlaybackSpeed2.setMaxPlaybackSpeed(f22).build();
            this.f11419t = build2;
            j10 = hlsMediaPlaylist.startOffsetUs;
            if (j10 == C0643C.TIME_UNSET) {
            }
            if (!hlsMediaPlaylist.preciseStart) {
            }
            if (hlsMediaPlaylist.playlistType != 2) {
            }
            z2 = false;
            singlePeriodTimeline = new SinglePeriodTimeline(j7, j, C0643C.TIME_UNSET, j5, hlsMediaPlaylist.durationUs, initialStartTimeUs, j11, true, !hlsMediaPlaylist.hasEndTag, z2, hlsManifest, this.f11418s, this.f11419t);
        } else {
            long j14 = j2;
            if (hlsMediaPlaylist.startOffsetUs != C0643C.TIME_UNSET && !hlsMediaPlaylist.segments.isEmpty()) {
                if (!hlsMediaPlaylist.preciseStart) {
                    long j15 = hlsMediaPlaylist.startOffsetUs;
                    if (j15 != hlsMediaPlaylist.durationUs) {
                        List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.segments;
                        j4 = list2.get(Util.binarySearchFloor((List<? extends Comparable<? super Long>>) list2, Long.valueOf(j15), true, true)).relativeStartTimeUs;
                        j3 = j4;
                    }
                }
                j4 = hlsMediaPlaylist.startOffsetUs;
                j3 = j4;
            } else {
                j3 = 0;
            }
            long j16 = hlsMediaPlaylist.durationUs;
            singlePeriodTimeline = new SinglePeriodTimeline(j14, j, C0643C.TIME_UNSET, j16, j16, 0L, j3, true, false, true, hlsManifest, this.f11418s, null);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f11420u = transferListener;
        DrmSessionManager drmSessionManager = this.f11411l;
        drmSessionManager.prepare();
        drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), getPlayerId());
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(null);
        this.f11416q.start(this.f11408i.uri, createEventDispatcher, this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f11416q.stop();
        this.f11411l.release();
    }
}
