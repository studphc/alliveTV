package p000;

import java.io.Serializable;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesSerializationProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class q90 extends AbstractList implements EnumEntries, Serializable {

    /* renamed from: a */
    public final Function0 f25488a;

    /* renamed from: b */
    public volatile Enum[] f25489b;

    public q90(Function0 entriesProvider) {
        Intrinsics.checkNotNullParameter(entriesProvider, "entriesProvider");
        this.f25488a = entriesProvider;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(m7007a());
    }

    /* renamed from: a */
    public final Enum[] m7007a() {
        Enum[] enumArr = this.f25489b;
        if (enumArr != null) {
            return enumArr;
        }
        Enum[] enumArr2 = (Enum[]) this.f25488a.invoke();
        this.f25489b = enumArr2;
        return enumArr2;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        if (((Enum) ArraysKt___ArraysKt.getOrNull(m7007a(), element.ordinal())) != element) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i) {
        Enum[] m7007a = m7007a();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(i, m7007a.length);
        return m7007a[i];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public final int getF21007c() {
        return m7007a().length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        int ordinal = element.ordinal();
        if (((Enum) ArraysKt___ArraysKt.getOrNull(m7007a(), ordinal)) != element) {
            return -1;
        }
        return ordinal;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return indexOf(element);
    }
}
