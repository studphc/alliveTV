package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class lo2 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f22600b;

    /* renamed from: c */
    public final /* synthetic */ String f22601c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lo2(String str, int i) {
        super(1);
        this.f22600b = i;
        this.f22601c = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f22600b) {
            case 0:
                String line = (String) obj;
                Intrinsics.checkNotNullParameter(line, "line");
                return AbstractC1726qj.m7061q(new StringBuilder(), this.f22601c, line);
            default:
                String it = (String) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                boolean isBlank = ro2.isBlank(it);
                String str = this.f22601c;
                if (isBlank) {
                    if (it.length() < str.length()) {
                        return str;
                    }
                    return it;
                }
                return AbstractC1726qj.m7057m(str, it);
        }
    }
}
