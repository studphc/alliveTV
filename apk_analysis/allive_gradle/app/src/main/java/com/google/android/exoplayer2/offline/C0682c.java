package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import p000.e60;
import p000.f60;

/* renamed from: com.google.android.exoplayer2.offline.c */
/* loaded from: classes.dex */
public final class C0682c implements DownloadManager.Listener {

    /* renamed from: a */
    public final Context f10869a;

    /* renamed from: b */
    public final DownloadManager f10870b;

    /* renamed from: c */
    public final boolean f10871c;

    /* renamed from: d */
    public final Scheduler f10872d;

    /* renamed from: e */
    public final Class f10873e;

    /* renamed from: f */
    public DownloadService f10874f;

    /* renamed from: g */
    public Requirements f10875g;

    public C0682c(Context context, DownloadManager downloadManager, boolean z, Scheduler scheduler, Class cls) {
        this.f10869a = context;
        this.f10870b = downloadManager;
        this.f10871c = z;
        this.f10872d = scheduler;
        this.f10873e = cls;
        downloadManager.addListener(this);
        m2723c();
    }

    /* renamed from: a */
    public final void m2721a() {
        Requirements requirements = new Requirements(0);
        if (!Util.areEqual(this.f10875g, requirements)) {
            this.f10872d.cancel();
            this.f10875g = requirements;
        }
    }

    /* renamed from: b */
    public final void m2722b() {
        Class cls = this.f10873e;
        boolean z = this.f10871c;
        Context context = this.f10869a;
        if (z) {
            try {
                String str = DownloadService.ACTION_INIT;
                Util.startForegroundService(context, new Intent(context, (Class<?>) cls).setAction("com.google.android.exoplayer.downloadService.action.RESTART"));
                return;
            } catch (IllegalStateException unused) {
                Log.m3027w("DownloadService", "Failed to restart (foreground launch restriction)");
                return;
            }
        }
        try {
            String str2 = DownloadService.ACTION_INIT;
            context.startService(new Intent(context, (Class<?>) cls).setAction(DownloadService.ACTION_INIT));
        } catch (IllegalStateException unused2) {
            Log.m3027w("DownloadService", "Failed to restart (process is idle)");
        }
    }

    /* renamed from: c */
    public final boolean m2723c() {
        DownloadManager downloadManager = this.f10870b;
        boolean isWaitingForRequirements = downloadManager.isWaitingForRequirements();
        Scheduler scheduler = this.f10872d;
        if (scheduler == null) {
            return !isWaitingForRequirements;
        }
        if (!isWaitingForRequirements) {
            m2721a();
            return true;
        }
        Requirements requirements = downloadManager.getRequirements();
        if (!scheduler.getSupportedRequirements(requirements).equals(requirements)) {
            m2721a();
            return false;
        }
        if (Util.areEqual(this.f10875g, requirements)) {
            return true;
        }
        if (scheduler.schedule(requirements, this.f10869a.getPackageName(), "com.google.android.exoplayer.downloadService.action.RESTART")) {
            this.f10875g = requirements;
            return true;
        }
        Log.m3027w("DownloadService", "Failed to schedule restart");
        m2721a();
        return false;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
        f60 f60Var;
        DownloadService downloadService = this.f10874f;
        if (downloadService != null && (f60Var = downloadService.f10820a) != null) {
            if (DownloadService.m2713c(download.state)) {
                f60Var.f17142d = true;
                f60Var.m4775a();
            } else if (f60Var.f17143e) {
                f60Var.m4775a();
            }
        }
        DownloadService downloadService2 = this.f10874f;
        if ((downloadService2 == null || downloadService2.f10828i) && DownloadService.m2713c(download.state)) {
            Log.m3027w("DownloadService", "DownloadService wasn't running. Restarting.");
            m2722b();
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final void onDownloadRemoved(DownloadManager downloadManager, Download download) {
        f60 f60Var;
        DownloadService downloadService = this.f10874f;
        if (downloadService != null && (f60Var = downloadService.f10820a) != null && f60Var.f17143e) {
            f60Var.m4775a();
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final /* synthetic */ void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z) {
        e60.m4663c(this, downloadManager, z);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final void onIdle(DownloadManager downloadManager) {
        DownloadService downloadService = this.f10874f;
        if (downloadService != null) {
            String str = DownloadService.ACTION_INIT;
            downloadService.m2715d();
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final void onInitialized(DownloadManager downloadManager) {
        DownloadService downloadService = this.f10874f;
        if (downloadService != null) {
            DownloadService.m2711a(downloadService, downloadManager.getCurrentDownloads());
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i) {
        m2723c();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public final void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z) {
        if (!z && !downloadManager.getDownloadsPaused()) {
            DownloadService downloadService = this.f10874f;
            if (downloadService == null || downloadService.f10828i) {
                List<Download> currentDownloads = downloadManager.getCurrentDownloads();
                for (int i = 0; i < currentDownloads.size(); i++) {
                    if (currentDownloads.get(i).state == 0) {
                        m2722b();
                        return;
                    }
                }
            }
        }
    }
}
