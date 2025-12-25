package p000;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;

/* loaded from: classes.dex */
public final class n01 extends BaseTrackSelection {

    /* renamed from: e */
    public int f23186e;

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndex() {
        return this.f23186e;
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
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!isBlacklisted(this.f23186e, elapsedRealtime)) {
            return;
        }
        for (int i = this.length - 1; i >= 0; i--) {
            if (!isBlacklisted(i, elapsedRealtime)) {
                this.f23186e = i;
                return;
            }
        }
        throw new IllegalStateException();
    }
}
