package p000;

import androidx.lifecycle.MediatorLiveData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class ov2 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ MediatorLiveData f24927b;

    /* renamed from: c */
    public final /* synthetic */ Ref.BooleanRef f24928c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ov2(MediatorLiveData mediatorLiveData, Ref.BooleanRef booleanRef) {
        super(1);
        this.f24927b = mediatorLiveData;
        this.f24928c = booleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MediatorLiveData mediatorLiveData = this.f24927b;
        T value = mediatorLiveData.getValue();
        Ref.BooleanRef booleanRef = this.f24928c;
        if (booleanRef.element || ((value == 0 && obj != null) || (value != 0 && !Intrinsics.areEqual(value, obj)))) {
            booleanRef.element = false;
            mediatorLiveData.setValue(obj);
        }
        return Unit.INSTANCE;
    }
}
