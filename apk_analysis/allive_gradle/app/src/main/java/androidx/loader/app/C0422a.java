package androidx.loader.app;

import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

/* renamed from: androidx.loader.app.a */
/* loaded from: classes.dex */
public final class C0422a implements Observer {

    /* renamed from: a */
    public final Loader f6606a;

    /* renamed from: b */
    public final LoaderManager.LoaderCallbacks f6607b;

    /* renamed from: c */
    public boolean f6608c = false;

    public C0422a(Loader loader, LoaderManager.LoaderCallbacks loaderCallbacks) {
        this.f6606a = loader;
        this.f6607b = loaderCallbacks;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        boolean z = C0423b.f6609c;
        Loader loader = this.f6606a;
        if (z) {
            Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.dataToString(obj));
        }
        this.f6607b.onLoadFinished(loader, obj);
        this.f6608c = true;
    }

    public final String toString() {
        return this.f6607b.toString();
    }
}
