package p000;

import com.google.android.gms.tasks.CancellationTokenSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class hs2 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f18162b;

    /* renamed from: c */
    public final /* synthetic */ CancellationTokenSource f18163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hs2(CancellationTokenSource cancellationTokenSource, int i) {
        super(1);
        this.f18162b = i;
        this.f18163c = cancellationTokenSource;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f18162b) {
            case 0:
                this.f18163c.cancel();
                return Unit.INSTANCE;
            default:
                this.f18163c.cancel();
                return Unit.INSTANCE;
        }
    }
}
