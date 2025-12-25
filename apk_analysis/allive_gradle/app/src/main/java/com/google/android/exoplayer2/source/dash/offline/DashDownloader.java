package com.google.android.exoplayer2.source.dash.offline;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.dash.BaseUrlExclusionList;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p000.C1102cy;
import p000.ExecutorC0582c6;

/* loaded from: classes.dex */
public final class DashDownloader extends SegmentDownloader<DashManifest> {

    /* renamed from: k */
    public final BaseUrlExclusionList f11354k;

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new ExecutorC0582c6(0));
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new DashManifestParser(), factory, executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0106 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, boolean z) {
        long j;
        List<AdaptationSet> list;
        int i;
        DashSegmentIndex dashWrappingSegmentIndex;
        DashDownloader dashDownloader = this;
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        loop0: while (i2 < dashManifest.getPeriodCount()) {
            Period period = dashManifest2.getPeriod(i2);
            long msToUs = Util.msToUs(period.startMs);
            long periodDurationUs = dashManifest2.getPeriodDurationUs(i2);
            List<AdaptationSet> list2 = period.adaptationSets;
            int i3 = 0;
            while (i3 < list2.size()) {
                AdaptationSet adaptationSet = list2.get(i3);
                int i4 = 0;
                while (i4 < adaptationSet.representations.size()) {
                    Representation representation = adaptationSet.representations.get(i4);
                    try {
                        int i5 = adaptationSet.type;
                        DashSegmentIndex index = representation.getIndex();
                        if (index != null) {
                            list = list2;
                            i = i3;
                            dashWrappingSegmentIndex = index;
                        } else {
                            ChunkIndex chunkIndex = (ChunkIndex) dashDownloader.execute(new C1102cy(dataSource, i5, representation), z);
                            if (chunkIndex == null) {
                                dashWrappingSegmentIndex = null;
                                list = list2;
                                i = i3;
                            } else {
                                list = list2;
                                i = i3;
                                try {
                                    dashWrappingSegmentIndex = new DashWrappingSegmentIndex(chunkIndex, representation.presentationTimeOffsetUs);
                                } catch (IOException e) {
                                    e = e;
                                    j = periodDurationUs;
                                    if (z) {
                                        throw e;
                                    }
                                    i4++;
                                    dashDownloader = this;
                                    list2 = list;
                                    i3 = i;
                                    periodDurationUs = j;
                                }
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        j = periodDurationUs;
                        list = list2;
                        i = i3;
                    }
                    if (dashWrappingSegmentIndex != null) {
                        long segmentCount = dashWrappingSegmentIndex.getSegmentCount(periodDurationUs);
                        if (segmentCount != -1) {
                            String str = ((BaseUrl) Util.castNonNull(dashDownloader.f11354k.selectBaseUrl(representation.baseUrls))).url;
                            RangedUri initializationUri = representation.getInitializationUri();
                            if (initializationUri != null) {
                                arrayList.add(new SegmentDownloader.Segment(msToUs, DashUtil.buildDataSpec(representation, str, initializationUri, 0)));
                            }
                            RangedUri indexUri = representation.getIndexUri();
                            if (indexUri != null) {
                                arrayList.add(new SegmentDownloader.Segment(msToUs, DashUtil.buildDataSpec(representation, str, indexUri, 0)));
                            }
                            long firstSegmentNum = dashWrappingSegmentIndex.getFirstSegmentNum();
                            j = periodDurationUs;
                            long j2 = firstSegmentNum;
                            for (long j3 = (firstSegmentNum + segmentCount) - 1; j2 <= j3; j3 = j3) {
                                arrayList.add(new SegmentDownloader.Segment(dashWrappingSegmentIndex.getTimeUs(j2) + msToUs, DashUtil.buildDataSpec(representation, str, dashWrappingSegmentIndex.getSegmentUrl(j2), 0)));
                                j2++;
                            }
                            i4++;
                            dashDownloader = this;
                            list2 = list;
                            i3 = i;
                            periodDurationUs = j;
                        } else {
                            throw new DownloadException("Unbounded segment index");
                        }
                    } else {
                        j = periodDurationUs;
                        try {
                            throw new DownloadException("Missing segment index");
                            break loop0;
                        } catch (IOException e3) {
                            e = e3;
                            if (z) {
                            }
                        }
                    }
                }
                i3++;
                dashDownloader = this;
            }
            i2++;
            dashDownloader = this;
            dashManifest2 = dashManifest;
        }
        return arrayList;
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, parser, factory, executor);
        this.f11354k = new BaseUrlExclusionList();
    }
}
