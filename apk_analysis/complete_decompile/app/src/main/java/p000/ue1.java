package p000;

import com.google.common.base.Preconditions;
import java.util.Map;

/* loaded from: classes2.dex */
public class ue1 {

    /* renamed from: a */
    public final Map f27239a;

    /* renamed from: b */
    public volatile transient Map.Entry f27240b;

    public ue1(Map map) {
        this.f27239a = (Map) Preconditions.checkNotNull(map);
    }

    /* renamed from: a */
    public void mo2093a() {
        this.f27240b = null;
    }

    /* renamed from: b */
    public final boolean m7702b(Object obj) {
        if (mo2095d(obj) == null && !this.f27239a.containsKey(obj)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public Object mo2094c(Object obj) {
        Preconditions.checkNotNull(obj);
        Object mo2095d = mo2095d(obj);
        if (mo2095d == null) {
            Preconditions.checkNotNull(obj);
            return this.f27239a.get(obj);
        }
        return mo2095d;
    }

    /* renamed from: d */
    public Object mo2095d(Object obj) {
        Map.Entry entry = this.f27240b;
        if (entry != null && entry.getKey() == obj) {
            return entry.getValue();
        }
        return null;
    }
}
