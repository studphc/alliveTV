package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

/* loaded from: classes.dex */
public final class FixedTrackSelection extends BaseTrackSelection {

    /* renamed from: e */
    public final int f11914e;

    /* renamed from: f */
    public final Object f11915f;

    public FixedTrackSelection(TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return this.f11915f;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return this.f11914e;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2) {
        this(trackGroup, i, i2, 0, null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2, int i3, @Nullable Object obj) {
        super(trackGroup, new int[]{i}, i2);
        this.f11914e = i3;
        this.f11915f = obj;
    }
}
