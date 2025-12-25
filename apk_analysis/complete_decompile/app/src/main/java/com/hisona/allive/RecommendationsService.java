package com.hisona.allive;

import android.app.NotificationManager;
import android.content.Intent;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class RecommendationsService extends RxJobIntentService {

    /* renamed from: j */
    public NotificationManager f15918j;

    @Override // com.hisona.allive.RxJobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f15918j == null) {
            this.f15918j = (NotificationManager) getSystemService("notification");
        }
    }

    @Override // com.hisona.allive.RxJobIntentService
    public void onHandleWork(@NonNull Intent intent) {
    }
}
