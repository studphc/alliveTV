package p000;

import com.google.android.exoplayer2.C0672f;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final /* synthetic */ class a10 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f14a;

    /* renamed from: b */
    public final /* synthetic */ Object f15b;

    public /* synthetic */ a10(int i, Object obj) {
        this.f14a = i;
        this.f15b = obj;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f14a) {
            case 0:
                try {
                    return (MediaSource.Factory) ((Class) this.f15b).getConstructor(null).newInstance(null);
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            case 1:
                return (LoadControl) this.f15b;
            case 2:
                return (RenderersFactory) this.f15b;
            case 3:
                return (MediaSource.Factory) this.f15b;
            case 4:
                return (BandwidthMeter) this.f15b;
            case 5:
                return (TrackSelector) this.f15b;
            case 6:
                return Boolean.valueOf(((AtomicBoolean) this.f15b).get());
            default:
                return Boolean.valueOf(((C0672f) this.f15b).f10631z);
        }
    }
}
