package androidx.core.location;

import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.location.C0184d;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import p000.RunnableC0547b7;
import p000.RunnableC1185f7;

/* renamed from: androidx.core.location.d */
/* loaded from: classes.dex */
public final class C0184d implements GpsStatus.Listener {

    /* renamed from: a */
    public final LocationManager f3698a;

    /* renamed from: b */
    public final GnssStatusCompat.Callback f3699b;

    /* renamed from: c */
    public volatile Executor f3700c;

    public C0184d(LocationManager locationManager, GnssStatusCompat.Callback callback) {
        boolean z;
        if (callback != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid null callback");
        this.f3698a = locationManager;
        this.f3699b = callback;
    }

    @Override // android.location.GpsStatus.Listener
    public final void onGpsStatusChanged(int i) {
        GpsStatus gpsStatus;
        final Executor executor = this.f3700c;
        if (executor == null) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 && (gpsStatus = this.f3698a.getGpsStatus(null)) != null) {
                        executor.execute(new RunnableC0547b7(this, executor, GnssStatusCompat.wrap(gpsStatus), 8));
                        return;
                    }
                    return;
                }
                GpsStatus gpsStatus2 = this.f3698a.getGpsStatus(null);
                if (gpsStatus2 != null) {
                    executor.execute(new RunnableC1185f7(this, executor, gpsStatus2.getTimeToFirstFix(), 5));
                    return;
                }
                return;
            }
            final int i2 = 1;
            executor.execute(new Runnable(this) { // from class: id1

                /* renamed from: b */
                public final /* synthetic */ C0184d f18374b;

                {
                    this.f18374b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            C0184d c0184d = this.f18374b;
                            if (c0184d.f3700c == executor) {
                                c0184d.f3699b.onStarted();
                                return;
                            }
                            return;
                        default:
                            C0184d c0184d2 = this.f18374b;
                            if (c0184d2.f3700c == executor) {
                                c0184d2.f3699b.onStopped();
                                return;
                            }
                            return;
                    }
                }
            });
            return;
        }
        final int i3 = 0;
        executor.execute(new Runnable(this) { // from class: id1

            /* renamed from: b */
            public final /* synthetic */ C0184d f18374b;

            {
                this.f18374b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        C0184d c0184d = this.f18374b;
                        if (c0184d.f3700c == executor) {
                            c0184d.f3699b.onStarted();
                            return;
                        }
                        return;
                    default:
                        C0184d c0184d2 = this.f18374b;
                        if (c0184d2.f3700c == executor) {
                            c0184d2.f3699b.onStopped();
                            return;
                        }
                        return;
                }
            }
        });
    }
}
