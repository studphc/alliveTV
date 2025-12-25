package p000;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class h12 extends AbstractC0541b1 {

    /* renamed from: c */
    public final Iterator f17920c;

    public h12(i12 i12Var) {
        this.f17920c = (Iterator) Preconditions.checkNotNull(i12Var.f18255b.iterator());
    }

    @Override // p000.AbstractC0541b1
    /* renamed from: a */
    public final Object mo2003a() {
        Optional optional;
        do {
            Iterator it = this.f17920c;
            if (it.hasNext()) {
                optional = (Optional) it.next();
            } else {
                this.f7846a = 3;
                return null;
            }
        } while (!optional.isPresent());
        return optional.get();
    }
}
