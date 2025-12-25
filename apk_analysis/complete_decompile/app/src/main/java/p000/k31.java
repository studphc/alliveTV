package p000;

import com.google.common.collect.ImmutableMultimap;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class k31 implements Serializable {

    /* renamed from: a */
    public final ImmutableMultimap f20742a;

    public k31(ImmutableMultimap immutableMultimap) {
        this.f20742a = immutableMultimap;
    }

    public Object readResolve() {
        return this.f20742a.keys();
    }
}
