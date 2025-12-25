package com.hisona.allive;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public class FetchChannelService extends RxJobIntentService {
    public SiteProcessor j;

    public static void enqueueWork(Context context, Intent intent) {
        RxJobIntentService.enqueueWork(context, (Class<?>) FetchChannelService.class, 1000, intent);
    }

    public final String d(int i) {
        return getResources().getString(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00da, code lost:
    
        if (r14.j.updateProcess() == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0133  */
    @Override // com.hisona.allive.RxJobIntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onHandleWork(@androidx.annotation.NonNull android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisona.allive.FetchChannelService.onHandleWork(android.content.Intent):void");
    }
}
