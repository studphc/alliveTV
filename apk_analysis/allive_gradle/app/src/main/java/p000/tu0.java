package p000;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class tu0 extends dx0 {

    /* renamed from: j */
    public static HandlerThread f26959j;

    /* renamed from: k */
    public static Handler f26960k;

    /* renamed from: f */
    public final int f26961f;

    /* renamed from: g */
    public SparseIntArray[] f26962g;

    /* renamed from: h */
    public final ArrayList f26963h;

    /* renamed from: i */
    public final su0 f26964i;

    public tu0(int i) {
        super(16);
        this.f26962g = new SparseIntArray[9];
        this.f26963h = new ArrayList();
        this.f26964i = new su0(this);
        this.f26961f = i;
    }

    /* renamed from: o */
    public static void m7512o(SparseIntArray sparseIntArray, long j) {
        if (sparseIntArray != null) {
            int i = (int) ((500000 + j) / 1000000);
            if (j >= 0) {
                sparseIntArray.put(i, sparseIntArray.get(i) + 1);
            }
        }
    }

    @Override // p000.dx0
    /* renamed from: a */
    public final void mo4625a(Activity activity) {
        if (f26959j == null) {
            HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
            f26959j = handlerThread;
            handlerThread.start();
            f26960k = new Handler(f26959j.getLooper());
        }
        for (int i = 0; i <= 8; i++) {
            SparseIntArray[] sparseIntArrayArr = this.f26962g;
            if (sparseIntArrayArr[i] == null && (this.f26961f & (1 << i)) != 0) {
                sparseIntArrayArr[i] = new SparseIntArray();
            }
        }
        activity.getWindow().addOnFrameMetricsAvailableListener(this.f26964i, f26960k);
        this.f26963h.add(new WeakReference(activity));
    }

    @Override // p000.dx0
    /* renamed from: f */
    public final SparseIntArray[] mo4627f() {
        return this.f26962g;
    }

    @Override // p000.dx0
    /* renamed from: k */
    public final SparseIntArray[] mo4629k(Activity activity) {
        ArrayList arrayList = this.f26963h;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == activity) {
                arrayList.remove(weakReference);
                break;
            }
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(this.f26964i);
        return this.f26962g;
    }

    @Override // p000.dx0
    /* renamed from: l */
    public final SparseIntArray[] mo4630l() {
        SparseIntArray[] sparseIntArrayArr = this.f26962g;
        this.f26962g = new SparseIntArray[9];
        return sparseIntArrayArr;
    }

    @Override // p000.dx0
    /* renamed from: m */
    public final SparseIntArray[] mo4631m() {
        ArrayList arrayList = this.f26963h;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            WeakReference weakReference = (WeakReference) arrayList.get(size);
            Activity activity = (Activity) weakReference.get();
            if (weakReference.get() != null) {
                activity.getWindow().removeOnFrameMetricsAvailableListener(this.f26964i);
                arrayList.remove(size);
            }
        }
        return this.f26962g;
    }
}
