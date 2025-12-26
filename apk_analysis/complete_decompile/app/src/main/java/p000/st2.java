package p000;

import android.app.PendingIntent;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class st2 {
    @DoNotInline
    /* renamed from: a */
    public static void m7414a(TileService tileService, PendingIntent pendingIntent) {
        tileService.startActivityAndCollapse(pendingIntent);
    }
}
