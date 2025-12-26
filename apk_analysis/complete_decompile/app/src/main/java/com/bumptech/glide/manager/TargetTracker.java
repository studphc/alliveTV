package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: a */
    public final Set f8990a = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.f8990a.clear();
    }

    @NonNull
    public List<Target<?>> getAll() {
        return Util.getSnapshot(this.f8990a);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Iterator it = Util.getSnapshot(this.f8990a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Iterator it = Util.getSnapshot(this.f8990a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Iterator it = Util.getSnapshot(this.f8990a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStop();
        }
    }

    public void track(@NonNull Target<?> target) {
        this.f8990a.add(target);
    }

    public void untrack(@NonNull Target<?> target) {
        this.f8990a.remove(target);
    }
}
