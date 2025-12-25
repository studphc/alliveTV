package p000;

import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import java.io.IOException;

/* renamed from: fy */
/* loaded from: classes.dex */
public final class C1212fy implements SntpClient.InitializationCallback {

    /* renamed from: a */
    public final /* synthetic */ DashMediaSource f17445a;

    public C1212fy(DashMediaSource dashMediaSource) {
        this.f17445a = dashMediaSource;
    }

    @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
    public final void onInitializationFailed(IOException iOException) {
        String str = DashMediaSource.DEFAULT_MEDIA_ID;
        DashMediaSource dashMediaSource = this.f17445a;
        dashMediaSource.getClass();
        Log.m3024e(DashMediaSource.DEFAULT_MEDIA_ID, "Failed to resolve time offset.", iOException);
        dashMediaSource.m2776c(true);
    }

    @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
    public final void onInitialized() {
        long elapsedRealtimeOffsetMs = SntpClient.getElapsedRealtimeOffsetMs();
        String str = DashMediaSource.DEFAULT_MEDIA_ID;
        DashMediaSource dashMediaSource = this.f17445a;
        dashMediaSource.f11223L = elapsedRealtimeOffsetMs;
        dashMediaSource.m2776c(true);
    }
}
