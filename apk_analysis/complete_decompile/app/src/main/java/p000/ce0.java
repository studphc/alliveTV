package p000;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.firebase.FirebaseApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ce0 implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a */
    public static final AtomicReference f8345a = new AtomicReference();

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        synchronized (FirebaseApp.f15451k) {
            try {
                Iterator it = new ArrayList(FirebaseApp.f15452l.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.f15457e.get()) {
                        firebaseApp.m4366d(z);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
