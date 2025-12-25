package p000;

import android.location.LocationManager;
import androidx.core.location.C0184d;
import androidx.core.location.LocationManagerCompat;
import com.google.common.util.concurrent.C0994g;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

/* renamed from: rk */
/* loaded from: classes2.dex */
public final /* synthetic */ class CallableC1764rk implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f25997a;

    /* renamed from: b */
    public final /* synthetic */ Object f25998b;

    /* renamed from: c */
    public final /* synthetic */ Object f25999c;

    public /* synthetic */ CallableC1764rk(int i, Object obj, Object obj2) {
        this.f25997a = i;
        this.f25998b = obj;
        this.f25999c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object obj = this.f25999c;
        Object obj2 = this.f25998b;
        switch (this.f25997a) {
            case 0:
                Callable callable = (Callable) obj;
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                boolean m4319b = Callables.m4319b((String) ((C0994g) obj2).get(), currentThread);
                try {
                    return callable.call();
                } finally {
                    if (m4319b) {
                        Callables.m4319b(name, currentThread);
                    }
                }
            default:
                Class cls = LocationManagerCompat.f3677a;
                return Boolean.valueOf(((LocationManager) obj2).addGpsStatusListener((C0184d) obj));
        }
    }
}
