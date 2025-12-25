package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1204fq;
import p000.f32;
import p000.iy2;
import p000.l53;
import p000.nz2;
import p000.ro2;
import p000.rw0;

@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, m5569d2 = {"Lkotlin/reflect/KType;", "Ljava/lang/reflect/Type;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "javaType", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
/* loaded from: classes2.dex */
public final class TypesJVMKt {

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.f21247IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: a */
    public static final Type m5627a(KType kType, boolean z) {
        Class javaClass;
        int i;
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new iy2((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            if (z) {
                javaClass = JvmClassMappingKt.getJavaObjectType(kClass);
            } else {
                javaClass = JvmClassMappingKt.getJavaClass(kClass);
            }
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return javaClass;
            }
            if (javaClass.isArray()) {
                if (javaClass.getComponentType().isPrimitive()) {
                    return javaClass;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt___CollectionsKt.singleOrNull((List) arguments);
                if (kTypeProjection != null) {
                    KVariance variance = kTypeProjection.getVariance();
                    KType type = kTypeProjection.getType();
                    if (variance == null) {
                        i = -1;
                    } else {
                        i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
                    }
                    if (i != -1 && i != 1) {
                        if (i != 2 && i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Intrinsics.checkNotNull(type);
                        Type m5627a = m5627a(type, false);
                        if (!(m5627a instanceof Class)) {
                            return new rw0(m5627a);
                        }
                        return javaClass;
                    }
                    return javaClass;
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            return m5628b(javaClass, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    public static final String access$typeToString(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence generateSequence = SequencesKt__SequencesKt.generateSequence(type, nz2.f23548h);
                name = ((Class) SequencesKt___SequencesKt.last(generateSequence)).getName() + ro2.repeat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt___SequencesKt.count(generateSequence));
            } else {
                name = cls.getName();
            }
            Intrinsics.checkNotNullExpressionValue(name, "{\n        if (type.isArr…   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }

    /* renamed from: b */
    public static final f32 m5628b(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m5629c((KTypeProjection) it.next()));
            }
            return new f32(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(m5629c((KTypeProjection) it2.next()));
            }
            return new f32(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        f32 m5628b = m5628b(declaringClass, list.subList(length, list.size()));
        List subList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(subList, 10));
        Iterator it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(m5629c((KTypeProjection) it3.next()));
        }
        return new f32(cls, m5628b, arrayList3);
    }

    /* renamed from: c */
    public static final Type m5629c(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return l53.f22350c.getSTAR();
        }
        KType type = kTypeProjection.getType();
        Intrinsics.checkNotNull(type);
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new l53(m5627a(type, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return m5627a(type, true);
        }
        return new l53(null, m5627a(type, true));
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType kType) {
        Type javaType;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        if ((kType instanceof KTypeBase) && (javaType = ((KTypeBase) kType).getJavaType()) != null) {
            return javaType;
        }
        return m5627a(kType, false);
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }
}
