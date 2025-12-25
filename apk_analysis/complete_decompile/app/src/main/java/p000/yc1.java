package p000;

import android.location.Location;
import android.os.Bundle;
import androidx.core.location.LocationListenerCompat;
import java.util.List;

/* loaded from: classes.dex */
public abstract /* synthetic */ class yc1 {
    /* renamed from: b */
    public static void m8262b(LocationListenerCompat locationListenerCompat, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i));
        }
    }

    /* renamed from: a */
    public static void m8261a(LocationListenerCompat locationListenerCompat, int i) {
    }

    /* renamed from: c */
    public static void m8263c(LocationListenerCompat locationListenerCompat, String str) {
    }

    /* renamed from: d */
    public static void m8264d(LocationListenerCompat locationListenerCompat, String str) {
    }

    /* renamed from: e */
    public static void m8265e(LocationListenerCompat locationListenerCompat, String str, int i, Bundle bundle) {
    }
}
