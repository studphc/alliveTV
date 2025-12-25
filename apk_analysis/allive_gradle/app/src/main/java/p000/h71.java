package p000;

import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.internal.common.zzh;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class h71 {

    /* renamed from: a */
    public int f17964a;

    /* renamed from: b */
    public final Object f17965b;

    /* renamed from: c */
    public Object f17966c;

    public /* synthetic */ h71(Object obj, int i, Serializable serializable) {
        this.f17965b = obj;
        this.f17964a = i;
        this.f17966c = serializable;
    }

    /* renamed from: a */
    public void m5040a(int i, float[] fArr) {
        int i2;
        float[][] fArr2 = (float[][]) this.f17966c;
        float[] fArr3 = fArr2[i];
        int[] iArr = (int[]) this.f17965b;
        if (fArr3 != null) {
            fArr2[i] = null;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = this.f17964a;
                if (i3 >= i2) {
                    break;
                }
                if (i == iArr[i3]) {
                    iArr[i3] = 999;
                    i4++;
                }
                if (i3 != i4) {
                    iArr[i3] = iArr[i4];
                }
                i4++;
                i3++;
            }
            this.f17964a = i2 - 1;
        }
        fArr2[i] = fArr;
        int i5 = this.f17964a;
        this.f17964a = i5 + 1;
        iArr[i5] = i;
        Arrays.sort(iArr);
    }

    /* renamed from: b */
    public Object m5041b(int i) {
        SparseArray sparseArray;
        if (this.f17964a == -1) {
            this.f17964a = 0;
        }
        while (true) {
            int i2 = this.f17964a;
            sparseArray = (SparseArray) this.f17965b;
            if (i2 <= 0 || i >= sparseArray.keyAt(i2)) {
                break;
            }
            this.f17964a--;
        }
        while (this.f17964a < sparseArray.size() - 1 && i >= sparseArray.keyAt(this.f17964a + 1)) {
            this.f17964a++;
        }
        return sparseArray.valueAt(this.f17964a);
    }

    /* renamed from: c */
    public void m5042c(String str, LifecycleCallback lifecycleCallback) {
        Map map = (Map) this.f17965b;
        if (!map.containsKey(str)) {
            map.put(str, lifecycleCallback);
            if (this.f17964a > 0) {
                new zzh(Looper.getMainLooper()).post(new sk1(3, str, this, lifecycleCallback));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(ye0.m8296p("LifecycleCallback with tag ", str, " already added to this fragment."));
    }

    /* renamed from: d */
    public void m5043d(Bundle bundle) {
        Bundle bundle2;
        this.f17964a = 1;
        this.f17966c = bundle;
        for (Map.Entry entry : ((Map) this.f17965b).entrySet()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback) entry.getValue();
            if (bundle != null) {
                bundle2 = bundle.getBundle((String) entry.getKey());
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
    }

    /* renamed from: e */
    public void m5044e(Bundle bundle) {
        if (bundle != null) {
            for (Map.Entry entry : ((Map) this.f17965b).entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public h71(int i) {
        this.f17965b = new SparseArray(10);
        this.f17964a = i;
    }

    public h71(t82 t82Var) {
        this.f17965b = new SparseArray();
        this.f17966c = t82Var;
        this.f17964a = -1;
    }

    public h71(int i, boolean z) {
        switch (i) {
            case 5:
                this.f17965b = Collections.synchronizedMap(new ArrayMap());
                this.f17964a = 0;
                return;
            default:
                int[] iArr = new int[101];
                this.f17965b = iArr;
                float[][] fArr = new float[101];
                this.f17966c = fArr;
                Arrays.fill(iArr, 999);
                Arrays.fill(fArr, (Object) null);
                this.f17964a = 0;
                return;
        }
    }
}
