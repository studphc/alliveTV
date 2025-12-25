package androidx.annotation;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.ANNOTATION_TYPE})
@Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, m5569d2 = {"Landroidx/annotation/RequiresOptIn;", "", FirebaseAnalytics.Param.LEVEL, "Landroidx/annotation/RequiresOptIn$Level;", "()Landroidx/annotation/RequiresOptIn$Level;", "Level", "annotation-experimental_release"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: classes.dex */
public @interface RequiresOptIn {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, m5569d2 = {"Landroidx/annotation/RequiresOptIn$Level;", "", "WARNING", "ERROR", "annotation-experimental_release"}, m5570k = 1, m5571mv = {1, 7, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Level {
        public static final Level ERROR;
        public static final Level WARNING;

        /* renamed from: a */
        public static final /* synthetic */ Level[] f570a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [androidx.annotation.RequiresOptIn$Level, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.annotation.RequiresOptIn$Level, java.lang.Enum] */
        static {
            ?? r2 = new Enum("WARNING", 0);
            WARNING = r2;
            ?? r3 = new Enum("ERROR", 1);
            ERROR = r3;
            f570a = new Level[]{r2, r3};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f570a.clone();
        }
    }

    Level level() default Level.ERROR;
}
