package p000;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.io.LinesSequence$iterator$1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes2.dex */
public final class n81 implements Sequence {

    /* renamed from: a */
    public final BufferedReader f23284a;

    public n81(BufferedReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.f23284a = reader;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
