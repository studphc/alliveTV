package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.core.util.Pair;
import androidx.media.C0431h;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class xk1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28598a = 0;

    /* renamed from: b */
    public final /* synthetic */ Object f28599b;

    /* renamed from: c */
    public final /* synthetic */ Object f28600c;

    /* renamed from: d */
    public final /* synthetic */ Object f28601d;

    /* renamed from: e */
    public final /* synthetic */ Object f28602e;

    /* renamed from: f */
    public final /* synthetic */ Object f28603f;

    public xk1(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f28599b = atomicReference;
        this.f28600c = callable;
        this.f28601d = reentrantLock;
        this.f28602e = atomicBoolean;
        this.f28603f = condition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28598a) {
            case 0:
                IBinder binder = ((al1) this.f28599b).f255a.getBinder();
                b01 b01Var = (b01) this.f28603f;
                C0431h c0431h = (C0431h) ((MediaBrowserServiceCompat) b01Var.f7833b).f6662d.get(binder);
                String str = (String) this.f28600c;
                if (c0431h == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) b01Var.f7833b;
                mediaBrowserServiceCompat.getClass();
                HashMap hashMap = c0431h.f6705g;
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList();
                }
                Iterator it = list.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    IBinder iBinder = (IBinder) this.f28601d;
                    Bundle bundle = (Bundle) this.f28602e;
                    if (hasNext) {
                        Pair pair = (Pair) it.next();
                        if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle) pair.second)) {
                            return;
                        }
                    } else {
                        list.add(new Pair(iBinder, bundle));
                        hashMap.put(str, list);
                        mediaBrowserServiceCompat.m1550b(str, c0431h, bundle, null);
                        mediaBrowserServiceCompat.f6663e = c0431h;
                        mediaBrowserServiceCompat.onSubscribe(str, bundle);
                        mediaBrowserServiceCompat.f6663e = null;
                        return;
                    }
                }
                break;
            default:
                try {
                    ((AtomicReference) this.f28599b).set(((Callable) this.f28600c).call());
                } catch (Exception unused) {
                }
                ReentrantLock reentrantLock = (ReentrantLock) this.f28601d;
                reentrantLock.lock();
                try {
                    ((AtomicBoolean) this.f28602e).set(false);
                    ((Condition) this.f28603f).signal();
                    return;
                } finally {
                    reentrantLock.unlock();
                }
        }
    }

    public xk1(b01 b01Var, al1 al1Var, String str, IBinder iBinder, Bundle bundle) {
        this.f28603f = b01Var;
        this.f28599b = al1Var;
        this.f28600c = str;
        this.f28601d = iBinder;
        this.f28602e = bundle;
    }
}
