package p000;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Map;

/* loaded from: classes.dex */
public final class pg1 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ Predicate f25162a;

    public pg1(Predicate predicate) {
        this.f25162a = predicate;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f25162a.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
    }
}
