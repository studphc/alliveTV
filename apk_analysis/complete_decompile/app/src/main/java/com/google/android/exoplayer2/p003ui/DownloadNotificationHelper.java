package com.google.android.exoplayer2.p003ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.core.R;
import com.google.android.exoplayer2.offline.Download;
import java.util.List;

/* loaded from: classes.dex */
public final class DownloadNotificationHelper {

    /* renamed from: a */
    public final NotificationCompat.Builder f12054a;

    public DownloadNotificationHelper(Context context, String str) {
        this.f12054a = new NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    /* renamed from: a */
    public final Notification m2900a(Context context, int i, PendingIntent pendingIntent, String str, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        String string;
        NotificationCompat.Builder builder = this.f12054a;
        builder.setSmallIcon(i);
        NotificationCompat.BigTextStyle bigTextStyle = null;
        if (i2 == 0) {
            string = null;
        } else {
            string = context.getResources().getString(i2);
        }
        builder.setContentTitle(string);
        builder.setContentIntent(pendingIntent);
        if (str != null) {
            bigTextStyle = new NotificationCompat.BigTextStyle().bigText(str);
        }
        builder.setStyle(bigTextStyle);
        builder.setProgress(i3, i4, z);
        builder.setOngoing(z2);
        builder.setShowWhen(z3);
        return builder.build();
    }

    public Notification buildDownloadCompletedNotification(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return m2900a(context, i, pendingIntent, str, R.string.exo_download_completed, 0, 0, false, false, true);
    }

    public Notification buildDownloadFailedNotification(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return m2900a(context, i, pendingIntent, str, R.string.exo_download_failed, 0, 0, false, false, true);
    }

    @Deprecated
    public Notification buildProgressNotification(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, List<Download> list) {
        return buildProgressNotification(context, i, pendingIntent, str, list, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification buildProgressNotification(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, List<Download> list, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        float f = RecyclerView.f7068F0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = true;
        for (int i9 = 0; i9 < list.size(); i9++) {
            Download download = list.get(i9);
            int i10 = download.state;
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 5) {
                        z7 = true;
                    } else if (i10 != 7) {
                    }
                }
                float percentDownloaded = download.getPercentDownloaded();
                if (percentDownloaded != -1.0f) {
                    f += percentDownloaded;
                    z8 = false;
                }
                z6 |= download.getBytesDownloaded() > 0;
                i8++;
                z4 = true;
            } else {
                z5 = true;
            }
        }
        if (z4) {
            i4 = R.string.exo_download_downloading;
        } else {
            if (z5 && i2 != 0) {
                if ((i2 & 2) != 0) {
                    i5 = R.string.exo_download_paused_for_wifi;
                } else if ((i2 & 1) != 0) {
                    i5 = R.string.exo_download_paused_for_network;
                } else {
                    i5 = R.string.exo_download_paused;
                }
                i3 = i5;
                z = false;
                if (z) {
                }
                return m2900a(context, i, pendingIntent, str, i3, i6, i7, z2, true, false);
            }
            if (z7) {
                i4 = R.string.exo_download_removing;
            } else {
                i3 = 0;
                z = true;
                if (z) {
                    if (z4) {
                        int i11 = (int) (f / i8);
                        if (z8 && z6) {
                            z3 = true;
                        }
                        i7 = i11;
                        z2 = z3;
                    } else {
                        i7 = 0;
                        z2 = true;
                    }
                    i6 = 100;
                } else {
                    i6 = 0;
                    i7 = 0;
                    z2 = false;
                }
                return m2900a(context, i, pendingIntent, str, i3, i6, i7, z2, true, false);
            }
        }
        i3 = i4;
        z = true;
        if (z) {
        }
        return m2900a(context, i, pendingIntent, str, i3, i6, i7, z2, true, false);
    }
}
