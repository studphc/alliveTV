package p000;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.TransferListener;

/* loaded from: classes.dex */
public final class b60 implements BandwidthMeter {
    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public final long getBitrateEstimate() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public final /* synthetic */ long getTimeToFirstByteEstimateUs() {
        return AbstractC1721qe.m7032a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public final TransferListener getTransferListener() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public final void removeEventListener(BandwidthMeter.EventListener eventListener) {
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public final void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
    }
}
