package p000;

import android.os.HandlerThread;
import com.google.android.exoplayer2.mediacodec.C0676a;
import com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

/* renamed from: ec */
/* loaded from: classes.dex */
public final /* synthetic */ class C1153ec implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f16756a;

    /* renamed from: b */
    public final /* synthetic */ int f16757b;

    public /* synthetic */ C1153ec(int i, int i2) {
        this.f16756a = i2;
        this.f16757b = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f16756a) {
            case 0:
                return new HandlerThread(C0676a.m2668b(this.f16757b, "ExoPlayer:MediaCodecAsyncAdapter:"));
            case 1:
                return new HandlerThread(C0676a.m2668b(this.f16757b, "ExoPlayer:MediaCodecQueueingThread:"));
            case 2:
                return new Semaphore(this.f16757b, false);
            default:
                return new Semaphore(this.f16757b, false);
        }
    }
}
