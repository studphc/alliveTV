package p000;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class p43 {

    /* renamed from: a */
    public final /* synthetic */ int f25030a;

    /* renamed from: b */
    public boolean f25031b;

    /* renamed from: c */
    public boolean f25032c;

    /* renamed from: d */
    public final Object f25033d;

    /* renamed from: e */
    public Object f25034e;

    public p43(Context context, int i) {
        this.f25030a = i;
        switch (i) {
            case 1:
                this.f25033d = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                return;
            default:
                this.f25033d = (PowerManager) context.getApplicationContext().getSystemService("power");
                return;
        }
    }

    /* renamed from: a */
    public final void m6835a(boolean z) {
        switch (this.f25030a) {
            case 0:
                if (z && ((PowerManager.WakeLock) this.f25034e) == null) {
                    PowerManager powerManager = (PowerManager) this.f25033d;
                    if (powerManager == null) {
                        Log.m3027w("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                        return;
                    } else {
                        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                        this.f25034e = newWakeLock;
                        newWakeLock.setReferenceCounted(false);
                    }
                }
                this.f25031b = z;
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f25034e;
                if (wakeLock != null) {
                    if (z && this.f25032c) {
                        wakeLock.acquire();
                        return;
                    } else {
                        wakeLock.release();
                        return;
                    }
                }
                return;
            default:
                if (z && ((WifiManager.WifiLock) this.f25034e) == null) {
                    WifiManager wifiManager = (WifiManager) this.f25033d;
                    if (wifiManager == null) {
                        Log.m3027w("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                        return;
                    } else {
                        WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                        this.f25034e = createWifiLock;
                        createWifiLock.setReferenceCounted(false);
                    }
                }
                this.f25031b = z;
                WifiManager.WifiLock wifiLock = (WifiManager.WifiLock) this.f25034e;
                if (wifiLock != null) {
                    if (z && this.f25032c) {
                        wifiLock.acquire();
                        return;
                    } else {
                        wifiLock.release();
                        return;
                    }
                }
                return;
        }
    }
}
