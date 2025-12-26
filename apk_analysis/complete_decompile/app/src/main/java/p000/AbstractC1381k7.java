package p000;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.DoNotInline;

/* renamed from: k7 */
/* loaded from: classes.dex */
public abstract class AbstractC1381k7 {
    @DoNotInline
    /* renamed from: a */
    public static void m5503a(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        alarmManager.setAndAllowWhileIdle(i, j, pendingIntent);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5504b(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
    }
}
