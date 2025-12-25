package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.RunnableC0583c7;

/* renamed from: com.google.android.exoplayer2.source.hls.playlist.b */
/* loaded from: classes.dex */
public final class C0702b implements Loader.Callback {

    /* renamed from: a */
    public final Uri f11521a;

    /* renamed from: b */
    public final Loader f11522b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* renamed from: c */
    public final DataSource f11523c;

    /* renamed from: d */
    public HlsMediaPlaylist f11524d;

    /* renamed from: e */
    public long f11525e;

    /* renamed from: f */
    public long f11526f;

    /* renamed from: g */
    public long f11527g;

    /* renamed from: h */
    public long f11528h;

    /* renamed from: i */
    public boolean f11529i;

    /* renamed from: j */
    public IOException f11530j;

    /* renamed from: k */
    public final /* synthetic */ DefaultHlsPlaylistTracker f11531k;

    public C0702b(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, Uri uri) {
        this.f11531k = defaultHlsPlaylistTracker;
        this.f11521a = uri;
        this.f11523c = defaultHlsPlaylistTracker.f11449a.createDataSource(4);
    }

    /* renamed from: a */
    public static boolean m2811a(C0702b c0702b, long j) {
        c0702b.f11528h = SystemClock.elapsedRealtime() + j;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = c0702b.f11531k;
        if (!c0702b.f11521a.equals(defaultHlsPlaylistTracker.f11460l)) {
            return false;
        }
        List<HlsMultivariantPlaylist.Variant> list = defaultHlsPlaylistTracker.f11459k.variants;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            C0702b c0702b2 = (C0702b) Assertions.checkNotNull((C0702b) defaultHlsPlaylistTracker.f11452d.get(list.get(i).url));
            if (elapsedRealtime > c0702b2.f11528h) {
                Uri uri = c0702b2.f11521a;
                defaultHlsPlaylistTracker.f11460l = uri;
                c0702b2.m2813c(defaultHlsPlaylistTracker.m2797a(uri));
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final void m2812b(Uri uri) {
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.f11531k;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f11523c, uri, 4, defaultHlsPlaylistTracker.f11450b.createPlaylistParser(defaultHlsPlaylistTracker.f11459k, this.f11524d));
        defaultHlsPlaylistTracker.f11455g.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.f11522b.startLoading(parsingLoadable, this, defaultHlsPlaylistTracker.f11451c.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    /* renamed from: c */
    public final void m2813c(Uri uri) {
        this.f11528h = 0L;
        if (!this.f11529i) {
            Loader loader = this.f11522b;
            if (!loader.isLoading() && !loader.hasFatalError()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = this.f11527g;
                if (elapsedRealtime < j) {
                    this.f11529i = true;
                    this.f11531k.f11457i.postDelayed(new RunnableC0583c7(10, this, uri), j - elapsedRealtime);
                } else {
                    m2812b(uri);
                }
            }
        }
    }

    /* renamed from: d */
    public final void m2814d(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
        long j;
        HlsMediaPlaylist.Segment segment;
        int i;
        HlsMediaPlaylist.Segment segment2;
        boolean z;
        HlsMediaPlaylist copyWith;
        IOException iOException;
        long j2;
        String str;
        long j3;
        HlsMediaPlaylist hlsMediaPlaylist2 = this.f11524d;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f11525e = elapsedRealtime;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.f11531k;
        defaultHlsPlaylistTracker.getClass();
        if (!hlsMediaPlaylist.isNewerThan(hlsMediaPlaylist2)) {
            if (hlsMediaPlaylist.hasEndTag) {
                copyWith = hlsMediaPlaylist2.copyWithEndTag();
            } else {
                copyWith = hlsMediaPlaylist2;
            }
            z = false;
        } else {
            if (hlsMediaPlaylist.hasProgramDateTime) {
                j = hlsMediaPlaylist.startTimeUs;
            } else {
                HlsMediaPlaylist hlsMediaPlaylist3 = defaultHlsPlaylistTracker.f11461m;
                if (hlsMediaPlaylist3 != null) {
                    j = hlsMediaPlaylist3.startTimeUs;
                } else {
                    j = 0;
                }
                if (hlsMediaPlaylist2 != null) {
                    int size = hlsMediaPlaylist2.segments.size();
                    int i2 = (int) (hlsMediaPlaylist.mediaSequence - hlsMediaPlaylist2.mediaSequence);
                    List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist2.segments;
                    if (i2 < list.size()) {
                        segment = list.get(i2);
                    } else {
                        segment = null;
                    }
                    if (segment != null) {
                        j = hlsMediaPlaylist2.startTimeUs + segment.relativeStartTimeUs;
                    } else if (size == hlsMediaPlaylist.mediaSequence - hlsMediaPlaylist2.mediaSequence) {
                        j = hlsMediaPlaylist2.getEndTimeUs();
                    }
                }
            }
            if (hlsMediaPlaylist.hasDiscontinuitySequence) {
                i = hlsMediaPlaylist.discontinuitySequence;
            } else {
                HlsMediaPlaylist hlsMediaPlaylist4 = defaultHlsPlaylistTracker.f11461m;
                if (hlsMediaPlaylist4 != null) {
                    i = hlsMediaPlaylist4.discontinuitySequence;
                } else {
                    i = 0;
                }
                if (hlsMediaPlaylist2 != null) {
                    int i3 = (int) (hlsMediaPlaylist.mediaSequence - hlsMediaPlaylist2.mediaSequence);
                    List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist2.segments;
                    if (i3 < list2.size()) {
                        segment2 = list2.get(i3);
                    } else {
                        segment2 = null;
                    }
                    if (segment2 != null) {
                        z = false;
                        i = (hlsMediaPlaylist2.discontinuitySequence + segment2.relativeDiscontinuitySequence) - hlsMediaPlaylist.segments.get(0).relativeDiscontinuitySequence;
                        copyWith = hlsMediaPlaylist.copyWith(j, i);
                    }
                }
            }
            z = false;
            copyWith = hlsMediaPlaylist.copyWith(j, i);
        }
        this.f11524d = copyWith;
        CopyOnWriteArrayList copyOnWriteArrayList = defaultHlsPlaylistTracker.f11453e;
        Uri uri = this.f11521a;
        if (copyWith != hlsMediaPlaylist2) {
            this.f11530j = null;
            this.f11526f = elapsedRealtime;
            if (uri.equals(defaultHlsPlaylistTracker.f11460l)) {
                if (defaultHlsPlaylistTracker.f11461m == null) {
                    defaultHlsPlaylistTracker.f11462n = !copyWith.hasEndTag;
                    defaultHlsPlaylistTracker.f11463o = copyWith.startTimeUs;
                }
                defaultHlsPlaylistTracker.f11461m = copyWith;
                defaultHlsPlaylistTracker.f11458j.onPrimaryPlaylistRefreshed(copyWith);
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((HlsPlaylistTracker.PlaylistEventListener) it.next()).onPlaylistChanged();
            }
        } else if (!copyWith.hasEndTag) {
            if (hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size() < this.f11524d.mediaSequence) {
                iOException = new HlsPlaylistTracker.PlaylistResetException(uri);
                z = true;
            } else if (elapsedRealtime - this.f11526f > Util.usToMs(r1.targetDurationUs) * defaultHlsPlaylistTracker.f11454f) {
                iOException = new HlsPlaylistTracker.PlaylistStuckException(uri);
            } else {
                iOException = null;
            }
            if (iOException != null) {
                this.f11530j = iOException;
                LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), iOException, 1);
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    ((HlsPlaylistTracker.PlaylistEventListener) it2.next()).onPlaylistError(uri, loadErrorInfo, z);
                }
            }
        }
        HlsMediaPlaylist hlsMediaPlaylist5 = this.f11524d;
        if (!hlsMediaPlaylist5.serverControl.canBlockReload) {
            if (hlsMediaPlaylist5 != hlsMediaPlaylist2) {
                j3 = hlsMediaPlaylist5.targetDurationUs;
            } else {
                j3 = hlsMediaPlaylist5.targetDurationUs / 2;
            }
            j2 = j3;
        } else {
            j2 = 0;
        }
        this.f11527g = Util.usToMs(j2) + elapsedRealtime;
        if (this.f11524d.partTargetDurationUs != C0643C.TIME_UNSET || uri.equals(defaultHlsPlaylistTracker.f11460l)) {
            HlsMediaPlaylist hlsMediaPlaylist6 = this.f11524d;
            if (!hlsMediaPlaylist6.hasEndTag) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist6.serverControl;
                if (serverControl.skipUntilUs != C0643C.TIME_UNSET || serverControl.canBlockReload) {
                    Uri.Builder buildUpon = uri.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist7 = this.f11524d;
                    if (hlsMediaPlaylist7.serverControl.canBlockReload) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hlsMediaPlaylist7.mediaSequence + hlsMediaPlaylist7.segments.size()));
                        HlsMediaPlaylist hlsMediaPlaylist8 = this.f11524d;
                        if (hlsMediaPlaylist8.partTargetDurationUs != C0643C.TIME_UNSET) {
                            List<HlsMediaPlaylist.Part> list3 = hlsMediaPlaylist8.trailingParts;
                            int size2 = list3.size();
                            if (!list3.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.getLast(list3)).isPreload) {
                                size2--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size2));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.f11524d.serverControl;
                    if (serverControl2.skipUntilUs != C0643C.TIME_UNSET) {
                        if (serverControl2.canSkipDateRanges) {
                            str = "v2";
                        } else {
                            str = "YES";
                        }
                        buildUpon.appendQueryParameter("_HLS_skip", str);
                    }
                    uri = buildUpon.build();
                }
                m2813c(uri);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.f11531k;
        defaultHlsPlaylistTracker.f11451c.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        defaultHlsPlaylistTracker.f11455g.loadCanceled(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        HlsPlaylist hlsPlaylist = (HlsPlaylist) parsingLoadable.getResult();
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        boolean z = hlsPlaylist instanceof HlsMediaPlaylist;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.f11531k;
        if (z) {
            m2814d((HlsMediaPlaylist) hlsPlaylist, loadEventInfo);
            defaultHlsPlaylistTracker.f11455g.loadCompleted(loadEventInfo, 4);
        } else {
            ParserException createForMalformedManifest = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
            this.f11530j = createForMalformedManifest;
            defaultHlsPlaylistTracker.f11455g.loadError(loadEventInfo, 4, (IOException) createForMalformedManifest, true);
        }
        defaultHlsPlaylistTracker.f11451c.onLoadTaskConcluded(parsingLoadable.loadTaskId);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        boolean z;
        int i2;
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        if (parsingLoadable.getUri().getQueryParameter("_HLS_msn") != null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
        Uri uri = this.f11521a;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.f11531k;
        if (z || z2) {
            if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
            } else {
                i2 = Integer.MAX_VALUE;
            }
            if (z2 || i2 == 400 || i2 == 503) {
                this.f11527g = SystemClock.elapsedRealtime();
                m2813c(uri);
                ((MediaSourceEventListener.EventDispatcher) Util.castNonNull(defaultHlsPlaylistTracker.f11455g)).loadError(loadEventInfo, parsingLoadable.type, iOException, true);
                return Loader.DONT_RETRY;
            }
        }
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.type), iOException, i);
        Iterator it = defaultHlsPlaylistTracker.f11453e.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= !((HlsPlaylistTracker.PlaylistEventListener) it.next()).onPlaylistError(uri, loadErrorInfo, false);
        }
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = defaultHlsPlaylistTracker.f11451c;
        if (z3) {
            long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
            if (retryDelayMsFor != C0643C.TIME_UNSET) {
                loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY_FATAL;
            }
        } else {
            loadErrorAction = Loader.DONT_RETRY;
        }
        boolean isRetry = loadErrorAction.isRetry();
        defaultHlsPlaylistTracker.f11455g.loadError(loadEventInfo, parsingLoadable.type, iOException, !isRetry);
        if (!isRetry) {
            loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable.loadTaskId);
            return loadErrorAction;
        }
        return loadErrorAction;
    }
}
