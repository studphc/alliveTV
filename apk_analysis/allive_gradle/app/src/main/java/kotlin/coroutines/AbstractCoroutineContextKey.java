package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B:\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0014\u001a\u00020\u00112\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m5569d2 = {"Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/CoroutineContext$Element;", "B", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "element", "safeCast", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "tryCast", "key", "", "isSubKey$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Key;)Z", "isSubKey", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalStdlibApi
/* loaded from: classes2.dex */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* renamed from: a */
    public final Function1 f21071a;

    /* renamed from: b */
    public final CoroutineContext.Key f21072b;

    public AbstractCoroutineContextKey(@NotNull CoroutineContext.Key<B> baseKey, @NotNull Function1<? super CoroutineContext.Element, ? extends E> safeCast) {
        Intrinsics.checkNotNullParameter(baseKey, "baseKey");
        Intrinsics.checkNotNullParameter(safeCast, "safeCast");
        this.f21071a = safeCast;
        this.f21072b = baseKey instanceof AbstractCoroutineContextKey ? ((AbstractCoroutineContextKey) baseKey).f21072b : baseKey;
    }

    public final boolean isSubKey$kotlin_stdlib(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key != this && this.f21072b != key) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    @Nullable
    public final CoroutineContext.Element tryCast$kotlin_stdlib(@NotNull CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return (CoroutineContext.Element) this.f21071a.invoke(element);
    }
}
