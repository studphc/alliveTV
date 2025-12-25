package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class up1 implements Supplier, Serializable {

    /* renamed from: a */
    public final /* synthetic */ int f27401a = 0;

    /* renamed from: b */
    public final Object f27402b;

    public up1(Comparator comparator) {
        this.f27402b = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f27401a) {
            case 0:
                return EnumSet.noneOf((Class) this.f27402b);
            default:
                return new TreeSet((Comparator) this.f27402b);
        }
    }

    public up1(Class cls) {
        this.f27402b = (Class) Preconditions.checkNotNull(cls);
    }
}
