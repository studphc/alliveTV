package kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.7")
@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001b\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u0005\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0007\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t2\u0006\u0010\u0004\u001a\u00028\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\nJ&\u0010\f\u001a\u00020\u000b*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087\u0002¢\u0006\u0004\b\f\u0010\r\u0082\u0001\u0001\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m5569d2 = {"Lkotlin/DeepRecursiveScope;", ExifInterface.GPS_DIRECTION_TRUE, "R", "", "value", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", ExifInterface.LATITUDE_SOUTH, "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "invoke", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Void;", "Lhz;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@RestrictsSuspension
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: classes2.dex */
public abstract class DeepRecursiveScope<T, R> {
    public DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Nullable
    public abstract Object callRecursive(T t, @NotNull Continuation<? super R> continuation);

    @Nullable
    public abstract <U, S> Object callRecursive(@NotNull DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, @NotNull Continuation<? super S> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    @NotNull
    public final Void invoke(@NotNull DeepRecursiveFunction<?, ?> deepRecursiveFunction, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
