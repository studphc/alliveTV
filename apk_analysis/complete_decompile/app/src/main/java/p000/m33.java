package p000;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract /* synthetic */ class m33 {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.INSTANCE;
    }

    /* renamed from: a */
    public static ViewModel m6046a(ViewModelProvider.Factory factory, Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    /* renamed from: b */
    public static ViewModel m6047b(ViewModelProvider.Factory factory, Class modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return factory.create(modelClass);
    }

    /* renamed from: c */
    public static ViewModelProvider.Factory m6048c(ViewModelInitializer... viewModelInitializerArr) {
        return ViewModelProvider.Factory.INSTANCE.from(viewModelInitializerArr);
    }
}
