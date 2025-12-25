package androidx.core.location;

import android.location.GnssStatus;
import android.location.GnssStatus$Callback;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import p000.RunnableC0547b7;
import p000.RunnableC1185f7;
import p000.nd1;

/* renamed from: androidx.core.location.e */
/* loaded from: classes.dex */
public final class C0185e extends GnssStatus$Callback {

    /* renamed from: a */
    public final GnssStatusCompat.Callback f3701a;

    /* renamed from: b */
    public volatile Executor f3702b;

    public C0185e(GnssStatusCompat.Callback callback) {
        boolean z;
        if (callback != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid null callback");
        this.f3701a = callback;
    }

    public final void onFirstFix(int i) {
        Executor executor = this.f3702b;
        if (executor == null) {
            return;
        }
        executor.execute(new RunnableC1185f7(this, executor, i, 6));
    }

    public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        Executor executor = this.f3702b;
        if (executor == null) {
            return;
        }
        executor.execute(new RunnableC0547b7(this, executor, gnssStatus, 9));
    }

    public final void onStarted() {
        Executor executor = this.f3702b;
        if (executor == null) {
            return;
        }
        executor.execute(new nd1(this, executor, 1));
    }

    public final void onStopped() {
        Executor executor = this.f3702b;
        if (executor == null) {
            return;
        }
        executor.execute(new nd1(this, executor, 0));
    }
}
