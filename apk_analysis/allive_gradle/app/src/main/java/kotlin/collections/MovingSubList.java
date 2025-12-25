package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m5569d2 = {"Lkotlin/collections/MovingSubList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "list", "<init>", "(Ljava/util/List;)V", "", "fromIndex", "toIndex", "", "move", "(II)V", FirebaseAnalytics.Param.INDEX, "get", "(I)Ljava/lang/Object;", "getSize", "()I", "size", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a */
    public final List f21005a;

    /* renamed from: b */
    public int f21006b;

    /* renamed from: c */
    public int f21007c;

    public MovingSubList(@NotNull List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f21005a = list;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.f21007c);
        return (E) this.f21005a.get(this.f21006b + index);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize, reason: from getter */
    public int getF21007c() {
        return this.f21007c;
    }

    public final void move(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.f21005a.size());
        this.f21006b = fromIndex;
        this.f21007c = toIndex - fromIndex;
    }
}
