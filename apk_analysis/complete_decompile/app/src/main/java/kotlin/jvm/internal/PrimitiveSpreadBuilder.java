package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0004\u0010\rJ\u001f\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0006¨\u0006\u0017"}, m5569d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "size", "<init>", "(I)V", "getSize", "(Ljava/lang/Object;)I", "spreadArgument", "", "addSpread", "(Ljava/lang/Object;)V", "()I", "values", "result", "toArray", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "b", "I", "getPosition", "setPosition", "position", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class PrimitiveSpreadBuilder<T> {

    /* renamed from: a */
    public final int f21181a;

    /* renamed from: b, reason: from kotlin metadata */
    public int position;

    /* renamed from: c */
    public final Object[] f21183c;

    public PrimitiveSpreadBuilder(int i) {
        this.f21181a = i;
        this.f21183c = new Object[i];
    }

    public final void addSpread(@NotNull T spreadArgument) {
        Intrinsics.checkNotNullParameter(spreadArgument, "spreadArgument");
        int i = this.position;
        this.position = i + 1;
        this.f21183c[i] = spreadArgument;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(@NotNull T t);

    public final void setPosition(int i) {
        this.position = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public final int size() {
        int i;
        int i2 = 0;
        ?? it = new IntRange(0, this.f21181a - 1).iterator();
        while (it.hasNext()) {
            Object obj = this.f21183c[it.nextInt()];
            if (obj != null) {
                i = getSize(obj);
            } else {
                i = 1;
            }
            i2 += i;
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @NotNull
    public final T toArray(@NotNull T values, @NotNull T result) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(result, "result");
        int i = this.f21181a;
        ?? it = new IntRange(0, i - 1).iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            Object obj = this.f21183c[nextInt];
            if (obj != null) {
                if (i2 < nextInt) {
                    int i4 = nextInt - i2;
                    System.arraycopy(values, i2, result, i3, i4);
                    i3 += i4;
                }
                int size = getSize(obj);
                System.arraycopy(obj, 0, result, i3, size);
                i3 += size;
                i2 = nextInt + 1;
            }
        }
        if (i2 < i) {
            System.arraycopy(values, i2, result, i3, i - i2);
        }
        return result;
    }
}
