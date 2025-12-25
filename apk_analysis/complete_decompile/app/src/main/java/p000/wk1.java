package p000;

import android.os.IBinder;
import androidx.media.C0431h;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
public final class wk1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28213a;

    /* renamed from: b */
    public final /* synthetic */ al1 f28214b;

    /* renamed from: c */
    public final /* synthetic */ b01 f28215c;

    public /* synthetic */ wk1(b01 b01Var, al1 al1Var, int i) {
        this.f28213a = i;
        this.f28215c = b01Var;
        this.f28214b = al1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28213a) {
            case 0:
                C0431h c0431h = (C0431h) ((MediaBrowserServiceCompat) this.f28215c.f7833b).f6662d.remove(this.f28214b.f255a.getBinder());
                if (c0431h != null) {
                    c0431h.f6704f.f255a.getBinder().unlinkToDeath(c0431h, 0);
                    return;
                }
                return;
            default:
                IBinder binder = this.f28214b.f255a.getBinder();
                C0431h c0431h2 = (C0431h) ((MediaBrowserServiceCompat) this.f28215c.f7833b).f6662d.remove(binder);
                if (c0431h2 != null) {
                    binder.unlinkToDeath(c0431h2, 0);
                    return;
                }
                return;
        }
    }
}
