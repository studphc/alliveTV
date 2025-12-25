package p000;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

/* renamed from: d9 */
/* loaded from: classes.dex */
public final class C1114d9 extends AbstractC1187f9 {

    /* renamed from: c */
    public final /* synthetic */ int f16293c = 0;

    /* renamed from: d */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f16294d;

    /* renamed from: e */
    public final Object f16295e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1114d9(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e, jz2 jz2Var) {
        super(layoutInflaterFactory2C0084e);
        this.f16294d = layoutInflaterFactory2C0084e;
        this.f16295e = jz2Var;
    }

    @Override // p000.AbstractC1187f9
    /* renamed from: b */
    public final IntentFilter mo4553b() {
        switch (this.f16293c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [hx2, java.lang.Object] */
    @Override // p000.AbstractC1187f9
    /* renamed from: c */
    public final int mo4554c() {
        Location location;
        boolean z;
        long j;
        Location location2;
        switch (this.f16293c) {
            case 0:
                if (AbstractC2011y8.m8255a((PowerManager) this.f16295e)) {
                    return 2;
                }
                return 1;
            default:
                jz2 jz2Var = (jz2) this.f16295e;
                ix2 ix2Var = (ix2) jz2Var.f20700d;
                if (ix2Var.f20305b > System.currentTimeMillis()) {
                    z = ix2Var.f20304a;
                } else {
                    Context context = (Context) jz2Var.f20698b;
                    int checkSelfPermission = PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location location3 = null;
                    LocationManager locationManager = (LocationManager) jz2Var.f20699c;
                    if (checkSelfPermission == 0) {
                        try {
                        } catch (Exception e) {
                            Log.d("TwilightManager", "Failed to get last known location", e);
                        }
                        if (locationManager.isProviderEnabled("network")) {
                            location2 = locationManager.getLastKnownLocation("network");
                            location = location2;
                        }
                        location2 = null;
                        location = location2;
                    } else {
                        location = null;
                    }
                    if (PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                location3 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e2) {
                            Log.d("TwilightManager", "Failed to get last known location", e2);
                        }
                    }
                    if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                        location = location3;
                    }
                    z = false;
                    if (location != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (hx2.f18211d == null) {
                            hx2.f18211d = new Object();
                        }
                        hx2 hx2Var = hx2.f18211d;
                        hx2Var.m5138a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        hx2Var.m5138a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                        if (hx2Var.f18214c == 1) {
                            z = true;
                        }
                        long j2 = hx2Var.f18213b;
                        long j3 = hx2Var.f18212a;
                        hx2Var.m5138a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                        long j4 = hx2Var.f18213b;
                        if (j2 != -1 && j3 != -1) {
                            if (currentTimeMillis <= j3) {
                                if (currentTimeMillis > j2) {
                                    j4 = j3;
                                } else {
                                    j4 = j2;
                                }
                            }
                            j = j4 + 60000;
                        } else {
                            j = currentTimeMillis + 43200000;
                        }
                        ix2Var.f20304a = z;
                        ix2Var.f20305b = j;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        if (i < 6 || i >= 22) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    return 1;
                }
                return 2;
        }
    }

    @Override // p000.AbstractC1187f9
    /* renamed from: d */
    public final void mo4555d() {
        switch (this.f16293c) {
            case 0:
                this.f16294d.m179f(true, true);
                return;
            default:
                this.f16294d.m179f(true, true);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1114d9(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e, Context context) {
        super(layoutInflaterFactory2C0084e);
        this.f16294d = layoutInflaterFactory2C0084e;
        this.f16295e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
