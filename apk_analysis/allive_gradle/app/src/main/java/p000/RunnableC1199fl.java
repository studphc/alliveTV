package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0088b;
import androidx.core.util.Pair;
import androidx.media.C0428e;
import androidx.media.C0431h;
import androidx.media.MediaBrowserServiceCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzbh;
import com.google.android.gms.measurement.internal.zzpv;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimeout;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;

/* renamed from: fl */
/* loaded from: classes.dex */
public final class RunnableC1199fl implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17307a;

    /* renamed from: b */
    public final Object f17308b;

    /* renamed from: c */
    public final Object f17309c;

    /* renamed from: d */
    public final Object f17310d;

    /* renamed from: e */
    public final /* synthetic */ Object f17311e;

    public /* synthetic */ RunnableC1199fl(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f17307a = i;
        this.f17311e = obj;
        this.f17308b = obj2;
        this.f17309c = obj3;
        this.f17310d = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17307a) {
            case 0:
                C1236gl c1236gl = (C1236gl) this.f17308b;
                if (c1236gl != null) {
                    b01 b01Var = (b01) this.f17311e;
                    ((ViewOnKeyListenerC0088b) b01Var.f7833b).f963A = true;
                    c1236gl.f17747b.close(false);
                    ((ViewOnKeyListenerC0088b) b01Var.f7833b).f963A = false;
                }
                MenuItem menuItem = (MenuItem) this.f17309c;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    ((MenuBuilder) this.f17310d).performItemAction(menuItem, 4);
                    return;
                }
                return;
            case 1:
                if (((AtomicBoolean) this.f17308b).compareAndSet(false, true)) {
                    ((CompositeDisposable) this.f17309c).clear();
                    CompletableTimeout completableTimeout = (CompletableTimeout) this.f17311e;
                    CompletableSource completableSource = completableTimeout.f18711e;
                    if (completableSource == null) {
                        ((CompletableObserver) this.f17310d).onError(new TimeoutException(ExceptionHelper.timeoutMessage(completableTimeout.f18708b, completableTimeout.f18709c)));
                        return;
                    } else {
                        completableSource.subscribe(new C1207ft(this));
                        return;
                    }
                }
                return;
            case 2:
                IBinder binder = ((al1) this.f17308b).f255a.getBinder();
                b01 b01Var2 = (b01) this.f17311e;
                C0431h c0431h = (C0431h) ((MediaBrowserServiceCompat) b01Var2.f7833b).f6662d.get(binder);
                String str = (String) this.f17309c;
                if (c0431h == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) b01Var2.f7833b;
                mediaBrowserServiceCompat.getClass();
                HashMap hashMap = c0431h.f6705g;
                IBinder iBinder = (IBinder) this.f17310d;
                boolean z = false;
                try {
                    if (iBinder == null) {
                        if (hashMap.remove(str) != null) {
                            z = true;
                        }
                    } else {
                        List list = (List) hashMap.get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (iBinder == ((Pair) it.next()).first) {
                                    it.remove();
                                    z = true;
                                }
                            }
                            if (list.size() == 0) {
                                hashMap.remove(str);
                            }
                        }
                    }
                    if (!z) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                        return;
                    }
                    return;
                } finally {
                    mediaBrowserServiceCompat.f6663e = c0431h;
                    mediaBrowserServiceCompat.onUnsubscribe(str);
                    mediaBrowserServiceCompat.f6663e = null;
                }
            case 3:
                IBinder binder2 = ((al1) this.f17308b).f255a.getBinder();
                b01 b01Var3 = (b01) this.f17311e;
                C0431h c0431h2 = (C0431h) ((MediaBrowserServiceCompat) b01Var3.f7833b).f6662d.get(binder2);
                String str2 = (String) this.f17309c;
                if (c0431h2 == null) {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str2);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = (MediaBrowserServiceCompat) b01Var3.f7833b;
                mediaBrowserServiceCompat2.getClass();
                C0428e c0428e = new C0428e(str2, (ResultReceiver) this.f17310d);
                mediaBrowserServiceCompat2.f6663e = c0431h2;
                mediaBrowserServiceCompat2.onLoadItem(str2, c0428e);
                mediaBrowserServiceCompat2.f6663e = null;
                if (c0428e.m1551a()) {
                    return;
                } else {
                    throw new IllegalStateException(AbstractC1726qj.m7038C("onLoadItem must call detach() or sendResult() before returning for id=", str2));
                }
            case 4:
                ((AppMeasurementDynamiteService) this.f17311e).f13971a.zzu().zzN((zzcy) this.f17308b, (zzbh) this.f17309c, (String) this.f17310d);
                return;
            case 5:
                ((AppMeasurementDynamiteService) this.f17311e).f13971a.zzu().zzF((zzcy) this.f17308b, (String) this.f17309c, (String) this.f17310d);
                return;
            default:
                zzpv zzpvVar = (zzpv) ((ai2) this.f17311e).f216b;
                zzpvVar.m3650j((zzbh) Preconditions.checkNotNull(zzpvVar.zzB().m3723b((String) this.f17309c, (Bundle) this.f17310d, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, zzpvVar.zzaU().currentTimeMillis(), false)), (String) this.f17308b);
                return;
        }
    }
}
