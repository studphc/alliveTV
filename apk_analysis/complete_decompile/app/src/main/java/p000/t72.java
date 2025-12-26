package p000;

import com.google.android.exoplayer2.source.C0707m;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final /* synthetic */ class t72 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f26712a;

    /* renamed from: b */
    public final /* synthetic */ C0707m f26713b;

    public /* synthetic */ t72(C0707m c0707m, int i) {
        this.f26712a = i;
        this.f26713b = c0707m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f26712a) {
            case 0:
                this.f26713b.m2819e();
                return;
            case 1:
                C0707m c0707m = this.f26713b;
                if (!c0707m.f11559L) {
                    ((MediaPeriod.Callback) Assertions.checkNotNull(c0707m.f11576q)).onContinueLoadingRequested(c0707m);
                    return;
                }
                return;
            default:
                this.f26713b.f11553F = true;
                return;
        }
    }
}
