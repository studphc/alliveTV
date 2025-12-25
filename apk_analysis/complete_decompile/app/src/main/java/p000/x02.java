package p000;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes.dex */
public final /* synthetic */ class x02 extends FunctionReferenceImpl implements Function0 {

    /* renamed from: h */
    public final /* synthetic */ int f28416h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x02(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, obj, cls, str, str2, i2);
        this.f28416h = i3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f28416h) {
            case 0:
                ((OnBackPressedDispatcher) this.receiver).m149e();
                return Unit.INSTANCE;
            default:
                ((OnBackPressedDispatcher) this.receiver).m149e();
                return Unit.INSTANCE;
        }
    }
}
