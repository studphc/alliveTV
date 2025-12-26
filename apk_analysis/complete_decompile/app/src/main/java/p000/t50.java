package p000;

import com.google.android.exoplayer2.offline.DownloadCursor;

/* loaded from: classes.dex */
public abstract /* synthetic */ class t50 {
    /* renamed from: a */
    public static boolean m7450a(DownloadCursor downloadCursor) {
        if (downloadCursor.getCount() == 0 || downloadCursor.getPosition() == downloadCursor.getCount()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m7451b(DownloadCursor downloadCursor) {
        if (downloadCursor.getCount() == 0 || downloadCursor.getPosition() == -1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m7452c(DownloadCursor downloadCursor) {
        if (downloadCursor.getPosition() == 0 && downloadCursor.getCount() != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m7453d(DownloadCursor downloadCursor) {
        int count = downloadCursor.getCount();
        if (downloadCursor.getPosition() == count - 1 && count != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m7454e(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(0);
    }

    /* renamed from: f */
    public static boolean m7455f(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getCount() - 1);
    }

    /* renamed from: g */
    public static boolean m7456g(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() + 1);
    }

    /* renamed from: h */
    public static boolean m7457h(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() - 1);
    }
}
