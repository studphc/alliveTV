package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SharedValues {
    public static final int UNSET = -1;

    /* renamed from: a */
    public final SparseIntArray f3208a = new SparseIntArray();

    /* renamed from: b */
    public final HashMap f3209b = new HashMap();

    /* loaded from: classes.dex */
    public interface SharedValuesListener {
        void onNewValue(int i, int i2, int i3);
    }

    public void addListener(int i, SharedValuesListener sharedValuesListener) {
        HashMap hashMap = this.f3209b;
        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet();
            hashMap.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void clearListeners() {
        this.f3209b.clear();
    }

    public void fireNewValue(int i, int i2) {
        SparseIntArray sparseIntArray = this.f3208a;
        int i3 = sparseIntArray.get(i, -1);
        if (i3 == i2) {
            return;
        }
        sparseIntArray.put(i, i2);
        HashSet hashSet = (HashSet) this.f3209b.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        Iterator it = hashSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            SharedValuesListener sharedValuesListener = (SharedValuesListener) ((WeakReference) it.next()).get();
            if (sharedValuesListener != null) {
                sharedValuesListener.onNewValue(i, i2, i3);
            } else {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference = (WeakReference) it2.next();
                if (((SharedValuesListener) weakReference.get()) == null) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public int getValue(int i) {
        return this.f3208a.get(i, -1);
    }

    public void removeListener(int i, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.f3209b.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        Iterator it = this.f3209b.keySet().iterator();
        while (it.hasNext()) {
            removeListener(((Integer) it.next()).intValue(), sharedValuesListener);
        }
    }
}
