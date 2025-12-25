package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.C0431h;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class yk1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ al1 f29001a;

    /* renamed from: b */
    public final /* synthetic */ int f29002b;

    /* renamed from: c */
    public final /* synthetic */ String f29003c;

    /* renamed from: d */
    public final /* synthetic */ int f29004d;

    /* renamed from: e */
    public final /* synthetic */ Bundle f29005e;

    /* renamed from: f */
    public final /* synthetic */ b01 f29006f;

    public yk1(int i, int i2, b01 b01Var, al1 al1Var, Bundle bundle, String str) {
        this.f29006f = b01Var;
        this.f29001a = al1Var;
        this.f29002b = i;
        this.f29003c = str;
        this.f29004d = i2;
        this.f29005e = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0431h c0431h;
        al1 al1Var = this.f29001a;
        IBinder binder = al1Var.f255a.getBinder();
        b01 b01Var = this.f29006f;
        ((MediaBrowserServiceCompat) b01Var.f7833b).f6662d.remove(binder);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) b01Var.f7833b;
        Iterator it = mediaBrowserServiceCompat.f6661c.iterator();
        while (true) {
            c0431h = null;
            if (!it.hasNext()) {
                break;
            }
            C0431h c0431h2 = (C0431h) it.next();
            if (c0431h2.f6701c == this.f29002b) {
                if (TextUtils.isEmpty(this.f29003c) || this.f29004d <= 0) {
                    c0431h = new C0431h((MediaBrowserServiceCompat) b01Var.f7833b, c0431h2.f6699a, c0431h2.f6700b, c0431h2.f6701c, this.f29005e, al1Var);
                }
                it.remove();
            }
        }
        if (c0431h == null) {
            c0431h = new C0431h((MediaBrowserServiceCompat) b01Var.f7833b, this.f29003c, this.f29004d, this.f29002b, this.f29005e, al1Var);
        }
        mediaBrowserServiceCompat.f6662d.put(binder, c0431h);
        try {
            binder.linkToDeath(c0431h, 0);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}
