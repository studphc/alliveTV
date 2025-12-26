package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m5569d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,70:1\n2475#2:71\n*E\n"})
/* loaded from: classes2.dex */
public final class StringsKt___StringsKt$asIterable$$inlined$Iterable$1 implements Iterable<Character>, KMappedMarker {

    /* renamed from: a */
    public final /* synthetic */ CharSequence f21363a;

    public StringsKt___StringsKt$asIterable$$inlined$Iterable$1(CharSequence charSequence) {
        this.f21363a = charSequence;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Character> iterator() {
        return StringsKt__StringsKt.iterator(this.f21363a);
    }
}
