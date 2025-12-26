package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import p000.i10;

/* loaded from: classes.dex */
public class DefaultSsChunkSource implements SsChunkSource {

    /* renamed from: a */
    public final LoaderErrorThrower f11632a;

    /* renamed from: b */
    public final int f11633b;

    /* renamed from: c */
    public final ChunkExtractor[] f11634c;

    /* renamed from: d */
    public final DataSource f11635d;

    /* renamed from: e */
    public ExoTrackSelection f11636e;

    /* renamed from: f */
    public SsManifest f11637f;

    /* renamed from: g */
    public int f11638g;

    /* renamed from: h */
    public BehindLiveWindowException f11639h;

    /* loaded from: classes.dex */
    public static final class Factory implements SsChunkSource.Factory {

        /* renamed from: a */
        public final DataSource.Factory f11640a;

        public Factory(DataSource.Factory factory) {
            this.f11640a = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, ExoTrackSelection exoTrackSelection, @Nullable TransferListener transferListener) {
            DataSource createDataSource = this.f11640a.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, exoTrackSelection, createDataSource);
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, ExoTrackSelection exoTrackSelection, DataSource dataSource) {
        TrackEncryptionBox[] trackEncryptionBoxArr;
        int i2;
        this.f11632a = loaderErrorThrower;
        this.f11637f = ssManifest;
        this.f11633b = i;
        this.f11636e = exoTrackSelection;
        this.f11635d = dataSource;
        SsManifest.StreamElement streamElement = ssManifest.streamElements[i];
        this.f11634c = new ChunkExtractor[exoTrackSelection.length()];
        for (int i3 = 0; i3 < this.f11634c.length; i3++) {
            int indexInTrackGroup = exoTrackSelection.getIndexInTrackGroup(i3);
            Format format = streamElement.formats[indexInTrackGroup];
            if (format.drmInitData != null) {
                trackEncryptionBoxArr = ((SsManifest.ProtectionElement) Assertions.checkNotNull(ssManifest.protectionElement)).trackEncryptionBoxes;
            } else {
                trackEncryptionBoxArr = null;
            }
            int i4 = streamElement.type;
            if (i4 == 2) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            this.f11634c[i3] = new BundledChunkExtractor(new FragmentedMp4Extractor(3, null, new Track(indexInTrackGroup, i4, streamElement.timescale, C0643C.TIME_UNSET, ssManifest.durationUs, format, 0, trackEncryptionBoxArr, i2, null, null)), streamElement.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2;
        SsManifest.StreamElement streamElement = this.f11637f.streamElements[this.f11633b];
        int chunkIndex = streamElement.getChunkIndex(j);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        if (startTimeUs < j && chunkIndex < streamElement.chunkCount - 1) {
            j2 = streamElement.getStartTimeUs(chunkIndex + 1);
        } else {
            j2 = startTimeUs;
        }
        return seekParameters.resolveSeekPositionUs(j, startTimeUs, j2);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int nextChunkIndex;
        long chunkDurationUs;
        long j3;
        if (this.f11639h != null) {
            return;
        }
        SsManifest.StreamElement[] streamElementArr = this.f11637f.streamElements;
        int i = this.f11633b;
        SsManifest.StreamElement streamElement = streamElementArr[i];
        if (streamElement.chunkCount == 0) {
            chunkHolder.endOfStream = !r1.isLive;
            return;
        }
        if (list.isEmpty()) {
            nextChunkIndex = streamElement.getChunkIndex(j2);
        } else {
            nextChunkIndex = (int) (list.get(list.size() - 1).getNextChunkIndex() - this.f11638g);
            if (nextChunkIndex < 0) {
                this.f11639h = new BehindLiveWindowException();
                return;
            }
        }
        int i2 = nextChunkIndex;
        if (i2 >= streamElement.chunkCount) {
            chunkHolder.endOfStream = !this.f11637f.isLive;
            return;
        }
        long j4 = j2 - j;
        SsManifest ssManifest = this.f11637f;
        if (!ssManifest.isLive) {
            chunkDurationUs = -9223372036854775807L;
        } else {
            SsManifest.StreamElement streamElement2 = ssManifest.streamElements[i];
            int i3 = streamElement2.chunkCount - 1;
            chunkDurationUs = (streamElement2.getChunkDurationUs(i3) + streamElement2.getStartTimeUs(i3)) - j;
        }
        int length = this.f11636e.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        for (int i4 = 0; i4 < length; i4++) {
            mediaChunkIteratorArr[i4] = new i10(streamElement, this.f11636e.getIndexInTrackGroup(i4), i2);
        }
        this.f11636e.updateSelectedTrack(j, j4, chunkDurationUs, list, mediaChunkIteratorArr);
        long startTimeUs = streamElement.getStartTimeUs(i2);
        long chunkDurationUs2 = streamElement.getChunkDurationUs(i2) + startTimeUs;
        if (list.isEmpty()) {
            j3 = j2;
        } else {
            j3 = -9223372036854775807L;
        }
        int i5 = this.f11638g + i2;
        int selectedIndex = this.f11636e.getSelectedIndex();
        ChunkExtractor chunkExtractor = this.f11634c[selectedIndex];
        Uri buildRequestUri = streamElement.buildRequestUri(this.f11636e.getIndexInTrackGroup(selectedIndex), i2);
        chunkHolder.chunk = new ContainerMediaChunk(this.f11635d, new DataSpec(buildRequestUri), this.f11636e.getSelectedFormat(), this.f11636e.getSelectionReason(), this.f11636e.getSelectionData(), startTimeUs, chunkDurationUs2, j3, C0643C.TIME_UNSET, i5, 1, startTimeUs, chunkExtractor);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.f11639h == null && this.f11636e.length() >= 2) {
            return this.f11636e.evaluateQueueSize(j, list);
        }
        return list.size();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() {
        BehindLiveWindowException behindLiveWindowException = this.f11639h;
        if (behindLiveWindowException == null) {
            this.f11632a.maybeThrowError();
            return;
        }
        throw behindLiveWindowException;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(TrackSelectionUtil.createFallbackOptions(this.f11636e), loadErrorInfo);
        if (z && fallbackSelectionFor != null && fallbackSelectionFor.type == 2) {
            ExoTrackSelection exoTrackSelection = this.f11636e;
            if (exoTrackSelection.blacklist(exoTrackSelection.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void release() {
        for (ChunkExtractor chunkExtractor : this.f11634c) {
            chunkExtractor.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean shouldCancelLoad(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f11639h != null) {
            return false;
        }
        return this.f11636e.shouldCancelChunkLoad(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement[] streamElementArr = this.f11637f.streamElements;
        int i = this.f11633b;
        SsManifest.StreamElement streamElement = streamElementArr[i];
        int i2 = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[i];
        if (i2 != 0 && streamElement2.chunkCount != 0) {
            int i3 = i2 - 1;
            long chunkDurationUs = streamElement.getChunkDurationUs(i3) + streamElement.getStartTimeUs(i3);
            long startTimeUs = streamElement2.getStartTimeUs(0);
            if (chunkDurationUs <= startTimeUs) {
                this.f11638g += i2;
            } else {
                this.f11638g = streamElement.getChunkIndex(startTimeUs) + this.f11638g;
            }
        } else {
            this.f11638g += i2;
        }
        this.f11637f = ssManifest;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.f11636e = exoTrackSelection;
    }
}
