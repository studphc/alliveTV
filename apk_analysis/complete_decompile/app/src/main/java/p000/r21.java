package p000;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class r21 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object[] f25839a;

    public r21(Object[] objArr) {
        this.f25839a = objArr;
    }

    public Object readResolve() {
        return ImmutableList.copyOf(this.f25839a);
    }
}
