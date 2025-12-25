package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Lkotlin/jvm/internal/IntSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "size", "<init>", "(I)V", "getSize", "([I)I", "value", "", "add", "toArray", "()[I", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class IntSpreadBuilder extends PrimitiveSpreadBuilder<int[]> {

    /* renamed from: d */
    public final int[] f21177d;

    public IntSpreadBuilder(int i) {
        super(i);
        this.f21177d = new int[i];
    }

    public final void add(int value) {
        int position = getPosition();
        setPosition(position + 1);
        this.f21177d[position] = value;
    }

    @NotNull
    public final int[] toArray() {
        return toArray(this.f21177d, new int[size()]);
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length;
    }
}
