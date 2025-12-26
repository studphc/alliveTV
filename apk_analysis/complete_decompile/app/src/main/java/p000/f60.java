package p000;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.offline.C0682c;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class f60 {

    /* renamed from: a */
    public final int f17139a;

    /* renamed from: b */
    public final long f17140b;

    /* renamed from: c */
    public final Handler f17141c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    public boolean f17142d;

    /* renamed from: e */
    public boolean f17143e;

    /* renamed from: f */
    public final /* synthetic */ DownloadService f17144f;

    public f60(DownloadService downloadService, int i, long j) {
        this.f17144f = downloadService;
        this.f17139a = i;
        this.f17140b = j;
    }

    /* renamed from: a */
    public final void m4775a() {
        DownloadService downloadService = this.f17144f;
        DownloadManager downloadManager = ((C0682c) Assertions.checkNotNull(downloadService.f10824e)).f10870b;
        Notification foregroundNotification = downloadService.getForegroundNotification(downloadManager.getCurrentDownloads(), downloadManager.getNotMetRequirements());
        boolean z = this.f17143e;
        int i = this.f17139a;
        if (!z) {
            downloadService.startForeground(i, foregroundNotification);
            this.f17143e = true;
        } else {
            ((NotificationManager) downloadService.getSystemService("notification")).notify(i, foregroundNotification);
        }
        if (this.f17142d) {
            Handler handler = this.f17141c;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new RunnableC0006a5(15, this), this.f17140b);
        }
    }
}
