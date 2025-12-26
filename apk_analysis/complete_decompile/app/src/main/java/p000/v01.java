package p000;

import android.net.Uri;
import android.os.Handler;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsChunkHolder;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.HlsMediaPeriod;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class v01 implements Loader.Callback, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {

    /* renamed from: Y */
    public static final Set f27562Y = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));

    /* renamed from: A */
    public int f27563A;

    /* renamed from: B */
    public int f27564B;

    /* renamed from: C */
    public boolean f27565C;

    /* renamed from: D */
    public boolean f27566D;

    /* renamed from: E */
    public int f27567E;

    /* renamed from: F */
    public Format f27568F;

    /* renamed from: G */
    public Format f27569G;

    /* renamed from: H */
    public boolean f27570H;

    /* renamed from: I */
    public TrackGroupArray f27571I;

    /* renamed from: J */
    public Set f27572J;

    /* renamed from: K */
    public int[] f27573K;

    /* renamed from: L */
    public int f27574L;

    /* renamed from: M */
    public boolean f27575M;

    /* renamed from: N */
    public boolean[] f27576N;

    /* renamed from: O */
    public boolean[] f27577O;

    /* renamed from: P */
    public long f27578P;

    /* renamed from: Q */
    public long f27579Q;

    /* renamed from: R */
    public boolean f27580R;

    /* renamed from: S */
    public boolean f27581S;

    /* renamed from: T */
    public boolean f27582T;

    /* renamed from: U */
    public boolean f27583U;

    /* renamed from: V */
    public long f27584V;

    /* renamed from: W */
    public DrmInitData f27585W;

    /* renamed from: X */
    public q01 f27586X;

    /* renamed from: a */
    public final String f27587a;

    /* renamed from: b */
    public final int f27588b;

    /* renamed from: c */
    public final HlsMediaPeriod f27589c;

    /* renamed from: d */
    public final p01 f27590d;

    /* renamed from: e */
    public final Allocator f27591e;

    /* renamed from: f */
    public final Format f27592f;

    /* renamed from: g */
    public final DrmSessionManager f27593g;

    /* renamed from: h */
    public final DrmSessionEventListener.EventDispatcher f27594h;

    /* renamed from: i */
    public final LoadErrorHandlingPolicy f27595i;

    /* renamed from: k */
    public final MediaSourceEventListener.EventDispatcher f27597k;

    /* renamed from: l */
    public final int f27598l;

    /* renamed from: n */
    public final ArrayList f27600n;

    /* renamed from: o */
    public final List f27601o;

    /* renamed from: p */
    public final s01 f27602p;

    /* renamed from: q */
    public final s01 f27603q;

    /* renamed from: r */
    public final Handler f27604r;

    /* renamed from: s */
    public final ArrayList f27605s;

    /* renamed from: t */
    public final Map f27606t;

    /* renamed from: u */
    public Chunk f27607u;

    /* renamed from: v */
    public u01[] f27608v;

    /* renamed from: x */
    public final HashSet f27610x;

    /* renamed from: y */
    public final SparseIntArray f27611y;

    /* renamed from: z */
    public t01 f27612z;

    /* renamed from: j */
    public final Loader f27596j = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: m */
    public final HlsChunkSource$HlsChunkHolder f27599m = new HlsChunkSource$HlsChunkHolder();

    /* renamed from: w */
    public int[] f27609w = new int[0];

    /* JADX WARN: Type inference failed for: r1v8, types: [s01] */
    /* JADX WARN: Type inference failed for: r1v9, types: [s01] */
    public v01(String str, int i, HlsMediaPeriod hlsMediaPeriod, p01 p01Var, Map map, Allocator allocator, long j, Format format, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i2) {
        this.f27587a = str;
        this.f27588b = i;
        this.f27589c = hlsMediaPeriod;
        this.f27590d = p01Var;
        this.f27606t = map;
        this.f27591e = allocator;
        this.f27592f = format;
        this.f27593g = drmSessionManager;
        this.f27594h = eventDispatcher;
        this.f27595i = loadErrorHandlingPolicy;
        this.f27597k = eventDispatcher2;
        this.f27598l = i2;
        Set set = f27562Y;
        this.f27610x = new HashSet(set.size());
        this.f27611y = new SparseIntArray(set.size());
        this.f27608v = new u01[0];
        this.f27577O = new boolean[0];
        this.f27576N = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f27600n = arrayList;
        this.f27601o = Collections.unmodifiableList(arrayList);
        this.f27605s = new ArrayList();
        final int i3 = 0;
        this.f27602p = new Runnable(this) { // from class: s01

            /* renamed from: b */
            public final /* synthetic */ v01 f26201b;

            {
                this.f26201b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        this.f26201b.m7800i();
                        return;
                    default:
                        v01 v01Var = this.f26201b;
                        v01Var.f27565C = true;
                        v01Var.m7800i();
                        return;
                }
            }
        };
        final int i4 = 1;
        this.f27603q = new Runnable(this) { // from class: s01

            /* renamed from: b */
            public final /* synthetic */ v01 f26201b;

            {
                this.f26201b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        this.f26201b.m7800i();
                        return;
                    default:
                        v01 v01Var = this.f26201b;
                        v01Var.f27565C = true;
                        v01Var.m7800i();
                        return;
                }
            }
        };
        this.f27604r = Util.createHandlerForCurrentLooper();
        this.f27578P = j;
        this.f27579Q = j;
    }

    /* renamed from: b */
    public static DummyTrackOutput m7792b(int i, int i2) {
        Log.m3027w("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new DummyTrackOutput();
    }

    /* renamed from: d */
    public static Format m7793d(Format format, Format format2, boolean z) {
        String codecsCorrespondingToMimeType;
        String str;
        int i;
        int i2;
        if (format == null) {
            return format2;
        }
        int trackType = MimeTypes.getTrackType(format2.sampleMimeType);
        if (Util.getCodecCountOfType(format.codecs, trackType) == 1) {
            codecsCorrespondingToMimeType = Util.getCodecsOfType(format.codecs, trackType);
            str = MimeTypes.getMediaMimeType(codecsCorrespondingToMimeType);
        } else {
            codecsCorrespondingToMimeType = MimeTypes.getCodecsCorrespondingToMimeType(format.codecs, format2.sampleMimeType);
            str = format2.sampleMimeType;
        }
        Format.Builder roleFlags = format2.buildUpon().setId(format.f9354id).setLabel(format.label).setLanguage(format.language).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags);
        if (z) {
            i = format.averageBitrate;
        } else {
            i = -1;
        }
        Format.Builder averageBitrate = roleFlags.setAverageBitrate(i);
        if (z) {
            i2 = format.peakBitrate;
        } else {
            i2 = -1;
        }
        Format.Builder codecs = averageBitrate.setPeakBitrate(i2).setCodecs(codecsCorrespondingToMimeType);
        if (trackType == 2) {
            codecs.setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate);
        }
        if (str != null) {
            codecs.setSampleMimeType(str);
        }
        int i3 = format.channelCount;
        if (i3 != -1 && trackType == 1) {
            codecs.setChannelCount(i3);
        }
        Metadata metadata = format.metadata;
        if (metadata != null) {
            Metadata metadata2 = format2.metadata;
            if (metadata2 != null) {
                metadata = metadata2.copyWithAppendedEntriesFrom(metadata);
            }
            codecs.setMetadata(metadata);
        }
        return codecs.build();
    }

    /* renamed from: g */
    public static int m7794g(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public final void m7795a() {
        Assertions.checkState(this.f27566D);
        Assertions.checkNotNull(this.f27571I);
        Assertions.checkNotNull(this.f27572J);
    }

    /* renamed from: c */
    public final TrackGroupArray m7796c(TrackGroup[] trackGroupArr) {
        for (int i = 0; i < trackGroupArr.length; i++) {
            TrackGroup trackGroup = trackGroupArr[i];
            Format[] formatArr = new Format[trackGroup.length];
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                Format format = trackGroup.getFormat(i2);
                formatArr[i2] = format.copyWithCryptoType(this.f27593g.getCryptoType(format));
            }
            trackGroupArr[i] = new TrackGroup(trackGroup.f11089id, formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0270  */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean continueLoading(long j) {
        long max;
        long j2;
        List<? extends MediaChunk> list;
        boolean z;
        q01 q01Var;
        int indexOf;
        long j3;
        q01 q01Var2;
        long j4;
        int selectedIndexInTrackGroup;
        boolean z2;
        Uri uri;
        HlsPlaylistTracker hlsPlaylistTracker;
        long endTimeUs;
        HlsChunkSource$HlsChunkHolder hlsChunkSource$HlsChunkHolder;
        q01 q01Var3;
        o01 o01Var;
        long j5;
        HlsMediaPlaylist.Segment segment;
        Uri uri2;
        l01 m6766d;
        Uri resolveToUri;
        boolean z3;
        Uri uri3;
        boolean z4;
        boolean z5;
        boolean z6;
        byte[] bArr;
        byte[] bArr2;
        int i;
        boolean z7;
        byte[] bArr3;
        DataSource dataSource;
        HlsMediaPlaylist.Segment segment2;
        o01 o01Var2;
        boolean z8;
        boolean z9;
        DataSpec dataSpec;
        DataSource dataSource2;
        boolean z10;
        Id3Decoder id3Decoder;
        ParsableByteArray parsableByteArray;
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        boolean z11;
        boolean z12;
        HlsMediaChunkExtractor hlsMediaChunkExtractor2;
        boolean z13;
        byte[] bArr4;
        String str;
        boolean z14;
        if (!this.f27582T) {
            Loader loader = this.f27596j;
            if (!loader.isLoading() && !loader.hasFatalError()) {
                if (m7799h()) {
                    list = Collections.emptyList();
                    j2 = this.f27579Q;
                    for (u01 u01Var : this.f27608v) {
                        u01Var.setStartTimeUs(this.f27579Q);
                    }
                } else {
                    q01 m7798f = m7798f();
                    if (m7798f.f25391y) {
                        max = m7798f.endTimeUs;
                    } else {
                        max = Math.max(this.f27578P, m7798f.startTimeUs);
                    }
                    j2 = max;
                    list = this.f27601o;
                }
                List<? extends MediaChunk> list2 = list;
                long j6 = j2;
                HlsChunkSource$HlsChunkHolder hlsChunkSource$HlsChunkHolder2 = this.f27599m;
                hlsChunkSource$HlsChunkHolder2.clear();
                if (!this.f27566D && list2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                p01 p01Var = this.f27590d;
                if (list2.isEmpty()) {
                    q01Var = null;
                } else {
                    q01Var = (q01) Iterables.getLast(list2);
                }
                if (q01Var == null) {
                    indexOf = -1;
                } else {
                    indexOf = p01Var.f24979h.indexOf(q01Var.trackFormat);
                }
                long j7 = j6 - j;
                int i2 = indexOf;
                long j8 = p01Var.f24989r;
                if (j8 != C0643C.TIME_UNSET) {
                    j3 = j8 - j;
                } else {
                    j3 = -9223372036854775807L;
                }
                if (q01Var != null && !p01Var.f24987p) {
                    long durationUs = q01Var.getDurationUs();
                    q01Var2 = q01Var;
                    j7 = Math.max(0L, j7 - durationUs);
                    if (j3 != C0643C.TIME_UNSET) {
                        j4 = Math.max(0L, j3 - durationUs);
                        q01 q01Var4 = q01Var2;
                        p01Var.f24988q.updateSelectedTrack(j, j7, j4, list2, p01Var.m6763a(q01Var4, j6));
                        selectedIndexInTrackGroup = p01Var.f24988q.getSelectedIndexInTrackGroup();
                        if (i2 == selectedIndexInTrackGroup) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Uri[] uriArr = p01Var.f24976e;
                        uri = uriArr[selectedIndexInTrackGroup];
                        hlsPlaylistTracker = p01Var.f24978g;
                        if (hlsPlaylistTracker.isSnapshotValid(uri)) {
                            hlsChunkSource$HlsChunkHolder2.playlistUrl = uri;
                            p01Var.f24990s &= uri.equals(p01Var.f24986o);
                            p01Var.f24986o = uri;
                            hlsChunkSource$HlsChunkHolder = hlsChunkSource$HlsChunkHolder2;
                        } else {
                            HlsMediaPlaylist playlistSnapshot = hlsPlaylistTracker.getPlaylistSnapshot(uri, true);
                            Assertions.checkNotNull(playlistSnapshot);
                            p01Var.f24987p = playlistSnapshot.hasIndependentSegments;
                            if (playlistSnapshot.hasEndTag) {
                                endTimeUs = C0643C.TIME_UNSET;
                            } else {
                                endTimeUs = playlistSnapshot.getEndTimeUs() - hlsPlaylistTracker.getInitialStartTimeUs();
                            }
                            p01Var.f24989r = endTimeUs;
                            long initialStartTimeUs = playlistSnapshot.startTimeUs - hlsPlaylistTracker.getInitialStartTimeUs();
                            hlsChunkSource$HlsChunkHolder = hlsChunkSource$HlsChunkHolder2;
                            Pair m6765c = p01Var.m6765c(q01Var4, z2, playlistSnapshot, initialStartTimeUs, j6);
                            long longValue = ((Long) m6765c.first).longValue();
                            int intValue = ((Integer) m6765c.second).intValue();
                            if (longValue < playlistSnapshot.mediaSequence) {
                                q01Var3 = q01Var4;
                                if (q01Var3 != null && z2) {
                                    uri = uriArr[i2];
                                    playlistSnapshot = hlsPlaylistTracker.getPlaylistSnapshot(uri, true);
                                    Assertions.checkNotNull(playlistSnapshot);
                                    initialStartTimeUs = playlistSnapshot.startTimeUs - hlsPlaylistTracker.getInitialStartTimeUs();
                                    Pair m6765c2 = p01Var.m6765c(q01Var3, false, playlistSnapshot, initialStartTimeUs, j6);
                                    longValue = ((Long) m6765c2.first).longValue();
                                    intValue = ((Integer) m6765c2.second).intValue();
                                    selectedIndexInTrackGroup = i2;
                                }
                            } else {
                                q01Var3 = q01Var4;
                            }
                            long j9 = playlistSnapshot.mediaSequence;
                            if (longValue < j9) {
                                p01Var.f24985n = new BehindLiveWindowException();
                            } else {
                                int i3 = (int) (longValue - j9);
                                if (i3 == playlistSnapshot.segments.size()) {
                                    if (intValue == -1) {
                                        intValue = 0;
                                    }
                                    if (intValue < playlistSnapshot.trailingParts.size()) {
                                        o01Var = new o01(playlistSnapshot.trailingParts.get(intValue), longValue, intValue);
                                        if (o01Var == null) {
                                            if (!playlistSnapshot.hasEndTag) {
                                                hlsChunkSource$HlsChunkHolder.playlistUrl = uri;
                                                p01Var.f24990s &= uri.equals(p01Var.f24986o);
                                                p01Var.f24986o = uri;
                                            } else if (!z && !playlistSnapshot.segments.isEmpty()) {
                                                j5 = initialStartTimeUs;
                                                o01Var = new o01((HlsMediaPlaylist.SegmentBase) Iterables.getLast(playlistSnapshot.segments), (playlistSnapshot.mediaSequence + playlistSnapshot.segments.size()) - 1, -1);
                                            } else {
                                                hlsChunkSource$HlsChunkHolder.endOfStream = true;
                                            }
                                        } else {
                                            j5 = initialStartTimeUs;
                                        }
                                        p01Var.f24990s = false;
                                        p01Var.f24986o = null;
                                        HlsMediaPlaylist.SegmentBase segmentBase = o01Var.f23550a;
                                        segment = segmentBase.initializationSegment;
                                        if (segment == null && (str = segment.fullSegmentEncryptionKeyUri) != null) {
                                            uri2 = UriUtil.resolveToUri(playlistSnapshot.baseUri, str);
                                        } else {
                                            uri2 = null;
                                        }
                                        m6766d = p01Var.m6766d(uri2, selectedIndexInTrackGroup);
                                        hlsChunkSource$HlsChunkHolder.chunk = m6766d;
                                        if (m6766d == null) {
                                            String str2 = segmentBase.fullSegmentEncryptionKeyUri;
                                            if (str2 == null) {
                                                resolveToUri = null;
                                            } else {
                                                resolveToUri = UriUtil.resolveToUri(playlistSnapshot.baseUri, str2);
                                            }
                                            l01 m6766d2 = p01Var.m6766d(resolveToUri, selectedIndexInTrackGroup);
                                            hlsChunkSource$HlsChunkHolder.chunk = m6766d2;
                                            if (m6766d2 == null) {
                                                if (q01Var3 == null) {
                                                    AtomicInteger atomicInteger = q01.f25364C;
                                                } else if (!uri.equals(q01Var3.f25369c) || !q01Var3.f25391y) {
                                                    long j10 = j5 + segmentBase.relativeStartTimeUs;
                                                    if (segmentBase instanceof HlsMediaPlaylist.Part) {
                                                        if (!((HlsMediaPlaylist.Part) segmentBase).isIndependent && (o01Var.f23552c != 0 || !playlistSnapshot.hasIndependentSegments)) {
                                                            z3 = false;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                    } else {
                                                        z3 = playlistSnapshot.hasIndependentSegments;
                                                    }
                                                    if (z3) {
                                                        uri3 = uri;
                                                        if (j10 >= q01Var3.endTimeUs) {
                                                            z4 = false;
                                                            z5 = z4;
                                                            z6 = o01Var.f23553d;
                                                            if (z5 || !z6) {
                                                                Format format = p01Var.f24977f[selectedIndexInTrackGroup];
                                                                int selectionReason = p01Var.f24988q.getSelectionReason();
                                                                Object selectionData = p01Var.f24988q.getSelectionData();
                                                                boolean z15 = p01Var.f24983l;
                                                                b01 b01Var = p01Var.f24981j;
                                                                if (resolveToUri == null) {
                                                                    b01Var.getClass();
                                                                    bArr = null;
                                                                } else {
                                                                    bArr = (byte[]) ((bv0) b01Var.f7833b).get(resolveToUri);
                                                                }
                                                                if (uri2 == null) {
                                                                    bArr2 = null;
                                                                } else {
                                                                    bArr2 = (byte[]) ((bv0) b01Var.f7833b).get(uri2);
                                                                }
                                                                AtomicInteger atomicInteger2 = q01.f25364C;
                                                                DataSpec.Builder length = new DataSpec.Builder().setUri(UriUtil.resolveToUri(playlistSnapshot.baseUri, segmentBase.url)).setPosition(segmentBase.byteRangeOffset).setLength(segmentBase.byteRangeLength);
                                                                if (z6) {
                                                                    i = 8;
                                                                } else {
                                                                    i = 0;
                                                                }
                                                                DataSpec build = length.setFlags(i).build();
                                                                if (bArr != null) {
                                                                    z7 = true;
                                                                } else {
                                                                    z7 = false;
                                                                }
                                                                if (z7) {
                                                                    bArr3 = q01.m6942b((String) Assertions.checkNotNull(segmentBase.encryptionIV));
                                                                } else {
                                                                    bArr3 = null;
                                                                }
                                                                DataSource dataSource3 = p01Var.f24973b;
                                                                if (bArr != null) {
                                                                    Assertions.checkNotNull(bArr3);
                                                                    dataSource = new C1112d7(dataSource3, bArr, bArr3);
                                                                } else {
                                                                    dataSource = dataSource3;
                                                                }
                                                                segment2 = segmentBase.initializationSegment;
                                                                if (segment2 != null) {
                                                                    if (bArr2 != null) {
                                                                        z13 = true;
                                                                    } else {
                                                                        z13 = false;
                                                                    }
                                                                    if (z13) {
                                                                        bArr4 = q01.m6942b((String) Assertions.checkNotNull(segment2.encryptionIV));
                                                                    } else {
                                                                        bArr4 = null;
                                                                    }
                                                                    boolean z16 = z13;
                                                                    o01Var2 = o01Var;
                                                                    z8 = z6;
                                                                    z9 = z15;
                                                                    dataSpec = new DataSpec(UriUtil.resolveToUri(playlistSnapshot.baseUri, segment2.url), segment2.byteRangeOffset, segment2.byteRangeLength);
                                                                    if (bArr2 != null) {
                                                                        Assertions.checkNotNull(bArr4);
                                                                        dataSource3 = new C1112d7(dataSource3, bArr2, bArr4);
                                                                    }
                                                                    z10 = z16;
                                                                    dataSource2 = dataSource3;
                                                                } else {
                                                                    o01Var2 = o01Var;
                                                                    z8 = z6;
                                                                    z9 = z15;
                                                                    dataSpec = null;
                                                                    dataSource2 = null;
                                                                    z10 = false;
                                                                }
                                                                long j11 = j5 + segmentBase.relativeStartTimeUs;
                                                                long j12 = j11 + segmentBase.durationUs;
                                                                int i4 = playlistSnapshot.discontinuitySequence + segmentBase.relativeDiscontinuitySequence;
                                                                if (q01Var3 != null) {
                                                                    DataSpec dataSpec2 = q01Var3.f25373g;
                                                                    if (dataSpec != dataSpec2 && (dataSpec == null || dataSpec2 == null || !dataSpec.uri.equals(dataSpec2.uri) || dataSpec.position != dataSpec2.position)) {
                                                                        z11 = false;
                                                                    } else {
                                                                        z11 = true;
                                                                    }
                                                                    if (uri3.equals(q01Var3.f25369c) && q01Var3.f25391y) {
                                                                        z12 = true;
                                                                    } else {
                                                                        z12 = false;
                                                                    }
                                                                    if (z11 && z12 && !q01Var3.f25365A && q01Var3.f25368b == i4) {
                                                                        hlsMediaChunkExtractor2 = q01Var3.f25386t;
                                                                    } else {
                                                                        hlsMediaChunkExtractor2 = null;
                                                                    }
                                                                    id3Decoder = q01Var3.f25381o;
                                                                    parsableByteArray = q01Var3.f25382p;
                                                                    hlsMediaChunkExtractor = hlsMediaChunkExtractor2;
                                                                } else {
                                                                    id3Decoder = new Id3Decoder();
                                                                    parsableByteArray = new ParsableByteArray(10);
                                                                    hlsMediaChunkExtractor = null;
                                                                }
                                                                o01 o01Var3 = o01Var2;
                                                                hlsChunkSource$HlsChunkHolder.chunk = new q01(p01Var.f24972a, dataSource, build, format, z7, dataSource2, dataSpec, z10, uri3, p01Var.f24980i, selectionReason, selectionData, j11, j12, o01Var3.f23551b, o01Var3.f23552c, !z8, i4, segmentBase.hasGapTag, z9, p01Var.f24975d.getAdjuster(i4), segmentBase.drmInitData, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z5, p01Var.f24982k);
                                                            }
                                                        }
                                                    } else {
                                                        uri3 = uri;
                                                    }
                                                    z4 = true;
                                                    z5 = z4;
                                                    z6 = o01Var.f23553d;
                                                    if (z5) {
                                                    }
                                                    Format format2 = p01Var.f24977f[selectedIndexInTrackGroup];
                                                    int selectionReason2 = p01Var.f24988q.getSelectionReason();
                                                    Object selectionData2 = p01Var.f24988q.getSelectionData();
                                                    boolean z152 = p01Var.f24983l;
                                                    b01 b01Var2 = p01Var.f24981j;
                                                    if (resolveToUri == null) {
                                                    }
                                                    if (uri2 == null) {
                                                    }
                                                    AtomicInteger atomicInteger22 = q01.f25364C;
                                                    DataSpec.Builder length2 = new DataSpec.Builder().setUri(UriUtil.resolveToUri(playlistSnapshot.baseUri, segmentBase.url)).setPosition(segmentBase.byteRangeOffset).setLength(segmentBase.byteRangeLength);
                                                    if (z6) {
                                                    }
                                                    DataSpec build2 = length2.setFlags(i).build();
                                                    if (bArr != null) {
                                                    }
                                                    if (z7) {
                                                    }
                                                    DataSource dataSource32 = p01Var.f24973b;
                                                    if (bArr != null) {
                                                    }
                                                    segment2 = segmentBase.initializationSegment;
                                                    if (segment2 != null) {
                                                    }
                                                    long j112 = j5 + segmentBase.relativeStartTimeUs;
                                                    long j122 = j112 + segmentBase.durationUs;
                                                    int i42 = playlistSnapshot.discontinuitySequence + segmentBase.relativeDiscontinuitySequence;
                                                    if (q01Var3 != null) {
                                                    }
                                                    o01 o01Var32 = o01Var2;
                                                    hlsChunkSource$HlsChunkHolder.chunk = new q01(p01Var.f24972a, dataSource, build2, format2, z7, dataSource2, dataSpec, z10, uri3, p01Var.f24980i, selectionReason2, selectionData2, j112, j122, o01Var32.f23551b, o01Var32.f23552c, !z8, i42, segmentBase.hasGapTag, z9, p01Var.f24975d.getAdjuster(i42), segmentBase.drmInitData, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z5, p01Var.f24982k);
                                                }
                                                uri3 = uri;
                                                z5 = false;
                                                z6 = o01Var.f23553d;
                                                if (z5) {
                                                }
                                                Format format22 = p01Var.f24977f[selectedIndexInTrackGroup];
                                                int selectionReason22 = p01Var.f24988q.getSelectionReason();
                                                Object selectionData22 = p01Var.f24988q.getSelectionData();
                                                boolean z1522 = p01Var.f24983l;
                                                b01 b01Var22 = p01Var.f24981j;
                                                if (resolveToUri == null) {
                                                }
                                                if (uri2 == null) {
                                                }
                                                AtomicInteger atomicInteger222 = q01.f25364C;
                                                DataSpec.Builder length22 = new DataSpec.Builder().setUri(UriUtil.resolveToUri(playlistSnapshot.baseUri, segmentBase.url)).setPosition(segmentBase.byteRangeOffset).setLength(segmentBase.byteRangeLength);
                                                if (z6) {
                                                }
                                                DataSpec build22 = length22.setFlags(i).build();
                                                if (bArr != null) {
                                                }
                                                if (z7) {
                                                }
                                                DataSource dataSource322 = p01Var.f24973b;
                                                if (bArr != null) {
                                                }
                                                segment2 = segmentBase.initializationSegment;
                                                if (segment2 != null) {
                                                }
                                                long j1122 = j5 + segmentBase.relativeStartTimeUs;
                                                long j1222 = j1122 + segmentBase.durationUs;
                                                int i422 = playlistSnapshot.discontinuitySequence + segmentBase.relativeDiscontinuitySequence;
                                                if (q01Var3 != null) {
                                                }
                                                o01 o01Var322 = o01Var2;
                                                hlsChunkSource$HlsChunkHolder.chunk = new q01(p01Var.f24972a, dataSource, build22, format22, z7, dataSource2, dataSpec, z10, uri3, p01Var.f24980i, selectionReason22, selectionData22, j1122, j1222, o01Var322.f23551b, o01Var322.f23552c, !z8, i422, segmentBase.hasGapTag, z9, p01Var.f24975d.getAdjuster(i422), segmentBase.drmInitData, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z5, p01Var.f24982k);
                                            }
                                        }
                                    }
                                    o01Var = null;
                                    if (o01Var == null) {
                                    }
                                    p01Var.f24990s = false;
                                    p01Var.f24986o = null;
                                    HlsMediaPlaylist.SegmentBase segmentBase2 = o01Var.f23550a;
                                    segment = segmentBase2.initializationSegment;
                                    if (segment == null) {
                                    }
                                    uri2 = null;
                                    m6766d = p01Var.m6766d(uri2, selectedIndexInTrackGroup);
                                    hlsChunkSource$HlsChunkHolder.chunk = m6766d;
                                    if (m6766d == null) {
                                    }
                                } else {
                                    HlsMediaPlaylist.Segment segment3 = playlistSnapshot.segments.get(i3);
                                    if (intValue == -1) {
                                        o01Var = new o01(segment3, longValue, -1);
                                    } else if (intValue < segment3.parts.size()) {
                                        o01Var = new o01(segment3.parts.get(intValue), longValue, intValue);
                                    } else {
                                        int i5 = i3 + 1;
                                        if (i5 < playlistSnapshot.segments.size()) {
                                            o01Var = new o01(playlistSnapshot.segments.get(i5), longValue + 1, -1);
                                        } else {
                                            if (!playlistSnapshot.trailingParts.isEmpty()) {
                                                o01Var = new o01(playlistSnapshot.trailingParts.get(0), longValue + 1, 0);
                                            }
                                            o01Var = null;
                                        }
                                    }
                                    if (o01Var == null) {
                                    }
                                    p01Var.f24990s = false;
                                    p01Var.f24986o = null;
                                    HlsMediaPlaylist.SegmentBase segmentBase22 = o01Var.f23550a;
                                    segment = segmentBase22.initializationSegment;
                                    if (segment == null) {
                                    }
                                    uri2 = null;
                                    m6766d = p01Var.m6766d(uri2, selectedIndexInTrackGroup);
                                    hlsChunkSource$HlsChunkHolder.chunk = m6766d;
                                    if (m6766d == null) {
                                    }
                                }
                            }
                        }
                        z14 = hlsChunkSource$HlsChunkHolder.endOfStream;
                        Chunk chunk = hlsChunkSource$HlsChunkHolder.chunk;
                        Uri uri4 = hlsChunkSource$HlsChunkHolder.playlistUrl;
                        if (!z14) {
                            this.f27579Q = C0643C.TIME_UNSET;
                            this.f27582T = true;
                            return true;
                        }
                        if (chunk == null) {
                            if (uri4 != null) {
                                this.f27589c.onPlaylistRefreshRequired(uri4);
                                return false;
                            }
                            return false;
                        }
                        if (chunk instanceof q01) {
                            q01 q01Var5 = (q01) chunk;
                            this.f27586X = q01Var5;
                            this.f27568F = q01Var5.trackFormat;
                            this.f27579Q = C0643C.TIME_UNSET;
                            this.f27600n.add(q01Var5);
                            ImmutableList.Builder builder = ImmutableList.builder();
                            for (u01 u01Var2 : this.f27608v) {
                                builder.add((ImmutableList.Builder) Integer.valueOf(u01Var2.getWriteIndex()));
                            }
                            ImmutableList build3 = builder.build();
                            q01Var5.f25387u = this;
                            q01Var5.f25392z = build3;
                            for (u01 u01Var3 : this.f27608v) {
                                u01Var3.getClass();
                                u01Var3.sourceId(q01Var5.f25367a);
                                if (q01Var5.f25370d) {
                                    u01Var3.splice();
                                }
                            }
                        }
                        this.f27607u = chunk;
                        this.f27597k.loadStarted(new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, loader.startLoading(chunk, this, this.f27595i.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.f27588b, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
                        return true;
                    }
                } else {
                    q01Var2 = q01Var;
                }
                j4 = j3;
                q01 q01Var42 = q01Var2;
                p01Var.f24988q.updateSelectedTrack(j, j7, j4, list2, p01Var.m6763a(q01Var42, j6));
                selectedIndexInTrackGroup = p01Var.f24988q.getSelectedIndexInTrackGroup();
                if (i2 == selectedIndexInTrackGroup) {
                }
                Uri[] uriArr2 = p01Var.f24976e;
                uri = uriArr2[selectedIndexInTrackGroup];
                hlsPlaylistTracker = p01Var.f24978g;
                if (hlsPlaylistTracker.isSnapshotValid(uri)) {
                }
                z14 = hlsChunkSource$HlsChunkHolder.endOfStream;
                Chunk chunk2 = hlsChunkSource$HlsChunkHolder.chunk;
                Uri uri42 = hlsChunkSource$HlsChunkHolder.playlistUrl;
                if (!z14) {
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public final void m7797e(int i) {
        ArrayList arrayList;
        Assertions.checkState(!this.f27596j.isLoading());
        loop0: while (true) {
            arrayList = this.f27600n;
            if (i < arrayList.size()) {
                int i2 = i;
                while (true) {
                    if (i2 < arrayList.size()) {
                        if (((q01) arrayList.get(i2)).f25370d) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        q01 q01Var = (q01) arrayList.get(i);
                        for (int i3 = 0; i3 < this.f27608v.length; i3++) {
                            if (this.f27608v[i3].getReadIndex() > q01Var.getFirstSampleIndex(i3)) {
                                break;
                            }
                        }
                        break loop0;
                    }
                }
            } else {
                i = -1;
                break;
            }
            i++;
        }
        if (i == -1) {
            return;
        }
        long j = m7798f().endTimeUs;
        q01 q01Var2 = (q01) arrayList.get(i);
        Util.removeRange(arrayList, i, arrayList.size());
        for (int i4 = 0; i4 < this.f27608v.length; i4++) {
            this.f27608v[i4].discardUpstreamSamples(q01Var2.getFirstSampleIndex(i4));
        }
        if (arrayList.isEmpty()) {
            this.f27579Q = this.f27578P;
        } else {
            ((q01) Iterables.getLast(arrayList)).f25365A = true;
        }
        this.f27582T = false;
        this.f27597k.upstreamDiscarded(this.f27563A, q01Var2.startTimeUs, j);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final void endTracks() {
        this.f27583U = true;
        this.f27604r.post(this.f27603q);
    }

    /* renamed from: f */
    public final q01 m7798f() {
        return (q01) AbstractC1726qj.m7053i(this.f27600n, 1);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        if (this.f27582T) {
            return Long.MIN_VALUE;
        }
        if (m7799h()) {
            return this.f27579Q;
        }
        long j = this.f27578P;
        q01 m7798f = m7798f();
        if (!m7798f.f25391y) {
            ArrayList arrayList = this.f27600n;
            if (arrayList.size() > 1) {
                m7798f = (q01) AbstractC1726qj.m7053i(arrayList, 2);
            } else {
                m7798f = null;
            }
        }
        if (m7798f != null) {
            j = Math.max(j, m7798f.endTimeUs);
        }
        if (this.f27565C) {
            for (u01 u01Var : this.f27608v) {
                j = Math.max(j, u01Var.getLargestQueuedTimestampUs());
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        if (m7799h()) {
            return this.f27579Q;
        }
        if (this.f27582T) {
            return Long.MIN_VALUE;
        }
        return m7798f().endTimeUs;
    }

    /* renamed from: h */
    public final boolean m7799h() {
        if (this.f27579Q != C0643C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public final void m7800i() {
        boolean z;
        int i;
        Format m7793d;
        int i2 = 0;
        if (!this.f27570H && this.f27573K == null && this.f27565C) {
            for (u01 u01Var : this.f27608v) {
                if (u01Var.getUpstreamFormat() == null) {
                    return;
                }
            }
            TrackGroupArray trackGroupArray = this.f27571I;
            if (trackGroupArray != null) {
                int i3 = trackGroupArray.length;
                int[] iArr = new int[i3];
                this.f27573K = iArr;
                Arrays.fill(iArr, -1);
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = 0;
                    while (true) {
                        u01[] u01VarArr = this.f27608v;
                        if (i5 < u01VarArr.length) {
                            Format format = (Format) Assertions.checkStateNotNull(u01VarArr[i5].getUpstreamFormat());
                            Format format2 = this.f27571I.get(i4).getFormat(0);
                            String str = format.sampleMimeType;
                            String str2 = format2.sampleMimeType;
                            int trackType = MimeTypes.getTrackType(str);
                            if (trackType != 3) {
                                if (trackType == MimeTypes.getTrackType(str2)) {
                                    break;
                                } else {
                                    i5++;
                                }
                            } else {
                                if (Util.areEqual(str, str2)) {
                                    if ((!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) || format.accessibilityChannel == format2.accessibilityChannel) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                                i5++;
                            }
                        }
                    }
                    this.f27573K[i4] = i5;
                }
                Iterator it = this.f27605s.iterator();
                while (it.hasNext()) {
                    ((r01) it.next()).m7158a();
                }
                return;
            }
            int length = this.f27608v.length;
            int i6 = 0;
            int i7 = -1;
            int i8 = -2;
            while (true) {
                int i9 = 2;
                if (i6 >= length) {
                    break;
                }
                String str3 = ((Format) Assertions.checkStateNotNull(this.f27608v[i6].getUpstreamFormat())).sampleMimeType;
                if (!MimeTypes.isVideo(str3)) {
                    if (MimeTypes.isAudio(str3)) {
                        i9 = 1;
                    } else if (MimeTypes.isText(str3)) {
                        i9 = 3;
                    } else {
                        i9 = -2;
                    }
                }
                if (m7794g(i9) > m7794g(i8)) {
                    i7 = i6;
                    i8 = i9;
                } else if (i9 == i8 && i7 != -1) {
                    i7 = -1;
                }
                i6++;
            }
            TrackGroup trackGroup = this.f27590d.f24979h;
            int i10 = trackGroup.length;
            this.f27574L = -1;
            this.f27573K = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                this.f27573K[i11] = i11;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            int i12 = 0;
            while (i12 < length) {
                Format format3 = (Format) Assertions.checkStateNotNull(this.f27608v[i12].getUpstreamFormat());
                String str4 = this.f27587a;
                Format format4 = this.f27592f;
                if (i12 == i7) {
                    Format[] formatArr = new Format[i10];
                    for (int i13 = i2; i13 < i10; i13++) {
                        Format format5 = trackGroup.getFormat(i13);
                        if (i8 == 1 && format4 != null) {
                            format5 = format5.withManifestFormatInfo(format4);
                        }
                        if (i10 == 1) {
                            m7793d = format3.withManifestFormatInfo(format5);
                        } else {
                            m7793d = m7793d(format5, format3, true);
                        }
                        formatArr[i13] = m7793d;
                    }
                    trackGroupArr[i12] = new TrackGroup(str4, formatArr);
                    this.f27574L = i12;
                    i = 0;
                } else {
                    if (i8 != 2 || !MimeTypes.isAudio(format3.sampleMimeType)) {
                        format4 = null;
                    }
                    StringBuilder m8303w = ye0.m8303w(str4, ":muxed:");
                    m8303w.append(i12 < i7 ? i12 : i12 - 1);
                    i = 0;
                    trackGroupArr[i12] = new TrackGroup(m8303w.toString(), m7793d(format4, format3, false));
                }
                i12++;
                i2 = i;
            }
            int i14 = i2;
            this.f27571I = m7796c(trackGroupArr);
            if (this.f27572J == null) {
                z = 1;
            } else {
                z = i14;
            }
            Assertions.checkState(z);
            this.f27572J = Collections.emptySet();
            this.f27566D = true;
            this.f27589c.onPrepared();
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return this.f27596j.isLoading();
    }

    /* renamed from: j */
    public final void m7801j() {
        this.f27596j.maybeThrowError();
        p01 p01Var = this.f27590d;
        BehindLiveWindowException behindLiveWindowException = p01Var.f24985n;
        if (behindLiveWindowException == null) {
            Uri uri = p01Var.f24986o;
            if (uri != null && p01Var.f24990s) {
                p01Var.f24978g.maybeThrowPlaylistRefreshError(uri);
                return;
            }
            return;
        }
        throw behindLiveWindowException;
    }

    /* renamed from: k */
    public final void m7802k(TrackGroup[] trackGroupArr, int... iArr) {
        this.f27571I = m7796c(trackGroupArr);
        this.f27572J = new HashSet();
        for (int i : iArr) {
            this.f27572J.add(this.f27571I.get(i));
        }
        this.f27574L = 0;
        this.f27604r.post(new RunnableC0006a5(21, this.f27589c));
        this.f27566D = true;
    }

    /* renamed from: l */
    public final void m7803l() {
        for (u01 u01Var : this.f27608v) {
            u01Var.reset(this.f27580R);
        }
        this.f27580R = false;
    }

    /* renamed from: m */
    public final boolean m7804m(long j, boolean z) {
        this.f27578P = j;
        if (m7799h()) {
            this.f27579Q = j;
            return true;
        }
        if (this.f27565C && !z) {
            int length = this.f27608v.length;
            for (int i = 0; i < length; i++) {
                if (this.f27608v[i].seekTo(j, false) || (!this.f27577O[i] && this.f27575M)) {
                }
            }
            return false;
        }
        this.f27579Q = j;
        this.f27582T = false;
        this.f27600n.clear();
        Loader loader = this.f27596j;
        if (loader.isLoading()) {
            if (this.f27565C) {
                for (u01 u01Var : this.f27608v) {
                    u01Var.discardToEnd();
                }
            }
            loader.cancelLoading();
        } else {
            loader.clearFatalError();
            m7803l();
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        Chunk chunk = (Chunk) loadable;
        this.f27607u = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.f27595i.onLoadTaskConcluded(chunk.loadTaskId);
        this.f27597k.loadCanceled(loadEventInfo, chunk.type, this.f27588b, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (!z) {
            if (m7799h() || this.f27567E == 0) {
                m7803l();
            }
            if (this.f27567E > 0) {
                this.f27589c.onContinueLoadingRequested((HlsMediaPeriod) this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        Chunk chunk = (Chunk) loadable;
        this.f27607u = null;
        p01 p01Var = this.f27590d;
        if (chunk instanceof l01) {
            l01 l01Var = (l01) chunk;
            p01Var.f24984m = l01Var.getDataHolder();
            Uri uri = l01Var.dataSpec.uri;
            byte[] bArr = (byte[]) Assertions.checkNotNull(l01Var.f22270c);
            b01 b01Var = p01Var.f24981j;
            b01Var.getClass();
        }
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.f27595i.onLoadTaskConcluded(chunk.loadTaskId);
        this.f27597k.loadCompleted(loadEventInfo, chunk.type, this.f27588b, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (!this.f27566D) {
            continueLoading(this.f27578P);
        } else {
            this.f27589c.onContinueLoadingRequested((HlsMediaPeriod) this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        boolean z;
        Loader.LoadErrorAction loadErrorAction;
        int i2;
        Chunk chunk = (Chunk) loadable;
        boolean z2 = chunk instanceof q01;
        if (z2 && !((q01) chunk).f25366B && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode) == 410 || i2 == 404)) {
            return Loader.RETRY;
        }
        long bytesLoaded = chunk.bytesLoaded();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, bytesLoaded);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk.type, this.f27588b, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, Util.usToMs(chunk.startTimeUs), Util.usToMs(chunk.endTimeUs)), iOException, i);
        p01 p01Var = this.f27590d;
        LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions = TrackSelectionUtil.createFallbackOptions(p01Var.f24988q);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f27595i;
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(createFallbackOptions, loadErrorInfo);
        boolean z3 = false;
        if (fallbackSelectionFor != null && fallbackSelectionFor.type == 2) {
            long j3 = fallbackSelectionFor.exclusionDurationMs;
            ExoTrackSelection exoTrackSelection = p01Var.f24988q;
            z = exoTrackSelection.blacklist(exoTrackSelection.indexOf(p01Var.f24979h.indexOf(chunk.trackFormat)), j3);
        } else {
            z = false;
        }
        if (z) {
            if (z2 && bytesLoaded == 0) {
                ArrayList arrayList = this.f27600n;
                if (((q01) arrayList.remove(arrayList.size() - 1)) == chunk) {
                    z3 = true;
                }
                Assertions.checkState(z3);
                if (arrayList.isEmpty()) {
                    this.f27579Q = this.f27578P;
                } else {
                    ((q01) Iterables.getLast(arrayList)).f25365A = true;
                }
            }
            loadErrorAction = Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
            if (retryDelayMsFor != C0643C.TIME_UNSET) {
                loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY_FATAL;
            }
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean isRetry = loadErrorAction2.isRetry();
        this.f27597k.loadError(loadEventInfo, chunk.type, this.f27588b, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, iOException, !isRetry);
        if (!isRetry) {
            this.f27607u = null;
            loadErrorHandlingPolicy.onLoadTaskConcluded(chunk.loadTaskId);
        }
        if (z) {
            if (!this.f27566D) {
                continueLoading(this.f27578P);
            } else {
                this.f27589c.onContinueLoadingRequested((HlsMediaPeriod) this);
            }
        }
        return loadErrorAction2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public final void onLoaderReleased() {
        for (u01 u01Var : this.f27608v) {
            u01Var.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public final void onUpstreamFormatChanged(Format format) {
        this.f27604r.post(this.f27602p);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        int size;
        boolean shouldCancelChunkLoad;
        Loader loader = this.f27596j;
        if (!loader.hasFatalError() && !m7799h()) {
            boolean isLoading = loader.isLoading();
            p01 p01Var = this.f27590d;
            List<? extends MediaChunk> list = this.f27601o;
            if (isLoading) {
                Assertions.checkNotNull(this.f27607u);
                Chunk chunk = this.f27607u;
                if (p01Var.f24985n != null) {
                    shouldCancelChunkLoad = false;
                } else {
                    shouldCancelChunkLoad = p01Var.f24988q.shouldCancelChunkLoad(j, chunk, list);
                }
                if (shouldCancelChunkLoad) {
                    loader.cancelLoading();
                    return;
                }
                return;
            }
            int size2 = list.size();
            while (size2 > 0 && p01Var.m6764b((q01) list.get(size2 - 1)) == 2) {
                size2--;
            }
            if (size2 < list.size()) {
                m7797e(size2);
            }
            if (p01Var.f24985n == null && p01Var.f24988q.length() >= 2) {
                size = p01Var.f24988q.evaluateQueueSize(j, list);
            } else {
                size = list.size();
            }
            if (size < this.f27600n.size()) {
                m7797e(size);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.google.android.exoplayer2.extractor.DummyTrackOutput] */
    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final TrackOutput track(int i, int i2) {
        u01 u01Var;
        Integer valueOf = Integer.valueOf(i2);
        Set set = f27562Y;
        boolean contains = set.contains(valueOf);
        HashSet hashSet = this.f27610x;
        SparseIntArray sparseIntArray = this.f27611y;
        boolean z = false;
        u01 u01Var2 = null;
        if (contains) {
            Assertions.checkArgument(set.contains(Integer.valueOf(i2)));
            int i3 = sparseIntArray.get(i2, -1);
            if (i3 != -1) {
                if (hashSet.add(Integer.valueOf(i2))) {
                    this.f27609w[i3] = i;
                }
                if (this.f27609w[i3] == i) {
                    u01Var = this.f27608v[i3];
                } else {
                    u01Var = m7792b(i, i2);
                }
                u01Var2 = u01Var;
            }
        } else {
            int i4 = 0;
            while (true) {
                u01[] u01VarArr = this.f27608v;
                if (i4 >= u01VarArr.length) {
                    break;
                }
                if (this.f27609w[i4] == i) {
                    u01Var2 = u01VarArr[i4];
                    break;
                }
                i4++;
            }
        }
        if (u01Var2 == null) {
            if (this.f27583U) {
                return m7792b(i, i2);
            }
            int length = this.f27608v.length;
            if (i2 == 1 || i2 == 2) {
                z = true;
            }
            u01Var2 = new u01(this.f27591e, this.f27593g, this.f27594h, this.f27606t);
            u01Var2.setStartTimeUs(this.f27578P);
            if (z) {
                u01Var2.f27056I = this.f27585W;
                u01Var2.invalidateUpstreamFormatAdjustment();
            }
            u01Var2.setSampleOffsetUs(this.f27584V);
            q01 q01Var = this.f27586X;
            if (q01Var != null) {
                u01Var2.sourceId(q01Var.f25367a);
            }
            u01Var2.setUpstreamFormatChangeListener(this);
            int i5 = length + 1;
            int[] copyOf = Arrays.copyOf(this.f27609w, i5);
            this.f27609w = copyOf;
            copyOf[length] = i;
            this.f27608v = (u01[]) Util.nullSafeArrayAppend(this.f27608v, u01Var2);
            boolean[] copyOf2 = Arrays.copyOf(this.f27577O, i5);
            this.f27577O = copyOf2;
            copyOf2[length] = z;
            this.f27575M |= z;
            hashSet.add(Integer.valueOf(i2));
            sparseIntArray.append(i2, length);
            if (m7794g(i2) > m7794g(this.f27563A)) {
                this.f27564B = length;
                this.f27563A = i2;
            }
            this.f27576N = Arrays.copyOf(this.f27576N, i5);
        }
        if (i2 == 5) {
            if (this.f27612z == null) {
                this.f27612z = new t01(u01Var2, this.f27598l);
            }
            return this.f27612z;
        }
        return u01Var2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final void seekMap(SeekMap seekMap) {
    }
}
