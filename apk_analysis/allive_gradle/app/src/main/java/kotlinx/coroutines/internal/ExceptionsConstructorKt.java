package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1223g8;
import p000.C1645op;
import p000.C1891v;
import p000.ga0;
import p000.v43;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004*(\b\u0002\u0010\u0006\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00052\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005¨\u0006\u0007"}, m5569d2 = {"", ExifInterface.LONGITUDE_EAST, "exception", "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "Ctor", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
/* loaded from: classes2.dex */
public final class ExceptionsConstructorKt {

    /* renamed from: a */
    public static final int f22013a = m5727a(-1, Throwable.class);

    /* renamed from: b */
    public static final CtorCache f22014b;

    static {
        CtorCache ctorCache;
        try {
            if (FastServiceLoaderKt.getANDROID_DETECTED()) {
                ctorCache = v43.f27649a;
            } else {
                ctorCache = C1645op.f24849a;
            }
        } catch (Throwable unused) {
            ctorCache = v43.f27649a;
        }
        f22014b = ctorCache;
    }

    /* renamed from: a */
    public static final int m5727a(int i, Class cls) {
        Object m8512constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            int i2 = 0;
            do {
                int i3 = 0;
                for (Field field : cls.getDeclaredFields()) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        i3++;
                    }
                }
                i2 += i3;
                cls = cls.getSuperclass();
            } while (cls != null);
            m8512constructorimpl = Result.m8512constructorimpl(Integer.valueOf(i2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m8517isFailureimpl(m8512constructorimpl)) {
            m8512constructorimpl = valueOf;
        }
        return ((Number) m8512constructorimpl).intValue();
    }

    public static final Function1 access$createConstructor(Class cls) {
        Object obj;
        Function1 function1;
        Pair m5575to;
        int m5727a = m5727a(0, cls);
        int i = f22013a;
        C1223g8 c1223g8 = C1223g8.f17576e;
        if (i == m5727a) {
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.length);
            int length = constructors.length;
            int i2 = 0;
            while (true) {
                obj = null;
                if (i2 >= length) {
                    break;
                }
                Constructor<?> constructor = constructors[i2];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                int length2 = parameterTypes.length;
                if (length2 != 0) {
                    if (length2 != 1) {
                        if (length2 != 2) {
                            m5575to = TuplesKt.m5575to(null, -1);
                        } else if (Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                            m5575to = TuplesKt.m5575to(new C1891v(new ga0(constructor, 0)), 3);
                        } else {
                            m5575to = TuplesKt.m5575to(null, -1);
                        }
                    } else {
                        Class<?> cls2 = parameterTypes[0];
                        if (Intrinsics.areEqual(cls2, String.class)) {
                            m5575to = TuplesKt.m5575to(new C1891v(new ga0(constructor, 1)), 2);
                        } else if (Intrinsics.areEqual(cls2, Throwable.class)) {
                            m5575to = TuplesKt.m5575to(new C1891v(new ga0(constructor, 2)), 1);
                        } else {
                            m5575to = TuplesKt.m5575to(null, -1);
                        }
                    }
                } else {
                    m5575to = TuplesKt.m5575to(new C1891v(new ga0(constructor, 3)), 0);
                }
                arrayList.add(m5575to);
                i2++;
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                    do {
                        Object next = it.next();
                        int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                        if (intValue < intValue2) {
                            obj = next;
                            intValue = intValue2;
                        }
                    } while (it.hasNext());
                }
            }
            Pair pair = (Pair) obj;
            if (pair != null && (function1 = (Function1) pair.getFirst()) != null) {
                return function1;
            }
            return c1223g8;
        }
        return c1223g8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E extends Throwable> E tryCopyException(@NotNull E e) {
        Object m8512constructorimpl;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m8512constructorimpl = Result.m8512constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m8517isFailureimpl(m8512constructorimpl)) {
                m8512constructorimpl = null;
            }
            return (E) m8512constructorimpl;
        }
        return (E) f22014b.get(e.getClass()).invoke(e);
    }
}
