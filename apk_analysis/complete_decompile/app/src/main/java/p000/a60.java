package p000;

import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;

/* loaded from: classes.dex */
public final class a60 extends BaseTrackSelection {
    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectionReason() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final void updateSelectedTrack(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }
}
