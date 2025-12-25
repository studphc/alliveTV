package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import p000.RunnableC0583c7;
import p000.f60;

/* loaded from: classes.dex */
public abstract class DownloadService extends Service {
    public static final String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    public static final String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final String KEY_FOREGROUND = "foreground";
    public static final String KEY_REQUIREMENTS = "requirements";
    public static final String KEY_STOP_REASON = "stop_reason";

    /* renamed from: k */
    public static final HashMap f10819k = new HashMap();

    /* renamed from: a */
    public final f60 f10820a;

    /* renamed from: b */
    public final String f10821b;

    /* renamed from: c */
    public final int f10822c;

    /* renamed from: d */
    public final int f10823d;

    /* renamed from: e */
    public C0682c f10824e;

    /* renamed from: f */
    public int f10825f;

    /* renamed from: g */
    public boolean f10826g;

    /* renamed from: h */
    public boolean f10827h;

    /* renamed from: i */
    public boolean f10828i;

    /* renamed from: j */
    public boolean f10829j;

    public DownloadService(int i) {
        this(i, 1000L);
    }

    /* renamed from: a */
    public static void m2711a(DownloadService downloadService, List list) {
        f60 f60Var = downloadService.f10820a;
        if (f60Var != null) {
            for (int i = 0; i < list.size(); i++) {
                if (m2713c(((Download) list.get(i)).state)) {
                    f60Var.f17142d = true;
                    f60Var.m4775a();
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public static Intent m2712b(Context context, Class cls, String str, boolean z) {
        return new Intent(context, (Class<?>) cls).setAction(str).putExtra(KEY_FOREGROUND, z);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return m2712b(context, cls, ACTION_PAUSE_DOWNLOADS, z);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return m2712b(context, cls, ACTION_REMOVE_ALL_DOWNLOADS, z);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return m2712b(context, cls, ACTION_REMOVE_DOWNLOAD, z).putExtra(KEY_CONTENT_ID, str);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return m2712b(context, cls, ACTION_RESUME_DOWNLOADS, z);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        return m2712b(context, cls, ACTION_SET_REQUIREMENTS, z).putExtra(KEY_REQUIREMENTS, requirements);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i, boolean z) {
        return m2712b(context, cls, ACTION_SET_STOP_REASON, z).putExtra(KEY_CONTENT_ID, str).putExtra(KEY_STOP_REASON, i);
    }

    /* renamed from: c */
    public static boolean m2713c(int i) {
        return i == 2 || i == 5 || i == 7;
    }

    /* renamed from: e */
    public static void m2714e(Context context, Intent intent, boolean z) {
        if (z) {
            Util.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        m2714e(context, buildAddDownloadIntent(context, cls, downloadRequest, z), z);
    }

    public static void sendPauseDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        m2714e(context, buildPauseDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveAllDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        m2714e(context, buildRemoveAllDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveDownload(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        m2714e(context, buildRemoveDownloadIntent(context, cls, str, z), z);
    }

    public static void sendResumeDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        m2714e(context, buildResumeDownloadsIntent(context, cls, z), z);
    }

    public static void sendSetRequirements(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        m2714e(context, buildSetRequirementsIntent(context, cls, requirements, z), z);
    }

    public static void sendSetStopReason(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i, boolean z) {
        m2714e(context, buildSetStopReasonIntent(context, cls, str, i, z), z);
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(new Intent(context, cls).setAction(ACTION_INIT));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, m2712b(context, cls, ACTION_INIT, true));
    }

    /* renamed from: d */
    public final void m2715d() {
        f60 f60Var = this.f10820a;
        if (f60Var != null) {
            f60Var.f17142d = false;
            f60Var.f17141c.removeCallbacksAndMessages(null);
        }
        if (!((C0682c) Assertions.checkNotNull(this.f10824e)).m2723c()) {
            return;
        }
        if (Util.SDK_INT < 28 && this.f10827h) {
            stopSelf();
            this.f10828i = true;
        } else {
            this.f10828i |= stopSelfResult(this.f10825f);
        }
    }

    public abstract DownloadManager getDownloadManager();

    public abstract Notification getForegroundNotification(List<Download> list, int i);

    @Nullable
    public abstract Scheduler getScheduler();

    public final void invalidateForegroundNotification() {
        f60 f60Var = this.f10820a;
        if (f60Var != null && !this.f10829j && f60Var.f17143e) {
            f60Var.m4775a();
        }
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        boolean z;
        boolean z2;
        Scheduler scheduler;
        String str = this.f10821b;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.f10822c, this.f10823d, 2);
        }
        Class<?> cls = getClass();
        HashMap hashMap = f10819k;
        C0682c c0682c = (C0682c) hashMap.get(cls);
        boolean z3 = false;
        if (c0682c == null) {
            if (this.f10820a != null) {
                z = true;
            } else {
                z = false;
            }
            if (Util.SDK_INT < 31) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                scheduler = getScheduler();
            } else {
                scheduler = null;
            }
            Scheduler scheduler2 = scheduler;
            DownloadManager downloadManager = getDownloadManager();
            downloadManager.resumeDownloads();
            c0682c = new C0682c(getApplicationContext(), downloadManager, z, scheduler2, cls);
            hashMap.put(cls, c0682c);
        }
        this.f10824e = c0682c;
        if (c0682c.f10874f == null) {
            z3 = true;
        }
        Assertions.checkState(z3);
        c0682c.f10874f = this;
        if (c0682c.f10870b.isInitialized()) {
            Util.createHandlerForCurrentOrMainLooper().postAtFrontOfQueue(new RunnableC0583c7(17, c0682c, this));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        boolean z = true;
        this.f10829j = true;
        C0682c c0682c = (C0682c) Assertions.checkNotNull(this.f10824e);
        if (c0682c.f10874f != this) {
            z = false;
        }
        Assertions.checkState(z);
        c0682c.f10874f = null;
        f60 f60Var = this.f10820a;
        if (f60Var != null) {
            f60Var.f17142d = false;
            f60Var.f17141c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        String str;
        String str2;
        f60 f60Var;
        boolean z;
        this.f10825f = i2;
        this.f10827h = false;
        if (intent != null) {
            str = intent.getAction();
            str2 = intent.getStringExtra(KEY_CONTENT_ID);
            boolean z2 = this.f10826g;
            if (!intent.getBooleanExtra(KEY_FOREGROUND, false) && !"com.google.android.exoplayer.downloadService.action.RESTART".equals(str)) {
                z = false;
            } else {
                z = true;
            }
            this.f10826g = z2 | z;
        } else {
            str = null;
            str2 = null;
        }
        if (str == null) {
            str = ACTION_INIT;
        }
        DownloadManager downloadManager = ((C0682c) Assertions.checkNotNull(this.f10824e)).f10870b;
        char c = 65535;
        switch (str.hashCode()) {
            case -1931239035:
                if (str.equals(ACTION_ADD_DOWNLOAD)) {
                    c = 0;
                    break;
                }
                break;
            case -932047176:
                if (str.equals(ACTION_RESUME_DOWNLOADS)) {
                    c = 1;
                    break;
                }
                break;
            case -871181424:
                if (str.equals("com.google.android.exoplayer.downloadService.action.RESTART")) {
                    c = 2;
                    break;
                }
                break;
            case -650547439:
                if (str.equals(ACTION_REMOVE_ALL_DOWNLOADS)) {
                    c = 3;
                    break;
                }
                break;
            case -119057172:
                if (str.equals(ACTION_SET_REQUIREMENTS)) {
                    c = 4;
                    break;
                }
                break;
            case 191112771:
                if (str.equals(ACTION_PAUSE_DOWNLOADS)) {
                    c = 5;
                    break;
                }
                break;
            case 671523141:
                if (str.equals(ACTION_SET_STOP_REASON)) {
                    c = 6;
                    break;
                }
                break;
            case 1015676687:
                if (str.equals(ACTION_INIT)) {
                    c = 7;
                    break;
                }
                break;
            case 1547520644:
                if (str.equals(ACTION_REMOVE_DOWNLOAD)) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) Assertions.checkNotNull(intent)).getParcelableExtra(KEY_DOWNLOAD_REQUEST);
                if (downloadRequest == null) {
                    Log.m3023e("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                } else {
                    downloadManager.addDownload(downloadRequest, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                }
            case 1:
                downloadManager.resumeDownloads();
                break;
            case 2:
            case 7:
                break;
            case 3:
                downloadManager.removeAllDownloads();
                break;
            case 4:
                Requirements requirements = (Requirements) ((Intent) Assertions.checkNotNull(intent)).getParcelableExtra(KEY_REQUIREMENTS);
                if (requirements == null) {
                    Log.m3023e("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                } else {
                    downloadManager.setRequirements(requirements);
                    break;
                }
            case 5:
                downloadManager.pauseDownloads();
                break;
            case 6:
                if (!((Intent) Assertions.checkNotNull(intent)).hasExtra(KEY_STOP_REASON)) {
                    Log.m3023e("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    downloadManager.setStopReason(str2, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                }
            case '\b':
                if (str2 == null) {
                    Log.m3023e("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                } else {
                    downloadManager.removeDownload(str2);
                    break;
                }
            default:
                Log.m3023e("DownloadService", "Ignored unrecognized action: ".concat(str));
                break;
        }
        if (Util.SDK_INT >= 26 && this.f10826g && (f60Var = this.f10820a) != null && !f60Var.f17143e) {
            f60Var.m4775a();
        }
        this.f10828i = false;
        if (downloadManager.isIdle()) {
            m2715d();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f10827h = true;
    }

    public DownloadService(int i, long j) {
        this(i, j, null, 0, 0);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i, boolean z) {
        return m2712b(context, cls, ACTION_ADD_DOWNLOAD, z).putExtra(KEY_DOWNLOAD_REQUEST, downloadRequest).putExtra(KEY_STOP_REASON, i);
    }

    @Deprecated
    public DownloadService(int i, long j, @Nullable String str, @StringRes int i2) {
        this(i, j, str, i2, 0);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i, boolean z) {
        m2714e(context, buildAddDownloadIntent(context, cls, downloadRequest, i, z), z);
    }

    public DownloadService(int i, long j, @Nullable String str, @StringRes int i2, @StringRes int i3) {
        if (i == 0) {
            this.f10820a = null;
            this.f10821b = null;
            this.f10822c = 0;
            this.f10823d = 0;
            return;
        }
        this.f10820a = new f60(this, i, j);
        this.f10821b = str;
        this.f10822c = i2;
        this.f10823d = i3;
    }
}
