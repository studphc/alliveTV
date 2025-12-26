package p000;

import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModel;
import androidx.loader.app.LoaderManagerImpl$LoaderInfo;

/* loaded from: classes.dex */
public class za1 extends ViewModel {

    /* renamed from: f */
    public static final ya1 f29297f = new Object();

    /* renamed from: d */
    public final SparseArrayCompat f29298d = new SparseArrayCompat();

    /* renamed from: e */
    public boolean f29299e = false;

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        SparseArrayCompat sparseArrayCompat = this.f29298d;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            ((LoaderManagerImpl$LoaderInfo) sparseArrayCompat.valueAt(i)).m1543d(true);
        }
        sparseArrayCompat.clear();
    }
}
