package p000;

import com.google.common.collect.MutableClassToInstanceMap;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public final class qq1 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Map f25728a;

    public qq1(Map map) {
        this.f25728a = map;
    }

    public Object readResolve() {
        return MutableClassToInstanceMap.create(this.f25728a);
    }
}
