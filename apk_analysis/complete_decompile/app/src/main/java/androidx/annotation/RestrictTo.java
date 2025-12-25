package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0007"}, m5569d2 = {"Landroidx/annotation/RestrictTo;", "", "value", "", "Landroidx/annotation/RestrictTo$Scope;", "()[Landroidx/annotation/RestrictTo$Scope;", "Scope", "annotation"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface RestrictTo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m5569d2 = {"Landroidx/annotation/RestrictTo$Scope;", "", "LIBRARY", "LIBRARY_GROUP", "LIBRARY_GROUP_PREFIX", "GROUP_ID", "TESTS", "SUBCLASSES", "annotation"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Scope {

        @Deprecated(message = "Use LIBRARY_GROUP_PREFIX instead.")
        public static final Scope GROUP_ID;
        public static final Scope LIBRARY;
        public static final Scope LIBRARY_GROUP;
        public static final Scope LIBRARY_GROUP_PREFIX;
        public static final Scope SUBCLASSES;
        public static final Scope TESTS;

        /* renamed from: a */
        public static final /* synthetic */ Scope[] f571a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        static {
            ?? r6 = new Enum("LIBRARY", 0);
            LIBRARY = r6;
            ?? r7 = new Enum("LIBRARY_GROUP", 1);
            LIBRARY_GROUP = r7;
            ?? r8 = new Enum("LIBRARY_GROUP_PREFIX", 2);
            LIBRARY_GROUP_PREFIX = r8;
            ?? r9 = new Enum("GROUP_ID", 3);
            GROUP_ID = r9;
            ?? r10 = new Enum("TESTS", 4);
            TESTS = r10;
            ?? r11 = new Enum("SUBCLASSES", 5);
            SUBCLASSES = r11;
            f571a = new Scope[]{r6, r7, r8, r9, r10, r11};
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) f571a.clone();
        }
    }

    Scope[] value();
}
