package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AbstractC1022u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: wp */
/* loaded from: classes2.dex */
public final class C1954wp extends AbstractC1022u {

    /* renamed from: p */
    public List f28263p;

    public C1954wp(ImmutableList immutableList, boolean z) {
        super(immutableList, z, true);
        List newArrayListWithCapacity;
        if (immutableList.isEmpty()) {
            newArrayListWithCapacity = Collections.emptyList();
        } else {
            newArrayListWithCapacity = Lists.newArrayListWithCapacity(immutableList.size());
        }
        for (int i = 0; i < immutableList.size(); i++) {
            newArrayListWithCapacity.add(null);
        }
        this.f28263p = newArrayListWithCapacity;
        m4361n();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [xp, java.lang.Object] */
    @Override // com.google.common.util.concurrent.AbstractC1022u
    /* renamed from: j */
    public final void mo4357j(int i, Object obj) {
        List list = this.f28263p;
        if (list != null) {
            ?? obj2 = new Object();
            obj2.f28675a = obj;
            list.set(i, obj2);
        }
    }

    @Override // com.google.common.util.concurrent.AbstractC1022u
    /* renamed from: l */
    public final void mo4359l() {
        Object obj;
        List<C1991xp> list = this.f28263p;
        if (list != null) {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            for (C1991xp c1991xp : list) {
                if (c1991xp != null) {
                    obj = c1991xp.f28675a;
                } else {
                    obj = null;
                }
                newArrayListWithCapacity.add(obj);
            }
            set(Collections.unmodifiableList(newArrayListWithCapacity));
        }
    }

    @Override // com.google.common.util.concurrent.AbstractC1022u
    /* renamed from: o */
    public final void mo4362o(EnumC1222g7 enumC1222g7) {
        Preconditions.checkNotNull(enumC1222g7);
        this.f15430l = null;
        this.f28263p = null;
    }
}
