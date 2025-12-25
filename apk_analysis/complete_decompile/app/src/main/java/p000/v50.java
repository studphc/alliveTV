package p000;

import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class v50 implements TextOutput {
    @Override // com.google.android.exoplayer2.text.TextOutput
    public final void onCues(CueGroup cueGroup) {
        DefaultTrackSelector.Parameters parameters = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public final /* synthetic */ void onCues(List list) {
        ws2.m8081a(this, list);
    }
}
