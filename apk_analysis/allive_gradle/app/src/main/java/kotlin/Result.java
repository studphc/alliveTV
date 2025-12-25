package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087@\u0018\u0000 \"*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\"#B\u0016\b\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b \u0010\u001e\u0088\u0001\u0005\u0092\u0001\u0004\u0018\u00010\u0004ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m5569d2 = {"Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "a", "Ljava/lang/Object;", "getValue$annotations", "()V", "isSuccess-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isFailure-impl", "isFailure", "Companion", "Failure", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final Object value;

    @Metadata(m5568d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m5569d2 = {"Lkotlin/Result$Companion;", "", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5569d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Failure implements Serializable {

        @JvmField
        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(@Nullable Object other) {
            if ((other instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) other).exception)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    public /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m8511boximpl(Object obj) {
        return new Result(obj);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m8512constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m8513equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).getValue());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8514equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m8515exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m8516hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m8517isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m8518isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m8519toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m8513equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m8516hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m8519toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Object getValue() {
        return this.value;
    }
}
