package p000;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class v02 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f27613b;

    /* renamed from: c */
    public final /* synthetic */ OnBackPressedDispatcher f27614c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v02(OnBackPressedDispatcher onBackPressedDispatcher, int i) {
        super(0);
        this.f27613b = i;
        this.f27614c = onBackPressedDispatcher;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f27613b) {
            case 0:
                this.f27614c.onBackPressed();
                return Unit.INSTANCE;
            case 1:
                OnBackPressedDispatcher.access$onBackCancelled(this.f27614c);
                return Unit.INSTANCE;
            default:
                this.f27614c.onBackPressed();
                return Unit.INSTANCE;
        }
    }
}
