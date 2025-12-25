package com.hisona.allive;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* loaded from: classes2.dex */
public class RecommendationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().endsWith("android.intent.action.BOOT_COMPLETED")) {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setInexactRepeating(2, 5000L, 1800000L, PendingIntent.getService(context, 0, new Intent(context, (Class<?>) RecommendationsService.class), 0));
        }
    }
}
