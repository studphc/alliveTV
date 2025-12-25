package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.AbstractC1726qj;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, m5569d2 = {"Lkotlin/collections/AbstractIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "computeNext", "value", "setNext", "(Ljava/lang/Object;)V", "done", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a */
    public int f20953a = 2;

    /* renamed from: b */
    public Object f20954b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AbstractC1726qj.m7044I(4).length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract void computeNext();

    public final void done() {
        this.f20953a = 3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.f20953a;
        if (i != 4) {
            int m7041F = AbstractC1726qj.m7041F(i);
            if (m7041F == 0) {
                return true;
            }
            if (m7041F != 2) {
                this.f20953a = 4;
                computeNext();
                if (this.f20953a == 1) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f20953a = 2;
            return (T) this.f20954b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNext(T value) {
        this.f20954b = value;
        this.f20953a = 1;
    }
}
