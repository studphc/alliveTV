package p000;

import com.bumptech.glide.load.data.DataRewinder;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* renamed from: qy */
/* loaded from: classes.dex */
public final class C1741qy implements DataRewinder, Predicate, ReadWriteProperty {

    /* renamed from: a */
    public Object f25798a;

    public /* synthetic */ C1741qy(Object obj) {
        this.f25798a = obj;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public Object getValue(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        Object obj2 = this.f25798a;
        if (obj2 != null) {
            return obj2;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public Object rewindAndGet() {
        return this.f25798a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty property, Object value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f25798a = value;
    }

    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Object obj) {
        return Objects.equals(obj, this.f25798a);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }
}
