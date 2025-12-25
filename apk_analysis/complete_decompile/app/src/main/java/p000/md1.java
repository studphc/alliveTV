package p000;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class md1 implements LocationListener {

    /* renamed from: a */
    public volatile jd1 f22897a;

    /* renamed from: b */
    public final Executor f22898b;

    public md1(jd1 jd1Var, Executor executor) {
        this.f22897a = jd1Var;
        this.f22898b = executor;
    }

    @Override // android.location.LocationListener
    public final void onFlushComplete(int i) {
        if (this.f22897a == null) {
            return;
        }
        this.f22898b.execute(new RunnableC2015yc(i, 1, this));
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        if (this.f22897a == null) {
            return;
        }
        this.f22898b.execute(new RunnableC0583c7(25, this, location));
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        if (this.f22897a == null) {
            return;
        }
        this.f22898b.execute(new kd1(this, str, 1));
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        if (this.f22897a == null) {
            return;
        }
        this.f22898b.execute(new kd1(this, str, 0));
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(final String str, final int i, final Bundle bundle) {
        if (this.f22897a == null) {
            return;
        }
        this.f22898b.execute(new Runnable() { // from class: ld1
            @Override // java.lang.Runnable
            public final void run() {
                md1 md1Var = md1.this;
                String str2 = str;
                int i2 = i;
                Bundle bundle2 = bundle;
                jd1 jd1Var = md1Var.f22897a;
                if (jd1Var != null) {
                    jd1Var.f20469b.onStatusChanged(str2, i2, bundle2);
                }
            }
        });
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(List list) {
        if (this.f22897a == null) {
            return;
        }
        this.f22898b.execute(new RunnableC0583c7(24, this, list));
    }
}
