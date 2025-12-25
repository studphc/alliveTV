package p000;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ca3 extends Thread {

    /* renamed from: a */
    public final WeakReference f8308a;

    /* renamed from: b */
    public final long f8309b;

    /* renamed from: c */
    public final CountDownLatch f8310c = new CountDownLatch(1);

    /* renamed from: d */
    public boolean f8311d = false;

    public ca3(AdvertisingIdClient advertisingIdClient, long j) {
        this.f8308a = new WeakReference(advertisingIdClient);
        this.f8309b = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AdvertisingIdClient advertisingIdClient;
        WeakReference weakReference = this.f8308a;
        try {
            if (!this.f8310c.await(this.f8309b, TimeUnit.MILLISECONDS) && (advertisingIdClient = (AdvertisingIdClient) weakReference.get()) != null) {
                advertisingIdClient.zza();
                this.f8311d = true;
            }
        } catch (InterruptedException unused) {
            AdvertisingIdClient advertisingIdClient2 = (AdvertisingIdClient) weakReference.get();
            if (advertisingIdClient2 != null) {
                advertisingIdClient2.zza();
                this.f8311d = true;
            }
        }
    }
}
