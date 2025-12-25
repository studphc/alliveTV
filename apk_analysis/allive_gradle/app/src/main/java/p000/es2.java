package p000;

import com.google.common.base.Function;
import com.google.common.collect.C0880h3;
import com.google.common.collect.Maps;
import java.util.Map;

/* loaded from: classes.dex */
public final class es2 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f16972a;

    /* renamed from: b */
    public final /* synthetic */ C0880h3 f16973b;

    public /* synthetic */ es2(C0880h3 c0880h3, int i) {
        this.f16972a = i;
        this.f16973b = c0880h3;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f16972a) {
            case 0:
                return Maps.transformValues((Map) obj, this.f16973b.f14844d);
            default:
                return Maps.transformValues((Map) obj, this.f16973b.f14844d);
        }
    }
}
