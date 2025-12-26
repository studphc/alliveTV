package p000;

import com.google.common.collect.ImmutableMultiset;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class m31 implements Serializable {

    /* renamed from: a */
    public final ImmutableMultiset f22783a;

    public m31(ImmutableMultiset immutableMultiset) {
        this.f22783a = immutableMultiset;
    }

    public Object readResolve() {
        return this.f22783a.entrySet();
    }
}
