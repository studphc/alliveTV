package p000;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ga0 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f17622b;

    /* renamed from: c */
    public final /* synthetic */ Constructor f17623c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ga0(Constructor constructor, int i) {
        super(1);
        this.f17622b = i;
        this.f17623c = constructor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Constructor constructor = this.f17623c;
        switch (this.f17622b) {
            case 0:
                Throwable th = (Throwable) obj;
                Object newInstance = constructor.newInstance(th.getMessage(), th);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                return (Throwable) newInstance;
            case 1:
                Throwable th2 = (Throwable) obj;
                Object newInstance2 = constructor.newInstance(th2.getMessage());
                Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                Throwable th3 = (Throwable) newInstance2;
                th3.initCause(th2);
                return th3;
            case 2:
                Object newInstance3 = constructor.newInstance((Throwable) obj);
                Intrinsics.checkNotNull(newInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                return (Throwable) newInstance3;
            default:
                Object newInstance4 = constructor.newInstance(null);
                Intrinsics.checkNotNull(newInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                Throwable th4 = (Throwable) newInstance4;
                th4.initCause((Throwable) obj);
                return th4;
        }
    }
}
