package p000;

import java.nio.file.Path;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class s32 extends Lambda implements Function3 {

    /* renamed from: c */
    public static final s32 f26228c = new s32(3, 0);

    /* renamed from: d */
    public static final s32 f26229d = new s32(3, 1);

    /* renamed from: e */
    public static final s32 f26230e = new s32(3, 2);

    /* renamed from: b */
    public final /* synthetic */ int f26231b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s32(int i, int i2) {
        super(i);
        this.f26231b = i2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f26231b) {
            case 0:
                Path m7202n = r32.m7202n(obj);
                Path m7202n2 = r32.m7202n(obj2);
                Exception exception = (Exception) obj3;
                Intrinsics.checkNotNullParameter(m7202n, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(m7202n2, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(exception, "exception");
                throw exception;
            case 1:
                Path m7202n3 = r32.m7202n(obj);
                Path m7202n4 = r32.m7202n(obj2);
                Exception exception2 = (Exception) obj3;
                Intrinsics.checkNotNullParameter(m7202n3, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(m7202n4, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(exception2, "exception");
                throw exception2;
            default:
                return null;
        }
    }
}
