package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.C0429f;
import androidx.media.C0430g;
import androidx.media.C0431h;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
public final class zk1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f29407a;

    /* renamed from: b */
    public final /* synthetic */ al1 f29408b;

    /* renamed from: c */
    public final /* synthetic */ String f29409c;

    /* renamed from: d */
    public final /* synthetic */ Bundle f29410d;

    /* renamed from: e */
    public final /* synthetic */ ResultReceiver f29411e;

    /* renamed from: f */
    public final /* synthetic */ b01 f29412f;

    public /* synthetic */ zk1(b01 b01Var, al1 al1Var, String str, Bundle bundle, ResultReceiver resultReceiver, int i) {
        this.f29407a = i;
        this.f29412f = b01Var;
        this.f29408b = al1Var;
        this.f29409c = str;
        this.f29410d = bundle;
        this.f29411e = resultReceiver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f29407a) {
            case 0:
                IBinder binder = this.f29408b.f255a.getBinder();
                b01 b01Var = this.f29412f;
                C0431h c0431h = (C0431h) ((MediaBrowserServiceCompat) b01Var.f7833b).f6662d.get(binder);
                String str = this.f29409c;
                if (c0431h == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) b01Var.f7833b;
                mediaBrowserServiceCompat.getClass();
                C0429f c0429f = new C0429f(str, this.f29411e);
                mediaBrowserServiceCompat.f6663e = c0431h;
                mediaBrowserServiceCompat.onSearch(str, this.f29410d, c0429f);
                mediaBrowserServiceCompat.f6663e = null;
                if (c0429f.m1551a()) {
                    return;
                } else {
                    throw new IllegalStateException(AbstractC1726qj.m7038C("onSearch must call detach() or sendResult() before returning for query=", str));
                }
            default:
                IBinder binder2 = this.f29408b.f255a.getBinder();
                b01 b01Var2 = this.f29412f;
                C0431h c0431h2 = (C0431h) ((MediaBrowserServiceCompat) b01Var2.f7833b).f6662d.get(binder2);
                Bundle bundle = this.f29410d;
                String str2 = this.f29409c;
                if (c0431h2 == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = (MediaBrowserServiceCompat) b01Var2.f7833b;
                mediaBrowserServiceCompat2.getClass();
                C0430g c0430g = new C0430g(str2, this.f29411e);
                mediaBrowserServiceCompat2.f6663e = c0431h2;
                mediaBrowserServiceCompat2.onCustomAction(str2, bundle, c0430g);
                mediaBrowserServiceCompat2.f6663e = null;
                if (c0430g.m1551a()) {
                    return;
                }
                throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str2 + " extras=" + bundle);
        }
    }
}
