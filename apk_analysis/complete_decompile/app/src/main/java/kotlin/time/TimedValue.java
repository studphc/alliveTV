package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\tR\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006 "}, m5569d2 = {"Lkotlin/time/TimedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "Lkotlin/time/Duration;", TypedValues.TransitionType.S_DURATION, "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1", "()Ljava/lang/Object;", "component2-UwyO8pc", "()J", "component2", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Object;", "getValue", "b", "J", "getDuration-UwyO8pc", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalTime
/* loaded from: classes2.dex */
public final /* data */ class TimedValue<T> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Object value;

    /* renamed from: b, reason: from kotlin metadata */
    public final long duration;

    public TimedValue(Object obj, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this.value = obj;
        this.duration = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default, reason: not valid java name */
    public static /* synthetic */ TimedValue m8845copyRFiDyg4$default(TimedValue timedValue, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i & 2) != 0) {
            j = timedValue.duration;
        }
        return timedValue.m8847copyRFiDyg4(obj, j);
    }

    public final T component1() {
        return (T) this.value;
    }

    /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: copy-RFiDyg4, reason: not valid java name */
    public final TimedValue<T> m8847copyRFiDyg4(T value, long duration) {
        return new TimedValue<>(value, duration, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) other;
        return Intrinsics.areEqual(this.value, timedValue.value) && Duration.m8724equalsimpl0(this.duration, timedValue.duration);
    }

    /* renamed from: getDuration-UwyO8pc, reason: not valid java name */
    public final long m8848getDurationUwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return (T) this.value;
    }

    public int hashCode() {
        Object obj = this.value;
        return Duration.m8744hashCodeimpl(this.duration) + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + ((Object) Duration.m8763toStringimpl(this.duration)) + ')';
    }
}
