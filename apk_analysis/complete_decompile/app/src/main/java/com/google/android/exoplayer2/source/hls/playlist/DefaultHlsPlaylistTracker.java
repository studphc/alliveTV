package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    public static final HlsPlaylistTracker.Factory FACTORY = new Object();

    /* renamed from: a */
    public final HlsDataSourceFactory f11449a;

    /* renamed from: b */
    public final HlsPlaylistParserFactory f11450b;

    /* renamed from: c */
    public final LoadErrorHandlingPolicy f11451c;

    /* renamed from: d */
    public final HashMap f11452d;

    /* renamed from: e */
    public final CopyOnWriteArrayList f11453e;

    /* renamed from: f */
    public final double f11454f;

    /* renamed from: g */
    public MediaSourceEventListener.EventDispatcher f11455g;

    /* renamed from: h */
    public Loader f11456h;

    /* renamed from: i */
    public Handler f11457i;

    /* renamed from: j */
    public HlsPlaylistTracker.PrimaryPlaylistListener f11458j;

    /* renamed from: k */
    public HlsMultivariantPlaylist f11459k;

    /* renamed from: l */
    public Uri f11460l;

    /* renamed from: m */
    public HlsMediaPlaylist f11461m;

    /* renamed from: n */
    public boolean f11462n;

    /* renamed from: o */
    public long f11463o;

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    /* renamed from: a */
    public final Uri m2797a(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.f11461m;
        if (hlsMediaPlaylist != null && hlsMediaPlaylist.serverControl.canBlockReload && (renditionReport = hlsMediaPlaylist.renditionReports.get(uri)) != null) {
            Uri.Builder buildUpon = uri.buildUpon();
            buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.lastMediaSequence));
            int i = renditionReport.lastPartIndex;
            if (i != -1) {
                buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
            }
            return buildUpon.build();
        }
        return uri;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void addListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        Assertions.checkNotNull(playlistEventListener);
        this.f11453e.add(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean excludeMediaPlaylist(Uri uri, long j) {
        if (((C0702b) this.f11452d.get(uri)) != null) {
            return !C0702b.m2811a(r2, j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.f11463o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public HlsMultivariantPlaylist getMultivariantPlaylist() {
        return this.f11459k;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public HlsMediaPlaylist getPlaylistSnapshot(Uri uri, boolean z) {
        HashMap hashMap = this.f11452d;
        HlsMediaPlaylist hlsMediaPlaylist = ((C0702b) hashMap.get(uri)).f11524d;
        if (hlsMediaPlaylist != null && z && !uri.equals(this.f11460l)) {
            List<HlsMultivariantPlaylist.Variant> list = this.f11459k.variants;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (uri.equals(list.get(i).url)) {
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.f11461m;
                    if (hlsMediaPlaylist2 == null || !hlsMediaPlaylist2.hasEndTag) {
                        this.f11460l = uri;
                        C0702b c0702b = (C0702b) hashMap.get(uri);
                        HlsMediaPlaylist hlsMediaPlaylist3 = c0702b.f11524d;
                        if (hlsMediaPlaylist3 != null && hlsMediaPlaylist3.hasEndTag) {
                            this.f11461m = hlsMediaPlaylist3;
                            this.f11458j.onPrimaryPlaylistRefreshed(hlsMediaPlaylist3);
                        } else {
                            c0702b.m2813c(m2797a(uri));
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        return hlsMediaPlaylist;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.f11462n;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(Uri uri) {
        int i;
        C0702b c0702b = (C0702b) this.f11452d.get(uri);
        if (c0702b.f11524d == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, Util.usToMs(c0702b.f11524d.durationUs));
        HlsMediaPlaylist hlsMediaPlaylist = c0702b.f11524d;
        if (!hlsMediaPlaylist.hasEndTag && (i = hlsMediaPlaylist.playlistType) != 2 && i != 1 && c0702b.f11525e + max <= elapsedRealtime) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(Uri uri) {
        C0702b c0702b = (C0702b) this.f11452d.get(uri);
        c0702b.f11522b.maybeThrowError();
        IOException iOException = c0702b.f11530j;
        if (iOException == null) {
        } else {
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() {
        Loader loader = this.f11456h;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.f11460l;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(Uri uri) {
        C0702b c0702b = (C0702b) this.f11452d.get(uri);
        c0702b.m2813c(c0702b.f11521a);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void removeListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.f11453e.remove(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void start(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        boolean z;
        this.f11457i = Util.createHandlerForCurrentLooper();
        this.f11455g = eventDispatcher;
        this.f11458j = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f11449a.createDataSource(4), uri, 4, this.f11450b.createPlaylistParser());
        if (this.f11456h == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f11456h = loader;
        eventDispatcher.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, loader.startLoading(parsingLoadable, this, this.f11451c.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f11460l = null;
        this.f11461m = null;
        this.f11459k = null;
        this.f11463o = C0643C.TIME_UNSET;
        this.f11456h.release();
        this.f11456h = null;
        HashMap hashMap = this.f11452d;
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((C0702b) it.next()).f11522b.release();
        }
        this.f11457i.removeCallbacksAndMessages(null);
        this.f11457i = null;
        hashMap.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d) {
        this.f11449a = hlsDataSourceFactory;
        this.f11450b = hlsPlaylistParserFactory;
        this.f11451c = loadErrorHandlingPolicy;
        this.f11454f = d;
        this.f11453e = new CopyOnWriteArrayList();
        this.f11452d = new HashMap();
        this.f11463o = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.f11451c.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.f11455g.loadCanceled(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        HashMap hashMap;
        HlsPlaylist result = parsingLoadable.getResult();
        boolean z = result instanceof HlsMediaPlaylist;
        if (z) {
            hlsMultivariantPlaylist = HlsMultivariantPlaylist.createSingleVariantMultivariantPlaylist(result.baseUri);
        } else {
            hlsMultivariantPlaylist = (HlsMultivariantPlaylist) result;
        }
        this.f11459k = hlsMultivariantPlaylist;
        int i = 0;
        this.f11460l = hlsMultivariantPlaylist.variants.get(0).url;
        this.f11453e.add(new C0701a(this));
        List<Uri> list = hlsMultivariantPlaylist.mediaPlaylistUrls;
        int size = list.size();
        while (true) {
            hashMap = this.f11452d;
            if (i >= size) {
                break;
            }
            Uri uri = list.get(i);
            hashMap.put(uri, new C0702b(this, uri));
            i++;
        }
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        C0702b c0702b = (C0702b) hashMap.get(this.f11460l);
        if (z) {
            c0702b.m2814d((HlsMediaPlaylist) result, loadEventInfo);
        } else {
            c0702b.m2813c(c0702b.f11521a);
        }
        this.f11451c.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.f11455g.loadCompleted(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, IOException iOException, int i) {
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.type), iOException, i);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11451c;
        long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
        boolean z = retryDelayMsFor == C0643C.TIME_UNSET;
        this.f11455g.loadError(loadEventInfo, parsingLoadable.type, iOException, z);
        if (z) {
            loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }
        if (z) {
            return Loader.DONT_RETRY_FATAL;
        }
        return Loader.createRetryAction(false, retryDelayMsFor);
    }
}
