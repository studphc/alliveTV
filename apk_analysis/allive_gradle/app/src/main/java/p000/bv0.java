package p000;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class bv0 extends LinkedHashMap {
    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        if (size() > 4) {
            return true;
        }
        return false;
    }
}
