package androidx.core.view;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1327iq;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Landroidx/core/view/TreeIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "rootIterator", "Lkotlin/Function1;", "getChildIterator", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "core-ktx_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class TreeIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a */
    public final Function1 f3904a;

    /* renamed from: b */
    public final ArrayList f3905b = new ArrayList();

    /* renamed from: c */
    public Iterator f3906c;

    public TreeIterator(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, ? extends Iterator<? extends T>> function1) {
        this.f3904a = function1;
        this.f3906c = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3906c.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T t = (T) this.f3906c.next();
        Iterator it = (Iterator) this.f3904a.invoke(t);
        ArrayList arrayList = this.f3905b;
        if (it != null && it.hasNext()) {
            arrayList.add(this.f3906c);
            this.f3906c = it;
        } else {
            while (!this.f3906c.hasNext() && !arrayList.isEmpty()) {
                this.f3906c = (Iterator) CollectionsKt___CollectionsKt.last((List) arrayList);
                AbstractC1327iq.removeLast(arrayList);
            }
        }
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
