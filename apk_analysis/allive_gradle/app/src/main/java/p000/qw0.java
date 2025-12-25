package p000;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.GeneratorSequence$iterator$1;
import kotlin.sequences.Sequence;

/* loaded from: classes2.dex */
public final class qw0 implements Sequence {

    /* renamed from: a */
    public final Function0 f25781a;

    /* renamed from: b */
    public final Function1 f25782b;

    public qw0(Function0 getInitialValue, Function1 getNextValue) {
        Intrinsics.checkNotNullParameter(getInitialValue, "getInitialValue");
        Intrinsics.checkNotNullParameter(getNextValue, "getNextValue");
        this.f25781a = getInitialValue;
        this.f25782b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
