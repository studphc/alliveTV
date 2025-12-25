package androidx.lifecycle;

import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class ViewModel {

    /* renamed from: a */
    public final HashMap f6563a;

    /* renamed from: b */
    public final LinkedHashSet f6564b;

    /* renamed from: c */
    public volatile boolean f6565c;

    public ViewModel() {
        this.f6563a = new HashMap();
        this.f6564b = new LinkedHashSet();
        this.f6565c = false;
    }

    /* renamed from: a */
    public static void m1537a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addCloseable(@NonNull Closeable closeable) {
        LinkedHashSet linkedHashSet = this.f6564b;
        if (linkedHashSet != null) {
            synchronized (linkedHashSet) {
                this.f6564b.add(closeable);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m1538b(SavedStateHandleController savedStateHandleController) {
        Object obj;
        synchronized (this.f6563a) {
            try {
                obj = this.f6563a.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == 0) {
                    this.f6563a.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != 0) {
            savedStateHandleController = obj;
        }
        if (this.f6565c) {
            m1537a(savedStateHandleController);
        }
    }

    public void onCleared() {
    }

    public ViewModel(@NonNull Closeable... closeableArr) {
        this.f6563a = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f6564b = linkedHashSet;
        this.f6565c = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }
}
