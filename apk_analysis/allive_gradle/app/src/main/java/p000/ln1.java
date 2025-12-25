package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.util.List;

/* loaded from: classes.dex */
public final class ln1 implements ExoTrackSelection {

    /* renamed from: a */
    public final ExoTrackSelection f22586a;

    /* renamed from: b */
    public final TrackGroup f22587b;

    public ln1(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
        this.f22586a = exoTrackSelection;
        this.f22587b = trackGroup;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final boolean blacklist(int i, long j) {
        return this.f22586a.blacklist(i, j);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void disable() {
        this.f22586a.disable();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void enable() {
        this.f22586a.enable();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ln1)) {
            return false;
        }
        ln1 ln1Var = (ln1) obj;
        if (this.f22586a.equals(ln1Var.f22586a) && this.f22587b.equals(ln1Var.f22587b)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int evaluateQueueSize(long j, List list) {
        return this.f22586a.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int i) {
        return this.f22586a.getFormat(i);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.f22586a.getIndexInTrackGroup(i);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final Format getSelectedFormat() {
        return this.f22586a.getSelectedFormat();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndex() {
        return this.f22586a.getSelectedIndex();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.f22586a.getSelectedIndexInTrackGroup();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final Object getSelectionData() {
        return this.f22586a.getSelectionData();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectionReason() {
        return this.f22586a.getSelectionReason();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.f22587b;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getType() {
        return this.f22586a.getType();
    }

    public final int hashCode() {
        return this.f22586a.hashCode() + ((this.f22587b.hashCode() + 527) * 31);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        return this.f22586a.indexOf(format);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final boolean isBlacklisted(int i, long j) {
        return this.f22586a.isBlacklisted(i, j);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.f22586a.length();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void onDiscontinuity() {
        this.f22586a.onDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void onPlayWhenReadyChanged(boolean z) {
        this.f22586a.onPlayWhenReadyChanged(z);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void onPlaybackSpeed(float f) {
        this.f22586a.onPlaybackSpeed(f);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void onRebuffer() {
        this.f22586a.onRebuffer();
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final boolean shouldCancelChunkLoad(long j, Chunk chunk, List list) {
        return this.f22586a.shouldCancelChunkLoad(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void updateSelectedTrack(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
        this.f22586a.updateSelectedTrack(j, j2, j3, list, mediaChunkIteratorArr);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i) {
        return this.f22586a.indexOf(i);
    }
}
