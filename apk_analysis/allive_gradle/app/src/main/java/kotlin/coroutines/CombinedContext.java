package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0567br;
import p000.C1095cr;
import p000.C1952wn;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001#B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\f*\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"¨\u0006$"}, m5569d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "", "writeReplace", "()Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "br", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
/* loaded from: classes2.dex */
public final class CombinedContext implements CoroutineContext, Serializable {

    /* renamed from: a */
    public final CoroutineContext f21073a;

    /* renamed from: b */
    public final CoroutineContext.Element f21074b;

    public CombinedContext(@NotNull CoroutineContext left, @NotNull CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.f21073a = left;
        this.f21074b = element;
    }

    private final Object writeReplace() {
        int m5599a = m5599a();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[m5599a];
        Ref.IntRef intRef = new Ref.IntRef();
        fold(Unit.INSTANCE, new C1095cr(coroutineContextArr, intRef));
        if (intRef.element == m5599a) {
            return new C0567br(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    /* renamed from: a */
    public final int m5599a() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.f21073a;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                combinedContext = null;
            }
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(@Nullable Object other) {
        boolean z;
        if (this != other) {
            if (!(other instanceof CombinedContext)) {
                return false;
            }
            CombinedContext combinedContext = (CombinedContext) other;
            if (combinedContext.m5599a() != m5599a()) {
                return false;
            }
            CombinedContext combinedContext2 = this;
            while (true) {
                CoroutineContext.Element element = combinedContext2.f21074b;
                if (!Intrinsics.areEqual(combinedContext.get(element.getKey()), element)) {
                    z = false;
                    break;
                }
                CoroutineContext coroutineContext = combinedContext2.f21073a;
                if (coroutineContext instanceof CombinedContext) {
                    combinedContext2 = (CombinedContext) coroutineContext;
                } else {
                    Intrinsics.checkNotNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                    z = Intrinsics.areEqual(combinedContext.get(element2.getKey()), element2);
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke((Object) this.f21073a.fold(initial, operation), this.f21074b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.f21074b.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.f21073a;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.get(key);
            }
        }
    }

    public int hashCode() {
        return this.f21074b.hashCode() + this.f21073a.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CoroutineContext.Element element = this.f21074b;
        CoroutineContext.Element element2 = element.get(key);
        CoroutineContext coroutineContext = this.f21073a;
        if (element2 != null) {
            return coroutineContext;
        }
        CoroutineContext minusKey = coroutineContext.minusKey(key);
        if (minusKey == coroutineContext) {
            return this;
        }
        if (minusKey != EmptyCoroutineContext.INSTANCE) {
            return new CombinedContext(minusKey, element);
        }
        return element;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @NotNull
    public String toString() {
        return "[" + ((String) fold("", C1952wn.f28245d)) + ']';
    }
}
