package p000;

import java.nio.file.Path;
import kotlin.io.path.CopyActionContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class u32 extends Lambda implements Function3 {

    /* renamed from: b */
    public final /* synthetic */ boolean f27083b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u32(boolean z) {
        super(3);
        this.f27083b = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        CopyActionContext copyActionContext = (CopyActionContext) obj;
        Path src = r32.m7202n(obj2);
        Path dst = r32.m7202n(obj3);
        Intrinsics.checkNotNullParameter(copyActionContext, "$this$null");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return copyActionContext.copyToIgnoringExistingDirectory(src, dst, this.f27083b);
    }
}
