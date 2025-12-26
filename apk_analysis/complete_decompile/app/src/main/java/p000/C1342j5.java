package p000;

import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: j5 */
/* loaded from: classes.dex */
public final class C1342j5 implements Lifecycle {

    /* renamed from: a */
    public final Set f20371a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    public boolean f20372b;

    /* renamed from: c */
    public boolean f20373c;

    @Override // com.bumptech.glide.manager.Lifecycle
    public final void addListener(LifecycleListener lifecycleListener) {
        this.f20371a.add(lifecycleListener);
        if (this.f20373c) {
            lifecycleListener.onDestroy();
        } else if (this.f20372b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public final void removeListener(LifecycleListener lifecycleListener) {
        this.f20371a.remove(lifecycleListener);
    }
}
