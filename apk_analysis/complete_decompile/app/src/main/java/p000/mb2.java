package p000;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class mb2 {

    /* renamed from: d */
    public static final long f22883d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e */
    public static final long f22884e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a */
    public final Utils f22885a = Utils.getInstance();

    /* renamed from: b */
    public long f22886b;

    /* renamed from: c */
    public int f22887c;

    /* renamed from: a */
    public final synchronized long m6124a(int i) {
        boolean z;
        if (i != 429 && (i < 500 || i >= 600)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return f22883d;
        }
        return (long) Math.min(Math.pow(2.0d, this.f22887c) + this.f22885a.getRandomDelayForSyncPrevention(), f22884e);
    }

    /* renamed from: b */
    public final synchronized boolean m6125b() {
        boolean z;
        if (this.f22887c != 0) {
            if (this.f22885a.currentTimeInMillis() <= this.f22886b) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    /* renamed from: c */
    public final synchronized void m6126c() {
        this.f22887c = 0;
    }

    /* renamed from: d */
    public final synchronized void m6127d(int i) {
        if ((i < 200 || i >= 300) && i != 401 && i != 404) {
            this.f22887c++;
            this.f22886b = this.f22885a.currentTimeInMillis() + m6124a(i);
            return;
        }
        m6126c();
    }
}
