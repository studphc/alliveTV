package p000;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.DoNotInline;

/* renamed from: j7 */
/* loaded from: classes.dex */
public abstract class AbstractC1344j7 {
    @DoNotInline
    /* renamed from: a */
    public static AlarmManager.AlarmClockInfo m5405a(long j, PendingIntent pendingIntent) {
        return new AlarmManager.AlarmClockInfo(j, pendingIntent);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5406b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
        alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
    }
}
