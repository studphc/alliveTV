package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J%\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0082\u0001\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u00002Q\b\u0004\u0010\u000f\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0082\u0001\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u00002Q\b\u0004\u0010\u000f\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00120\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, m5569d2 = {"Lkotlin/properties/Delegates;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/properties/ReadWriteProperty;", "notNull", "()Lkotlin/properties/ReadWriteProperty;", "initialValue", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "property", "oldValue", "newValue", "", "onChange", "observable", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "", "vetoable", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Delegates {

    @NotNull
    public static final Delegates INSTANCE = new Object();

    @NotNull
    public final <T> ReadWriteProperty<Object, T> notNull() {
        return (ReadWriteProperty<Object, T>) new Object();
    }

    @NotNull
    public final <T> ReadWriteProperty<Object, T> observable(final T initialValue, @NotNull final Function3<? super KProperty<?>, ? super T, ? super T, Unit> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        return new ObservableProperty<T>(initialValue) { // from class: kotlin.properties.Delegates$observable$1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(@NotNull KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                onChange.invoke(property, oldValue, newValue);
            }
        };
    }

    @NotNull
    public final <T> ReadWriteProperty<Object, T> vetoable(final T initialValue, @NotNull final Function3<? super KProperty<?>, ? super T, ? super T, Boolean> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        return new ObservableProperty<T>(initialValue) { // from class: kotlin.properties.Delegates$vetoable$1
            @Override // kotlin.properties.ObservableProperty
            public boolean beforeChange(@NotNull KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                return ((Boolean) onChange.invoke(property, oldValue, newValue)).booleanValue();
            }
        };
    }
}
