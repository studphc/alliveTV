package kotlin.jvm.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1167eq;

@SinceKotlin(version = "1.4")
@Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\t\u0010#R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006)"}, m5569d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "", "container", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Lkotlin/reflect/KVariance;", "variance", "", "isReified", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "", "Lkotlin/reflect/KType;", "upperBounds", "", "setUpperBounds", "(Ljava/util/List;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "b", "Ljava/lang/String;", "getName", "c", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "d", "Z", "()Z", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
/* loaded from: classes2.dex */
public final class TypeParameterReference implements KTypeParameter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final Object f21189a;

    /* renamed from: b, reason: from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: from kotlin metadata */
    public final KVariance variance;

    /* renamed from: d, reason: from kotlin metadata */
    public final boolean isReified;

    /* renamed from: e */
    public volatile List f21193e;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "Lkotlin/reflect/KTypeParameter;", "typeParameter", "", "toString", "(Lkotlin/reflect/KTypeParameter;)Ljava/lang/String;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

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

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final String toString(@NotNull KTypeParameter typeParameter) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = WhenMappings.$EnumSwitchMapping$0[typeParameter.getVariance().ordinal()];
            if (i != 2) {
                if (i == 3) {
                    sb.append("out ");
                }
            } else {
                sb.append("in ");
            }
            sb.append(typeParameter.getName());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    public TypeParameterReference(@Nullable Object obj, @NotNull String name, @NotNull KVariance variance, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.f21189a = obj;
        this.name = name;
        this.variance = variance;
        this.isReified = z;
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) other;
            if (Intrinsics.areEqual(this.f21189a, typeParameterReference.f21189a) && Intrinsics.areEqual(getName(), typeParameterReference.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public List<KType> getUpperBounds() {
        List<KType> list = this.f21193e;
        if (list == null) {
            List<KType> listOf = AbstractC1167eq.listOf(Reflection.nullableTypeOf(Object.class));
            this.f21193e = listOf;
            return listOf;
        }
        return list;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        int i;
        Object obj = this.f21189a;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return getName().hashCode() + (i * 31);
    }

    @Override // kotlin.reflect.KTypeParameter
    /* renamed from: isReified, reason: from getter */
    public boolean getIsReified() {
        return this.isReified;
    }

    public final void setUpperBounds(@NotNull List<? extends KType> upperBounds) {
        Intrinsics.checkNotNullParameter(upperBounds, "upperBounds");
        if (this.f21193e == null) {
            this.f21193e = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @NotNull
    public String toString() {
        return INSTANCE.toString(this);
    }
}
