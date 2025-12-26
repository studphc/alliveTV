package p000;

import android.location.GnssMeasurementsEvent;
import android.location.GnssMeasurementsEvent$Callback;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class hd1 extends GnssMeasurementsEvent$Callback {

    /* renamed from: a */
    public final GnssMeasurementsEvent$Callback f18029a;

    /* renamed from: b */
    public volatile Executor f18030b;

    public hd1(GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, Executor executor) {
        this.f18029a = gnssMeasurementsEvent$Callback;
        this.f18030b = executor;
    }

    public final void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        Executor executor = this.f18030b;
        if (executor == null) {
            return;
        }
        executor.execute(new RunnableC0547b7(this, executor, gnssMeasurementsEvent, 7));
    }

    public final void onStatusChanged(int i) {
        Executor executor = this.f18030b;
        if (executor == null) {
            return;
        }
        executor.execute(new RunnableC1185f7(this, executor, i, 4));
    }
}
