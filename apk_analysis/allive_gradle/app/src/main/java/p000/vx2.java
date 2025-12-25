package p000;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class vx2 extends wx2 {

    /* renamed from: c */
    public final /* synthetic */ TypeVariable f27988c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vx2(AtomicInteger atomicInteger, TypeVariable typeVariable) {
        super(atomicInteger);
        this.f27988c = typeVariable;
    }

    @Override // p000.wx2
    /* renamed from: b */
    public final TypeVariable mo7952b(Type[] typeArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
        linkedHashSet.addAll(Arrays.asList(this.f27988c.getBounds()));
        if (linkedHashSet.size() > 1) {
            linkedHashSet.remove(Object.class);
        }
        return super.mo7952b((Type[]) linkedHashSet.toArray(new Type[0]));
    }
}
