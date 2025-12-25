package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class KeyCache {

    /* renamed from: a */
    public final HashMap f2179a = new HashMap();

    public float getFloatValue(Object obj, String str, int i) {
        HashMap hashMap;
        float[] fArr;
        HashMap hashMap2 = this.f2179a;
        if (!hashMap2.containsKey(obj) || (hashMap = (HashMap) hashMap2.get(obj)) == null || !hashMap.containsKey(str) || (fArr = (float[]) hashMap.get(str)) == null || fArr.length <= i) {
            return Float.NaN;
        }
        return fArr[i];
    }

    public void setFloatValue(Object obj, String str, int i, float f) {
        HashMap hashMap = this.f2179a;
        if (!hashMap.containsKey(obj)) {
            HashMap hashMap2 = new HashMap();
            float[] fArr = new float[i + 1];
            fArr[i] = f;
            hashMap2.put(str, fArr);
            hashMap.put(obj, hashMap2);
            return;
        }
        HashMap hashMap3 = (HashMap) hashMap.get(obj);
        if (hashMap3 == null) {
            hashMap3 = new HashMap();
        }
        if (!hashMap3.containsKey(str)) {
            float[] fArr2 = new float[i + 1];
            fArr2[i] = f;
            hashMap3.put(str, fArr2);
            hashMap.put(obj, hashMap3);
            return;
        }
        float[] fArr3 = (float[]) hashMap3.get(str);
        if (fArr3 == null) {
            fArr3 = new float[0];
        }
        if (fArr3.length <= i) {
            fArr3 = Arrays.copyOf(fArr3, i + 1);
        }
        fArr3[i] = f;
        hashMap3.put(str, fArr3);
    }
}
