package p000;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;

/* loaded from: classes.dex */
public final class z50 implements ExoTrackSelection.Factory {
    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
    public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        BaseTrackSelection baseTrackSelection;
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        for (int i = 0; i < definitionArr.length; i++) {
            ExoTrackSelection.Definition definition = definitionArr[i];
            if (definition == null) {
                baseTrackSelection = null;
            } else {
                baseTrackSelection = new BaseTrackSelection(definition.group, definition.tracks);
            }
            exoTrackSelectionArr[i] = baseTrackSelection;
        }
        return exoTrackSelectionArr;
    }
}
