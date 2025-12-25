package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a */
/* loaded from: classes.dex */
public final class C0711a implements MediaPeriod, SequenceableLoader.Callback {

    /* renamed from: a */
    public final SsChunkSource.Factory f11668a;

    /* renamed from: b */
    public final TransferListener f11669b;

    /* renamed from: c */
    public final LoaderErrorThrower f11670c;

    /* renamed from: d */
    public final DrmSessionManager f11671d;

    /* renamed from: e */
    public final DrmSessionEventListener.EventDispatcher f11672e;

    /* renamed from: f */
    public final LoadErrorHandlingPolicy f11673f;

    /* renamed from: g */
    public final MediaSourceEventListener.EventDispatcher f11674g;

    /* renamed from: h */
    public final Allocator f11675h;

    /* renamed from: i */
    public final TrackGroupArray f11676i;

    /* renamed from: j */
    public final CompositeSequenceableLoaderFactory f11677j;

    /* renamed from: k */
    public MediaPeriod.Callback f11678k;

    /* renamed from: l */
    public SsManifest f11679l;

    /* renamed from: m */
    public ChunkSampleStream[] f11680m;

    /* renamed from: n */
    public SequenceableLoader f11681n;

    public C0711a(SsManifest ssManifest, SsChunkSource.Factory factory, TransferListener transferListener, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f11679l = ssManifest;
        this.f11668a = factory;
        this.f11669b = transferListener;
        this.f11670c = loaderErrorThrower;
        this.f11671d = drmSessionManager;
        this.f11672e = eventDispatcher;
        this.f11673f = loadErrorHandlingPolicy;
        this.f11674g = eventDispatcher2;
        this.f11675h = allocator;
        this.f11677j = compositeSequenceableLoaderFactory;
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.streamElements.length];
        int i = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.streamElements;
            if (i < streamElementArr.length) {
                Format[] formatArr = streamElementArr[i].formats;
                Format[] formatArr2 = new Format[formatArr.length];
                for (int i2 = 0; i2 < formatArr.length; i2++) {
                    Format format = formatArr[i2];
                    formatArr2[i2] = format.copyWithCryptoType(drmSessionManager.getCryptoType(format));
                }
                trackGroupArr[i] = new TrackGroup(Integer.toString(i), formatArr2);
                i++;
            } else {
                this.f11676i = new TrackGroupArray(trackGroupArr);
                ChunkSampleStream[] chunkSampleStreamArr = new ChunkSampleStream[0];
                this.f11680m = chunkSampleStreamArr;
                this.f11681n = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(chunkSampleStreamArr);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        return this.f11681n.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
        for (ChunkSampleStream chunkSampleStream : this.f11680m) {
            chunkSampleStream.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (ChunkSampleStream chunkSampleStream : this.f11680m) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return this.f11681n.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return this.f11681n.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final List getStreamKeys(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ExoTrackSelection exoTrackSelection = (ExoTrackSelection) list.get(i);
            int indexOf = this.f11676i.indexOf(exoTrackSelection.getTrackGroup());
            for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
                arrayList.add(new StreamKey(indexOf, exoTrackSelection.getIndexInTrackGroup(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.f11676i;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return this.f11681n.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
        this.f11670c.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(SequenceableLoader sequenceableLoader) {
        this.f11678k.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.f11678k = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        this.f11681n.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        for (ChunkSampleStream chunkSampleStream : this.f11680m) {
            chunkSampleStream.seekToUs(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int i;
        ExoTrackSelection exoTrackSelection;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < exoTrackSelectionArr.length) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if (sampleStream != null) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStream;
                if (exoTrackSelectionArr[i2] != null && zArr[i2]) {
                    ((SsChunkSource) chunkSampleStream.getChunkSource()).updateTrackSelection(exoTrackSelectionArr[i2]);
                    arrayList.add(chunkSampleStream);
                } else {
                    chunkSampleStream.release();
                    sampleStreamArr[i2] = null;
                }
            }
            if (sampleStreamArr[i2] == null && (exoTrackSelection = exoTrackSelectionArr[i2]) != null) {
                int indexOf = this.f11676i.indexOf(exoTrackSelection.getTrackGroup());
                i = i2;
                ChunkSampleStream chunkSampleStream2 = new ChunkSampleStream(this.f11679l.streamElements[indexOf].type, null, null, this.f11668a.createChunkSource(this.f11670c, this.f11679l, indexOf, exoTrackSelection, this.f11669b), this, this.f11675h, j, this.f11671d, this.f11672e, this.f11673f, this.f11674g);
                arrayList.add(chunkSampleStream2);
                sampleStreamArr[i] = chunkSampleStream2;
                zArr2[i] = true;
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        ChunkSampleStream[] chunkSampleStreamArr = new ChunkSampleStream[arrayList.size()];
        this.f11680m = chunkSampleStreamArr;
        arrayList.toArray(chunkSampleStreamArr);
        this.f11681n = this.f11677j.createCompositeSequenceableLoader(this.f11680m);
        return j;
    }
}
