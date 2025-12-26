package p000;

import android.util.Log;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
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
                
                // Create custom ExoMediaDrm provider with logging
                ExoMediaDrm.Provider loggingProvider = uuid -> {
                    try {
                        FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.newInstance(uuid);
                        
                        // Add expiration update listener for DRM logging
                        frameworkMediaDrm.setOnExpirationUpdateListener((exoMediaDrm, sessionId, expirationTimeMs) -> {
                            try {
                                String securityLevel = exoMediaDrm.getPropertyString("securityLevel");
                                String version = exoMediaDrm.getPropertyString("version");
                                String vendor = exoMediaDrm.getPropertyString("vendor");
                                Log.d("AlliveTV-DRM", "[DRM Expiration] securityLevel: " + securityLevel + 
                                      " (L1=FHD, L3=HD), version: " + version + 
                                      ", vendor: " + vendor + 
                                      ", expirationMs: " + expirationTimeMs);
                            } catch (Exception e) {
                                Log.e("AlliveTV-DRM", "[DRM] Error getting properties", e);
                            }
                        });
                        
                        // Add key status change listener for DRM debugging
                        frameworkMediaDrm.setOnKeyStatusChangeListener((exoMediaDrm, sessionId, keyStatuses, hasNewUsableKey) -> {
                            try {
                                String securityLevel = exoMediaDrm.getPropertyString("securityLevel");
                                Log.d("AlliveTV-DRM", "[DRM KeyStatus] securityLevel: " + securityLevel + 
                                      ", hasNewUsableKey: " + hasNewUsableKey +
                                      ", keyCount: " + keyStatuses.size());
                                
                                // Log each key status
                                for (ExoMediaDrm.KeyStatus keyStatus : keyStatuses) {
                                    Log.d("AlliveTV-DRM", "  Key status code: " + keyStatus.getStatusCode());
                                }
                            } catch (Exception e) {
                                Log.e("AlliveTV-DRM", "[DRM] Error in key status change", e);
                            }
                        });
                        
                        return frameworkMediaDrm;
                    } catch (Exception e) {
                        Log.e("AlliveTV-DRM", "[DRM] Error creating FrameworkMediaDrm", e);
                        return FrameworkMediaDrm.DEFAULT_PROVIDER.acquireExoMediaDrm(uuid);
                    }
                };
                
                return new DefaultDrmSessionManager.Builder()
                    .setUuidAndExoMediaDrmProvider(C0643C.WIDEVINE_UUID, loggingProvider)
                    .setMultiSession(false)
                    .build(playerActivity.f15879H);
        }
    }
}
