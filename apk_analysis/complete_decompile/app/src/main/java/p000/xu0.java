package p000;

import com.google.android.exoplayer2.drm.DummyExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.util.Log;
import java.util.UUID;

/* loaded from: classes.dex */
public final /* synthetic */ class xu0 implements ExoMediaDrm.Provider {
    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
    public final ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
        try {
            return FrameworkMediaDrm.newInstance(uuid);
        } catch (UnsupportedDrmException unused) {
            Log.m3023e("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new DummyExoMediaDrm();
        }
    }
}
