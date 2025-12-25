package kotlin.coroutines.jvm.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.p63;
import p000.so1;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u0000H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "getStackTraceElementImpl", "", "", "getSpilledVariableFieldMapping", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
/* loaded from: classes2.dex */
public final class DebugMetadataKt {
    /* renamed from: a */
    public static final void m5608a(int i) {
        if (i <= 1) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + i + ". Please update the Kotlin standard library.").toString());
    }

    /* renamed from: b */
    public static final int m5609b(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            return i - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    @Nullable
    public static final String[] getSpilledVariableFieldMapping(@NotNull BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadata = (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
        if (debugMetadata == null) {
            return null;
        }
        m5608a(debugMetadata.m5607v());
        ArrayList arrayList = new ArrayList();
        int m5609b = m5609b(baseContinuationImpl);
        int[] m5602i = debugMetadata.m5602i();
        int length = m5602i.length;
        for (int i = 0; i < length; i++) {
            if (m5602i[i] == m5609b) {
                arrayList.add(debugMetadata.m5606s()[i]);
                arrayList.add(debugMetadata.m5605n()[i]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    public static final StackTraceElement getStackTraceElement(@NotNull BaseContinuationImpl continuation) {
        int i;
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        DebugMetadata debugMetadata = (DebugMetadata) continuation.getClass().getAnnotation(DebugMetadata.class);
        String str2 = null;
        if (debugMetadata == null) {
            return null;
        }
        m5608a(debugMetadata.m5607v());
        int m5609b = m5609b(continuation);
        if (m5609b < 0) {
            i = -1;
        } else {
            i = debugMetadata.m5603l()[m5609b];
        }
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        so1 so1Var = p63.f25048b;
        so1 so1Var2 = p63.f25047a;
        if (so1Var == null) {
            try {
                so1 so1Var3 = new so1(Class.class.getDeclaredMethod("getModule", null), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(AppMeasurementSdk.ConditionalUserProperty.NAME, null));
                p63.f25048b = so1Var3;
                so1Var = so1Var3;
            } catch (Exception unused) {
                p63.f25048b = so1Var2;
                so1Var = so1Var2;
            }
        }
        if (so1Var != so1Var2) {
            Method method = so1Var.f26506a;
            if (method != null) {
                obj = method.invoke(continuation.getClass(), null);
            } else {
                obj = null;
            }
            if (obj != null) {
                Method method2 = so1Var.f26507b;
                if (method2 != null) {
                    obj2 = method2.invoke(obj, null);
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    Method method3 = so1Var.f26508c;
                    if (method3 != null) {
                        obj3 = method3.invoke(obj2, null);
                    } else {
                        obj3 = null;
                    }
                    if (obj3 instanceof String) {
                        str2 = (String) obj3;
                    }
                }
            }
        }
        if (str2 == null) {
            str = debugMetadata.m5600c();
        } else {
            str = str2 + '/' + debugMetadata.m5600c();
        }
        return new StackTraceElement(str, debugMetadata.m5604m(), debugMetadata.m5601f(), i);
    }
}
