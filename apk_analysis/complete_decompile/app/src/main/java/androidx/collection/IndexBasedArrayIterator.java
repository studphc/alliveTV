package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0003H$¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H$¢\u0006\u0004\b\u000b\u0010\u0006J\u0010\u0010\r\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5569d2 = {"Landroidx/collection/IndexBasedArrayIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "startingSize", "<init>", "(I)V", FirebaseAnalytics.Param.INDEX, "elementAt", "(I)Ljava/lang/Object;", "", "removeAt", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "remove", "()V", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nIndexBasedArrayIterator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IndexBasedArrayIterator.kt\nandroidx/collection/IndexBasedArrayIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
/* loaded from: classes.dex */
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, KMutableIterator {

    /* renamed from: a */
    public int f1669a;

    /* renamed from: b */
    public int f1670b;

    /* renamed from: c */
    public boolean f1671c;

    public IndexBasedArrayIterator(int i) {
        this.f1669a = i;
    }

    public abstract T elementAt(int index);

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f1670b < this.f1669a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            T elementAt = elementAt(this.f1670b);
            this.f1670b++;
            this.f1671c = true;
            return elementAt;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.f1671c) {
            int i = this.f1670b - 1;
            this.f1670b = i;
            removeAt(i);
            this.f1669a--;
            this.f1671c = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }

    public abstract void removeAt(int index);
}
