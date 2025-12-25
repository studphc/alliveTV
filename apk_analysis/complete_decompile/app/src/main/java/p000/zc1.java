package p000;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class zc1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f29308a;

    /* renamed from: b */
    public final /* synthetic */ Consumer f29309b;

    /* renamed from: c */
    public final /* synthetic */ Location f29310c;

    public /* synthetic */ zc1(Consumer consumer, Location location, int i) {
        this.f29308a = i;
        this.f29309b = consumer;
        this.f29310c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Location location = this.f29310c;
        Consumer consumer = this.f29309b;
        switch (this.f29308a) {
            case 0:
                Class cls = LocationManagerCompat.f3677a;
                consumer.accept(location);
                return;
            default:
                consumer.accept(location);
                return;
        }
    }
}
