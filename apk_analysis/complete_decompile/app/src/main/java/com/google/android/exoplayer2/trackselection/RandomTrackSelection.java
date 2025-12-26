package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;
import java.util.Random;
import p000.C1294i5;

/* loaded from: classes.dex */
public final class RandomTrackSelection extends BaseTrackSelection {

    /* renamed from: e */
    public final Random f11924e;

    /* renamed from: f */
    public int f11925f;

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, int i, Random random) {
        super(trackGroup, iArr, i);
        this.f11924e = random;
        this.f11925f = random.nextInt(this.length);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.f11925f;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return 3;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (!isBlacklisted(i2, elapsedRealtime)) {
                i++;
            }
        }
        this.f11925f = this.f11924e.nextInt(i);
        if (i != this.length) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.length; i4++) {
                if (!isBlacklisted(i4, elapsedRealtime)) {
                    int i5 = i3 + 1;
                    if (this.f11925f == i3) {
                        this.f11925f = i4;
                        return;
                    }
                    i3 = i5;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Factory implements ExoTrackSelection.Factory {

        /* renamed from: a */
        public final Random f11926a;

        public Factory() {
            this.f11926a = new Random();
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
        public ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            return TrackSelectionUtil.createTrackSelectionsForDefinitions(definitionArr, new C1294i5(18, this));
        }

        public Factory(int i) {
            this.f11926a = new Random(i);
        }
    }
}
