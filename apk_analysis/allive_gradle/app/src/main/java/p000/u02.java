package p000;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class u02 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f27057b;

    /* renamed from: c */
    public final /* synthetic */ OnBackPressedDispatcher f27058c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u02(OnBackPressedDispatcher onBackPressedDispatcher, int i) {
        super(1);
        this.f27057b = i;
        this.f27058c = onBackPressedDispatcher;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f27057b) {
            case 0:
                BackEventCompat backEvent = (BackEventCompat) obj;
                Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                this.f27058c.m147c(backEvent);
                return Unit.INSTANCE;
            default:
                BackEventCompat backEvent2 = (BackEventCompat) obj;
                Intrinsics.checkNotNullParameter(backEvent2, "backEvent");
                this.f27058c.m146b(backEvent2);
                return Unit.INSTANCE;
        }
    }
}
