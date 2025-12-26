package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;
import p000.C0556bg;
import p000.tb0;

/* loaded from: classes.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* renamed from: a */
    public final int f11884a;

    /* renamed from: b */
    public final Format[] f11885b;

    /* renamed from: c */
    public final long[] f11886c;

    /* renamed from: d */
    public int f11887d;
    protected final TrackGroup group;
    protected final int length;
    protected final int[] tracks;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public boolean blacklist(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i, elapsedRealtime);
        for (int i2 = 0; i2 < this.length && !isBlacklisted; i2++) {
            if (i2 != i && !isBlacklisted(i2, elapsedRealtime)) {
                isBlacklisted = true;
            } else {
                isBlacklisted = false;
            }
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.f11886c;
        jArr[i] = Math.max(jArr[i], Util.addWithOverflowDefault(elapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void enable() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        if (this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int i) {
        return this.f11885b[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.tracks[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final Format getSelectedFormat() {
        return this.f11885b[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getType() {
        return this.f11884a;
    }

    public int hashCode() {
        if (this.f11887d == 0) {
            this.f11887d = Arrays.hashCode(this.tracks) + (System.identityHashCode(this.group) * 31);
        }
        return this.f11887d;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.f11885b[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public boolean isBlacklisted(int i, long j) {
        if (this.f11886c[i] > j) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final /* synthetic */ void onDiscontinuity() {
        tb0.m7472a(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final /* synthetic */ void onPlayWhenReadyChanged(boolean z) {
        tb0.m7473b(this, z);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final /* synthetic */ void onRebuffer() {
        tb0.m7474c(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final /* synthetic */ boolean shouldCancelChunkLoad(long j, Chunk chunk, List list) {
        return tb0.m7475d(this, j, chunk, list);
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i) {
        int i2 = 0;
        Assertions.checkState(iArr.length > 0);
        this.f11884a = i;
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length = iArr.length;
        this.length = length;
        this.f11885b = new Format[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f11885b[i3] = trackGroup.getFormat(iArr[i3]);
        }
        Arrays.sort(this.f11885b, new C0556bg(0));
        this.tracks = new int[this.length];
        while (true) {
            int i4 = this.length;
            if (i2 < i4) {
                this.tracks[i2] = trackGroup.indexOf(this.f11885b[i2]);
                i2++;
            } else {
                this.f11886c = new long[i4];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.tracks[i2] == i) {
                return i2;
            }
        }
        return -1;
    }
}
