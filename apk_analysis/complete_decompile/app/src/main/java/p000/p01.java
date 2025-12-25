package p000;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class p01 {

    /* renamed from: a */
    public final HlsExtractorFactory f24972a;

    /* renamed from: b */
    public final DataSource f24973b;

    /* renamed from: c */
    public final DataSource f24974c;

    /* renamed from: d */
    public final TimestampAdjusterProvider f24975d;

    /* renamed from: e */
    public final Uri[] f24976e;

    /* renamed from: f */
    public final Format[] f24977f;

    /* renamed from: g */
    public final HlsPlaylistTracker f24978g;

    /* renamed from: h */
    public final TrackGroup f24979h;

    /* renamed from: i */
    public final List f24980i;

    /* renamed from: k */
    public final PlayerId f24982k;

    /* renamed from: l */
    public boolean f24983l;

    /* renamed from: n */
    public BehindLiveWindowException f24985n;

    /* renamed from: o */
    public Uri f24986o;

    /* renamed from: p */
    public boolean f24987p;

    /* renamed from: q */
    public ExoTrackSelection f24988q;

    /* renamed from: s */
    public boolean f24990s;

    /* renamed from: j */
    public final b01 f24981j = new b01(16);

    /* renamed from: m */
    public byte[] f24984m = Util.EMPTY_BYTE_ARRAY;

    /* renamed from: r */
    public long f24989r = C0643C.TIME_UNSET;

    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.exoplayer2.trackselection.ExoTrackSelection, com.google.android.exoplayer2.trackselection.BaseTrackSelection, n01] */
    public p01(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, List list, PlayerId playerId) {
        this.f24972a = hlsExtractorFactory;
        this.f24978g = hlsPlaylistTracker;
        this.f24976e = uriArr;
        this.f24977f = formatArr;
        this.f24975d = timestampAdjusterProvider;
        this.f24980i = list;
        this.f24982k = playerId;
        DataSource createDataSource = hlsDataSourceFactory.createDataSource(1);
        this.f24973b = createDataSource;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        this.f24974c = hlsDataSourceFactory.createDataSource(3);
        this.f24979h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((formatArr[i].roleFlags & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        TrackGroup trackGroup = this.f24979h;
        int[] array = Ints.toArray(arrayList);
        ?? baseTrackSelection = new BaseTrackSelection(trackGroup, array);
        baseTrackSelection.f23186e = baseTrackSelection.indexOf(trackGroup.getFormat(array[0]));
        this.f24988q = baseTrackSelection;
    }

    /* renamed from: a */
    public final MediaChunkIterator[] m6763a(q01 q01Var, long j) {
        int indexOf;
        boolean z;
        List m3902of;
        if (q01Var == null) {
            indexOf = -1;
        } else {
            indexOf = this.f24979h.indexOf(q01Var.trackFormat);
        }
        int length = this.f24988q.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z2 = false;
        int i = 0;
        while (i < length) {
            int indexInTrackGroup = this.f24988q.getIndexInTrackGroup(i);
            Uri uri = this.f24976e[indexInTrackGroup];
            HlsPlaylistTracker hlsPlaylistTracker = this.f24978g;
            if (!hlsPlaylistTracker.isSnapshotValid(uri)) {
                mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
            } else {
                HlsMediaPlaylist playlistSnapshot = hlsPlaylistTracker.getPlaylistSnapshot(uri, z2);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - hlsPlaylistTracker.getInitialStartTimeUs();
                if (indexInTrackGroup != indexOf) {
                    z = true;
                } else {
                    z = z2;
                }
                Pair m6765c = m6765c(q01Var, z, playlistSnapshot, initialStartTimeUs, j);
                long longValue = ((Long) m6765c.first).longValue();
                int intValue = ((Integer) m6765c.second).intValue();
                String str = playlistSnapshot.baseUri;
                int i2 = (int) (longValue - playlistSnapshot.mediaSequence);
                if (i2 >= 0 && playlistSnapshot.segments.size() >= i2) {
                    ArrayList arrayList = new ArrayList();
                    if (i2 < playlistSnapshot.segments.size()) {
                        if (intValue != -1) {
                            HlsMediaPlaylist.Segment segment = playlistSnapshot.segments.get(i2);
                            if (intValue == 0) {
                                arrayList.add(segment);
                            } else if (intValue < segment.parts.size()) {
                                List<HlsMediaPlaylist.Part> list = segment.parts;
                                arrayList.addAll(list.subList(intValue, list.size()));
                            }
                            i2++;
                        }
                        List<HlsMediaPlaylist.Segment> list2 = playlistSnapshot.segments;
                        arrayList.addAll(list2.subList(i2, list2.size()));
                        intValue = 0;
                    }
                    if (playlistSnapshot.partTargetDurationUs != C0643C.TIME_UNSET) {
                        if (intValue == -1) {
                            intValue = 0;
                        }
                        if (intValue < playlistSnapshot.trailingParts.size()) {
                            List<HlsMediaPlaylist.Part> list3 = playlistSnapshot.trailingParts;
                            arrayList.addAll(list3.subList(intValue, list3.size()));
                        }
                    }
                    m3902of = Collections.unmodifiableList(arrayList);
                } else {
                    m3902of = ImmutableList.m3902of();
                }
                mediaChunkIteratorArr[i] = new m01(str, initialStartTimeUs, m3902of);
            }
            i++;
            z2 = false;
        }
        return mediaChunkIteratorArr;
    }

    /* renamed from: b */
    public final int m6764b(q01 q01Var) {
        List<HlsMediaPlaylist.Part> list;
        if (q01Var.f25371e == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.checkNotNull(this.f24978g.getPlaylistSnapshot(this.f24976e[this.f24979h.indexOf(q01Var.trackFormat)], false));
        int i = (int) (q01Var.chunkIndex - hlsMediaPlaylist.mediaSequence);
        if (i < 0) {
            return 1;
        }
        if (i < hlsMediaPlaylist.segments.size()) {
            list = hlsMediaPlaylist.segments.get(i).parts;
        } else {
            list = hlsMediaPlaylist.trailingParts;
        }
        int size = list.size();
        int i2 = q01Var.f25371e;
        if (i2 >= size) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(i2);
        if (part.isPreload) {
            return 0;
        }
        if (Util.areEqual(Uri.parse(UriUtil.resolve(hlsMediaPlaylist.baseUri, part.url)), q01Var.dataSpec.uri)) {
            return 1;
        }
        return 2;
    }

    /* renamed from: c */
    public final Pair m6765c(q01 q01Var, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        boolean z2;
        List<HlsMediaPlaylist.Part> list;
        long j3;
        long j4;
        int i = -1;
        if (q01Var != null && !z) {
            boolean z3 = q01Var.f25391y;
            int i2 = q01Var.f25371e;
            if (z3) {
                if (i2 == -1) {
                    j4 = q01Var.getNextChunkIndex();
                } else {
                    j4 = q01Var.chunkIndex;
                }
                Long valueOf = Long.valueOf(j4);
                if (i2 != -1) {
                    i = i2 + 1;
                }
                return new Pair(valueOf, Integer.valueOf(i));
            }
            return new Pair(Long.valueOf(q01Var.chunkIndex), Integer.valueOf(i2));
        }
        long j5 = hlsMediaPlaylist.durationUs + j;
        if (q01Var != null && !this.f24987p) {
            j2 = q01Var.startTimeUs;
        }
        if (!hlsMediaPlaylist.hasEndTag && j2 >= j5) {
            return new Pair(Long.valueOf(hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size()), -1);
        }
        long j6 = j2 - j;
        List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.segments;
        Long valueOf2 = Long.valueOf(j6);
        int i3 = 0;
        if (this.f24978g.isLive() && q01Var != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) list2, valueOf2, true, z2);
        long j7 = binarySearchFloor + hlsMediaPlaylist.mediaSequence;
        if (binarySearchFloor >= 0) {
            HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(binarySearchFloor);
            if (j6 < segment.relativeStartTimeUs + segment.durationUs) {
                list = segment.parts;
            } else {
                list = hlsMediaPlaylist.trailingParts;
            }
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                HlsMediaPlaylist.Part part = list.get(i3);
                if (j6 < part.relativeStartTimeUs + part.durationUs) {
                    if (part.isIndependent) {
                        if (list == hlsMediaPlaylist.trailingParts) {
                            j3 = 1;
                        } else {
                            j3 = 0;
                        }
                        j7 += j3;
                        i = i3;
                    }
                } else {
                    i3++;
                }
            }
        }
        return new Pair(Long.valueOf(j7), Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.android.exoplayer2.source.chunk.DataChunk, l01] */
    /* renamed from: d */
    public final l01 m6766d(Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        b01 b01Var = this.f24981j;
        byte[] bArr = (byte[]) ((bv0) b01Var.f7833b).remove(Assertions.checkNotNull(uri));
        if (bArr != null) {
            return null;
        }
        return new DataChunk(this.f24974c, new DataSpec.Builder().setUri(uri).setFlags(1).build(), 3, this.f24977f[i], this.f24988q.getSelectionReason(), this.f24988q.getSelectionData(), this.f24984m);
    }
}
