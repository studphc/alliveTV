package p000;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.text.DelimitedRangesSequence$iterator$1;

/* loaded from: classes2.dex */
public final class d20 implements Sequence {

    /* renamed from: a */
    public final CharSequence f16217a;

    /* renamed from: b */
    public final int f16218b;

    /* renamed from: c */
    public final int f16219c;

    /* renamed from: d */
    public final Lambda f16220d;

    /* JADX WARN: Multi-variable type inference failed */
    public d20(CharSequence input, int i, int i2, Function2 getNextMatch) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(getNextMatch, "getNextMatch");
        this.f16217a = input;
        this.f16218b = i;
        this.f16219c = i2;
        this.f16220d = (Lambda) getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
