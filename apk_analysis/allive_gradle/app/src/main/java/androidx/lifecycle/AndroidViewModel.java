package androidx.lifecycle;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Landroidx/lifecycle/AndroidViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;)V", ExifInterface.GPS_DIRECTION_TRUE, "getApplication", "()Landroid/app/Application;", "lifecycle-viewmodel_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {

    /* renamed from: d */
    public final Application f6468d;

    public AndroidViewModel(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f6468d = application;
    }

    @NotNull
    public <T extends Application> T getApplication() {
        T t = (T) this.f6468d;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t;
    }
}
