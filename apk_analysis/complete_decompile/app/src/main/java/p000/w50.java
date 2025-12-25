package p000;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

/* loaded from: classes.dex */
public final /* synthetic */ class w50 implements MetadataOutput {
    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata) {
        DefaultTrackSelector.Parameters parameters = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    }
}
