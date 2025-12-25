package kotlin.sequences;

import com.hisona.allive.CardPresenter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m5569d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n*L\n1#1,680:1\n*E\n"})
/* loaded from: classes2.dex */
public final class SequencesKt__SequencesKt$Sequence$1 implements Sequence<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function0 f21290a;

    public SequencesKt__SequencesKt$Sequence$1(Function0<? extends Iterator<Object>> function0) {
        this.f21290a = function0;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<Object> iterator() {
        return (Iterator) this.f21290a.invoke();
    }
}
