package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class vo2 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f27901b;

    /* renamed from: c */
    public final /* synthetic */ CharSequence f27902c;

    /* renamed from: d */
    public final /* synthetic */ Function1 f27903d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo2(CharSequence charSequence, int i, Function1 function1) {
        super(1);
        this.f27901b = i;
        this.f27902c = charSequence;
        this.f27903d = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int intValue = ((Number) obj).intValue();
        int i = this.f27901b + intValue;
        CharSequence charSequence = this.f27902c;
        if (i < 0 || i > charSequence.length()) {
            i = charSequence.length();
        }
        return this.f27903d.invoke(charSequence.subSequence(intValue, i));
    }
}
