package p000;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class cf3 extends LifecycleCallback {

    /* renamed from: a */
    public final ArrayList f8353a;

    public cf3(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f8353a = new ArrayList();
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    /* renamed from: a */
    public static cf3 m2231a(Activity activity) {
        cf3 cf3Var;
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        synchronized (fragment) {
            try {
                cf3Var = (cf3) fragment.getCallbackOrNull("TaskOnStopCallback", cf3.class);
                if (cf3Var == null) {
                    cf3Var = new cf3(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cf3Var;
    }

    /* renamed from: b */
    public final void m2232b(xe3 xe3Var) {
        synchronized (this.f8353a) {
            this.f8353a.add(new WeakReference(xe3Var));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        synchronized (this.f8353a) {
            try {
                Iterator it = this.f8353a.iterator();
                while (it.hasNext()) {
                    xe3 xe3Var = (xe3) ((WeakReference) it.next()).get();
                    if (xe3Var != null) {
                        xe3Var.zzc();
                    }
                }
                this.f8353a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
