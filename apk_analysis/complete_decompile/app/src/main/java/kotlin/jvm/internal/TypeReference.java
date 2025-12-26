package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.C1891v;

@SinceKotlin(version = "1.4")
@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u001b\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R \u0010\t\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b)\u0010%\u001a\u0004\b(\u0010\u0014R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001fR\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010-¨\u0006/"}, m5569d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "classifier", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "platformTypeUpperBound", "", "flags", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "", "isMarkedNullable", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "b", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "c", "Lkotlin/reflect/KType;", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "d", "I", "getFlags$kotlin_stdlib", "getFlags$kotlin_stdlib$annotations", "", "getAnnotations", "annotations", "()Z", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TypeReference implements KType {
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;

    /* renamed from: a, reason: from kotlin metadata */
    public final KClassifier classifier;

    /* renamed from: b, reason: from kotlin metadata */
    public final List arguments;

    /* renamed from: c, reason: from kotlin metadata */
    public final KType platformTypeUpperBound;

    /* renamed from: d, reason: from kotlin metadata */
    public final int flags;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.f21247IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @SinceKotlin(version = "1.6")
    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, @Nullable KType kType, int i) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = kType;
        this.flags = i;
    }

    public static final String access$asString(TypeReference typeReference, KTypeProjection kTypeProjection) {
        TypeReference typeReference2;
        String valueOf;
        typeReference.getClass();
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        KType type = kTypeProjection.getType();
        if (type instanceof TypeReference) {
            typeReference2 = (TypeReference) type;
        } else {
            typeReference2 = null;
        }
        if (typeReference2 == null || (valueOf = typeReference2.m5626a(true)) == null) {
            valueOf = String.valueOf(kTypeProjection.getType());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[kTypeProjection.getVariance().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "out ".concat(valueOf);
                }
                throw new NoWhenBranchMatchedException();
            }
            return "in ".concat(valueOf);
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    /* renamed from: a */
    public final String m5626a(boolean z) {
        KClass kClass;
        String name;
        String joinToString$default;
        KClassifier classifier = getClassifier();
        Class cls = null;
        if (classifier instanceof KClass) {
            kClass = (KClass) classifier;
        } else {
            kClass = null;
        }
        if (kClass != null) {
            cls = JvmClassMappingKt.getJavaClass(kClass);
        }
        if (cls == null) {
            name = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (cls.isArray()) {
            if (Intrinsics.areEqual(cls, boolean[].class)) {
                name = "kotlin.BooleanArray";
            } else if (Intrinsics.areEqual(cls, char[].class)) {
                name = "kotlin.CharArray";
            } else if (Intrinsics.areEqual(cls, byte[].class)) {
                name = "kotlin.ByteArray";
            } else if (Intrinsics.areEqual(cls, short[].class)) {
                name = "kotlin.ShortArray";
            } else if (Intrinsics.areEqual(cls, int[].class)) {
                name = "kotlin.IntArray";
            } else if (Intrinsics.areEqual(cls, float[].class)) {
                name = "kotlin.FloatArray";
            } else if (Intrinsics.areEqual(cls, long[].class)) {
                name = "kotlin.LongArray";
            } else if (Intrinsics.areEqual(cls, double[].class)) {
                name = "kotlin.DoubleArray";
            } else {
                name = "kotlin.Array";
            }
        } else if (z && cls.isPrimitive()) {
            KClassifier classifier2 = getClassifier();
            Intrinsics.checkNotNull(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = JvmClassMappingKt.getJavaObjectType((KClass) classifier2).getName();
        } else {
            name = cls.getName();
        }
        String str = "";
        if (getArguments().isEmpty()) {
            joinToString$default = "";
        } else {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new C1891v(18, this), 24, null);
        }
        if (isMarkedNullable()) {
            str = "?";
        }
        String m7058n = AbstractC1726qj.m7058n(name, joinToString$default, str);
        KType kType = this.platformTypeUpperBound;
        if (kType instanceof TypeReference) {
            String m5626a = ((TypeReference) kType).m5626a(true);
            if (!Intrinsics.areEqual(m5626a, m7058n)) {
                if (Intrinsics.areEqual(m5626a, m7058n + '?')) {
                    return m7058n + '!';
                }
                return "(" + m7058n + ".." + m5626a + ')';
            }
            return m7058n;
        }
        return m7058n;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) other;
            if (Intrinsics.areEqual(getClassifier(), typeReference.getClassifier()) && Intrinsics.areEqual(getArguments(), typeReference.getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public KClassifier getClassifier() {
        return this.classifier;
    }

    /* renamed from: getFlags$kotlin_stdlib, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    @Nullable
    /* renamed from: getPlatformTypeUpperBound$kotlin_stdlib, reason: from getter */
    public final KType getPlatformTypeUpperBound() {
        return this.platformTypeUpperBound;
    }

    public int hashCode() {
        return ((getArguments().hashCode() + (getClassifier().hashCode() * 31)) * 31) + this.flags;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        if ((this.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return m5626a(false) + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, boolean z) {
        this(classifier, arguments, null, z ? 1 : 0);
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
    }
}
