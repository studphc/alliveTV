package p000;

import android.content.Intent;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class rt2 {
    @DoNotInline
    /* renamed from: a */
    public static void m7302a(TileService tileService, Intent intent) {
        tileService.startActivityAndCollapse(intent);
    }
}
