package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.NonNull;
import p000.AbstractC1344j7;
import p000.AbstractC1381k7;
import p000.AbstractC1501l7;

/* loaded from: classes.dex */
public final class AlarmManagerCompat {
    public static boolean canScheduleExactAlarms(@NonNull AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC1501l7.m5865a(alarmManager);
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        AbstractC1344j7.m5406b(alarmManager, AbstractC1344j7.m5405a(j, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i, long j, @NonNull PendingIntent pendingIntent) {
        AbstractC1381k7.m5503a(alarmManager, i, j, pendingIntent);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i, long j, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i, j, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i, long j, @NonNull PendingIntent pendingIntent) {
        AbstractC1381k7.m5504b(alarmManager, i, j, pendingIntent);
    }
}
