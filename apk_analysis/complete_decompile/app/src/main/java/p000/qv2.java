package p000;

import androidx.lifecycle.MediatorLiveData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class qv2 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f25777b;

    /* renamed from: c */
    public final /* synthetic */ MediatorLiveData f25778c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qv2(MediatorLiveData mediatorLiveData, int i) {
        super(1);
        this.f25777b = i;
        this.f25778c = mediatorLiveData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f25777b) {
            case 0:
                this.f25778c.setValue(obj);
                return Unit.INSTANCE;
            default:
                this.f25778c.setValue(obj);
                return Unit.INSTANCE;
        }
    }
}
