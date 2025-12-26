package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultDashChunkSource implements DashChunkSource {

    /* renamed from: a */
    public final LoaderErrorThrower f11255a;

    /* renamed from: b */
    public final BaseUrlExclusionList f11256b;

    /* renamed from: c */
    public final int[] f11257c;

    /* renamed from: d */
    public final int f11258d;

    /* renamed from: e */
    public final DataSource f11259e;

    /* renamed from: f */
    public final long f11260f;

    /* renamed from: g */
    public final int f11261g;

    /* renamed from: h */
    public final PlayerEmsgHandler.PlayerTrackEmsgHandler f11262h;

    /* renamed from: i */
    public ExoTrackSelection f11263i;

    /* renamed from: j */
    public DashManifest f11264j;

    /* renamed from: k */
    public int f11265k;

    /* renamed from: l */
    public BehindLiveWindowException f11266l;

    /* renamed from: m */
    public boolean f11267m;
    protected final RepresentationHolder[] representationHolders;

    /* loaded from: classes.dex */
    public static final class Factory implements DashChunkSource.Factory {

        /* renamed from: a */
        public final DataSource.Factory f11268a;

        /* renamed from: b */
        public final int f11269b;

        /* renamed from: c */
        public final ChunkExtractor.Factory f11270c;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, long j, boolean z, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @Nullable TransferListener transferListener, PlayerId playerId) {
            DataSource createDataSource = this.f11268a.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultDashChunkSource(this.f11270c, loaderErrorThrower, dashManifest, baseUrlExclusionList, i, iArr, exoTrackSelection, i2, createDataSource, j, this.f11269b, z, list, playerTrackEmsgHandler, playerId);
        }

        public Factory(DataSource.Factory factory, int i) {
            this(BundledChunkExtractor.FACTORY, factory, i);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i) {
            this.f11270c = factory;
            this.f11268a = factory2;
            this.f11269b = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class RepresentationHolder {

        /* renamed from: a */
        public final ChunkExtractor f11271a;

        /* renamed from: b */
        public final long f11272b;

        /* renamed from: c */
        public final long f11273c;
        public final Representation representation;

        @Nullable
        public final DashSegmentIndex segmentIndex;
        public final BaseUrl selectedBaseUrl;

        public RepresentationHolder(long j, Representation representation, BaseUrl baseUrl, ChunkExtractor chunkExtractor, long j2, DashSegmentIndex dashSegmentIndex) {
            this.f11272b = j;
            this.representation = representation;
            this.selectedBaseUrl = baseUrl;
            this.f11273c = j2;
            this.f11271a = chunkExtractor;
            this.segmentIndex = dashSegmentIndex;
        }

        /* renamed from: a */
        public final RepresentationHolder m2783a(Representation representation, long j) {
            long segmentNum;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation.getIndex();
            if (index == null) {
                return new RepresentationHolder(j, representation, this.selectedBaseUrl, this.f11271a, this.f11273c, index);
            }
            if (!index.isExplicit()) {
                return new RepresentationHolder(j, representation, this.selectedBaseUrl, this.f11271a, this.f11273c, index2);
            }
            long segmentCount = index.getSegmentCount(j);
            if (segmentCount == 0) {
                return new RepresentationHolder(j, representation, this.selectedBaseUrl, this.f11271a, this.f11273c, index2);
            }
            long firstSegmentNum = index.getFirstSegmentNum();
            long timeUs = index.getTimeUs(firstSegmentNum);
            long j2 = segmentCount + firstSegmentNum;
            long j3 = j2 - 1;
            long durationUs = index.getDurationUs(j3, j) + index.getTimeUs(j3);
            long firstSegmentNum2 = index2.getFirstSegmentNum();
            long timeUs2 = index2.getTimeUs(firstSegmentNum2);
            long j4 = this.f11273c;
            if (durationUs != timeUs2) {
                if (durationUs >= timeUs2) {
                    if (timeUs2 < timeUs) {
                        segmentNum = j4 - (index2.getSegmentNum(timeUs, j) - firstSegmentNum);
                        return new RepresentationHolder(j, representation, this.selectedBaseUrl, this.f11271a, segmentNum, index2);
                    }
                    j2 = index.getSegmentNum(timeUs2, j);
                } else {
                    throw new BehindLiveWindowException();
                }
            }
            segmentNum = (j2 - firstSegmentNum2) + j4;
            return new RepresentationHolder(j, representation, this.selectedBaseUrl, this.f11271a, segmentNum, index2);
        }

        public long getFirstAvailableSegmentNum(long j) {
            return this.segmentIndex.getFirstAvailableSegmentNum(this.f11272b, j) + this.f11273c;
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.f11273c;
        }

        public long getLastAvailableSegmentNum(long j) {
            return (this.segmentIndex.getAvailableSegmentCount(this.f11272b, j) + getFirstAvailableSegmentNum(j)) - 1;
        }

        public long getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.f11272b);
        }

        public long getSegmentEndTimeUs(long j) {
            return this.segmentIndex.getDurationUs(j - this.f11273c, this.f11272b) + getSegmentStartTimeUs(j);
        }

        public long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.f11272b) + this.f11273c;
        }

        public long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.f11273c);
        }

        public RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.f11273c);
        }

        public boolean isSegmentAvailableAtFullNetworkSpeed(long j, long j2) {
            if (this.segmentIndex.isExplicit() || j2 == C0643C.TIME_UNSET || getSegmentEndTimeUs(j) <= j2) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: d */
        public final RepresentationHolder f11274d;

        /* renamed from: e */
        public final long f11275e;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long j, long j2, long j3) {
            super(j, j2);
            this.f11274d = representationHolder;
            this.f11275e = j3;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.f11274d.getSegmentEndTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.f11274d.getSegmentStartTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            int i;
            checkInBounds();
            long currentIndex = getCurrentIndex();
            RepresentationHolder representationHolder = this.f11274d;
            RangedUri segmentUrl = representationHolder.getSegmentUrl(currentIndex);
            if (representationHolder.isSegmentAvailableAtFullNetworkSpeed(currentIndex, this.f11275e)) {
                i = 0;
            } else {
                i = 8;
            }
            return DashUtil.buildDataSpec(representationHolder.representation, representationHolder.selectedBaseUrl.url, segmentUrl, i);
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, DataSource dataSource, long j, int i3, boolean z, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, PlayerId playerId) {
        this.f11255a = loaderErrorThrower;
        this.f11264j = dashManifest;
        this.f11256b = baseUrlExclusionList;
        this.f11257c = iArr;
        this.f11263i = exoTrackSelection;
        this.f11258d = i2;
        this.f11259e = dataSource;
        this.f11265k = i;
        this.f11260f = j;
        this.f11261g = i3;
        this.f11262h = playerTrackEmsgHandler;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        ArrayList m2781a = m2781a();
        this.representationHolders = new RepresentationHolder[exoTrackSelection.length()];
        int i4 = 0;
        while (i4 < this.representationHolders.length) {
            Representation representation = (Representation) m2781a.get(exoTrackSelection.getIndexInTrackGroup(i4));
            BaseUrl selectBaseUrl = baseUrlExclusionList.selectBaseUrl(representation.baseUrls);
            int i5 = i4;
            this.representationHolders[i5] = new RepresentationHolder(periodDurationUs, representation, selectBaseUrl == null ? representation.baseUrls.get(0) : selectBaseUrl, factory.createProgressiveMediaExtractor(i2, representation.format, z, list, playerTrackEmsgHandler, playerId), 0L, representation.getIndex());
            i4 = i5 + 1;
        }
    }

    /* renamed from: a */
    public final ArrayList m2781a() {
        List<AdaptationSet> list = this.f11264j.getPeriod(this.f11265k).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (int i : this.f11257c) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    /* renamed from: b */
    public final RepresentationHolder m2782b(int i) {
        RepresentationHolder representationHolder = this.representationHolders[i];
        BaseUrl selectBaseUrl = this.f11256b.selectBaseUrl(representationHolder.representation.baseUrls);
        if (selectBaseUrl != null && !selectBaseUrl.equals(representationHolder.selectedBaseUrl)) {
            RepresentationHolder representationHolder2 = new RepresentationHolder(representationHolder.f11272b, representationHolder.representation, selectBaseUrl, representationHolder.f11271a, representationHolder.f11273c, representationHolder.segmentIndex);
            this.representationHolders[i] = representationHolder2;
            return representationHolder2;
        }
        return representationHolder;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2;
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                long segmentCount = representationHolder.getSegmentCount();
                if (segmentStartTimeUs < j && (segmentCount == -1 || segmentNum < (representationHolder.getFirstSegmentNum() + segmentCount) - 1)) {
                    j2 = representationHolder.getSegmentStartTimeUs(segmentNum + 1);
                } else {
                    j2 = segmentStartTimeUs;
                }
                return seekParameters.resolveSeekPositionUs(j, segmentStartTimeUs, j2);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        long msToUs;
        MediaChunk mediaChunk;
        MediaChunkIterator[] mediaChunkIteratorArr;
        long msToUs2;
        long j3;
        long max;
        boolean z;
        long constrainValue;
        RangedUri rangedUri;
        RangedUri rangedUri2;
        long constrainValue2;
        if (this.f11266l != null) {
            return;
        }
        long j4 = j2 - j;
        long msToUs3 = Util.msToUs(this.f11264j.getPeriod(this.f11265k).startMs) + Util.msToUs(this.f11264j.availabilityStartTimeMs) + j2;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f11262h;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(msToUs3)) {
            return;
        }
        long msToUs4 = Util.msToUs(Util.getNowUnixTimeMs(this.f11260f));
        DashManifest dashManifest = this.f11264j;
        long j5 = dashManifest.availabilityStartTimeMs;
        long j6 = C0643C.TIME_UNSET;
        if (j5 == C0643C.TIME_UNSET) {
            msToUs = -9223372036854775807L;
        } else {
            msToUs = msToUs4 - Util.msToUs(j5 + dashManifest.getPeriod(this.f11265k).startMs);
        }
        if (list.isEmpty()) {
            mediaChunk = null;
        } else {
            mediaChunk = list.get(list.size() - 1);
        }
        int length = this.f11263i.length();
        MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            RepresentationHolder representationHolder = this.representationHolders[i];
            if (representationHolder.segmentIndex == null) {
                mediaChunkIteratorArr2[i] = MediaChunkIterator.EMPTY;
            } else {
                long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(msToUs4);
                long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(msToUs4);
                if (mediaChunk != null) {
                    constrainValue2 = mediaChunk.getNextChunkIndex();
                } else {
                    constrainValue2 = Util.constrainValue(representationHolder.getSegmentNum(j2), firstAvailableSegmentNum, lastAvailableSegmentNum);
                }
                long j7 = constrainValue2;
                if (j7 < firstAvailableSegmentNum) {
                    mediaChunkIteratorArr2[i] = MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr2[i] = new RepresentationSegmentIterator(m2782b(i), j7, lastAvailableSegmentNum, msToUs);
                }
            }
        }
        if (!this.f11264j.dynamic) {
            mediaChunkIteratorArr = mediaChunkIteratorArr2;
            max = -9223372036854775807L;
            j3 = 0;
        } else {
            long segmentEndTimeUs = this.representationHolders[0].getSegmentEndTimeUs(this.representationHolders[0].getLastAvailableSegmentNum(msToUs4));
            DashManifest dashManifest2 = this.f11264j;
            long j8 = dashManifest2.availabilityStartTimeMs;
            if (j8 == C0643C.TIME_UNSET) {
                mediaChunkIteratorArr = mediaChunkIteratorArr2;
                msToUs2 = -9223372036854775807L;
            } else {
                mediaChunkIteratorArr = mediaChunkIteratorArr2;
                msToUs2 = msToUs4 - Util.msToUs(j8 + dashManifest2.getPeriod(this.f11265k).startMs);
            }
            long min = Math.min(msToUs2, segmentEndTimeUs) - j;
            j3 = 0;
            max = Math.max(0L, min);
        }
        long j9 = j3;
        this.f11263i.updateSelectedTrack(j, j4, max, list, mediaChunkIteratorArr);
        RepresentationHolder m2782b = m2782b(this.f11263i.getSelectedIndex());
        ChunkExtractor chunkExtractor = m2782b.f11271a;
        if (chunkExtractor != null) {
            Representation representation = m2782b.representation;
            if (chunkExtractor.getSampleFormats() == null) {
                rangedUri = representation.getInitializationUri();
            } else {
                rangedUri = null;
            }
            if (m2782b.segmentIndex == null) {
                rangedUri2 = representation.getIndexUri();
            } else {
                rangedUri2 = null;
            }
            if (rangedUri != null || rangedUri2 != null) {
                chunkHolder.chunk = newInitializationChunk(m2782b, this.f11259e, this.f11263i.getSelectedFormat(), this.f11263i.getSelectionReason(), this.f11263i.getSelectionData(), rangedUri, rangedUri2);
                return;
            }
        }
        long j10 = m2782b.f11272b;
        if (j10 != C0643C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        if (m2782b.getSegmentCount() == j9) {
            chunkHolder.endOfStream = z;
            return;
        }
        long firstAvailableSegmentNum2 = m2782b.getFirstAvailableSegmentNum(msToUs4);
        long lastAvailableSegmentNum2 = m2782b.getLastAvailableSegmentNum(msToUs4);
        if (mediaChunk != null) {
            constrainValue = mediaChunk.getNextChunkIndex();
        } else {
            constrainValue = Util.constrainValue(m2782b.getSegmentNum(j2), firstAvailableSegmentNum2, lastAvailableSegmentNum2);
        }
        if (constrainValue < firstAvailableSegmentNum2) {
            this.f11266l = new BehindLiveWindowException();
            return;
        }
        if (constrainValue <= lastAvailableSegmentNum2 && (!this.f11267m || constrainValue < lastAvailableSegmentNum2)) {
            if (z && m2782b.getSegmentStartTimeUs(constrainValue) >= j10) {
                chunkHolder.endOfStream = true;
                return;
            }
            int min2 = (int) Math.min(this.f11261g, (lastAvailableSegmentNum2 - constrainValue) + 1);
            if (j10 != C0643C.TIME_UNSET) {
                while (min2 > 1 && m2782b.getSegmentStartTimeUs((min2 + constrainValue) - 1) >= j10) {
                    min2--;
                }
            }
            int i2 = min2;
            if (list.isEmpty()) {
                j6 = j2;
            }
            chunkHolder.chunk = newMediaChunk(m2782b, this.f11259e, this.f11258d, this.f11263i.getSelectedFormat(), this.f11263i.getSelectionReason(), this.f11263i.getSelectionData(), constrainValue, i2, j6, msToUs);
            return;
        }
        chunkHolder.endOfStream = z;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.f11266l == null && this.f11263i.length() >= 2) {
            return this.f11263i.evaluateQueueSize(j, list);
        }
        return list.size();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() {
        BehindLiveWindowException behindLiveWindowException = this.f11266l;
        if (behindLiveWindowException == null) {
            this.f11255a.maybeThrowError();
            return;
        }
        throw behindLiveWindowException;
    }

    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i, @Nullable Object obj, @Nullable RangedUri rangedUri, @Nullable RangedUri rangedUri2) {
        RangedUri rangedUri3 = rangedUri;
        Representation representation = representationHolder.representation;
        if (rangedUri3 != null) {
            RangedUri attemptMerge = rangedUri3.attemptMerge(rangedUri2, representationHolder.selectedBaseUrl.url);
            if (attemptMerge != null) {
                rangedUri3 = attemptMerge;
            }
        } else {
            rangedUri3 = rangedUri2;
        }
        return new InitializationChunk(dataSource, DashUtil.buildDataSpec(representation, representationHolder.selectedBaseUrl.url, rangedUri3, 0), format, i, obj, representationHolder.f11271a);
    }

    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, int i, Format format, int i2, Object obj, long j, int i3, long j2, long j3) {
        long j4;
        int i4;
        int i5;
        Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(j);
        RangedUri segmentUrl = representationHolder.getSegmentUrl(j);
        if (representationHolder.f11271a == null) {
            long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs(j);
            if (representationHolder.isSegmentAvailableAtFullNetworkSpeed(j, j3)) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            return new SingleSampleMediaChunk(dataSource, DashUtil.buildDataSpec(representation, representationHolder.selectedBaseUrl.url, segmentUrl, i5), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j, i, format);
        }
        int i6 = 1;
        int i7 = 1;
        while (i6 < i3) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder.getSegmentUrl(i6 + j), representationHolder.selectedBaseUrl.url);
            if (attemptMerge == null) {
                break;
            }
            i7++;
            i6++;
            segmentUrl = attemptMerge;
        }
        long j5 = (i7 + j) - 1;
        long segmentEndTimeUs2 = representationHolder.getSegmentEndTimeUs(j5);
        long j6 = representationHolder.f11272b;
        if (j6 != C0643C.TIME_UNSET && j6 <= segmentEndTimeUs2) {
            j4 = j6;
        } else {
            j4 = -9223372036854775807L;
        }
        if (representationHolder.isSegmentAvailableAtFullNetworkSpeed(j5, j3)) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        return new ContainerMediaChunk(dataSource, DashUtil.buildDataSpec(representation, representationHolder.selectedBaseUrl.url, segmentUrl, i4), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs2, j2, j4, j, i7, -representation.presentationTimeOffsetUs, representationHolder.f11271a);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        ChunkIndex chunkIndex;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.f11263i.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (chunkIndex = representationHolder.f11271a.getChunkIndex()) != null) {
                this.representationHolders[indexOf] = new RepresentationHolder(representationHolder.f11272b, representationHolder.representation, representationHolder.selectedBaseUrl, representationHolder.f11271a, representationHolder.f11273c, new DashWrappingSegmentIndex(chunkIndex, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f11262h;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f11262h;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.onChunkLoadError(chunk)) {
            return true;
        }
        if (!this.f11264j.dynamic && (chunk instanceof MediaChunk)) {
            IOException iOException = loadErrorInfo.exception;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 404) {
                RepresentationHolder representationHolder = this.representationHolders[this.f11263i.indexOf(chunk.trackFormat)];
                long segmentCount = representationHolder.getSegmentCount();
                if (segmentCount != -1 && segmentCount != 0) {
                    if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                        this.f11267m = true;
                        return true;
                    }
                }
            }
        }
        RepresentationHolder representationHolder2 = this.representationHolders[this.f11263i.indexOf(chunk.trackFormat)];
        ImmutableList<BaseUrl> immutableList = representationHolder2.representation.baseUrls;
        BaseUrlExclusionList baseUrlExclusionList = this.f11256b;
        BaseUrl selectBaseUrl = baseUrlExclusionList.selectBaseUrl(immutableList);
        if (selectBaseUrl != null && !representationHolder2.selectedBaseUrl.equals(selectBaseUrl)) {
            return true;
        }
        ExoTrackSelection exoTrackSelection = this.f11263i;
        ImmutableList<BaseUrl> immutableList2 = representationHolder2.representation.baseUrls;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (exoTrackSelection.isBlacklisted(i2, elapsedRealtime)) {
                i++;
            }
        }
        int priorityCount = BaseUrlExclusionList.getPriorityCount(immutableList2);
        LoadErrorHandlingPolicy.FallbackOptions fallbackOptions = new LoadErrorHandlingPolicy.FallbackOptions(priorityCount, priorityCount - baseUrlExclusionList.getPriorityCountAfterExclusion(immutableList2), length, i);
        if ((!fallbackOptions.isFallbackAvailable(2) && !fallbackOptions.isFallbackAvailable(1)) || (fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(fallbackOptions, loadErrorInfo)) == null || !fallbackOptions.isFallbackAvailable(fallbackSelectionFor.type)) {
            return false;
        }
        int i3 = fallbackSelectionFor.type;
        if (i3 == 2) {
            ExoTrackSelection exoTrackSelection2 = this.f11263i;
            return exoTrackSelection2.blacklist(exoTrackSelection2.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs);
        }
        if (i3 != 1) {
            return false;
        }
        baseUrlExclusionList.exclude(representationHolder2.selectedBaseUrl, fallbackSelectionFor.exclusionDurationMs);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void release() {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            ChunkExtractor chunkExtractor = representationHolder.f11271a;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean shouldCancelLoad(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f11266l != null) {
            return false;
        }
        return this.f11263i.shouldCancelChunkLoad(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.f11264j = dashManifest;
            this.f11265k = i;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            ArrayList m2781a = m2781a();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                Representation representation = (Representation) m2781a.get(this.f11263i.getIndexInTrackGroup(i2));
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i2] = representationHolderArr[i2].m2783a(representation, periodDurationUs);
            }
        } catch (BehindLiveWindowException e) {
            this.f11266l = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.f11263i = exoTrackSelection;
    }
}
