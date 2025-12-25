package p000;

import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class v63 extends LifecycleCallback {

    /* renamed from: a */
    public ArrayList f27662a;

    public v63(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f27662a = new ArrayList();
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = this.f27662a;
            this.f27662a = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
