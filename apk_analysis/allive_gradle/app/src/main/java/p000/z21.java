package p000;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class z21 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final ImmutableMap f29227a;

    public z21(ImmutableMap immutableMap) {
        this.f29227a = immutableMap;
    }

    public Object readResolve() {
        return this.f29227a.entrySet();
    }
}
