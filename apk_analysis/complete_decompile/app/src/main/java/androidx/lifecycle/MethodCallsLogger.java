package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"Landroidx/lifecycle/MethodCallsLogger;", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "type", "", "approveCall", "(Ljava/lang/String;I)Z", "lifecycle-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MethodCallsLogger {

    /* renamed from: a */
    public final HashMap f6518a = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(@NotNull String name, int type) {
        int i;
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap hashMap = this.f6518a;
        Integer num = (Integer) hashMap.get(name);
        boolean z = false;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if ((i & type) != 0) {
            z = true;
        }
        hashMap.put(name, Integer.valueOf(type | i));
        return !z;
    }
}
