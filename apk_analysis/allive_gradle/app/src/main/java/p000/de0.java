package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.FirebaseApp;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class de0 extends BroadcastReceiver {

    /* renamed from: b */
    public static final AtomicReference f16350b = new AtomicReference();

    /* renamed from: a */
    public final Context f16351a;

    public de0(Context context) {
        this.f16351a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (FirebaseApp.f15451k) {
            try {
                Iterator it = FirebaseApp.f15452l.values().iterator();
                while (it.hasNext()) {
                    ((FirebaseApp) it.next()).m4365c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f16351a.unregisterReceiver(this);
    }
}
