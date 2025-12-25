package androidx.core.service.quicksettings;

import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import p000.rt2;
import p000.st2;
import p000.tt2;

/* loaded from: classes.dex */
public class TileServiceCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void clearTileServiceWrapper() {
    }

    public static void startActivityAndCollapse(@NonNull TileService tileService, @NonNull PendingIntentActivityWrapper pendingIntentActivityWrapper) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            st2.m7414a(tileService, pendingIntentActivityWrapper.getPendingIntent());
        } else if (i >= 24) {
            rt2.m7302a(tileService, pendingIntentActivityWrapper.getIntent());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setTileServiceWrapper(@NonNull tt2 tt2Var) {
    }
}
