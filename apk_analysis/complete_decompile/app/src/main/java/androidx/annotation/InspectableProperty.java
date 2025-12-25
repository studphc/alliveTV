package androidx.annotation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.METHOD})
@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017BH\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000fR\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u0010R\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0006\u001a\u0004\b\r\u0010\u0011R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0012R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0013R\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u0014¨\u0006\u0018"}, m5569d2 = {"Landroidx/annotation/InspectableProperty;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "attributeId", "", "hasAttributeId", "", "valueType", "Landroidx/annotation/InspectableProperty$ValueType;", "enumMapping", "", "Landroidx/annotation/InspectableProperty$EnumEntry;", "flagMapping", "Landroidx/annotation/InspectableProperty$FlagEntry;", "()I", "()[Landroidx/annotation/InspectableProperty$EnumEntry;", "()[Landroidx/annotation/InspectableProperty$FlagEntry;", "()Z", "()Ljava/lang/String;", "()Landroidx/annotation/InspectableProperty$ValueType;", "EnumEntry", "FlagEntry", "ValueType", "annotation"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
@Deprecated(message = "Replaced by the androidx.resourceinpsection package.")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes.dex */
public @interface InspectableProperty {

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, m5569d2 = {"Landroidx/annotation/InspectableProperty$EnumEntry;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "value", "", "()Ljava/lang/String;", "()I", "annotation"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes.dex */
    public @interface EnumEntry {
        String name();

        int value();
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u000f\u0010\u0006\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\bR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\t"}, m5569d2 = {"Landroidx/annotation/InspectableProperty$FlagEntry;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", TypedValues.AttributesType.S_TARGET, "", "mask", "()I", "()Ljava/lang/String;", "annotation"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes.dex */
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m5569d2 = {"Landroidx/annotation/InspectableProperty$ValueType;", "", "NONE", "INFERRED", "INT_ENUM", "INT_FLAG", "COLOR", "GRAVITY", "RESOURCE_ID", "annotation"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class ValueType {
        public static final ValueType COLOR;
        public static final ValueType GRAVITY;
        public static final ValueType INFERRED;
        public static final ValueType INT_ENUM;
        public static final ValueType INT_FLAG;
        public static final ValueType NONE;
        public static final ValueType RESOURCE_ID;

        /* renamed from: a */
        public static final /* synthetic */ ValueType[] f569a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r11v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r12v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r13v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r8v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        static {
            ?? r7 = new Enum("NONE", 0);
            NONE = r7;
            ?? r8 = new Enum("INFERRED", 1);
            INFERRED = r8;
            ?? r9 = new Enum("INT_ENUM", 2);
            INT_ENUM = r9;
            ?? r10 = new Enum("INT_FLAG", 3);
            INT_FLAG = r10;
            ?? r11 = new Enum("COLOR", 4);
            COLOR = r11;
            ?? r12 = new Enum("GRAVITY", 5);
            GRAVITY = r12;
            ?? r13 = new Enum("RESOURCE_ID", 6);
            RESOURCE_ID = r13;
            f569a = new ValueType[]{r7, r8, r9, r10, r11, r12, r13};
        }

        public static ValueType valueOf(String str) {
            return (ValueType) Enum.valueOf(ValueType.class, str);
        }

        public static ValueType[] values() {
            return (ValueType[]) f569a.clone();
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
