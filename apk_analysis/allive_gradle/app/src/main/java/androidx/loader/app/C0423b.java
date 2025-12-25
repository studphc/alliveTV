package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import p000.za1;

/* renamed from: androidx.loader.app.b */
/* loaded from: classes.dex */
public final class C0423b extends LoaderManager {

    /* renamed from: c */
    public static boolean f6609c = false;

    /* renamed from: a */
    public final LifecycleOwner f6610a;

    /* renamed from: b */
    public final za1 f6611b;

    public C0423b(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f6610a = lifecycleOwner;
        this.f6611b = (za1) new ViewModelProvider(viewModelStore, za1.f29297f).get(za1.class);
    }

    /* renamed from: a */
    public final Loader m1545a(int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks, Loader loader) {
        za1 za1Var = this.f6611b;
        try {
            za1Var.f29299e = true;
            Loader onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                }
                LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = new LoaderManagerImpl$LoaderInfo(i, bundle, onCreateLoader, loader);
                if (f6609c) {
                    Log.v("LoaderManager", "  Created new loader " + loaderManagerImpl$LoaderInfo);
                }
                za1Var.f29298d.put(i, loaderManagerImpl$LoaderInfo);
                za1Var.f29299e = false;
                Loader loader2 = loaderManagerImpl$LoaderInfo.f6602n;
                C0422a c0422a = new C0422a(loader2, loaderCallbacks);
                LifecycleOwner lifecycleOwner = this.f6610a;
                loaderManagerImpl$LoaderInfo.observe(lifecycleOwner, c0422a);
                C0422a c0422a2 = loaderManagerImpl$LoaderInfo.f6604p;
                if (c0422a2 != null) {
                    loaderManagerImpl$LoaderInfo.removeObserver(c0422a2);
                }
                loaderManagerImpl$LoaderInfo.f6603o = lifecycleOwner;
                loaderManagerImpl$LoaderInfo.f6604p = c0422a;
                return loader2;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            za1Var.f29299e = false;
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public final void destroyLoader(int i) {
        za1 za1Var = this.f6611b;
        if (!za1Var.f29299e) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f6609c) {
                    Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
                }
                LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo) za1Var.f29298d.get(i);
                if (loaderManagerImpl$LoaderInfo != null) {
                    loaderManagerImpl$LoaderInfo.m1543d(true);
                    za1Var.f29298d.remove(i);
                    return;
                }
                return;
            }
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        SparseArrayCompat sparseArrayCompat = this.f6611b.f29298d;
        if (sparseArrayCompat.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo) sparseArrayCompat.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(sparseArrayCompat.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderManagerImpl$LoaderInfo.toString());
                loaderManagerImpl$LoaderInfo.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public final Loader getLoader(int i) {
        za1 za1Var = this.f6611b;
        if (!za1Var.f29299e) {
            LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo) za1Var.f29298d.get(i);
            if (loaderManagerImpl$LoaderInfo != null) {
                return loaderManagerImpl$LoaderInfo.f6602n;
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public final boolean hasRunningLoaders() {
        C0422a c0422a;
        SparseArrayCompat sparseArrayCompat = this.f6611b.f29298d;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo) sparseArrayCompat.valueAt(i);
            if (loaderManagerImpl$LoaderInfo.hasActiveObservers() && (c0422a = loaderManagerImpl$LoaderInfo.f6604p) != null && !c0422a.f6608c) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.loader.app.LoaderManager
    public final Loader initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        za1 za1Var = this.f6611b;
        if (!za1Var.f29299e) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo) za1Var.f29298d.get(i);
                if (f6609c) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (loaderManagerImpl$LoaderInfo == null) {
                    return m1545a(i, bundle, loaderCallbacks, null);
                }
                if (f6609c) {
                    Log.v("LoaderManager", "  Re-using existing loader " + loaderManagerImpl$LoaderInfo);
                }
                Loader loader = loaderManagerImpl$LoaderInfo.f6602n;
                C0422a c0422a = new C0422a(loader, loaderCallbacks);
                LifecycleOwner lifecycleOwner = this.f6610a;
                loaderManagerImpl$LoaderInfo.observe(lifecycleOwner, c0422a);
                C0422a c0422a2 = loaderManagerImpl$LoaderInfo.f6604p;
                if (c0422a2 != null) {
                    loaderManagerImpl$LoaderInfo.removeObserver(c0422a2);
                }
                loaderManagerImpl$LoaderInfo.f6603o = lifecycleOwner;
                loaderManagerImpl$LoaderInfo.f6604p = c0422a;
                return loader;
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public final void markForRedelivery() {
        SparseArrayCompat sparseArrayCompat = this.f6611b.f29298d;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            ((LoaderManagerImpl$LoaderInfo) sparseArrayCompat.valueAt(i)).m1544e();
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public final Loader restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        Loader loader;
        za1 za1Var = this.f6611b;
        if (!za1Var.f29299e) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f6609c) {
                    Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
                }
                LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo) za1Var.f29298d.get(i);
                if (loaderManagerImpl$LoaderInfo != null) {
                    loader = loaderManagerImpl$LoaderInfo.m1543d(false);
                } else {
                    loader = null;
                }
                return m1545a(i, bundle, loaderCallbacks, loader);
            }
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.f6610a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
