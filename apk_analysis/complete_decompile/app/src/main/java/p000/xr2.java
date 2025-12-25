package p000;

import com.google.common.base.Function;
import com.google.common.collect.C0865e3;
import java.util.Map;

/* loaded from: classes.dex */
public final class xr2 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f28718a;

    /* renamed from: b */
    public final /* synthetic */ C0865e3 f28719b;

    public /* synthetic */ xr2(C0865e3 c0865e3, int i) {
        this.f28718a = i;
        this.f28719b = c0865e3;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f28718a) {
            case 0:
                return new pr2((Map) obj, this.f28719b.f25273b);
            default:
                return new pr2((Map) obj, this.f28719b.f25273b);
        }
    }
}
