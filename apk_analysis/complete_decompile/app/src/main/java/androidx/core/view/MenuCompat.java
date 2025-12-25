package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import p000.ym1;

/* loaded from: classes.dex */
public final class MenuCompat {
    public static void setGroupDividerEnabled(@NonNull Menu menu, boolean z) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(z);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ym1.m8311a(menu, z);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }
}
