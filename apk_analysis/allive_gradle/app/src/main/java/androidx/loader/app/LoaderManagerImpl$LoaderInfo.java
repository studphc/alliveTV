package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class LoaderManagerImpl$LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

    /* renamed from: l */
    public final int f6600l;

    /* renamed from: m */
    public final Bundle f6601m;

    /* renamed from: n */
    public final Loader f6602n;

    /* renamed from: o */
    public LifecycleOwner f6603o;

    /* renamed from: p */
    public C0422a f6604p;

    /* renamed from: q */
    public Loader f6605q;

    public LoaderManagerImpl$LoaderInfo(int i, Bundle bundle, Loader loader, Loader loader2) {
        this.f6600l = i;
        this.f6601m = bundle;
        this.f6602n = loader;
        this.f6605q = loader2;
        loader.registerListener(i, this);
    }

    /* renamed from: d */
    public final Loader m1543d(boolean z) {
        if (C0423b.f6609c) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        Loader loader = this.f6602n;
        loader.cancelLoad();
        loader.abandon();
        C0422a c0422a = this.f6604p;
        if (c0422a != null) {
            removeObserver(c0422a);
            if (z && c0422a.f6608c) {
                boolean z2 = C0423b.f6609c;
                Loader<D> loader2 = c0422a.f6606a;
                if (z2) {
                    Log.v("LoaderManager", "  Resetting: " + loader2);
                }
                c0422a.f6607b.onLoaderReset(loader2);
            }
        }
        loader.unregisterListener(this);
        if ((c0422a != null && !c0422a.f6608c) || z) {
            loader.reset();
            return this.f6605q;
        }
        return loader;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f6600l);
        printWriter.print(" mArgs=");
        printWriter.println(this.f6601m);
        printWriter.print(str);
        printWriter.print("mLoader=");
        Loader loader = this.f6602n;
        printWriter.println(loader);
        loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
        if (this.f6604p != null) {
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f6604p);
            C0422a c0422a = this.f6604p;
            c0422a.getClass();
            printWriter.print(str + "  ");
            printWriter.print("mDeliveredData=");
            printWriter.println(c0422a.f6608c);
        }
        printWriter.print(str);
        printWriter.print("mData=");
        printWriter.println(loader.dataToString(getValue()));
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.println(hasActiveObservers());
    }

    /* renamed from: e */
    public final void m1544e() {
        LifecycleOwner lifecycleOwner = this.f6603o;
        C0422a c0422a = this.f6604p;
        if (lifecycleOwner != null && c0422a != null) {
            super.removeObserver(c0422a);
            observe(lifecycleOwner, c0422a);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        if (C0423b.f6609c) {
            Log.v("LoaderManager", "  Starting: " + this);
        }
        this.f6602n.startLoading();
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        if (C0423b.f6609c) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f6602n.stopLoading();
    }

    @Override // androidx.loader.content.Loader.OnLoadCompleteListener
    public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
        if (C0423b.f6609c) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setValue(d);
            return;
        }
        if (C0423b.f6609c) {
            Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
        }
        postValue(d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NonNull Observer<? super D> observer) {
        super.removeObserver(observer);
        this.f6603o = null;
        this.f6604p = null;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(D d) {
        super.setValue(d);
        Loader loader = this.f6605q;
        if (loader != null) {
            loader.reset();
            this.f6605q = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.f6600l);
        sb.append(" : ");
        DebugUtils.buildShortClassTag(this.f6602n, sb);
        sb.append("}}");
        return sb.toString();
    }
}
