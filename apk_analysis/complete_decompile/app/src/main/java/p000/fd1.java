package p000;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class fd1 implements LocationListener {

    /* renamed from: a */
    public final LocationManager f17213a;

    /* renamed from: b */
    public final Executor f17214b;

    /* renamed from: c */
    public final Handler f17215c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    public Consumer f17216d;

    /* renamed from: e */
    public boolean f17217e;

    /* renamed from: f */
    public RunnableC0006a5 f17218f;

    public fd1(LocationManager locationManager, Executor executor, Consumer consumer) {
        this.f17213a = locationManager;
        this.f17214b = executor;
        this.f17216d = consumer;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        synchronized (this) {
            try {
                if (this.f17217e) {
                    return;
                }
                this.f17217e = true;
                this.f17214b.execute(new zc1(this.f17216d, location, 1));
                this.f17216d = null;
                this.f17213a.removeUpdates(this);
                RunnableC0006a5 runnableC0006a5 = this.f17218f;
                if (runnableC0006a5 != null) {
                    this.f17215c.removeCallbacks(runnableC0006a5);
                    this.f17218f = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        onLocationChanged((Location) null);
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
