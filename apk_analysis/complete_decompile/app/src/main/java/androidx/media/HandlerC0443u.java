package androidx.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.BundleCompat;
import p000.RunnableC1199fl;
import p000.al1;
import p000.b01;
import p000.wk1;
import p000.xk1;
import p000.yk1;
import p000.zk1;

/* renamed from: androidx.media.u */
/* loaded from: classes.dex */
public final class HandlerC0443u extends Handler {

    /* renamed from: a */
    public final b01 f6731a;

    public HandlerC0443u(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f6731a = new b01(24, mediaBrowserServiceCompat);
    }

    /* renamed from: a */
    public final void m1564a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Bundle data = message.getData();
        int i = message.what;
        b01 b01Var = this.f6731a;
        switch (i) {
            case 1:
                Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                MediaSessionCompat.ensureClassLoader(bundle);
                String string = data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME);
                int i2 = data.getInt(MediaBrowserProtocol.DATA_CALLING_PID);
                int i3 = data.getInt(MediaBrowserProtocol.DATA_CALLING_UID);
                al1 al1Var = new al1(message.replyTo);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) b01Var.f7833b;
                if (string != null) {
                    for (String str : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i3)) {
                        if (str.equals(string)) {
                            mediaBrowserServiceCompat.f6664f.m1564a(new RunnableC0442t(i2, i3, b01Var, al1Var, bundle, string));
                            return;
                        }
                    }
                } else {
                    mediaBrowserServiceCompat.getClass();
                }
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + string);
            case 2:
                ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new wk1(b01Var, new al1(message.replyTo), 0));
                return;
            case 3:
                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new xk1(b01Var, new al1(message.replyTo), data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2));
                return;
            case 4:
                ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new RunnableC1199fl(2, b01Var, new al1(message.replyTo), data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN)));
                return;
            case 5:
                String string2 = data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
                ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER);
                al1 al1Var2 = new al1(message.replyTo);
                b01Var.getClass();
                if (!TextUtils.isEmpty(string2) && resultReceiver != null) {
                    ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new RunnableC1199fl(3, b01Var, al1Var2, string2, resultReceiver));
                    return;
                }
                return;
            case 6:
                Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                MediaSessionCompat.ensureClassLoader(bundle3);
                ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new yk1(data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), b01Var, new al1(message.replyTo), bundle3, data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME)));
                return;
            case 7:
                ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new wk1(b01Var, new al1(message.replyTo), 1));
                return;
            case 8:
                Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle4);
                String string3 = data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY);
                ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER);
                al1 al1Var3 = new al1(message.replyTo);
                b01Var.getClass();
                if (!TextUtils.isEmpty(string3) && resultReceiver2 != null) {
                    ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new zk1(b01Var, al1Var3, string3, bundle4, resultReceiver2, 0));
                    return;
                }
                return;
            case 9:
                Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle5);
                String string4 = data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION);
                ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER);
                al1 al1Var4 = new al1(message.replyTo);
                b01Var.getClass();
                if (!TextUtils.isEmpty(string4) && resultReceiver3 != null) {
                    ((MediaBrowserServiceCompat) b01Var.f7833b).f6664f.m1564a(new zk1(b01Var, al1Var4, string4, bundle5, resultReceiver3, 1));
                    return;
                }
                return;
            default:
                Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                return;
        }
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message message, long j) {
        Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
        int callingPid = Binder.getCallingPid();
        if (callingPid > 0) {
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, callingPid);
        } else if (!data.containsKey(MediaBrowserProtocol.DATA_CALLING_PID)) {
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, -1);
        }
        return super.sendMessageAtTime(message, j);
    }
}
