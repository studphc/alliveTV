package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class d90 extends AbstractIterator {

    /* renamed from: c */
    public final InterfaceC1304if f16296c;

    /* renamed from: d */
    public final Iterator f16297d;

    /* renamed from: e */
    public Object f16298e = null;

    /* renamed from: f */
    public Iterator f16299f = ImmutableSet.m3971of().iterator();

    public d90(InterfaceC1304if interfaceC1304if) {
        this.f16296c = interfaceC1304if;
        this.f16297d = interfaceC1304if.nodes().iterator();
    }

    /* renamed from: a */
    public final boolean m4556a() {
        Preconditions.checkState(!this.f16299f.hasNext());
        Iterator it = this.f16297d;
        if (!it.hasNext()) {
            return false;
        }
        Object next = it.next();
        this.f16298e = next;
        this.f16299f = this.f16296c.successors(next).iterator();
        return true;
    }
}
