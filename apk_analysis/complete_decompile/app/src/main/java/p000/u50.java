package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.hisona.allive.PlayerActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class u50 implements DrmSessionManagerProvider {

    /* renamed from: a */
    public final /* synthetic */ int f27112a;

    /* renamed from: b */
    public final /* synthetic */ Object f27113b;

    public /* synthetic */ u50(int i, Object obj) {
        this.f27112a = i;
        this.f27113b = obj;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManagerProvider
    public final DrmSessionManager get(MediaItem mediaItem) {
        Object obj = this.f27113b;
        switch (this.f27112a) {
            case 0:
                DefaultTrackSelector.Parameters parameters = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
                return (DrmSessionManager) obj;
            default:
                boolean z = PlayerActivity.f15869d0;
                PlayerActivity playerActivity = (PlayerActivity) obj;
                playerActivity.getClass();
                return new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(C0643C.WIDEVINE_UUID, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(false).build(playerActivity.f15879H);
        }
    }
}
