package p000;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class w51 extends rv2 {

    /* renamed from: b */
    public final /* synthetic */ int f28070b;

    /* renamed from: c */
    public final /* synthetic */ Function f28071c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w51(Iterator it, Function function, int i) {
        super(it);
        this.f28070b = i;
        this.f28071c = function;
    }

    @Override // p000.rv2
    /* renamed from: a */
    public final Object mo4106a(Object obj) {
        switch (this.f28070b) {
            case 0:
                return this.f28071c.apply(obj);
            default:
                return Maps.immutableEntry(obj, this.f28071c.apply(obj));
        }
    }
}
